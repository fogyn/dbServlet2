package servlet.update;

import basa.ConnectionUrl;
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


@WebServlet("/views/updateCountrybyid")
public class UpdateCountryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        String update = "";
        Country country = new Country();
        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("select * FROM 'country' WHERE idcountry = ?;");){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                country.setIdCountry(resultSet.getInt("idcountry"));
                country.setNameCountry(resultSet.getString("namecountry"));
                country.setCapital(resultSet.getString("capital"));
                country.setPeople(resultSet.getInt("people"));


                req.setAttribute("updateid", true);
                req.setAttribute("countrybyid", country);
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
            PreparedStatement statement = connection.prepareStatement("UPDATE 'country' SET nameCountry = ?, capital = ?, people = ? WHERE idcountry = ?;");){
            req.setCharacterEncoding("UTF-8");
            String nameCountry = req.getParameter("nameCountry");
            System.out.println(nameCountry);
            statement.setString(1, nameCountry);
            String capital = req.getParameter("capital").toLowerCase();
            statement.setString(2, capital);
            System.out.println(capital);
            int people = Integer.parseInt(req.getParameter("people"));
            statement.setInt(3, people);


            int id = Integer.parseInt(req.getParameter("id"));
            statement.setInt(4 ,id);

            statement.execute();

            if(statement.executeUpdate()==1){
                System.out.println("Страна отредактирована успешно");
                update = "Старна отредактирована успешно.";
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
