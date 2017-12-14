package zcdl.rexception;

import zcdl.rexception.RegisterException;

public class UsException extends RegisterException {
    @Override
    public String getMessage() {
        return "帐号格式错误,请以手机号，邮箱注册";
    }
}
