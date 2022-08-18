package Mobs.Dungeon;


import Logic.Status.Status;
import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.GameApp;

import java.util.Random;

public class Imp extends Monster {

    int gold;

    public Imp(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
        this.gold = gold;

    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold() {

    }

    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }
    double maxHP = hp;

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            Status.BURN(player);
GameApp.mobSpellText = "The imp has set you ablaze!";

        }
        else if (roll < 81 && roll > missRoll){
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("The imp tossed a fireball at you for " + (dmgRoll - player.getArmor()) + " damage");
            GameApp.enemyAttackText = "The imp tossed a fireball at you for " + (dmgRoll - player.getArmor()) + " damage";
        }
        else if (roll < missRoll){
            GameApp.enemyAttackText = "The imp missed!";
        }
    }

}