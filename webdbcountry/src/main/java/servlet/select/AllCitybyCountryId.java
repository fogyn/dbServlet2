package servlet.select;

import basa.ConnectionUrl;
import model.City;
import model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/views/getallCityByIdCountry")
public class AllCitybyCountryId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> listCity = new ArrayList<>();
        try(Connection connection = ConnectionUrl.createConnection();
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcountry2", "root","1403Kate,");
            PreparedStatement statement = connection.prepareStatement("select namecity from city WHERE idcountry = ?;");
        ){
            int idCountry = Integer.parseInt(req.getParameter("idCountry"));
            statement.setInt(1,idCountry);
            ResultSet resultSet = statement.executeQuery();

            int i = 0;
            while (resultSet.next()){
                i++;
                String nameCity = resultSet.getString("namecity");
                System.out.print("Город : "+nameCity+", ");
                listCity.add(nameCity);
            }

            if(i!=0){
                req.setAttribute("allboolcountry", "true");
                req.setAttribute("allc", listCity);
            }
            else{
                req.setAttribute("allbool22", "true");
                req.setAttribute("all22", "Данных нет");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/views/select.jsp").forward(req, resp);
    }
}
