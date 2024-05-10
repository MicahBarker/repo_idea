package com.lagou.service.impl;

import com.lagou.dao.TestMapper;
import com.lagou.domain.Test;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/6 23:36
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAllTest() {
        List<Test> list = testMapper.findAllTest();
        return list;
    }
}
