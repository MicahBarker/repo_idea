package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/8 22:26
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllUserByPage(@RequestBody Role role){
        List<Role> allRole = roleService.findAllRole(role);
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",allRole);
        return responseResult;
    }

    /*
    查询所有菜单信息
    */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        //-1 表示查询所有菜单数据
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);
        Map<String,Object> map = new HashMap<>();
        map.put("parentMenuList",menuList);
        ResponseResult result = new ResponseResult(true,200,"响应成功",map);
        return result;
    }

    /**
     * 查询角色关联菜单列表ID
     * */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        List<String> menuList = roleService.findMenuByRoleId(roleId);
        ResponseResult result = new ResponseResult(true,200,"响应成功",menuList);
        return result;
    }

    /*
    用户关联菜单 {roleId: 4, menuIdList: [19, 20, 7, 8, 9, 15, 16, 17, 18]}
    */
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        roleService.RoleContextMenu(roleMenuVo);
        ResponseResult result = new ResponseResult(true,200,"响应成功","");
        return result;
    }

    /**
     * 删除角色
     * */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){
        roleService.deleteRole(id);
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功","");
        return responseResult;
    }

    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role){
        ResponseResult responseResult;
        Date date=new Date();
        if(role.getId()==null){
            role.setCreatedTime(date);
            role.setUpdatedTime(date);
            role.setCreatedBy("system");
            role.setUpdatedBy("system");
            roleService.saveRole(role);
            responseResult=new ResponseResult(true,200,"角色保存成功","");
        }else {
            role.setUpdatedTime(date);
            role.setUpdatedBy("system");
            roleService.updateRole(role);
            responseResult=new ResponseResult(true,200,"角色更新成功","");
        }
        return responseResult;
    }

}
