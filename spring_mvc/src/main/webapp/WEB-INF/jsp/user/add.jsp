<%--
  Created by IntelliJ IDEA.
  User: kirogiyi
  Date: 2019-03-21
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add user</title>
    <script src="https://code.jquery.com/jquery-3.2.0.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#submit").click(function() {
                var userName = $("#userName").val();
                var note = $("#note").val();
                if($.trim(userName) === '') {
                    alert("User name is not null.");
                    return;
                }
                var params = {
                    userName: userName,
                    note: note
                };
                $.post({
                    url: "./insert",
                    contentType: "application/json",
                    data: JSON.stringify(params),
                    success: function (result) {
                        if (result === null || result.id === null) {
                            alert("Insert failed.");
                            return;
                        }
                        alert("Insert success.")
                    }
                });
            });
        });
    </script>
</head>
<body>
    <div style="margin: 20px 0;"></div>
    <form id="insertForm">
        <table>
            <tr>
                <td>User name: </td>
                <td>
                    <input id="userName" name="userName"></td>
                </td>
            </tr>
            <tr>
                <td>Remark</td>
                <td><input id="note" name="note"></td>
            </tr>
            <tr>
                <td></td>
                <td align="right">
                    <input id="submit" type="button" value="Submit">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
