<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
    </tr>


    <c:forEach var="emp" items="${allEmps}">

        <tr>
            <td>${emp.firstName}</td>
            <td>${emp.lastName}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
        </tr>

    </c:forEach>

</table>
</div>

    <div class="background-overlay"></div>

    </div>

</body>

</html>