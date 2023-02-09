package com.jxd.orderfood.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.orderfood.dao.FoodMapper;
import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Food;
import com.jxd.orderfood.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FoodServiceImpl
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/1/31
 * @Version 1.0
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements IFoodService {
    @Autowired
    private FoodMapper foodMapper;
    @Override
    public List<Food> getAllFood() {
        return foodMapper.getAllFood();
    }

    @Override
    public Map<String, Object> getAllFood2(Map<String, String> map) {
        String page = (String)map.get("page");
        String limit = (String)map.get("limit");
        Map<String, Object> map1 = new HashMap(4);
        if(page != null && limit != null){
            IPage<Dept> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Dept> pageResult = foodMapper.getAllFood2(pages,map);
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
    public boolean addFood(Food food) {
        return foodMapper.insertFood(food);
    }

    @Override
    public boolean checkFoodname(String foodname) {
        //当foodname为null时，改为""
        if (foodname == null) {
            foodname = "";
        }
        //按照部门名称去数据库查询有没有数据
        Food food = foodMapper.selectFoodOne(null, foodname);
        if (food == null) {
            return false;
        } else {//否则，部门名称重复
            return true;
        }
    }

    @Override
    public Food getFoodOne(Integer foodno) {
        return foodMapper.selectFoodOne(foodno, null);
    }


    @Override
    public boolean editFood(Food food) {
        return foodMapper.updateFood(food);
    }

    @Override
    public boolean delFood(List<String> foodnos) {
        return foodMapper.deleteFood(foodnos);
    }
}
