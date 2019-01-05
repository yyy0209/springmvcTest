package com.jmypackagee.pojo;

public class UserQ {
    private String name;
    private Integer pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPwd() {
        return pwd;
    }

    public void setPwd(Integer pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserQ{" +
                "name='" + name + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}
