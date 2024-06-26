package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVo;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/8 9:59
 */
public interface UserService {

    /*
    查询所有用户
    */
    public PageInfo findAllUserByPage(UserVo userVo);

    /*
     * 修改用户状态
     * */
    public void updateUserStatus(int id, String status);

    /*
    用户登录
    */
    public User login(User user) throws Exception;

    /**
     * 获取用户拥有的角色
     * */
    public List<Role> findUserRelationRoleById(int id) ;

    /*
    用户关联角色
    */
    void userContextRole(UserVo userVo);

    /*
     * 获取用户权限
     * */
    public ResponseResult getUserPermissions(Integer id);

}
