<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <title>Country&City</title>

    <link rel="stylesheet" href="css/normalize.css">

    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <script src="js/mainjs.js"></script>

</head>
<body>


<section class="network" style="margin-top: 100px">
    <div class="container">
        <div class="row r0">
            <div class="col-4" style="margin: auto">
                <h1>
                    Главная страница
                </h1>
            </div>
        </div>
        <div class="row r1">
            <div class="col">
                <a href="views/newCountryCity.jsp">
                    <p class="num1">
                        Создание новой записи
                    </p>
                </a>
            </div>
            <div class="col">
                <a href="views/updateCountryCity.jsp">
                    <p class="num1">
                        Редактирование записи
                    </p>
                </a>
            </div>
            <div class="col">
                <a href="views/deleteCountryCity.jsp">
                    <p class="num1">
                        Удаление записи
                    </p>
                </a>
            </div>
            <div class="col">
                <a href="views/select.jsp">
                    <p class="num1">
                        Выбор данных из базы
                    </p>
                </a>
            </div>
            <div class="col">
                <div>
                    <form type="post" action="defaultDb" method="POST" class="postform" style="background-color: red;">
                        <input type="submit" value="Заполнение базы по дефолту" style="background-color: red; color: #000000;">
                    </form>
                </div>


            </div>
        </div>
        <div class="row" style="margin: 50px;">
            <div class="col">
                <c:if test="${defaultbool =='true'}">
                    <div>
                        <c:out value="${defaultDb}"></c:out>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
    <hr>


</section>





</body>
</html>
