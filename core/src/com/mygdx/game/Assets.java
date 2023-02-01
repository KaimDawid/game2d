package com.mygdx.game;

import Data.Quests.Quests;
import Mobs.Cemetery.CemeterySprites;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.Frontend.Statistics;

import java.util.ArrayList;

import static com.mygdx.game.GameApp.*;

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

    public static BitmapFont addMAGICBMP, addMAXMANABMP, armorBMP;
    public static String addATTACKTEXT, addMAXMANATEXT, armorTEXT;
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

    public static Texture dragonhelmetTXT, fisharmorTXT;
    public static Sprite dragonhemletSPR, fisharmorSPR;

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
    public static Texture poisonTXT;
    public static Sprite poisonBMP;


    public static Texture charstandingTXT;
    public static Sprite charstandingSPR;
    public static Texture quest1TXT;
    public static Sprite quest1SPR;
    public static Texture dialogueChoiceTXT;
    public static Sprite dialogueChoice1SPR;
    public static Sprite dialogueChoice2SPR;
    public static Texture bombTXT;
    public static Sprite bombSPR;
    public static Texture healthPotionTXT;
    public static Sprite healthPotionSPR;
    public static Texture manaPotionTXT;
    public static Sprite manaPotionSPR;
    public static Texture armorPotionTXT;
    public static Sprite armorPotionSPR;
    public static Texture grindingWheelTXT;
    public static Sprite grindingWheelSPR;

    public static Texture shopTXT;
    public static Sprite shopSPR;

    public static String sellText;
    public static BitmapFont sellBMP;
    public static String buyText;
    public static BitmapFont buyBMP;

    public static Texture usBagTXT;
    public static Sprite usBagSPR;

    public static String shopNameText;
    public static BitmapFont shopNameBMP;
    public static Texture fireanimTXT;
    public static Sprite fireanimSPR;
    public static ArrayList<TextureRegion> fireRegion;
    public  static Animation<TextureRegion> fireAnimation;
public static TextureRegion[] fireFrames;
public static TextureRegion[][] tmp;
public static SpriteBatch spriteBatch;
public static Texture fireBallAnimTexture;
public static float stateTime;

public static Texture interactTXT;
public static Sprite interactSPR;

    public static void createAssets(){
        fireBallAnimTexture = new Texture("charanim.png");

        TextureRegion[][] tmp = TextureRegion.split(fireBallAnimTexture,
                fireBallAnimTexture.getWidth() / 5,
                fireBallAnimTexture.getHeight() / 1);
        fireFrames = new TextureRegion[5*1];
        int index = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 5; j++) {
                fireFrames[index++] = tmp[i][j];
            }
        }

       fireAnimation = new Animation<TextureRegion>(0.025f, fireFrames);
       fireAnimation.setFrameDuration(1f);
       fireAnimation.setPlayMode(Animation.PlayMode.LOOP);
                spriteBatch = new SpriteBatch();
                stateTime = 0f;
        sellText = new String();
interactTXT = new Texture("interact.png");
interactSPR = new Sprite(interactTXT);
        sellText = " ";
        buyText = new String();
        sellBMP = new BitmapFont();
        buyBMP = new BitmapFont();
        shopNameText = new String();
        shopNameBMP = new BitmapFont();
        usBagTXT = new Texture("usablebag.png");
        usBagSPR = new Sprite( usBagTXT);
        bombTXT = new Texture("bomb.png");
        bombSPR = new Sprite(bombTXT);
        healthPotionTXT = new Texture("healthpotion.png");
        healthPotionSPR = new Sprite(healthPotionTXT);
        manaPotionTXT = new Texture("manapotion.png");
        manaPotionSPR = new Sprite(manaPotionTXT);
        armorPotionTXT = new Texture("armorpotion.png");
        armorPotionSPR = new Sprite(armorPotionTXT);
        grindingWheelTXT = new Texture("grindingwheel.png");
        grindingWheelSPR = new Sprite(grindingWheelTXT);
        quest1TXT = new Texture("quest1.png");
        shopTXT = new Texture("shopframe.png");
        shopSPR = new Sprite(shopTXT);
        quest1SPR = new Sprite(quest1TXT);
        dialogueChoiceTXT = new Texture("dialoguechoice.png");
        dialogueChoice1SPR = new Sprite(dialogueChoiceTXT);
        dialogueChoice2SPR = new Sprite(dialogueChoiceTXT);
        platearmorTXT = new Texture("platearmor.png");
        platearmorSPR = new SpriteTouchable(platearmorTXT);
        charstandingTXT = new Texture("charstanding.png");
        charstandingSPR = new Sprite(charstandingTXT);

