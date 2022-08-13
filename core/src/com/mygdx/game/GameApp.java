package com.mygdx.game;

import Data.Areas.BanditCamp;
import Data.Areas.Forest;
import Data.Quests;
import Logic.Experience;
import Logic.FightLogic.Fight;
import Logic.FightLogic.FightLogic;
import Logic.GameLogic;
import Logic.Inventory;
import Logic.Spawners.*;
import Logic.Test;
import Mobs.*;
import Objects.Armor;
import Objects.Items.Chests.ChestArmor;
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
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import lombok.SneakyThrows;

import java.lang.annotation.Target;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import static Logic.FightLogic.Fight.*;
import static Mobs.Monster.eqNumber;

public class GameApp extends ApplicationAdapter {
	static int checkSuccesful = 0;

	int toxic = 0;


	int borderX = 16;
	int borderY = 16;
	static int ladderCheckUPSuccessful = 0;
	static int ladderCheckDOWNSuccessful = 0;

	Scanner scanner = new Scanner(System.in);
	public static Monster[] monsterBase = new Monster[50];
	public static Monster[] forestBase = new Monster[50];
	static Monster[] monsterBase2 = new Monster[50];
	static Monster[] monsterBase3 = new Monster[50];

	public static Item[] equipment = new Item[100];

	static Monster[] monsterBase4 = new Monster[50];

	static Monster[] monsterBase5 = new Monster[50];

	static Monster[] monsterBase6 = new Monster[50];

	static Ladder[] ladders = new Ladder[10];

	static Monster[] banditCampBase = new Monster[50];

	static int[] ladX = new int[10];

	static int[] ladY = new int[10];

	static LadderDOWN[] ladderDOWNS = new LadderDOWN[10];

	static LadderUP[] ladderUPS = new LadderUP[10];

	double[] field = new double[100];
	public static int spawnedMonsters = 1;
	int spawnedMonstersFloor2 = 1;

	double checkme[] = new double[500];
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
	private static SpriteBatch batch;
	private static Texture texture;
	private static Sprite sprite;
	private static Texture forestTexture;
	private static Sprite forestSprite;
	public static Texture playerTexture;
	public static Sprite playerSprite;

	private static Camera camera;

	private static Screen screen;
	private static Target target;
	private static Vector3 vector;
	private static Shop shop;
	private static Minotaur minotaur;
	private static Texture mapTexture;
	private static Sprite mapSprite;
	private static Player Dawid;
	private static Texture inventoryTX;
	private static Sprite inventorySP;

	private static Texture fightscreenTX;
	private static Sprite fightscreenSP;
	private static int fightstart = 0;

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



