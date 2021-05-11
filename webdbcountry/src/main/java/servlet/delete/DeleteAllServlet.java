package servlet.delete;

import basa.ConnectionUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/views/deleteAll")
public class DeleteAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try(Connection connection = ConnectionUrl.createConnection();
            Statement statement = connection.createStatement();){
            String query = "DELETE FROM 'country';";
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //ConnectionUrl.booldb = false;
        req.setAttribute("delete", "Все записи из базы удалены");

        getServletContext().getRequestDispatcher("/views/deleteCountryCity.jsp").forward(req, resp);

    }

}
