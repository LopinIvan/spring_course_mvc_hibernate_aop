<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>

<head>
    <title>Таблица работников компании "LopIv corporate"</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/all-employees-view-style.css">

<%--                               для локального подключения JS(JavaScript) библиотек                              --%>
    <script src="<c:url value='/static/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/js/jquery.inputmask.min.js'/>"></script>

<%--                               для удаленного подключения JS(JavaScript) библиотек                              --%>
<%--    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/inputmask@5.0.9/dist/jquery.inputmask.min.js"></script>--%>

</head>

<body>

<div class="container">

    <div class="content">
        <br>
        <h2>Введите данные о работнике</h2>

        <form:form action="saveEmployee" modelAttribute="employee">

            <form:hidden path="id"/>
            <form:hidden path="empDetails.id"/>

            <!-- Поля для Employee -->
            Имя <form:input path="firstName" required="required" placeholder="Введите имя"/>
            <br><br>
            Фамилия <form:input path="lastName" required="required"/>
            <br><br>
            Департамент <form:input path="department" required="required"/>
            <br><br>
            Зарплата <form:input path="salary" required="required" type="number" min="500" step="100"/>
            <br><br>

            <!-- Поля для EmpDetails -->
            Email <form:input path="empDetails.email" required="required" type="email"/>
            <br><br>
            Телефон <form:input path="empDetails.phoneNumber" required="required" type="tel"
                               data-inputmask="'mask': '+9(999)999-99-99'"
                               pattern="\\+\d\(\d{3}\)\d{3}-\d{2}-\d{2}"
                               title="Введите номер в формате +9(999)999-99-99"/>
            <br><br>
            Пароль <form:input path="empDetails.password" required="required"/>
            <br><br>
            Рейтинг <form:input path="empDetails.rating" required="required" type="number" min="1" max="10"/>
            <br><br>

            <!-- Условие отображения кнопок -->
            <c:choose>
                <c:when test="${not empty employee.firstName}">
                    <!-- Если id существует, это обновление -->
                    <input type="submit" class="btn1" value="Обновить">
                </c:when>
                <c:otherwise>
                    <!-- Если id пустое, это добавление нового сотрудника -->
                    <input type="submit" class="btn1" value="Добавить">
                </c:otherwise>
            </c:choose>

            <a href="${pageContext.request.contextPath}/" class="btn1">Назад</a>

        </form:form>
        <br>
    </div>

    <div class="background-overlay"></div>

</div>

<script>
    $(document).ready(function(){
        // Применение маски
        $(":input[type='tel']").inputmask("+9(999)999-99-99");
        // Валидация перед отправкой формы
        $("form").on("submit", function(e) {
            const phoneInput = $(":input[name='empDetails.phoneNumber']");
            const phone = phoneInput.val();
            const validPhone = phone.match(/^\+\d\(\d{3}\)\d{3}-\d{2}-\d{2}$/);

            if (!validPhone) {
                alert("Пожалуйста, введите корректный номер телефона в формате +9(999)999-99-99.");
                e.preventDefault(); // Останавливаем отправку формы
            }
        });
    });
</script>

</body>

</html>