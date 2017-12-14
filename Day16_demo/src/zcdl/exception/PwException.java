package zcdl.exception;

public class PwException extends LoginException{
    @Override
    public String getMessage() {
        return "密码错误";
    }
}
