package com.july.test.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
import java.util.List;

public class PageVo<T> implements IPageVo<T> {
    private static final long serialVersionUID = 8545996863226528798L;
    @JSONField(
            serialize = false
    )
    private List<T> records;
    @JSONField(
            name = "totalCount"
    )
    private long total;
    @JSONField(
            name = "pageSize"
    )
    private long size;
    @JSONField(
            name = "currentPage"
    )
    private long current;
    @JSONField(
            serialize = false
    )
    private String[] ascs;
    @JSONField(
            serialize = false
    )
    private String[] descs;
    @JSONField(
            serialize = false
    )
    private boolean optimizeCountSql;
    @JSONField(
            serialize = false
    )
    private boolean isSearchCount;

    public PageVo() {
        this.records = Collections.emptyList();
        this.total = 0L;
        this.size = 10L;
        this.current = 1L;
        this.optimizeCountSql = true;
        this.isSearchCount = true;
    }

    public PageVo<T> setPage(Long page) {
        return this.setCurrent(page);
    }

    public PageVo<T> setCurrentPage(Long currentPage) {
        return this.setCurrent(currentPage);
    }

    public Long getCurrentPage() {
        return this.getCurrent();
    }

    public PageVo<T> setPageNo(Long pageNo) {
        return this.setCurrent(pageNo);
    }

    public PageVo<T> setPageSize(Long pageSize) {
        return this.setSize(pageSize);
    }

    public Long getPageSize() {
        return this.getSize();
    }

    public PageVo<T> setLimt(Long limt) {
        return this.setSize(limt);
    }

    public PageVo<T> setTotalCount(Long totalCount) {
        return this.setTotal(totalCount);
    }

    public Long getTotalCount() {
        return this.getTotal();
    }

    public PageVo<T> setCount(Long count) {
        return this.setTotal(count);
    }

    public PageVo(long current, long size) {
        this(current, size, 0L);
    }

    public PageVo(long current, long size, long total) {
        this(current, size, total, true);
    }

    public PageVo(long current, long size, boolean isSearchCount) {
        this(current, size, 0L, isSearchCount);
    }

    public PageVo(long current, long size, long total, boolean isSearchCount) {
        this.records = Collections.emptyList();
        this.total = 0L;
        this.size = 10L;
        this.current = 1L;
        this.optimizeCountSql = true;
        this.isSearchCount = true;
        if (current > 1L) {
            this.current = current;
        }

        this.size = size;
        this.total = total;
        this.isSearchCount = isSearchCount;
    }

    public boolean hasPrevious() {
        return this.current > 1L;
    }

    public boolean hasNext() {
        return this.current < this.getPages();
    }

    @Override
    @JsonIgnore
    @JSONField(
            serialize = false
    )
    public List<T> getRecords() {
        return this.records;
    }

    @JsonIgnore
    @JSONField(
            serialize = false
    )
    public List<T> getList() {
        return this.getRecords();
    }

    @Override
    public PageVo<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    public PageVo<T> setList(List<T> list) {
        return this.setRecords(list);
    }

    @Override
    @JsonIgnore
    public long getTotal() {
        return this.total;
    }

    @Override
    public PageVo<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    @JsonIgnore
    public long getSize() {
        return this.size;
    }

    @Override
    public PageVo<T> setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    @JsonIgnore
    public long getCurrent() {
        return this.current;
    }

    @Override
    public PageVo<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    @Override
    public String[] ascs() {
        return this.ascs;
    }

    public PageVo<T> setAscs(List<String> ascs) {
        if (ascs != null && !ascs.isEmpty()) {
            this.ascs = (String[])ascs.toArray(new String[0]);
        }

        return this;
    }

    public PageVo<T> setAsc(String... ascs) {
        this.ascs = ascs;
        return this;
    }

    @Override
    public String[] descs() {
        return this.descs;
    }

    public PageVo<T> setDescs(List<String> descs) {
        if (descs != null && !descs.isEmpty()) {
            this.descs = (String[])descs.toArray(new String[0]);
        }

        return this;
    }

    public PageVo<T> setDesc(String... descs) {
        this.descs = descs;
        return this;
    }

    @Override
    public boolean optimizeCountSql() {
        return this.optimizeCountSql;
    }

    @Override
    @JsonIgnore
    public boolean isSearchCount() {
        return this.total < 0L ? false : this.isSearchCount;
    }

    public PageVo<T> setSearchCount(boolean isSearchCount) {
        this.isSearchCount = isSearchCount;
        return this;
    }

    public PageVo<T> setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
        return this;
    }

    @Override
    public String toString() {
        return "[totalCount=" + this.getTotalCount() + ", pageSize=" + this.getPageSize() + ", currentPage=" + this.getCurrentPage() + "]";
    }
}