package com.mygdx.game;

import Data.Areas.BanditCamp;
import Data.Areas.Forest;
import Logic.Experience;
import Logic.FightLogic.Fight;
import Logic.FightLogic.FightLogic;
import Logic.GameLogic;
import Logic.Inventory;
import Logic.Spawners.*;
import Mobs.*;
import Objects.Items.Item;
import Objects.Items.Weapons.Weapon;
import Objects.Ladder;
import Objects.LadderDOWN;
import Objects.LadderUP;
import Objects.Shop.Shop;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.Target;
import java.util.Random;
import java.util.Scanner;

import static Logic.Experience.*;
import static Logic.FightLogic.Fight.*;
import static Mobs.Monster.eqNumber;
import static com.mygdx.game.Assets.cleaveTXT;
import static com.mygdx.game.Assets.healTXT;

public class GameApp extends ApplicationAdapter {
	public static int levelCap = 0;
	static int checkSuccesful = 0;
	private static Player player;
	private static Monster monster;

	int toxic = 0;

	public static int fightON;
public static int expScreen = 0;
	int borderX = 16;
	int borderY = 16;
	static int ladderCheckUPSuccessful = 0;
	static int ladderCheckDOWNSuccessful = 0;
public static int statsscreen = 0;
	Scanner scanner = new Scanner(System.in);
	public static Monster[] monsterBase = new Monster[50];
	public static Monster[] forestBase = new Monster[50];
	static Monster[] monsterBase2 = new Monster[50];
	static Monster[] monsterBase3 = new Monster[50];

	public static Item[] equipment = new Item[100];

	static Monster[] monsterBase4 = new Monster[50];

	static Monster[] monsterBase5 = new Monster[50];

	static Monster[] monsterBase6 = new Monster[50];
	static FreeTypeFontGenerator fontGenerator;
static FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;
	static Ladder[] ladders = new Ladder[10];

	static Monster[] banditCampBase = new Monster[50];

	static int[] ladX = new int[10];

	static int[] ladY = new int[10];

	public static TextField stats;

	static LadderDOWN[] ladderDOWNS = new LadderDOWN[10];
	public static Vector3 touchPoint;

	static LadderUP[] ladderUPS = new LadderUP[10];

	double[] field = new double[100];

	public static Player Dawid;
	public static int spawnedMonsters = 1;
	int spawnedMonstersFloor2 = 1;

	double checkme[] = new double[500];
	public static String enemyAttackText;
	public static String bottomText;
	public static String topText;
	public static BitmapFont topTextBitmap;
	public static String mobSpellText;
	public static BitmapFont mobSpellBitmap;
	//
	//
	//
	//     WSZYSTKIE TESKTURY!!!
	//
	//
	////
	//	//
	//	//
	//	//     WSZYSTKIE TESKTURY!!!
	//	//
	//	//
	//	//
	public static SpriteBatch batch;
	private static Texture texture;
	public static Sprite sprite;
	private static Texture forestTexture;
	private static Sprite forestSprite;
	public static Texture playerTexture;
	public static Sprite playerSprite;
public static String playerAttackText;
	public static Camera camera;

	private static Screen screen;
	private static Target target;
	private static Vector3 vector;
	private static Shop shop;
	private static Minotaur minotaur;
	private static Texture mapTexture;
	private static Sprite mapSprite;
	private static Texture inventoryTX;
	private static Sprite inventorySP;

	private static Texture fightscreenTX;
	public static Sprite fightscreenSP;
	public static int fightstart = 0;
public static Rectangle cursor;
	static Monster currentTarget;
//
	//
	//
	//     WSZYSTKIE TESKTURY!!!
	//
	//
	////
	//	//
	//	//
	//	//     WSZYSTKIE TESKTURY!!!
	//	//
	//	//
	//	//

private Stage stage;
private Actor actor;
private Event battle;
public static Sprite statsSprite;
public static BitmapFont font;
public static TextField attackText;
public static String inventoryString;
public static TextField inventoryScreen[];
public static BitmapFont inventoryScreenBitMap[];
public static ActionListener fight;
public static ActionEvent fightEvent;
public static BitmapFont enemyAttackFont;
public static Texture spiderTexture;
public static Sprite spiderSprite;
public static BitmapFont playerAttackFont;
public static Spider spider;
public static Mutant mutant;
public static Monster defaltowy;
public static Texture goblinTxt;
public static Sprite goblinSprite;

public static BitmapFont bottomBitMapFont;
	public static Texture skeletonTxt;
	public static Sprite skeletonSprite;
	public static Texture shopTxt;
	public static Sprite shopSprite;
	public static String playerInfo;
	public static BitmapFont playerInfoBitMap;
	public static Rectangle buttonBounds;
	public static String leftText;
	public static BitmapFont leftBitMapFont;
	public static Texture levelUpScreen;
	public static SpriteTouchable levelUpSprite;
	public static Texture iceBoltTXT;
	public static SpriteTouchable iceBoltSPR;
	public static Texture fireBallTXT;
	public static SpriteTouchable fireBallSPR2;
	public static SpriteTouchable getIceBoltSPR2;
	public static SpriteTouchable getAdrenalineSPR2;
	public static SpriteTouchable ironskinSPR2;
	public static SpriteTouchable cleaveSPR2;
	public static SpriteTouchable healSPR2;
	public static SpriteTouchable fireBallSPR;
	public static Texture adrenalineTXT;
	public static SpriteTouchable adrenalineSPR;
	public static Texture ironskinTXT;
	public static SpriteTouchable ironskinSPR;
	public static Texture dualWieldTXT;
	public static SpriteTouchable dualWieldSPR;

