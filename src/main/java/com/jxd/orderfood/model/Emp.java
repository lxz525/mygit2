package com.jxd.orderfood.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName OrderInfo_emp
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/29
 * @Version 1.0
 */
public class Emp {
    /**
     * 员工类
     */
    @TableId(value = "empno",type = IdType.AUTO)
    private Integer empno;//员工编号
    private String ename;//姓名
    private String sex;//性别
    private String tel;//电话
    private Integer deptno;//部门号
    private String job;//工作
    private Integer delflag;

    public Emp() {
    }

    public Emp(Integer empno, String ename, String sex, String tel, Integer deptno, String job, Integer delflag) {
        this.empno = empno;
        this.ename = ename;
        this.sex = sex;
        this.tel = tel;
        this.deptno = deptno;
        this.job = job;
        this.delflag = delflag;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }
}
