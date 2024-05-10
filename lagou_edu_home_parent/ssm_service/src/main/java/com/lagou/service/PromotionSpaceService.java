package com.lagou.service;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/7 18:41
 */
public interface PromotionSpaceService {
    /*
      获取所有的广告位
    */
    public List<PromotionSpace> findAllPromotionSpace();

    void savePromotionSpace(PromotionSpace promotionSpace);

    void updatePromotionSpace(PromotionSpace promotionSpace);

    PromotionSpace findPromotionSpaceById(int id);


}
