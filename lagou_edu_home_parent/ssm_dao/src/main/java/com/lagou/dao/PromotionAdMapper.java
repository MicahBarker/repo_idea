package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/7 19:28
 */
public interface PromotionAdMapper {
    /**
     * 分页获取所有的广告列表
     */
    public List<PromotionAd> findAllPromotionAdByPage();

    void savePromotionAd(PromotionAd promotionAd);

    void updatePromotionAd(PromotionAd promotionAd);

    /**
     * 根据id查询广告信息
     * */
    PromotionAd findPromotionAdById(int id);

    /*
    * 广告状态上下线
    * */
    void updatePromotionAdStatus(PromotionAd promotionAd);

}
