package servlet.delete;

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
import java.sql.Statement;


@WebServlet("/views/deleteAllCity")
public class DeleteAllCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String delete = "";
        try(Connection connection = ConnectionUrl.createConnection();
            Statement statement = connection.createStatement();){
            String query = "DELETE FROM 'city';";
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("delete", "Все города удалены");

        getServletContext().getRequestDispatcher("/views/deleteCountryCity.jsp").forward(req, resp);

    }

}
