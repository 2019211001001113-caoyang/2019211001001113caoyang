package caoyang.week5.demo;

import com.caoyang.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {


    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();

        ///tODO 1:GET 4 CONTEXT PARAM - DRIVER , URL , USERNAME , PASSWORD
        //TODO 2: GET JDBC connection
        con = (Connection) getServletContext().getAttribute("con");


        //only one connection
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        //String username="sa";
        //String password="123456";
        //code like this is bad way --because change in not easy
        //for example change password of db = change in java code

        //get servletconfig --> getInitParameters --no change
        String driver= getServletContext().getInitParameter("driver");
        String url= getServletContext().getInitParameter("url");
        String username= getServletContext().getInitParameter("username");
        String password= getServletContext().getInitParameter("password");


        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con); //ok(use java code) -ok (use config in web.xml) -ok --use(@webservlet)
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out= response.getWriter();
        //TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        UserDao userDao=new UserDao();
        try{
         User user=  userDao.findByUsernamePassword(con,username,password);
      if(user!=null){
          request.setAttribute("user",user);
          request.getRequestDispatcher("WEB-INF/views/useInfo.jsp").forward(request,response);
      }else {
          request.setAttribute("message","Username or Password Error!!!");
          request.getRequestDispatcher("login.jsp").forward(request,response);
      }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }




        //TODO 4: VALIDATE USER - SELEECT * FROM USERTABLE WHERE USERNAME='XXX'
        // AND PASSWORD='YYY'
       /* String sql="select id,username,password,email,gender,birthdate from usertable where username='"+username+"' and password='";
        try {
            ResultSet rs =con.createStatement().executeQuery(sql);
        if(rs.next()){

            request.setAttribute("id",rs.getInt("id"));
            request.setAttribute("uesrname",rs.getInt("username"));
            request.setAttribute("password",rs.getInt("password"));
            request.setAttribute("gender",rs.getInt("gender"));
            request.setAttribute("birthdate",rs.getInt("birthdate"));
            request.getRequestDispatcher("userInfo.jsp").forward(request,response);

        }else {
         request.setAttribute("message","Username or Password Error!!!");
         request.getRequestDispatcher("login.jsp").forward(request,response);

        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(!rs.next()){
                writer.println("Login Success!!!");
                writer.println("Welcome ChenLiang");

            }
            else
            {
                writer.println("密码或用户名错误");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
*/