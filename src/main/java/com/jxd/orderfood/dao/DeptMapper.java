package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface DeptMapper extends BaseMapper<Dept> {
    List<Emp> getEmpsByDname(@Param("dname") String dname);
    IPage<Dept> getAllDept(IPage<Dept> page, @Param("queryMap") Map<String, String> queryMap);

    boolean deleteDept(int[] deptnos);

    boolean insertDept(Dept dept);

    Dept selectDeptOne(@Param("deptno") Integer deptno,
                       @Param("dname") String dname);

    boolean updateDept(Dept dept);

    List<Dept> getAllDept2();
}
