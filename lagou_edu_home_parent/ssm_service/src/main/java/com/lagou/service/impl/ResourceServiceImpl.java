package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/9 9:49
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo) {
        PageHelper.startPage(resourceVo.getCurrentPage(), resourceVo.getPageSize());
        List<Resource> allResource = resourceMapper.findAllResource(resourceVo);
        PageInfo<Resource> adPageInfo = new PageInfo<Resource>(allResource);
        return adPageInfo;
    }

    @Override
    public void saveResource(Resource resource) {
        resourceMapper.saveResource(resource);
    }

    @Override
    public void updateResource(Resource resource) {
        resourceMapper.updateResource(resource);
    }

    @Override
    public void deleteResource(Integer id) {
        resourceMapper.deleteResource(id);
    }
}
