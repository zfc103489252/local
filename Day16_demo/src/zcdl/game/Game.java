package zcdl.game;

import org.junit.Test;
import zcdl.Function;
import zcdl.Person;
import zcdl.UpGames;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Game {
    Scanner input=new Scanner(System.in);
    public static void geme(Person person) throws IOException {
        while (true){
            Scanner input=new Scanner(System.in);
            System.out.println("请选择难度"+"\n"+
                    "1.简单(10个字符)"+"\n"+
                    "2.适中(20个字符)"+"\n"+
                    "3.困难(30个字符)"+
                    "4.退出");
            int num=input.nextInt();
            switch (num){
                case 1:
                    xc();
                    new Game().easy(person);
                    break;
                case 2:
                    xc();
                    new Game().medium(person);
                    break;
                case 3:
                    xc();
                    new Game().difficulty(person);
                    break;
                case 4:
                    Function.functions(person);
                    break;
            }
        }
    }

    public void difficulty(Person person) throws IOException {
        String randomcode = "";
        String model = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz~！@#￥%^&*（）{}[]\\/.,<>?_-+=";
        char[] m = model.toCharArray();
        for (int j=0;j<30;j++ ){
            char c = m[(int)(Math.random()*model.length())];
            randomcode = randomcode + c;
        }
        System.out.println(randomcode);
        System.out.println("开始");
        long k = System.currentTimeMillis();
        String s=input.nextLine();
        if (s.equals(randomcode)){
            System.out.println("你赢了");
            time(person,k);
        }else {
            System.out.println("你输了");
            return;
        }
    }

    public void medium (Person person) throws IOException {
        String randomcode2 = "";
        String model = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] m = model.toCharArray();
        for (int j=0;j<20;j++ )
        {
            char c = m[(int)(Math.random()*model.length())];
            randomcode2 = randomcode2 + c;
        }
        System.out.println(randomcode2);
        System.out.println("开始");
        long k = System.currentTimeMillis();
        String s=input.nextLine();
        if (s.equals(randomcode2)){
            System.out.println("你赢了");
            time(person,k);
        }else {
            System.out.println("你输了");
        }
    }

    public  void easy (Person person) throws IOException {
        String randomcode2 = "";
        List<String>list = new ArrayList();
        String model = "0123456789abcdefghijklmnopqrstuvwxyz";
//        for (char i = 48; i < 57; i++) {
//            list.addAll(i);
//        }
        char[] m = model.toCharArray();
        for (int j=0;j<10 ;j++ )
        {
            char c = m[(int)(Math.random()*model.length())];
            randomcode2 = randomcode2 + c;
        }
        System.out.println(randomcode2);
        System.out.println("开始");
        long k = System.currentTimeMillis();
        String s=input.nextLine();
        if (s.equals(randomcode2)){
            System.out.println("你赢了");
            time(person,k);
        }else {
            System.out.println("你输了");
        }
    }
@Test
    public static void xc(){
        for (int i = 3; i >= 1; i--) {
            try {
                Thread.sleep(1000);
                System.out.println(" 倒计时"+i+"秒钟后开始");
            } catch (InterruptedException e) {
                System.out.println("aaa");
            }
        }
    }

    public static void time(Person person,long k) throws IOException {
        long j = System.currentTimeMillis();
        long x =  j - k;
        System.out.println("用时：" + x);
        UpGames.select(person,x);
    }
}
