package com.lazy.demo.sshvue.server.api.dto;

import java.io.Serializable;

/**
 * <p>
 * 分页DTO
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/9.
 */
public class PageDto implements Serializable {

    private static final long serialVersionUID = 98456537689L;
    private Integer pageSize = 10;
    private Integer currentPage = 1;

    public Integer getBeginRow() {
        return this.currentPage <= 1 ? 0 : (this.currentPage - 1) * this.getPageSize();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public PageDto setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public PageDto setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }
}
