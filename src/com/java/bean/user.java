package com.java.bean;

public class user {
    String id;
    String name;
    String password;
    String signcount;
    String signdata;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSigndata() {
        return signdata;
    }

    public String getSigncount() {
        return signcount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSigndata(String signdata) {
        this.signdata = signdata;
    }

    public void setSigncount(String signcount) {
        this.signcount = signcount;
    }
}
