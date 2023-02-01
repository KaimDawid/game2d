package Mobs.Dungeon;

import Data.Quests.RusakovQuest;
import Logic.Camera;
import Logic.FightLogic.Fight;
import Logic.FightLogic.Skills.Autoattack;
import Logic.FightLogic.Skills.Fireball;
import Logic.FightLogic.Skills.MobSkills;
import Logic.FightLogic.Skills.Stun;
import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.minotaur;
@Getter@Setter
public class Minotaur extends Monster {

    public int mobType = 16;

    public Minotaur(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
    }
    public int statusAmount;
    @Override
    public int getGold() {
        return 0;
    }
    double maxHP = hp;
    public int dropable = 1;

    @Override
    public int getDropable() {
        return dropable;
    }

    @Override
    public void setDropable(int dropable) {
        this.dropable = dropable;
    }

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }
    @Override
    public void setGold() {

    }

    @Override
    public void setGold(int gold) {

    }
    public void Drop(){

        dropNeck();
        dropWeapon();
        dropGloves();
        dropArmor();
        dropHelmet();
        if (RusakovQuest.questStage!=4){
            RusakovQuest.questStage = 3;
        }
        Dawid.setX(17);
        Dawid.setY(4);
    }
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        int roll = random.nextInt(100);
        double missRoll = 10;
        if (roll >= 75){
            if (player.getStun() == -4) {
                player.setStun(3);

                Stun.animStun = true;
                MobSkills.animThunder = true;
                Soundtrack.thunder.play();
                player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
                Fonts.enemyAttackText = "The minotaur has tossed a thunder bolt at you \n for" + monster.getDmg() * 1.2 + " points " +
                        "of damage and stunned you for 3 turns!";

            }
            else {
                Soundtrack.minotaursound.play();
                Autoattack.criticalMobAttack = true;
                int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
                Autoattack.animMobAttack = true;
                player.setHP(player.getHP() - dmgRoll+ player.getArmor());
                System.out.println("Minotaur uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń");
                Fonts.enemyAttackText = "The Minotaur striked you for " + (dmgRoll - player.getArmor()) + " points of damage!";
            }
        }
        else if (roll < 75 && roll >= 50){
            player.setBurn(3);
            player.setHP(player.getHP() - (monster.getDmg()));
            Fireball.animMobFire = true;
            Soundtrack.fire.play();
            Fonts.enemyAttackText = "The minotaur hurled a fireball at you for " + (monster.getDmg() * 0.8) + "\n" +
                    "points of damage and set you ablaze!";
            Soundtrack.minotaursound.play();


        }
        else if (roll < 50 && roll >= 41){
            if (Dawid.getDecay() == 0) {
                Soundtrack.minotaursound.play();

                player.setDecay(1);
                Fonts.enemyAttackText = "The minotaur placed a lethal curse on you, draining \n" +
                        "your health quickly!";
                MobSkills.animPoison = true;
            }
            else {
                player.setBurn(3);
                player.setHP(player.getHP() - (monster.getDmg()));
                Fireball.animMobFire = true;
                Soundtrack.fire.play();
                Fonts.enemyAttackText = "The minotaur hurled a fireball at you for " + (monster.getDmg() * 0.8) + "\n" +
                        "points of damage and set you ablaze!";
                Soundtrack.minotaursound.play();
            }
        }
        else if (roll < 41 && roll >= 10){
            Soundtrack.minotaursound.play();
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll+ player.getArmor());
            Autoattack.animMobAttack = true;
            Fonts.enemyAttackText = "The Minotaur striked you for " + (dmgRoll - player.getArmor()) + " points of damage!";
        }
        else if (roll < 10){
            Autoattack.mobMiss = true;
            Fonts.enemyAttackText = "The minotaur missed!";
        }
    }
public static void FightMinotaur(){
    if (GameApp.fightscreenSP.getHeight() < 1079) {

        if (Camera.X == 0) {
            Camera.X = 200;
        }
        GameApp.enemybar.setSize(0, 0);
        GameApp.enemybargreen.setSize(0, 0);
        GameApp.sprite.setSize(0, 0);
        GameApp.transitionIn = true;
    }

    GameApp.fightON = 1;
    GameApp.fightstart = 1;

    Fonts.topText = "Fight!";
    Fonts.leftText = " ";


    if (GameApp.fightON == 1) {

        try {
            Fight.Turn(Dawid, minotaur);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        currentTarget = minotaur;
    }
}

}
