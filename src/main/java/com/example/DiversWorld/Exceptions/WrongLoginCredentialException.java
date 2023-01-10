package com.example.DiversWorld.Exceptions;

public class WrongLoginCredentialException {
    private static final long serialVersionUID = 1L;
    private final Integer code;

    public WrongLoginCredentialException(Integer code) {
        this.code = code;
    }
    public Integer getCode() {
        return this.code;
    }
}
