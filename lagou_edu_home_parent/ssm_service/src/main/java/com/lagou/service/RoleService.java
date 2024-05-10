package com.lagou.service;

import com.lagou.domain.Menu;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/8 22:25
 */
public interface RoleService {

    public List<Role> findAllRole(Role role);

    /**
     * 根据ID查询角色关联菜单
     * */
    List<String> findMenuByRoleId(Integer roleId);

    void RoleContextMenu(RoleMenuVo roleMenuVo);

    void deleteRole(Integer id);

    /*添加用户*/
    void saveRole(Role role);

    /*修改用户*/
    void updateRole(Role role);

}
