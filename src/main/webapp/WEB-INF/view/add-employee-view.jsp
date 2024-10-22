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
        <h2>Введите данные о работнике</h2>

        <form:form action="saveNewEmployee" modelAttribute="employee">

            <form:hidden path="id"/>
            <form:hidden path="empDetails.id"/>

            <!-- Поля для Employee -->
            Имя <form:input path="firstName"/>
            <br><br>
            Фамилия <form:input path="lastName"/>
            <br><br>
            Департамент <form:input path="department"/>
            <br><br>
            Зарплата <form:input path="salary"/>
            <br><br>

            <!-- Поля для EmpDetails -->
            Email <form:input path="empDetails.email"/>
            <br><br>
            Телефон <form:input path="empDetails.phoneNumber"/>
            <br><br>
            Пароль <form:input path="empDetails.password"/>
            <br><br>
            Рейтинг <form:input path="empDetails.rating"/>
            <br><br>

            <input type="submit" class="btn" value="Добавить">
            <a href="${pageContext.request.contextPath}/" class="btn">Назад</a>

        </form:form>
        <br>
    </div>

    <div class="background-overlay"></div>

</div>

</body>

</html>