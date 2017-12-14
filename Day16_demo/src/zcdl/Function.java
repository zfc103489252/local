package zcdl;

import org.junit.Test;
import zcdl.examinePhoneNumber.PhoneNumber;
import zcdl.game.Game;
import zcdl.upmessage.UpGame;
import zcdl.weather.Weather;

import java.io.IOException;
import java.util.Scanner;

public class Function {
    public static void functions(Person person) throws IOException {
        Scanner inputs = new Scanner(System.in);
        while (true) {
            System.out.println("请选择：" +"\n"+
                    " 1.查询天气 \n 2.查询手机号归属地 \n 3.手速游戏 \n 4.查询手速游戏前十名\n 5.用户信息");
            int s = inputs.nextInt();
            inputs.nextLine();
            switch (s) {
                case 1:
                    System.out.println("请输入城市：");
                    String st = inputs.nextLine();
                    if (st != null) {
                        Weather.weathers(st);
                    }
                    continue;
                case 2:
                    System.out.println("请输入手机号：");
                    String num = inputs.nextLine();
                    if (num != null) {
                        PhoneNumber.phonenumber(num);
                    }
                    continue;
                case 3:
                    Game.geme(person);
                    break;
                case 4:
                    UpGame.ten();
                    break;
                case 5:
                    System.out.println(person.toString());
                    break;
            }
        }
    }
}
