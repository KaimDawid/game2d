package Mobs.Beach;

import Data.Quests.FlorekQuest;
import Data.Quests.Quests;
import Logic.Drop.Miscelanous;
import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter@Setter
public class Crayfish extends Monster {

    int mobType = 6;


    public int getMobType() {
        return mobType;
    }

    public void setMobType(int mobType) {
        this.mobType = mobType;
    }

    int gold;
        public Crayfish(int hp, int dmg, double x, double y, String name, int giveXP,int gold, double level, int floor) {
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
        public void Drop(){
            Quests.sideDescription = "Crayfish: " + Miscelanous.crayfishKilled + "/" + Miscelanous.crayFishRequirement;
            Miscelanous.crayfishKilled++;
            System.out.println("test");
            FlorekQuest.florekDescription = "test";
            dropNeck();
            dropWeapon();
            dropGloves();
            dropArmor();
            dropHelmet();


        }
        public int statusAmount;



        double maxHP = hp;

        public double getMaxHP() {
            return maxHP;
        }
        public int dropable = 1;

        public int getDropable() {
            return dropable;
        }

        public void setDropable(int dropable) {
            this.dropable = dropable;
        }

        public void setMaxHP(double maxHP) {
            this.maxHP = maxHP;
        }
        @Override
        public void setGold(int gold) {

        }
        public void Attack(Monster monster, Player player){
            Random random = new Random();
            int roll = random.nextInt(100);
            double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
            if (roll > 80){
                player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
                Fonts.enemyAttackText = "The crayfish wounded you deeply for "+ (monster.getDmg()*1.2 - player.getArmor()) + " damage!";
                Soundtrack.smallbite.play();
            }
            else if (roll < 81 && roll > missRoll){
                int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
                player.setHP(player.getHP() - dmgRoll + player.getArmor());
                System.out.println("The crayfish hit you for " + (dmgRoll - player.getArmor()) + " damage");
                Fonts.enemyAttackText = "The crayfish bit you for " + (dmgRoll - player.getArmor()) + " damage";
                Soundtrack.smallbite.play();

            }
            else if (roll < missRoll){
                Fonts.enemyAttackText =  "The crayfish missed!";
            }
        }


}
