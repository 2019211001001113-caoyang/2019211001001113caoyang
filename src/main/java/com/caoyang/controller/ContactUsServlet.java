package com.caoyang.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("ContactUs")
public class ContactUsServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String path="/WEB-INF/views/contactUs.jsp";
request.getRequestDispatcher(path).forward(request,response);
    }
}
