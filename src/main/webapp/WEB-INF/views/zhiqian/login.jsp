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
    out.println(request.getAttribute("message"));
    }
    %>
<%
  Cookie[] allCookies=request.getCookies();
  String username="",password="",rememberMevale"";
  if(!(request.getAttribute("message")==null)){
      out.println(request.getAttribute("message"));
  }
%>
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVal="";
    if(allCookies!=null){
        for (Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }
        }
    }


%>
<form method="post" action="login">
            username:<input  type="text" name="Username" value="<%=username%>"><br/>
            password:<input  type="password" name="password" value="<%=password%>><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1") ?"checked":""%>checked/>RememberMe<br/>
            <input  type="submit" value="Submit"/>
        </form>
        <%@include file="zhiqian/footer.jsp"%>

