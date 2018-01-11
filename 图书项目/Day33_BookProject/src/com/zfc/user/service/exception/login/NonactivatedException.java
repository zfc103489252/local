package com.zfc.user.service.exception.login;

public class NonactivatedException extends LoginException {
    @Override
    public String getMessage() {
        return "帐号未激活";
    }
}
