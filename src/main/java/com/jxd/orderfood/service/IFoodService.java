package com.jxd.orderfood.service;

import com.jxd.orderfood.model.Food;

import java.util.List;
import java.util.Map;

public interface IFoodService {
    List<Food> getAllFood();

    //分页
    Map<String, Object> getAllFood2(Map<String, String> map);

    boolean addFood(Food food);

    boolean checkFoodname(String foodname);

    Food getFoodOne(Integer foodno);

    boolean editFood(Food food);

    boolean delFood(List<String> foodnos);
}
