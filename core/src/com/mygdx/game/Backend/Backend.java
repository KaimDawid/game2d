package com.mygdx.game.Backend;

import Logic.Camera;
import Logic.Spawners.Areas.BanditCamp;
import Logic.Spawners.Areas.Beach;
import Logic.Spawners.Areas.Cemetery;
import Logic.Spawners.Areas.Forest;
import Data.Quests.Quests;
import Logic.Drop.Wood;
import Logic.FightLogic.Fight;
import Logic.FightLogic.FightLogic;
import Logic.GameLogic;
import Logic.Spawners.*;
import Mobs.Beach.Crayfish;
import Mobs.Monster;
import Mobs.Player;
import Objects.Ladder;
import Objects.LadderDOWN;
import Objects.LadderUP;
import Objects.Shop.Shop;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;
import com.mygdx.game.SpriteTouchable;

import java.util.Random;

import static Logic.FightLogic.Fight.*;
import static com.mygdx.game.Assets.*;
import static com.mygdx.game.GameApp.*;

public class Backend {
    public static int borderY = 32;
    public static Texture hbTXT;
    public static Sprite hbSPR;
    public static int checkSuccesful = 0;
    static int ladderCheckUPSuccessful = 0;
    static int ladderCheckDOWNSuccessful = 0;
    static Ladder[] ladders = new Ladder[10];
    public static int[] ladX = new int[10];
    public static int[] ladY = new int[10];
    public static LadderDOWN[] ladderDOWNS = new LadderDOWN[10];
    public static LadderUP[] ladderUPS = new LadderUP[10];
    static Monster[] banditCampBase = new Monster[50];

    public static Texture banditcampTXT;
    public static  Texture forestTXT;
    public static Texture fieldsTXT;
    public  static  Texture cemeteryTXT, bridgeTXT;
    public static Texture dungeonTXT;

    public static void createBackEnd() {

        Quests.questInfo = " ";
        csBMP.setSize(0, 0);
        Assets.addATTACKTEXT = " ";
        Assets.addHPTEXT = " ";
        Assets.addCRITTEXT = " ";
        Assets.addMAGICTEXT = " ";
        Assets.addMANATEXT = " ";
        Assets.PLUS = new Texture("plus.png");
        Assets.addDMG = new SpriteTouchable(Assets.PLUS);
        Assets.addCRIT = new SpriteTouchable(Assets.PLUS);
        Assets.addHP = new SpriteTouchable(Assets.PLUS);
        Assets.addMAGIC = new SpriteTouchable(Assets.PLUS);
        Assets.addMANA = new SpriteTouchable(Assets.PLUS);
        bridgeTXT = new Texture("bridge.png");
        Assets.cleaveTXT = new Texture("cleavebutton.png");
        Assets.cleaveSPR = new SpriteTouchable(Assets.cleaveTXT);
        dualWieldTXT = new Texture("duealwieldbutton.png");
        dualWieldSPR = new SpriteTouchable(dualWieldTXT);
        healTXT = new Texture("healbutton.png");
        Assets.healSPR = new SpriteTouchable(healTXT);
        Assets.attackTxt = new Texture("attackbutton.png");
        Assets.attackSpr = new SpriteTouchable(Assets.attackTxt);
        Assets.runTxt = new Texture("runbutton.png");
        Assets.runSpr = new Sprite(Assets.runTxt);
        Assets.iceTxt = new Texture("iceboltbutton.png");
        Assets.iceSpr = new Sprite(Assets.iceTxt);
        dungeonTXT = new Texture("dungeon.png");
        Assets.addMANA.setSize(0, 0);
        Assets.addDMG.setSize(0, 0);
        Assets.addCRIT.setSize(0, 0);
        Assets.addHP.setSize(0, 0);
        Assets.addMAGIC.setSize(0, 0);
        Assets.levelupSPR.setSize(0, 0);
        Assets.invbarSPR.setSize(0, 0);
        GameApp.iceBoltTXT = new Texture("iceboltbutt.png");
        GameApp.iceBoltSPR = new SpriteTouchable(GameApp.iceBoltTXT);
        GameApp.fireBallTXT = new Texture("fireballbutt.png");
        GameApp.fireBallSPR = new SpriteTouchable(GameApp.fireBallTXT);
        GameApp.adrenalineTXT = new Texture("adrenalinebutt.png");
        GameApp.adrenalineSPR = new SpriteTouchable(GameApp.adrenalineTXT);
        GameApp.ironskinTXT = new Texture("ironskinbutton.png");
        GameApp.ironskinSPR = new SpriteTouchable(GameApp.ironskinTXT);
fireBallSPR.setSize(0,0);

        Assets.iceSpr.setSize(0, 0);
        GameApp.adrenalineSPR.setSize(0, 0);
        Assets.runSpr.setSize(0, 0);
        Assets.attackSpr.setSize(0, 0);
        critBMP.setSize(0, 0);
        poisonBMP.setSize(0, 0);
        stunBMP.setSize(0, 0);


        int weaponEQ = 0;
        int neckEQ = 0;
        int handsEQ = 0;
        int chestEQ = 0;
        Dawid.setEscapeInvulnerability(0);
        int reminder = 0;
		/*eqNumber[30] = new Weapon("Zardzewiały miecz", 0, 60, 5, 0, 1,1,1);
		Inventory.equippedweapon = (Weapon) eqNumber[30];
		eqNumber[30].eqON(Dawid);*/

        /*Monster.weaponEQ++;*/
        /*eqNumber[30].setIsON(1);*/
        int discoverForest = 0;
        int discoverCamp = 0;
        int discoverLadder = 0;



        /*	eqNumber[31] = new Weapon("Laska nowicjusza", 0, 10, 10, 60, 2, 0, 1);*/
        Shop shop = new Shop(3, 4);
        shop.setFloor(1);
	/*	try {
			createLadder(1);
		}
		catch (NullPointerException a){

		}
		createLadder(2);
		createLadder(3);
		createLadder(4);
		createLadder(5);
		createLadder(6);*/
        CastleSpawner.spawn(24, Spawner.castleBase);
        Spawner.spawn(22, Spawner.monsterBase);
        SpawnFloor2.SPAWN(27, Spawner.monsterBase2);
        SpawnFloor3.SPAWN(27, Spawner.monsterBase3);
        SpawnFloor4.SPAWN(27, Spawner.monsterBase3);
        SpawnFloor5.SPAWN(27, Spawner.monsterBase3);
        SpawnFloor6.SPAWN(27, Spawner.monsterBase3);
        Forest.SPAWN(27, Spawner.forestBase);
        BanditCamp.SPAWN(27, Spawner.monsterBase3);
        Cemetery.SPAWN(27, Cemetery.cemeteryBase);
        Beach.spawn(16, Spawner.beachBase);
    }

