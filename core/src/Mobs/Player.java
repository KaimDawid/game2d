package Mobs;


import Logic.Inventory;
import Logic.Skills;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.Scanner;

@Getter @Setter

public class Player {
    public static int ICE = 60;

    public static int getICE() {
        return ICE;
    }

    public static void setICE(int ICE) {
        Player.ICE = ICE;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    public double getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(double maxHP) {
        MaxHP = maxHP;
    }

    public int getDMG() {
        return DMG;
    }

    public void setDMG(int DMG) {
        this.DMG = DMG;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public int getEscapeInvulnerability() {
        return escapeInvulnerability;
    }

    public void setEscapeInvulnerability(int escapeInvulnerability) {
        this.escapeInvulnerability = escapeInvulnerability;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getToxify() {
        return toxify;
    }

    public void setToxify(int toxify) {
        this.toxify = toxify;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getBombNumber() {
        return bombNumber;
    }

    public void setBombNumber(int bombNumber) {
        this.bombNumber = bombNumber;
    }

    public int getPotionNumber() {
        return potionNumber;
    }

    public void setPotionNumber(int potionNumber) {
        this.potionNumber = potionNumber;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }

    public int getBurn() {
        return burn;
    }

    public void setBurn(int burn) {
        this.burn = burn;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getIronSkinValue() {
        return ironSkinValue;
    }

    public void setIronSkinValue(int ironSkinValue) {
        this.ironSkinValue = ironSkinValue;
    }

    public int getAdrenalineValue() {
        return adrenalineValue;
    }

    public void setAdrenalineValue(int adrenalineValue) {
        this.adrenalineValue = adrenalineValue;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public double getManaRegen() {
        return manaRegen;
    }

    public void setManaRegen(double manaRegen) {
        this.manaRegen = manaRegen;
    }

    public int getChosenSkill1() {
        return chosenSkill1;
    }

    public void setChosenSkill1(int chosenSkill1) {
        this.chosenSkill1 = chosenSkill1;
    }

    public int getChosenSkill2() {
        return chosenSkill2;
    }

    public void setChosenSkill2(int chosenSkill2) {
        this.chosenSkill2 = chosenSkill2;
    }

    public int getChosenSkill3() {
        return chosenSkill3;
    }

    public void setChosenSkill3(int chosenSkill3) {
        this.chosenSkill3 = chosenSkill3;
    }

    public int getChosenSkill4() {
        return chosenSkill4;
    }

    public void setChosenSkill4(int chosenSkill4) {
        this.chosenSkill4 = chosenSkill4;
    }

    public int getChosenSkill5() {
        return chosenSkill5;
    }

    public void setChosenSkill5(int chosenSkill5) {
        this.chosenSkill5 = chosenSkill5;
    }

    public int getChosenSkill6() {
        return chosenSkill6;
    }

    public void setChosenSkill6(int chosenSkill6) {
        this.chosenSkill6 = chosenSkill6;
    }

    public int getChosenSkill7() {
        return chosenSkill7;
    }

    public void setChosenSkill7(int chosenSkill7) {
        this.chosenSkill7 = chosenSkill7;
    }

    public int getChosenSkill8() {
        return chosenSkill8;
    }

    public void setChosenSkill8(int chosenSkill8) {
        this.chosenSkill8 = chosenSkill8;
    }

    public int getChosenSkill9() {
        return chosenSkill9;
    }

    public void setChosenSkill9(int chosenSkill9) {
        this.chosenSkill9 = chosenSkill9;
    }

    public int getChosenSkill10() {
        return chosenSkill10;
    }

    public void setChosenSkill10(int chosenSkill10) {
        this.chosenSkill10 = chosenSkill10;
    }

    public int getAttributePoints() {
        return attributePoints;
    }

    public void setAttributePoints(int attributePoints) {
        this.attributePoints = attributePoints;
    }

    public int getWeaponCapacity() {
        return weaponCapacity;
    }

    public void setWeaponCapacity(int weaponCapacity) {
        this.weaponCapacity = weaponCapacity;
    }

    public int getFreeze() {
        return freeze;
    }

    public void setFreeze(int freeze) {
        this.freeze = freeze;
    }

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    public final static int TP = 61;
    public final static int FIREBALL = 62;

    public final static int ADRENALINE = 63;

    public final static int IRONSKIN = 64;

    public final static int CLEAVE = 65;

    public final static int HEAL = 66;

    private double HP = 120;
    private double MaxHP = 120;
    int DMG = 20;
    public int XP;

    public double level = 0;
    int escapeInvulnerability = 0;


    public int X;
    public int Y;

    int floor = 1;


int toxify = 0;

    int gold;
    int bombNumber;
    int potionNumber;
    int armor;
    int poison;

    int burn;
    int maxMana = 100;

    int ironSkinValue = 0;
    int adrenalineValue = 0;



    int magic = 0;
    int classNumber;
    double mana;

    double manaRegen = 10;



    public int chosenSkill1 = 0;
    public int chosenSkill2 = 0;
    public int chosenSkill3 = 0;
    public int chosenSkill4 = 0;
    public int chosenSkill5 = 0;

    public int chosenSkill6 = 0;

    public int chosenSkill7 = 0;

    public int chosenSkill8 = 0;

    public int chosenSkill9 = 0;



    public int chosenSkill10 = 0;

    int attributePoints;

int weaponCapacity = 1;



    int freeze = 0;


    double critChance;


    public Player(double HP, double maxHP, int DMG, int XP, int level, int x, int y, int gold, int bombNumber, int potionNumber,
                  int armor) {
        this.HP = HP;
        MaxHP = maxHP;
        this.DMG = DMG;
        this.XP = XP;
        this.level = level;
        X = x;
        Y = y;
        this.gold = gold;
        this.bombNumber = bombNumber;
        this.potionNumber = potionNumber;
        this.armor = armor;
    }


    public void DualWield(Player player){
        player.setWeaponCapacity(2);
    }



    public void Freeze(Monster target) {
        double iceDMG = 25 + (0.25 * magic);
        if (mana > 69) {
            System.out.println(target.getName() + " został zamrożony na 2 tury i otrzymał " + iceDMG + " obrażeń");
            target.setHp(target.getHp() - (DMG * 0.25));
            target.setFreeze(3);
            mana = mana - 70;
        } else {
            System.out.println("Masz za mało many!");
        }
    }

    public void Teleport(Player player) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz gdzie chcesz się przeteleportować.");
        System.out.println("X :");
        int inputX = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Y: ");
        int inputY = scanner.nextInt();
        scanner.nextLine();
        player.setX(inputX);
        player.setY(inputY);
        System.out.println("Twoje nowe koordynaty to: " + inputX + "," + inputY);

    }

    public void Heal(Player player){
        if (player.getChosenSkill1() == HEAL || player.getChosenSkill2() == HEAL || player.getChosenSkill3() == HEAL ||  player.getChosenSkill4() == HEAL ||
                player.getChosenSkill5() == HEAL || player.getChosenSkill6() == HEAL || player.getChosenSkill7() == HEAL ||
                player.getChosenSkill8() == HEAL || player.getChosenSkill9() == HEAL || player.getChosenSkill10() == HEAL) {
            if (player.getMana() >= 60) {
                double healValue = 150 + (player.getMagic() * 0.6);
                player.setMana(player.getMana() - 60);
                player.setHP(player.getHP() + healValue);
                double overHeal = (player.getHP() - player.getMaxHP());
                if (overHeal >= 0){
                    player.setHP(player.getHP() - overHeal);
                }
                System.out.println("Uleczyłeś się za " + healValue + " punktów życia");
            } else {
                System.out.println("Masz za mało many!");
            }
        }
        else {
            System.out.println("Nie masz tej umiejętności.");
        }
    }

    public void Fireball(Monster monster, Player player) {
        double fireDMG = 80 + magic;
        if (mana >= 50) {
            mana = mana - 50;
            monster.setHp(monster.getHp() - fireDMG);
            System.out.println("Rzuciłeś kulą ognia za " + fireDMG + " obrażeń");
        } else {
            System.out.println("Masz za mało many!");
        }
    }

    public void IronSkin(Player player) {
        String skillName = "Żelazna skóra";
        int ironSkinValue = 30;
        if (player.getIronSkinValue() == 0) {
            System.out.println("Użyłeś czaru " + skillName + " i otrzymałeś " + ironSkinValue + " punktów zbroi na 2 tury");
            player.setArmor(player.getArmor() + ironSkinValue);
            player.setIronSkinValue(1);
        }

    }


    public void Adrenaline(Player player) {

        String skillName = "Adrenalina";

        if (player.getAdrenalineValue() == 0) {
            double adrenalineAttackValue = (player.getDMG() + 60);
            double adrenalineArmorValue = (player.getArmor() - 40);

            player.setDMG((int) adrenalineAttackValue);
            player.setArmor((int) adrenalineArmorValue);

            System.out.println("Użyłeś umiejętności " + skillName + ", zadajesz więcej obrażeń ale sam jesteś bardziej podatny na obrażenia");
            player.setAdrenalineValue(1);
        }

        // 29% w dół

    }

    public void Cleave(Player player, Monster monster, Monster monster2) {

        player.setDMG(player.getDMG() + 20);
        System.out.println("Bierzesz zamach i atakujesz obu wrogów naraz ze zwiększoną siłą");
        System.out.println("Zadajesz obu potworom " + player.getDMG() + " obrażeń");
        player.Attack(monster, player);
        player.Attack(monster2, player);
        player.setDMG(player.getDMG() - 20);


    }


    public void Attack(Monster monster, Player player) {
        Random random = new Random();
        double missRoll = (20 - (player.getLevel() * 3) + (monster.getLevel() * 3));
        double roll = random.nextDouble(100);
        double critRoll = (80 - player.getCritChance());
        if (roll > critRoll) {
            double dmgroll = (random.nextInt(20)+ (player.getDMG() * 1.2) - 10);
            monster.setHp(monster.getHp() - (dmgroll + monster.getArmor()));
            System.out.println("Zadałeś cios krytyczny za " + dmgroll + " punktów obrażeń!");
            if (monster.getArmor() > 0) {
                System.out.println("Potwór zanegował " + monster.getArmor() + " obrażeń");
            }
            putToxin(player,monster);
        } else if (roll < critRoll && roll > missRoll) {
            double dmgRoll = (random.nextInt(20)+ player.getDMG() - 10);
            monster.setHp(monster.getHp() - dmgRoll + monster.getArmor());
            System.out.println("Zadałeś " + dmgRoll + " obrażeń");
            if (monster.getArmor() > 0) {
                System.out.println("Potwór zanegował " + monster.getArmor() + " obrażeń");
            }
            putToxin(player,monster);
        } else if (roll < missRoll) {
            System.out.println("Chybiłeś!");
        }
    }

public static void putToxin(Player player, Monster monster) {


        if (Inventory.equippedweapon.getIsToxic() == 1) {
            Random random = new Random();
            int chance = random.nextInt(100);
            if (chance > 80 && player.getToxify() > 0 && monster.getPoisonInvulnerability() == 0) {
                monster.setPoison(3);
                System.out.println("Zatrułeś swojego przeciwnika na 2 tury! Otrzymuje on 30 obrażeń co turę.");
                monster.setHp(monster.getHp() - 30);
            }
        }
}

/*public static void putToxin(Player player, Monster monster){
        Random random = new Random();
        int chance = random.nextInt(100);
        if (chance > 80 && player.getToxify() > 0){
            monster.setPoison(3);
            System.out.println("Zatrułeś swojego przeciwnika na 2 tury! Otrzymuje on 30 obrażeń co turę.");
            monster.setHp(monster.getHp() - 30);
        }
    }*/

}
