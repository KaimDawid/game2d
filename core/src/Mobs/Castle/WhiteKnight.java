package Mobs.Castle;

import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter@Setter
public class WhiteKnight extends Monster {
    public int mobType = 9;
    int whk = 1;
    public WhiteKnight(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
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
    double maxHP = hp;
    public void Attack(Monster monster, Player player){

        Random random = new Random();
        int roll = random.nextInt(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            Soundtrack.banditswing.play();
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            Fonts.enemyAttackText = ("The White Knight bashed you critically for " + monster.getDmg() * 1.2 + " points of damage!");

        }
        else if (roll < 81 && roll > missRoll){
            Soundtrack.banditswing.play();
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            System.out.println("The White Knight slashed you for " + (dmgRoll - player.getArmor()) + " points of damage!");
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            Fonts.enemyAttackText = "The White Knight slashed you for " + (dmgRoll - player.getArmor()) + " points of damage!";
        }
        else if (roll < missRoll){
            Fonts.enemyAttackText = "The White Knight missed!";
        }

    }

}
