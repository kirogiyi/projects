<%--
  Created by IntelliJ IDEA.
  User: kirogiyi
  Date: 2019-03-23
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.spring_mvc.pojo.User" %>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Test @SessionAttributes</title>
</head>
<body>
    <%
        User user = (User)session.getAttribute("user");
        Long id = (Long)session.getAttribute("id_new");
        out.print("<br>user_name= " + user.getUserName());
        out.println("<br>id_name = " + id);
    %>
</body>
</html>
