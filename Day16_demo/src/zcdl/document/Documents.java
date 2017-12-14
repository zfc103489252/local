package zcdl.document;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import zcdl.Person;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Documents {
    public static Document document = null;
    public static void register(Person person) throws DocumentException, IOException {
        File file = new File("src/dc.xml");
        if (file.exists()){
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new File("src/dc.xml"));
        }
        if (!file.exists()){
            document = DocumentHelper.createDocument();
            Element x = document.addElement("person");
        }
        Element element = document.getRootElement();
        Element element1 = element.addElement("userInfo");
        element1.addAttribute("name",person.getName());
        Element element2 = element1.addElement("userName");
        element2.addText(person.getUserName());
        Element element3 = element1.addElement("password");
        element3.addText(person.getPassword());
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileWriter("src/dc.xml"),outputFormat);
        writer.write(document);
        writer.close();
    }

    public static List<Person> login() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        document = saxReader.read(new File("src/dc.xml"));
        Element element = document.getRootElement();
        List<Element> e = element.elements();
        List<Person> ps = new ArrayList<>();
        for (int i = 0; i < e.size(); i++) {
            Element element1 = e.get(i);
            Element element2 = element1.element("userInfo");
            Attribute name = element1.attribute("name");
            Element userName = element1.element("userName");
            Element password = element1.element("password");
            Person p = new Person(name.getValue(),userName.getText(),password.getText());
            ps.add(p);
        }
        return ps;
    }
}
