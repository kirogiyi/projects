<%--
  Created by IntelliJ IDEA.
  User: kirogiyi
  Date: 2019-03-20
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../../easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="../../easyui/">
    <script type="text/javascript" src="../../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        function onSearch() {
            var userName = $("#userName").val();
            var note = $("#note").val();
            var params = {};
            if(userName != null && userName.trim() !== '') {
                params.userName = userName;
            }
            if(note !== null && note.trim() !== '') {
                params.note = note;
            }
            $("#dg").datagrid('load', params);
        }
    </script>
</head>
<body>
    <div style="margin: 20px 0"></div>
    <div class="easyui-layout" style="width: 100%; height: 350px;">
        <div data-options="region:'north'" style="height: 50px;">
            <form id="searchForm" method="post">
                <table>
                    <tr>
                        <td>User Name</td>
                        <td>
                            <input id="userName" name="userName" class="easyui-textbox"
                                   data-options="prompt: 'Input username...'"
                                   style="width: 100%; height: 32px">
                        </td>
                        <td>Remark</td>
                        <td>
                            <input id="note" name="note" class="easyui-textbox"
                                   data-options="prompt:'Input remark...'"
                                   style="width: 100%"; height="32px">
                        </td>
                        <td>
                            <a href="#" class="easyui-linkbutton"
                               data-options="iconCls: 'icon-search'" style="width: 80px"
                               onclick="onSearch()">Query</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div data-options="region:'center', title: 'User List', iconCls:'icon-ok'">
            <table id="dg" class="easyui-datagrid"
                   data-options="border:false,singleSelect:true,
                   fit:true, fitColumns:true">
                <thead>
                    <tr>
                        <th data-options="field:'id'" width="80">Number</th>
                        <th data-options="field:'userName'" width="100">
                            User name
                        </th>
                        <th data-options="field:'note'" width="80">Remark</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.userName}</td>
                            <td>${user.note}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
