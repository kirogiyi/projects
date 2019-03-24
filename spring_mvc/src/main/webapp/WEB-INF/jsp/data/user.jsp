<%--
  Created by IntelliJ IDEA.
  User: kirogiyi
  Date: 2019-03-21
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>User Info</title>
</head>
<body>
    <table>
        <tr>
            <td>Number</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>User Name</td>
            <td>${user.userName}</td>
        </tr>
        <tr>
            <td>Remark</td>
            <td>${user.note}</td>
        </tr>
    </table>
</body>
</html>
