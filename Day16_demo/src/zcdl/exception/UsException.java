package zcdl.exception;

public class UsException extends LoginException {
    @Override
    public String getMessage() {
        return "帐号不存在";
    }
}
