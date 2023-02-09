package com.jxd.orderfood.service.impl;

import com.jxd.orderfood.dao.EmpMapper;
import com.jxd.orderfood.dao.OrderFoodInfoMapper;
import com.jxd.orderfood.dao.OrderInfoMapper;
import com.jxd.orderfood.dao.OrderInfo_EmpMapper;
import com.jxd.orderfood.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderInfoImpl
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/31
 * @Version 1.0
 */
@Service
public class OrderInfoImpl implements IOrderInfoService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderFoodInfoMapper orderFoodInfoMapper;
    @Autowired
    private OrderInfo_EmpMapper orderInfo_empMapper;

    /**
     * 添加订餐记录
     * 新增订餐记录的同时新增订餐餐品信息
     * 添加一个订单对应多个员工关系表记录
     * @param map
     * @return
     */
    @Override
    public boolean insertOrder(Map<String, Object> map) {
        return orderInfoMapper.insertOrder(map);
    }
    @Override
    public boolean insertOrderFoodInfo(String reservationno ,Map<String, Object> map) {
        List<Map> list = (List<Map>)map.get("orderfoodinfo");
        return orderFoodInfoMapper.insertOrderFoodInfo(reservationno,list);
    }
    @Override
    public boolean insertOrderInfo_Emp(String reservationno ,Map<String, Object> map) {
        List<Integer> list = (List<Integer>)map.get("empnos");
        return orderInfo_empMapper.insertOrderInfo_Emp(reservationno,list);
    }

    /**
     * 修改订单信息
     * @param map
     * @return
     */
    @Override
    public boolean updateOrderState(Map<String, Object> map) {
        return orderInfoMapper.updateOrderState(map);
    }

    /**
     * 删除订餐记录
     * 删除订餐记录的同时删除订餐餐品信息
     * 删除一个订单对应多个员工关系表记录
     * @param list
     * @return
     */
    @Override
    public boolean delOrder(List<String> list) {
        return orderInfoMapper.delOrder(list);
    }

    @Override
    public boolean delOrderFoodInfo1(List<String> list) {
        return orderFoodInfoMapper.delOrderFoodInfo1(list);
    }

    @Override
    public boolean delOrderInfo_Emp1(List<String> list) {
        return orderInfo_empMapper.delOrderInfo_Emp1(list);
    }

    @Override
    public boolean delOrderFoodInfo(String reservationno) {
        return orderFoodInfoMapper.delOrderFoodInfo(reservationno);
    }

    @Override
    public boolean delOrderInfo_Emp(String reservationno) {
        return orderInfo_empMapper.delOrderInfo_Emp(reservationno);
    }

    @Override
    public List<String> getOrderEmpnos(Map<String, Object> map) {
        return orderInfo_empMapper.getOrderEmpnos(map);
    }

    @Override
    public List<Map<String, Object>> getOrderInfo(List<String> list) {
        return empMapper.getOrderInfo(list);
    }
//    @Override
//    public boolean updateOrderState2(List<String> list) {
//        return orderInfoMapper.updateOrderState2(list);
//    }
}
