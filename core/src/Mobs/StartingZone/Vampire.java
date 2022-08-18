package Mobs.StartingZone;

import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.GameApp;

import java.util.Random;

public class Vampire extends Monster {

    int gold;
    double level;


    public Vampire(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level, int floor) {
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
    int vamp = 1;

    @Override
    public double getLevel() {
        return level;
    }

    @Override
    public void setLevel(double level) {
        this.level = level;
    }

    @Override
    public int getVamp() {
        return vamp;
    }

    @Override
    public void setVamp(int vamp) {
        this.vamp = vamp;
    }
    double maxHP = hp;

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }
    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            player.setHP(player.getHP() - monster.getDmg());
            monster.setHp(monster.getHp() + (monster.getDmg() * 0.4));
            GameApp.enemyAttackText = "The vampire bit you for " + (monster.getDmg() - player.getArmor()) + " points of damage thus healing himself for "
                    + (monster.getDmg()*0.4) + " damage";
        }
        else if (roll < 81 && roll > missRoll){
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("The vampire hit you for " + (dmgRoll - player.getArmor()) + " obrazen");
            GameApp.enemyAttackText = "The vampire hit you for " + (dmgRoll - player.getArmor()) + " damage";

        }
        else if (roll < missRoll){
            GameApp.enemyAttackText = "The vampire missed!";
        }
    }
}



