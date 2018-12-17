package com.java.Control.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.java.bean.user;
import com.java.dao.userdao;

public class LoginServlet extends HttpServlet {
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
        userdao ud=new userdao();
        try {
            user user1 = ud.sign(user);
            list.add(user1);
            String na = user1.getName();
            String ps = user1.getPassword();
            if (name.equals(na) && password.equals(ps)) {
                System.out.println("打印1");

                req.getRequestDispatcher("user.jsp").forward(req, resp);

            } else {
                req.getRequestDispatcher("fail.jsp").forward(req, resp);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     doPost(req,resp);
    }
}