	@Override
	public void create() {
		touchPoint = new Vector3();
		fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("AGoblinAppears-o2aV.ttf"));
		fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParameter.size = 10;
		fontParameter.borderColor = Color.BLACK;
fontParameter.color = Color.RED;
cursor = new Rectangle();
cursor.setBounds(1,1,1,1);
		Dawid = new Player(1,1,1,0,0,4,4,0,0,0,0);
		int helmEQ = 0;
		createBackEnd();
		levelUpScreen = new Texture("skillscreen.png");
		Assets.addAttributeSPR = new SpriteTouchable(levelUpScreen);
		levelUpSprite = new SpriteTouchable(levelUpScreen);
		buttonBounds = new Rectangle((int) Assets.attackSpr.getX(), (int) Assets.attackSpr.getY(), (int) Assets.attackSpr.getWidth(), (int) Assets.attackSpr.getHeight());
		spider = new Spider(100,10,4,6,"pajonk",100,1,1);
		mutant = new Mutant(100,10,5,6,"pajonk",100,1, 1, 1);
		cleaveSPR2 = new SpriteTouchable(cleaveTXT);
		getAdrenalineSPR2 = new SpriteTouchable(adrenalineTXT);
		ironskinSPR2 = new SpriteTouchable(ironskinTXT);
		healSPR2 = new SpriteTouchable(healTXT);
		getIceBoltSPR2 = new SpriteTouchable(iceBoltTXT);
		fireBallSPR2 = new SpriteTouchable(fireBallTXT);
		playerAttackText = " ";
		enemyAttackText = " ";
		leftText = "Sterowanie: \n \n " +
				"Chodzenie:  W, S, D, A \n \n Mapa: Tab \n \n Ekwipunek: F2 \n \n Atrybuty: P ";
		topText = " ";
		mobSpellText = " ";
		bottomText = "Wyjdź z gry: 0, Sterowanie: WSAD     Ekwipunek: F2,       Atrybuty : P                Mapa : TAB ";
		playerInfo = "Punkty zdrowia: " + Dawid.getHP() + "/" + Dawid.getMaxHP() + "         Mana: " +Dawid.getMana() +
				"\n Doświadczenie: " + Dawid.getXP() + "/" + levelCap + "         Poziom: " + Dawid.getLevel() +
				"\n Punkty obrażeń: " + Dawid.getDMG();
		playerInfoBitMap = new BitmapFont();
		mobSpellBitmap = new BitmapFont();
		mobSpellBitmap.getData().setScale(2);
		Assets.addATTACKBMP = fontGenerator.generateFont(fontParameter);
		Assets.addCRITBMP = fontGenerator.generateFont(fontParameter);
		Assets.addHPBMP = fontGenerator.generateFont(fontParameter);
		Assets.addMANABMP = fontGenerator.generateFont(fontParameter);
		Assets.addMAGICBMP = fontGenerator.generateFont(fontParameter);

		leftBitMapFont = fontGenerator.generateFont(fontParameter);
		bottomBitMapFont = fontGenerator.generateFont(fontParameter);
		topTextBitmap = fontGenerator.generateFont(fontParameter);
		playerAttackFont = fontGenerator.generateFont(fontParameter);
		enemyAttackFont = fontGenerator.generateFont(fontParameter);
		mobSpellBitmap = fontGenerator.generateFont(fontParameter);
		leftBitMapFont.getData().setScale(2);
		bottomBitMapFont.getData().setScale(1.5F);
		enemyAttackFont.getData().setScale(2);
		playerAttackFont.getData().setScale(2);
		topTextBitmap.getData().setScale((float) 2.2);
		topText = "1. zaatakuj, 2. użyj czaru, 3. użyj czaru";

