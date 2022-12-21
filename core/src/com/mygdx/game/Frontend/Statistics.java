package com.mygdx.game.Frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.GameApp;

import static Logic.Experience.levelCap;
import static com.mygdx.game.Assets.addMANABMP;
import static com.mygdx.game.Assets.addMAXMANABMP;
import static com.mygdx.game.Frontend.Fonts.bottomBitMapFont;
import static com.mygdx.game.GameApp.*;

public class Statistics {
    public static Texture hpbar;
    public static Texture hpbarfull;
    public static Texture manabar;
    public static Texture manabarfull;
    public static Sprite hpbarSPR;
    public static Sprite hpbarfullSPR;
    public static Sprite manabarSPR;
    public static Sprite manabarfullSPR;

    public static Texture statsscreenTXT, expBarTXT, expBarGreenTXT, playerInfoTXT;

    public static Sprite statsscreenSPR, expBarSPR, expBarGreenSPR, playerInfoSPR;


    public static void create(){
        Assets.armorTEXT = new String();
        Assets.addMAXMANATEXT = new String();
        addMAXMANABMP = new BitmapFont();
        Assets.armorBMP = new BitmapFont();
        playerInfoTXT = new Texture("playerinfo.png");
        playerInfoSPR = new Sprite(playerInfoTXT);
        playerInfoSPR.setSize(350,170);
        hpbar = new Texture("hpbar.png");
        hpbarfull = new Texture("hpbarfull.png");
        manabar = new Texture("manabar.png");
        manabarfull = new Texture("manabarfull.png");
        hpbarSPR = new Sprite(hpbar);
        hpbarfullSPR = new Sprite(hpbarfull);
        manabarSPR = new Sprite(manabar);
        manabarfullSPR = new Sprite(manabarfull);
statsscreenTXT = new Texture("stats.png");
statsscreenSPR = new Sprite(statsscreenTXT);
statsscreenSPR.setSize(400,600);
        hpbarSPR.setSize(400,130);
        manabarSPR.setSize(400,130);
        hpbarfullSPR.setSize(245,35);
        manabarfullSPR.setSize(241,30);
        hpbarSPR.setPosition(GameApp.playerSprite.getX()- 700, GameApp.playerSprite.getY() + 500);
        hpbarfullSPR.setPosition(GameApp.playerSprite.getX()-540, GameApp.playerSprite.getY() + 450);
        manabarSPR.setPosition(GameApp.playerSprite.getX()-700, GameApp.playerSprite.getY()+350);
        manabarfullSPR.setPosition(GameApp.playerSprite.getX()-540,GameApp.playerSprite.getY()+300);
    }

public static void render (){

    hpbarSPR.setPosition(GameApp.playerSprite.getX()- 900, GameApp.playerSprite.getY() + 400);
    hpbarfullSPR.setPosition(GameApp.playerSprite.getX()-782, GameApp.playerSprite.getY() + 447);
    manabarSPR.setPosition(GameApp.playerSprite.getX()-900, GameApp.playerSprite.getY()+250);
    manabarfullSPR.setPosition(GameApp.playerSprite.getX()-779,GameApp.playerSprite.getY()+298);
    hpbarSPR.draw(batch);
    hpbarfullSPR.draw(batch);
    hpbarfullSPR.setSize((float) (245*(Dawid.getHP()/Dawid.getMaxHP())), 35);
    manabarfullSPR.setSize((float) (241*(Dawid.getMana()/Dawid.getMaxMana())), 30);
    manabarSPR.draw(batch);
    manabarfullSPR.draw(batch);

    if (statsscreen == 1) {
        statsscreenSPR.setPosition(playerSprite.getX()-900,playerSprite.getY()-360);
        statsscreenSPR.draw(batch);
        Assets.addAttributeSPR.setSize(450, 600);
        Assets.addATTACKBMP.draw(batch, Assets.addATTACKTEXT, statsscreenSPR.getX()+185, statsscreenSPR.getY()+395);
        Assets.addHPBMP.draw(batch, Assets.addHPTEXT, statsscreenSPR.getX()+185, statsscreenSPR.getY()+465);
        Assets.addCRITBMP.draw(batch, Assets.addCRITTEXT, statsscreenSPR.getX()+185, statsscreenSPR.getY()+50);
        Assets.addMAGICBMP.draw(batch, Assets.addMAGICTEXT, statsscreenSPR.getX()+185, statsscreenSPR.getY()+110);
        Assets.armorBMP.draw(batch, Assets.armorTEXT, statsscreenSPR.getX()+185, statsscreenSPR.getY() +325);
        Assets.addMANABMP.draw(batch, Assets.addMANATEXT, statsscreenSPR.getX()+185, statsscreenSPR.getY()+180);
        addMAXMANABMP.draw(batch, Assets.addMAXMANATEXT, statsscreenSPR.getX()+185, statsscreenSPR.getY() + 250);
        Assets.addMAXMANATEXT = Dawid.getMaxMana() + " ";
        Assets.armorTEXT = Dawid.getArmor() + " ";
        Assets.addATTACKTEXT = Dawid.getDMG() + " + 3";
        Assets.addHPTEXT = Dawid.getHP() + " + 6";
        Assets.addCRITTEXT = Dawid.getCritChance() + " + 0,5%";
        Assets.addMAGICTEXT = Dawid.getMagic() + " + 5";
        Assets.addMANATEXT = Dawid.getManaRegen() + "+ 0,5";
        addMANABMP.getData().setScale((float) 0.7F);
    } else if (statsscreen == 0 && Dawid.getAttributePoints() == 0) {
        Assets.addATTACKTEXT = " ";
        Assets.addHPTEXT = " ";
        Assets.addCRITTEXT = " ";
        Assets.addMAGICTEXT = " ";
        Assets.addMANATEXT = " ";

        Assets.addAttributeSPR.setSize(0, 0);

    }

    Assets.addHP.setPosition(statsscreenSPR.getX()+320, statsscreenSPR.getY()+430);
    Assets.addDMG.setPosition(statsscreenSPR.getX()+320, statsscreenSPR.getY()+360);
    Assets.addMANA.setPosition(statsscreenSPR.getX()+320, statsscreenSPR.getY()+145);
    Assets.addCRIT.setPosition(statsscreenSPR.getX()+320, statsscreenSPR.getY()+15);
    Assets.addMAGIC.setPosition(statsscreenSPR.getX()+320, statsscreenSPR.getY()+75);
    Assets.addMAGIC.draw(batch);
    Assets.addDMG.draw(batch);
    Assets.addHP.draw(batch);
    Assets.addMANA.draw(batch);
    Assets.addCRIT.draw(batch);



}

