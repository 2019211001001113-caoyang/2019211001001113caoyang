<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/3/12
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">go to ecjtu</a><!-- method is GET-->
<form method="get"> <!--what is method when we use form?-->
    Name :<input type="text" name= "name"><br/>
    ID :<input type="text" name="id"><br/>
    <input type="submit" value="send data to server"/>
</form>
</body>
</html>