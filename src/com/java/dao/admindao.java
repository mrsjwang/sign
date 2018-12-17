package com.java.dao;


import com.java.bean.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class admindao {
    private Connection conn= news.getConn();
    public void adduser(user user)throws Exception {
        String sql = "insert into student_tbl (student_name,student_password)values(?,?)";
        java.sql.PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        boolean b = ps.execute();
        if (!b) {
            System.out.println(user.getName() + "创建成功");
        } else {
            System.out.println(user.getName() + "创建失败");
        }

    }
    public void dele(int id ) throws Exception{
        String sql="delete from student_tbl where student_id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
        ps.close();
    }
    public user sign(user user)throws Exception{
        String sql="select * from auser where auser_name=?+auser_password=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,user.getName());
        ps.setString(2,user.getPassword());
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            String id=rs.getString("auser_id");
            String name=rs.getString("auser_name");
            String password=rs.getString("auser_password");
            user.setId(id);
            user.setName(name);
            user.setPassword(password);

        }
        return user;


    }
    public void update(user user)throws SQLException {
        String sql="update student_tbl  set student_name=? student_password=?where student_id=?,";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,user.getName());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getId());
        boolean b = ps.execute();
        if (!b) {
            System.out.println(user.getName() + "修改成功");
        } else {
            System.out.println(user.getName() + "修改失败");
        }
    }
    public List<user> sele()throws Exception{
        String sql="select * from student_tbl";
        Statement  statement=conn.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        List<user> list=new ArrayList<>();
        while (rs.next()){
            user user=new user();
            String id=rs.getString("student_id");
            String name=rs.getString("student_name");
            String password=rs.getString("student_password");
            user.setId(id);
            user.setName(name);
            user.setPassword(password);
            list.add(user);
        }

        return list;

    }
    public user select()throws Exception{
        String sql=" SELECT student_name, SUM(sign_count) as signin_count FROM usign GROUP BY student_name WITH ROLLUP";
        Statement statement=conn.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        user user=new user();
        while (rs.next()){
          String name=  rs.getString("student_name");
           String signcount= rs.getString("signin_count");
           user.setName(name);
           user.setSigncount(signcount);
        }
        return user;
    }
}
