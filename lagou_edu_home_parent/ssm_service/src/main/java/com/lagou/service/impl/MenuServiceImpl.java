package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/8 22:50
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> findSubMenuListByPid(int pid) {
        List<Menu> menuList = menuMapper.findSubMenuListByPid(pid);
        return menuList;
    }

    @Override
    public PageInfo<Menu> findAllMenu(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Menu> list = menuMapper.findAllMenu();
        PageInfo<Menu> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void saveMenu(Menu menu) {
        menuMapper.saveMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateMenu(menu);
    }
}
