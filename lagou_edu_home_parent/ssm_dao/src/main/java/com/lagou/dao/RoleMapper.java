package com.lagou.dao;

import com.lagou.domain.Menu;
import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/8 10:54
 */
public interface RoleMapper {

    // 权限系统经典五张表（用户表、角色表、权限表、用户角色中间表、角色权限中间表）

    /*
    查询角色列表(条件)
    */
    public List<Role> findAllRole(Role role);


    /*
    根据角色ID查询菜单信息
    */
    List<String> findMenuByRoleId(Integer roleId);

    /*
    角色菜单关联
    */
    void RoleContextMenu(Role_menu_relation role_menu_relation);

    void deleteRoleContextMenu(int id);

    /*
    删除角色
    */
    void deleteRole(Integer id);

    /*添加用户*/
    void saveRole(Role role);

    /*修改用户*/
    void updateRole(Role role);
}
