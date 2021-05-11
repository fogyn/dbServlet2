package servlet.select;

import basa.ConnectionUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/views/getCityrepeat")
public class NumCityByNoUniqName extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> listCity = new ArrayList<>();

        try(Connection connection = ConnectionUrl.createConnection();
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcountry2", "root","1403Kate,");
            Statement statement = connection.createStatement();

        ){
            ResultSet resultSet = statement.executeQuery("select namecity, num from (select namecity, count() as num from city GROUP by namecity) where num > 1;");
            int i = 0;
            while (resultSet.next()){
                i++;
                String name = resultSet.getString("namecity");
                System.out.print("Город : "+name+", ");
                String num = resultSet.getString("num");
                try(Connection connection2 = ConnectionUrl.createConnection();
                    PreparedStatement statement2 = connection.prepareStatement("select namecountry from country, city where country.idcountry = city.idcountry and namecity like ?; ");
                ) {

                    statement2.setString(1, name);
                    ResultSet resultSet2 = statement2.executeQuery();
                    name = name+", число повторений названия города = "+num+", страны - ";
                    while(resultSet2.next()){
                        name = name+resultSet2.getString("namecountry") + ", ";

                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }

                listCity.add(name);

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
