package servlet;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/views/ajax")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Пришло2");
        String myJsonData = req.getParameter("term");
        String[] mas = myJsonData.split(",");
        System.out.println(mas[0]);


        resp.setContentType("application/json");//Отправляем от сервера данные в JSON -формате
        resp.setCharacterEncoding("utf-8");


        try (PrintWriter out = resp.getWriter()) {
            JSONObject jsonEnt = new JSONObject();
            System.out.println("Пришло json");
            jsonEnt.put("serverInfo", "Вы вошли!");

            out.print(jsonEnt.toString());
        }
        catch (Exception e){

        }

    }
}
