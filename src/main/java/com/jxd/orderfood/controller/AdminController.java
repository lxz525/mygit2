package com.jxd.orderfood.controller;

import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.Food;
import com.jxd.orderfood.service.IDeptService;
import com.jxd.orderfood.service.IEmpService;
import com.jxd.orderfood.service.IFoodService;
import com.jxd.orderfood.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/2/1
 * @Version 1.0
 */
@RestController
public class AdminController {
    @Autowired
    private IDeptService deptService;

    @Autowired
    private IEmpService empService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IFoodService foodService;

    //部门管理
    @RequestMapping("/deptList")
    public Map<String, Object> deptList(@RequestBody Map<String, String> map) {
        Map<String,Object> map1 = deptService.getAllDept(map);
        return map1;
    }
    @RequestMapping("/getEmpByDeptnos")
    public List<Integer> getEmpByDeptno(@RequestBody int[] deptnos) {
        return empService.getEmpByDeptno(deptnos);
    }
    @RequestMapping("/delDept")
    public boolean delDept(@RequestBody int[] deptnos) {
        return deptService.delDept(deptnos);
    }
    @RequestMapping("/addDept")
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    /**
     * 验证部门名称是否重复
     * @param dname
     * @return
     */
    @RequestMapping("/checkDeptName/{dname}")
    public boolean checkDeptName(@PathVariable("dname") String dname) {
        return deptService.checkDeptName(dname);
    }

    @RequestMapping("/getDeptOne/{deptno}")
    public Dept getDeptOne(@PathVariable("deptno") Integer deptno) {
        return deptService.getDeptOne(deptno);
    }
    @RequestMapping("/editDept")
    public boolean editDept(@RequestBody Dept dept) {
        return deptService.editDept(dept);
    }


    //员工管理

    @RequestMapping("/empList")
    public Map<String, Object> empList(@RequestBody Map<String, String> map) {
        Map<String,Object> map1 = empService.getEmpList(map);
        return map1;
    }

    @RequestMapping("/deptList2")
    public List<Dept> deptList() {
        List<Dept> list = deptService.getAllDept2();
        return list;
    }

    @RequestMapping("/checkEname/{ename}")
    public boolean checkEame(@PathVariable("ename") String ename) {
        Map<String,Object> map1 = empService.getEmp(ename);
//        if(map1.size() > 0) {
//            return true;
//        }
        if (map1 == null){
            return false;
        } else {
            return true;
        }
    }
    @RequestMapping("/addEmp")
    @Transactional  // 事务
    public boolean addEmp(@RequestBody Map<String, String> map) {
        boolean iss1 = empService.addEmp(map);
        boolean iss2 = userService.addUser(map);
        return iss1 && iss2;
    }
    @RequestMapping("/delEmp")
    @Transactional  // 事务
    public boolean delEmp(@RequestBody List<String> enames) {
        boolean iss1 = empService.deleteEmpByEnames(enames);
        boolean iss2 = userService.deleteUserByEnames(enames);
        return iss1 && iss2;
    }

    @RequestMapping("/getEmpOne/{ename}")
    public Map<String,Object> getEmpOne(@PathVariable("ename") String ename) {
        return empService.getEmpByEname(ename);
    }

    @RequestMapping("/editEmp")
    public boolean editEmp(@RequestBody Map<String, String> map) {
        boolean iss1 = empService.editEmp(map);
        boolean iss2 = userService.editUser(map);
        return iss1 && iss2;
    }

    @RequestMapping("/updatePwd/{ename}")
    public boolean updateEmpPwd(@PathVariable("ename") String ename) {
        Map<String, Object> map = new HashMap<>();
        map.put("ename",ename);
        map.put("newPwd","123456");
        boolean iss = userService.updateUserPwd(map);
        return iss ;
    }


    //餐品管理
    @RequestMapping("/foodList2")
    public Map<String, Object> foodList(@RequestBody Map<String, String> map) {
        Map<String,Object> map1 = foodService.getAllFood2(map);
        return map1;
    }

    @RequestMapping("/addFood")
    public boolean addFood(@RequestBody Food food) {
        return foodService.addFood(food);
    }

    /**
     * 验证餐品名称是否重复
     * @param foodname
     * @return
     */
    @RequestMapping("/checkFoodname/{foodname}")
    public boolean checkFoodame(@PathVariable("foodname") String foodname) {
        return foodService.checkFoodname(foodname);
    }

    @RequestMapping("/getFoodOne/{foodno}")
    public Food getFoodOne(@PathVariable("foodno") Integer foodno) {
        return foodService.getFoodOne(foodno);
    }
    @RequestMapping("/editFood")
    public boolean editFood(@RequestBody Food food) {
        return foodService.editFood(food);
    }
    @RequestMapping("/delFood")
    public boolean delFood(@RequestBody List<String> foodnos) {
        return foodService.delFood(foodnos);
    }
}
