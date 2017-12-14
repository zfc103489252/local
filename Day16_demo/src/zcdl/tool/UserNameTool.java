package zcdl.tool;

import zcdl.rexception.UsException;

import java.util.regex.Pattern;

public class UserNameTool {
    public static boolean us(String userName) throws UsException {
        boolean isMatched;
        boolean isMatcheds;
        isMatched = Pattern.matches("^1(3|4|5|7|8)\\d{9}$",userName);
        isMatcheds = Pattern.matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",userName);
        if (isMatched == true | isMatcheds == true){
            return true;
        }
        throw new UsException();
    }
}
