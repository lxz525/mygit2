package com.jxd.orderfood.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderInfo_EmpMapper {
    boolean insertOrderInfo_Emp(@Param("reservationno") String reservationno, @Param("list") List<Integer> list);

    boolean delOrderInfo_Emp(@Param("reservationno") String reservationno);

    List<String> getOrderEmpnos(@Param("map") Map<String, Object> map);

    boolean delOrderInfo_Emp1(List<String> list);
}
