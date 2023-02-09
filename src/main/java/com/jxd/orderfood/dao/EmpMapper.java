package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.OrderInfo;
import com.jxd.orderfood.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper extends BaseMapper<Emp> {
//    IPage<OrderInfo>  getAllEmpOrderList(IPage<OrderInfo> page, @Param("uname") String uname, @Param("date1") String date1, @Param("date2")String date2);
    IPage<OrderInfo> getOrderList(IPage<OrderInfo> page, @Param("queryMap") Map<String, String> queryMap);

    String getDnameByUname(String uname);

    String getDeptEmpByUname(String uname);

    Map<String, Object> getEmp(@Param("uname") String uname);

    List<Map<String, Object>> getOrderInfo(@Param("list") List<String> list);

    boolean updateEmp(@Param("map") Map<String, Object> map);

    List<Emp> selectEmpByDeptno(int deptno);


    IPage<Emp> getEmpList(IPage<Emp> pages, @Param("queryMap") Map<String, String> queryMap);

    boolean insertEmp(Map<String, String> map);

    boolean deleteEmpByEnames(List<String> enames);

    Map<String, Object> selectEmpByEname(String ename);

    boolean updateEmp2(Map<String, String> map);
}
