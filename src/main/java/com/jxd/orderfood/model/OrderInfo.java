package com.jxd.orderfood.model;

/**
 * @ClassName OrderInfo
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/29
 * @Version 1.0
 */
public class OrderInfo {
    /**
     * 订单类
     */
    private Integer reservationno;//订餐申请编号
    private String applicationtime;//申请时间
    private Integer empno;//申请人编号
    private String type;//订餐类型（午餐/晚餐）
    private Integer orderedcount;//订餐数量
    private Double total;//总金额
    private Integer state;//状态（未提交/待部门确认/待系统确认/完成）
    private String remarks;//备注

    public OrderInfo() {
    }

    public OrderInfo(Integer reservationno, String applicationtime, Integer empno, String type, Integer orderedcount, Double total, Integer state, String remarks) {
        this.reservationno = reservationno;
        this.applicationtime = applicationtime;
        this.empno = empno;
        this.type = type;
        this.orderedcount = orderedcount;
        this.total = total;
        this.state = state;
        this.remarks = remarks;
    }

    public Integer getReservationno() {
        return reservationno;
    }

    public void setReservationno(Integer reservationno) {
        this.reservationno = reservationno;
    }

    public String getApplicationtime() {
        return applicationtime;
    }

    public void setApplicationtime(String applicationtime) {
        this.applicationtime = applicationtime;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrderedcount() {
        return orderedcount;
    }

    public void setOrderedcount(Integer orderedcount) {
        this.orderedcount = orderedcount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
