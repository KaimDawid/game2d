package Logic;

import Logic.FightLogic.Skills.*;
import Mobs.Player;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;

import java.util.Scanner;
import java.util.TimerTask;

import static com.mygdx.game.GameApp.*;

public class Experience {

    public static String lvlupInput;
    public static int lvlupPoints;
public static int skillSlot  = 1;
    public static String iceDescription = "1. Lodowy pocisk (zamraża przeciwnika na 2 tury, 20p many)";

    public static String fireDescription = "2. Kula ognia (zadaje 120 obrażeń, 50p many)";
    public static String tpDescription = "3. Teleportacja (przenieś się na dowolne pole, darmowe)";
    public static String adrenalineDescription = "4. Adrenalina (Zadajesz i przyjmujesz więcej obrażeń)";
    public static String ironskinDescription = "5. Skóra z żelaza (+30 armor w trakcie walki)";
    public static String dualWieldDescripion = "6. Dual Wielding (Możesz używać dwóch lekkich broni naraz)";
    public static String cleaveDescription = "7. Cleave (Atakujesz 2 potwory naraz ze zwiększoną siłą)";
    public static String healDescription = "8. Heal (Leczysz się za koszt many)";
    public static int levelCap = 0;

    public static int firstCap = 40, secondCap = 200, thirdCap = 400,  fourthCap = 700, fifthCap = 1100, sixthCap = 2000,
            seventhCap = 3500, eighthCap = 6000, ninthCap = 10000, tenthCap = 20000;


