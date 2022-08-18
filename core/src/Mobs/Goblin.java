package Mobs;


import com.mygdx.game.GameApp;

import java.util.Random;

public class Goblin extends Monster {

    int gold;


    public Goblin(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
        this.gold = gold;

    }
int glb = 1;

    @Override
    public int getGlb() {
        return glb;
    }

    @Override
    public void setGlb(int glb) {
        this.glb = glb;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold() {

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

    public void Attack(Monster monster, Player player) {
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80) {
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            GameApp.enemyAttackText = ("The goblin stabbed you critically for " + monster.getDmg() * 1.2 + " damage!");
        } else if (roll < 81 && roll > missRoll) {
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() -dmgRoll + player.getArmor());
            System.out.println("Goblin uderzył Cię za " + (dmgRoll - player.getArmor())  + " obrażeń");
            GameApp.enemyAttackText = "The goblin hit you for" + (dmgRoll - player.getArmor()) + " damage";
        } else if (roll < missRoll) {
            GameApp.enemyAttackText = ("The goblin missed!");
        }
    }
}


