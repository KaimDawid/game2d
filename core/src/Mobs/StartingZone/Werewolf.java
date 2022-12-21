package Mobs.StartingZone;


import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter@Setter
public class Werewolf extends Monster{
    int gold;
    public Werewolf(int hp, int dmg, double x, double y, String name, int giveXP,int gold, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
        this.gold = gold;
    }
    public int mobType = 2;
    int wewolf = 1;
    public int statusAmount;
    @Override
    public int getWewolf() {
        return wewolf;
    }

    @Override
    public void setWewolf(int wewolf) {
        this.wewolf = wewolf;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold() {

    }
    double maxHP = hp;
    public int dropable = 1;

    public int getDropable() {
        return dropable;
    }

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
    public void setGold(int gold) {

    }
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){  Soundtrack.bite.play();
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            Fonts.enemyAttackText = "The werewolf hit you critically for "+ (monster.getDmg()*1.2 - player.getArmor()) + " damage!";
        }
        else if (roll < 81 && roll > missRoll){  Soundtrack.bite.play();
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            Fonts.enemyAttackText = "The werewolf bit you for " + (dmgRoll - player.getArmor()) + " damage";

        }
        else if (roll < missRoll){
            Fonts.enemyAttackText = "The werewolf missed!";
        }
    }
}

