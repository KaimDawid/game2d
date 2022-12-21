package Mobs;

import Mobs.Cemetery.CemeterySprites;
import com.badlogic.gdx.graphics.Texture;
import lombok.Getter;
import lombok.Setter;



import Objects.Items.Chests.*;
import Objects.Items.Helmets.HeadPiece;
import Objects.Items.Hands.*;

import Objects.Items.Item;

import Objects.Items.Necklaces.Necklace;

import Objects.Items.Weapons.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.GameApp;

import java.util.ArrayList;
import java.util.Random;

import static Data.Quests.FlorekQuest.crayfishSPR;
import static Data.Quests.Quests.gabiSPR;
import static com.mygdx.game.Assets.*;
import static com.mygdx.game.GameApp.*;

@Getter
@Setter
public abstract class Monster {

    public int mobType = 0;

    public static Texture whiteKnightTXT, minotaurTXT;
    public static Sprite whiteKnightSPR, minotaurSPR;
    public static ArrayList<Sprite> monsterSprites;

    public double hp;
    public int dmg;
    public double x;
    public double y;
    public String name;

    int freeze = 0;

    int poison = 0;
    int whk = 0;
int glb =0;
int spid = 0;
int wewolf = 0;
int wolv = 0;
int skele = 0;
int vamp = 0;

int bandchief = 0;
int band = 0;

int mutant = 0;

double maxHP = hp;




    public int giveXP;
    double level;
    public static int helmEQ;
    public static int handsEQ;
    public static int chestEQ;
    public static int neckEQ;
    public static int weaponEQ;

    int poisonInvulnerability;

    int fireInvulnerability;

    int iceInvulnerability;

    int waterInvulnerability;

    int shockInvulnerability;


public int statusAmount;



    int floor;
public static void create1(){
    spiderTexture = new Texture("spider.png");
    spiderSprite = new Sprite(spiderTexture);
    spiderSprite.setSize(0, 0);
    goblinTxt = new Texture("goblin.png");
    goblinSprite = new Sprite(goblinTxt);
    goblinSprite.setSize(0, 0);
    skeletonTxt = new Texture("skeleton.png");
    skeletonSprite = new Sprite(skeletonTxt);
    skeletonSprite.setSize(0, 0);
    spiderSprite.setPosition(playerSprite.getX() + 100, playerSprite.getY());
    Assets.banditSPR.setPosition(playerSprite.getX() + 100, playerSprite.getY());
    Assets.banditchiefSPR.setPosition(playerSprite.getX() + 100, playerSprite.getY());
    Assets.banditSPR.setSize(0, 0);
    Assets.banditchiefSPR.setSize(0, 0);
    minotaurTXT = new Texture("minotaur.png");
    minotaurSPR = new Sprite(minotaurTXT);
}

public static void create(){

    whiteKnightTXT = new Texture("whiteknight.png");
    whiteKnightSPR = new Sprite(whiteKnightTXT);
    monsterSprites = new ArrayList<Sprite>();

    monsterSprites.add(0,spiderSprite);
    monsterSprites.add(1,wolfSPR);
    monsterSprites.add(2, werewolfSPR);
    monsterSprites.add(3,vampireSPR);
    monsterSprites.add(4, goblinSprite);
    monsterSprites.add(5, mutantSPR);
    monsterSprites.add(6, crayfishSPR);
    monsterSprites.add(7, banditSPR);
    monsterSprites.add(8, banditchiefSPR);
    monsterSprites.add(9,whiteKnightSPR);
    monsterSprites.add(10,gabiSPR);
    monsterSprites.add(11, CemeterySprites.ghostSPR);
    monsterSprites.add(12, CemeterySprites.ghoulSPR);
    monsterSprites.add(13, CemeterySprites.headlessHorsemanSPR);
    monsterSprites.add(14, CemeterySprites.lumpOfFleshSPR);
    monsterSprites.add(15, CemeterySprites.skeletonSPR);


/*    for (int i = 0; i < monsterSprites.size(); i++) {
        monsterSprites.get(i).setSize(600,600);
        monsterSprites.get(i).setPosition(playerSprite.getX()+ 300, playerSprite.getY());
    }*/
}
    public void Drop(){

        dropNeck();
        dropWeapon();
        dropGloves();
        dropArmor();
        dropHelmet();

    }


