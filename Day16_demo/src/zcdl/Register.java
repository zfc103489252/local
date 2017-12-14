package zcdl;

import org.dom4j.DocumentException;
import zcdl.document.Documents;
import zcdl.rexception.UsException1;

import java.util.List;

public class Register {
    public static void register(Person person) throws DocumentException, UsException1 {
        List<Person> ss = Documents.login();
        for (Person s : ss) {
            if (s.getUserName().equals(person.getUserName())){
                throw new UsException1();
            }
        }
    }
}
