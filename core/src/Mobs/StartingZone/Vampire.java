package Mobs.StartingZone;

import Logic.FightLogic.Skills.Autoattack;
import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter@Setter
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
    public int dropable = 1;

    @Override
    public int getDropable() {
        return dropable;
    }

    @Override
    public void setDropable(int dropable) {
        this.dropable = dropable;
    }
    public int statusAmount;

    public int mobType = 3;
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
        int roll = random.nextInt(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){  Soundtrack.bite.play();
            Autoattack.criticalMobAttack = true;
            Autoattack.animMobAttack = true;
            player.setHP(player.getHP() - monster.getDmg());
            monster.setHp(monster.getHp() + (monster.getDmg() * 0.4));
            Fonts.enemyAttackText = "The vampire bit you for " + (monster.getDmg() - player.getArmor()) + " points of damage thus \n healing himself for "
                    + (monster.getDmg()*0.4) + " damage";
        }
        else if (roll < 81 && roll > missRoll){  Soundtrack.bite.play();
            Autoattack.animMobAttack = true;
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("The vampire hit you for " + (dmgRoll - player.getArmor()) + " obrazen");
            Fonts.enemyAttackText = "The vampire hit you for " + (dmgRoll - player.getArmor()) + " damage";

        }
        else if (roll < missRoll){
            Autoattack.mobMiss = true;
            Fonts.enemyAttackText = "The vampire missed!";
        }
    }
}



