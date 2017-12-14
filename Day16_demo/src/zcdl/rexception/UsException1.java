package zcdl.rexception;

import zcdl.rexception.RegisterException;

public class UsException1 extends RegisterException {
    @Override
    public String getMessage() {
        return "帐号已存在";
    }
}
