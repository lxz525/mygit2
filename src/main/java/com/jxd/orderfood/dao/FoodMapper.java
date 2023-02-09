package com.jxd.orderfood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.orderfood.model.Dept;
import com.jxd.orderfood.model.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FoodMapper extends BaseMapper<Food> {
    List<Food> getAllFood();

    IPage<Dept> getAllFood2(IPage<Dept> pages, Map<String, String> map);

    boolean insertFood(Food food);

    Food selectFoodOne(Integer foodno, String foodname);

    boolean updateFood(Food food);

    boolean deleteFood(List<String> foodnos);
}