csTXT = new Texture("cursescreen.png");
csBMP = new Sprite(csTXT);
poisonTXT = new Texture("poisonstatus.png");
poisonBMP = new Sprite(poisonTXT);


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
        dragonarmorSPR = new SpriteTouchable(dragonarmorTXT);

        dragonhelmetTXT = new Texture("dragonhelmet.png");
        dragonhemletSPR = new SpriteTouchable(dragonhelmetTXT);
        fisharmorTXT = new Texture("fishscalearmor.png");
        fisharmorSPR = new SpriteTouchable(fisharmorTXT);
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


        charstandingSPR.setSize(120,140);
       dialogueChoice1SPR.setSize(0,0);
       dialogueChoice2SPR.setSize(0,0);
       grindingWheelSPR.setSize(50,50);
       healthPotionSPR.setSize(50,50);
       manaPotionSPR.setSize(50,50);
       armorPotionSPR.setSize(50,50);
       bombSPR.setSize(50,50);
       shopSPR.setSize(480,800);
       usBagSPR.setSize(480,800);
       quest1SPR.setSize(0,0);

    }
    public static void RenderAssets(){
        batch.begin();

        mapSprite.draw(batch);
	/*	faceDown1SPR.draw(batch);
		faceDown2SPR.draw(batch);
		faceLeft2SPR.draw(batch);

		faceRight1SPR.draw(batch);
		faceRight2SPR.draw(batch);
		faceUp2SPR.draw(batch);
		faceUp1SPR.draw(batch);
*/

		/*Assets.attackSpr.setPosition(playerSprite.getX() - 600, playerSprite.getY() - 250);
		Assets.runSpr.setPosition(playerSprite.getX() - 300, playerSprite.getY() - 250);*/
        buttonBounds.setBounds((int) (playerSprite.getX() + 300), (int) (playerSprite.getY() - 250), 6000, 6000);

        Equipment.X = playerSprite.getX() - 400;
        Equipment.Y = playerSprite.getY() + 300;

        fightscreenSP.draw(batch);

        /*   playerSprite.set(faceDown1SPR);*/
        /*inventorySP.setPosition(playerSprite.getX(), playerSprite.getY()+100);*/

/*if (GameApp.moveDOWN == false && GameApp.moveUP == false && GameApp.moveLEFT == false && GameApp.moveRIGHT == false) {
	timer.schedule(new TimerTask() {
		@Override
		public void run() {

		}
	},100);

}*/
        playerSprite.draw(batch);

        Statistics.addStats();



        Fonts.levelUpSprite.setPosition(playerSprite.getX()-400,playerSprite.getY()-200);
        sprite.draw(batch);
        Fonts.playerAttackFont.draw(batch, Fonts.playerAttackText, playerSprite.getX()- 600, playerSprite.getY() );
        Fonts.enemyAttackFont.draw(batch, Fonts.enemyAttackText, playerSprite.getX()- 250, playerSprite.getY() + 250);
        Fonts.topTextBitmap.draw(batch, Fonts.topText, playerSprite.getX()- 300, playerSprite.getY() + 420);
        Quests.questInfoBitMap.draw(batch, Quests.questInfo, playerSprite.getX()- 300, playerSprite.getY() + 320);
        Fonts.mobSpellBitmap.draw(batch, Fonts.mobSpellText, playerSprite.getX(), playerSprite.getY() + 150);
        Fonts.bottomBitMapFont.draw(batch, Fonts.bottomText,playerSprite.getX()- 400,playerSprite.getY() - 400);
        Fonts.leftBitMapFont.draw(batch, Fonts.leftText, playerSprite.getX()- 900,playerSprite.getY() + 100);



        Fonts.levelUpSprite.draw(batch);
        iceBoltSPR.draw(batch);

        adrenalineSPR.draw(batch);
        ironskinSPR.draw(batch);
        getIceBoltSPR2.draw(batch);

        fireBallSPR2.draw(batch);
        getAdrenalineSPR2.draw(batch);
        ironskinSPR2.draw(batch);
        healSPR2.draw(batch);
        cleaveSPR2.draw(batch);
        /*Equipment.displayEQ();*/
        Assets.addAttributeSPR.draw(batch);

        Assets.addAttributeSPR.setPosition(playerSprite.getX()+ 300,playerSprite.getY() - 300);
        Assets.addHP.setPosition(playerSprite.getX() + 580,playerSprite.getY()+100);
        Assets.addDMG.setPosition(playerSprite.getX() + 580,playerSprite.getY()+200);
        Assets.addMANA.setPosition(playerSprite.getX() + 580,playerSprite.getY()-200);
        Assets.addMAGIC.setPosition(playerSprite.getX() + 580,playerSprite.getY());
        Assets.addCRIT.setPosition(playerSprite.getX() + 580,playerSprite.getY()-100);
        Assets.addMAGIC.draw(batch);
        Assets.addDMG.draw(batch);
        Assets.addHP.draw(batch);
        Assets.addMANA.draw(batch);
        Assets.addCRIT.draw(batch);



        Assets.addATTACKBMP.draw(batch, Assets.addATTACKTEXT, Assets.addDMG.getX() - 180, Assets.addDMG.getY() + 30);
        Assets.addHPBMP.draw(batch, Assets.addHPTEXT, Assets.addHP.getX() - 180, Assets.addHP.getY() + 30);
        Assets.addCRITBMP.draw(batch, Assets.addCRITTEXT, Assets.addDMG.getX() - 180, Assets.addCRIT.getY() + 30);
        Assets.addMAGICBMP.draw(batch, Assets.addMAGICTEXT, Assets.addDMG.getX() - 180, Assets.addMAGIC.getY() + 30);
        Assets.addMANABMP.draw(batch, Assets.addMANATEXT, Assets.addDMG.getX() - 180, Assets.addMANA.getY() + 30);

        Assets.healSPR.draw(batch);
        cleaveSPR.draw(batch);
        Assets.dualWieldSPR.draw(batch);
        Assets.iceSpr.draw(batch);

        Assets.runSpr.draw(batch);



        if (Gdx.input.isKeyJustPressed(Input.Keys.B) && fightstart == 0) {

            if (showequip == 0){
                showequip = 1;
            }
            else if (showequip == 1 && fightstart == 0){
                showequip = 0;
                Equipment.itemDescription = " ";
            }


/*inventorySP.setPosition(playerSprite.getX() - 500, playerSprite.getY() - 220);
            inventorySP.setSize(700,600);
			inventorySP.draw(batch);*/



        }
        if (showequip == 1) {

            Equipment.displayEQ();
        }
        else {
            inventorySP.setSize(0,0);
        }

        invbarSPR.draw(batch);
        Equipment.itemDescriptionBMP.draw(batch, Equipment.itemDescription, Equipment.ix,Equipment.iy);


        enemybar.setPosition(sprite.getX(),sprite.getY());
        enemybargreen.setPosition(sprite.getX(),sprite.getY());
        enemybar.draw(batch);
        enemybargreen.draw(batch);



        Assets.poisonBMP.setPosition(playerSprite.getX()+ 300, playerSprite.getY() + 350);







        Assets.poisonBMP.draw(batch);
        playerAttackBMP2.draw(batch, playerAttackText2, playerSprite.getX(), playerSprite.getY() - 100);
        Assets.levelupSPR.setPosition(playerSprite.getX() - 300,playerSprite.getY()+ 250);
        levelupSPR.draw(batch);
        csBMP.draw(batch);
        Fonts.curseBMP.draw(batch, Fonts.curseTEXT, playerSprite.getX()- 400,playerSprite.getY()  + 150);
        quest1SPR.draw(batch);
        dialogueChoice1SPR.draw(batch);
        dialogueChoice2SPR.draw(batch);
        Quests.questStoryBitMap.draw(batch, Quests.questStory, playerSprite.getX() - 750, playerSprite.getY() + 400);
        Quests.diaChoice1BitMap.draw(batch, Quests.diaChoice1, playerSprite.getX() - 700, playerSprite.getY() + 90);
        Quests.diaChoice2BitmMap.draw(batch, Quests.diaChoice2, playerSprite.getX() - 700, playerSprite.getY() - 10);
        testScreenSP.draw(batch);
	/*	cursorSPR.draw(batch);
		cursorSPR.setSize(50,50);
cursorSPR.setPosition(playerSprite.getX(),playerSprite.getY());*/
        batch.end();




    }

}