	public void Game() throws InterruptedException {
		/*  Monster[] monsterBase = new Monster[100];*/
		final String SETTINGS = "9";
		final String INFO = "8";

		//
		// Podstawowe potwory są wyłączone bo generują się automatycznie
		//

		Random random = new Random();
		String input;
		String exit = "0";
		do {
			input = scanner.nextLine().toUpperCase();
			switch (input) {

				case "HEAL":
					double healvalue = 200;
					Dawid.setHP(Dawid.getHP() + healvalue);
					double overHeal = (Dawid.getHP() - Dawid.getMaxHP());
					if (overHeal >= 0) {
						Dawid.setHP(Dawid.getHP() - overHeal);
					}
					System.out.println("Uleczyłeś się za " + (healvalue - overHeal) + " punktów życia");
					break;
				case "TOWN":
					if (Dawid.getX() < 6 && Dawid.getX() > 2 && Dawid.getY() < 6 && Dawid.getY() > 2) {
						System.out.println("Gdzie chcesz pójść?");
						System.out.println("Kowal");
						System.out.println("Ratusz");
						String input2 = scanner.nextLine().toUpperCase();
						switch (input2) {
							case "KOWAL":
								Quests.QuestConvo(Dawid);
								break;
							case "RATUSZ":
								Quests.Quest2Convo(Dawid);
								break;
						}
					}
					break;
				case "PATCH":
					break;
				case "DMG":
					System.out.println(Dawid.getDMG());
					break;
				case "XP":
					System.out.println(Dawid.getXP());
					break;
				case "TP":
					if (Dawid.getChosenSkill1() == Player.TP || Dawid.getChosenSkill2() == Player.TP ||
							Dawid.getChosenSkill3() == Player.TP || Dawid.getChosenSkill4() == Player.TP ||
							Dawid.getChosenSkill5() == Player.TP) {
						System.out.println("Użyłeś teleportacji!");
						Dawid.Teleport(Dawid);
					} else {
						System.out.println("Nie posiadasz tej umiejętności");
					}
					break;


				case "LVLUP":

					String attributes = "1";
					do {

						System.out.println("Masz " + Dawid.getAttributePoints() + " punktów umiejętności");
						System.out.println("Wybierz którą statystykę chcesz podnieść: ");
						System.out.println("1. Atak (+1)");
						System.out.println("2. Moc zaklęć (+5)");
						System.out.println("3. Punkty życia (+6)");
						System.out.println("4. Szansa na cios krytyczny (+0,5%)");
						System.out.println("5. Regeneracja many (+0,5 na turę)");
						System.out.println("0. Wyjdź");

						attributes = scanner.nextLine();
						switch (attributes) {
							case "1":
								if (Dawid.getAttributePoints() > 0) {
									Dawid.setDMG(Dawid.getDMG() + 1);
									Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
								} else {
									System.out.println("Nie masz już punktów umiejętności");
								}
								break;
							case "2":
								if (Dawid.getAttributePoints() > 0) {
									Dawid.setMagic(Dawid.getMagic() + 5);
									Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
								} else {
									System.out.println("Nie masz już punktów umiejętności");
								}
								break;
							case "3":
								if (Dawid.getAttributePoints() > 0) {
									Dawid.setMaxHP(Dawid.getMaxHP() + 6);
									Dawid.setHP(Dawid.getHP() + 6);
									Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
								} else {
									System.out.println("Nie masz już punktów umiejętności");
								}
								break;
							case "4":
								if (Dawid.getAttributePoints() > 0) {
									Dawid.setCritChance(Dawid.getCritChance() + 0.5);
									Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
								} else {
									System.out.println("Nie masz już punktów umiejętności");
								}
								break;
							case "5":
								if (Dawid.getAttributePoints() > 0) {
									Dawid.setManaRegen(Dawid.getManaRegen() + 0.5);
									Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
								} else {
									System.out.println("Nie masz już punktów umiejętności");
								}
								break;
							case "0":
								attributes = "0";
								break;
							default:
								attributes = "0";
						}


					}
					while (attributes != "0");


					break;


				case "EQ":
					System.out.println("Twoje przedmioty: ");
					System.out.println("Naciśnij numer przedmiotu aby go założyć lub zdjąć, wpisz OFF aby zdjąć wszystkie" +
							" przedmioty lub 0 aby wyjść z ekwipunku");
					for (int i = 0; i < 50; i++) {
						try {
							System.out.println((i) + ". " + eqNumber[i].getShortName() + " (" + eqNumber[i].getHP() + " HP, "
									+ eqNumber[i].getDMG() + " DMG, " + eqNumber[i].getCrit() + "Crit, " + eqNumber[i].getMagic()
									+ " Mocy zaklęć) ");
							if (eqNumber[i].getEqValue() > 0) {
								System.out.println("(Założony)");
							}
						} catch (NullPointerException a) {
						}
					}
					Inventory.INVENTORY(Dawid);


				case SETTINGS:
					System.out.println("W: góra, S: dół, A: lewo, D: prawo,");
					break;
				case INFO:
					Test.PlayerInfo(Dawid);
					break;
				case "EXIT":
					input = exit;
					break;
				case "GIVEITEMS":


					break;
				case "MAP":
					System.out.println("Sklep: X:" + shop.getX() + ", Y:" + shop.getY());
					System.out.println("Drabina piętro 1: X:" + ladderDOWNS[1].getX() + " Y:" + ladderDOWNS[1].getY());
					/*if (discoverForest == 1) {
						System.out.println("Las: X: 1-8, Y: 8-16");
					}
					if (discoverCamp == 1) {
						System.out.println("Obóz bandytów: X: 9-15, Y: 1-8");
					}*/
					break;
				case "ABCDE":
					Dawid.setHP(10000);
					Dawid.setDMG(10000);
					Dawid.setMaxHP(10000);


					Dawid.setChosenSkill1(Player.ICE);
					Dawid.setChosenSkill2(Player.FIREBALL);
					Dawid.setChosenSkill3(Player.TP);

					break;

				case "MOREEXP":
					Dawid.setXP(Dawid.getXP() + 100);
					System.out.println("Dodałeś 100 expa, teraz masz " + Dawid.getXP());
					break;
			}

			Dawid.setEscapeInvulnerability(0);
			if (Dawid.getY() == 3 && Dawid.getX() == 5) {
				Armor.pickArmor(Dawid);
			}
			if (Dawid.getHP() > 0) {
				Experience.expCounter(Dawid);
			}
			if (Dawid.getHP() < 1) {
				System.out.println("Odrodziłeś się w mieście, niestety utraciłeś całe doświadczenie zdobyte w walce");
				Dawid.setXP(0);
				Dawid.setX(4);
				Dawid.setY(4);
				Dawid.setHP(Dawid.getMaxHP());
				/*input = exit;*/
			}
		}
		while (!input.equals(exit));
		scanner.close();
	}

private Stage stage;
private Actor actor;
private Event battle;

