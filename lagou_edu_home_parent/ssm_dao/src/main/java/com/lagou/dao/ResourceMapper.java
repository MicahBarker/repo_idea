package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/9 9:46
 */
public interface ResourceMapper {
    public List<Resource> findAllResource(ResourceVo resourceVo);

    public void saveResource(Resource resource);

    public void updateResource(Resource resource);

    public void deleteResource(Integer id);
}
