package com.polaris.maker.meta;

/**
 * 自定义元信息异常类
 * @author MXD
 */
public class MetaException extends RuntimeException {
    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }
}
