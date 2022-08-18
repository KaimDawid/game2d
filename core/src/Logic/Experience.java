package Logic;

import Mobs.Player;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Assets;
import com.mygdx.game.GameApp;
import com.mygdx.game.GameInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimerTask;

import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.stats;

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


    public static void expCounter(Player player) {


        int firstCap = 40;
        int secondCap = 100;
        int thirdCap = 250;
        int fourthCap = 400;
        int fifthCap = 700;
        int sixthCap = 1100;
        int seventhCap = 1700;
        int eighthCap = 2500;
        int ninthCap = 3500;
        int tenthCap = 5000;


        Scanner scanner = new Scanner(System.in);
        if (player.getXP() >= 40 && player.getLevel() == 0) {
            addPointsAndPrint(player, firstCap, 15, 5, 50);
            if (player.getClassNumber() == 1) {
                Curse.drawCurse(Dawid);
                LevelUp(player, 1,1);

            }

        } else if (player.getXP() >= 100 && player.getLevel() == 1) {
            addPointsAndPrint(player, secondCap, 15, 5, 50);
            if (player.getClassNumber() == 1) {

                LevelUp(player, 2,2);

            }

        } else if (player.getXP() >= 250 && player.getLevel() == 2) {

            addPointsAndPrint(player, thirdCap, 20, 5, 50);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 3,3);

            }

        } else if (player.getXP() >= fourthCap && player.getLevel() == 3) {
            addPointsAndPrint(player, fourthCap, 25, 5, 50);
            if (player.getClassNumber() == 1) {
                Curse.drawCurse(Dawid);
                LevelUp(player, 4,4);
            }


        } else if (player.getXP() >= fifthCap && player.getLevel() == 4) {

            addPointsAndPrint(player, fifthCap, 30, 5, 50);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 5, 5);
            }

        } else if (player.getXP() >= sixthCap && player.getLevel() == 5) {

            addPointsAndPrint(player, sixthCap, 30, 10, 50);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 6,6 );
            }


        } else if (player.getXP() >= seventhCap && player.getLevel() == 6) {

            addPointsAndPrint(player, seventhCap, 15, 5, 50);

            if (player.getClassNumber() == 1) {
                Curse.drawCurse(Dawid);
                LevelUp(player, 7, 7);
            }

        } else if (player.getXP() >= eighthCap && player.getLevel() == 7) {
            addPointsAndPrint(player, eighthCap, 15, 5, 50);
            if (player.getClassNumber() == 1) {

                LevelUp(player, 8, 8);
            }

        } else if (player.getXP() >= ninthCap && player.getLevel() == 8) {

            addPointsAndPrint(player, ninthCap, 15, 5, 50);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 9, 9);
            }


        } else if (player.getXP() >= tenthCap && player.getLevel() == 9) {

            addPointsAndPrint(player, tenthCap, 15, 5, 50);

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

    public static void LearnSkill(Player player, int skillNumber, int skillSlot) {
        String input;
        if (player.getChosenSkill1() != skillNumber && player.getChosenSkill2() != skillNumber && player.getChosenSkill3() != skillNumber &&
                player.getChosenSkill4() != skillNumber && player.getChosenSkill5() != skillNumber && player.getChosenSkill6() != skillNumber
                && player.getChosenSkill7() != skillNumber && player.getChosenSkill8() != skillNumber && player.getChosenSkill9() != skillNumber
                && player.getChosenSkill10() != skillNumber) {
            if (skillSlot == 1) {
                player.setChosenSkill1(skillNumber);
            } else if (skillSlot == 2) {
                player.setChosenSkill2(skillNumber);
            } else if (skillSlot == 3) {
                player.setChosenSkill3(skillNumber);
            } else if (skillSlot == 4) {
                player.setChosenSkill4(skillNumber);
            } else if (skillSlot == 5) {
                player.setChosenSkill5(skillNumber);
            } else if (skillSlot == 6) {
                player.setChosenSkill6(skillNumber);
            } else if (skillSlot == 7) {
                player.setChosenSkill7(skillNumber);
            } else if (skillSlot == 8) {
                player.setChosenSkill8(skillNumber);
            } else if (skillSlot == 9) {
                player.setChosenSkill9(skillNumber);
            } else if (skillSlot == 10) {
                player.setChosenSkill10(skillNumber);
            }
            lvlupInput = "0";
        } else {
            System.out.println("Umiesz już ten czar");
        }


    }
    public static void experienceCheck(){
        if (lvlupPoints > 0 && fightstart == 0){
            levelUpSprite.setSize(300,600);
            levelUpSprite.setPosition(playerSprite.getX()-300,playerSprite.getY() -200);
            if (Dawid.getChosenSkill1() != Player.ICE && Dawid.getChosenSkill2() != Player.ICE && Dawid.getChosenSkill3() != Player.ICE && Dawid.getChosenSkill4() != Player.ICE && Dawid.getChosenSkill5() != Player.ICE && Dawid.getChosenSkill6() != Player.ICE &&
                    Dawid.getChosenSkill7() != Player.ICE && Dawid.getChosenSkill8() != Player.ICE && Dawid.getChosenSkill9() != Player.ICE && Dawid.getChosenSkill10() != Player.ICE) {
                iceBoltSPR.setSize(200, 60);
            }
            else {
                iceBoltSPR.setSize(0,0);
            }
            if (Dawid.getChosenSkill1() != Player.FIREBALL && Dawid.getChosenSkill2() != Player.FIREBALL && Dawid.getChosenSkill3() != Player.FIREBALL && Dawid.getChosenSkill4() != Player.FIREBALL && Dawid.getChosenSkill5() != Player.FIREBALL && Dawid.getChosenSkill6() != Player.FIREBALL &&
                    Dawid.getChosenSkill7() != Player.FIREBALL && Dawid.getChosenSkill8() != Player.FIREBALL && Dawid.getChosenSkill9() != Player.FIREBALL && Dawid.getChosenSkill10() != Player.FIREBALL) {
                fireBallSPR.setSize(200, 60);
            }
            else {
                fireBallSPR.setSize(0,0);
            }
            if (Dawid.getChosenSkill1() != Player.ADRENALINE && Dawid.getChosenSkill2() != Player.ADRENALINE && Dawid.getChosenSkill3() != Player.ADRENALINE && Dawid.getChosenSkill4() != Player.ADRENALINE && Dawid.getChosenSkill5() != Player.ADRENALINE && Dawid.getChosenSkill6() != Player.ADRENALINE &&
                    Dawid.getChosenSkill7() != Player.ADRENALINE && Dawid.getChosenSkill8() != Player.ADRENALINE && Dawid.getChosenSkill9() != Player.ADRENALINE && Dawid.getChosenSkill10() != Player.ADRENALINE) {
                adrenalineSPR.setSize(200, 60);
            } else {
               adrenalineSPR.setSize(0,0);
            }
            if (Dawid.getChosenSkill1() != Player.IRONSKIN && Dawid.getChosenSkill2() != Player.IRONSKIN && Dawid.getChosenSkill3() != Player.IRONSKIN && Dawid.getChosenSkill4() != Player.IRONSKIN && Dawid.getChosenSkill5() != Player.IRONSKIN && Dawid.getChosenSkill6() != Player.IRONSKIN &&
                    Dawid.getChosenSkill7() != Player.IRONSKIN && Dawid.getChosenSkill8() != Player.IRONSKIN && Dawid.getChosenSkill9() != Player.IRONSKIN && Dawid.getChosenSkill10() != Player.IRONSKIN ) {
                ironskinSPR.setSize(200, 60);
            }
            else {
               ironskinSPR.setSize(0,0);
            }
            if (Dawid.getChosenSkill1() != Player.HEAL && Dawid.getChosenSkill2() != Player.HEAL && Dawid.getChosenSkill3() != Player.HEAL && Dawid.getChosenSkill4() != Player.HEAL && Dawid.getChosenSkill5() != Player.HEAL && Dawid.getChosenSkill6() != Player.HEAL &&
                    Dawid.getChosenSkill7() != Player.HEAL && Dawid.getChosenSkill8() != Player.HEAL && Dawid.getChosenSkill9() != Player.HEAL && Dawid.getChosenSkill10() != Player.HEAL ) {
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
            if (Dawid.getChosenSkill1() != Player.CLEAVE && Dawid.getChosenSkill2() != Player.CLEAVE && Dawid.getChosenSkill3() != Player.CLEAVE && Dawid.getChosenSkill4() != Player.CLEAVE && Dawid.getChosenSkill5() != Player.CLEAVE && Dawid.getChosenSkill6() != Player.CLEAVE &&
                    Dawid.getChosenSkill7() != Player.CLEAVE && Dawid.getChosenSkill8() != Player.CLEAVE && Dawid.getChosenSkill9() != Player.CLEAVE && Dawid.getChosenSkill10() != Player.CLEAVE ) {
                Assets.cleaveSPR.setSize(200, 60);
            }
            else {
                Assets.cleaveSPR.setSize(0,0);
            }


            iceBoltSPR.setPosition(levelUpSprite.getX()- 50, levelUpSprite.getY()+ 520);
            fireBallSPR.setPosition(levelUpSprite.getX() - 50, levelUpSprite.getY() + 440);
            adrenalineSPR.setPosition(levelUpSprite.getX()- 50, levelUpSprite.getY() + 360);
            ironskinSPR.setPosition(levelUpSprite.getX()- 50, levelUpSprite.getY() + 280);
            Assets.dualWieldSPR.setPosition(levelUpSprite.getX()- 50, levelUpSprite.getY() + 200);
            Assets.healSPR.setPosition(levelUpSprite.getX()- 50, levelUpSprite.getY() + 120);
            Assets.cleaveSPR.setPosition(levelUpSprite.getX()- 50, levelUpSprite.getY() + 40);

        }
        else{
            levelUpSprite.setSize(0,0);
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
                LearnSkill(GameApp.Dawid, Player.ICE, skillSlot);
                Experience.lvlupPoints--;
                skillSlot++;
                expScreen = 0 ;
                topText = "Nauczyłeś się lodowego pocisku!";
                // will be here when balloon will be touched
            }
            if (fireBallSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                LearnSkill(GameApp.Dawid, Player.FIREBALL, skillSlot);
                Experience.lvlupPoints--;
                skillSlot++;
                expScreen = 0 ;
                topText = "Nauczyłeś się kuli ognia!";
                // will be here when balloon will be touched
            }
            if (adrenalineSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                LearnSkill(GameApp.Dawid, Player.ADRENALINE, skillSlot);
                Experience.lvlupPoints--;
                skillSlot++;
                expScreen = 0 ;
                topText = "Nauczyłeś się Adrenaliny!";
                // will be here when balloon will be touched
            }
            if (ironskinSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                LearnSkill(GameApp.Dawid, Player.IRONSKIN, skillSlot);
                Experience.lvlupPoints--;
                skillSlot++;
                expScreen = 0 ;
                topText = "Nauczyłeś się Ironskin!";
                // will be here when balloon will be touched
            }
            camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.healSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                LearnSkill(GameApp.Dawid, Player.HEAL, skillSlot);
                Experience.lvlupPoints--;
                skillSlot++;
                expScreen = 0 ;
                topText = "Nauczyłeś się leczenia!";
                // will be here when balloon will be touched
            }
            camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.cleaveSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                LearnSkill(GameApp.Dawid, Player.CLEAVE, skillSlot);
                Experience.lvlupPoints--;
                skillSlot++;
                expScreen = 0 ;
                topText = "Nauczyłeś się Cleave!";
                // will be here when balloon will be touched
            }
            camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.dualWieldSPR.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
               Dawid.setWeaponCapacity(2);
                Experience.lvlupPoints = 0;
                skillSlot++;
                expScreen = 0 ;
                topText = "Nauczyłeś się Dual Wield!";
                // will be here when balloon will be touched
            }
        }

    }
    public static void LevelUp(Player player, int skillSlot, int nextLevel) {

        Assets.levelupSPR.setSize(700,250);

        batch.begin();
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
/*if (lvlupPoints > 0) {

    GameApp.topText = " Wybierz czar którego chcesz się nauczyć: ";
    if (Gdx.input.justTouched()) {
        camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        if (levelUpSprite.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
            LearnSkill(GameApp.Dawid, Player.FIREBALL, skillSlot);
            lvlupPoints = 0;
            topText = "Nauczyłeś się kuli ognia!";
            // will be here when balloon will be touched
        }
    }
    if(Gdx.input.justTouched())
    {
        //unprojects the camera
        camera.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(),0));
        if(levelUpSprite.getBoundingRectangle().contains(touchPoint.x,touchPoint.y))
        {

            // will be here when balloon will be touched
        }
    }
    if (Gdx.input.justTouched()) {
        camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        if (Assets.attackSpr.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
            LearnSkill(GameApp.Dawid, Player.ADRENALINE, skillSlot);
            lvlupPoints = 0;
            // will be here when balloon will be touched
        }
    }
    if (Gdx.input.justTouched()) {
        camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        if (Assets.attackSpr.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
            LearnSkill(GameApp.Dawid, Player.TP, skillSlot);
            lvlupPoints = 0;
            // will be here when balloon will be touched
        }
    }
    if (Gdx.input.justTouched()) {
        camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        if (Assets.attackSpr.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
            LearnSkill(GameApp.Dawid, Player.IRONSKIN, skillSlot);
            // will be here when balloon will be touched
            lvlupPoints = 0;
        }
    }
}
       else {

    System.out.println("Nauczyłeś się nowej umiejętności!");
    player.setLevel(nextLevel);
}*/

    }

    public static void addPointsAndPrint(Player player, int cap, int hpUP, int dmgUP, int manaUP) {
        lvlupPoints++ ;

        player.setMaxHP(player.getMaxHP() + hpUP);
        player.setHP(player.getMaxHP());
        player.setDMG(player.getDMG() + dmgUP);
        player.setXP(player.getXP() - levelCap);
        player.setLevel(player.getLevel() + 1);
        bottomText = "Gratulacje, zdobyłeś kolejny poziom doświadczenia! ";
        System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
        System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(), player.getMaxHP());
        System.out.println("Twoje nowe obrażenia: " + player.getDMG());
        player.setAttributePoints(player.getAttributePoints() + 5);
        System.out.println("Otrzymałeś też " + player.getAttributePoints() + " punktów umiejętności");
        player.setMaxMana(player.getMaxMana() + manaUP);
        player.setMana(player.getMaxMana());
    }

    public static void ExpDisplay(Player player, int cap){
        bottomText = "Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                "/" + cap + " punktów doświadczenia";

    }

    public static void PrintSkill(int skillNumber, Player player, String description){
        if (player.getChosenSkill1() != skillNumber && player.getChosenSkill2() != skillNumber && player.getChosenSkill3() != skillNumber &&
                player.getChosenSkill4() != skillNumber && player.getChosenSkill5() != skillNumber && player.getChosenSkill6() != skillNumber
                && player.getChosenSkill7() != skillNumber && player.getChosenSkill8() != skillNumber && player.getChosenSkill9() != skillNumber
                && player.getChosenSkill10() != skillNumber){
            System.out.println(description);
        }
    }

}


