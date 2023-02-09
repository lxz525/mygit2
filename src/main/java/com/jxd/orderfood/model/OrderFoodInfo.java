package com.jxd.orderfood.model;

/**
 * @ClassName OrderFoodInfo
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/29
 * @Version 1.0
 */
public class OrderFoodInfo {
    /**
     * 订餐餐品信息类
     */
    private Integer reservationno;//订餐申请编号
    private Integer foodno;//餐品编号
    private Integer count;//数量
    private Double price;//价格
    private String remarks;//备注

    public OrderFoodInfo() {
    }

    public OrderFoodInfo(Integer reservationno, String remarks, Double price, Integer foodno, Integer count) {
        this.reservationno = reservationno;
        this.remarks = remarks;
        this.price = price;
        this.foodno = foodno;
        this.count = count;
    }

    public Integer getReservationno() {
        return reservationno;
    }

    public void setReservationno(Integer reservationno) {
        this.reservationno = reservationno;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getFoodno() {
        return foodno;
    }

    public void setFoodno(Integer foodno) {
        this.foodno = foodno;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
