package com.lagou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/9 9:12
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    /**
     * 查询菜单列表信息
     * */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(Integer currentPage,Integer pageSize){
        PageInfo<Menu> pageInfo = menuService.findAllMenu(currentPage, pageSize);
        ResponseResult result = new ResponseResult(true,200,"响应成功",pageInfo);
        return result;
    }

    @RequestMapping("/saveOrUpdateMenu")
    public ResponseResult saveOrUpdateMenu(@RequestBody Menu menu){
        ResponseResult responseResult;
        Date date=new Date();
        if(menu.getId()==null){
            menu.setCreatedTime(date);
            menu.setUpdatedTime(date);
            menu.setCreatedBy("system");
            menu.setUpdatedBy("system");
            menuService.saveMenu(menu);
            responseResult=new ResponseResult(true,200,"菜单保存成功","");
        }else {
            menu.setUpdatedTime(date);
            menu.setUpdatedBy("system");
            menuService.updateMenu(menu);
            responseResult=new ResponseResult(true,200,"菜单更新成功","");
        }
        return responseResult;
    }
}
