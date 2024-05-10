package com.lagou.controller;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/9 13:22
 */
@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @RequestMapping("/findAllResourceCategory")
    private ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",allResourceCategory);
        return responseResult;
    }
}
