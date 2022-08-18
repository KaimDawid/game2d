package Mobs;


import Logic.Drop.Miscelanous;
import Logic.Status.Status;
import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.GameApp;

import java.util.Random;

public class Spider extends Monster {

    public Spider(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);

    }
    double maxHP = hp;

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }
    @Override
    public int getGold() {
        return 0;
    }

    @Override
    public void setGold() {

    }
@Override
    public void Drop(){
    Random random = new Random();
    int sackChance = random.nextInt(100);
    if (sackChance > 10){
        int sackNumber = (random.nextInt(2)+ 1);
        Miscelanous.poisonSacks = Miscelanous.poisonSacks + sackNumber;
        System.out.println("Znalazłeś " + sackNumber + " worków z jadem, masz ich już " + Miscelanous.poisonSacks + "/6");
    }
    dropNeck();
        dropWeapon();
        dropGloves();
        dropArmor();
        dropHelmet();

    }

    public boolean isSpidey() {
        return spidey;
    }

    public void setSpidey(boolean spidey) {
        this.spidey = spidey;
    }
    int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    boolean spidey = true;
int spid = 1;

    @Override
    public int getSpid() {
        return spid;
    }

    @Override
    public void setSpid(int spid) {
        this.spid = spid;
    }

    @Override
    public void setGold(int gold) {

    }
   /* public void Attack(Monster monster, Player player){
        Fight fight = new Fight();
        Random random = new Random();
        Poison poison = new Poison();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            setI(2);
            spidey = true;
            poison.poisoned(player);
            player.setHP(player.getHP() - (monster.getDmg()) + player.getArmor());
            System.out.println("Przeciwnik zatruł Cię na 2 tury za "+ 20 + " punktów obrażeń!");

        }
        else if (roll < 81 && roll > missRoll){
            player.setHP(player.getHP() - monster.getDmg() + player.getArmor());
            System.out.println("Przeciwnik uderzył Cię za " + monster.getDmg() + " obrażeń");
        }
        else if (roll < missRoll){
            System.out.println("Przeciwnik chybił!");
        }s
    }*/
   public void Attack(Monster monster, Player player){
       Random random = new Random();
       double roll = random.nextDouble(100);
       double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
       if (roll > 80){
           Status.POISON(player, monster);
           GameApp.mobSpellText = " The spider has poisoned you! ";
       }
       else if (roll < 81 && roll > missRoll){
           int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
           System.out.println("Pajak ukasil Cię za " + (dmgRoll - player.getArmor()) + " obrazen");
           player.setHP(player.getHP() -dmgRoll + player.getArmor());
           GameApp.enemyAttackText = "The spider bit you for " + (dmgRoll - player.getArmor()) + " damage";

       }
       else if (roll < missRoll){
           GameApp.enemyAttackText =  "The spider missed!";
       }
   }


}

