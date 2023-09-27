package com.zmm.zjob.core.exception;

public class ZJobException extends RuntimeException {

    public ZJobException(String msg) {
        super(msg);
    }

    public ZJobException(Throwable cause) {
        super(cause);
    }
}
