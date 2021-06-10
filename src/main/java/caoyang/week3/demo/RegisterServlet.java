package caoyang.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet
public class RegisterServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        Connection con = (Connection) getServletContext().getAttribute("con");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username =request.getParameter("username");
        String password =request.getParameter("password");
        String email =request.getParameter("email");
        String gender =request.getParameter("gender");
        String birthDate =request.getParameter("birthDate");

     try {
         Connection con = null;
         statement st = (statement) con.createStatement();
         String sql = "insert into usertable(username,password,email,gender,birthdate)" +
                 "values('" + username + "','" + password + "','" + email + "','" + gender + "','" + birthDate + "')";
         System.out.println("sql" + sql);

         int n = ((Statement) st).executeUpdate(sql);
         System.out.println("n-->" + n);

        // response.sendRedirect("login.jsp");
        // request.getRequestDispatcher("userList.jsp").forward(request,response);
       // System.out.println("i am RegisterServlet-->dopost()--> after forward()");
//week  -  9
      response.sendRedirect("login");
     }catch (SQLException e){
         e.printStackTrace();
     }

        PrintWriter writer = response.getWriter();
        writer.println("<br> username :"+username);
        writer.println("<br> password :"+password);
        writer.println("<br> email :"+email);
        writer.println("<br> gender :"+gender);
        writer.println("<br> birth Date "+birthDate);
        writer.close();


    }
    }

