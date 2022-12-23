package Mobs.Cemetery;

import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter
@Setter
public class Skeleton extends Monster {
    public int mobType = 15;
    int gold;
    public int statusAmount;
    int armor;
    
    int poisonInvulnerability = 1;
    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public Skeleton(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level, int floor) {
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
    public int dropable = 1;

    @Override
    public int getDropable() {
        return dropable;
    }

    @Override
    public void setDropable(int dropable) {
        this.dropable = dropable;
    }

    @Override
    public int getPoisonInvulnerability() {
        return poisonInvulnerability;
    }

    @Override
    public void setPoisonInvulnerability(int poisonInvulnerability) {
        this.poisonInvulnerability = poisonInvulnerability;
    }

    public void Attack(Monster monster, Player player) {
        Random random = new Random();
        int roll = random.nextInt(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        int armorUP = 20;
        if (roll > 80) {
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            Fonts.enemyAttackText = "Przeciwnik zadał cios krytyczny za " + monster.getDmg() * 1.2 + " punktów obrażeń!";
            Fonts.mobSpellText = "Szkielet podniósł wartość swojej zbroi o " + armorUP + " punktów.";

        } else if (roll < 81 && roll > missRoll) {
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("Szkielet uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń");
            Fonts.enemyAttackText = "Szkielet uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń";

        } else if (roll < missRoll) {
            Fonts.enemyAttackText = "Szkielet chybił!";
            System.out.println("Szkielet chybił!");
        }
    }

}
