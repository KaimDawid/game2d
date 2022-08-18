package Logic.FightLogic;

import Logic.GameLogic;
import Mobs.Monster;
import Mobs.Player;
import com.badlogic.gdx.Game;
import com.mygdx.game.Assets;
import com.mygdx.game.GameApp;

import java.util.Random;
import java.util.TimerTask;

import static Logic.FightLogic.Fight.*;
import static com.mygdx.game.GameApp.*;
import static jdk.internal.org.jline.utils.Colors.h;

public class FightLogic {

    public static void ConcludeBattle(final Player player, final Monster monster1, int joined) throws InterruptedException {
        if (Fight.doubleStrike == 1) {
            if (monster1.getHp() <= 0 && GameLogic.monsterBase[joined].getHp() <= 0) {
                topText = "Pokonałeś obu wrogów!";
                monster1.setFreeze(0);
                System.out.println("Pokonałeś obu wrogów!");
                GameLogic.monsterBase[joined].setX(100);
                GameLogic.monsterBase[joined].setY(100);
                monster1.setX(100);
                monster1.setY(100);
                player.setXP(player.getXP() + monster1.getGiveXP() + GameLogic.monsterBase[joined].getGiveXP());
                GameLogic.monsterBase[joined].Drop();
                monster1.Drop();           Dawid.setFear(0);
                player.setGold(player.getGold() + monster1.getGold() + GameLogic.monsterBase[joined].getGold());

                Fight.joined = 1;
                Fight.doubleStrike = 0;
                PlayerStatusWearOff(player);
                Fight.escape = 1;
                Fight.fightON = 0;

                GameApp.fightscreenSP.setSize(1, 1);
                GameApp.fightstart = 0;
                GameApp.enemyAttackText = " ";
                GameApp.playerAttackText = " ";
                GameApp.mobSpellText = " ";
                GameApp.topText = "1. zaatakuj, 2. Użyj czaru";
                GameApp.sprite.setPosition(100000,100000);
                leftText = "Controls: \n \n " +
                        "Steering:  W, S, D, A \n \n Map: Tab \n \n Inventory: F2 \n \n Stats: P ";

                Assets.attackSpr.setSize(0,0);
                Assets.iceSpr.setSize(0,0);
               adrenalineSPR.setSize(0,0);
                Assets.runSpr.setSize(0,0);
                playerAttackText2 = " ";
            }
        } else if (Fight.doubleStrike == 0) {

            if (monster1.getHp() <= 0) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        monster1.setFreeze(0);
                        playerAttackText2 = " ";
                        topText = "Wygrałeś! ";
                        System.out.println("Wygrałeś!");
                        monster1.setX(100);
                        monster1.setY(100);
                        player.setXP(player.getXP() + monster1.getGiveXP());
                        Random random = new Random();
                        Assets.attackSpr.setSize(0,0);
                        Assets.iceSpr.setSize(0,0);
                        adrenalineSPR.setSize(0,0);
                        Assets.runSpr.setSize(0,0);
                        monster1.Drop();
                        Fight.joined = 1;
                        Fight.doubleStrike = 0;
                        player.setGold(player.getGold() + monster1.getGold());
                        PlayerStatusWearOff(player);
                        Fight.escape = 1;
                        Fight.fightON = 0;

                        GameApp.fightscreenSP.setSize(1, 1);
                        GameApp.fightstart = 0;
                        GameApp.sprite.setPosition(100000,100000);
                        GameApp.enemyAttackText = " ";
                        GameApp.playerAttackText = " ";
                        GameApp.mobSpellText = " ";           Dawid.setFear(0);
                        GameApp.topText = "1. zaatakuj, 2. Użyj czaru";
                        leftText = "Controls: \n \n " +
                                "Steering:  W, S, D, A \n \n Map: Tab \n \n Inventory: F2 \n \n Stats: P ";
                    }
                },1000);

            }
        }
        else {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Assets.attackSpr.setSize(0,0);
                    Assets.iceSpr.setSize(0,0);
                    adrenalineSPR.setSize(0,0);
                    Assets.runSpr.setSize(0,0);
                    GameApp.sprite.setPosition(100000,100000);
                    GameApp.enemyAttackText = " ";
                    GameApp.playerAttackText = " ";
                    GameApp.mobSpellText = " ";
                    GameApp.topText = "1. zaatakuj, 2. Użyj czaru";
                    leftText = "Controls: \n \n " +
                            "Steering:  W, S, D, A \n \n Map: Tab \n \n Inventory: F2 \n \n Stats: P ";
                    PlayerStatusWearOff(player);
                    GameApp.fightscreenSP.setSize(1, 1);
                    GameApp.fightstart = 0;           Dawid.setFear(0);
                }
            },1000);


        }

        if (player.getHP() < 1) {

            GameApp.fightON = 0;
            fightstart = 0;
            escape = 1;
            playerSprite.setPosition(1100,1030);
            Dawid.setXP(0);
            Dawid.setHP(Dawid.getMaxHP());
            Dawid.setX(4);
            Dawid.setY(4);
            camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
            camera.update();

            Random random = new Random();
            Assets.attackSpr.setSize(0,0);
            Assets.iceSpr.setSize(0,0);
            adrenalineSPR.setSize(0,0);
            Assets.runSpr.setSize(0,0);

            Fight.joined = 1;
            Fight.doubleStrike = 0;

            PlayerStatusWearOff(player);
            Fight.escape = 1;
            Fight.fightON = 0;

            GameApp.fightscreenSP.setSize(1, 1);
            GameApp.fightstart = 0;
            GameApp.sprite.setPosition(100000,100000);
            GameApp.enemyAttackText = " ";
            GameApp.playerAttackText = " ";
            GameApp.mobSpellText = " ";
            GameApp.topText = "1. zaatakuj, 2. Użyj czaru";
            leftText = "Controls: \n \n " +
                    "Steering:  W, S, D, A \n \n Map: Tab \n \n Inventory: F2 \n \n Stats: P ";
            Assets.attackSpr.setSize(0,0);
            Assets.iceSpr.setSize(0,0);
            adrenalineSPR.setSize(0,0);
            Assets.runSpr.setSize(0,0);
            GameApp.sprite.setPosition(100000,100000);
            GameApp.enemyAttackText = " ";
            GameApp.playerAttackText = " ";
            GameApp.mobSpellText = " ";
            GameApp.topText = "1. zaatakuj, 2. Użyj czaru";
            leftText = "Controls: \n \n " +
                    "Steering:  W, S, D, A \n \n Map: Tab \n \n Inventory: F2 \n \n Stats: P ";
            PlayerStatusWearOff(player);
            GameApp.fightscreenSP.setSize(1, 1);
            GameApp.fightstart = 0;
            Dawid.setFear(0);

        }

    }
    public static void StatusConclude(Player player, Monster monster){
        int burnDMG = 40;
        if (player.getBurn() > 0) {
            System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
            player.setHP(player.getHP() - burnDMG);
            player.setBurn(player.getBurn() - 1);
        }
        if (player.getPoison() > 0 && player.getDecay() == 0) {
            int poisonDMG = 20;
            player.setHP(player.getHP() - poisonDMG);
            System.out.println("Otrzymałeś " + poisonDMG + " obrażeń od trucizny");
            player.setPoison(player.getPoison() - 1);
        }
        else if (player.getDecay() == 1){
            int decayDMG = 50;
            player.setHP(player.getHP() - 50);
            playerAttackText2 = " You've received " + decayDMG + " damage from decay!";
        }
        if (monster.getPoison() > 0){
            int poisonDMG = 20;
            monster.setHp(monster.getHp() - poisonDMG);
            System.out.println("Przeciwnik otrzymał " + poisonDMG + " obrażeń od trucizny!");
            monster.setPoison(monster.getPoison() - 1);
        }
        if (monster.getFreeze() > 0){
            monster.setFreeze(monster.getFreeze() - 1);
        }
        if (monster.getHp() < 1){
            GameApp.fightON = 0;
            GameApp.fightstart = 0;
        }



        if (Fight.adrenalineDuration > 0){
            Fight.adrenalineDuration--;
        }
        if (Fight.ironSkinDuration > 0){
            Fight.ironSkinDuration--;
        }

    }

    public static void RestoreMana(Player player){
        if (player.getMana() < player.getMaxMana()) {

            player.setMana(player.getMana() + player.getManaRegen());
            double manaDiff = (player.getMana() - player.getMaxMana());
            if (manaDiff > 0) {
                player.setMana(player.getMana() - manaDiff);
            }
        }
    }

    public static void WhoDoYouWantToAttack(Monster monster){
        System.out.println("Kogo chcesz wybrać jako swój cel?");
        if (monster.getHp() > 0) {
            System.out.println("A. " + monster.getName() + " (" + monster.getHp() + ") HP");
        } else {
            System.out.println("A. " + monster.getName() + " (Martwy)");
        }
        if (GameLogic.monsterBase[joined].getHp() > 0) {
            System.out.println("B. " + GameLogic.monsterBase[joined].getName() + " (" + GameLogic.monsterBase[joined].getHp() + ") HP");
        } else if (GameLogic.monsterBase[joined].getHp() < 1) {
            System.out.println("B. " + GameLogic.monsterBase[joined].getName() + " (Martwy)");
        }
    }

}
