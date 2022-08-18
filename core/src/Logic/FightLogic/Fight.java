package Logic.FightLogic;

import Logic.GameLogic;
import Mobs.Monster;
import Mobs.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.Assets;
import com.mygdx.game.GameApp;

import java.awt.*;
import java.util.Random;

import static com.badlogic.gdx.Gdx.*;
import static com.mygdx.game.GameApp.*;


public class Fight {

    static final int BDMG = 80;
    public static int joined = 1;
    public static int doubleStrike = 0;

    public static int ironSkinDuration;

    public static int adrenalineDuration;
    public static int fightON = 0;

    void isFrozen(Player player) {
        if (player.getFreeze() > 0) {
            System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
        }
    }

    public static void groupFight(Monster[] monsterTable, Player player) {





        Random random = new Random();
        if (doubleStrike == 0) {
            joined = 1;
           /* do {

                if ((GameLogic.monsterBase[joined].getX() - player.getX() == 1 || player.getX() - GameLogic.monsterBase[joined].getX() == 1) &&
                        (GameLogic.monsterBase[joined].getY() - player.getY() == 1 || player.getY() - GameLogic.monsterBase[joined].getY() == 1)
                ) {

                    int chance = random.nextInt(100);
                    if (chance > 91) {
                        System.out.println(GameLogic.monsterBase[joined].getName() + " dołączył do walki!");
                        doubleStrike = 1;
                        joined--;
                    }
                }
                joined++;
            } while (joined < 2 && doubleStrike == 0);*/
        }

    }

