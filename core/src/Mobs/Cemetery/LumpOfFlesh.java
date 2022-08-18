package Mobs.Cemetery;

import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.GameApp;

import java.util.Random;

public class LumpOfFlesh extends Monster {
    public LumpOfFlesh(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
    }

    @Override
    public int getGold() {
        return 0;
    }

    @Override
    public void setGold() {

    }

    @Override
    public void setGold(int gold) {

    }
    public void Attack(Monster monster, Player player) {
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        int armorUP = 20;
        double G = monster.getHp();
        double F = player.getHP();
        if (roll > 80) {
            player.setHP(G);
            monster.setHp(F);
            monster.setArmor(50);
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());

            GameApp.mobSpellText = "The lump of flesh swapped your health points with his and gained 50 armor";

        } else if (roll < 81 && roll > missRoll) {
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            monster.setHp(monster.getHp() + player.getArmor());

            GameApp.enemyAttackText = "Your enemy licked you for " + (dmgRoll - player.getArmor()) + " damage \n and healed for " + player.getArmor() + " equivalent to your armor";

        } else if (roll < missRoll) {
            GameApp.enemyAttackText = "He missed!";
            System.out.println("He missed!");
        }
    }
}
