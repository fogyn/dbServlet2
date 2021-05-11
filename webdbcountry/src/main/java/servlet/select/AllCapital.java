package servlet.select;

import basa.ConnectionUrl;

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

@WebServlet("/views/getAllCapital")
public class AllCapital extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> listCapital = new ArrayList<>();
        try(Connection connection = ConnectionUrl.createConnection();
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcountry2", "root","1403Kate,");
            Statement statement = connection.createStatement();

        ){
            ResultSet resultSet = statement.executeQuery("select capital from country;");
            int i = 0;
            while (resultSet.next()){
                i++;
                String name = resultSet.getString("capital");
                System.out.print("Столица : "+name+", ");
                listCapital.add(name);

            }

            if(i!=0){
                req.setAttribute("allboolcapital", "true");
                req.setAttribute("allc", listCapital);
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
