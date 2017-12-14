package zcdl.examinePhoneNumber;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class PhoneNumber {
    public static void phonenumber(String num) throws IOException {
        URL url = new URL("http://api.k780.com/?app=phone.get&phone="+num+"&appkey=30515&sign=033342ca5dcdc0b64648cf8d2219ca3b&format=json");
        InputStream is = url.openStream();
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        try {
            byte[] by = new byte[1024];
            int len = 0;
            while ((len = is.read(by))>0){
                bo.write(by,0,len);
            }
        }
        finally {
            if (is != null){
                is.close();
            }
        }
        byte[] b = bo.toByteArray();
        String s = new String(b,"UTF-8");
        JSONObject jsonObject = JSONObject.fromObject(s);
        Object o = JSONObject.toBean(jsonObject,Phone.class);
        Phone phone = (Phone) o;
        System.out.println(phone.getResult().getCtype() + phone.getResult().getStyle_simcall()+phone.getResult().getStyle_citynm());
    }
}
