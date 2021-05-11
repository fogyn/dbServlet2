package servlet.select;

import basa.ConnectionUrl;

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
import java.util.ArrayList;
import java.util.List;


@WebServlet("/views/getCityBetweenNum")
public class CountryByCityBerween extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> listCity = new ArrayList<>();
        int min = Integer.parseInt(req.getParameter("min"));
        int max = Integer.parseInt(req.getParameter("max"));
        if(min<0 || max <=0 || min >=max ){
            req.setAttribute("allbool22", "true");
            req.setAttribute("all22", "Укажите правильный дтапазон. Минимальное значение должно быть меньше максимального и больше 0!");
        }
        else{
            try(Connection connection = ConnectionUrl.createConnection();
                //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcountry2", "root","1403Kate,");
                PreparedStatement statement = connection.prepareStatement("select namecountry from country, (select count() as num, idcountry from  city GROUP by idcountry) as dop where dop.idcountry = country.idcountry and num BETWEEN ? and ?;");
            ){

                statement.setInt(1,min);
                statement.setInt(2,max);
                ResultSet resultSet = statement.executeQuery();

                int i = 0;
                while (resultSet.next()){
                    i++;
                    String nameCountry = resultSet.getString("namecountry");
                    System.out.print("Страна : "+nameCountry+", ");

                    listCity.add(nameCountry);
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
        }


        getServletContext().getRequestDispatcher("/views/select.jsp").forward(req, resp);
    }
}