		fight = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		};
		attackText = new TextField();
		attackText.setText("Siema");


		fight.actionPerformed(fightEvent);
		attackText.addActionListener(fight);

		battle = new Event();
		actor = new Actor();

		 stage = new Stage();
		 stage.draw();
		 stage.addActor(actor);

		camera = new OrthographicCamera(1920, 1080);
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		spiderTexture = new Texture("spider.png");
		spiderSprite = new Sprite(spiderTexture);
		spiderSprite.setSize(650,500);
		shopTxt = new Texture("shop.png");
		shopSprite = new Sprite(shopTxt);
		shopSprite.setSize(1920,1080);
		goblinTxt = new Texture("goblin.png");
		goblinSprite = new Sprite(goblinTxt);
		goblinSprite.setSize(650,500);
		skeletonTxt = new Texture("skeleton.png");
		skeletonSprite = new Sprite(skeletonTxt);
		skeletonSprite.setSize(650,500);
		texture = new Texture(Gdx.files.internal("mutant.png"));
		sprite = new Sprite(texture);

		inventoryTX = new Texture("Inventory.png");
		inventorySP = new Sprite(inventoryTX);
		inventorySP.setPosition((w / 2 - sprite.getWidth() / 2) - 300, h / 2 - sprite.getHeight() / 2);
		mapTexture = new Texture("mymap.png");
		mapSprite = new Sprite(mapTexture);

		forestTexture = new Texture(Gdx.files.internal("forest.jpg"));
		forestSprite = new Sprite(forestTexture);
		forestSprite.setPosition(w / 2 - sprite.getWidth() / 2, h / 2 - sprite.getHeight() / 2);
		sprite.setSize(120, 150);
		forestSprite.setSize(700, 500);
		forestSprite.setPosition(forestSprite.getX() - 320, forestSprite.getY() - 230);
		sprite.setPosition(sprite.getX(), sprite.getY() - 200);
		inventorySP.setSize(600, 200);
		playerTexture = new Texture(Gdx.files.internal("player.png"));
		playerSprite = new Sprite(playerTexture);
		playerSprite.setPosition((w / 2 - sprite.getWidth() / 2) + 800, (h / 2 - sprite.getHeight() / 2) + 800);

		playerSprite.setSize(120, 140);
		spiderSprite.setPosition(playerSprite.getX() + 100, playerSprite.getY());

		sprite.setPosition(playerSprite.getX() + 100,playerSprite.getY());
		attackText.setLocation((int) (playerSprite.getX() - 100), (int) (playerSprite.getY() + 200));
		stats = new TextField("Zadałeś 100 obrażeń!");
		stats.setLocation((int) playerSprite.getX(), (int) playerSprite.getY());
	font = new BitmapFont();
		mapSprite.setPosition(playerSprite.getX() - 2040, playerSprite.getY() - 1730);
		mapSprite.setSize(7680, 4320);
		Dawid = new Player(100000, 100000, 100, 0, 0, 4, 4, 0, 0, 0, 0);
		Dawid.setFloor(1);
		Dawid.setClassNumber(1);
		Dawid.setMana(100);
		fightscreenTX = new Texture("battlescreen.png");
		fightscreenSP = new Sprite(fightscreenTX);
		fightscreenSP.setPosition(10000, 10000);
		fightscreenSP.setSize(1920,1080);
		levelUpSprite.setPosition(playerSprite.getX()-300,playerSprite.getY() - 200);
		levelUpSprite.setSize(0,0);
		camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
		camera.update();
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}


	@Override
	public void render() {

		Gdx.gl.glClearColor(1, 1, 1, 1);

		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {

			sprite.setX(sprite.getX() - 60);
			Dawid.setX(Dawid.getX() - 1);


		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {

			sprite.setX(sprite.getX() + 60);
			Dawid.setX(Dawid.getX() + 1);
			camera.position.set(sprite.getX(), sprite.getY(), 0);
			camera.update();


		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {

			sprite.setY(sprite.getY() + 60);
			Dawid.setY(Dawid.getY() + 1);
			camera.position.set(sprite.getX(), sprite.getY(), 0);
			camera.update();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {

			sprite.setY(sprite.getY() - 60);
			Dawid.setY(Dawid.getY() - 1);
			camera.position.set(sprite.getX(), sprite.getY(), 0);
			camera.update();


		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.W) && Dawid.getY() < borderY && fightstart == 0) {
			playerSprite.setY(playerSprite.getY() + 229);
			if (Dawid.getY() < borderY) {
				Dawid.setY(Dawid.getY() + 1);
				System.out.println("Ruszyłeś się");
				checkSuccesful = 1;
			} else if (Dawid.getY() >= borderY) {
				System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
			}

			camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
			camera.update();
			Experience.expCounter(Dawid);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.S) && Dawid.getY() > 1 && fightstart == 0) {
			playerSprite.setY(playerSprite.getY() - 229);
			if (Dawid.getY() > 1) {
				Dawid.setY(Dawid.getY() - 1);
				System.out.println("Ruszyłeś się");
			} else {
				System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
			}
			camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
			camera.update();
			Experience.expCounter(Dawid);
		}

		Experience.expCounter(Dawid);
		if (Gdx.input.isKeyJustPressed(Input.Keys.D) && Dawid.getX() < borderX && fightstart == 0) {
			playerSprite.setX(playerSprite.getX() + 261);
			if (Dawid.getX() < borderX) {
				Dawid.setX(Dawid.getX() + 1);
				System.out.println("Ruszyłeś się");
			} else if (Dawid.getX() >= borderX) {
				System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
			}
			camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
			camera.update();
			Experience.expCounter(Dawid);

		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.A) && Dawid.getX() > 1 && fightstart == 0) {
			playerSprite.setX(playerSprite.getX() - 261);
			if (Dawid.getX() > 1) {
				Dawid.setX(Dawid.getX() - 1);
				System.out.println("Ruszyłeś się");
			} else {
				System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
			}
			camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
			camera.update();
			Experience.expCounter(Dawid);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
			Dawid.Attack(monsterBase[1], Dawid);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			/*GameInterface.showSteering();*/
		}
		batch.setProjectionMatrix(camera.combined);

		try {
			MoveConclude();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.P)){
			if (statsscreen == 0){
				statsscreen = 1;
			}
			else if (statsscreen == 1){
				statsscreen = 0;
			}
		}
		if (statsscreen == 1){
			Assets.addAttributeSPR.setSize(300,600);

			Assets.addATTACKTEXT = "ATAK     (" + Dawid.getDMG() +")      + 5";
			Assets.addHPTEXT = "HP     (" + Dawid.getHP() +")      + 5";
			Assets.addCRITTEXT = "CRIT       (" + Dawid.getCritChance() +")      + 5";
			Assets.addMAGICTEXT ="MAGIA      (" + Dawid.getMagic() +")      + 5";
			Assets.addMANATEXT = "MANA     (" + Dawid.getMana() +")     + 5";
		}
		else if (statsscreen == 0) {
			Assets.addATTACKTEXT = " ";
			Assets.addHPTEXT = " ";
			Assets.addCRITTEXT = " ";
			Assets.addMAGICTEXT =" ";
			Assets.addMANATEXT = " ";
			Assets.addAttributeSPR.setSize(0, 0);
		}



		/*try {
			checker(Dawid,spider);
			checker(Dawid,mutant);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}*/
		/*Gdx.input.setInputProcessor() {


										public boolean touchUp(int screenX, int screenY, int pointer, int button) {

											return false;
										}

										public boolean touchDown(int x, int yy, int pointer, int button) {
											int y = Gdx.graphics.getHeight() - yy;
											// if sprite + 10 of px marge is touched
											if(Assets.attackSpr.isPressing(10, x, y)) {
												// sprite is touched down
											}
											return false;
										}
									}*/
		Experience.expCounter(Dawid);
		experienceCheck();
		cursor.setBounds(Gdx.input.getX(),Gdx.input.getY(), 10, 10);
