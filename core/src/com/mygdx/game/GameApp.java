package com.mygdx.game;

import Data.Quests.*;
import Logic.Drop.Miscelanous;
import Logic.Drop.Wood;
import Logic.FightLogic.Fight;
import Logic.FightLogic.FightLogic;
import Logic.FightLogic.Skills.Fireball;
import Logic.Experience;
import Logic.FightLogic.Skills.Spells;
import Logic.Input.RenderInput;
import Logic.Inventory;
import Logic.Movement;
import Mobs.*;
import Mobs.Beach.Crayfish;
import Mobs.Castle.Gabbie;
import Mobs.Cemetery.CemeterySprites;
import Mobs.Dungeon.Minotaur;
import Mobs.StartingZone.*;
import Objects.Items.Item;
import Objects.Items.Usables.*;
import Objects.Items.Weapons.Weapon;
import Objects.Ladder;
import Objects.LadderDOWN;
import Objects.LadderUP;
import Objects.Shop.Shop;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Backend.Backend;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.AllAssets;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.Frontend.Interfejs.TownMenu;
import com.mygdx.game.Frontend.Statistics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import static Data.Quests.CysiuQuest.cysiuSPR;
import static Data.Quests.FlorekQuest.*;
import static Data.Quests.Quests.*;
import static Logic.Experience.*;
import static Objects.Shop.Shop.*;
import static com.badlogic.gdx.graphics.Color.ORANGE;
import static com.badlogic.gdx.graphics.Color.YELLOW;
import static com.mygdx.game.Assets.*;
import static com.mygdx.game.Frontend.Eq.Equipment.itemDescription;
import static com.mygdx.game.Frontend.Eq.Equipment.itemDescriptionBMP;
import static com.mygdx.game.Frontend.Fonts.*;
import static com.mygdx.game.Frontend.Statistics.*;

public class GameApp extends ApplicationAdapter {

    public static Monster gabbie;
    int borderX = 16;
    public static boolean transitionOut, transitionIn, narrowScreen, windowOpen = false, screenTransition = false, drawSource;
    public static SpriteBatch spriteBatch;
    public static int loopRepeated, loopRepeated2, screenValue, fightON, moveValue, expScreen = 0, statsscreen = 0;
    public static List<Sprite> usableList;
    public static String fps;
    public static BitmapFont fpsBMP;
    int toxic = 0;
    private final Color clearColor = new Color();
    private final Color startingClearColor = new Color();
    private final Color targetClearColor = new Color();
    public static float elapsedClearColorChangeTime, clearChangeDuration;

    Scanner scanner = new Scanner(System.in);
    public static Item[] equipment = new Item[100];
    public static TextField stats;

    public static Vector3 touchPoint;

    double[] field = new double[100];

    public static Player Dawid;

    int spawnedMonstersFloor2 = 1;

    public static SpriteBatch batch;
    public static int fightstart = 0;
    public static Rectangle cursor;
    public static Monster currentTarget;

    private Stage stage;
    private Actor actor;
    public static String inventoryString;
    public static TextField inventoryScreen[];
    public static BitmapFont inventoryScreenBitMap[];
    public static ActionListener fight;
    public static ActionEvent fightEvent;
    private static Texture texture;
    public static Texture castleTXT;
    public static Sprite sprite;
    public static int showequip = 0;
    public static Color originalColor;
    public static Color originalColor2;
    public static Camera camera;
    public static Sprite inventorySP;
    public static Texture spiderTexture, goblinTxt, ironskinTXT, adrenalineTXT, fightscreenTX, fireBallTXT, iceBoltTXT, skeletonTxt, cursorTXT, playerTexture, forestTexture, inventoryTX, mapTexture, hpbargreenTXT;
    public static Sprite spiderSprite, goblinSprite, skeletonSprite, cursorSPR, enemybar, enemybargreen, testScreenSP, fightscreenSP, mapSprite, OGColor2, OGColor, DawidSprite, playerSprite, forestSprite;
    public static Pixmap cursorPixmap;
    public static Spider spider;
    public static Mutant mutant;
    public static Rectangle buttonBounds;
    public static Cursor cursorTwo;
    public static SpriteBatch spellsBatch;
    public static SpriteTouchable iceBoltSPR, fireBallSPR2, getIceBoltSPR2, getAdrenalineSPR2, ironskinSPR2, ironskinSPR, cleaveSPR2, healSPR2, fireBallSPR, adrenalineSPR;
    public static ClickListener hover;
    public static List<Sprite> eqList;
    public static Timer timer;
    public static String playerAttackText2;
    public static Minotaur minotaur;
    public static BitmapFont playerAttackBMP2;
    public static float xValue;
    public static float yValue;
    public static Color color;
    public static Color color2;
    public static Fireball fireball;
    public static Sprite battleStance;

