package com.lagou.dao;

import com.lagou.domain.Test;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/6 23:24
 */
public interface TestMapper {

    /*
        对test表进行查询所有操作
    * */
    public List<Test> findAllTest();

}
