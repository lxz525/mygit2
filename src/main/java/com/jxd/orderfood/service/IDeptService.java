package com.jxd.orderfood.service;


import com.jxd.orderfood.model.Dept;

import java.util.List;
import java.util.Map;

public interface IDeptService{
    Map<String, Object> getAllDept(Map<String, String> map);

    boolean delDept(int[] deptnos);

    boolean addDept(Dept dept);

    boolean checkDeptName(String dname);

    Dept getDeptOne(Integer deptno);

    boolean editDept(Dept dept);

    List<Dept> getAllDept2();
}
