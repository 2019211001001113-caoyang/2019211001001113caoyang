package com.caoyang.controller;

import Dao.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "GetlmgServlet", value = "/Getlmg")
public class GetlmgServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException{
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        if (request.getParameter("id") != null)
            id = Integer.parseInt(request.getParameter("id"));
        ProductDao productDao = new ProductDao();
        byte[] imgByte = new byte[0];
        try {
            imgByte = productDao.getPictureById(id, con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (imgByte != null) {
            response.setContentType("image/gif");//which type of data send back
            OutputStream out = response.getOutputStream();
            out.write(imgByte);
            out.flush();
        }
    }


    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}