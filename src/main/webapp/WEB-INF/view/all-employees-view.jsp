<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>

<head>
    <title>Таблица работников компании "LopIv corporate"</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/all-employees-view-style.css">
</head>

<body>

<div class="container">

    <div class="content">
        <br>
        <h2>Таблица работников компании "LopIv corporate"</h2>

<table>

    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отдел</th>
        <th>Зарплата</th>
        <th>Операции</th>
    </tr>


    <c:forEach var="emp" items="${allEmps}">

        <tr>
            <td>${emp.firstName}</td>
            <td>${emp.lastName}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td><input type="button" class="btn" value="Посмотреть детали"
                       onclick="window.location.href= 'details/' + ${emp.id}"/></td>
        </tr>

    </c:forEach>

</table>

    <input type="button" class="btn" value="Добавить работника"
    onclick="window.location.href= 'addNewEmployee'"/>
    <br><br>

</div>

    <div class="background-overlay"></div>

    </div>

</body>

</html>