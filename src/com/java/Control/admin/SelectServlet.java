package com.java.Control.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.java.bean.user;

import com.java.dao.admindao;

public class SelectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("gbk");
        req.setCharacterEncoding("UTF-8");
        admindao ad=new admindao();
        try {
            List<user> list=ad.sele();
            req.setAttribute("list" ,list);
            req.getRequestDispatcher("admin.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req,resp);
    }
}
