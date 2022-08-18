package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.awt.*;
import java.util.ArrayList;

public class Assets {

    public static Texture attackTxt;
    public static SpriteTouchable attackSpr;
    public static Texture runTxt;
    public static Sprite runSpr;
    public static Texture iceTxt;
    public static Sprite iceSpr;

    public static Texture cleaveTXT;
    public static Sprite cleaveSPR;
    public static Texture dualWieldTXT;
    public static Sprite dualWieldSPR;
    public static Texture healTXT;
    public static Sprite healSPR;
    public static Texture PLUS;
    public static Sprite addDMG;
    public static Sprite addHP;
    public static Sprite addCRIT;
    public static Sprite addMAGIC;
    public static Sprite addMANA;
public static Sprite addAttributeSPR;

public static BitmapFont addATTACKBMP;
    public static BitmapFont addMANABMP;


    public static BitmapFont addCRITBMP;


    public static BitmapFont addHPBMP;

    public static BitmapFont addMAGICBMP;
    public static String addATTACKTEXT;
    public static String addMANATEXT;


    public static String addCRITTEXT;


    public static String addHPTEXT;

    public static String addMAGICTEXT;

public static Texture leatherhelmetTXT;
public static Sprite leatherhelmetSPR;

public static Texture leatherglovesTXT;
public static Sprite leatherglovesSPR;
    public static Texture plateArmorTXT;
    public static Sprite plateArmorSPR;

    public static Texture katanaTXT;
    public static Sprite katanaSPR;
    public static Texture coppernecklaceTXT;
    public static Sprite coppernecklaceSPR;

    public static Texture daggerTXT;
    public static Sprite daggerSPR;

    public static Texture diamondglovesTXT;
    public static Sprite diamondglovesSPR;

    public static Texture diamondhelmetTXT;
    public static Sprite diamondhelmetSPR;

    public static Texture diamondnecklaceTXT;
    public static Sprite diamondnecklaceSPR;

    public static Texture dragonarmorTXT;
    public static Sprite dragonarmorSPR;

    public static Texture dragonglovesTXT;
    public static Sprite dragonglovesSPR;

    public static Texture dragonhelmetTXT;
    public static Sprite dragonhemletSPR;

    public static Texture leatherarmorTXT;
    public static Sprite leatherarmorSPR;

    public static Texture mailglovesTXT;
    public static Sprite mailglovesSPR;

    public static Texture mailshirtTXT;
    public static Sprite mailshirtSPR;

    public static Texture noviceglovesTXT;
    public static Sprite noviceglovesSPR;

    public static Texture novicehatTXT;
    public static Sprite novicehatSPR;

    public static Texture platearmorTXT;
    public static Sprite platearmorSPR;
    public static Texture plateglovesTXT;
    public static Sprite plateglovesSPR;

    public static Texture silvernecklaceTXT;
    public static Sprite silvernecklaceSPR;
    public static Texture swordTXT;
    public static Sprite swordSPR;

    public static Texture twohandedswordTXT;
    public static Sprite twohandedswordSPR;

    public static Texture swordandshieldTXT;
    public static Sprite swordswordandshieldSPR;

    public static Texture platehelmetTXT;
    public static Sprite platehelmetSPR;

    public static Texture novicerobeTXT;
    public static Sprite novicerobeSPR;
    public static Texture novicestaffTXT;
    public static Sprite novicestaffSPR;

    public static Texture banditTXT;
    public static Sprite banditSPR;

    public static Texture banditchiefTXT;
    public static Sprite banditchiefSPR;

    public static Texture vampireTXT;
    public static Sprite vampireSPR;
    public static Texture werewolfTXT;
    public static Sprite werewolfSPR;
    public static Texture wolfTXT;
    public static Sprite wolfSPR;
    public static Texture mutantTXT;
    public static Sprite mutantSPR;
    public static Texture levelupTXT;
    public static Sprite levelupSPR;
    public static Texture invbarTXT;
    public static Sprite invbarSPR;
    public static Texture csTXT;
    public static Sprite csBMP;

