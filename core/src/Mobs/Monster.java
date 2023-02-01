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
    monsterSprites.add(16,minotaurSPR);

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
        int roll = random.nextInt(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            if (player.getArmor()> monster.getDmg()){
                player.setHP(player.getHP() - 10);
            }
            else {
                player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
                System.out.println("Przeciwnik zadał cios krytyczny za " + monster.getDmg() * 1.2 + " punktów obrażeń!");
            }

        }
        else if (roll < 81 && roll > missRoll){
            if (player.getArmor()> monster.getDmg()){
                player.setHP(player.getHP() - 10);
            }
            else {
                if (player.getAdrenalineValue() == 1) {
                    player.setHP(player.getHP() - (monster.getDmg() * 1.3));
                } else {
                    player.setHP(player.getHP() - monster.getDmg() + player.getArmor());
                }
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

                GameApp.eqList.add(Assets.dragonhemletSPR);
                Item.gear.add(new HeadPiece("Drake helmet [HEAD]", 50, 20, 3, 30, 1));


            } else if (helmetRandomize > 15 && helmetRandomize < 26) {
                GameApp.eqList.add(Assets.diamondhelmetSPR);

                Item.gear.add(new HeadPiece("Jewelled helmet [HEAD]", 60, 30, 5, 50, 1));


            } else if (helmetRandomize > 25 && helmetRandomize < 51) {
                GameApp.eqList.add(Assets.leatherhelmetSPR);
                Item.gear.add(new HeadPiece("Leather helmet [HEAD]", 30, 20, 7, 0, 1));



            } else if (helmetRandomize > 50 && helmetRandomize < 81) {
                GameApp.eqList.add(Assets.platehelmetSPR);
                Item.gear.add(new HeadPiece("Plate helmet [HEAD]", 70, 10, 0, 10, 1));



            } else if (helmetRandomize > 80) {
                GameApp.eqList.add(Assets.novicehatSPR);
                Item.gear.add(new HeadPiece("Novice hat [HEAD]", 0, 10, 5, 60, 1));



            }

        }
    }

    public static void dropArmor(){
        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 88) {
            int armorRandomize = random.nextInt(100);

            if (armorRandomize < 16) {
                GameApp.eqList.add(Assets.dragonarmorSPR);
                Item.gear.add(new ChestArmor("Drake armor [CHEST]", 100, 20, 3, 30, 1));


            } else if (armorRandomize > 15 && armorRandomize < 26) {
                GameApp.eqList.add(Assets.mailshirtSPR);
                Item.gear.add(new ChestArmor("Mail armor [CHEST]", 80, 10, 0, 0, 1));


            } else if (armorRandomize > 25 && armorRandomize < 51) {
                GameApp.eqList.add(Assets.leatherarmorSPR);
                Item.gear.add(new ChestArmor("Leather armor [CHEST]", 60, 20, 7, 0, 1));


            } else if (armorRandomize > 50 && armorRandomize < 81) {
                GameApp.eqList.add(Assets.plateArmorSPR) ;
                Item.gear.add(new ChestArmor("Plate armor [CHEST]", 120, 5, 3, 10, 1));


            } else if (armorRandomize > 80) {
                GameApp.eqList.add(Assets.novicerobeSPR);
                Item.gear.add(new ChestArmor("Novice robes [CHEST]", 30, 10, 3, 50, 1));

            }

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
                GameApp.eqList.add(Assets.mailglovesSPR);
                Item.gear.add(new Gloves("Basilisk gloves [GLOVES]", 20, 20, 3, 20, 1)) ;

            } else if (glovesRandomize > 15 && glovesRandomize < 26) {
                GameApp.eqList.add(Assets.diamondglovesSPR);
                Item.gear.add(new Gloves("Jewelled gloves [GLOVES]", 30, 25, 5, 30, 1)) ;

            } else if (glovesRandomize > 25 && glovesRandomize < 51) {
                GameApp.eqList.add(Assets.leatherglovesSPR);
                Item.gear.add(new Gloves("Leather gloves [GLOVES]", 10, 15, 7, 0, 1));

            } else if (glovesRandomize > 50 && glovesRandomize < 81) {
                GameApp.eqList.add(Assets.plateglovesSPR);
                Item.gear.add(new Gloves("Plate gloves [GLOVES]", 40, 7, 2, 10, 1)) ;

            } else if (glovesRandomize > 80) {
                GameApp.eqList.add(Assets.noviceglovesSPR);
                Item.gear.add(new Gloves("Novice gloves [GLOVES]", 10, 5, 3, 40, 1)) ;

            }

        }
    }

    public static void dropWeapon(){

        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 85) {
            int weaponRandomize = random.nextInt(100);


            if (weaponRandomize < 16) {
                GameApp.eqList.add(Assets.katanaSPR);
                Item.gear.add(new Weapon("Katana [WEAPON]", 0, 70, 7, 10, 1, 1, 1));

            } else if (weaponRandomize > 15 && weaponRandomize < 26) {
                GameApp.eqList.add(Assets.twohandedswordSPR);
                Item.gear.add(new Weapon("Two-handed sword [WEAPON]", 0, 80, 3, 0, 2, 1, 1));

            } else if (weaponRandomize > 25 && weaponRandomize < 51) {
                GameApp.eqList.add(Assets.daggerSPR);
                Item.gear.add(new Weapon("Dagger [WEAPON]", 0, 50, 10, 0, 1, 1, 1));

            } else if (weaponRandomize > 50 && weaponRandomize < 81) {
                GameApp.eqList.add(Assets.swordswordandshieldSPR);
                Item.gear.add(new Weapon("Sword and shield [WEAPON]", 120, 50, 3, 10, 2, 1, 1));

            } else if (weaponRandomize > 80) {
                GameApp.eqList.add(Assets.novicestaffSPR);
                Item.gear.add(new Weapon("Novice staff [WEAPON]", 0, 5, 0, 80, 2, 0, 1));

            }

        }
    }


    public static void dropNeck() {
        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 88) {
            int neckRandomize = random.nextInt(100);

            if (neckRandomize < 26) {
                GameApp.eqList.add(Assets.diamondnecklaceSPR);
                Item.gear.add(new Necklace("Pearl Necklace [NECK]", 5, 5, 3, 40, 1)) ;

            } else if (neckRandomize > 25 && neckRandomize < 71) {
                GameApp.eqList.add(Assets.coppernecklaceSPR);
                Item.gear.add(new Necklace("Copper necklace [NECK]", 0, 5, 0, 10, 1));

            } else if (neckRandomize > 70) {
                GameApp.eqList.add(Assets.silvernecklaceSPR);
                Item.gear.add(new Necklace("Silver necklace [NECK]", 15, 5, 0, 30, 1)) ;

            }

        }
    }



}

