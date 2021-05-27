package com.caoyang.controller;

import Dao.ProductDao;
import com.caoyang.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "ProductListServlet", value = "/admin/ProductList")
public class ProductListServlet extends HttpServlet {
    Connection con=null;

    @Override
    public  void init() throws ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao = new ProductDao();
        try {
            List<Product> productList = productDao.findAll(con);
            request.setAttribute("productList", productList);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String path="WEB-INF/views/admin/productionList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }












    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
