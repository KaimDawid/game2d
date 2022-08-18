package Mobs;

import Logic.Drop.Drop;
import Logic.GameLogic;
import Logic.INV;
import Logic.Inventory;
import Objects.Items.Chests.*;
import Objects.Items.Hands.*;
import Objects.Items.Helmets.*;
import Objects.Items.Item;

import Objects.Items.Necklaces.Necklace;

import Objects.Items.Weapons.*;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.GameApp;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.function.Function;

@Getter  @Setter
public abstract class Monster {
    public double hp;
    public int dmg;
    public double x;
    public double y;
    public String name;
    int freeze = 0;

    int poison = 0;
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

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public int getMutant() {
        return mutant;
    }

    public void setMutant(int mutant) {
        this.mutant = mutant;
    }

    public int getBandchief() {
        return bandchief;
    }

    public void setBandchief(int bandchief) {
        this.bandchief = bandchief;
    }

    public int getBand() {
        return band;
    }

    public void setBand(int band) {
        this.band = band;
    }

    public int getGlb() {
        return glb;
    }

    public void setGlb(int glb) {
        this.glb = glb;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public int getWewolf() {
        return wewolf;
    }

    public void setWewolf(int wewolf) {
        this.wewolf = wewolf;
    }

    public int getWolv() {
        return wolv;
    }

    public void setWolv(int wolv) {
        this.wolv = wolv;
    }

    public int getSkele() {
        return skele;
    }

    public void setSkele(int skele) {
        this.skele = skele;
    }

    public int getVamp() {
        return vamp;
    }

    public void setVamp(int vamp) {
        this.vamp = vamp;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFreeze() {
        return freeze;
    }

    public void setFreeze(int freeze) {
        this.freeze = freeze;
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }

    public int getGiveXP() {
        return giveXP;
    }

    public void setGiveXP(int giveXP) {
        this.giveXP = giveXP;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Monster.number = number;
    }

    public static Item[] getEqNumber() {
        return eqNumber;
    }

    public static void setEqNumber(Item[] eqNumber) {
        Monster.eqNumber = eqNumber;
    }

    public static int getHelmEQ() {
        return helmEQ;
    }

    public static void setHelmEQ(int helmEQ) {
        Monster.helmEQ = helmEQ;
    }

    public static int getHandsEQ() {
        return handsEQ;
    }

    public static void setHandsEQ(int handsEQ) {
        Monster.handsEQ = handsEQ;
    }

    public static int getChestEQ() {
        return chestEQ;
    }

    public static void setChestEQ(int chestEQ) {
        Monster.chestEQ = chestEQ;
    }

    public static int getNeckEQ() {
        return neckEQ;
    }

    public static void setNeckEQ(int neckEQ) {
        Monster.neckEQ = neckEQ;
    }

    public static int getWeaponEQ() {
        return weaponEQ;
    }

    public static void setWeaponEQ(int weaponEQ) {
        Monster.weaponEQ = weaponEQ;
    }

    public int getPoisonInvulnerability() {
        return poisonInvulnerability;
    }

    public void setPoisonInvulnerability(int poisonInvulnerability) {
        this.poisonInvulnerability = poisonInvulnerability;
    }

    public int getFireInvulnerability() {
        return fireInvulnerability;
    }

    public void setFireInvulnerability(int fireInvulnerability) {
        this.fireInvulnerability = fireInvulnerability;
    }

    public int getIceInvulnerability() {
        return iceInvulnerability;
    }

    public void setIceInvulnerability(int iceInvulnerability) {
        this.iceInvulnerability = iceInvulnerability;
    }

    public int getWaterInvulnerability() {
        return waterInvulnerability;
    }

    public void setWaterInvulnerability(int waterInvulnerability) {
        this.waterInvulnerability = waterInvulnerability;
    }

    public int getShockInvulnerability() {
        return shockInvulnerability;
    }

    public void setShockInvulnerability(int shockInvulnerability) {
        this.shockInvulnerability = shockInvulnerability;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int giveXP;
    double level;
    public static int number = 0;
    public static Item eqNumber[] = new Item[100];
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






    int floor;



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

                Monster.eqNumber[Monster.number] = new HeadPiece("Smoczy hełm [HEAD]", 50, 20, 3, 30, 1);
                System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.dragonhemletSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (helmetRandomize > 15 && helmetRandomize < 26) {

                Monster.eqNumber[Monster.number] = new HeadPiece("Hełm wysadzany diamentami [HEAD]", 60, 30, 5, 50, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.diamondhelmetSPR);
                Monster.number++;
            } else if (helmetRandomize > 25 && helmetRandomize < 51) {

                Monster.eqNumber[Monster.number] = new HeadPiece("Skórzany hełm [HEAD]", 30, 20, 7, 0, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.leatherhelmetSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (helmetRandomize > 50 && helmetRandomize < 81) {

                Monster.eqNumber[Monster.number] = new HeadPiece("Płytowy hełm [HEAD]", 70, 10, 0, 10, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.platehelmetSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (helmetRandomize > 80) {

                Monster.eqNumber[Monster.number] = new HeadPiece("Kapelusz nowicjusza [HEAD]", 0, 10, 5, 60, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.novicehatSPR);
                Equipment.eqSlot++;
                Monster.number++;
            }

        }
    }

    public static void dropArmor(){
        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 88) {
            int armorRandomize = random.nextInt(100);

            if (armorRandomize < 16) {

                Monster.eqNumber[Monster.number] = new ChestArmor("Smocza zbroja [CHEST]", 100, 20, 3, 30, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.dragonarmorSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (armorRandomize > 15 && armorRandomize < 26) {

                Monster.eqNumber[Monster.number] = new ChestArmor("Zbroja łuskowa [CHEST]", 80, 10, 0, 0, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.mailshirtSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (armorRandomize > 25 && armorRandomize < 51) {

                Monster.eqNumber[Monster.number] = new ChestArmor("Skórzana zbroja [CHEST]", 60, 20, 7, 0, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.leatherarmorSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (armorRandomize > 50 && armorRandomize < 81) {

                Monster.eqNumber[Monster.number] = new ChestArmor("Zbroja płytowa [CHEST]", 120, 5, 3, 10, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.plateArmorSPR) ;
                Equipment.eqSlot++;
                Monster.number++;

            } else if (armorRandomize > 80) {

                Monster.eqNumber[Monster.number] = new ChestArmor("Szata nowicjusza [CHEST]", 30, 10, 3, 50, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.novicerobeSPR);
                Equipment.eqSlot++;
                Monster.number++;
            }
        }
    }

    public static void dropGloves(){
        Random random = new Random();

        int dropChance = random.nextInt(100);

        if (dropChance > 88) {
            int glovesRandomize = random.nextInt(100);

            if (glovesRandomize < 16) {

                Monster.eqNumber[Monster.number] = new Gloves("Rękawice bazyliszka [GLOVES]", 20, 20, 3, 20, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.mailglovesSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (glovesRandomize > 15 && glovesRandomize < 26) {

                Monster.eqNumber[Monster.number] = new Gloves("Rękawice wysadzane diamentami [GLOVES]", 30, 25, 5, 30, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.diamondglovesSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (glovesRandomize > 25 && glovesRandomize < 51) {

                Monster.eqNumber[Monster.number] = new Gloves("Skórzane rękawice [GLOVES]", 10, 15, 7, 0, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.leatherglovesSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (glovesRandomize > 50 && glovesRandomize < 81) {

                Monster.eqNumber[Monster.number] = new Gloves("Płytowe rękawice [GLOVES]", 40, 7, 2, 10, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.plateglovesSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (glovesRandomize > 80) {

                Monster.eqNumber[Monster.number] = new Gloves("Rękawice nowicjusza [GLOVES]", 10, 5, 3, 40, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.noviceglovesSPR);
                Equipment.eqSlot++;
                Monster.number++;
            }
        }
    }

    public static void dropWeapon(){

        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 85) {
            int weaponRandomize = random.nextInt(100);


            if (weaponRandomize < 16) {

                Monster.eqNumber[Monster.number] = new Weapon("Katana [WEAPON]", 0, 90, 7, 10, 1, 1, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                 GameApp.eqList.add(Assets.katanaSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (weaponRandomize > 15 && weaponRandomize < 26) {

                Monster.eqNumber[Monster.number] = new Weapon("Miecz dwuręczny [WEAPON]", 0, 130, 3, 0, 2, 1, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.twohandedswordSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (weaponRandomize > 25 && weaponRandomize < 51) {

                Monster.eqNumber[Monster.number] = new Weapon("Sztylet [WEAPON]", 0, 60, 10, 0, 1, 1, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.daggerSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (weaponRandomize > 50 && weaponRandomize < 81) {

                Monster.eqNumber[Monster.number] = new Weapon("Miecz i tarcza [WEAPON]", 120, 60, 3, 10, 2, 1, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.swordswordandshieldSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (weaponRandomize > 80) {

                Monster.eqNumber[Monster.number] = new Weapon("Laska nowicjusza [WEAPON]", 0, 5, 0, 80, 2, 0, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.novicestaffSPR);
                Equipment.eqSlot++;
                Monster.number++;
            }

        }
    }


    public static void dropNeck() {
        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 88) {
            int neckRandomize = random.nextInt(100);

            if (neckRandomize < 26) {

                Monster.eqNumber[Monster.number] = new Necklace("Perłowy naszyjnik [NECK]", 5, 5, 3, 40, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.diamondnecklaceSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (neckRandomize > 25 && neckRandomize < 71) {

                Monster.eqNumber[Monster.number] = new Necklace("Miedziany naszyjnik [NECK]", 0, 5, 0, 10, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.coppernecklaceSPR);
                Equipment.eqSlot++;
                Monster.number++;
            } else if (neckRandomize > 70) {

                Monster.eqNumber[Monster.number] = new Necklace("Srebrny naszyjnik [NECK]", 15, 5, 0, 30, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
                GameApp.eqList.add(Assets.silvernecklaceSPR);
                Equipment.eqSlot++;
                Monster.number++;
            }
        }
    }



}