    public static void createAssets(){
        platearmorTXT = new Texture("platearmor.png");
        platearmorSPR = new SpriteTouchable(platearmorTXT);
csTXT = new Texture("cursescreen.png");
csBMP = new Sprite(csTXT);
        coppernecklaceTXT = new Texture("coppernecklace.png");
        coppernecklaceSPR = new SpriteTouchable(coppernecklaceTXT);
leatherhelmetTXT = new Texture("leatherhelmet.png");
leatherhelmetSPR = new SpriteTouchable(leatherhelmetTXT);
        daggerTXT = new Texture("dagger.png");
        daggerSPR = new SpriteTouchable(daggerTXT);

        diamondglovesTXT = new Texture("diamondgloves.png");
        diamondglovesSPR = new SpriteTouchable(diamondglovesTXT);
        diamondhelmetTXT = new Texture("diamondhelmet.png");
        diamondhelmetSPR = new SpriteTouchable(diamondhelmetTXT);
        diamondnecklaceTXT = new Texture("diamondnecklace.png");
        diamondnecklaceSPR = new Sprite(diamondnecklaceTXT);
        dragonarmorTXT = new Texture("dragonarmor.png");
        dragonarmorSPR = new SpriteTouchable(dragonarmorTXT);
        dragonglovesTXT = new Texture("dragongloves.png");
        dragonarmorSPR = new SpriteTouchable(dragonglovesTXT);

        dragonhelmetTXT = new Texture("dragonhelmet.png");
        dragonhemletSPR = new SpriteTouchable(dragonhelmetTXT);
        leatherarmorTXT = new Texture("leatherarmor.png");
        leatherarmorSPR = new SpriteTouchable(leatherarmorTXT);
        mailglovesTXT = new Texture("mailgloves.png");
        mailglovesSPR = new SpriteTouchable(mailglovesTXT);
        mailshirtTXT = new Texture("mailshirt.png");
        mailshirtSPR = new SpriteTouchable(mailshirtTXT);
        noviceglovesTXT = new Texture("novicegloves.png");
        noviceglovesSPR = new SpriteTouchable(noviceglovesTXT);
        novicehatTXT = new Texture("novicehat.png");
        novicehatSPR = new SpriteTouchable(novicehatTXT);
        novicerobeTXT = new Texture("novicerobe.png");
        novicerobeSPR = new SpriteTouchable(novicerobeTXT);
        novicestaffTXT = new Texture("novicestaff.png");
        novicestaffSPR = new SpriteTouchable(novicestaffTXT);
        platearmorTXT = new Texture("platearmor.png");
        platearmorSPR = new SpriteTouchable(platearmorTXT);
        plateglovesTXT = new Texture("plategloves.png");
        plateglovesSPR = new SpriteTouchable(plateglovesTXT);
        platehelmetTXT = new Texture("platehelmet.png");
        platehelmetSPR = new SpriteTouchable(platehelmetTXT);
        silvernecklaceTXT = new Texture("silvernecklace.png");
        silvernecklaceSPR = new SpriteTouchable(silvernecklaceTXT);
        swordTXT = new Texture("sword.png");
        swordSPR = new SpriteTouchable(swordTXT);
        swordandshieldTXT = new Texture("swordandshield.png");
        swordswordandshieldSPR = new SpriteTouchable(swordandshieldTXT);
        twohandedswordTXT = new Texture("twohandedsword.png");
        twohandedswordSPR = new SpriteTouchable(twohandedswordTXT);
        leatherglovesTXT = new Texture("leathergloves.png");
        leatherglovesSPR = new SpriteTouchable(leatherglovesTXT);
banditchiefTXT = new Texture("banditchief.png");
banditchiefSPR = new SpriteTouchable(banditchiefTXT);
banditTXT = new Texture("bandit.png");
banditSPR = new SpriteTouchable(banditTXT);
        vampireTXT = new Texture("vampire.png");
        vampireSPR = new SpriteTouchable(vampireTXT);
        werewolfTXT = new Texture("werewolf.png");
        werewolfSPR= new SpriteTouchable(werewolfTXT);
        wolfTXT= new Texture("wolf.png");
        wolfSPR= new SpriteTouchable(wolfTXT);
        mutantTXT= new Texture("mutant.png");
        mutantSPR= new SpriteTouchable(mutantTXT);
levelupTXT = new Texture("levelup.png");
levelupSPR = new Sprite(levelupTXT);
invbarTXT = new Texture("inventorybar.png");
invbarSPR = new Sprite(invbarTXT);
    }

}
