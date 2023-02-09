package com.jxd.orderfood.model;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/29
 * @Version 1.0
 */
public class Dept {
    /**
     * 部门类
     */
    private Integer deptno;//部门号
    private String dname;//部门号
    private Integer delflag;

    public Dept() {
    }

    public Dept(Integer deptno, String dname, Integer delflag) {
        this.deptno = deptno;
        this.dname = dname;
        this.delflag = delflag;
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
    
}
