package com.caoyang.controller;

import Dao.ProductDao;
import com.caoyang.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "ShopServlet", value = "/ShopServlet")
public class ShopServlet extends HttpServlet {
        Connection con=null;
        @Override
                public  void init() throws ServletException{
            super.init();
            con=(Connection) getServletContext().getAttribute("con");
        }
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Product> productList = productDao.findAll(con);
            request.setAttribute("categoryList",categoryList);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }


            ProductDao productDao=new ProductDao();
            try {
                if (request.getParameter("categoryId") == null) {
                    List<Product> productList = productDao.findAll(con);
                    request.setAttribute("productList", productList);
                }
                eLse {
                    int catId=Integer.parseInt(request.getParameter("categoryId");
                   List<Product> productList =  productDao.findByCategoryId(catId,con)
                    request.setAttribute("productList", productList);
                }
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }




        String path="WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
