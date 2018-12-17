package com.java.Control.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.java.bean.user;
import com.java.dao.userdao;


public class SigninServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String date=req.getParameter("date");
        String count=req.getParameter("count");
        user user=new user();
        user.setName(name);
        user.setSigncount(count);
        user.setSigndata(date);
        userdao ud=new userdao();
        try {
            ud.signin(user);
            req.getRequestDispatcher("user.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req,resp);
    }
}
