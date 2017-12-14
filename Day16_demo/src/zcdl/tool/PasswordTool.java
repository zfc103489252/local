package zcdl.tool;

import zcdl.rexception.*;

public class PasswordTool {
    public static boolean ps(String password) throws RegisterException {
        int a = 0;
        for (int i = 0; i <= 9; i++) {
            String x = i + "";
            if (password.contains(x)){
                if (a == 0){
                    a++;
                }
            }
        }
        if (a == 0){
            throw new PwException();
        }

        for (char i = 'a'; i <= 'z'; i++) {
            if (password.contains(Character.toString(i)));{
                if (a==1){
                    a++;
                }
            }
            if (a == 1){
                throw new PwException1();
            }
        }
            if (password.length()<6){
                throw new PwException2();
            }
            if (password.length()>14){
                throw new PwException3();
            }
        return true;
    }
}
