<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Select</title>
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/styleSelect.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/mainjs.js"></script>
</head>
<body>



    <section class="select" style="margin-top: 100px">
        <div class="container">
            <div class="row r0">
                <div class="col-4" style="margin: auto; margin-bottom: 50px;">
                    <h1>
                        Выборка из базы
                    </h1>
                </div>
            </div>
            <div class="row r1" style="margin-bottom: 50px;">
                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="getallCountryCity" method="GET" class="getform" >
                        <input type="submit" value="Выбрать все" class="sub">
                    </form>
                </div>
                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="getAllCountry" method="GET" class="getform" >
                        <input type="submit" value="Все страны" class="sub">
                    </form>
                </div>
                <div class="col" style="display: flex; justify-content: center;">
                    <form type="get" action="getAllCapital" method="GET" class="getform" >
                        <input type="submit" value="Выбрать все столицы" class="sub">
                    </form>
                </div>

            </div>
            <hr>
            <div class="row r2" style="margin-bottom: 50px;">
                <div class="col">
                    <form type="get" action="getallCityByIdCountry" method="GET" class="getform" >
                        <p style="background-color: yellow;">Введите id страны для поиска городов</p>
                        <input type="number" name="idCountry" required>
                        <input type="submit" value="Вывести города по id страны" class="sub">
                    </form>
                </div>

                <div class="col">
                    <form type="get" action="getCapitalByIdCountry" method="GET" class="getform" >
                        <p style="background-color: yellow;">Введите id страны для поиска столицы</p>
                        <input type="number" name="idCountry" required>
                        <input type="submit" value="Вывести столицу страны по id" class="sub">
                    </form>
                </div>

            </div>
            <hr>
            <div class="row r3" style="margin-bottom: 50px;">

                <div class="col">
                    <form type="get" action="getNumCountryMaxColCity" method="GET" class="getform" >
                        <p>
                            Страны самым большим числом городов
                        </p>
                        <p style="background-color: yellow;">Введиет, n - сколько стран показать</p>
                        <input type="number" name="num" required>
                        <input type="submit" value="Показать" class="sub">
                    </form>
                </div>
                <div class="col">
                    <form type="get" action="getNumCountryMaxColPeople" method="GET" class="getform" >
                        <p>
                            Страны с самым большим количеством населения
                        </p>
                        <p style="background-color: yellow;">Введиет, n - сколько стран показать</p>
                        <input type="number" name="num" required>
                        <input type="submit" value="Показать" class="sub">
                    </form>
                </div>
                <div class="col">
                    <form type="get" action="getNumCountryMinColPeople" method="GET" class="getform" >
                        <p>
                            Страны с самым маленьким количеством населения
                        </p>
                        <p style="background-color: yellow;">Введиет, n - сколько стран показать</p>
                        <input type="number" name="num" required>
                        <input type="submit" value="Показать" class="sub">
                    </form>
                </div>
                <div class="col">
                    <form type="get" action="getAveragePeopleInCity" method="GET" class="getform" >
                        <p>
                            Вывести среднее число жителей в городе
                        </p>
                        <p style="background-color: yellow;">Введите id страны для расчета </p>
                        <input type="number" name="idCountry" required>
                        <input type="submit" value="Показать" class="sub">
                    </form>
                </div>

            </div>
            <hr>
            <div class="row r4" style="margin-bottom: 50px;">

                <div class="col">
                    <form type="get" action="getCityrepeat" method="GET" class="getform" >
                        <p>
                            Количество городов с одинаковыми названиями в разных странах
                        </p>
                        <input type="submit" value="Вывести" class="sub">
                    </form>
                </div>
                <div class="col">
                    <form type="get" action="getallUnicCity" method="GET" class="getform" >
                        <p>
                            Не повторяющиеся названия городов и стран где они расположены
                        </p>
                        <input type="submit" value="Вывести" class="sub">
                    </form>
                </div>
                <div class="col">
                    <form type="get" action="getCityBetweenNum" method="GET" class="getform" >
                        <p>
                            Вывести страны, число городов которых находитя в указанном диапазоне
                        </p>
                        <p style="background-color: yellow;">Введиет min число городов</p>
                        <input type="number" name="min" required>
                        <p style="background-color: yellow;">Введиет max число городов</p>
                        <input type="number" name="max" required>
                        <input type="submit" value="Вывести" class="sub">
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col" style="display: flex; justify-content: center;">
                    <div class="home" style="display: flex; justify-content: center; border: 2px solid blue; width: 200px;">
                        <a href="../index.jsp"><h3>Главная</h3></a>
                    </div>
                </div>
            </div>
        </div>
        <hr>
    </section>

    <section class="rez">
        <div class="container">
            <div class="row all">
                <div class="col">
                    <div>
                        <!--вывод всей информации из базы-->
                        <c:if test="${allbool=='true' || yearbetweenbool=='true' || yearbool=='true'}">
                            <h1 style="display: flex; justify-content: center;">данные из базы</h1>

                            <div>
                                <c:forEach var="country" items="${all}" varStatus="b">
                                    <div class="countryclass">
                                        <div class="title" style="display: flex; justify-content: center">
                                            <div style="margin: 50px;">
                                                <c:out value="${country['idCountry']}"></c:out>
                                            </div >
                                            <div style="margin: 50px;">
                                                <c:out value="${country['nameCountry']}"></c:out>
                                            </div >
                                            <div style="margin: 50px;">
                                                <c:out value="${country['capital']}"></c:out>
                                            </div >
                                            <div style="margin: 50px;">
                                                <c:out value="${country['people']}"></c:out>
                                            </div>

                                                <c:set var="citis" value="${country['listCity']}"></c:set>

                                        </div>
                                        <table style="margin: auto;">

                                            <tr>
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

                                            <c:forEach var="el" items="${citis}" varStatus="b">

                                                <tr>
                                                    <td>
                                                        <c:out value="${el['idCity']}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${el['idCountry']}"></c:out>
                                                    </td>
                                                    <td>
                                                        <c:out value="${el['nameCity']}"></c:out>
                                                    </td>
                                                    <td style="margin-top: 50px; margin-bottom: 50px; height: auto;">
                                                        <p style="width: 800px; text-align: justify; height: auto;">
                                                            <c:out value="${el['about']}"></c:out>
                                                        </p>

                                                    </td>

                                                </tr>
                                            </c:forEach>

                                        </table>
                                    </div>


                                </c:forEach>
                            </div>
                        </c:if>

                        <c:if test="${allbool22 =='true'}">

                            <div>
                                <c:out value="${all22}"></c:out>
                            </div>

                        </c:if>

                        <!--вывод названия стран-->
                        <c:if test="${allboolcountry=='true' || allboolcapital=='true' || allboolcitybyCountry=='true'}">

                            <div style="margin: auto;">
                                <c:forEach var="out" items="${allc}" varStatus="b">
                                    <div class="name2">
                                        <c:out value="${b.index+1}. ${out}"></c:out>
                                    </div>

                                </c:forEach>
                            </div>
                        </c:if>

