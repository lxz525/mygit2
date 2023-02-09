package com.jxd.orderfood.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderFoodInfoMapper {
    boolean insertOrderFoodInfo(@Param("reservationno") String reservationno,@Param("list") List<Map> list);

    boolean delOrderFoodInfo(@Param("reservationno") String reservationno);

    boolean delOrderFoodInfo1(List<String> list);
}
