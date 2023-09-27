package com.zmm.zjob.core.common;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private final static long serialVersionUID = 123591213L;
    private final int code;
    private final T data;
    private final String errorMsg;
    private Result(int code, T data, String errorMsg) {
        this.code = 100;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(100, data, null);
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
