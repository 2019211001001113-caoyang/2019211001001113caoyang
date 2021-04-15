<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/4/8
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <%@include file="header.jsp"%>
            <h1>Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
    out.print("<h3>"+request.getAttribute("message")+"<h3>");
    }
    %>
<form method="post" action="login">
            username:<input  type="text" name="Username"><br/>
            password:<input  type="password" name="password"><br/>
            <input  type="submit" value="Submit"/>
        </form>
        <%@include file="footer.jsp"%>

