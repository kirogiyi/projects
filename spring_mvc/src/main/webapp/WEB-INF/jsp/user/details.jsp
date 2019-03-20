<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>User details</title>
    </head>
    <body>
        <center>
            <table border="1">
                <tr>
                    <td>Label</td>
                    <td>Value</td>
                </tr>
                <tr>
                    <td>User number</td>
                    <td><c:out value="${user.id}"/></td>
                </tr>
                <tr>
                    <td>User name</td>
                    <td><c:out value="${user.userName}"/></td>
                </tr>
                <tr>
                    <td>User note</td>
                    <td><c:out value="${user.note}"/></td>
                </tr>
            </table>
        </center>
    </body>
</html>