package Logic.FightLogic;

import Mobs.Monster;
import Mobs.Player;

import java.util.Timer;
import java.util.TimerTask;

import static com.mygdx.game.GameApp.Dawid;

public class TimedTasks {
    public static void delayMe(final Monster monster ){
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("chuj");
                    }
                },10000);
                monster.Attack(monster,Dawid);
            }
        },10);
    }
    public static void delayMe(Player player, final Monster monster ){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Dawid.Attack(monster,Dawid);
            }
        },8000);
    }
}
