package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Menu;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/8 22:50
 */
public interface MenuService {

    public List<Menu> findSubMenuListByPid(int pid);

    /**
     * 查询菜单列表
     * */
    public PageInfo<Menu> findAllMenu(Integer currentPage, Integer pageSize);

    /**
     * 添加&修改菜单
     */
    public void saveMenu(Menu menu);
    public void updateMenu(Menu menu);
}
