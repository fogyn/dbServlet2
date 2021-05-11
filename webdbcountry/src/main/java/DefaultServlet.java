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


@WebServlet("/defaultDb")
public class DefaultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ConnectionUrl.defaultTable();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        req.setAttribute("defaultbool", "true");
        req.setAttribute("defaultDb", "Таблицы заполнены по default");

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
