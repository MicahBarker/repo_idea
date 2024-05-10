package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/7 22:43
 */
@Service
public class PromotionAdServiceImpl implements PromotionAdService {
    @Autowired
    private PromotionAdMapper adMapper;

    @Override
    public PageInfo findAllPromotionAdByPage(PromotionAdVo adVo) {
        // 设置分页参数
        // 参数1：当前页
        // 参数2：每页显示的条数
        PageHelper.startPage(adVo.getCurrentPage(), adVo.getPageSize());

        List<PromotionAd> allAd = adMapper.findAllPromotionAdByPage();
        PageInfo<PromotionAd> adPageInfo = new PageInfo<>(allAd);
        return adPageInfo;
    }

    @Override
    public void savePromotionAd(PromotionAd promotionAd) {
        adMapper.savePromotionAd(promotionAd);
    }

    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        adMapper.updatePromotionAd(promotionAd);
    }

    @Override
    public PromotionAd findPromotionAdById(int id) {
        PromotionAd promotionAd = adMapper.findPromotionAdById(id);
        return promotionAd;
    }

    @Override
    public void updatePromotionAdStatus(int id, int status) {
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(new Date());
        adMapper.updatePromotionAdStatus(promotionAd);
    }

}
