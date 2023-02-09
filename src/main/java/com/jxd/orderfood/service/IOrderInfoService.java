package com.jxd.orderfood.service;

import java.util.List;
import java.util.Map;

public interface IOrderInfoService {
    boolean insertOrder(Map<String, Object> map);

    boolean insertOrderFoodInfo(String reservationno ,Map<String, Object> map);

    boolean insertOrderInfo_Emp(String reservationno ,Map<String, Object> map);

    boolean updateOrderState(Map<String, Object> map);

    boolean delOrder(List<String> list);
    boolean delOrderFoodInfo1(List<String> list);

    boolean delOrderInfo_Emp1(List<String> list);

    boolean delOrderFoodInfo(String reservationno);

    boolean delOrderInfo_Emp(String reservationno);

    List<String> getOrderEmpnos(Map<String, Object> map);

    List<Map<String, Object>> getOrderInfo(List<String> list);

//    boolean updateOrderState2(List<String> list);
}
