package com.mygdx.game.Frontend;

import Data.Quests.Quests;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.GameApp;
import com.mygdx.game.SpriteTouchable;

import java.awt.*;

import static Logic.Experience.levelCap;
import static com.badlogic.gdx.graphics.Color.*;
import static com.mygdx.game.GameApp.*;

public class Fonts {
    public static FreeTypeFontGenerator fontGenerator;
    public static FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;
    public static String leftText;
    public static BitmapFont leftBitMapFont;
    public static Texture levelUpScreen;
    public static SpriteTouchable levelUpSprite;
    public static String enemyAttackText;
    public static String bottomText;
    public static String topText;
    public static BitmapFont topTextBitmap;
    public static String mobSpellText;
    public static BitmapFont mobSpellBitmap, missOrCritBMP;
    public static TextField attackText;
    public static BitmapFont enemyAttackFont;
    public static String curseTEXT, missOrCritText;
    public static BitmapFont curseBMP;
    public static String playerAttackText;
    public static BitmapFont font;
    public static BitmapFont playerAttackFont;
    public static BitmapFont bottomBitMapFont;
    public static String playerInfo;
    public static BitmapFont playerInfoBitMap;
    public static String itemDescription;
    public static BitmapFont itemDescriptionBMP;
public static FreeTypeFontGenerator Impact;
public static FreeTypeFontGenerator.FreeTypeFontParameter impactFont;

public static String questInfo;
public static BitmapFont questInfoBMP, spidersInfoBMP, cysiuInfoBMP, florekInfoBMP, rysiuInfoBMP, sideQuestBMP;
    public static void  createFonts(){
        Fonts.fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("AncientModernTales-a7Po.ttf"));
        FreeTypeFontGenerator curseFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("AncientModernTales-a7Po.ttf"));
        Fonts.Impact = new FreeTypeFontGenerator(Gdx.files.internal("impact.ttf"));
        Fonts.fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        FreeTypeFontGenerator.FreeTypeFontParameter curseFont = new FreeTypeFontGenerator.FreeTypeFontParameter();
 impactFont = new FreeTypeFontGenerator.FreeTypeFontParameter();
        FreeTypeFontGenerator.FreeTypeFontParameter normalFont = new FreeTypeFontGenerator.FreeTypeFontParameter();
        curseFont.color.set(Color.WHITE);
        impactFont.size = 30;
        impactFont.borderWidth = 4;
        impactFont.borderColor = BLACK;

        curseFont.borderWidth = 5;
        curseFont.size = 80;
        normalFont.color.set(Color.WHITE);
        normalFont.size = 45;
