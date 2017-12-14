package zcdl;

import zcdl.game.Game;
import zcdl.upmessage.UpGame;

import java.io.IOException;
import java.util.Scanner;

public class UpGames {
    public static void select(Person person,long score) throws IOException {
        System.out.println("请选择：1上传 2继续游戏");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()){
            case 1:
                UpGame.up(person,score);
                UpGame.one();
                break;
            case 2:
                Game.geme(person);
                break;
        }
    }

}
