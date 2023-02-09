package com.jxd.orderfood.model;

/**
 * @ClassName OrderInfo_emp
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/29
 * @Version 1.0
 */
public class Food {

    /**
     * 餐品信息类
     */
    private Integer foodno;//餐品编号
    private String foodname;//餐品名称
    private Double price;//单价
    private Integer delflag;

    public Food() {
    }

    public Food(Integer foodno, String foodname, Double price, Integer delflag) {
        this.foodno = foodno;
        this.foodname = foodname;
        this.price = price;
        this.delflag = delflag;
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }

    public Integer getFoodno() {
        return foodno;
    }

    public void setFoodno(Integer foodno) {
        this.foodno = foodno;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
