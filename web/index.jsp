<%--
  Created by IntelliJ IDEA.
  User: HY-lenovo
  Date: 2018/12/8
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
<form action="login" method="post" name="frmLogin">
 用户名:<input type="text" name="username">
  密码:<input type="password" name="password">
  <input type="submit" value="用户登录" onClick="return validateLogin()" >
</form>
<a href="ad_login.jsp">管理员登录</a>
<script language="javascript">
    function validateLogin(){
        var sUserName = document.frmLogin.username.value ;
        var sPassword = document.frmLogin.password.value ;
        if (sUserName ==""){
            alert("请输入用户名!");
            return false ;
        }

        if (sPassword ==""){
            alert("请输入密码!");
            return false ;
        }
    }
</script>
  </body>
</html>
