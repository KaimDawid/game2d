package Mobs;


import Data.Quests.FlorekQuest;
import Data.Quests.Quests;
import Logic.FightLogic.Skills.*;
import Logic.Inventory;
import Mobs.Cemetery.CemeterySprites;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.Scanner;
import java.util.TimerTask;

import static Mobs.Monster.minotaurSPR;
import static com.mygdx.game.Backend.Soundtrack.*;
import static com.mygdx.game.GameApp.*;

@Getter @Setter

public class Player {
    public static int XPCap;

    public static int HPSWITCHED = 0;


   public static boolean healthSwapped;

    public static int getHPSWITCHED() {
        return HPSWITCHED;
    }

    public static void setHPSWITCHED(int HPSWITCHED) {
        Player.HPSWITCHED = HPSWITCHED;
    }

    public static boolean isHealthSwapped() {
        return healthSwapped;
    }

    public static void setHealthSwapped(boolean healthSwapped) {
        Player.healthSwapped = healthSwapped;
    }

    public static int ICE = 60;

    public static int Rogue;


    public final static int TP = 61;
    public final static int FIREBALL = 62;

    public final static int ADRENALINE = 63;

    public final static int IRONSKIN = 64;

    public final static int CLEAVE = 65;

    public final static int HEAL = 66;

    private double HP = 120;
    private double MaxHP = 120;
    int DMG = 20;
    public int XP;

    public double level = 0;
    int escapeInvulnerability = 0;


    public int X;
    public int Y;

    int floor = 1;


int toxify = 0;

    int gold;
    int bombNumber;
    int potionNumber;
    int armor;
    int poison;

    int burn;
    int maxMana = 100;

    int ironSkinValue = 0;
    int adrenalineValue = 0;



    int magic = 0;
    int classNumber;
    double mana;

    double manaRegen = 10;

int fear;

    public int getFear() {
        return fear;
    }

    public void setFear(int fear) {
        this.fear = fear;
    }

    public int chosenSkill1 = 0;
    public int chosenSkill2 = 0;
    public int chosenSkill3 = 0;
    public int chosenSkill4 = 0;
    public int chosenSkill5 = 0;

    public int chosenSkill6 = 0;

    public int chosenSkill7 = 0;

    public int chosenSkill8 = 0;


    public int chosenSkill9 = 0;



    public int chosenSkill10 = 0;

    int attributePoints;

int weaponCapacity = 1;

int decay = 0;


    public int getDecay() {
        return decay;
    }

    public void setDecay(int decay) {
        this.decay = decay;
    }

    int freeze = 0;

int GC;

    public int getGC() {
        return GC;
    }

    public void setGC(int GC) {
        this.GC = GC;
    }

    double critChance;


    public Player(double HP, double maxHP, int DMG, int XP, int level, int x, int y, int gold, int bombNumber, int potionNumber,
                  int armor) {
        this.HP = HP;
        MaxHP = maxHP;
        this.DMG = DMG;
        this.XP = XP;
        this.level = level;
        X = x;
        Y = y;
        this.gold = gold;
        this.bombNumber = bombNumber;
        this.potionNumber = potionNumber;
        this.armor = armor;
    }


    public void DualWield(Player player){
        player.setWeaponCapacity(2);
    }



    public void Freeze(Monster target) {
        double iceDMG = 25 + (0.25 * magic);
        double iceHeal = 25 - (0.25*magic);
        Random random = new Random();
        int fearValue = random.nextInt(100)*fear;
        if (fearValue < 51) {
            if (mana > 69) {
                ice.play();
                Icebolt.cooldown = 8;
                if (magic >= 0) {
                    Fonts.playerAttackText = target.getName() + " Has been frozen for 2 turns and received " + iceDMG + " damage";

                    target.setHp(target.getHp() - (DMG * 0.25));
                } else {
                    target.setHp(target.getHp() + iceHeal);
                    Fonts.playerAttackText = target.getName() + " Has been frozen for 2 turns and was healed for " + iceHeal + " HP";
                }
                target.setFreeze(3);
                mana = mana - 70;
            } else {
                Fonts.playerAttackText = "Not enough mana!";
            }
        }
        else {
            Fonts.playerAttackText = "You couldn't deliver a hit out of fear!";
        }
    }

    public void Teleport(Player player) {
        Scanner scanner = new Scanner(System.in);

        Fonts.topText = "Wubierz gdzie chcesz się przeteleportować.";
        System.out.println("Wybierz gdzie chcesz się przeteleportować.");
        System.out.println("X :");
        int inputX = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Y: ");
        int inputY = scanner.nextInt();
        scanner.nextLine();
        player.setX(inputX);
        player.setY(inputY);
        System.out.println("Twoje nowe koordynaty to: " + inputX + "," + inputY);

    }

