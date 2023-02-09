package com.jxd.orderfood.controller;

import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.User;
import com.jxd.orderfood.service.IEmpService;
import com.jxd.orderfood.service.IOrderInfoService;
import com.jxd.orderfood.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpController
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/28
 * @Version 1.0
 */
@RestController
public class EmpController {
    @Autowired
    private IEmpService empService;
    @Autowired
    private IOrderInfoService orderInfoService;
    @Autowired
    private IUserService userService;

    //登录页

    /**
     * 登录验证
     *
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public User login(@RequestBody User user) {
        User user1 = userService.getUserByUnameAndPwd(user.getUname(), user.getPassword());
        return user1;
    }

    //主页

    /**
     * 获取员工信息
     *
     * @param uname
     * @return
     */
    @RequestMapping("/getEmp")
    public Map<String, Object> getEmp(String uname) {
        Map<String, Object> map = empService.getEmp(uname);
        return map;
    }

    /**
     * 修改个人信息
     *
     * @param map
     * @return
     */
    @RequestMapping("/updateEmp")
    public String updateEmp(@RequestBody Map<String, Object> map) {
        boolean iss = empService.updateEmp(map);
        return iss ? "success" : "fail";
    }

    /**
     * 修改个人密码
     *
     * @param map
     * @return
     */
    @RequestMapping("/updateEmpPwd")
    public String updateEmpPwd(@RequestBody Map<String, Object> map) {
        boolean iss = userService.updateUserPwd(map);
        return iss ? "success" : "fail";
    }

    //个人订餐页

    /**
     * 查询订餐记录
     *
     * @param map
     * @return
     */
    //也用于订餐确认页
    @RequestMapping("/getOrderList")
    public Map<String, Object> getOrderList(@RequestBody Map<String, String> map) {
        Map<String, Object> map1 = empService.getOrderList(map);
        return map1;
    }

    //.......

    /**
     * 通过用户名获取员工所属部门
     *
     * @param uname
     * @return
     */
    @RequestMapping("/getDname")
    public String getDnameByUname(@RequestBody String uname) {
        return empService.getDnameByUname(uname);
    }


    @RequestMapping("/delOrderRecords")
    @Transactional  // 事务
    public String delOrderRecords(@RequestBody List<String> list) {

        boolean isSuccOrderInfo1 = orderInfoService.delOrder(list);
        boolean isisSuccOrderFoodInfo1 = orderInfoService.delOrderFoodInfo1(list);
        boolean isisSuccOrderInfo_Emp1 = orderInfoService.delOrderInfo_Emp1(list);
        return isSuccOrderInfo1 && isisSuccOrderFoodInfo1 && isisSuccOrderInfo_Emp1 ? "success" : "fail";
    }
}