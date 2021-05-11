<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 04.05.2021
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpadateCountryCity</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/styleSelect.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/mainjs.js"></script>
</head>
<body>
    <h1 style="display: flex; justify-content: center;">
        Update
    </h1>
    <section>
        <div class="container">
            <div class="row">
                <div class="col">

                        <form type="get" action="updateCountrybyid" method="GET" class="getform" >
                            <p style="background-color: yellow;">Введиет id страны для редактирования</p>
                            <input type="number" name="id" required>
                            <input type="submit" value="Вывести страну по id" class="sub">
                        </form>

                </div>
                <div class="col">

                    <form type="get" action="updateCitybyid" method="GET" class="getform" >
                        <p style="background-color: yellow;">Введиет id города для редактирования</p>
                        <input type="number" name="id" required>
                        <input type="submit" value="Вывести город по id" class="sub">
                    </form>

                </div>

            </div>
            <div class="row">
                <div class="col">
                    <div>
                        <c:if test="${updateid=='true'}">

                            <h1 style="display: flex; justify-content: center;">Данные страны по id</h1>

                                        <div class="title" style="display: flex; justify-content: center">
                                            <div style="margin: 50px;">
                                                <c:out value="${countrybyid['idCountry']}"></c:out>
                                            </div >
                                            <div style="margin: 50px;">
                                                <c:out value="${countrybyid['nameCountry']}"></c:out>
                                            </div >
                                            <div style="margin: 50px;">
                                                <c:out value="${countrybyid['capital']}"></c:out>
                                            </div >
                                            <div style="margin: 50px;">
                                                <c:out value="${countrybyid['people']}"></c:out>
                                            </div>


                                        </div>

                        </c:if>

                    </div>
                </div>

                <div class="col">
                    <div>
                        <c:if test="${updateidcity=='true'}">

                            <h1 style="display: flex; justify-content: center;">Данные города по id</h1>

                            <div class="title" style="display: flex; justify-content: center">
                                <div style="margin: 50px;">
                                    <c:out value="${citybyid['idCity']}"></c:out>
                                </div >
                                <div style="margin: 50px;">
                                    <c:out value="${citybyid['idCountry']}"></c:out>
                                </div >
                                <div style="margin: 50px;">
                                    <c:out value="${citybyid['nameCity']}"></c:out>
                                </div >
                                <div style="margin: 50px;">
                                    <p style="width: 800px; text-align: justify; height: auto;">
                                        <c:out value="${citybyid['about']}"></c:out>
                                    </p>

                                </div>
                            </div>

                        </c:if>

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">

                    <c:if test="${updateid=='true'}">
                        <h5 style="margin: auto; margin-top: 50px; margin-bottom: 50px;">
                            Введите отредактированные данные. Заполнить надо все поля (даже если значение не изменилось)
                        </h5>
                        <form type="post" action="updateCountrybyid" method="POST" class="postform" >
                            <input type="number" name="id" value="${countrybyid['idCountry']}" hidden>
                            <div>
                                <label style="background-color: yellow;">Название Страны</label>
                                <input type="text" name="nameCountry" required>
                            </div>
                            <div>
                                <label style="background-color: yellow;">Столица</label>
                                <input type="text" name="capital" required>
                            </div>
                            <div>
                                <label style="background-color: yellow;">Численность населения в миллионах человек</label>
                                <input type="number" name="people" required>
                            </div>
                            <div>
                                <input type="submit" value="Редактировать" class="sub">
                            </div>

                        </form>
                    </c:if>
                </div>

                <div class="col">

                    <c:if test="${updateidcity=='true'}">
                        <h5 style="margin: auto; margin-top: 50px; margin-bottom: 50px;">
                            Введите отредактированные данные. Заполнить надо все поля (даже если значение не изменилось)
                        </h5>
                        <form type="post" action="updateCitybyid" method="POST" class="postform" >
                            <input type="number" name="id" value="${citybyid['idCity']}" hidden>
                            <input type="number" name="idCountry" value="${citybyid['idCountry']}" hidden>
                            <div>
                                <label style="background-color: yellow;">Название Города</label>
                                <input type="text" name="nameCity" required>
                            </div>
                            <div>
                                <label style="background-color: yellow;">Описание</label>
                                <input type="text" name="about" required>
                            </div>

                            <div>
                                <input type="submit" value="Редактировать" class="sub">
                            </div>

                        </form>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <c:out value="${update}"></c:out>
                </div>

            </div>
        </div>
    </section>

    <hr>
    <a href="../index.jsp">Главная</a>
</body>
</html>
