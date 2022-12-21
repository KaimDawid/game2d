package Mobs;

import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter @Setter
public class Wolf extends Monster{
    int gold;
    public Wolf(int hp, int dmg, double x, double y, String name, int giveXP,int gold, double level, int floor) {
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
    public int statusAmount;
int wolv = 1;
    public int mobType = 1;
    public int getWolv() {
        return wolv;
    }

    public void setWolv(int wolv) {
        this.wolv = wolv;
    }
    double maxHP = hp;

    public double getMaxHP() {
        return maxHP;
    }
    public int dropable = 1;

    public int getDropable() {
        return dropable;
    }

    public void setDropable(int dropable) {
        this.dropable = dropable;
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
        if (roll > 80){
            Soundtrack.bite.play();
            Fonts.enemyAttackText = "The wolf wounded you deeply for "+ (monster.getDmg()*1.2 - player.getArmor()) + " damage!";
        player.setHP(player.getHP() - (monster.getDmg()*1.2 - player.getArmor()));
        }
        else if (roll < 81 && roll > missRoll){
            Soundtrack.bite.play();
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("Wilołak ugryzł Cię za " + (dmgRoll - player.getArmor()) + " damage");
            Fonts.enemyAttackText = "The wolf bit you for " + (dmgRoll - player.getArmor()) + " damage";


        }
        else if (roll < missRoll){
            Fonts.enemyAttackText =  "The wolf missed!";
        }
    }
}
