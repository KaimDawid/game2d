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
public class Goblin extends Monster {

    int gold;

    public int statusAmount;
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
    public  int dropable = 1;
    public int mobType = 4;
    @Override
    public int getDropable() {
        return dropable;
    }

    @Override
    public void setDropable(int dropable) {
        this.dropable = dropable;
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
        int roll = random.nextInt(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80) {Soundtrack.thump.play();
            Autoattack.criticalMobAttack = true;
            Autoattack.animMobAttack = true;
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            Fonts.enemyAttackText = ("The goblin stabbed you critically for " + monster.getDmg() * 1.2 + " damage!");
        } else if (roll < 81 && roll > missRoll) { Soundtrack.thump.play();
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            Autoattack.animMobAttack = true;
            player.setHP(player.getHP() -dmgRoll + player.getArmor());
            System.out.println("Goblin uderzył Cię za " + (dmgRoll - player.getArmor())  + " obrażeń");
            Fonts.enemyAttackText = "The goblin hit you for" + (dmgRoll - player.getArmor()) + " damage";
        } else if (roll < missRoll) {
            Autoattack.mobMiss = true;
            Fonts.enemyAttackText = ("The goblin missed!");
        }
    }
}