    public static void checker(Player player, Monster monster) throws InterruptedException {
if (Dawid.getX() < 9 && Dawid.getY() < 9){
    fightscreenSP.setTexture(fieldsTXT);
}
else if (Dawid.getX() > 8 && Dawid.getY() < 9){
    fightscreenSP.setTexture(banditcampTXT);
}
else if (Dawid.getX() < 9 && Dawid.getY() > 8){
    fightscreenSP.setTexture(forestTXT);
}
else if (Dawid.getX() > 110 & Dawid.getX()<140){
    fightscreenSP.setTexture(GameApp.castleTXT);
}
else if (Dawid.getX() > 8 && Dawid.getY() > 8){
    fightscreenSP.setTexture(cemeteryTXT);
}
else if (Dawid.getX() == 17 && Dawid.getY() == 4){
    fightscreenSP.setTexture(bridgeTXT);
}
else if (Dawid.getX()>= 200 && Dawid.getY() >= 200 && Dawid.getX() < 210 && Dawid.getY() < 210){
    fightscreenSP.setTexture(dungeonTXT);
}

        try {

            if (player.getX() == monster.getX() && player.getY() == monster.getY() && player.getFloor() == monster.getFloor() && monster.getHp() > 0) {

                if (GameApp.fightscreenSP.getHeight() < 1079) {

                    if (Camera.X == 0) {
                        Camera.X = 200;
                    }
                    GameApp.enemybar.setSize(0, 0);
                    GameApp.enemybargreen.setSize(0, 0);
                    GameApp.sprite.setSize(0, 0);
                    GameApp.transitionIn = true;
                }

                GameApp.fightON = 1;
                GameApp.fightstart = 1;

                Fonts.topText = "Fight!";
                Fonts.leftText = " ";


                checkSuccesful = 1;
                if (GameApp.fightON == 1) {

                    Fight.Turn(Dawid, monster);
                    currentTarget = monster;
                }

            } else {
                GameApp.fightON = 0;
            }
        } catch (NullPointerException a) {

        }

    }
public static boolean crayBug = false;
    static Random random = new Random();
    public static void beachFight() throws InterruptedException {
        if (Dawid.getX()<1){
            int fightchance = random.nextInt(10);
        if (fightchance < 7) {
            if (GameApp.fightscreenSP.getHeight() < 1079) {
                GameApp.enemybar.setSize(0, 0);
                GameApp.enemybargreen.setSize(0, 0);
                GameApp.sprite.setSize(0, 0);
                GameApp.transitionIn = true;
            }



            GameApp.fightON = 1;
            GameApp.fightstart = 1;

            Fonts.topText = "Walcz!";
            Fonts.leftText = " ";

			/*	Assets.attackSpr.setSize(190,95);
				Assets.runSpr.setSize(190,95);*/
			/*	fightscreenSP.setPosition(playerSprite.getX() - 960, playerSprite.getY() - 540);
				fightscreenSP.setSize(1920,1080);*/


            checkSuccesful = 1;
            if (GameApp.fightON == 1) {
                Fight.Turn(Dawid, new Crayfish(200, 40, 0, 0, "Crayfish", 30, 50, 1, 1));
crayBug = true;
            }
        }
        }
    }
    public static void MoveConclude() throws InterruptedException {

	/*	LadderCheckDOWN(ladderDOWNS[1], Dawid);
		LadderCheckUP(ladderUPS[1], Dawid);
		LadderCheckDOWN(ladderDOWNS[2], Dawid);
		LadderCheckUP(ladderUPS[2], Dawid);
		LadderCheckDOWN(ladderDOWNS[3], Dawid);
		LadderCheckUP(ladderUPS[3], Dawid);
		LadderCheckDOWN(ladderDOWNS[4], Dawid);
		LadderCheckUP(ladderUPS[4], Dawid);
		LadderCheckDOWN(ladderDOWNS[5], Dawid);
		LadderCheckUP(ladderUPS[5], Dawid);*/
        /*erer(Dawid, mutant);*/



            for (int icheck = 1; icheck < 40; icheck++) {

                    checker(Dawid, Spawner.monsterBase[icheck]);
                    checker(Dawid,Spawner.beachBase[icheck]);

                    Wood.check();

                    checker(Dawid, Spawner.monsterBase2[icheck]);
                    checker(Dawid, Spawner.monsterBase3[icheck]);
                    checker(Dawid, Spawner.monsterBase4[icheck]);
                    checker(Dawid, Spawner.monsterBase5[icheck]);
                    checker(Dawid, Spawner.monsterBase6[icheck]);
                    if (Dawid.getY() > 8) {
                        checker(Dawid, Spawner.forestBase[icheck]);
                    }
                    if (Dawid.getX() > 8) {
                        checker(Dawid, banditCampBase[icheck]);
                        checker(Dawid, Cemetery.cemeteryBase[icheck]);
                    }
                    checker(Dawid, Spawner.castleBase[icheck]);
                    checker(Dawid, GameApp.gabbie);


                    checker(Dawid, werevolf);
                if (checkSuccesful > 0) {
                    checkSuccesful = 0;
                    break;
                }
                }


            }