    public void Heal(Player player){


            if (player.getMana() >= 60) {
                heal.play();
                double healValue = 300 + (player.getMagic() * 0.3);

                if (decay == 1){
                    player.setHP(player.getHP() + 300);
                }

                player.setMana(player.getMana() - 60);
                player.setHP(player.getHP() + healValue);
                changeColor(battleStance, Color.GREEN, 1500);
                double overHeal = (player.getHP() - player.getMaxHP());
                if (overHeal >= 0){
                    player.setHP(player.getHP() - overHeal);
                }
                Fonts.playerAttackText = "You've healed for "+ healValue;
                Heal.cooldown = 4;
            } else {
                Fonts.playerAttackText = "Not enough mana!";

            }

    }

    public void Fireball(Monster monster, Player player) {
        double fireDMG = 80 + magic;
        double fireHeal = 80 - magic;
        Random random = new Random();
        int fearValue = random.nextInt(100)*fear;
        if (fearValue < 51) {
            if (mana >= 50) {
                Soundtrack.fire.play();
                mana = mana - 50;
                Fireball.cooldown = 2;
                if (magic >= 0) {
                    monster.setHp(monster.getHp() - fireDMG);
                    setRedScreen();
                    Fonts.playerAttackText = "You've tossed a fireball for " + fireDMG + " damage!";
                } else {
                    monster.setHp(monster.getHp() + fireHeal);
                    Fonts.playerAttackText = "Your fireball healed your enemy for " + fireHeal + " HP!";
                }
            } else {
                Fonts.playerAttackText = "Not enough mana!";
            }
        } else {
            Fonts.playerAttackText = "You couldn't deliver a hit out of fear!";
        }
    }

    public void IronSkin(Player player) {
        String skillName = "Ironskin";
        int ironSkinValue = 30;
        if (player.getIronSkinValue() == 0) {
            Ironskin.cooldown = 5;
            Fonts.playerAttackText = "You've used " + skillName + " and received " + ironSkinValue + " armor points for 2 turns";

            player.setArmor(player.getArmor() + ironSkinValue);
            player.setIronSkinValue(1);
        }

    }


    public void Adrenaline(Player player) {

        String skillName = "Adrenalina";

        if (player.getAdrenalineValue() == 0) {
            Adrenaline.cooldown = 5;
            double adrenalineAttackValue = (player.getDMG() + 60);
            double adrenalineArmorValue = (player.getArmor() - 40);

            player.setDMG((int) adrenalineAttackValue);
            player.setArmor((int) adrenalineArmorValue);
            Fonts.playerAttackText = "Użyłeś umiejętności " + skillName + ", zadajesz więcej obrażeń ale sam jesteś bardziej podatny na obrażenia";

            player.setAdrenalineValue(1);
        }

        // 29% w dół

    }

    public void Cleave(Player player, Monster monster, Monster monster2) {

        Random random = new Random();
        int fearValue = random.nextInt(100)*fear;
        if (fearValue < 51) {
            Cleave.cooldown = 2;
            setRedScreen();
            player.setDMG(player.getDMG() + 20);
            Fonts.playerAttackText = "Bierzesz zamach i atakujesz obu wrogów naraz ze zwiększoną siłą \n Zadajesz obu potworom " + player.getDMG() + " obrażeń";

            player.Attack(monster, player);
            player.Attack(monster2, player);
            player.setDMG(player.getDMG() - 20);
        }
        else {
            Fonts.playerAttackText = "You couldn't deliver a hit out of fear!";
        }

    }

    public static int getRogue() {
        return Rogue;
    }

    public static void setRogue(int rogue) {
        Rogue = rogue;
    }

    public void Attack(Monster monster, Player player) {
        Random random = new Random();
        double missRoll = (20 - (player.getLevel() * 3) + (monster.getLevel() * 3));
        int roll = random.nextInt(100);
        double critRoll = (80 - player.getCritChance());

        int fearValue = random.nextInt(100)*fear;
        if (fearValue < 51) {
            if (roll > critRoll) {
                Fonts.missOrCritText = "CRIT!";
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Fonts.missOrCritText = "";
                    }
                },1200);
                swing.play();
                Autoattack.animAttack = true;
                setRedScreen();
                double dmgroll = (random.nextInt(20) + (player.getDMG() * 1.2) - 10);
                monster.setHp(monster.getHp() - (dmgroll + monster.getArmor()));
                Fonts.playerAttackText = "You landed a critical attack for " + dmgroll + " damage!";
                Assets.critBMP.setSize(150,150);
                GameApp.timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Assets.critBMP.setSize(0,0);
                    }
                },3000);
                if (monster.getArmor() > 0) {
                    System.out.println("Potwór zanegował " + monster.getArmor() + " obrażeń");
                }
                if (Rogue == 1) {
                    monster.setHp(monster.getHp() - (dmgroll + monster.getArmor()));
                    GameApp.playerAttackText2 = "You landed another critical attack for " + dmgroll + " damage!";
                }
                putToxin(player, monster);
            } else if (roll < critRoll && roll > missRoll) {
                Autoattack.animAttack = true;
                setRedScreen();
                swing.play();
                double dmgRoll = (random.nextInt(20) + player.getDMG() - 10);
                monster.setHp(monster.getHp() - dmgRoll + monster.getArmor());
                System.out.println("Zadales " + dmgRoll + " obrażeń");
                Fonts.playerAttackText = "You've dealt " + dmgRoll + " damage";
                if (Rogue == 1) {
                    monster.setHp(monster.getHp() - dmgRoll + monster.getArmor());

                    GameApp.playerAttackText2 = "You've dealt another " + dmgRoll + " damage";
                }

                if (monster.getArmor() > 0) {
                    System.out.println("Potwór zanegował " + monster.getArmor() + " obrażeń");
                }

                putToxin(player, monster);
            } else if (roll < missRoll) {
                Fonts.playerAttackText = "You missed!";
                Fonts.missOrCritText = "MISS!";
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Fonts.missOrCritText = "";
                    }
                },1200);
            }
        }
        else {
            Fonts.playerAttackText = "You couldn't deliver a hit out of fear!";
        }
    }



