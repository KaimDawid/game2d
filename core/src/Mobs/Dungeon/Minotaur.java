package Mobs.Dungeon;

import Data.Quests.RusakovQuest;
import Logic.Camera;
import Logic.FightLogic.Fight;
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
    }
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        int roll = random.nextInt(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            Soundtrack.minotaursound.play();
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            Fonts.enemyAttackText = "Minotaur zadał cios krytyczny za "+ monster.getDmg()*1.2 + " punktów obrażeń!";
        }
        else if (roll < 81 && roll > missRoll){
            Soundtrack.minotaursound.play();
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll+ player.getArmor());
            System.out.println("Minotaur uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń");
            Fonts.enemyAttackText = "Minotaur Cię za " + (dmgRoll - player.getArmor()) + " obrażeń";
        }
        else if (roll < missRoll){
            Fonts.enemyAttackText = "Minotaur chybił!";
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
