package Logic.FightLogic;

import Data.Quests.FlorekQuest;
import Data.Quests.Quests;
import Logic.Camera;
import Logic.Drop.Miscelanous;
import Logic.FightLogic.Skills.Heal;
import Logic.FightLogic.Skills.Spells;
import Logic.GameLogic;
import Logic.Input.RenderInput;
import Logic.Movement;
import Mobs.Cemetery.CemeterySprites;
import Mobs.Monster;
import Mobs.Player;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;

import java.util.Random;
import java.util.TimerTask;

import static Logic.FightLogic.Fight.*;
import static Mobs.Monster.minotaurSPR;
import static com.mygdx.game.Assets.runSpr;
import static com.mygdx.game.GameApp.*;

public class FightLogic {

    public static int movedFrames;
    public static int finalframes = 50;

    public static void ConcludeBattle(final Player player, final Monster monster1, int joined) throws InterruptedException {
        if (Fight.doubleStrike == 1) {
            if (monster1.getHp() <= 0 && GameLogic.monsterBase[joined].getHp() <= 0) {
                Spells.resetCooldown();
                Dawid.setMana(Dawid.getMaxMana());
                Assets.stunBMP.setSize(0,0);
                Assets.poisonBMP.setSize(0,0);
                Assets.critBMP.setSize(0,0);
                Fonts.topText = "Pokonałeś obu wrogów!";
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

               if (fightscreenSP.getHeight() > 1070){
                   Camera.fadeOut();
               }
                GameApp.fightstart = 0;
                Fonts.enemyAttackText = " ";
                Fonts.playerAttackText = " ";
                Fonts.mobSpellText = " ";
                Fonts.topText = "1. zaatakuj, 2. Użyj czaru";
                GameApp.sprite.setPosition(100000,100000);
                Fonts.leftText = "Controls: \n \n " +
                        "Steering:  W, S, D, A \n \n Map: Tab \n \n Inventory: F2 \n \n Stats: P ";

                Assets.attackSpr.setSize(0,0);
                Assets.iceSpr.setSize(0,0);
               adrenalineSPR.setSize(0,0);
                Assets.runSpr.setSize(0,0);
                playerAttackText2 = " ";
                loaded = false;
            }
        } else if (Fight.doubleStrike == 0) {

            if (monster1.getHp() <= 0 && monster1.getDropable() == 1) {
                Spells.resetCooldown();
                Dawid.setMana(Dawid.getMaxMana());
                Assets.stunBMP.setSize(0,0);
                Assets.poisonBMP.setSize(0,0);
                Assets.critBMP.setSize(0,0);
                RenderInput.moveBlocked = true;
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        RenderInput.moveBlocked = false;
                    }
                },3000);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        monster1.setFreeze(0);
                        playerAttackText2 = " ";
                        Fonts.topText = "Wygrałeś! ";
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

