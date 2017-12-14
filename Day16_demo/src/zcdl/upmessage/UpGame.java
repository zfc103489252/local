package zcdl.upmessage;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import zcdl.Person;
import zcdl.weather.Book;

import javax.xml.bind.Element;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UpGame {
    public static void up(Person person,long score) throws IOException {
        URL url = new URL("http://192.168.20.194:8080/day16/insert?username="+ person.getName() +"&score=" + score);
        InputStream in = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int r = in.read(b);
        out.write(b,0,r);
        in.close();
        byte a[]=out.toByteArray( );
        System.out.println(new String(b,"utf-8"));
        String str = new String(a,"utf-8");
//        JSONObject joss = JSONObject.fromObject(str);
    }

    public static void one() throws IOException {
        URL url = new URL("http://192.168.20.194:8080/day16/first");
        InputStream in = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int r = in.read(b);
        out.write(b,0,r);
        in.close();
        byte a[]=out.toByteArray( );
//      System.out.println(new String(b,"utf-8"));
        String s = new String(b,"utf-8");
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("User",Grade.class);
        //.trim删除行首行尾的空格 会报尾随节中不允许有内容异常
        s= s.trim();
        Grade grade = (Grade) xStream.fromXML(s);
        System.out.println("第一名:" + grade.getNickname()+ "分数:" + grade.getScore());

}

    public static void ten() throws IOException {
        URL url = new URL("http://192.168.20.194:8080/day16/ten");
        InputStream in = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int r = in.read(b);
        out.write(b,0,r);
        in.close();
        byte a[]=out.toByteArray( );
//        System.out.println(new String(b,"utf-8"));
        String s = new String(b,"UTF-8");
        JSONArray jsonArray = JSONArray.fromObject(s);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject j = jsonArray.getJSONObject(i);
            Grade grade = (Grade) JSONObject.toBean(j,Grade.class);
            System.out.println("第"+(i+1)+"名："+ grade.getNickname()+"\n"+"分数："+grade.getScore());
        }
    }
}
