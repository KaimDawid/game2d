package Mobs.Cemetery;

import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter@Setter
public class Ghoul extends Monster {
    public Ghoul(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
    }
    public int statusAmount;
    @Override
    public int getGold() {
        return 0;
    }

    @Override
    public void setGold() {

    }
    public int mobType = 12;
    @Override
    public void setGold(int gold) {

    }
    public  int dropable = 1;
    double maxHP = hp;
    @Override
    public int getDropable() {
        return dropable;
    }

    @Override
    public void setDropable(int dropable) {
        this.dropable = dropable;
    }

    public void Attack(Monster monster, Player player) {
        Random random = new Random();
        int roll = random.nextInt(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        int armorUP = 20;
        if (roll > 80) {
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            monster.setDmg((int) (monster.getDmg() + (player.getMagic()) * 0.5));
            Fonts.enemyAttackText = "Ghoul has attacked you critically for " + monster.getDmg() * 1.2 + " damage!";
            Fonts.mobSpellText = "Ghoul has stolen half of your mana + " + (player.getMagic()*0.5) + " as his damage";

        } else if (roll < 81 && roll > missRoll) {
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("Ghoul has thrashed you for " + (dmgRoll - player.getArmor()) + " damage");
            Fonts.enemyAttackText = "Ghoul has thrashed you for " + (dmgRoll - player.getArmor()) + " damage";

        } else if (roll < missRoll) {
            Fonts.enemyAttackText = "Ghoul missed!!";
            System.out.println("Ghoul missed!");
        }
    }
}
