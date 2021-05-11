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

@WebServlet("/views/newcountry")
public class NewCountry extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO country (namecountry, capital, people) VALUES (?, ?, ?);");){
            req.setCharacterEncoding("UTF-8");
            String nameCountryParam = req.getParameter("nameCountry");
            statement.setString(1, nameCountryParam);
            String capitalParam = req.getParameter("capital");
            statement.setString(2, capitalParam);
            int peopleParam = Integer.parseInt(req.getParameter("people"));
            statement.setInt(3, peopleParam);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("newBoolCountry", "true");
        req.setAttribute("newCountryCity", "Новая страна добавлена");

        getServletContext().getRequestDispatcher("/views/newCountryCity.jsp").forward(req, resp);
    }
}
