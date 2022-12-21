package Mobs.Dungeon;

import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Frontend.Fonts;

import java.util.Random;

public class Minotaur extends Monster {

    public Minotaur(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
    }
    public int statusAmount;
    @Override
    public int getGold() {
        return 0;
    }
    double maxHP = hp;
    public int dropable = 1;

    @Override
    public int getDropable() {
        return dropable;
    }

    @Override
    public void setDropable(int dropable) {
        this.dropable = dropable;
    }

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }
    @Override
    public void setGold() {

    }

    @Override
    public void setGold(int gold) {

    }
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            Fonts.enemyAttackText = "Minotaur zadał cios krytyczny za "+ monster.getDmg()*1.2 + " punktów obrażeń!";
        }
        else if (roll < 81 && roll > missRoll){
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll+ player.getArmor());
            System.out.println("Minotaur uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń");
            Fonts.enemyAttackText = "Minotaur Cię za " + (dmgRoll - player.getArmor()) + " obrażeń";
        }
        else if (roll < missRoll){
            Fonts.enemyAttackText = "Minotaur chybił!";
        }
    }


}