showXP(Dawid);
		batch.begin();
		mapSprite.draw(batch);
		Assets.attackSpr.setPosition(playerSprite.getX() - 600, playerSprite.getY() - 250);
		Assets.runSpr.setPosition(playerSprite.getX() - 300, playerSprite.getY() - 250);
		buttonBounds.setBounds((int) (playerSprite.getX() + 300), (int) (playerSprite.getY() - 250), 6000, 6000);



		fightscreenSP.draw(batch);

inventorySP.setPosition(playerSprite.getX(), playerSprite.getY()+100);
		playerSprite.draw(batch);

addStats();



		levelUpSprite.setPosition(playerSprite.getX()-400,playerSprite.getY()-200);
		sprite.draw(batch);
		playerAttackFont.draw(batch, playerAttackText, playerSprite.getX()- 500, playerSprite.getY() + 100);
		enemyAttackFont.draw(batch,enemyAttackText, playerSprite.getX(), playerSprite.getY() + 150);
		topTextBitmap.draw(batch, topText, playerSprite.getX()- 300, playerSprite.getY() + 420);
		mobSpellBitmap.draw(batch,mobSpellText, playerSprite.getX(), playerSprite.getY() + 100);
		bottomBitMapFont.draw(batch,bottomText,playerSprite.getX()- 400,playerSprite.getY() - 400);
		leftBitMapFont.draw(batch,leftText, playerSprite.getX()- 900,playerSprite.getY() + 100);

		levelUpSprite.draw(batch);
		iceBoltSPR.draw(batch);
		fireBallSPR.draw(batch);
		adrenalineSPR.draw(batch);
		ironskinSPR.draw(batch);
		getIceBoltSPR2.draw(batch);
		fireBallSPR2.draw(batch);
		getAdrenalineSPR2.draw(batch);
		ironskinSPR2.draw(batch);
        healSPR2.draw(batch);