    public static void expCounter(Player player) {






        Scanner scanner = new Scanner(System.in);
        if (player.getXP() >= firstCap && player.getLevel() == 0) {
            addPointsAndPrint(player, firstCap, 30, 5, 10);
            if (player.getClassNumber() == 1) {
/*                Curse.drawCurse(Dawid);*/
                LevelUp(player, 1,1);

            }

        } else if (player.getXP() >= secondCap && player.getLevel() == 1) {
            addPointsAndPrint(player, secondCap, 30, 5, 10);
            if (player.getClassNumber() == 1) {

                LevelUp(player, 2,2);

            }

        } else if (player.getXP() >= thirdCap && player.getLevel() == 2) {

            addPointsAndPrint(player, thirdCap, 40, 5, 10);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 3,3);

            }

        } else if (player.getXP() >= fourthCap && player.getLevel() == 3) {
            addPointsAndPrint(player, fourthCap, 50, 5, 10);
            if (player.getClassNumber() == 1) {
             /*   Curse.drawCurse(Dawid);*/
                LevelUp(player, 4,4);
            }


        } else if (player.getXP() >= fifthCap && player.getLevel() == 4) {

            addPointsAndPrint(player, fifthCap, 50, 5, 10);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 5, 5);
            }

        } else if (player.getXP() >= sixthCap && player.getLevel() == 5) {

            addPointsAndPrint(player, sixthCap, 50, 10, 20);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 6,6 );
            }


        } else if (player.getXP() >= seventhCap && player.getLevel() == 6) {

            addPointsAndPrint(player, seventhCap, 50, 5, 20);

            if (player.getClassNumber() == 1) {
                /*Curse.drawCurse(Dawid);*/
                LevelUp(player, 7, 7);
            }

        } else if (player.getXP() >= eighthCap && player.getLevel() == 7) {
            addPointsAndPrint(player, eighthCap, 15, 5, 30);
            if (player.getClassNumber() == 1) {

                LevelUp(player, 8, 8);
            }

        } else if (player.getXP() >= ninthCap && player.getLevel() == 8) {

            addPointsAndPrint(player, ninthCap, 15, 5, 30);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 9, 9);
            }


        } else if (player.getXP() >= tenthCap && player.getLevel() == 9) {

            addPointsAndPrint(player, tenthCap, 15, 5, 30);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 10, 10);
            }

        }
        if (player.getLevel() == 0 && player.getHP() > 0) {
            ExpDisplay(player, firstCap);

        } else if (player.getLevel() == 1 && player.getHP() > 0) {
            ExpDisplay(player, secondCap);

        } else if (player.getLevel() == 2 && player.getHP() > 0) {
            ExpDisplay(player, thirdCap);

        } else if (player.getLevel() == 3 && player.getHP() > 0) {
            ExpDisplay(player, fourthCap);

        } else if (player.getLevel() == 4 && player.getHP() > 0) {
            ExpDisplay(player, fifthCap);

        } else if (player.getLevel() == 5 && player.getHP() > 0) {
            ExpDisplay(player, sixthCap);

        } else if (player.getLevel() == 6 && player.getHP() > 0) {
            ExpDisplay(player, seventhCap);

        } else if (player.getLevel() == 7 && player.getHP() > 0) {
            ExpDisplay(player, eighthCap);

        } else if (player.getLevel() == 8 && player.getHP() > 0) {
            ExpDisplay(player, ninthCap);

        } else if (player.getLevel() == 9 && player.getHP() > 0) {
            ExpDisplay(player, tenthCap);

        } else if (player.getLevel() == 10 && player.getHP() > 0) {
            System.out.println("Osiągnąłeś maksymalny poziom doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
    }


    public static void experienceCheck(){
        if (lvlupPoints > 0 && fightstart == 0){
            Fonts.levelUpSprite.setSize(300,600);
            Fonts.levelUpSprite.setPosition(playerSprite.getX()-300,playerSprite.getY() -200);
            if (!Icebolt.learned) {
                iceBoltSPR.setSize(200, 60);
            }
            else {
                iceBoltSPR.setSize(0,0);
                    }
            if (!Fireball.learned) {
                fireBallSPR.setSize(200, 60);
                batch.begin();
                fireBallSPR.draw(batch);
                batch.end();
            }
            else {
                fireBallSPR.setSize(0,0);
            }
            if (!Adrenaline.learned) {
                adrenalineSPR.setSize(200, 60);
            } else {
               adrenalineSPR.setSize(0,0);
            }
            if (!Ironskin.learned) {
                ironskinSPR.setSize(200, 60);
            }
            else {
               ironskinSPR.setSize(0,0);
            }
            if (!Heal.learned) {
                Assets.healSPR.setSize(200, 60);
            }
            else {
                Assets.healSPR.setSize(0,0);
            }
            if (Dawid.getWeaponCapacity() < 2) {
                Assets.dualWieldSPR.setSize(200, 60);
            }
            else {
               Assets.dualWieldSPR.setSize(0,0);
            }
            if (!Cleave.learned ) {
                Assets.cleaveSPR.setSize(200, 60);
            }
            else {
                Assets.cleaveSPR.setSize(0,0);
            }


            iceBoltSPR.setPosition(Fonts.levelUpSprite.getX()- 50, Fonts.levelUpSprite.getY()+ 520);
            fireBallSPR.setPosition(Fonts.levelUpSprite.getX() - 50, Fonts.levelUpSprite.getY() + 440);
            adrenalineSPR.setPosition(Fonts.levelUpSprite.getX()- 50, Fonts.levelUpSprite.getY() + 360);
            ironskinSPR.setPosition(Fonts.levelUpSprite.getX()- 50, Fonts.levelUpSprite.getY() + 280);
            Assets.dualWieldSPR.setPosition(Fonts.levelUpSprite.getX()- 50, Fonts.levelUpSprite.getY() + 200);
            Assets.healSPR.setPosition(Fonts.levelUpSprite.getX()- 50, Fonts.levelUpSprite.getY() + 120);
            Assets.cleaveSPR.setPosition(Fonts.levelUpSprite.getX()- 50, Fonts.levelUpSprite.getY() + 40);

        }
        else{
            Fonts.levelUpSprite.setSize(0,0);
            iceBoltSPR.setSize(0,0);
            fireBallSPR.setSize(0,0);
            adrenalineSPR.setSize(0,0);
            ironskinSPR.setSize(0,0);
            Assets.cleaveSPR.setSize(0,0);
            Assets.dualWieldSPR.setSize(0,0);
            Assets.healSPR.setSize(0,0);
        }
        if (Gdx.input.justTouched()) {




            camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (iceBoltSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                Icebolt.learned = true;
                Experience.lvlupPoints--;
                expScreen = 0 ;
                Fonts.topText = "Nauczyłeś się lodowego pocisku!";
                // will be here when balloon will be touched
            }
            if (fireBallSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                Fireball.learned = true;
                Experience.lvlupPoints--;
                expScreen = 0 ;
                Fonts.topText = "Nauczyłeś się kuli ognia!";
                // will be here when balloon will be touched
            }
            if (adrenalineSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                Adrenaline.learned = true;
                Experience.lvlupPoints--;
                expScreen = 0 ;
                Fonts.topText = "Nauczyłeś się Adrenaliny!";
                // will be here when balloon will be touched
            }
            if (ironskinSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                Ironskin.learned = true;
                Experience.lvlupPoints--;
                expScreen = 0 ;
                Fonts.topText = "Nauczyłeś się Ironskin!";
                // will be here when balloon will be touched
            }
            camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.healSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                Heal.learned = true;
                Experience.lvlupPoints--;
                expScreen = 0 ;
                Fonts.topText = "Nauczyłeś się leczenia!";
                // will be here when balloon will be touched
            }
            camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.cleaveSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                Cleave.learned = true;
                Experience.lvlupPoints--;
                expScreen = 0 ;
                Fonts.topText = "Nauczyłeś się Cleave!";
                // will be here when balloon will be touched
            }
            camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.dualWieldSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                DualWield.learned = true;
               Dawid.setWeaponCapacity(2);
                Experience.lvlupPoints--;
                expScreen = 0 ;
                Fonts.topText = "Nauczyłeś się Dual Wield!";
                // will be here when balloon will be touched
            }
        }

    }
    public static void LevelUp(Player player, int skillSlot, int nextLevel) {
Assets.addAttributeSPR.setSize(450,600);
        Assets.levelupSPR.setSize(700,250);

        batch.begin();
        Assets.addAttributeSPR.draw(batch);
        Assets.levelupSPR.draw(batch);
        batch.end();
GameApp.expScreen  = 1;
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        Assets.levelupSPR.setSize(0,0);
    }
},3000);
            Scanner scanner = new Scanner(System.in);
            PrintSkill(Player.ICE, player, iceDescription);
            PrintSkill(Player.FIREBALL, player, fireDescription);
            PrintSkill(Player.TP, player, tpDescription);
            PrintSkill(Player.ADRENALINE, player, adrenalineDescription);
            PrintSkill(Player.IRONSKIN, player, ironskinDescription);
            PrintSkill(Player.HEAL, player, healDescription);
            if (player.getWeaponCapacity() < 2){
                System.out.println("6. Dual Wielding (Możesz używać dwóch lekkich broni naraz)");
            }
            PrintSkill(Player.CLEAVE, player, cleaveDescription);
            PrintSkill(Player.HEAL, player, healDescription);

    }

    public static void addPointsAndPrint(Player player, int cap, int hpUP, int dmgUP, int manaUP) {
        lvlupPoints++ ;

        player.setMaxHP(player.getMaxHP() + hpUP);
        player.setHP(player.getMaxHP());
        player.setDMG(player.getDMG() + dmgUP);
        player.setXP(player.getXP() - levelCap);
        player.setLevel(player.getLevel() + 1);
        Fonts.bottomText = "Gratulacje, zdobyłeś kolejny poziom doświadczenia! ";
        System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
        System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(), player.getMaxHP());
        System.out.println("Twoje nowe obrażenia: " + player.getDMG());
        player.setAttributePoints(player.getAttributePoints() + 5);
        System.out.println("Otrzymałeś też " + player.getAttributePoints() + " punktów umiejętności");
        player.setMaxMana(player.getMaxMana() + manaUP);
        player.setMana(player.getMaxMana());
    }

    public static void ExpDisplay(Player player, int cap){
        Fonts.bottomText = "LEVEL " + player.getLevel() + " \n XP: " + player.getXP() +
                "/" + cap + " \n " +
                "GOLD: " + player.getGold();

    }

    public static void PrintSkill(int skillNumber, Player player, String description){
        if (player.getChosenSkill1() != skillNumber && player.getChosenSkill2() != skillNumber && player.getChosenSkill3() != skillNumber &&
                player.getChosenSkill4() != skillNumber && player.getChosenSkill5() != skillNumber && player.getChosenSkill6() != skillNumber
                && player.getChosenSkill7() != skillNumber && player.getChosenSkill8() != skillNumber && player.getChosenSkill9() != skillNumber
                && player.getChosenSkill10() != skillNumber){
            System.out.println(description);
        }
    }

    public static void showXP(Player gracz){
        if (Dawid.getLevel() == 0) {
            levelCap = firstCap;
        }
        if (Dawid.getLevel() == 1) {
            levelCap = secondCap;
        }
        if (Dawid.getLevel() == 2) {
            levelCap = thirdCap;
        }
        if (Dawid.getLevel() == 3) {
            levelCap = fourthCap;
        }
        if (Dawid.getLevel() == 4) {
            levelCap = fifthCap;
        }
        if (Dawid.getLevel() == 5) {
            levelCap = sixthCap;
        }
    }
}


