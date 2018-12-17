package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class news {
    private static String Driver="com.mysql.jdbc.Driver";
    private static  String url="jdbc:mysql://localhost:3306/student?useSSL=false";
    private static String user="root";
    private static String password="123456";
    private  static Connection conn=null;
    static {


        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, user,password );
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Connection getConn() {
        return conn;
    }
}
