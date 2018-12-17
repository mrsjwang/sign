<%--
  Created by IntelliJ IDEA.
  User: HY-lenovo
  Date: 2018/12/8
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户界面</title>
    <link type="text/css" rel="stylesheet" href="css/users.css" >
</head>
<body>
<h1 style="text-align: center ">用户界面</h1>
<div class="box">
    <ul class="ul">
        <li><a herf="">查询次数</a></li>
        <li><a herf="">个人资料</a></li>
        <li>欢迎${usernmae}}</li>
    </ul>
</div>
<div>
    <table>
        <tr>
            <td>序号</td>
            <td>用户名</td>
            <td>签到操作</td>
        </tr>
        <tr>
            <td>1</td>
            <td>${username}</td>
            <td>
                <form action="signin" method="post">
                    <input type="text" name="username">
                    <input type="number" name="data" value="NOW()">
                    <input type="number" name="count">
                    <input type="submit" value="提交">
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
