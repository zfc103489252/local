package zcdl.rexception;

import zcdl.rexception.RegisterException;

public class PwException1 extends RegisterException {
    @Override
    public String getMessage() {
        return "密码缺少字母";
    }
}
