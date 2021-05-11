package servlet.select;

import basa.ConnectionUrl;
import model.City;
import model.Country;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/views/getallCountryCity")
public class SelectAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        try {
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        List<Country> listCountry = new ArrayList<>();
        try(Connection connection = ConnectionUrl.createConnection();
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcountry2", "root","1403Kate,");
            Statement statement = connection.createStatement();


                                                                     ){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM country;");
            int i = 0;
            while (resultSet.next()){
                i++;
                 Country country = new Country();
                int id = resultSet.getInt("idcountry");
                System.out.print("id = "+id+", ");
                country.setIdCountry(id);

                String name = resultSet.getString("namecountry");
                System.out.print("Производитель : "+name+", ");
                country.setNameCountry(name);

                String capital = resultSet.getString("capital");
                System.out.print("модель : "+capital+", ");
                country.setCapital(capital);

                int people = resultSet.getInt("people");
                System.out.print("Объем : "+people+", ");
                country.setPeople(people);


                System.out.println();
                System.out.println("------------");
                listCountry.add(country);
            }

            if(i!=0){
                ResultSet resultSet2 = statement.executeQuery("SELECT * FROM city;");
                while (resultSet2.next()){
                    City city = new City();
                    int id = resultSet2.getInt("idcity");
                    System.out.print("id = "+id+", ");
                    city.setIdCity(id);

                    int idCountry = resultSet2.getInt("idcountry");
                    System.out.print("idcity = "+idCountry+", ");
                    city.setIdCountry(idCountry);


                    String nameCity = resultSet2.getString("namecity");
                    System.out.print("Производитель : "+nameCity+", ");
                    city.setNameCity(nameCity);

                    String about = resultSet2.getString("about");
                    System.out.print("модель : "+about+", ");
                    city.setAbout(about);

                    System.out.println();
                    System.out.println("------------");

                    for(Country c : listCountry){
                        if(c.getIdCountry()==idCountry){

                            System.out.println(c.getIdCountry());
                            c.addListCity(city);
                            break;
                        }
                    }
                }

                req.setAttribute("allbool", "true");
                req.setAttribute("all", listCountry);
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
