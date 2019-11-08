package com.july.test.config;

import java.util.HashMap;
import java.util.Map;

public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = -8194821450292902175L;
    private static final Integer SUCCESS = 0;
    private static final Integer FAIL = -1;

    public Result() {
        this("处理成功");
    }

    public Result(String msg) {
        this.put((String)"code", SUCCESS);
        this.put((String)"msg", msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put((String)"code", code);
        r.put((String)"msg", msg);
        return r;
    }

    public static Result error() {
        return error(FAIL, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(FAIL, msg);
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put((String)"msg", msg);
        return r;
    }

    public static Result ok(Object data) {
        Result r = new Result();
        r.put("content", data);
        return r;
    }

    public static <T> Result ok(Object data, PageVo<T> pager) {
        Map<String, Object> content = new HashMap();
        content.put("list", data);
        content.put("pager", pager);
        Result r = new Result();
        r.put((String)"content", content);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
