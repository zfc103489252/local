package zcdl;

import org.dom4j.DocumentException;
import zcdl.document.Documents;
import zcdl.exception.LoginException;
import zcdl.exception.PwException;
import zcdl.exception.UsException;

import java.io.IOException;
import java.util.List;

public class Login {
    public static void login(String userName,String password) throws DocumentException, LoginException, IOException {
        List<Person> people = Documents.login();
        for (Person person : people) {
            if (person.getUserName().equals(userName)&&!person.getPassword().equals(password)){
                throw new PwException();
            }
            if (person.getUserName().equals(userName)&&person.getPassword().equals(password)){
                System.out.println("登陆成功 \n"+person.toString());
                Function.functions(person);
                return;
            }
        }
        throw new UsException();
    }
}
