package com.ideao.dev.javadatabase.supplier.exceptions;


import com.ideao.dev.javadatabase.common.exceptions.BusinessException;

public class SupplierNotFoundException extends BusinessException {

    public SupplierNotFoundException(String message) {
        super(message);
    }

    public SupplierNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SupplierNotFoundException(Throwable cause) {
        super(cause);
    }
}
