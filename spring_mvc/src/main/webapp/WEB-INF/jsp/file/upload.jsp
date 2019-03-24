<%--
  Created by IntelliJ IDEA.
  User: kirogiyi
  Date: 2019-03-21
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload file</title>
</head>
<body>
    <form method="post" action="./request" enctype="multipart/form-data">
        <input type="file" name="file" value="Select">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