cleaveSPR2.draw(batch);

Assets.addAttributeSPR.draw(batch);

Assets.addAttributeSPR.setPosition(playerSprite.getX()+ 300,playerSprite.getY() - 300);
		Assets.addHP.setPosition(playerSprite.getX() + 520,playerSprite.getY()+100);
		Assets.addDMG.setPosition(playerSprite.getX() + 520,playerSprite.getY()+200);
		Assets.addMANA.setPosition(playerSprite.getX() + 520,playerSprite.getY()-200);
		Assets.addMAGIC.setPosition(playerSprite.getX() + 520,playerSprite.getY());
		Assets.addCRIT.setPosition(playerSprite.getX() + 520,playerSprite.getY()-100);
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

		Assets.dualWieldSPR.draw(batch);
		Assets.iceSpr.draw(batch);
		Assets.attackSpr.draw(batch);
		Assets.runSpr.draw(batch);


		if (Gdx.input.isKeyPressed(Input.Keys.B)) {

			/*for (int i = 0; i < 50; i++) {
				try {
					inventoryScreen[i].setText((i) + ". " + eqNumber[i].getShortName() + " (" + eqNumber[i].getHP() + " HP, "
							+ eqNumber[i].getDMG() + " DMG, " + eqNumber[i].getCrit() + "Crit, " + eqNumber[i].getMagic()
							+ " Mocy zaklęć) ");
					inventoryScreenBitMap[i].draw((Batch) batch, (CharSequence) inventoryScreen[i], playerSprite.getX() - 200, playerSprite.getY() + 100);
					inventoryScreenBitMap[i].getData().setScale(3);
					if (eqNumber[i].getEqValue() > 0) {
						System.out.println("(Założony)");
					}
				} catch (NullPointerException a) {
				}
			}*/


			inventorySP.draw(batch);



		}




		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			playerInfo = "Punkty zdrowia: " + Dawid.getHP() + "/" + Dawid.getMaxHP() + "         Mana: " +Dawid.getMana() +
					"\n Doświadczenie: " + Dawid.getXP() + "/" + levelCap + "         Poziom: " + Dawid.getLevel() +
					"\n Punkty obrażeń: " + Dawid.getDMG();
			playerInfoBitMap.draw(batch, playerInfo, playerSprite.getX(), playerSprite.getY());


		}

		batch.end();

	}

	public static void showXP(Player gracz){
		if (Dawid.getLevel() == 0) {
			levelCap = 40;
		}
		if (Dawid.getLevel() == 1) {
			levelCap = 100;
		}
		if (Dawid.getLevel() == 2) {
			levelCap = 250;
		}
		if (Dawid.getLevel() == 3) {
			levelCap = 400;
		}
		if (Dawid.getLevel() == 4) {
			levelCap = 700;
		}
		if (Dawid.getLevel() == 5) {
			levelCap = 1100;
		}
	}

	public static void showLevel(Player gracz){

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

	public void createBackEnd(){
		Assets.addATTACKTEXT = " ";
		Assets.addHPTEXT = " ";
		Assets.addCRITTEXT = " ";
		Assets.addMAGICTEXT =" ";
		Assets.addMANATEXT = " ";
Assets.PLUS = new Texture("plus.png");
Assets.addDMG = new SpriteTouchable(Assets.PLUS);
		Assets.addCRIT = new SpriteTouchable(Assets.PLUS);
		Assets.addHP = new SpriteTouchable(Assets.PLUS);
		Assets.addMAGIC = new SpriteTouchable(Assets.PLUS);
		Assets.addMANA = new SpriteTouchable(Assets.PLUS);
		Assets.cleaveTXT = new Texture("cleavebutton.png");
		Assets.cleaveSPR = new SpriteTouchable(Assets.cleaveTXT);
		Assets.dualWieldTXT = new Texture("duealwieldbutton.png");
		Assets.dualWieldSPR = new SpriteTouchable(Assets.dualWieldTXT);
		healTXT = new Texture("healbutton.png");
		Assets.healSPR = new SpriteTouchable(healTXT);
Assets.attackTxt = new Texture("attackbutton.png");
Assets.attackSpr = new SpriteTouchable(Assets.attackTxt);
		Assets.runTxt = new Texture("runbutton.png");
		Assets.runSpr = new Sprite(Assets.runTxt);
		Assets.iceTxt = new Texture("iceboltbutton.png");
		Assets.iceSpr = new Sprite(Assets.iceTxt);
		Assets.addMANA.setSize(0,0);
		Assets.addDMG.setSize(0,0);
		Assets.addCRIT.setSize(0,0);
		Assets.addHP.setSize(0,0);
		Assets.addMAGIC.setSize(0,0);

		iceBoltTXT = new Texture("iceboltbutt.png");
		iceBoltSPR = new SpriteTouchable(iceBoltTXT);
		fireBallTXT = new Texture("fireballbutt.png");
		fireBallSPR= new SpriteTouchable(fireBallTXT);
		adrenalineTXT = new Texture("adrenalinebutt.png");
		adrenalineSPR = new SpriteTouchable(adrenalineTXT);
		ironskinTXT = new Texture("ironskinbutton.png");
		ironskinSPR = new SpriteTouchable(ironskinTXT);

		Assets.iceSpr.setSize(0,0);
		adrenalineSPR.setSize(0,0);
		Assets.runSpr.setSize(0,0);
		Assets.attackSpr.setSize(0,0);



		int weaponEQ = 0;
		int neckEQ = 0;
		int handsEQ = 0;
		int chestEQ = 0;
		Dawid.setEscapeInvulnerability(0);
		int reminder = 0;
		eqNumber[30] = new Weapon("Zardzewiały miecz", 0, 60, 5, 0, 1,1,1);
		Inventory.equippedweapon = (Weapon) eqNumber[30];
		eqNumber[30].eqON(Dawid);

		Monster.weaponEQ++;
		eqNumber[30].setIsON(1);
		int discoverForest = 0;
		int discoverCamp = 0;
		int discoverLadder = 0;



		eqNumber[31] = new Weapon("Laska nowicjusza", 0, 10, 10, 60, 2, 0, 1);
		Shop shop = new Shop(3, 4);
		shop.setFloor(1);
		try {
			createLadder(1);
		}
		catch (NullPointerException a){

		}
		createLadder(2);
		createLadder(3);
		createLadder(4);
		createLadder(5);
		createLadder(6);
		spawn(27, monsterBase);
		SpawnFloor2.SPAWN(27,monsterBase2);
		SpawnFloor3.SPAWN(27, monsterBase3);
		SpawnFloor4.SPAWN(27, monsterBase3);
		SpawnFloor5.SPAWN(27, monsterBase3);
		SpawnFloor6.SPAWN(27, monsterBase3);
		Forest.SPAWN(27, forestBase);
		BanditCamp.SPAWN(27, monsterBase3);
	}
	public void MoveConclude() throws InterruptedException {

		LadderCheckDOWN(ladderDOWNS[1], Dawid);
		LadderCheckUP(ladderUPS[1], Dawid);
		LadderCheckDOWN(ladderDOWNS[2], Dawid);
		LadderCheckUP(ladderUPS[2], Dawid);
		LadderCheckDOWN(ladderDOWNS[3], Dawid);
		LadderCheckUP(ladderUPS[3], Dawid);
		LadderCheckDOWN(ladderDOWNS[4], Dawid);
		LadderCheckUP(ladderUPS[4], Dawid);
		LadderCheckDOWN(ladderDOWNS[5], Dawid);
		LadderCheckUP(ladderUPS[5], Dawid);
		/*checker(Dawid, mutant);*/
		if (Dawid.getEscapeInvulnerability() < 1) {


			for (int icheck = 1; icheck < 27; icheck++) {

					checker(Dawid, monsterBase[icheck]);
					checker(Dawid, monsterBase2[icheck]);
					checker(Dawid, monsterBase3[icheck]);
					checker(Dawid, monsterBase4[icheck]);
					checker(Dawid, monsterBase5[icheck]);
					checker(Dawid, monsterBase6[icheck]);
					checker(Dawid, forestBase[icheck]);
					checker(Dawid, banditCampBase[icheck]);
					if (checkSuccesful > 0) {
						checkSuccesful = 0;
						break;
					}

			}
		}


	}
	public static void checker(Player player, Monster monster) throws InterruptedException {


		try {

			if (player.getX() == monster.getX() && player.getY() == monster.getY() && player.getFloor() == monster.getFloor() && monster.getHp() > 0) {
               fightON = 1;
               fightstart = 1;
				topText = "Walcz!";
				leftText = " ";

				Assets.attackSpr.setSize(200,80);
				Assets.runSpr.setSize(200,80);
				fightscreenSP.setPosition(playerSprite.getX() - 960, playerSprite.getY() - 540);
				fightscreenSP.setSize(1920,1080);
				sprite.setPosition(fightscreenSP.getX()+ 1000, fightscreenSP.getY() + 360);
				sprite.setSize(200,200);
				checkSuccesful = 1;
				if (fightON == 1) {
					Fight.Turn(Dawid, monster);
				}

			}
			else {
				fightON = 0;
			}
		} catch (NullPointerException a) {

		}
		batch.begin();
		playerSprite.draw(batch);
batch.end();
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
	public void spawn(int mobsNumber, Monster[] monsterBase) {

		Random random = new Random();

		for (int i = 0; i < mobsNumber; i++) {
			double valueX = random.nextInt(8) + 1;
			double valueY = random.nextInt(8) + 1;


			checkme[i] = (valueX * 100 + valueY);
			//
			// Potwory nie pojawią się na polach 2,5 -- 5,5 i tak dalej, żeby gracz miał trochę swojego miejsca
			//
			double mobType = random.nextInt(100);
			int valid = 0;

			for (int j = 0; j < i; j++) {

				if (checkme[i] == checkme[j]) {
					valid = 1;
					break;
				} else {

				}

			}
			if ((valueX > 5 || valueX < 3) || (valueY > 5 || valueY < 3)) {
				if (valid < 1) {
					spawnedMonsters++;
					if (mobType < 21) {
						monsterBase[i] = new Goblin(120, 50, valueX, valueY, "goblin", 40, 10, 2, 1);
					} else if (mobType < 41 && mobType > 20) {
						monsterBase[i] = new Spider(130, 40, valueX, valueY, "pająk", 20, 1, 1);
					}
					//
					//        Tu ustawiasz szansę na pojawienie się danego typu przeciwnika
					//
					else if (mobType < 61 && mobType > 40) {
						monsterBase[i] = new Werewolf(200, 70, valueX, valueY, "wilkołak", 60, 20, 4, 1);
					} else if (mobType < 81 && mobType > 60) {
						monsterBase[i] = new Vampire(210, 70, valueX, valueY, "wampir", 70, 14, 3, 1);
					} else if (mobType > 80) {
						monsterBase[i] = new Mutant(250, 80, valueX, valueY, "mutant", 120, 50, 5, 1);
					}
					int emptyslots = mobsNumber;


					//
					// Jakbyś testował spawner to włącz sobie poniższe printy,
					// wyświetlą info o każdym wygenerowanym potworku
					//
                   /* System.out.println(monsterBase[i].getHp());
                    System.out.println(monsterBase[i].getDmg());
                    System.out.println("Rodzaj potwora: ");
                    System.out.println(monsterBase[i].getName());
                    System.out.println("Koordy:");
                    System.out.println(monsterBase[i].getX());
                    System.out.println(monsterBase[i].getY());
                    System.out.println("Piętro: " + monsterBase[i].getFloor());
                    System.out.println();
                    System.out.println(spawnedMonsters);*/

				} else {

					i = i - 1;
				}
			} else {

				i = i - 1;
			}
		}
	}
	   public void Battle(Player player, Monster monster) throws InterruptedException {



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
		   if (currentTarget != null) {
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


			   if (Gdx.input.isKeyJustPressed(Input.Keys.A) && fightstart == 1) {

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
			   if (Gdx.input.isKeyJustPressed(Input.Keys.I) && fightstart == 1) {

				   if (player.getIronSkinValue() == 0) {
					   player.IronSkin(player);
					   player.setIronSkinValue(1);
					   ironSkinDuration = 3;
				   } else {
					   player.Attack(monster, player);
				   }
				   EnemyAttack(player, monster);

			   }
			   if (Gdx.input.isKeyJustPressed(Input.Keys.X) && fightstart == 1) {
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


				   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1) && fightstart == 1) {

					   if (player.getFreeze() < 1) {
						   player.Attack(monster, player);
					   } else if (player.getFreeze() > 0) {
						   System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
						   player.setFreeze(player.getFreeze() - 1);
					   }
					   EnemyAttack(player, monster);
				   }


				   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2) && fightstart == 1) {
					   if (player.getFreeze() < 1) {
						   player.Attack(GameLogic.monsterBase[joined], player);
					   } else if (player.getFreeze() > 0) {
						   System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
						   player.setFreeze(player.getFreeze() - 1);
					   }
					   EnemyAttack(player, monster);
				   }

			   }


			   if (Gdx.input.isKeyJustPressed(Input.Keys.B) && fightstart == 1) {
				   System.out.println("Udało Ci się uciec, Twoje koordynaty to: X: " + player.getX() + ", Y: " + player.getY());

				   escape = 1;
				   player.setEscapeInvulnerability(1);
				   doubleStrike = 0;

			   }

			   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_0) && fightstart == 1) {
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

			   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3) && fightstart == 1) {
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
				   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4) && fightstart == 1) {
					   if (player.getChosenSkill1() == Player.FIREBALL || player.getChosenSkill2() == Player.FIREBALL
							   || player.getChosenSkill3() == Player.FIREBALL || player.getChosenSkill4() == Player.FIREBALL || player.getChosenSkill5() ==
							   Player.FIREBALL || player.getChosenSkill6() == Player.FIREBALL || player.getChosenSkill7() == Player.FIREBALL
							   || player.getChosenSkill8() == Player.FIREBALL || player.getChosenSkill9() == Player.FIREBALL || player.getChosenSkill10() == Player.FIREBALL) {
						   if (doubleStrike == 1) {
							   FightLogic.WhoDoYouWantToAttack(monster);

							   if (Gdx.input.isKeyJustPressed(Input.Keys.A) && fightstart == 1) {

								   player.Fireball(monster, player);
							   }
							   if (Gdx.input.isKeyJustPressed(Input.Keys.V) && fightstart == 1) {
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

	   public static void addStats(){
		if (fightstart == 0){
			cleaveSPR2.setSize(0,0);
			getAdrenalineSPR2.setSize(0,0);
			ironskinSPR2.setSize(0,0);
			healSPR2.setSize(0,0);
			getIceBoltSPR2.setSize(0,0);
			fireBallSPR2.setSize(0,0);
		}

		if (Dawid.getAttributePoints() > 0){
			Assets.addATTACKTEXT = "ATAK     (" + Dawid.getDMG() +")      + 5";
			Assets.addHPTEXT = "HP     (" + Dawid.getHP() +")      + 5";
			Assets.addCRITTEXT = "CRIT       (" + Dawid.getCritChance() +")      + 5";
			Assets.addMAGICTEXT ="MAGIA      (" + Dawid.getMagic() +")      + 5";
			Assets.addMANATEXT = "MANA REGEN  (" + Dawid.getManaRegen() +")     + 5";
Assets.addAttributeSPR.setSize(300,600);
			Assets.addMAGIC.setSize(50,50);

			Assets.addHP.setSize(50,50);

			Assets.addDMG.setSize(50,50);

			Assets.addCRIT.setSize(50,50);

			Assets.addMANA.setSize(50,50);

		}
		else  {

			Assets.addMANA.setSize(0,0);
			Assets.addDMG.setSize(0,0);
			Assets.addCRIT.setSize(0,0);
			Assets.addHP.setSize(0,0);
			Assets.addMAGIC.setSize(0,0);

		}
		   if(Gdx.input.justTouched())

		   {
			   //unprojects the camera
			   camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			   if (Assets.addDMG.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
				   Dawid.setDMG(Dawid.getDMG() + 1);
				   Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);


			   }
		   }
		   if(Gdx.input.justTouched())

		   {
			   //unprojects the camera
			   camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			   if (Assets.addHP.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
				   Dawid.setMaxHP(Dawid.getMaxHP() + 6);
				   Dawid.setHP(Dawid.getHP() + 6);
				   Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
			   }
		   }
		   if(Gdx.input.justTouched())

		   {
			   //unprojects the camera
			   camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			   if (Assets.addCRIT.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
				   Dawid.setCritChance(Dawid.getCritChance() + 0.5);
				   Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
			   }
		   }
		   if(Gdx.input.justTouched())

		   {
			   //unprojects the camera
			   camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			   if (Assets.addMAGIC.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
				   Dawid.setMagic(Dawid.getMagic() + 5);
				   Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
			   }
		   }
		   if(Gdx.input.justTouched())

		   {
			   //unprojects the camera
			   camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			   if (Assets.addMANA.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)) {
				   Dawid.setManaRegen(Dawid.getManaRegen() + 0.5);
				   Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
			   }
		   }
	   }

}