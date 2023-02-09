package com.jxd.orderfood.model;

/**
 * @ClassName OrderInfo_emp
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/29
 * @Version 1.0
 */
public class OrderInfo_emp {
    /**
     * 订单——订餐人员关系类
     */
    private Integer reservationno;//订单编号
    private String empno;//员工编号

    public OrderInfo_emp() {
    }

    public OrderInfo_emp(Integer reservationno, String empno) {
        this.reservationno = reservationno;
        this.empno = empno;
    }

    public Integer getReservationno() {
        return reservationno;
    }

    public void setReservationno(Integer reservationno) {
        this.reservationno = reservationno;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }
}
