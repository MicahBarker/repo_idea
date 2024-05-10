package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/7 22:42
 */
public interface PromotionAdService {
    /**
     * 分页获取所有的广告列表
     */
    public PageInfo findAllPromotionAdByPage(PromotionAdVo adVo);

    void savePromotionAd(PromotionAd promotionAd);

    void updatePromotionAd(PromotionAd promotionAd);

    /*
    回显广告信息
    */
    PromotionAd findPromotionAdById(int id);

    /*
    * 修改广告状态
    * */
    void updatePromotionAdStatus(int id, int status);

}
