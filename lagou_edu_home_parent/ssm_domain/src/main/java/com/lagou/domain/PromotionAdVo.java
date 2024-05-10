package com.lagou.domain;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/7 19:27
 */
public class PromotionAdVo {

    private Integer currentPage = 1;

    private Integer pageSize = 10;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
