package com.july.test.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface IPageVo<T> extends Serializable {
    default String[] descs() {
        return null;
    }

    default String[] ascs() {
        return null;
    }

    default Map<Object, Object> condition() {
        return null;
    }

    default boolean optimizeCountSql() {
        return true;
    }

    default boolean isSearchCount() {
        return true;
    }

    default long offset() {
        return this.getCurrent() > 0L ? (this.getCurrent() - 1L) * this.getSize() : 0L;
    }

    @JsonIgnore
    @JSONField(
            serialize = false
    )
    default long getPages() {
        if (this.getSize() == 0L) {
            return 0L;
        } else {
            long pages = this.getTotal() / this.getSize();
            if (this.getTotal() % this.getSize() != 0L) {
                ++pages;
            }

            return pages;
        }
    }

    default IPageVo<T> setPages(long pages) {
        return this;
    }

    List<T> getRecords();

    IPageVo<T> setRecords(List<T> records);

    long getTotal();

    IPageVo<T> setTotal(long total);

    long getSize();

    IPageVo<T> setSize(long size);

    long getCurrent();

    IPageVo<T> setCurrent(long current);

    default <R> IPageVo<R> convert(Function<? super T, ? extends R> mapper) {
        List<R> collect = (List)this.getRecords().stream().map(mapper).collect(Collectors.toList());
        return (IPageVo<R>) this.setRecords((List<T>) collect);
    }
}
