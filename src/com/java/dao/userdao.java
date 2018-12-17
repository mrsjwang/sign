package com.java.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.java.bean.user;

public class userdao {
   protected Connection conn=news.getConn();
    public user sign(user user) throws SQLException {
        String sql = "select * from student_tbl  where student_name=?+student_password=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user = new user();
            String id = rs.getString("student_id");
            String name = rs.getString("student_name");
            String password = rs.getString("student_password");
            user.setId(id);
            user.setName(name);
            user.setPassword(password);
        }
        return user;
    }
    public void signin(user user)throws Exception{
        String sql="insert into usign(student_name, sign_data,sign_count)values(?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,user.getName());
        ps.setString(2,user.getSigndata());
        ps.setString(3,user.getSigncount());
        boolean b = ps.execute();
        if (!b) {
            System.out.println(user.getName() + "签到成功");
        } else {
            System.out.println(user.getName() + "签到失败");
        }

    }
    public List<user> select()throws Exception{
     String sql="select *from student_tbl";
        Statement statement=conn.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        List<user> list=new ArrayList<>();
        while (rs.next()){
            String id=rs.getString("student_id");
            String name=rs.getString("student_name");
            String password=rs.getString("student_password");
            user user=new user();
            user.setId(id);
            user.setName(name);
            user.setPassword(password);
            list.add(user);
        }
        return list;
    }
}
