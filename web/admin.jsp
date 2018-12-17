<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>管理员界面</title>
</head>
<body>
<table>
    <tr>
        <td>序号</td>
        <td>用户名</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="user" >
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td><a href="dele?id=${user.id}">删除</a> <a href="">修改</a> </td>
    </tr>
    </c:forEach>
</table>
<form action="" method="post">
    <input type="submit" value="查询">
</form>


</body>
</html>
