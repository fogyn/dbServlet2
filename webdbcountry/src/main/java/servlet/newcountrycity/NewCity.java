package servlet.newcountrycity;

import basa.ConnectionUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/views/newcity")
public class NewCity extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO city (idcountry, namecity, about) VALUES (?, ?, ?);");){
            req.setCharacterEncoding("UTF-8");
            int idCountryParam = Integer.parseInt(req.getParameter("idCountry"));
            statement.setInt(1, idCountryParam);
            String nameCityParam = req.getParameter("nameCity");
            statement.setString(2, nameCityParam);
            String aboutParam = req.getParameter("about");
            statement.setString(3, aboutParam);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("newBoolCity", "true");
        req.setAttribute("newCountryCity", "Новый город добавлена");

        getServletContext().getRequestDispatcher("/views/newCountryCity.jsp").forward(req, resp);
    }
}
