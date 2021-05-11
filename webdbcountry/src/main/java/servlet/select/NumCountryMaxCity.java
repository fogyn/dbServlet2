package servlet.select;

import basa.ConnectionUrl;
import org.json.HTTP;

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

@WebServlet("/views/getNumCountryMaxColCity")
public class NumCountryMaxCity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> listCity = new ArrayList<>();
        int num = Integer.parseInt(req.getParameter("num"));
        if(num<=0){
            req.setAttribute("allbool22", "true");
            req.setAttribute("all22", "Запрашиваемое число стран, как результат, должно быть больше 0!");
        }
        else{
            try(Connection connection = ConnectionUrl.createConnection();
                //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcountry2", "root","1403Kate,");
                PreparedStatement statement = connection.prepareStatement("select namecountry, num from country, (select count() as num, idcountry from  city GROUP by idcountry) as dop where dop.idcountry = country.idcountry ORDER by num DESC LIMIT ?;");
            ){

                statement.setInt(1,num);
                ResultSet resultSet = statement.executeQuery();

                int i = 0;
                while (resultSet.next()){
                    i++;
                    String nameCountry = resultSet.getString("namecountry");
                    System.out.print("Страна : "+nameCountry+", ");
                    String reznum = resultSet.getString("num");
                    nameCountry = nameCountry+", число городов = "+reznum;
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
