package com.jxd.orderfood.model;

/**
 * @ClassName User
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/30
 * @Version 1.0
 */
public class User {
    /**
     * 角色表
     */
    private String uname;//用户名
    private String password;//密码
    private String role;//角色
    private Integer delflag;
    public User() {
    }

    public User(String uname, String password, String role, Integer delflag) {
        this.uname = uname;
        this.password = password;
        this.role = role;
        this.delflag = delflag;
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
