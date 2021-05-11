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


@WebServlet("/views/deleteCountryById")
public class DeleteCountryByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        String delete = "";
        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM 'country' WHERE idcountry = ?;");){

            statement.setInt(1, id);


            if(statement.executeUpdate()==1){
                System.out.println("Страна с городами удалена успешно");
                delete = "Страна с городами удалена успешно.";
            }
            else{
                System.out.println("Нет страны с таким id");
                delete = "Нет страны с таким id";
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("delete", delete);

        getServletContext().getRequestDispatcher("/views/deleteCountryCity.jsp").forward(req, resp);

    }
}
