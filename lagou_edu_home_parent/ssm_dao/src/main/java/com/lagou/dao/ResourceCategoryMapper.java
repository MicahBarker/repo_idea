package com.lagou.dao;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/9 10:24
 */
public interface ResourceCategoryMapper {
    public List<ResourceCategory> findAllResourceCategory();
}