<!--вывод производителей и количество их авто-->
                        <c:if test="${namecol=='true'}">
                            <h1 style="display: flex; justify-content: center;">Все производители  и количество авто в базе</h1>
                            <div style="margin: auto;">
                                <c:forEach var="manufactory" items="${names_cols}" varStatus="b">
                                    <div class="name2">
                                        <c:out value="${b.index+1}. ${manufactory['name']} - ${manufactory['count']}"></c:out>
                                    </div>

                                </c:forEach>
                            </div>
                        </c:if>
                        <!--вывод производителя с максимальным числом авто-->
                        <c:if test="${namemaxbool=='true'}">
                            <h3 style="display: flex; justify-content: center; width: 900px; margin: auto">Наименование производителя с максимальным числом авто в базе</h3>
                            <div style="margin: auto;">
                                <c:forEach var="av" items="${namemax}" varStatus="b">
                                    <div class="name2" style="display: flex; justify-content: center;">
                                        <c:out value="${av['name']} - ${av['count']}"></c:out>
                                    </div>
                                </c:forEach>

                            </div>
                        </c:if>

                        <!--вывод производителя с минимальным числом авто-->
                        <c:if test="${nameminbool=='true'}">
                            <h3 style="display: flex; justify-content: center; width: 900px; margin: auto">Наименование производителя с минимальным числом авто в базе</h3>
                            <div style="margin: auto;">
                                <c:forEach var="av" items="${namemin}" varStatus="b">
                                    <div class="name2" style="display: flex; justify-content: center;">
                                        <c:out value="${av['name']} - ${av['count']}"></c:out>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>


                        <!--вывод авто по конкретному году если такого авто нет-->
                        <c:if test="${yearboolnot=='true' || yearboolbetweennot =='true'}">
                            <h3 style="display: flex; justify-content: center; width: 900px; margin: auto">Наименование производителя с минимальным числом авто в базе</h3>
                            <div style="margin: auto;">
                                <div class="name2" style="display: flex; justify-content: center;">
                                    <c:out value="${avto_notyear}"></c:out>
                                </div>
                            </div>
                        </c:if>




                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="rez">
        <div class="container">
            <div class="row all">
                <div class="col">
                    <c:if test="${allname=='true'}">
                        <h1 style="display: flex; justify-content: center;">Все производители</h1>
                        <div style="margin: auto;">
                            <c:forEach var="name" items="${names}" varStatus="b">
                                <div class="name2">
                                    <c:out value="${b.index+1}. ${name}"></c:out>
                                </div>

                            </c:forEach>
                        </div>


                    </c:if>
                </div>
            </div>

        </div>

    </section>

    <hr>


</body>
</html>