    public Monster(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
        this.hp = hp;
        this.dmg = dmg;
        this.x = x;
        this.y = y;
        this.name = name;
        this.giveXP = giveXP;
        this.floor = floor;
    /*    this.gold = gold;*/
    }

    int armor;



abstract public int getGold();
    abstract public void setGold();

    public double getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public abstract void setGold(int gold);
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            System.out.println("Przeciwnik zadał cios krytyczny za "+ monster.getDmg()*1.2 + " punktów obrażeń!");

        }
        else if (roll < 81 && roll > missRoll){
            if (player.getAdrenalineValue() == 1){
                player.setHP(player.getHP() - (monster.getDmg()*1.3));
            }
            else {
                player.setHP(player.getHP() - monster.getDmg() + player.getArmor());
            }
        }
        else if (roll < missRoll){
            System.out.println("Przeciwnik chybił!");
        }
    }

    public static void dropHelmet(){
        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 88) {

            int helmetRandomize = random.nextInt(100);

            if (helmetRandomize < 16) {

                Item.gearPiece[Item.currentSlot] = new HeadPiece("Smoczy hełm [HEAD]", 50, 20, 3, 30, 1);
                System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.dragonhemletSPR);

            } else if (helmetRandomize > 15 && helmetRandomize < 26) {

                Item.gearPiece[Item.currentSlot] = new HeadPiece("Hełm wysadzany diamentami [HEAD]", 60, 30, 5, 50, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.diamondhelmetSPR);

            } else if (helmetRandomize > 25 && helmetRandomize < 51) {

                Item.gearPiece[Item.currentSlot] = new HeadPiece("Skórzany hełm [HEAD]", 30, 20, 7, 0, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.leatherhelmetSPR);

            } else if (helmetRandomize > 50 && helmetRandomize < 81) {

                Item.gearPiece[Item.currentSlot] = new HeadPiece("Płytowy hełm [HEAD]", 70, 10, 0, 10, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.platehelmetSPR);

            } else if (helmetRandomize > 80) {

                Item.gearPiece[Item.currentSlot] = new HeadPiece("Kapelusz nowicjusza [HEAD]", 0, 10, 5, 60, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.novicehatSPR);

            }
            Equipment.eqSlot++;
            Item.currentSlot++;
        }
    }

    public static void dropArmor(){
        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 88) {
            int armorRandomize = random.nextInt(100);

            if (armorRandomize < 16) {

                Item.gearPiece[Item.currentSlot] = new ChestArmor("Smocza zbroja [CHEST]", 100, 20, 3, 30, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.dragonarmorSPR);

            } else if (armorRandomize > 15 && armorRandomize < 26) {

                Item.gearPiece[Item.currentSlot] = new ChestArmor("Zbroja łuskowa [CHEST]", 80, 10, 0, 0, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.mailshirtSPR);

            } else if (armorRandomize > 25 && armorRandomize < 51) {

                Item.gearPiece[Item.currentSlot] = new ChestArmor("Skórzana zbroja [CHEST]", 60, 20, 7, 0, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.leatherarmorSPR);

            } else if (armorRandomize > 50 && armorRandomize < 81) {

                Item.gearPiece[Item.currentSlot] = new ChestArmor("Zbroja płytowa [CHEST]", 120, 5, 3, 10, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.plateArmorSPR) ;


            } else if (armorRandomize > 80) {

                Item.gearPiece[Item.currentSlot] = new ChestArmor("Szata nowicjusza [CHEST]", 30, 10, 3, 50, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.novicerobeSPR);

            }
            Equipment.eqSlot++;
            Item.currentSlot++;
        }
    }
    public int dropable = 1;

    public int getDropable() {
        return dropable;
    }

    public void setDropable(int dropable) {
        this.dropable = dropable;
    }

    public static void dropGloves(){
        Random random = new Random();

        int dropChance = random.nextInt(100);

        if (dropChance > 88) {
            int glovesRandomize = random.nextInt(100);

            if (glovesRandomize < 16) {

                Item.gearPiece[Item.currentSlot] = new Gloves("Rękawice bazyliszka [GLOVES]", 20, 20, 3, 20, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.mailglovesSPR);

            } else if (glovesRandomize > 15 && glovesRandomize < 26) {

                Item.gearPiece[Item.currentSlot] = new Gloves("Rękawice wysadzane diamentami [GLOVES]", 30, 25, 5, 30, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.diamondglovesSPR);

            } else if (glovesRandomize > 25 && glovesRandomize < 51) {

                Item.gearPiece[Item.currentSlot] = new Gloves("Skórzane rękawice [GLOVES]", 10, 15, 7, 0, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.leatherglovesSPR);

            } else if (glovesRandomize > 50 && glovesRandomize < 81) {

                Item.gearPiece[Item.currentSlot] = new Gloves("Płytowe rękawice [GLOVES]", 40, 7, 2, 10, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.plateglovesSPR);

            } else if (glovesRandomize > 80) {

                Item.gearPiece[Item.currentSlot] = new Gloves("Rękawice nowicjusza [GLOVES]", 10, 5, 3, 40, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.noviceglovesSPR);

            }
            Equipment.eqSlot++;
            Item.currentSlot++;
        }
    }

    public static void dropWeapon(){

        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 85) {
            int weaponRandomize = random.nextInt(100);


            if (weaponRandomize < 16) {

                Item.gearPiece[Item.currentSlot] = new Weapon("Katana [WEAPON]", 0, 90, 7, 10, 1, 1, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                 GameApp.eqList.add(Assets.katanaSPR);

            } else if (weaponRandomize > 15 && weaponRandomize < 26) {

                Item.gearPiece[Item.currentSlot] = new Weapon("Miecz dwuręczny [WEAPON]", 0, 130, 3, 0, 2, 1, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.twohandedswordSPR);

            } else if (weaponRandomize > 25 && weaponRandomize < 51) {

                Item.gearPiece[Item.currentSlot] = new Weapon("Sztylet [WEAPON]", 0, 60, 10, 0, 1, 1, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.daggerSPR);

            } else if (weaponRandomize > 50 && weaponRandomize < 81) {

                Item.gearPiece[Item.currentSlot] = new Weapon("Miecz i tarcza [WEAPON]", 120, 60, 3, 10, 2, 1, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.swordswordandshieldSPR);

            } else if (weaponRandomize > 80) {

                Item.gearPiece[Item.currentSlot] = new Weapon("Laska nowicjusza [WEAPON]", 0, 5, 0, 80, 2, 0, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.novicestaffSPR);

            }
            Equipment.eqSlot++;
            Item.currentSlot++;
        }
    }


    public static void dropNeck() {
        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 88) {
            int neckRandomize = random.nextInt(100);

            if (neckRandomize < 26) {

                Item.gearPiece[Item.currentSlot] = new Necklace("Perłowy naszyjnik [NECK]", 5, 5, 3, 40, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.diamondnecklaceSPR);

            } else if (neckRandomize > 25 && neckRandomize < 71) {

                Item.gearPiece[Item.currentSlot] = new Necklace("Miedziany naszyjnik [NECK]", 0, 5, 0, 10, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.coppernecklaceSPR);

            } else if (neckRandomize > 70) {

                Item.gearPiece[Item.currentSlot] = new Necklace("Srebrny naszyjnik [NECK]", 15, 5, 0, 30, 1);
                 System.out.println("Znalazłeś " + Item.gearPiece[Item.currentSlot].getShortName() + " (" + Item.gearPiece[Item.currentSlot].getHP() + " HP, "
                        + Item.gearPiece[Item.currentSlot].getDMG() + " DMG, " + Item.gearPiece[Item.currentSlot].getCrit() + "Crit, " + Item.gearPiece[Item.currentSlot].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.silvernecklaceSPR);

            }
            Equipment.eqSlot++;
            Item.currentSlot++;
        }
    }



}

