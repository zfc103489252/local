package zcdl.rexception;

import zcdl.rexception.RegisterException;

public class PwException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码缺少数字";
    }
}
