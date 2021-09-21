<%--
  Created by IntelliJ IDEA.
  User: AZiyalov
  Date: 19.09.2021
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="ru.appline.logic.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Домашняя страница по работе с пользователем</h1>
  Введите id пользователя (0 - для вывода всего списка пользователей)
  <br/>

  Доступно: <%
  Model model = Model.getInstance();
  out.print(model.getFromList().size()); %>
  <form method="get" action="get">
    <label>id
      <input type="text" name="id">
    </label>
    <button type="submit">Поиск</button>

    <a href="addUser.html">Создать нового пользователя</a>
  </form>
  </body>
</html>
