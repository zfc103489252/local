package com.zfc.user.service.exception.register;

public class ExistException extends Register {
    @Override
    public String getMessage() {
        return "帐号已存在";
    }
}
