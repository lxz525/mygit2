package com.jxd.orderfood.controller;

import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.Food;
import com.jxd.orderfood.service.IEmpService;
import com.jxd.orderfood.service.IFoodService;
import com.jxd.orderfood.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderInfoController
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/31
 * @Version 1.0
 */
@RestController
public class OrderInfoController {
    @Autowired
    private IEmpService empService;
    @Autowired
    private IOrderInfoService orderInfoService;
    @Autowired
    private IFoodService foodService;


    //加班订餐页
    /**
     * 查询所有餐品种类
     * @return
     */
    @RequestMapping("/foodList")
    public List<Food> deptList(){
        List<Food> list = foodService.getAllFood();
        return list;
    }
    //加班订餐页
    /**
     * 查询某部门下所有员工
     * @param dname
     * @return
     */
    @RequestMapping("/getEmpsByDname")
    public List<Emp> getEmpsByDname(String dname){
        List<Emp> list= empService.getEmpsByDname(dname);
        return list;
    }

    /**
     * 获得已经被订餐人员
     * @param map
     * @return
     */
    @RequestMapping("/getOrderEmpnos")
    public List<String> getOrderEmpnos(@RequestBody Map<String,Object> map){
        List<String> empnos = orderInfoService.getOrderEmpnos(map);
        return empnos;
    }

    /**
     * 保存提交订餐订单
     * @param map
     * @return
     */
    @RequestMapping("/insertOrder")
    @Transactional  // 事务
    public String insertOrder(@RequestBody Map<String,Object> map){
        String orderState = (String) map.get("state");
        if (map.get("reservationno") == "") {
//                System.out.println(123);
            boolean isSuccOrderInfo = orderInfoService.insertOrder(map);
            String reservationno = (String)map.get("reservationno");
            boolean isisSuccOrderFoodInfo = orderInfoService.insertOrderFoodInfo(reservationno, map);
            boolean isisSuccOrderInfo_Emp = orderInfoService.insertOrderInfo_Emp(reservationno, map);
            return isSuccOrderInfo && isisSuccOrderFoodInfo && isisSuccOrderInfo_Emp ? reservationno : "fail";
        } else {
            String reservationno = Integer.toString((Integer)map.get("reservationno"));
//                String reservationno = (String)map.get("reservationno");
//                boolean isSuccOrderInfo1 = orderInfoService.delOrder(reservationno);
            boolean isSuccOrderInfo1 = orderInfoService.updateOrderState(map);
            boolean isisSuccOrderFoodInfo1 = orderInfoService.delOrderFoodInfo(reservationno);
            boolean isisSuccOrderInfo_Emp1 = orderInfoService.delOrderInfo_Emp(reservationno);
            boolean isisSuccOrderFoodInfo2 = orderInfoService.insertOrderFoodInfo(reservationno,map);
            boolean isisSuccOrderInfo_Emp2 = orderInfoService.insertOrderInfo_Emp(reservationno,map);
            return isSuccOrderInfo1 && isisSuccOrderFoodInfo1 && isisSuccOrderInfo_Emp1 && isisSuccOrderFoodInfo2 && isisSuccOrderInfo_Emp2 ? reservationno : "fail";
        }
//        }
//
    }

    /**
     * 获取该员工所在部门的所有员工
     * @param uname
     * @return
     */
    @RequestMapping("/getDeptEmp")
    public String getDeptEmpByUname(@RequestBody String uname){
        return empService.getDeptEmpByUname(uname);
    }

    //订餐确认页
    /**
     * 获得餐品信息明细（OrderSure页面）
     * @param reservationnoList
     * @return
     */
    @RequestMapping("/getOrderInfo")
    List<Map<String, Object>> getOrderInfo(@RequestBody List<String> reservationnoList) {
        if (reservationnoList.size() == 0){
            return new ArrayList<>();
        }
        List<Map<String, Object>> list = orderInfoService.getOrderInfo(reservationnoList);
        return list;
    }

    /**
     * 订单审核修改订单状态
     * @param map
     * @return
     */
    @RequestMapping("/updOrderState")
    public String updOrderState(@RequestBody Map<String,Object> map){
        boolean isSuccOrderInfo = orderInfoService.updateOrderState(map);
        return isSuccOrderInfo ? "success" : "fail";
    }
}