    public static int escape = 0;
    public static void Turn(Player player, Monster monster) throws InterruptedException {



        sprite.setPosition(playerSprite.getX()+ 300,playerSprite.getY());
        goblinSprite.setSize(600,500);
        spiderSprite.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        goblinSprite.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.banditSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.banditchiefSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.banditSPR.setSize(600,500);
        Assets.banditchiefSPR.setSize(600,500);
        Assets.wolfSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.werewolfSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.wolfSPR.setSize(600,500);
        Assets.werewolfSPR.setSize(600,500);
        Assets.vampireSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.vampireSPR.setSize(600,500);
        Assets.mutantSPR.setPosition(playerSprite.getX()+ 300, playerSprite.getY());
        Assets.mutantSPR.setSize(600,500);
        escape = 0;
        if (fightstart == 1){
            enemybar.setPosition(sprite.getX()+200,sprite.getY() - 30);
            enemybar.setSize(200,60);
            enemybargreen.setSize((float) (200*(monster.getHp()/monster.getMaxHP())), GameApp.hbSPR.getHeight());
            enemybargreen.setPosition(sprite.getX() + 200,sprite.getY() - 30);
            batch.begin();
            enemybargreen.draw(batch);
            enemybar.draw(batch);
            batch.end();
        }
        if (monster.getGlb() == 1){
            batch.begin();
sprite.set(goblinSprite);
sprite.draw(batch);
batch.end();
        }
        if (monster.getSpid() == 1){
            batch.begin();
            sprite.set(spiderSprite);
            sprite.draw(batch);
            batch.end();
        }
        if (monster.getVamp() == 1){
batch.begin();
sprite.set(Assets.vampireSPR);
sprite.draw(batch);
batch.end();
        }
        if (monster.getBand() == 1){
            batch.begin();
            sprite.set(Assets.banditSPR);
            sprite.draw(batch);
            batch.end();
        }
        if (monster.getBandchief() == 1){
            batch.begin();
            sprite.set(Assets.banditchiefSPR);
            sprite.draw(batch);
            batch.end();
        }
        if (monster.getWolv() == 1){
            batch.begin();
            sprite.set(Assets.wolfSPR);
            sprite.draw(batch);
            batch.end();
        }
        if (monster.getWewolf() == 1){
            batch.begin();
            sprite.set(Assets.werewolfSPR);
            sprite.draw(batch);
            batch.end();
        }
        if (monster.getMutant() == 1){
            batch.begin();
            sprite.set(Assets.mutantSPR);
            sprite.draw(batch);
            batch.end();
        }
        int toxic = 0;
if (Dawid.getHP() <=0){
    fightON = 0;
    fightstart = 0;
    escape = 1;
    playerSprite.setPosition(1000,1000);
    Dawid.setXP(0);
    Dawid.setHP(Dawid.getMaxHP());
Dawid.setX(4);
Dawid.setY(4);


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
}
        int burnDMG = 40;

            /* do {
             */
            /*if (player.getIronSkinValue() > 0) {
                player.setIronSkinValue(player.getIronSkinValue() - 1);
                if (player.getIronSkinValue() == 0){
                    player.setArmor(player.getArmor() - 30);
                    System.out.println("Ironskin przestał działać.");
                }
            }
            if (player.getAdrenalineValue() > 0) {
                player.setAdrenalineValue(player.getAdrenalineValue() - 1);
                if (player.getAdrenalineValue() == 0){
                    player.setDMG((int) (player.getDMG() * 0.71));
                    player.setArmor(player.getArmor() + 40);
                    System.out.println("Adrenalina przestała działać.");
                }
            }*/


           /* System.out.println("Twoje punkty zdrowia: " + player.getHP() + "/" + player.getMaxHP() + " Twoje obrażenia :"
                    + player.getDMG() + "            Mana: " + player.getMana());*/
/*
            if (monster.getHp() > 0) {
                System.out.println("Punkty zdrowia przeciwnika: " + monster.getHp() + " Jego obrażenia: " + monster.getDmg());
            } else if (monster.getHp() < 1) {
                System.out.println(monster.getName() + " jest martwy");
            }
            if (doubleStrike == 1 && GameLogic.monsterBase[joined].getHp() > 0) {
                System.out.println("Punkty zdrowia drugiego przeciwnika (" + GameLogic.monsterBase[joined].getName() + ") : " + GameLogic.monsterBase[joined].getHp());
            } else if (doubleStrike == 1 && GameLogic.monsterBase[joined].getHp() < 1) {
                System.out.println(GameLogic.monsterBase[joined].getName() + " jest martwy");
            }
            if (doubleStrike == 1) {
                System.out.println("Uważaj na siebie, walczysz z dwoma przeciwnikami! " + monster.getName() + " i "
                        + GameLogic.monsterBase[joined].getName());
            }*/
        if (player.getChosenSkill1() == Player.ICE || player.getChosenSkill2() == Player.ICE
                || player.getChosenSkill3() == Player.ICE || player.getChosenSkill4() == Player.ICE || player.getChosenSkill5() ==
                Player.ICE || player.getChosenSkill6() == Player.ICE || player.getChosenSkill7() == Player.ICE
                || player.getChosenSkill8() == Player.ICE || player.getChosenSkill9() == Player.ICE || player.getChosenSkill10() ==
                Player.ICE && fightstart == 1){
            getIceBoltSPR2.setSize(200, 60);
            getIceBoltSPR2.setPosition(playerSprite.getX() - 900, playerSprite.getY() - 100);
        }
        if (player.getChosenSkill1() == Player.FIREBALL || player.getChosenSkill2() == Player.FIREBALL
                || player.getChosenSkill3() == Player.FIREBALL || player.getChosenSkill4() == Player.FIREBALL || player.getChosenSkill5() ==
                Player.FIREBALL || player.getChosenSkill6() == Player.FIREBALL || player.getChosenSkill7() == Player.FIREBALL
                || player.getChosenSkill8() == Player.FIREBALL || player.getChosenSkill9() == Player.FIREBALL || player.getChosenSkill10() ==
                Player.FIREBALL && fightstart == 1){
            fireBallSPR2.setSize(200, 60);
            fireBallSPR2.setPosition(playerSprite.getX() - 600, playerSprite.getY() - 100);
        }
        if (player.getChosenSkill1() == Player.CLEAVE || player.getChosenSkill2() == Player.CLEAVE
                || player.getChosenSkill3() == Player.CLEAVE || player.getChosenSkill4() == Player.CLEAVE || player.getChosenSkill5() ==
                Player.CLEAVE || player.getChosenSkill6() == Player.CLEAVE || player.getChosenSkill7() == Player.CLEAVE
                || player.getChosenSkill8() == Player.CLEAVE || player.getChosenSkill9() == Player.CLEAVE || player.getChosenSkill10() ==
                Player.CLEAVE && fightstart == 1){
            cleaveSPR2.setPosition(playerSprite.getX()-300, playerSprite.getY() - 100);
            cleaveSPR2.setSize(200,60);
        }
        if (player.getChosenSkill1() == Player.HEAL || player.getChosenSkill2() == Player.HEAL
                || player.getChosenSkill3() == Player.HEAL || player.getChosenSkill4() == Player.HEAL || player.getChosenSkill5() ==
                Player.HEAL || player.getChosenSkill6() == Player.HEAL || player.getChosenSkill7() == Player.HEAL
                || player.getChosenSkill8() == Player.HEAL || player.getChosenSkill9() == Player.HEAL || player.getChosenSkill10() ==
                Player.HEAL && fightstart == 1){
            healSPR2.setSize(200, 60);
            healSPR2.setPosition(playerSprite.getX(), playerSprite.getY() - 100);
        }
        if (player.getChosenSkill1() == Player.ADRENALINE || player.getChosenSkill2() == Player.ADRENALINE
                || player.getChosenSkill3() == Player.ADRENALINE || player.getChosenSkill4() == Player.ADRENALINE || player.getChosenSkill5() ==
                Player.ADRENALINE || player.getChosenSkill6() == Player.ADRENALINE || player.getChosenSkill7() == Player.ADRENALINE
                || player.getChosenSkill8() == Player.ADRENALINE || player.getChosenSkill9() == Player.ADRENALINE || player.getChosenSkill10() ==
                Player.ADRENALINE && fightstart == 1){
            getAdrenalineSPR2.setSize(200,60);
            getAdrenalineSPR2.setPosition(playerSprite.getX() + 300, playerSprite.getY() - 100);
        }
        if (player.getChosenSkill1() == Player.IRONSKIN || player.getChosenSkill2() == Player.IRONSKIN
                || player.getChosenSkill3() == Player.IRONSKIN || player.getChosenSkill4() == Player.IRONSKIN || player.getChosenSkill5() ==
                Player.IRONSKIN || player.getChosenSkill6() == Player.IRONSKIN || player.getChosenSkill7() == Player.IRONSKIN
                || player.getChosenSkill8() == Player.IRONSKIN || player.getChosenSkill9() == Player.IRONSKIN || player.getChosenSkill10() ==
                Player.IRONSKIN && fightstart == 1){
            ironskinSPR2.setSize(200, 60);
            ironskinSPR2.setPosition(playerSprite.getX() + 600, playerSprite.getY() - 100 );
        }
            groupFight(GameLogic.monsterBase, player);
        if(Gdx.input.justTouched())
        {
            //unprojects the camera
            camera.unproject(touchPoint.set(Gdx.input.getX(),Gdx.input.getY(),0));
            if(Assets.attackSpr.getBoundingRectangle().contains(touchPoint.x,touchPoint.y))
            {
                player.Attack(monster, player);
                /* }*/
                stats = new TextField("Zadałeś " + player.getDMG() + " obrażeń");

                if (monster.getFreeze() == 0) {
                    EnemyAttack(player, monster);
                }
                else {
                    enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury!";
                }
                FightLogic.StatusConclude(Dawid,monster);

                // will be here when balloon will be touched
            }
        }
        if(Gdx.input.justTouched())

                {
                    //unprojects the camera
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (getIceBoltSPR2.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        player.Freeze(monster);
                        if (monster.getFreeze() == 0) {
                            EnemyAttack(player, monster);
                        }
                        else {
                            enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury!";
                        }
                        FightLogic.StatusConclude(Dawid,monster);
                        // will be here when balloon will be touched
                    }
                }

        if(Gdx.input.justTouched())
            if (player.getChosenSkill1() == Player.ICE || player.getChosenSkill2() == Player.ICE
                    || player.getChosenSkill3() == Player.ICE || player.getChosenSkill4() == Player.ICE || player.getChosenSkill5() ==
                    Player.ICE || player.getChosenSkill6() == Player.ICE || player.getChosenSkill7() == Player.ICE
                    || player.getChosenSkill8() == Player.ICE || player.getChosenSkill9() == Player.ICE || player.getChosenSkill10() ==
                    Player.ICE){
                {
                    //unprojects the camera
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (getIceBoltSPR2.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        player.Freeze(monster);
                        if (monster.getFreeze() == 0) {
                            EnemyAttack(player, monster);
                        }
                        else {
                            enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury!";
                        }
                        FightLogic.StatusConclude(Dawid,monster);
                        // will be here when balloon will be touched
                    }
                }
            }
        if(Gdx.input.justTouched())
            if (player.getChosenSkill1() == Player.HEAL || player.getChosenSkill2() == Player.HEAL
                    || player.getChosenSkill3() == Player.HEAL || player.getChosenSkill4() == Player.HEAL || player.getChosenSkill5() ==
                    Player.HEAL || player.getChosenSkill6() == Player.HEAL || player.getChosenSkill7() == Player.HEAL
                    || player.getChosenSkill8() == Player.HEAL || player.getChosenSkill9() == Player.HEAL || player.getChosenSkill10() ==
                    Player.HEAL){
                {
                    //unprojects the camera
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (healSPR2.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        player.Heal(Dawid);
                        if (monster.getFreeze() == 0) {
                            EnemyAttack(player, monster);
                        }
                        else {
                            enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury!";
                        }
                        FightLogic.StatusConclude(Dawid,monster);
                        // will be here when balloon will be touched
                    }
                }
            }
        if(Gdx.input.justTouched())
            if (player.getChosenSkill1() == Player.FIREBALL || player.getChosenSkill2() == Player.FIREBALL
                    || player.getChosenSkill3() == Player.FIREBALL || player.getChosenSkill4() == Player.FIREBALL || player.getChosenSkill5() ==
                    Player.FIREBALL || player.getChosenSkill6() == Player.FIREBALL || player.getChosenSkill7() == Player.FIREBALL
                    || player.getChosenSkill8() == Player.FIREBALL || player.getChosenSkill9() == Player.FIREBALL || player.getChosenSkill10() ==
                    Player.FIREBALL){
                {
                    //unprojects the camera
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (fireBallSPR2.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        player.Fireball(monster, player);
                        if (monster.getFreeze() == 0) {
                            EnemyAttack(player, monster);
                        }
                        else {
                            enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury!";
                        }
                        FightLogic.StatusConclude(Dawid,monster);
                        // will be here when balloon will be touched
                    }
                }
            }
        if(Gdx.input.justTouched())
            if (player.getChosenSkill1() == Player.IRONSKIN || player.getChosenSkill2() == Player.IRONSKIN
                    || player.getChosenSkill3() == Player.IRONSKIN || player.getChosenSkill4() == Player.IRONSKIN || player.getChosenSkill5() ==
                    Player.IRONSKIN || player.getChosenSkill6() == Player.IRONSKIN || player.getChosenSkill7() == Player.IRONSKIN
                    || player.getChosenSkill8() == Player.IRONSKIN || player.getChosenSkill9() == Player.IRONSKIN || player.getChosenSkill10() ==
                    Player.IRONSKIN){
                {
                    //unprojects the camera
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (ironskinSPR2.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        player.IronSkin(player);
                        if (monster.getFreeze() == 0) {
                            EnemyAttack(player, monster);
                        }
                        else {
                            enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury!";
                        }
                        FightLogic.StatusConclude(Dawid,monster);
                        // will be here when balloon will be touched
                    }
                }
            }
        if(Gdx.input.justTouched())
            if (player.getChosenSkill1() == Player.ADRENALINE || player.getChosenSkill2() == Player.ADRENALINE
                    || player.getChosenSkill3() == Player.ADRENALINE || player.getChosenSkill4() == Player.ADRENALINE || player.getChosenSkill5() ==
                    Player.ADRENALINE || player.getChosenSkill6() == Player.ADRENALINE || player.getChosenSkill7() == Player.ADRENALINE
                    || player.getChosenSkill8() == Player.ADRENALINE || player.getChosenSkill9() == Player.ADRENALINE || player.getChosenSkill10() ==
                    Player.ADRENALINE){
                {
                    //unprojects the camera
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (getAdrenalineSPR2.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        player.Adrenaline(player);
                        if (monster.getFreeze() == 0) {
                            EnemyAttack(player, monster);
                        }
                        else {
                            enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury!";
                        }
                        FightLogic.StatusConclude(Dawid,monster);
                        // will be here when balloon will be touched
                    }
                }
            }
        if(Gdx.input.justTouched())
            if (player.getChosenSkill1() == Player.CLEAVE || player.getChosenSkill2() == Player.CLEAVE
                    || player.getChosenSkill3() == Player.CLEAVE || player.getChosenSkill4() == Player.CLEAVE || player.getChosenSkill5() ==
                    Player.CLEAVE || player.getChosenSkill6() == Player.CLEAVE || player.getChosenSkill7() == Player.CLEAVE
                    || player.getChosenSkill8() == Player.CLEAVE || player.getChosenSkill9() == Player.CLEAVE || player.getChosenSkill10() ==
                    Player.CLEAVE){
                {
                    //unprojects the camera
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
                    if (cleaveSPR2.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
                        player.Cleave(player,monster,monster);
                        if (monster.getFreeze() == 0) {
                            EnemyAttack(player, monster);
                        }
                        else {
                            enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury!";
                        }
                        FightLogic.StatusConclude(Dawid,monster);
                        // will be here when balloon will be touched
                    }
                }
            }

            if (input.isKeyJustPressed(Input.Keys.NUM_1)) {

        /* if (player.getAdrenalineValue() == 0 && player.getChosenSkill1() == Player.ADRENALINE || player.getChosenSkill2() == Player.ADRENALINE
                 || player.getChosenSkill3() == Player.ADRENALINE || player.getChosenSkill4() == Player.ADRENALINE || player.getChosenSkill5() ==
                 Player.ADRENALINE || player.getChosenSkill6() == Player.ADRENALINE || player.getChosenSkill7() == Player.ADRENALINE
                 || player.getChosenSkill8() == Player.ADRENALINE || player.getChosenSkill9() == Player.ADRENALINE || player.getChosenSkill10() == Player.ADRENALINE) {
             player.Adrenaline(player);
             player.setAdrenalineValue(1);
             adrenalineDuration = 3;
         } else {*/
                player.Attack(monster, player);
                /* }*/
                stats = new TextField("Zadałeś " + player.getDMG() + " obrażeń");

                if (monster.getFreeze() == 0) {
                    EnemyAttack(player, monster);
                }
                else {
                    enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury!";
                }
                FightLogic.StatusConclude(Dawid,monster);
                /*stats.setText("Przeciwnik zadał " + monster.getDmg() + " obrażeń");*/


 }
 if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {

                if (player.getIronSkinValue() == 0) {
                    player.IronSkin(player);
                    player.setIronSkinValue(1);
                    ironSkinDuration = 3;
                } else {
                    player.Attack(monster, player);
                }
     if (monster.getFreeze() == 0) {
         EnemyAttack(player, monster);
     }
     else {
         enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury!";
     }
     FightLogic.StatusConclude(Dawid,monster);

 }
                if (Gdx.input.isKeyJustPressed(Input.Keys.X)) {
                    if (doubleStrike == 0) {
                        if (player.getFreeze() < 1) {
                            player.Attack(monster, player);
                            System.out.println("Zaatakowałeś");
                        } else if (player.getFreeze() > 0) {
                            System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                            player.setFreeze(player.getFreeze() - 1);
                        }
                        EnemyAttack(player, monster);
                    } else if (doubleStrike == 1) {
                        FightLogic.WhoDoYouWantToAttack(monster);
                    }
                    FightLogic.StatusConclude(Dawid,monster);


if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)){

                    if (player.getFreeze() < 1) {
                        player.Attack(monster, player);
                    } else if (player.getFreeze() > 0) {
                        System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                        player.setFreeze(player.getFreeze() - 1);
                    }
                    if (monster.getFreeze() == 0) {
                        EnemyAttack(player, monster);
                    }
                    else {
                        enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury";
                    }
    FightLogic.StatusConclude(Dawid,monster);
                }


                            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
                                if (player.getFreeze() < 1) {
                                    player.Attack(GameLogic.monsterBase[joined], player);
                                } else if (player.getFreeze() > 0) {
                                    System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                                    player.setFreeze(player.getFreeze() - 1);
                                }
                                EnemyAttack(player, monster);
                                FightLogic.StatusConclude(player, monster);
                            }

            }





                    if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
                        FightLogic.StatusConclude(player, monster);
                        System.out.println("Udało Ci się uciec, Twoje koordynaty to: X: " + player.getX() + ", Y: " + player.getY());
