package Mobs;

import Logic.Drop.Miscelanous;
import com.mygdx.game.GameApp;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter @Getter
public class BanditChief extends Monster {
    int gold;

    int bandchief = 1;

    public int getBandchief() {
        return bandchief;
    }

    public void setBandchief(int bandchief) {
        this.bandchief = bandchief;
    }

    public BanditChief(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
        this.gold = gold;

    }

    @Override
    public void Drop(){

        Miscelanous.banditsKilled++;
        GameApp.topText = "You've slain a thief for a total of " + Miscelanous.banditsKilled + "/" + Miscelanous.bkRequirement;

        dropNeck();
        dropWeapon();
        dropGloves();
        dropArmor();
        dropHelmet();

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
            double critHit = (random.nextInt(20) + monster.getDmg()*1.2);
            player.setHP(player.getHP() - critHit + player.getArmor());
            GameApp.enemyAttackText = ("The bandit chief sliced you critically for " + critHit + " damage!");
        } else if (roll < 81 && roll > missRoll) {
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() -dmgRoll + player.getArmor());
            System.out.println("The bandit chief hit you for " + (dmgRoll - player.getArmor())  + " damage");
            GameApp.enemyAttackText = "The bandit chief hit you for " + (dmgRoll - player.getArmor()) + " damage";
        } else if (roll < missRoll) {
            GameApp.enemyAttackText = ("The thug missed!");
        }
    }


}
