package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.DeptMapper;
import com.jxd.orderfood.dao.EmpMapper;
import com.jxd.orderfood.dao.OrderInfoMapper;
import com.jxd.orderfood.dao.UserMapper;
import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.OrderInfo;
import com.jxd.orderfood.model.User;
import com.jxd.orderfood.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author lixiaoru
 * @Date 2020/11/18
 * @Version 1.0
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 获得订单信息
     * @param queryMap
     * @return
     */
    @Override
    public Map<String, Object> getOrderList(Map<String,String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
//        String uname = queryMap.get("uname");
//        String date1 = queryMap.get("date1");
//        String date2 = queryMap.get("date2");
        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<OrderInfo> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
//            IPage<OrderInfo> pageResult = empMapper.getAllEmpOrderList(pages,uname,date1,date2);
            IPage<OrderInfo> pageResult = empMapper.getOrderList(pages,queryMap);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
            return map;
        }

    }

    /**
     * 修改个人信息
     * @param map
     * @return
     */
    @Override
    public boolean updateEmp(Map<String, Object> map) {
        return empMapper.updateEmp(map);
    }

    @Override
    public List<Integer> getEmpByDeptno(int[] deptnos) {
        List<Integer> deptnoList = new ArrayList<>();
        for (int deptno : deptnos) {
            //根据部门编号查询员工集合，如果员工集合大小为0，
            //说明该部门没有员工，否则该部门有员工
            List<Emp> emps = empMapper.selectEmpByDeptno(deptno);
            if (emps.size() != 0) {
                deptnoList.add(deptno);
            }
        }
        return deptnoList;
    }

    @Override
    public Map<String, Object> getEmpList(Map<String, String> map) {
        String page = (String)map.get("page");
        String limit = (String)map.get("limit");
        Map<String, Object> map1 = new HashMap(4);
        if(page != null && limit != null){
            IPage<Emp> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Emp> pageResult = empMapper.getEmpList(pages,map);
            map1.put("count",pageResult.getTotal());
            map1.put("data",pageResult.getRecords());
            map1.put("code",0);
            return map1;
        }else{
            map1.put("data", (Object)null);
            map1.put("code", "500");
            map1.put("msg", "参数不符");
            map1.put("count", (Object)null);
            return map1;
        }
    }

    @Override
    public boolean addEmp(Map<String, String> map) {
        return empMapper.insertEmp(map);
    }

    @Override
    public boolean deleteEmpByEnames(List<String> enames) {
        return empMapper.deleteEmpByEnames(enames);
    }

    @Override
    public Map<String, Object> getEmpByEname(String ename) {
        return empMapper.selectEmpByEname(ename);
    }

    @Override
    public boolean editEmp(Map<String, String> map) {
        return empMapper.updateEmp2(map);
    }


    /**
     * 通过用户名获取员工所属部门
     * @param uname
     * @return
     */
    @Override
    public String getDnameByUname(String uname) {
        return empMapper.getDnameByUname(uname);
    }

    /**
     * 获取该员工所在部门的所有员工
     * @param uname
     * @return
     */
    @Override
    public String getDeptEmpByUname(String uname) {
        return empMapper.getDeptEmpByUname(uname);
    }

    /**
     * 获取员工信息
     * @param uname
     * @return
     */
    @Override
    public Map<String, Object> getEmp(String uname) {
        return empMapper.getEmp(uname);
    }

    /**
     * 查询某部门所有员工
     * @param dname
     * @return
     */
    @Override
    public List<Emp> getEmpsByDname(String dname) {
        return deptMapper.getEmpsByDname(dname);
    }



}