                        if (fightscreenSP.getHeight() > 1070){
                            transitionOut = true;
                        }
                        GameApp.fightstart = 0;
                        GameApp.sprite.setPosition(100000,100000);
                        Fonts.enemyAttackText = " ";
                        Fonts.playerAttackText = " ";
                        Fonts.mobSpellText = " ";           Dawid.setFear(0);
                        Fonts.topText = "1. zaatakuj, 2. Użyj czaru";
                        Fonts.leftText = "Controls: \n \n " +
                                "Steering:  W, S, D, A \n \n Map: Tab \n \n Inventory: F2 \n \n Stats: P ";
                        monster1.setDropable(0);
                        loaded = false;
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
                    Fonts.enemyAttackText = " ";
                    Fonts.playerAttackText = " ";
                    Fonts.mobSpellText = " ";
                    Fonts.topText = "1. zaatakuj, 2. Użyj czaru";
                    Fonts.leftText = "Controls: \n \n " +
                            "Steering:  W, S, D, A \n \n Map: Tab \n \n Inventory: F2 \n \n Stats: P ";
                    PlayerStatusWearOff(player);
                    if (fightscreenSP.getHeight() > 1070){
                        transitionOut = true;
                    }
                    GameApp.fightstart = 0;           Dawid.setFear(0);
                    loaded = false;
                }
            },1000);


        }

        if (player.getHP() < 1) {
            Spells.resetCooldown();
            Dawid.setMana(Dawid.getMaxMana());
            GameApp.fightON = 0;
            fightstart = 0;
            escape = 1;

            Dawid.setXP(0);
            Dawid.setHP(Dawid.getMaxHP());
            if (Quests.quest2Stage!=5) {
                Dawid.setX(4);
                Dawid.setY(4);
            }
            else if (Quests.quest2Stage == 5){
                Dawid.setX(110);
                Dawid.setY(110);
            }
            playerSprite.setPosition(7856,3798);
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

            if (fightscreenSP.getHeight() > 1070){
                transitionOut = true;
            }
            GameApp.fightstart = 0;
            GameApp.sprite.setPosition(100000,100000);
            Fonts.enemyAttackText = " ";
            Fonts.playerAttackText = " ";
            Fonts.mobSpellText = " ";
            Fonts.topText = "1. zaatakuj, 2. Użyj czaru";
            Fonts.leftText = "Controls: \n \n " +
                    "Steering:  W, S, D, A \n \n Map: Tab \n \n Inventory: F2 \n \n Stats: P ";
            Assets.attackSpr.setSize(0,0);
            Assets.iceSpr.setSize(0,0);
            adrenalineSPR.setSize(0,0);
            Assets.runSpr.setSize(0,0);
            GameApp.sprite.setPosition(100000,100000);
            Fonts.enemyAttackText = " ";
            Fonts.playerAttackText = " ";
            Fonts.mobSpellText = " ";
            Fonts.topText = "1. zaatakuj, 2. Użyj czaru";
            Fonts.leftText = "Controls: \n \n " +
                    "Steering:  W, S, D, A \n \n Map: Tab \n \n Inventory: F2 \n \n Stats: P ";
            PlayerStatusWearOff(player);
            GameApp.fightscreenSP.setSize(1, 1);
            GameApp.fightstart = 0;
            Dawid.setFear(0);
            loaded = false;
        }

    }
    public static void StatusConclude(Player player, Monster monster){
      Spells.lowerCooldown();
        FightLogic.RestoreMana(player);
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

    public static void reverseHP(Monster monster){
        if (!Dawid.isHealthSwapped()){
            System.out.println("spoko luz");
        }
        else if (Dawid.isHealthSwapped()){

            Dawid.setHealthSwapped(false);
        }
    }

    public static void hideAssets(){
        Fonts.missOrCritText = " ";
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        },50);
        sprite.setSize(0,0);
        goblinSprite.setSize(0,0);
        Assets.banditSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.banditchiefSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.banditSPR.setSize(0,0);
        Assets.banditchiefSPR.setSize(0,0);
        Assets.wolfSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.werewolfSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.wolfSPR.setSize(0,0);
        Assets.werewolfSPR.setSize(0,0);
        Assets.vampireSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.vampireSPR.setSize(0,0);
        Monster.whiteKnightSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Monster.whiteKnightSPR.setSize(0,0);
        Assets.mutantSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.mutantSPR.setSize(0,0);
        Quests.gabiSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Quests.gabiSPR.setSize(0,0);
        CemeterySprites.ghoulSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        CemeterySprites.ghoulSPR.setSize(0,0);
        CemeterySprites.ghostSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        CemeterySprites.ghostSPR.setSize(0,0);
        CemeterySprites.headlessHorsemanSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        CemeterySprites.headlessHorsemanSPR.setSize(0,0);
        CemeterySprites.skeletonSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        CemeterySprites.skeletonSPR.setSize(0,0);
        CemeterySprites.lumpOfFleshSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        CemeterySprites.lumpOfFleshSPR.setSize(0,0);
        minotaurSPR.setSize(0,0);
        minotaurSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        enemybargreen.setSize(0,0);
        enemybar.setSize(0,0);
        getIceBoltSPR2.setSize(0, 0);
        fireBallSPR2.setSize(0, 0);
        cleaveSPR2.setSize(0,0);
        getAdrenalineSPR2.setSize(0,0);
        healSPR2.setSize(0, 0);
        ironskinSPR2.setSize(0, 0);

    }

    public static void showAssets(){


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sprite.setPosition(playerSprite.getX()+ 300,playerSprite.getY());
                goblinSprite.setSize(600,500);
                spiderSprite.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                spiderSprite.setSize(600,500);
                goblinSprite.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                Assets.banditSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                Assets.banditchiefSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                Assets.banditSPR.setSize(600,500);
                Assets.banditchiefSPR.setSize(600,500);
                Assets.wolfSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                Assets.werewolfSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                Monster.whiteKnightSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                Monster.whiteKnightSPR.setSize(600,500);
                FlorekQuest.crayfishSPR.setSize(600,600);
                FlorekQuest.crayfishSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
               Quests.gabiSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
               Quests.gabiSPR.setSize(600,500);
                Assets.wolfSPR.setSize(600,500);
                Assets.werewolfSPR.setSize(600,500);
                Assets.vampireSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                Assets.vampireSPR.setSize(600,500);
                CemeterySprites.ghoulSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                CemeterySprites.ghoulSPR.setSize(600,500);
                CemeterySprites.ghostSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                CemeterySprites.ghostSPR.setSize(600,500);
                CemeterySprites.headlessHorsemanSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                CemeterySprites.headlessHorsemanSPR.setSize(600,500);
                CemeterySprites.skeletonSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                CemeterySprites.skeletonSPR.setSize(600,500);
                CemeterySprites.lumpOfFleshSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                CemeterySprites.lumpOfFleshSPR.setSize(600,500);
                Assets.mutantSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
                Assets.mutantSPR.setSize(600,500);
                minotaurSPR.setSize(600,500);
                minotaurSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
            }
        },1000);


    }

    public static void Die(Player player){
        Fight.fightON = 0;
        GameApp.fightON = 0;
        fightstart = 0;
        escape = 1;
        playerSprite.setPosition(Gdx.graphics.getWidth() / 2  + 7152, Gdx.graphics.getHeight() / 2  + 3384);
        Dawid.setXP(0);
        Dawid.setHP(Dawid.getMaxHP());
        Dawid.setX(4);
        Dawid.setY(4);

        Random random = new Random();
        Assets.attackSpr.setSize(0,0);
        Assets.iceSpr.setSize(0,0);
        adrenalineSPR.setSize(0,0);
        runSpr.setSize(0,0);

        Fight.joined = 1;
        Fight.doubleStrike = 0;

        PlayerStatusWearOff(player);
        Fight.escape = 1;
        Fight.fightON = 0;

        if (fightscreenSP.getHeight() > 1070){
            transitionOut = true;
        }
        GameApp.fightstart = 0;
        GameApp.sprite.setPosition(100000,100000);
        Fonts.enemyAttackText = " ";
        Fonts.playerAttackText = " ";
        Fonts.mobSpellText = " ";
        Fonts.leftText = "Controls: \n \n " +
                "Steering:  W, S, D, A \n \n Inventory: B \n \n Interact: Space \n \n Stats: P \n \n Quest log: L ";
        Fonts.topText = "1. Attack";
        Assets.attackSpr.setSize(0,0);
        Assets.iceSpr.setSize(0,0);
        adrenalineSPR.setSize(0,0);
        runSpr.setSize(0,0);
        PlayerStatusWearOff(player);
        if (fightscreenSP.getHeight() > 1070){
            transitionOut = true;
        }
        GameApp.fightstart = 0;
    }

    public static void blockInput(){

        if (inputWait) {
            Fight.inputBlocked = true;




            do {


                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (movedFrames < finalframes) {
                            System.out.println("dodaję wartość");
                            movedFrames++;
                        }  else if (movedFrames ==finalframes) {
                           inputWait = false;
                            movedFrames = 0;
                            Fight.inputBlocked = false;
                            System.out.println("koniec animaji");

                        }

                        camera.update();



                    }
                }, (long) 0.000001f);
            }
            while (inputWait);
        }
    }


}
