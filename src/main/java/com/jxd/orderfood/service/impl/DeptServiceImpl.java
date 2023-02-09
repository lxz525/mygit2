package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.DeptMapper;
import com.jxd.orderfood.dao.EmpMapper;
import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.OrderInfo;
import com.jxd.orderfood.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DeptServiceImpl
 * @Description TODO
 * @Author lixiaoru
 * @Date 2020/11/18
 * @Version 1.0
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public Map<String, Object> getAllDept(Map<String, String> map) {
        String page = (String)map.get("page");
        String limit = (String)map.get("limit");
        Map<String, Object> map1 = new HashMap(4);
        if(page != null && limit != null){
            IPage<Dept> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Dept> pageResult = deptMapper.getAllDept(pages,map);
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
    public boolean delDept(int[] deptnos) {
        return deptMapper.deleteDept(deptnos);
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.insertDept(dept);
    }

    @Override
    public boolean checkDeptName(String dname) {
        //当dname为null时，改为""
        if (dname == null) {
            dname = "";
        }
        //按照部门名称去数据库查询有没有数据
        Dept dept = deptMapper.selectDeptOne(null, dname);
        //如果dept为null代表没有查到，部门名称不重复
        if (dept == null) {
            return false;
        } else {//否则，部门名称重复
            return true;
        }
    }

    @Override
    public Dept getDeptOne(Integer deptno) {
        //当部门编号为空时，返回null
//        if (deptno == null) {
//            return null;
//        }
        return deptMapper.selectDeptOne(deptno, null);
    }

    @Override
    public boolean editDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    @Override
    public List<Dept> getAllDept2() {
        return deptMapper.getAllDept2();
    }
}