    private boolean freezeScreen = false;

    public Pixmap pm;
    public static HealthPotion healthPotion;
    public static ManaPotion manaPotion;
    public static ArmorPotion armorPotion;
    public static GrindingWheel grindingWheel;
    public static Bomb bomb;
    public static Crayfish crayfish;
    public static boolean penis = false;

    public static Monster werevolf;
    public static int currentXP;
    public static Music musicBG;
    public static TimerTask mobAttack;

    @Override
    public void create() {
        mobAttack = new TimerTask() {
            @Override
            public void run() {
                try {
                    Fight.EnemyAttack(Dawid, currentTarget);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        int xHotspot = 0, yHotspot = 0;

        cursorPixmap = new Pixmap(Gdx.files.internal("cursor2.png"));

        cursorTwo = Gdx.graphics.newCursor(cursorPixmap, xHotspot, yHotspot);
        cursorPixmap.dispose();
        fireball = new Fireball();
        spriteBatch = new SpriteBatch();
        dupa dupa = new dupa();
        dupa.setCipajas(1);
        usableList = new ArrayList<Sprite>();
        Item.edible = new ArrayList<Item>();
        Item.gear = new ArrayList<Item>();
        /*  shop.makeAShopList();*/
        healthPotion = new HealthPotion(0, "Health potion + 300 HP", false, false, false, false, true, 80, 40, 0, 200, 0, 0, 0, 0, 0);
        manaPotion = new ManaPotion(0, "Mana potion + 100 mana", false, false, false, false, true, 50, 25, 160, 0, 0, 0, 0, 0, 0);
        armorPotion = new ArmorPotion(0, "Armor potion + 20 armor", false, false, false, false, true, 800, 400, 0, 0, 0, 0, 25, 0, 0);
        grindingWheel = new GrindingWheel(0, "Grinding wheel + 50 dmg to weapon", false, false, false, false, true, 180, 90, 0, 0, 0, 0, 0, 0, 20);
        bomb = new Bomb(0, "Small bomb", false, false, false, false, true, 80, 40, 0, 0, 0, 0, 0, 0, 150);
        grindingWheel.setAddDmg(50);
        armorPotion.setMaxStock(1);
        grindingWheel.setMaxStock(3);
        color = new Color();
        color2 = new Color();
        fps = new String();
        fpsBMP = new BitmapFont();
        Quests.questStory = " ";
        Quests.diaChoice1 = " ";
        Quests.diaChoice2 = " ";
        Fonts.curseTEXT = new String(" ");
        Fonts.curseBMP = new BitmapFont();
        playerAttackText2 = new String();
        playerAttackBMP2 = new BitmapFont();
        playerAttackText2 = " ";
        spellsBatch = new SpriteBatch();
        timer = new Timer();
        Assets.createAssets();
        texture = new Texture(Gdx.files.internal("mutant.png"));
        sprite = new Sprite(texture);
        playerTexture = new Texture(Gdx.files.internal("charanim.png"));
        battleStance = new Sprite(playerTexture);
        battleStance.setSize(0, 0);
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        playerSprite = new Sprite(playerTexture);

        playerSprite.setPosition((w / 2 - sprite.getWidth() / 2) + 6000, (h / 2 - sprite.getHeight() / 2) + 2736);
        Movement.createMovement();
        Statistics.create();
        Wood.Spawn();
        cursorTXT = new Texture("cursor.png");
        cursorSPR = new Sprite(cursorTXT);
        cursorSPR.setSize(50, 50);
        fireball.createFire();
        xValue = playerSprite.getX();
        yValue = playerSprite.getY();
        playerSprite.setSize(120, 140);

        itemDescription = " ";
        Fonts.itemDescription = new String();
        Fonts.itemDescriptionBMP = new BitmapFont();
        Fonts.itemDescriptionBMP.getData().setScale(3, 3);

        hover = new ClickListener();
        Backend.hbTXT = new Texture("healthbar.png");
        hpbargreenTXT = new Texture("hpbargreen.png");
        enemybar = new Sprite(Backend.hbTXT);
        enemybargreen = new Sprite(hpbargreenTXT);
        Shop.shopList = new ArrayList<Sprite>();
        eqList = new ArrayList<Sprite>();
        Assets.createAssets();
        Assets.katanaTXT = new Texture("katana.png");
        Assets.katanaSPR = new SpriteTouchable(katanaTXT);
        touchPoint = new Vector3();
        crayfishTXT = new Texture("crayfish.png");
        crayfishSPR = new Sprite(crayfishTXT);
        cursor = new Rectangle();

        Dawid = new Player(1, 1, 1, 0, 0, 4, 4, 0, 0, 0, 0);
        int helmEQ = 0;

        Backend.createBackEnd();
        Fonts.createFonts();
        Fonts.levelUpScreen = new Texture("skillscreen.png");
        Assets.addAttributeSPR = new SpriteTouchable(Fonts.levelUpScreen);
        Fonts.levelUpSprite = new SpriteTouchable(Fonts.levelUpScreen);
        buttonBounds = new Rectangle((int) Assets.attackSpr.getX(), (int) Assets.attackSpr.getY(), (int) Assets.attackSpr.getWidth(), (int) Assets.attackSpr.getHeight());
        spider = new Spider(100, 10, 4, 6, "pajonk", 100, 1, 1);
        mutant = new Mutant(100, 10, 5, 6, "pajonk", 100, 1, 1, 1);
        cleaveSPR2 = new SpriteTouchable(cleaveTXT);
        getAdrenalineSPR2 = new SpriteTouchable(adrenalineTXT);
        ironskinSPR2 = new SpriteTouchable(ironskinTXT);
        healSPR2 = new SpriteTouchable(healTXT);
        getIceBoltSPR2 = new SpriteTouchable(iceBoltTXT);
        fireBallSPR2 = new SpriteTouchable(fireBallTXT);
        fireBallSPR2.setSize(0, 0);


        Fonts.attackText = new TextField();
        Fonts.attackText.setText("Siema");

        camera = new OrthographicCamera(1920, 1080);
        batch = new SpriteBatch();

        Shop.shopTxt = new Texture("shopframe.png");
        Shop.shopSprite = new Sprite(Shop.shopTxt);
        Shop.shopSprite.setSize(360, 600);
        usBagSPR.setSize(480, 800);
        Monster.create1();
        inventoryTX = new Texture("inventory2.png");
        inventorySP = new Sprite(inventoryTX);
        /*inventorySP.setPosition((w / 2 - sprite.getWidth() / 2) - 300, h / 2 - sprite.getHeight() / 2);*/
        mapTexture = new Texture("mymap2.png");
        mapSprite = new Sprite(mapTexture);

        OGColor = new Sprite(mapTexture);
        DawidSprite = new Sprite(playerTexture);

        forestTexture = new Texture(Gdx.files.internal("forest.jpg"));
        forestSprite = new Sprite(forestTexture);
        forestSprite.setPosition(w / 2 - sprite.getWidth() / 2, h / 2 - sprite.getHeight() / 2);
        sprite.setSize(0, 0);
        forestSprite.setSize(0, 0);
        forestSprite.setPosition(forestSprite.getX() - 320, forestSprite.getY() - 230);
        sprite.setPosition(sprite.getX(), sprite.getY() - 200);
        inventorySP.setSize(0, 0);

        playerSprite.setRegion(0, 0, 40, 100);
        minotaur = new Minotaur(5000, 120, 20, 2, "Minotaur", 1000, 10, 1);
        sprite.setPosition(playerSprite.getX() + 100, playerSprite.getY());
        Fonts.attackText.setLocation((int) (playerSprite.getX() - 100), (int) (playerSprite.getY() + 200));
        stats = new TextField("Zadałeś 100 obrażeń!");
        stats.setLocation((int) playerSprite.getX(), (int) playerSprite.getY());
        Fonts.font = new BitmapFont();
        mapSprite.setPosition(playerSprite.getX() - 1384, playerSprite.getY() - 766);
        mapSprite.setSize(38400, 21600);
        Dawid = new Player(400, 400, 60, 0, 0, 4, 4, 0, 0, 0, 0);
        Dawid.setFloor(1);
        Dawid.setClassNumber(1);
        Dawid.setMana(150);
        Dawid.setMaxMana(150);
        Dawid.setManaRegen(15);
        fightscreenTX = new Texture("battlescreen.png");
        fightscreenSP = new Sprite(fightscreenTX);
        fightscreenSP.setSize(1, 1);
        Backend.forestTXT = new Texture("forest.jpg");
        Backend.banditcampTXT = new Texture("banditcamp.jpg");
        Backend.fieldsTXT = new Texture("field.png");
        Backend.cemeteryTXT = new Texture("cemetery.png");
        castleTXT = new Texture("castle.png");
        testScreenSP = new Sprite(fightscreenTX);
        testScreenSP.setSize(0, 0);
        /*	testScreenSP.setSize(1920,1080);*/
        testScreenSP.setPosition(playerSprite.getX(), playerSprite.getY());
        /*	testScreenSP.setPosition(playerSprite.getX() - 960, playerSprite.getY() - 540);*/
        gabbie = new Gabbie(2000, 50, 110, 122, "Gabbie Flowers", 500, 8, 1);
        Fonts.levelUpSprite.setPosition(playerSprite.getX() - 300, playerSprite.getY() - 200);
        Fonts.levelUpSprite.setSize(0, 0);
        camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
        camera.update();
        OGColor2 = new Sprite(fightscreenSP);
        originalColor = OGColor.getColor();
        originalColor2 = OGColor2.getColor();
        Equipment.create();


        mobSpellBitmap.setColor(ORANGE);

        Fonts.mobSpellBitmap = Fonts.Impact.generateFont(impactFont);

        Array<TextureRegion> textureRegion = new Array<TextureRegion>();
        Spells.create();
        FightLogic.create();
        Shop.create();
        AllAssets.Create();
        Usables.setAllImages();
        TownMenu.create();
        Quests.create();
        CemeterySprites.create();
        Monster.create();
        QuestLog.create();
        FlorekQuest.create();
        CysiuQuest.create();

        playerSprite.setPosition(7856, 3798);
        camera.update();
        Soundtrack.create();
        Weapon.giveStartingWeapon();
        RusakovQuest.create();

    }

    @Override
    public void dispose() {

    }

    public static int stepsLeft = 0;

    @Override
    public void render() {
        Soundtrack.render();

        camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
        camera.update();
        //
        //
        // playerSprite.setPosition((Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2) + 7130, (Gdx.graphics.getHeight() / 2 - sprite.getHeight() / 2) + 3385);
        // STARTOWA LOKACJA!!!!
        //

        /*      Movement.updatePostion();*/
        Movement.goUP(Dawid);
        Movement.goRIGHT(Dawid);
        Movement.goDOWN(Dawid);
        Movement.goLEFT(Dawid);
        try {
            RenderInput.LoadInput();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /* ObjectCreator.UpdateShopPosition(shopList);*/
        showXP(Dawid);
        Logic.Camera.fadeIn();
        Logic.Camera.fadeOut();
        Experience.expCounter(Dawid);
        experienceCheck();
        Statistics.addStats();


        try {
            SpidersQuest.QuestConvo(Dawid);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        batch.setProjectionMatrix(camera.combined);


        try {
            Backend.MoveConclude();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cursor.setBounds(Gdx.input.getX(), Gdx.input.getY(), 10, 10);
        if (gabbie.getHp() < 1) {

            Quests.gabiOverworldSPR.setRegion(100, 0, 200, 180);
            Quests.gabiOverworldSPR.setSize(600, 300);
            mapSprite.setColor(originalColor);
        }


        if (fightscreenSP.getHeight() < 10) {
            fightscreenSP.setPosition(playerSprite.getX(), playerSprite.getY());
            attackSpr.setPosition(playerSprite.getX(), playerSprite.getY());
            runSpr.setPosition(playerSprite.getX(), playerSprite.getY());
            playerSprite.setSize(120, 140);
        }
        if (fightstart == 0) {
            sprite.setSize(0, 0);
        }
        if (fightstart == 1) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    playerSprite.setSize(0, 0);

                }
            }, 500);

        } else if (fightstart == 0) {

        }

        /*  Gdx.gl.glClearColor(1, 1, 1, 1);*/
        if (fightstart == 0) {
            enemybar.setSize(0, 0);
        }
        batch.enableBlending();
        batch.begin();

Quests.preRender();
        RenderInput.renderInteract();
        buttonBounds.setBounds((int) (playerSprite.getX() + 300), (int) (playerSprite.getY() - 250), 6000, 6000);
        Equipment.X = GameApp.playerSprite.getX() - 400;
        Equipment.Y = GameApp.playerSprite.getY() + 300;
        playerInfoSPR.setPosition(playerSprite.getX() + 500, playerSprite.getY() + 330);
        playerInfoSPR.draw(batch);

        bottomBitMapFont.draw(batch, Fonts.bottomText, playerSprite.getX() + 520, playerSprite.getY() + 480);
        playerSprite.draw(batch);

        Monster.minotaurSPR.draw(batch);
        if (fightstart == 0) {
            CysiuQuest.cysiuSPR.draw(batch);
            Monster.minotaurSPR.setSize(300, 300);
            Monster.minotaurSPR.setPosition(cysiuSPR.getX() + 1890, cysiuSPR.getY() + 160);
        }

        fightscreenSP.draw(batch);
        if (fightstart == 1) {
            battleStance.draw(batch);
            sprite.draw(batch);
        }
        Fonts.levelUpSprite.setPosition(playerSprite.getX() - 400, playerSprite.getY() - 200);
        Fonts.renderFonts();
        TownMenu.render();
        Gdx.graphics.setCursor(cursorTwo);
        FightLogic.render();
        Fonts.sideQuestBMP.setColor(Color.GREEN);
        Fonts.sideQuestBMP.draw(batch, sideDescription, playerSprite.getX() + 100, playerSprite.getY() - 100);
        RenderInput.loadShop();
        Statistics.render();
      Quests.render1();

        RysiuQuest.Quest2Convo();
        FlorekQuest.Quest3Convo();
        CysiuQuest.Quest4Convo();
        RusakovQuest.QuestConvo();

        Quests.render2();
        Quests.updateDescription();
        AllAssets.Draw();
        Fonts.missOrCritBMP.draw(batch, Fonts.missOrCritText, battleStance.getX() + 700, battleStance.getY() + 100);
        FightLogic.blockInput();


        if (showequip == 1) {
            Equipment.displayEQ();
        }
        itemDescriptionBMP.draw(batch, itemDescription, Equipment.descriptionX, Equipment.descriptionY);
        batch.end();
       batch.begin();
        Spells.render();
        batch.end();

        batch.begin();
        FightLogic.gameOverRender();
        batch.end();
        spriteBatch.begin();
        batch.disableBlending();
        spriteBatch.draw(fireBallTXT, playerSprite.getX(), playerSprite.getY(), 800, 800);
        spriteBatch.end();



    }


    public static void showLevel(Player gracz) {

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    public void eqDisplay(Player player) {


    }

    ShapeRenderer fadeRenderer;

    public static void LadderCheckUP(LadderUP ladder, Player player) {
        Scanner scanner1 = new Scanner(System.in);
        if (player.getX() == ladder.getX() && player.getY() == ladder.getY() && player.getFloor() == ladder.getFloor()) {

            Ladder.ASCEND(player);


        }

    }


    public static void LadderCheckDOWN(LadderDOWN ladder, Player player) {
        Scanner scanner1 = new Scanner(System.in);
        if (player.getX() == ladder.getX() && player.getY() == ladder.getY() && player.getFloor() == ladder.getFloor()) {


            Ladder.DESCEND(player);


        }

    }

    private void changeClearColor(int colorHex, float duration) { //for example 0xff0000ff for Red
        targetClearColor.set(colorHex);
        startingClearColor.set(clearColor);
        elapsedClearColorChangeTime = 0;
        clearChangeDuration = duration;
    }

    private void updateClearColor(float deltaTime) {
        if (elapsedClearColorChangeTime < clearChangeDuration) {
            elapsedClearColorChangeTime = Math.min(elapsedClearColorChangeTime + deltaTime, clearChangeDuration);
            clearColor.set(startingClearColor).lerp(targetClearColor,
                    Interpolation.fade.apply(elapsedClearColorChangeTime / clearChangeDuration));
        }
        Gdx.gl.glClearColor(clearColor.r, clearColor.g, clearColor.b, clearColor.a);
    }


}