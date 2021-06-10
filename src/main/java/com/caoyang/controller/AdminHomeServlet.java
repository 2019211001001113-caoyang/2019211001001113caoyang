package com.caoyang.controller;

import com.caoyang.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet", value = "/AdminHomeServlet")
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);//return session or nuLl (n
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if ("admin".equals(user.getUsername())) {//admin username must be in table
                request.getRequestDispatcher(".. /WEB-INF/views/admin/index.jsp").forward(request, response);
            } else {
                session.invalidate();//ki1l session
                request.setAttribute("message", "Unauthorized Access admin module!!!");
                request.getRequestDispatcher(".. /WEB- INF/views/Login. jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "PLease Login as admin!! !");
            request.getRequestDispatcher(".. /WEB- INF/views/Login. jsp").forward(request, response);
        }

    }
}
