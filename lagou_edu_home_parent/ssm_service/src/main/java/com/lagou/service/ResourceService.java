package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/9 9:49
 */
public interface ResourceService {
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo);

    public void saveResource(Resource resource);

    public void updateResource(Resource resource);

    public void deleteResource(Integer id);
}