sideQuestBMP = new BitmapFont();
        normalFont.borderWidth = 5;
        leftBitMapFont = Fonts.fontGenerator.generateFont(normalFont);
        bottomBitMapFont = Fonts.Impact.generateFont(impactFont);
        Quests.questStoryBitMap = Fonts.fontGenerator.generateFont(normalFont);
        Quests.diaChoice1BitMap = Fonts.fontGenerator.generateFont(normalFont);
        Quests.diaChoice2BitmMap = Fonts.fontGenerator.generateFont(normalFont);
        Assets.buyBMP = Fonts.fontGenerator.generateFont(normalFont);
        Assets.sellBMP = Fonts.fontGenerator.generateFont(normalFont);
        Assets.shopNameBMP = Fonts.fontGenerator.generateFont(normalFont);
        GameApp.fpsBMP = Fonts.fontGenerator.generateFont(normalFont);
        bottomBitMapFont.setColor(YELLOW);
        Fonts.fontParameter.size = 60;
        Fonts.fontParameter.borderWidth = 4;
        Fonts.fontParameter.borderColor = BLACK;
        curseFont.borderColor = BLACK;
        normalFont.borderColor = BLACK;
        Fonts.fontParameter.color = Color.WHITE;
        Assets.addATTACKBMP = Fonts.fontGenerator.generateFont(normalFont);
        Assets.addCRITBMP = Fonts.fontGenerator.generateFont(normalFont);
        Assets.addHPBMP = Fonts.fontGenerator.generateFont(normalFont);
        Assets.addMANABMP = Fonts.fontGenerator.generateFont(normalFont);
        Assets.addMAGICBMP = Fonts.fontGenerator.generateFont(normalFont);
        Assets.addMAXMANABMP = Fonts.fontGenerator.generateFont(normalFont);
        Assets.armorBMP = Fonts.fontGenerator.generateFont(normalFont);
        Assets.armorBMP.getData().setScale(0.7F);
        Assets.addMAXMANABMP.getData().setScale(0.7F);
        Assets.addHPBMP.setColor(GREEN);
        Assets.addMAGICBMP.setColor(PURPLE);
        Assets.addMANABMP.setColor(CYAN);
        Assets.addMAXMANABMP.setColor(CYAN);
        Assets.armorBMP.setColor(YELLOW);
        Assets.addATTACKBMP.setColor(RED);
        Assets.addCRITBMP.setColor(ORANGE);
        Assets.addATTACKBMP.getData().setScale(0.7F);
        Assets.addCRITBMP.getData().setScale(0.7F);
        Assets.addHPBMP.getData().setScale(0.7F);
        Assets.addMANABMP.getData().setScale(0.7F);
        Assets.addMAGICBMP.getData().setScale(0.7F);
        Quests.questInfoBitMap = Fonts.fontGenerator.generateFont(Fonts.fontParameter);
        topTextBitmap = Fonts.Impact.generateFont(impactFont);
        questInfoBMP = Fonts.Impact.generateFont(impactFont);
        questInfoBMP.setColor(YELLOW);
        questInfoBMP.getData().setScale(0.8F);

        spidersInfoBMP = Fonts.Impact.generateFont(impactFont);
        spidersInfoBMP.setColor(YELLOW);
        spidersInfoBMP.getData().setScale(0.8F);

        sideQuestBMP = Fonts.Impact.generateFont(impactFont);
        sideQuestBMP.setColor(YELLOW);
        sideQuestBMP.getData().setScale(0.8F);

        cysiuInfoBMP = Fonts.Impact.generateFont(impactFont);
        cysiuInfoBMP.setColor(YELLOW);
        cysiuInfoBMP.getData().setScale(0.8F);

       florekInfoBMP = Fonts.Impact.generateFont(impactFont);
        florekInfoBMP.setColor(YELLOW);
        florekInfoBMP.getData().setScale(0.8F);

        missOrCritBMP = Fonts.Impact.generateFont(impactFont);
        missOrCritBMP.setColor(RED);
        missOrCritText = new String();

        addBMP(rysiuInfoBMP);

        topTextBitmap.setColor(YELLOW);
        topTextBitmap.getData().setScale(1.3F);
        playerAttackFont = Fonts.Impact.generateFont(impactFont);
        enemyAttackFont = Fonts.Impact.generateFont(impactFont);
        mobSpellBitmap = Fonts.Impact.generateFont(impactFont);
        GameApp.playerAttackBMP2 = Fonts.Impact.generateFont(impactFont);
        playerAttackFont.getData().setScale(1.1F);
        enemyAttackFont.setColor(FIREBRICK);
        playerAttackFont.setColor(FOREST);
        enemyAttackFont.getData().setScale(1.1F);
        mobSpellBitmap.getData().setScale(1.1F);
        GameApp.playerAttackBMP2.getData().setScale(1.3F);
        curseBMP = curseFontGenerator.generateFont(curseFont);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.borderWidth = 3;
        parameter.borderColor = BLACK;
        parameter.borderStraight = true;
        /*parameter.color.set(Color.GOLD);
        parameter.borderColor.set(Color.BLACK);
        parameter.borderWidth = 2;*/
        playerInfoBitMap = new BitmapFont();
        mobSpellBitmap = new BitmapFont();
        mobSpellBitmap.getData().setScale(1);
        playerAttackText = " ";
        Fonts.enemyAttackText = " ";

        Fonts.leftText = "Controls: \n \n " +
                "Steering:  W, S, D, A \n \n Inventory: B \n \n Interact: Space \n \n Stats: P \n \n Quest log: L ";
        Fonts.topText = " ";
        Fonts.mobSpellText = " ";
        Fonts.bottomText = "Exit game: 0, Steering: WSAD     Inventory : B,       Attribute points : P                Map : TAB ";
        playerInfo = "Health: " + Dawid.getHP() + "/" + Dawid.getMaxHP() + "         Mana: " + Dawid.getMana() +
                "\n Experience: " + Dawid.getXP() + "/" + levelCap + "         Level: " + Dawid.getLevel() +
                "\n Physical damage: " + Dawid.getDMG();

	/*	leftBitMapFont.getData().setScale(1);
		bottomBitMapFont.getData().setScale(1);
		enemyAttackFont.getData().setScale(2);
		playerAttackFont.getData().setScale(2);
		topTextBitmap.getData().setScale((float) 1.6);*/
        Fonts.topText = "1. Attack";
        Equipment.itemDescriptionBMP = Fonts.fontGenerator.generateFont(parameter);
    }

    public static void addBMP(BitmapFont bitmapFont){
        bitmapFont = Fonts.Impact.generateFont(impactFont);
        bitmapFont.setColor(YELLOW);
        bitmapFont.getData().setScale(0.8F);

    }

    public static void renderFonts(){
        playerAttackFont.draw(batch, playerAttackText, playerSprite.getX() - 700, playerSprite.getY());
        Fonts.enemyAttackFont.draw(batch, Fonts.enemyAttackText, playerSprite.getX()-100, playerSprite.getY() + 250);
        Fonts.topTextBitmap.draw(batch, Fonts.topText, playerSprite.getX() - 300, playerSprite.getY() + 420);
        Quests.questInfoBitMap.draw(batch, Quests.questInfo, playerSprite.getX() - 300, playerSprite.getY() + 320);
        Fonts.mobSpellBitmap.draw(batch, Fonts.mobSpellText, playerSprite.getX(), playerSprite.getY() + 150);

        Fonts.leftBitMapFont.draw(batch, Fonts.leftText, playerSprite.getX() - 900, playerSprite.getY() + 100);
        Fonts.levelUpSprite.draw(batch);
    }
}
