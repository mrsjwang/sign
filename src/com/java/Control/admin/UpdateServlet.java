package com.java.Control.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.java.bean.user;
import com.java.dao.admindao;
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String password=req.getParameter("password");
        String id=req.getParameter("id");
        user user=new user();
        user.setName(new String(name.getBytes("ISO-8859-1"),"UTF-8"));
        user.setPassword(new String(password.getBytes("ISO-8859-1"),"UTF-8"));
        user.setId(new String(id.getBytes("ISO-8859-1"),"UTF-8"));
        admindao ad=new admindao();
        try {
            ad.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     doPost(req,resp);
    }
}
