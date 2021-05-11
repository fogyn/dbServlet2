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
    <title>DeleteCountryCity</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/styleSelect.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/mainjs.js"></script>
</head>
<body>
    <h1 style="display: flex; justify-content: center;">
        Delete
    </h1>

    <section>
        <div class="container">
            <div class="row" style="margin: 50px;">
                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="deleteAll" method="GET" class="getform" >

                        <input type="submit" value="удалить все" class="sub">
                    </form>
                </div>
                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="deleteAllCity" method="GET" class="getform" >

                        <input type="submit" value="удалить все города" class="sub">
                    </form>
                </div>

            </div>
            <div class="row" style="margin: 50px;">
                <div class="col">
                    <form type="get" action="deleteCountryById" method="GET" class="getform" >
                        <p style="background-color: yellow;">Введиет id страны для удаления</p>
                        <input type="number" name="id" required>
                        <input type="submit" value="удалить" class="sub">
                    </form>
                </div>
                <div class="col">
                    <form type="get" action="deleteCityById" method="GET" class="getform" >
                        <p style="background-color: yellow;">Введиет id города для удаления</p>
                        <input type="number" name="id" required>
                        <input type="submit" value="удалить" class="sub">
                    </form>
                </div>

            </div>

            <div class="row" style="margin: 50px;">
                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="deleteSomeCountry" method="GET" class="getform" >

                        <input type="submit" value="удалить выборочно страны" class="sub" id="country">
                    </form>
                </div>
                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="deleteSomeCity" method="GET" class="getform" >

                        <input type="submit" value="удалить выборочно города" class="sub" id="city">
                    </form>
                </div>

            </div>

            <div class="row" style="margin: 50px;">
                <div class="col">
                    <c:if test="${somebooldeleteCity == 'true'}">
                        <div>

                            <table style="margin: auto;">

                                <tr>
                                    <th>
                                        Chekbox for delete
                                    </th>
                                    <th>
                                        idCity
                                    </th>
                                    <th>
                                        idCountry
                                    </th>
                                    <th>
                                        nameCity
                                    </th>
                                    <th style="margin: auto;">
                                        about
                                    </th>

                                </tr>
                                <form type="get" action="deleteSomeCity" method="GET" class="getform">
                                    <c:forEach var="city" items="listCity" varStatus="i">
                                    <tr>
                                        <td>
                                            <div>
                                                <input type="checkbox" name="ch${i.index}">
                                            </div>

                                        </td>
                                        <td>
                                            <c:out value="${city['idCity']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${city['idCountry']}"></c:out>
                                        </td>
                                        <td>
                                            <c:out value="${city['nameCity']}"></c:out>
                                        </td>
                                        <td style="margin-top: 50px; margin-bottom: 50px; height: auto;">
                                            <p style="width: 800px; text-align: justify; height: auto;">
                                                <c:out value="${city['about']}"></c:out>
                                            </p>

                                        </td>

                                    </tr>

                                     </c:forEach>

                                    <input type="submit" value="удалить отмеченные" class="sub">
                                </form>
                            </table>
                        </div>

                    </c:if>

                    <c:if test="${somebooldeleteCountry == 'true'}">
                    <div style="display: flex; flex-direction: column;">
                        <form>
                            <div style="overflow: scroll; height: 300px;">
                                <c:forEach var="country" items="${somecountry}" varStatus="i">
                                    <div style="display: flex; justify-content: center; align-items: center; border: 2px solid blue;">
                                        <div style="margin: 50px; width: 100px;">
                                            <input type="checkbox" name="ch" value="${country['idCountry']}" style="width: 50px; height: 50px;">
                                        </div>
                                        <div style="margin: 50px; width: 100px;">
                                            <c:out value="${country['nameCountry']}"></c:out>
                                        </div>
                                        <div style="margin: 50px; width: 100px;">
                                            <c:out value="${country['capital']}"></c:out>
                                        </div>
                                        <div style="margiт: 50px; width: 100px;">
                                            <c:out value="${country['people']}"></c:out>
                                        </div>
                                    </div>

                                </c:forEach>
                            </div>

                            <!--    <div style="display: flex; justify-content: center;">
                                    <input type="submit" id="idsub" name="subsomecountrydel" value="Удалить выбранные страны" >
                                </div>  -->

                        </form>
                        <div style="display: flex; justify-content: center;">
                            <button id="idbut" name="somebutdel"  onclick="makeAjaxCall(${delete})" style="width: 200px; height: 50px;">Удалить выбранные страны</button>
                        </div>

                    </div>
                </c:if>

                    <!-- удаление выбранных городов-->



                    <c:if test="${somebooldeleteCity2 == 'true'}">
                        <div style="display: flex; flex-direction: column;">
                            <form>
                                <div style="overflow: scroll; height: 300px;">
                                    <c:forEach var="city" items="${somecity}" varStatus="i">
                                        <div style="display: flex; justify-content: center; align-items: center; border: 2px solid blue;">
                                            <div style="margin: 50px; width: 100px;">
                                                <input type="checkbox" name="chcity" value="${city['idCity']}" style="width: 50px; height: 50px;">
                                            </div>
                                            <div style="margin: 50px; width: 150px;">
                                                <c:out value="принадлежность стране по её id ${city['idCountry']}"></c:out>
                                            </div>
                                            <div style="margin: 50px; width: 100px;">
                                                <c:out value="${city['nameCity']}"></c:out>
                                            </div>
                                            <div style="margiт: 50px; width: 400px;">
                                                <c:out value="${city['about']}"></c:out>
                                            </div>
                                        </div>

                                    </c:forEach>
                                </div>

                                <!--    <div style="display: flex; justify-content: center;">
                                        <input type="submit" id="idsub" name="subsomecountrydel" value="Удалить выбранные страны" >
                                    </div>  -->

                            </form>
                            <div style="display: flex; justify-content: center;">
                                <button id="idbutcity" name="somebutdelcity"  onclick="makeDeleteSomeCity()" style="width: 200px; height: 50px;">Удалить выбранные города</button>
                            </div>

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
        <hr>
        <div class="row" style="margin: 50px;">
            <div class="col" style="display: flex; justify-content: center;">
                <c:out value="${delete}"></c:out>
                <div id="delСountryCityajax">

                </div>
            </div>
        </div>
    </section>


</body>
</html>
