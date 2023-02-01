package Mobs.Cemetery;

import Logic.FightLogic.Skills.Autoattack;
import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter
@Setter
public class Ghost extends Monster {
    public Ghost(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
    }

    public int mobType = 11;
    public int statusAmount;
    @Override
    public int getGold() {
        return 0;
    }

    @Override
    public void setGold() {

    }
    double maxHP = hp;
    @Override
    public void setGold(int gold) {

    } public  int dropable = 1;

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
            Autoattack.criticalMobAttack = true;
            Autoattack.animMobAttack = true;
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            Fonts.enemyAttackText = "The Ghost has struck you critically for " + monster.getDmg() * 1.2 + " damage!";
            Soundtrack.thump.play();

        } else if (roll < 81 && roll > missRoll) {
            Autoattack.animMobAttack = true;
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("Szkielet uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń");
            Fonts.enemyAttackText = "The ghost has struck you for " + (dmgRoll - player.getArmor()) + " damage";
            Fonts.mobSpellText = "The ghost is translucent, making it far more difficult to hit him. ";
            Soundtrack.thump.play();
        } else if (roll < missRoll) { Autoattack.mobMiss = true;
            Fonts.enemyAttackText = "The ghost missed!";
            System.out.println("The ghost missed!");
        }
    }
}
