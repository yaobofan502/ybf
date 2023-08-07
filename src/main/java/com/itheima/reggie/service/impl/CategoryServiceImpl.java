package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.mapper.CategoryMapper;
import com.itheima.reggie.service.CategoryService;
import com.itheima.reggie.service.DishService;
import com.itheima.reggie.service.SetmealService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Resource
    private DishService dishService;

    @Resource
    private SetmealService setmealService;

    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(Dish::getCategoryId, id);
        LambdaQueryWrapper<Setmeal> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(Setmeal::getCategoryId, id);
        //该分类信息下有菜品或者套餐关联
        if(dishService.count(queryWrapper1) > 0 || setmealService.count(queryWrapper2) > 0) {
            throw new CustomException("该套餐或菜品已被关联");
        }
        //菜品未被关联 正常删除
        super.removeById(id);
    }

//    @Override
//    public void remove(Long ids) {
//        LambdaQueryWrapper<Dish> queryWrapper1 = new LambdaQueryWrapper<>();
//        queryWrapper1.eq(Dish::getCategoryId, ids);
//        LambdaQueryWrapper<Setmeal> queryWrapper2 = new LambdaQueryWrapper<>();
//        queryWrapper2.eq(Setmeal::getCategoryId, ids);
//        //该分类信息下有菜品或者套餐关联
//        if(dishService.count(queryWrapper1) > 0 || setmealService.count(queryWrapper2) > 0) {
//            throw new CustomException("该套餐或菜品已被关联");
//        }
//        //菜品未被关联
//        super.removeById(ids);
//    }
}
