package com.jxd.orderfood.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderInfoMapper {
    /**
     * 保存订餐记录
     * @param map
     * @return
     */
    boolean insertOrder(@Param("orderMap") Map<String, Object> map);

    /**
     * 提交时修改订单状态
     * @param map
     * @return
     */
    boolean updateOrderState(@Param("map") Map<String, Object> map);

    boolean delOrder(List<String> list);

//    boolean updateOrderState2(List<String> list);
}
