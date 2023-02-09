package com.jxd.orderfood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.User;

import java.util.List;
import java.util.Map;

public interface IEmpService extends IService<Emp> {

    Map<String, Object> getOrderList(Map<String,String> map);

    String getDnameByUname(String uname);

    String getDeptEmpByUname(String uname);

    Map<String, Object> getEmp(String uname);

    List<Emp> getEmpsByDname(String dname);

    boolean updateEmp(Map<String, Object> map);

    List<Integer> getEmpByDeptno(int[] deptnos);

    Map<String, Object> getEmpList(Map<String, String> map);

    boolean addEmp(Map<String, String> map);


    boolean deleteEmpByEnames(List<String> enames);


    Map<String, Object> getEmpByEname(String ename);

    boolean editEmp(Map<String, String> map);
}
