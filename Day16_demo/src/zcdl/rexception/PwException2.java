package zcdl.rexception;

import zcdl.rexception.RegisterException;

public class PwException2 extends RegisterException {
    @Override
    public String getMessage() {
        return "密码过短";
    }
}
