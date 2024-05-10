package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/8 22:48
 */
public interface MenuMapper {

    /**
     * 查询全部的父子菜单信息
     * */
    public List<Menu> findSubMenuListByPid(int pid);

    /**
     * 查询菜单列表
     * */
    public List<Menu> findAllMenu();

    /**
     * 添加&修改菜单
     */
    public void saveMenu(Menu menu);
    public void updateMenu(Menu menu);


}
