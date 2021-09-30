package com.dsg.common.core.exception;

/**
 * Dsg系统异常
 *
 * @author MrBird
 */
public class DsgException extends RuntimeException {

    private static final long serialVersionUID = -6916154462432027437L;

    public DsgException(String message) {
        super(message);
    }
}
