package Mobs;

import com.mygdx.game.GameApp;
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
int wolv = 1;

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

            GameApp.enemyAttackText = "The wolf wounded you deeply for "+ (monster.getDmg()*1.2 - player.getArmor()) + " damage!";
            GameApp.hbSPR.setSize((float) (320*(player.getHP()/player.getMaxHP())), GameApp.hbSPR.getHeight());
        }
        else if (roll < 81 && roll > missRoll){
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("Wilołak ugryzł Cię za " + (dmgRoll - player.getArmor()) + " damage");
            GameApp.enemyAttackText = "The wolf bit you for " + (dmgRoll - player.getArmor()) + " damage";

            GameApp.hbSPR.setSize((float) (320*(player.getHP()/player.getMaxHP())), GameApp.hbSPR.getHeight());
        }
        else if (roll < missRoll){
            GameApp.enemyAttackText =  "The wolf missed!";
        }
    }
}