fightstart = 0;
                escape = 1;
                player.setEscapeInvulnerability(1);
                doubleStrike = 0;
                fightscreenSP.setSize(0,0);

            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_0)) {
                if (player.getPotionNumber() > 0) {
                    player.setPotionNumber(player.getPotionNumber() - 1);
                    player.setHP(player.getHP() + 100);
                    double difference = player.getHP() - player.getMaxHP();
                    if (player.getHP() > player.getMaxHP()) {
                        player.setHP(player.getHP() - difference);
                    }
                    EnemyAttack(player, monster);
                    FightLogic.StatusConclude(player, monster);
                }
            }

            if (input.isKeyJustPressed(Input.Keys.O)) {
                if (player.getChosenSkill1() == Player.ICE || player.getChosenSkill2() == Player.ICE
                        || player.getChosenSkill3() == Player.ICE || player.getChosenSkill4() == Player.ICE || player.getChosenSkill5() ==
                        Player.ICE || player.getChosenSkill6() == Player.ICE || player.getChosenSkill7() == Player.ICE
                        || player.getChosenSkill8() == Player.ICE || player.getChosenSkill9() == Player.ICE || player.getChosenSkill10() ==
                        Player.ICE) {
                    if (doubleStrike == 1) {
                        FightLogic.WhoDoYouWantToAttack(monster);


                        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {

                                player.Freeze(monster);
                        }
                        if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
                            player.Freeze(GameLogic.monsterBase[joined]);


                        } else {
                            player.Freeze(monster);
                        }

                    }
                    player.Freeze(monster);
                    EnemyAttack(player, monster);
                    FightLogic.StatusConclude(player, monster);

            }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
                    if (player.getChosenSkill1() == Player.FIREBALL || player.getChosenSkill2() == Player.FIREBALL
                            || player.getChosenSkill3() == Player.FIREBALL || player.getChosenSkill4() == Player.FIREBALL || player.getChosenSkill5() ==
                            Player.FIREBALL || player.getChosenSkill6() == Player.FIREBALL || player.getChosenSkill7() == Player.FIREBALL
                            || player.getChosenSkill8() == Player.FIREBALL || player.getChosenSkill9() == Player.FIREBALL || player.getChosenSkill10() == Player.FIREBALL) {
                        if (doubleStrike == 1) {
                            FightLogic.WhoDoYouWantToAttack(monster);

                            if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {

                                player.Fireball(monster, player);
                            }
                            if (Gdx.input.isKeyJustPressed(Input.Keys.V)) {
                                    player.Fireball(GameLogic.monsterBase[joined], player);

                            }
                        } else {
                            player.Fireball(monster, player);
                        }
                        EnemyAttack(player, monster);
                        System.out.println("Zdrowie przeciwnika: " + monster.getHp());
                        FightLogic.StatusConclude(player, monster);
                    }

                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)) {
                    if (doubleStrike == 1) {
                        player.Cleave(player, monster, GameLogic.monsterBase[joined]);
                    } else {
                        player.Attack(monster, player);
                    }
                    EnemyAttack(player, monster);
                    FightLogic.StatusConclude(player, monster);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_6)) {
                    player.Heal(player);
                    EnemyAttack(player, monster);
                    FightLogic.StatusConclude(player, monster);
                }
            }

            FightLogic.ConcludeBattle(player, monster, joined);
            FightLogic.RestoreMana(player);

        }


