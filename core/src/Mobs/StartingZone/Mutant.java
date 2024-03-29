package Mobs.StartingZone;

import Logic.FightLogic.Skills.Autoattack;
import Logic.FightLogic.Skills.Fireball;
import Logic.FightLogic.Skills.Icebolt;
import Mobs.Monster;
import Mobs.Player;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.TimerTask;

import static com.mygdx.game.GameApp.timer;

@Getter@Setter
public class Mutant extends Monster {
    int gold;
    public Mutant(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
        this.gold = gold;

    }
    public  int dropable = 1;

    @Override
    public int getDropable() {
        return dropable;
    }

    @Override
    public void setDropable(int dropable) {
        this.dropable = dropable;
    }

    int activeSkill;

 int mutant = 1;
    double maxHP = hp;

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }
    public int getMutant() {
        return mutant;
    }

    public void setMutant(int mutant) {
        this.mutant = mutant;
    }

    @Override
    public int getPoisonInvulnerability() {
        return poisonInvulnerability;
    }

    @Override
    public void setPoisonInvulnerability(int poisonInvulnerability) {
        this.poisonInvulnerability = poisonInvulnerability;
    }
    public int mobType = 5;
    public int getActiveSkill() {
        return activeSkill;
    }

    public void setActiveSkill(int activeSkill) {
        this.activeSkill = activeSkill;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold() {

    }
    int poisonInvulnerability = 1;
    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }

    public int statusAmount;
    public void Freeze(Player target){
        double iceDMG = 25;

        Fonts.mobSpellText =   "Zostałeś zamrożony na 2 tury i otrzymałeś " + iceDMG + " obrażeń!";
            target.setHP(target.getHP() - 25);
            target.setFreeze(1);


    }
    public void Fireball(Monster monster, Player player){
        double fireDMG = 80;

            player.setHP(player.getHP() - fireDMG);
        Fonts.mobSpellText =   "Mutant skopiował Twój czar i rzucił w Ciebie kulą ognia za " + fireDMG + " obrażeń!";


    }

    void SkillSteal(Monster mutant, Player player){
        if (player.getChosenSkill3() != 0){
            activeSkill = player.getChosenSkill3();
        }
        else {
            if (player.getChosenSkill2() != 0) {
                activeSkill = player.getChosenSkill2();
            }
            else {
                activeSkill = player.getChosenSkill1();
            }
        }
    }

    public void Attack(final Monster monster, final Player player){

        Random random = new Random();
        int roll = random.nextInt(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            int skillSteal = random.nextInt(30);

            if (skillSteal < 11) {
                if (Fireball.learned){
                    Fireball(monster,player);
                    Fireball.animMobFire = true;
                    Soundtrack.fire.play();
                }
                else {
                    Autoattack.criticalMobAttack = true;
                    int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
                    System.out.println("Mutant uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń!");
                    player.setHP(player.getHP() - dmgRoll + player.getArmor());
                    Fonts.enemyAttackText = "Mutant uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń";
                }


            }
            else if (skillSteal > 10 && skillSteal < 21){
             if (Icebolt.learned){
                 Freeze(player);
             }
             else if (Icebolt.learned == false && Fireball.learned){
                 Fireball(monster,player);
                 Fireball.animMobFire = true;
                 Soundtrack.fire.play();
             }
             else {
                 int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
                 System.out.println("Mutant uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń!");
                 player.setHP(player.getHP() - dmgRoll + player.getArmor());
                 Fonts.enemyAttackText = "Mutant uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń";
             }

            }
            else if (skillSteal > 20) {
                if (Fireball.learned && Icebolt.learned) {
                    Freeze(player);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Fireball(monster, player);
                            Fireball.animMobFire = true;
                            Soundtrack.fire.play();
                        }
                    }, 500);
                }
                else {
                    Autoattack.criticalMobAttack = true;
                    int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
                    System.out.println("Mutant uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń!");
                    player.setHP(player.getHP() - dmgRoll + player.getArmor());
                    Fonts.enemyAttackText = "Mutant uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń";
                }
            }


        }
        else if (roll < 81 && roll > missRoll){
            Autoattack.animMobAttack = true;

            Soundtrack.thump.play();
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            System.out.println("Mutant uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń!");
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            Fonts.enemyAttackText = "Mutant uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń";
        }
        else if (roll < missRoll){
            Autoattack.mobMiss = true;
            Fonts.enemyAttackText = "Mutant chybił!";
        }

    }

}
