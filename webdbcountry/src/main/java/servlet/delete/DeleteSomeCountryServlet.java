package servlet.delete;

import basa.ConnectionUrl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.Country;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/views/deleteSomeCountry")
public class DeleteSomeCountryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Country> listCountry = new ArrayList<>();
        try(Connection connection = ConnectionUrl.createConnection();
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcountry2", "root","1403Kate,");
            Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM country;");
            int i = 0;
            while (resultSet.next()){
                i++;
                Country country = new Country();
                int id = resultSet.getInt("idcountry");
                //System.out.print("id = "+id+", ");
                country.setIdCountry(id);

                String name = resultSet.getString("namecountry");
                //System.out.print("Производитель : "+name+", ");
                country.setNameCountry(name);

                String capital = resultSet.getString("capital");
                //System.out.print("модель : "+capital+", ");
                country.setCapital(capital);

                int people = resultSet.getInt("people");
               // System.out.print("Объем : "+people+", ");
                country.setPeople(people);
//                System.out.println();
//                System.out.println("------------");
                listCountry.add(country);
            }
            if(i!=0){
            req.setAttribute("somebooldeleteCountry", "true");
            req.setAttribute("somecountry", listCountry);
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
        //int id = Integer.parseInt(req.getParameter("id"));


        String delete = "";
        try(Connection connection = ConnectionUrl.createConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM 'country' WHERE idcountry = ?;");){

            for(int a:masId){
                statement.setInt(1, a);
                statement.addBatch();
            }
            int[] rez = statement.executeBatch();
            //System.out.println(rez.length);

            if(rez.length >0){
                System.out.println("Страны удалены успешно");
                delete = "Страны удалены успешно.";
            }
            else{
                System.out.println("Нет стран с таким id");
                delete = "Нет стран с таким id";
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

        //getServletContext().getRequestDispatcher("/views/deleteCountryCity.jsp").forward(req, resp);


    }
}
