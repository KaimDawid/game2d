package Mobs.Cemetery;

import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter
@Setter
public class HeadlessHorseman extends Monster {
    public HeadlessHorseman(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
    }

    @Override
    public int getGold() {
        return 0;
    }
    public int statusAmount;
    @Override
    public void setGold() {

    }
    public int mobType = 13;
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
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        int armorUP = 20;
        if (roll > 80) {
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            player.setFear(1);
            Fonts.enemyAttackText = "The headless horseman slashed you critically for " + monster.getDmg() * 1.2 + " damage and applied fear!";

        } else if (roll < 81 && roll > missRoll) {
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("Szkielet uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń");
            Fonts.enemyAttackText = "The headless horseman trampled you you for " + (dmgRoll - player.getArmor()) + " obrażeń";

        } else if (roll < missRoll) {
            Fonts.enemyAttackText = "The headless horseman missed!";
            System.out.println("The headless horseman missed!");
        }
    }
}