    public static void Battle(Player player, Monster monster) throws InterruptedException {



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
        FightLogic.StatusConclude(player, monster);
        if (GameApp.currentTarget != null) {
            System.out.println("Twoje punkty zdrowia: " + player.getHP() + "/" + player.getMaxHP() + " Twoje obrażenia :"
                    + player.getDMG() + "            Mana: " + player.getMana());
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
            groupFight(GameLogic.monsterBase, player);


            if (Gdx.input.isKeyJustPressed(Input.Keys.A) && GameApp.fightstart == 1) {

                if (player.getAdrenalineValue() == 0 && player.getChosenSkill1() == Player.ADRENALINE || player.getChosenSkill2() == Player.ADRENALINE
                        || player.getChosenSkill3() == Player.ADRENALINE || player.getChosenSkill4() == Player.ADRENALINE || player.getChosenSkill5() ==
                        Player.ADRENALINE || player.getChosenSkill6() == Player.ADRENALINE || player.getChosenSkill7() == Player.ADRENALINE
                        || player.getChosenSkill8() == Player.ADRENALINE || player.getChosenSkill9() == Player.ADRENALINE || player.getChosenSkill10() == Player.ADRENALINE) {
                    player.Adrenaline(player);
                    player.setAdrenalineValue(1);
                    adrenalineDuration = 3;
                } else {
                    player.Attack(monster, player);
                }
                EnemyAttack(player, monster);


            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.I) && GameApp.fightstart == 1) {

                if (player.getIronSkinValue() == 0) {
                    player.IronSkin(player);
                    player.setIronSkinValue(1);
                    ironSkinDuration = 3;
                } else {
                    player.Attack(monster, player);
                }
                EnemyAttack(player, monster);

            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.X) && GameApp.fightstart == 1) {
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


                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1) && GameApp.fightstart == 1) {

                    if (player.getFreeze() < 1) {
                        player.Attack(monster, player);
                    } else if (player.getFreeze() > 0) {
                        System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                        player.setFreeze(player.getFreeze() - 1);
                    }
                    EnemyAttack(player, monster);
                }


                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2) && GameApp.fightstart == 1) {
                    if (player.getFreeze() < 1) {
                        player.Attack(GameLogic.monsterBase[joined], player);
                    } else if (player.getFreeze() > 0) {
                        System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                        player.setFreeze(player.getFreeze() - 1);
                    }
                    EnemyAttack(player, monster);
                }

            }


            if (Gdx.input.isKeyJustPressed(Input.Keys.B) && GameApp.fightstart == 1) {
                System.out.println("Udało Ci się uciec, Twoje koordynaty to: X: " + player.getX() + ", Y: " + player.getY());

                escape = 1;
                player.setEscapeInvulnerability(1);
                doubleStrike = 0;

            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_0) && GameApp.fightstart == 1) {
                if (player.getPotionNumber() > 0) {
                    player.setPotionNumber(player.getPotionNumber() - 1);
                    player.setHP(player.getHP() + 100);
                    double difference = player.getHP() - player.getMaxHP();
                    if (player.getHP() > player.getMaxHP()) {
                        player.setHP(player.getHP() - difference);
                    }
                    EnemyAttack(player, monster);

                }
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3) && GameApp.fightstart == 1) {
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
                    EnemyAttack(player, monster);


                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4) && GameApp.fightstart == 1) {
                    if (player.getChosenSkill1() == Player.FIREBALL || player.getChosenSkill2() == Player.FIREBALL
                            || player.getChosenSkill3() == Player.FIREBALL || player.getChosenSkill4() == Player.FIREBALL || player.getChosenSkill5() ==
                            Player.FIREBALL || player.getChosenSkill6() == Player.FIREBALL || player.getChosenSkill7() == Player.FIREBALL
                            || player.getChosenSkill8() == Player.FIREBALL || player.getChosenSkill9() == Player.FIREBALL || player.getChosenSkill10() == Player.FIREBALL) {
                        if (doubleStrike == 1) {
                            FightLogic.WhoDoYouWantToAttack(monster);

                            if (Gdx.input.isKeyJustPressed(Input.Keys.A) && GameApp.fightstart == 1) {

                                player.Fireball(monster, player);
                            }
                            if (Gdx.input.isKeyJustPressed(Input.Keys.V) && GameApp.fightstart == 1) {
                                player.Fireball(GameLogic.monsterBase[joined], player);

                            }
                        } else {
                            player.Fireball(monster, player);
                        }
                        EnemyAttack(player, monster);
                        System.out.println("Zdrowie przeciwnika: " + monster.getHp());

                    }

                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)) {
                    if (doubleStrike == 1) {
                        player.Cleave(player, monster, GameLogic.monsterBase[joined]);
                    } else {
                        player.Attack(monster, player);
                    }
                    EnemyAttack(player, monster);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_6)) {
                    player.Heal(player);
                    EnemyAttack(player, monster);
                }
            }

            FightLogic.ConcludeBattle(player, monster, joined);
            FightLogic.RestoreMana(player);


        }
    }

    public static void createLadder(int floor) {
        Random random = new Random();
        ladderDOWNS[floor] = new LadderDOWN(1, 1, floor);
        ladderUPS[floor] = new LadderUP(1, 1, (floor + 1));
        for (int f = 0; f < 1; f++) {


            // to może nie działać


            ladX[floor] = (random.nextInt(8) + 1);
            ladY[floor] = (random.nextInt(8) + 1);


            if ((ladX[floor] > (ladderUPS[floor - 1].getX() + 4) || ladX[floor] < (ladderUPS[floor - 1].getX() - 4)) ||
                    (ladY[floor] > (ladderUPS[floor - 1].getY() + 4) || ladY[floor] < (ladderUPS[floor - 1].getY() - 4))) {


                ladderDOWNS[floor].setX(ladX[floor]);
                ladderDOWNS[floor].setY(ladY[floor]);

                ladderUPS[floor].setX(ladX[floor]);
                ladderUPS[floor].setY(ladY[floor]);
                /*System.out.println("Koordy drabiny " + floor + " to: ");
                System.out.println("X: " + ladX[floor]);
                System.out.println("Y: " + ladY[floor]);
                System.out.println("floor: " + ladderUPS[floor].getFloor());*/
            } else {
                f = f - 1;
            }
        }
    }
}
