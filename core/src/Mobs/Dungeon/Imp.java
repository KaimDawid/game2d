package Mobs.Dungeon;


import Logic.FightLogic.Skills.Autoattack;
import Logic.Status.Status;
import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter@Setter
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
    public int dropable = 1;

    @Override
    public int getDropable() {
        return dropable;
    }

    @Override
    public void setDropable(int dropable) {
        this.dropable = dropable;
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
        int roll = random.nextInt(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            Autoattack.criticalMobAttack = true;
            Autoattack.animMobAttack = true;
            Status.BURN(player);
Fonts.mobSpellText = "The imp has set you ablaze!";

        }
        else if (roll < 81 && roll > missRoll){
            Autoattack.animMobAttack = true;
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("The imp tossed a fireball at you for " + (dmgRoll - player.getArmor()) + " damage");
            Fonts.enemyAttackText = "The imp tossed a fireball at you for " + (dmgRoll - player.getArmor()) + " damage";
        }
        else if (roll < missRoll){
            Autoattack.mobMiss = true;
            Fonts.enemyAttackText = "The imp missed!";
        }
    }

}
