<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>

<head>
    <title>Подробная информация о работнике "LopIv corporate"</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/all-employees-view-style.css">
</head>

<body>

<div class="container">

    <div class="content">
        <br>
        <h2>Подробная информация о работнике</h2>

        <table>

            <tr>
                <th>Емейл</th>
                <th>Номер телефона</th>
                <th>Пароль</th>
                <th>Рейтинг</th>
                <th>Операции</th>
            </tr>

            <tr>
                <td>${empDetails.email}</td>
                <td>${empDetails.phoneNumber}</td>
                <td>${empDetails.password}</td>
                <td>${empDetails.rating}</td>
                <td><input type="button" class="btn" value="Назад"
                           onclick="window.history.back()"/></td>
            </tr>

        </table>
    </div>

    <div class="background-overlay"></div>

</div>

</body>

</html>
