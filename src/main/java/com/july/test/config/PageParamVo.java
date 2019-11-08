package com.july.test.config;

public class PageParamVo<T> {
    private T content;
    private PageVo<T> pager;

    public void setList(T list) {
        this.content = list;
    }

    public void setPage(Long page) {
        if (this.pager != null) {
            this.pager.setPage(page);
        }

    }

    public void setLimit(Long limit) {
        if (this.pager != null) {
            this.pager.setLimt(limit);
        }

    }

    public void setLimt(Long limt) {
        if (this.pager != null) {
            this.pager.setLimt(limt);
        }

    }

    public PageParamVo() {
    }

    public T getContent() {
        return this.content;
    }

    public PageVo<T> getPager() {
        return this.pager;
    }

    public void setContent(final T content) {
        this.content = content;
    }

    public void setPager(final PageVo<T> pager) {
        this.pager = pager;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageParamVo)) {
            return false;
        } else {
            PageParamVo<?> other = (PageParamVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                Object this$pager = this.getPager();
                Object other$pager = other.getPager();
                if (this$pager == null) {
                    if (other$pager != null) {
                        return false;
                    }
                } else if (!this$pager.equals(other$pager)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageParamVo;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        Object $pager = this.getPager();
        result = result * 59 + ($pager == null ? 43 : $pager.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PageParamVo(content=" + this.getContent() + ", pager=" + this.getPager() + ")";
    }
}
