package com.example.s05_nimbus_jwt_spring_security_seperate_front_back.common;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * the common response body for all the response
 * 
 * usage:
 * 1. R.ok().msg("xxx").data(.....)
 * 2. R.error().msg("xxxxx").data(.....)
 */
@Getter
@Setter
@AllArgsConstructor
public class R {
    private Boolean success;
    private String msg;
    private Map<String, Object> data;

    private R() {
    }

    public static R ok() {
        R r = new R();
        r.success = true;
        r.msg = "operation succeed";
        return r;
    }

    public static R error() {
        R r = new R();
        r.success = false;
        r.msg = "operation failed";
        return r;
    }

    public R success(Boolean customSuccess) {
        this.setSuccess(customSuccess);
        return this;
    }

    public R msg(String customMsg) {
        this.setMsg(customMsg);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
