package com.ideao.dev.javadatabase.coffee.exceptions;

import com.ideao.dev.javadatabase.common.exceptions.BusinessException;

public class CoffeeNotFoundException extends BusinessException {

    public CoffeeNotFoundException(String message) {
        super(message);
    }

    public CoffeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoffeeNotFoundException(Throwable cause) {
        super(cause);
    }
}