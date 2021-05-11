package servlet.delete;

import basa.ConnectionUrl;
import model.City;
import model.Country;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/views/deleteSomeCity")
public class DeleteSomeCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<City> listCity = new ArrayList<>();
        try(Connection connection = ConnectionUrl.createConnection();
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcountry2", "root","1403Kate,");
            Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM city;");
            int i = 0;
            while (resultSet.next()){
                i++;
                City city = new City();
                int id = resultSet.getInt("idcity");
                city.setIdCity(id);
                int idcountry = resultSet.getInt("idcountry");
                city.setIdCountry(idcountry);
                String name = resultSet.getString("namecity");
                city.setNameCity(name);
                String about = resultSet.getString("about");
                city.setAbout(about);
                listCity.add(city);
            }
            if(i!=0){
                req.setAttribute("somebooldeleteCity2", "true");
                req.setAttribute("somecity", listCity);
            }
            else{
                req.setAttribute("allbool22", "true");
                req.setAttribute("all22", "Данных нет");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/views/deleteCountryCity.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, JSONException {
        System.out.println("Пришло2");
        String myJsonData = req.getParameter("term");
        String[] mas = myJsonData.split(",");

        int[]masId = new int[mas.length];
        for(int i=0; i<mas.length; i++){
            masId[i] = Integer.parseInt(mas[i]);
            System.out.println(masId[i]);
        }

        String delete = "";
        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM 'city' WHERE idcity = ?;");){

            for(int a:masId){
                statement.setInt(1, a);
                statement.addBatch();
            }
            int[] rez = statement.executeBatch();
            //System.out.println(rez.length);

            if(rez.length >0){
                System.out.println("Города удалены успешно");
                delete = "Города удалены успешно.";
            }
            else{
                System.out.println("Нет городов с таким id");
                delete = "Нет городов с таким id";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("delete", delete);

        resp.setContentType("application/json");//Отправляем от сервера данные в JSON -формате
        resp.setCharacterEncoding("utf-8");
        try (PrintWriter out = resp.getWriter()) {
            JSONObject jsonEnt = new JSONObject();
            System.out.println("Пришло json");
            jsonEnt.put("delete", delete);

            out.print(jsonEnt.toString());
        }
        catch (Exception e){e.printStackTrace();  }
    }
}
