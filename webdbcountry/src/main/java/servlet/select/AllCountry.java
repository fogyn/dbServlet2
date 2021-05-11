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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/views/getAllCountry")
public class AllCountry extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> listCountry = new ArrayList<>();
        try(Connection connection = ConnectionUrl.createConnection();
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcountry2", "root","1403Kate,");
            Statement statement = connection.createStatement();

        ){
            ResultSet resultSet = statement.executeQuery("select nameCountry from country;");
            int i = 0;
            while (resultSet.next()){
                i++;
                String name = resultSet.getString("namecountry");
                System.out.print("Старна : "+name+", ");
                listCountry.add(name);

            }

            if(i!=0){
                req.setAttribute("allboolcountry", "true");
                req.setAttribute("allc", listCountry);
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