/*

        } while (player.getHP() > 0 && escape == 0);
*/




    public static void EnemyAttack(Player player, Monster monster1) throws InterruptedException {
        /*if (doubleStrike == 1 && GameLogic.monsterBase[joined].getFreeze() == 0 && GameLogic.monsterBase[joined].getHp() > 0) {
            GameLogic.monsterBase[joined].Attack(GameLogic.monsterBase[joined], player);
        }
        else if (GameLogic.monsterBase[joined].getFreeze() > 0){
            System.out.println(GameLogic.monsterBase[joined].getName() + " jest zamrożony, nie może się ruszać przez " +
                    GameLogic.monsterBase[joined].getFreeze() + " tury.");
            GameLogic.monsterBase[joined].setFreeze(GameLogic.monsterBase[joined].getFreeze() - 1);
        }*/
        Thread.sleep(200);
        if (monster1.getHp() > 0 && monster1.getFreeze() == 0) {
            monster1.Attack(monster1, player);

        } else if (monster1.getFreeze() > 0) {
            System.out.println(monster1.getName() + " jest zamrożony, nie może się ruszać przez " + monster1.getFreeze()
                    + " tury");
        }
    }

    public static void PlayerStatusWearOff(Player player) {

        if (player.getAdrenalineValue() > 0) {
            player.setDMG( (player.getDMG() - 60));
            player.setArmor(player.getArmor() + 40);
            player.setAdrenalineValue(0);
        }

        if (player.getIronSkinValue() > 0) {

            player.setArmor(player.getArmor() - 30);
            player.setIronSkinValue(0);
        }

        player.setFreeze(0);
        player.setPoison(0);

    }



}
