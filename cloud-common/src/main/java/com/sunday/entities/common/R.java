package com.sunday.entities.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yangwendong
 * @Date 2021/8/28 11:09 上午
 */
@Data
@NoArgsConstructor
public class R<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> success(Integer code, String msg, T data) {
        return result(code, msg, data);
    }

    public static <T> R<T> success(T data) {
        return result(200, "操作成功", data);
    }

    public static <T> R<T> success() {
        return success(null);
    }

    public static <T> R<T> error() {
        return error("操作失败");
    }

    public static <T> R<T> error(String msg) {
        return result(500, msg, null);
    }

    public static <T> R<T> result(Integer code, String msg, T data) {
        return new R<>(code, msg, data);
    }

    public static <T> R<T> result(Integer code, String msg) {
        return result(code, msg, null);
    }
}