public static void putToxin(Player player, Monster monster) {


        if (Inventory.equippedweapon.getIsToxic() == 1) {
            Random random = new Random();
            int chance = random.nextInt(100);
            if (chance > 25 && Inventory.equippedweapon.getIsToxic() > 0 && monster.getPoisonInvulnerability() == 0) {
                monster.setPoison(3);
                Fonts.topText = "You've poisoned your enemy for 2 turns! He receives 30 damage each turn.";

                monster.setHp(monster.getHp() - 30);
            }
        }
}

private void setRedScreen(){

    sprite.setColor(Color.RED);
    Assets.mutantSPR.setColor(Color.RED);
    spiderSprite.setColor(Color.RED);
    Assets.wolfSPR.setColor(Color.RED);
    Assets.vampireSPR.setColor(Color.RED);
    goblinSprite.setColor(Color.RED);
    Assets.werewolfSPR.setColor(Color.RED);
    Monster.whiteKnightSPR.setColor(Color.RED);
    Quests.gabiSPR.setColor(Color.RED);
    FlorekQuest.crayfishSPR.setColor(Color.RED);
    CemeterySprites.ghoulSPR.setColor(Color.RED);
    CemeterySprites.skeletonSPR.setColor(Color.RED);
    CemeterySprites.ghostSPR.setColor(Color.RED);
    CemeterySprites.lumpOfFleshSPR.setColor(Color.RED);
    CemeterySprites.headlessHorsemanSPR.setColor(Color.RED);
    minotaurSPR.setColor(Color.RED);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                FlorekQuest.crayfishSPR.setColor(originalColor);
                sprite.setColor(originalColor);
                Assets.mutantSPR.setColor(originalColor);
                spiderSprite.setColor(originalColor);
                Assets.wolfSPR.setColor(originalColor);
                Assets.vampireSPR.setColor(originalColor);
                goblinSprite.setColor(originalColor);
                Assets.werewolfSPR.setColor(originalColor);
                Monster.whiteKnightSPR.setColor(originalColor);
                Quests.gabiSPR.setColor(originalColor);
                CemeterySprites.ghoulSPR.setColor(originalColor);
                CemeterySprites.skeletonSPR.setColor(originalColor);
                CemeterySprites.ghostSPR.setColor(originalColor);
                CemeterySprites.lumpOfFleshSPR.setColor(originalColor);
                CemeterySprites.headlessHorsemanSPR.setColor(originalColor);
                minotaurSPR.setColor(originalColor);
            }
        },1500);
}

private void changeColor(final Sprite sprite, Color destinedColor, int duration){
        sprite.setColor(destinedColor);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sprite.setColor(GameApp.originalColor);
            }
        }, (long) duration);
}

public static void changeStatusColor(Sprite sprite, Color destinedColor, Color originalColor, int status){
        if (status > 0){
            sprite.setColor(destinedColor);
        }
        else if (status == 0){
            sprite.setColor(originalColor);
        }


}
    public static void changeEnemyStatusColor(Color destinedColor, Color originalColor, int status){
        if (status > 0){
            sprite.setColor(destinedColor);
            Assets.mutantSPR.setColor(destinedColor);
            spiderSprite.setColor(destinedColor);
            Assets.wolfSPR.setColor(destinedColor);
            Assets.vampireSPR.setColor(destinedColor);
            goblinSprite.setColor(destinedColor);
            Assets.werewolfSPR.setColor(destinedColor);
        }
        else if (status == 0){
            sprite.setColor(GameApp.originalColor);
        }


    }

/*public static void putToxin(Player player, Monster monster){
        Random random = new Random();
        int chance = random.nextInt(100);
        if (chance > 80 && player.getToxify() > 0){
            monster.setPoison(3);
            System.out.println("Zatrułeś swojego przeciwnika na 2 tury! Otrzymuje on 30 obrażeń co turę.");
            monster.setHp(monster.getHp() - 30);
        }
    }*/

}