	@Override
	public void create() {
		battle = new Event();
		actor = new Actor();
		createBackEnd();
		 stage = new Stage();
		 stage.draw();
		 stage.addActor(actor);

		camera = new OrthographicCamera(1280, 720);
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("mutant.png"));
		sprite = new Sprite(texture);
		sprite.setPosition(w / 2 - sprite.getWidth() / 2, h / 2 - sprite.getHeight() / 2);
		inventoryTX = new Texture("Inventory.png");
		inventorySP = new Sprite(inventoryTX);
		inventorySP.setPosition((w / 2 - sprite.getWidth() / 2) - 300, h / 2 - sprite.getHeight() / 2);
		mapTexture = new Texture("map.jpg");
		mapSprite = new Sprite(mapTexture);
		mapSprite.setPosition(w / 2 - mapSprite.getWidth() / 2, (h / 2 - mapSprite.getHeight() / 2) - 30);
		forestTexture = new Texture(Gdx.files.internal("forest.jpg"));
		forestSprite = new Sprite(forestTexture);
		forestSprite.setPosition(w / 2 - sprite.getWidth() / 2, h / 2 - sprite.getHeight() / 2);
		sprite.setSize(50, 80);
		forestSprite.setSize(700, 500);
		forestSprite.setPosition(forestSprite.getX() - 320, forestSprite.getY() - 230);
		sprite.setPosition(sprite.getX(), sprite.getY() - 200);
		inventorySP.setSize(600, 200);
		playerTexture = new Texture(Gdx.files.internal("player.png"));
		playerSprite = new Sprite(playerTexture);
		playerSprite.setPosition((w / 2 - sprite.getWidth() / 2) + 800, (h / 2 - sprite.getHeight() / 2) + 800);
		playerSprite.setSize(50, 80);
		mapSprite.setSize(mapSprite.getWidth() * 3, (mapSprite.getHeight() + 70) * 3);
		Dawid = new Player(300, 300, 60, 0, 1, 4, 4, 0, 0, 0, 0);
		Dawid.setFloor(1);
		Dawid.setClassNumber(1);
		Dawid.setMana(100);
		fightscreenTX = new Texture("battlescreen.png");
		fightscreenSP = new Sprite(fightscreenTX);
		fightscreenSP.setPosition(10000, 10000);
		fightscreenSP.setSize(1280,720);
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
		if (Gdx.input.isKeyJustPressed(Input.Keys.W) && Dawid.getY() < borderY && checkSuccesful == 0) {
			playerSprite.setY(playerSprite.getY() + 60);
			if (Dawid.getY() < borderY) {
				Dawid.setY(Dawid.getY() + 1);
			} else if (Dawid.getY() >= borderY) {
				System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
			}
			try {
				Battle(Dawid, monsterBase[1]);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
			camera.update();
			try {
				MoveConclude();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.S) && Dawid.getY() > 1 && checkSuccesful == 0) {
			playerSprite.setY(playerSprite.getY() - 60);
			if (Dawid.getY() > 1) {
				Dawid.setY(Dawid.getY() - 1);
			} else {
				System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
			}
			camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
			camera.update();
			try {
				MoveConclude();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.D) && Dawid.getX() < borderX && checkSuccesful == 0) {
			playerSprite.setX(playerSprite.getX() + 60);
			if (Dawid.getX() < borderX) {
				Dawid.setX(Dawid.getX() + 1);
			} else if (Dawid.getX() >= borderX) {
				System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
			}
			camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
			camera.update();
			try {
				MoveConclude();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.A) && Dawid.getX() > 1 && checkSuccesful == 0) {
			playerSprite.setX(playerSprite.getX() - 60);
			if (Dawid.getX() > 1) {
				Dawid.setX(Dawid.getX() - 1);
			} else {
				System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
			}
			camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
			camera.update();
			try {
				MoveConclude();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
			try {
				Dawid.Attack(currentTarget, Dawid);
			}catch (NullPointerException a){

			}
			}
		batch.setProjectionMatrix(camera.combined);
		if (currentTarget != null){
			try {

				Battle(Dawid, currentTarget);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
	}
		batch.begin();
		mapSprite.draw(batch);

		fightscreenSP.draw(batch);
inventorySP.setPosition(playerSprite.getX(), playerSprite.getY()+100);
		playerSprite.draw(batch);
		sprite.draw(batch);
		if (fightstart == 1){
			try {
				Fight.Turn(Dawid,monsterBase[1]);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.B)) {

			inventorySP.draw(batch);

		}
		/*if (Gdx.input.isKeyJustPressed(Input.Keys.X)) {
			if (doubleStrike == 0) {
				if (Dawid.getFreeze() < 1) {
					Dawid.Attack(monsterBase[1], Dawid);
					System.out.println("Zaatakowałeś");
				} else if (Dawid.getFreeze() > 0) {
					System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + Dawid.getFreeze() + " tury");
					Dawid.setFreeze(Dawid.getFreeze() - 1);
				}
				try {
					EnemyAttack(Dawid, monsterBase[1]);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			} else if (doubleStrike == 1) {
				FightLogic.WhoDoYouWantToAttack(monsterBase[1]);
			}

}*/

		batch.end();


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
		Player Dawid = new Player(300,300,20,0,1,4,4,0,0,0,0);
		int helmEQ = 0;
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
		spawn(27, monsterBase2);
		spawn(27, monsterBase3);
		spawn(27, monsterBase4);
		spawn(27, monsterBase5);
		spawn(27, monsterBase6);
		spawn(27, forestBase);
		spawn(27,banditCampBase);
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

				monster = currentTarget;
				fightscreenSP.setPosition(playerSprite.getX() - 640, playerSprite.getY() - 360);
				sprite.setPosition(fightscreenSP.getX()+ 1000, fightscreenSP.getY() + 360);
				sprite.setSize(200,200);

				checkSuccesful = 1;
				Fight.Turn(player, monster);
             fightstart = 1;
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
}