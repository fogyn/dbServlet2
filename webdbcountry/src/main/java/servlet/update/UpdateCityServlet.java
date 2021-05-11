package servlet.update;

import basa.ConnectionUrl;
import model.City;
import model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/views/updateCitybyid")
public class UpdateCityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        String update = "";
        City city = new City();
        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("select * FROM 'city' WHERE idcity = ?;");){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                city.setIdCity(resultSet.getInt("idcity"));
                city.setIdCountry(resultSet.getInt("idcountry"));
                city.setNameCity(resultSet.getString("namecity"));
                city.setAbout(resultSet.getString("about"));

                req.setAttribute("updateidcity", true);
                req.setAttribute("citybyid", city);
            }
            else {
                update = "Такого id нет";
                //req.setAttribute("updateid", false);
                req.setAttribute("update", update);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/views/updateCountryCity.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String update = "";
        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE 'city' SET nameCity = ?, about = ? WHERE idcity = ?;");){
            req.setCharacterEncoding("UTF-8");
            String nameCity= req.getParameter("nameCity");
            System.out.println(nameCity);
            statement.setString(1, nameCity);
            String about = req.getParameter("about");
            statement.setString(2, about);
            System.out.println(about);

            int id = Integer.parseInt(req.getParameter("id"));
            statement.setInt(3,id);

            statement.execute();

            if(statement.executeUpdate()==1){
                System.out.println("Город отредактирован успешно");
                update = "Город отредактирована успешно.";
            }
            else{
                System.out.println("Нет такого номера");
                update = "Нет такого номера id";
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("update", update);

        getServletContext().getRequestDispatcher("/views/updateCountryCity.jsp").forward(req, resp);
    }
}
