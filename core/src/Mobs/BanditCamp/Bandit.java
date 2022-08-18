package Mobs.BanditCamp;

import Logic.Drop.Miscelanous;
import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.GameApp;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter @Setter
public class Bandit extends Monster {
    int gold;
    int band = 1;

    public int getBand() {
        return band;
    }
    double maxHP = hp;

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }
    public void setBand(int band) {
        this.band = band;
    }

    public Bandit(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
        this.gold = gold;

    }

    @Override
    public void Drop(){



            Miscelanous.banditsKilled++;
            System.out.println("Udało Ci się zgładzić bandytę, zabiłeś ich już " + Miscelanous.banditsKilled + "/" + Miscelanous.bkRequirement);

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
            double critHit2 = (random.nextInt(20) + monster.getDmg()*1.2);
            player.setHP(player.getHP() - critHit + player.getArmor());
            GameApp.enemyAttackText = ("The thug stabbed you twice critically for " + critHit + " and " + critHit2 + " damage!");
        } else if (roll < 81 && roll > missRoll) {
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() -dmgRoll + player.getArmor());
            int dmgRoll2 = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() -dmgRoll + player.getArmor());
            GameApp.enemyAttackText = ("The thug stabbed you twice for " + (dmgRoll - player.getArmor()) + " and " + (dmgRoll2 - player.getArmor())  + " damage");

        } else if (roll < missRoll) {
            GameApp.enemyAttackText = ("The thug missed!");
        }
    }
}
