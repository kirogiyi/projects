<%--
  Created by IntelliJ IDEA.
  User: kirogiyi
  Date: 2019-03-21
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formatter</title>
</head>
<body>
    <form action="./commit" method="post">
        <table>
            <tr>
                <td>Date(yyyy-MM-dd)</td>
                <td>
                    <input type="text" name="date" value="2017-08-08"/>
                </td>
            </tr>
            <tr>
                <td>Amount(#,###.##)</td>
                <td>
                    <input type="text" name="number" value="1,234,567.89"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
