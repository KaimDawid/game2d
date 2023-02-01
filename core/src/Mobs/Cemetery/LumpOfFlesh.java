package Mobs.Cemetery;

import Logic.FightLogic.Skills.Autoattack;
import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Assets;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

import static com.mygdx.game.GameApp.Dawid;
@Getter
@Setter
public class LumpOfFlesh extends Monster {
    public LumpOfFlesh(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
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
    public int dropable = 1;
    public int mobType = 14;
    @Override
    public int getDropable() {
        return dropable;
    }
    double maxHP = hp;
    @Override
    public void setDropable(int dropable) {
        this.dropable = dropable;
    }

    @Override
    public void setGold(int gold) {

    }
    public void Attack(Monster monster, Player player) {
        Random random = new Random();
        int roll = random.nextInt(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        int armorUP = 20;
        double G = monster.getHp();
        double F = player.getHP();
        if (roll > 80) {
            Soundtrack.bite.play();
            Autoattack.criticalMobAttack = true;

            double difference = monster.getHp() - player.getMaxHP();

            Autoattack.animMobAttack = true;
            player.setHP(G);
            monster.setHp(F);
            monster.setArmor(50);
            if (difference > 0){
          player.setHP(player.getMaxHP() - difference);
            }

            if (Dawid.isHealthSwapped() == false) {
                Dawid.setHealthSwapped(true);
            } else {
                Dawid.setHealthSwapped(false);
            }

            Fonts.mobSpellText = "The lump of flesh swapped your health points with his and gained 50 armor";
        }
        else if (roll < 81 && roll > missRoll) {
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            monster.setHp(monster.getHp() + player.getArmor());
            Autoattack.animMobAttack = true;
            Fonts.enemyAttackText = "The lump of flesh licked you for " + (dmgRoll - player.getArmor()) + " damage \n and healed for " + player.getArmor() + " equivalent to your armor";
            Soundtrack.bite.play();
        } else if (roll < missRoll) {
            Autoattack.mobMiss = true;
            Fonts.enemyAttackText = "The lump of flesh missed!";
            System.out.println("The lump of flesh missed!");

        }
    }
}
