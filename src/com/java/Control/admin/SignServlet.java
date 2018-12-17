package com.java.Control.admin;

import com.java.bean.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.java.dao.admindao;
public class SignServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("gbk");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        List<user> list = new ArrayList<>();
        user user = new user();
        user.setName(name);
        user.setPassword(password);
        admindao ad=new admindao();
        user user1= null;
        try {
            user1 = ad.sign(user);
            list.add(user1);
            String na = user1.getName();
            String ps = user1.getPassword();  if (name.equals(na) && password.equals(ps)) {
                System.out.println("打印1");
                req.getRequestDispatcher("success.jsp").forward(req, resp);

            } else {
                req.getRequestDispatcher("fail.jsp").forward(req, resp);}

            } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }
}
