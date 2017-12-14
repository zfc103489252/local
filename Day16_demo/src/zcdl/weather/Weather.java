package zcdl.weather;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class Weather {

    public void weather() throws IOException {
        URL url = new URL("http://api.k780.com/?app=weather.future&weaid=1&&appkey=30515&" + "sign=8efccf2b7846c8cb90694a9e431ae274&format=json");
        URLConnection uc = url.openConnection();
        InputStream is = uc.getInputStream();
        byte[] bf = new byte[1024*1024];
        String result = null;
        int len = 0;
        while ((len = is.read(bf)) > 0){
            result = new String(bf,0,len);
        }
        if (is != null){
            is.close();
        }
        JSONObject jsonObject = JSONObject.fromObject(result);
        Book book = (Book)JSONObject.toBean(jsonObject,Book.class);
        System.out.println("id为：" + book.getResult());
    }

    public static void weathers(String s) throws IOException {
        URL url = new URL("http://api.k780.com/?app=weather.today&weaid="+s+"&appkey=10003&" + "sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
        InputStream in = url.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
//        System.out.println(new String(b,"utf-8"));
        String str = new String(b,"utf-8");
        JSONObject joss = JSONObject.fromObject(str);
        Object o = JSONObject.toBean(joss, Book.class);
        Book weather = (Book) o;
        System.out.println("城市：" + weather.getResult().getCitynm() + "\n" +"天气：" + weather.getResult().getWeather());
    }
}
