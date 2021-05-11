<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>NewCountry&City</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/styleSelect.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/mainjs.js"></script>
</head>
<body>
    <h1 style="display: flex; justify-content: center; margin: 50px;">new Country or City</h1>




    <section class="new">
        <div class="container">
            <div class="row">
                <div class="col">
                    <form type="post" action="newcountry" method="POST" class="postform" >
                        <div>
                            <label style="background-color: yellow;">Страна</label>
                            <input type="text" name="nameCountry" required>
                        </div>
                        <div>
                            <label style="background-color: yellow;">Столица</label>
                            <input type="text" name="capital" required>
                        </div>
                        <div>
                            <label style="background-color: yellow;">Численность населения в миллионах</label>
                            <input type="number" name="people" required>
                        </div>

                        <div>
                            <input type="submit" value="Создать" class="sub">
                        </div>

                    </form>
                </div>

                <div class="col">
                    <form type="post" action="newcity" method="POST" class="postform" >
                        <div>
                            <label style="background-color: yellow;">код страны</label>
                            <input type="number" name="idCountry" required>
                        </div>

                        <div>
                            <label style="background-color: yellow;">Название города</label>
                            <input type="text" name="nameCity" required>
                        </div>

                        <div style="display: flex; flex-direction: column;">
                            <label style="background-color: yellow;">Информация о городе</label>
                            <textarea name="about"></textarea>
                        </div>

                        <div>
                            <input type="submit" value="Создать" class="sub">
                        </div>

                    </form>
                </div>
            </div>


            <div class="row">
                <div class="col">
                    <c:if test="${newBoolCountry==true || newBoolCity}">
                        <div>
                            <c:out value="${newCountryCity}"></c:out>
                        </div>
                    </c:if>

                </div>
            </div>


            <div class="row" style="margin-top: 50px;">
                 <div class="col" style="display: flex; justify-content: center;">
                     <div class="home" style="display: flex; justify-content: center; border: 2px solid blue; width: 200px;">
                         <a href="../index.jsp"><h3>Главная</h3></a>
                     </div>
                 </div>
            </div>

        </div>
    </section>




</body>
</html>