    public static void addStats() {
        if (GameApp.fightstart == 0) {
            GameApp.cleaveSPR2.setSize(0, 0);
            GameApp.getAdrenalineSPR2.setSize(0, 0);
            GameApp.ironskinSPR2.setSize(0, 0);
            GameApp.healSPR2.setSize(0, 0);
            GameApp.getIceBoltSPR2.setSize(0, 0);
            GameApp.fireBallSPR2.setSize(0, 0);
        }

        if (Dawid.getAttributePoints() > 0) {
            statsscreen = 1;

            Assets.addMAGIC.setSize(50, 50);

            Assets.addHP.setSize(50, 50);

            Assets.addDMG.setSize(50, 50);

            Assets.addCRIT.setSize(50, 50);

            Assets.addMANA.setSize(50, 50);

        } else {

            Assets.addMANA.setSize(0, 0);
            Assets.addDMG.setSize(0, 0);
            Assets.addCRIT.setSize(0, 0);
            Assets.addHP.setSize(0, 0);
            Assets.addMAGIC.setSize(0, 0);

        }
        if (Gdx.input.justTouched()) {
            //unprojects the camera
            GameApp.camera.unproject(GameApp.touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.addDMG.getBoundingRectangle().contains(GameApp.touchPoint.x, GameApp.touchPoint.y)) {
                Dawid.setDMG(Dawid.getDMG() + 3);
                Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);

                Soundtrack.ui.play();
            }
        }
        if (Gdx.input.justTouched()) {
            //unprojects the camera
            GameApp.camera.unproject(GameApp.touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.addHP.getBoundingRectangle().contains(GameApp.touchPoint.x, GameApp.touchPoint.y)) {
                Dawid.setMaxHP(Dawid.getMaxHP() + 6);
                Dawid.setHP(Dawid.getHP() + 6);
                Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
                Soundtrack.ui.play();
            }
        }
        if (Gdx.input.justTouched()) {
            //unprojects the camera
            GameApp.camera.unproject(GameApp.touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.addCRIT.getBoundingRectangle().contains(GameApp.touchPoint.x, GameApp.touchPoint.y)) {
                Dawid.setCritChance(Dawid.getCritChance() + 0.5);
                Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
                Soundtrack.ui.play();
            }
        }
        if (Gdx.input.justTouched()) {
            //unprojects the camera
            GameApp.camera.unproject(GameApp.touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.addMAGIC.getBoundingRectangle().contains(GameApp.touchPoint.x, GameApp.touchPoint.y)) {
                Dawid.setMagic(Dawid.getMagic() + 5);
                Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
                Soundtrack.ui.play();
            }
        }
        if (Gdx.input.justTouched()) {
            //unprojects the camera
            GameApp.camera.unproject(GameApp.touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (Assets.addMANA.getBoundingRectangle().contains(GameApp.touchPoint.x, GameApp.touchPoint.y)) {
                Dawid.setManaRegen(Dawid.getManaRegen() + 0.5);
                Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
                Soundtrack.ui.play();
            }
        }
    }
}
