package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Menu;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/9 9:50
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    /**
     * 分页与条件查询
     * */
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVo resourceVo){
        PageInfo<Resource> allResource = resourceService.findAllResource(resourceVo);
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",allResource);
        return responseResult;
    }

    @RequestMapping("/saveOrUpdateResource")
    public ResponseResult saveOrUpdateResource(@RequestBody Resource resource){
        ResponseResult responseResult;
        Date date=new Date();
        if(resource.getId()==null){
            resource.setCreatedTime(date);
            resource.setUpdatedTime(date);
            resource.setCreatedBy("system");
            resource.setUpdatedBy("system");
            resourceService.saveResource(resource);
            responseResult=new ResponseResult(true,200,"资源保存成功","");
        }else {
            resource.setUpdatedTime(date);
            resource.setUpdatedBy("system");
            resourceService.updateResource(resource);
            responseResult=new ResponseResult(true,200,"资源更新成功","");
        }
        return responseResult;
    }

    @RequestMapping("/deleteResource")
    public ResponseResult deleteResource(@RequestParam Integer id){
        resourceService.deleteResource(id);
        ResponseResult responseResult=new ResponseResult(true,200,"资源删除成功","");
        return responseResult;
    }
}
