package Logic.FightLogic;

import Logic.FightLogic.Skills.*;
import Logic.GameLogic;
import Mobs.Monster;
import Mobs.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;

import java.util.Random;
import java.util.TimerTask;

import static com.badlogic.gdx.Gdx.*;
import static com.mygdx.game.Assets.runSpr;
import static com.mygdx.game.GameApp.*;


public class Fight {

    static final int BDMG = 80;
    public static boolean loaded = false;
    public static int joined = 1;
    public static int doubleStrike = 0;

    public static int ironSkinDuration;

    public static int adrenalineDuration;
    public static int fightON = 0;



public static boolean inputBlocked = false;
    public static boolean inputWait;
    public static boolean inputStop;


    void isFrozen(Player player) {
        if (player.getFreeze() > 0) {
            System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
        }
    }

    void render(){

    }
 /*   public static void StatusColors(Monster monster){
        Player.changePlayerStatusColor(Color.PURPLE, Dawid.getAdrenalineValue());
        Player.changePlayerStatusColor(Color.GRAY, Dawid.getIronSkinValue());
        Player.changePlayerStatusColor(Color.GREEN, Dawid.getPoison());

        Player.changeEnemyStatusColor(Color.BLUE, monster.getFreeze());
        Player.changeEnemyStatusColor(Color.GREEN, monster.getPoison());

    }*/

    public static void groupFight(Monster[] monsterTable, Player player) {





        Random random = new Random();
        if (doubleStrike == 0) {
            joined = 1;
           /* do {

                if ((GameLogic.monsterBase[joined].getX() - player.getX() == 1 || player.getX() - GameLogic.monsterBase[joined].getX() == 1) &&
                        (GameLogic.monsterBase[joined].getY() - player.getY() == 1 || player.getY() - GameLogic.monsterBase[joined].getY() == 1)
                ) {

                    int chance = random.nextInt(100);
                    if (chance > 91) {
                        System.out.println(GameLogic.monsterBase[joined].getName() + " dołączył do walki!");
                        doubleStrike = 1;
                        joined--;
                    }
                }
                joined++;
            } while (joined < 2 && doubleStrike == 0);*/
        }

    }

    public static int escape = 0;

    public static void Turn(Player player, Monster monster) throws InterruptedException {
/*

StatusColors(monster);
*/

if (monster.getHp() > 0){
    monster.setDropable(1);
}

if (monster.getPoison() > 0){
    Assets.poisonBMP.setSize(150,150);
}
else {
    Assets.poisonBMP.setSize(0,0);
}
if (monster.getFreeze() > 0){
    Assets.stunBMP.setSize(150,150);
}
else {
    Assets.stunBMP.setSize(0,0);
}
fightstart = 1;

if (fightscreenSP.getHeight() < 1070){
   FightLogic.hideAssets();


}
else if (fightscreenSP.getHeight() > 1079){
    FightLogic.showAssets();
    enemybar.setPosition(sprite.getX()+200,sprite.getY() - 30);
    enemybar.setSize(200,60);
    enemybargreen.setSize((float) (200*(monster.getHp()/monster.getMaxHP())), 60);
    enemybargreen.setPosition(sprite.getX() + 200,sprite.getY() - 30);
}

        escape = 0;
        if (fightstart == 1){

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    playerSprite.setRegion(0,0,40,100);
                }
            },200);
            batch.begin();
            battleStance.setSize(600,300);
            battleStance.setRegion(0,0,40,100);
            enemybargreen.draw(batch);
            enemybar.draw(batch);
            batch.end();
        }


        batch.begin();
        sprite.set(Monster.monsterSprites.get(monster.getMobType()));
        System.out.println(monster.getMobType());
        sprite.draw(batch);
        batch.end();

        int toxic = 0;
if (Dawid.getHP() <=0){

   FightLogic.Die(Dawid);

}
        int burnDMG = 40;

            groupFight(GameLogic.monsterBase, player);

            if (!inputBlocked) {

                if (Gdx.input.justTouched()) {
                    //unprojects the camera
                    camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

                    if (Fireball.sprite.getBoundingRectangle().contains(touchPoint.x, touchPoint.y) && Fireball.cooldown == 0 && Fireball.learned){
                        player.Fireball(monster,player);
                        attackConclude(Dawid, monster);
                        Fireball.animFire = true;
                    }
                    if (Heal.sprite.getBoundingRectangle().contains(touchPoint.x, touchPoint.y) && Heal.cooldown < 1 && Heal.learned){
                        player.Heal(Dawid);
                        attackConclude(Dawid, monster);

                    }
                    if (Icebolt.sprite.getBoundingRectangle().contains(touchPoint.x, touchPoint.y) && Icebolt.cooldown == 0 && Icebolt.learned){
                        player.Freeze(monster);
                        attackConclude(Dawid, monster);
                        Icebolt.animIce = true;
                    }
                    if (Adrenaline.sprite.getBoundingRectangle().contains(touchPoint.x, touchPoint.y) && Adrenaline.cooldown == 0 && Adrenaline.learned){
                        player.Adrenaline(Dawid);
                        attackConclude(Dawid, monster);
                    }
                    if (Ironskin.sprite.getBoundingRectangle().contains(touchPoint.x, touchPoint.y) && Ironskin.cooldown == 0 && Ironskin.learned){
                        player.IronSkin(Dawid);
                        attackConclude(Dawid, monster);

                    }
                    if (Autoattack.sprite.getBoundingRectangle().contains(touchPoint.x, touchPoint.y) && Autoattack.cooldown == 0 && Autoattack.learned){
                        player.Attack(monster,Dawid);

                        attackConclude(Dawid, monster);

                    }
                    if (Cleave.sprite.getBoundingRectangle().contains(touchPoint.x, touchPoint.y) && Cleave.cooldown == 0 && Cleave.learned){
                        player.Attack(monster,Dawid);
                        attackConclude(Dawid, monster);

                    }
                    if (runSpr.getBoundingRectangle().contains(touchPoint.x, touchPoint.y)){
                         Spells.runAway(Dawid,monster);
                    }


                }

                if (input.isKeyJustPressed(Input.Keys.NUM_1)) {

                    player.Attack(monster, player);
                    attackConclude(Dawid, monster);


                }


                if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
                   Spells.runAway(Dawid, monster);
                }

            }
            FightLogic.ConcludeBattle(player, monster, joined);


        }



    public static void EnemyAttack(Player player, Monster monster1) throws InterruptedException {


        if (monster1.getHp() > 0 && monster1.getFreeze() == 0) {
            monster1.Attack(monster1, player);

        } else if (monster1.getFreeze() > 0) {
            System.out.println(monster1.getName() + " jest zamrożony, nie może się ruszać przez " + monster1.getFreeze()
                    + " tury");
        }
    }

    public static void PlayerStatusWearOff(Player player) {

        if (player.getAdrenalineValue() > 0) {
            player.setDMG( (player.getDMG() - 60));
            player.setArmor(player.getArmor() + 40);
            player.setAdrenalineValue(0);
        }

        if (player.getIronSkinValue() > 0) {

            player.setArmor(player.getArmor() - 30);
            player.setIronSkinValue(0);
        }

        player.setFreeze(0);
        player.setPoison(0);

    }

    public static void attackConclude(final Player player, final Monster monster){
        inputBlocked = true;
        if (inputBlocked){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    inputBlocked = false;
                }
            },1400);
        }

    if (monster.getFreeze() == 0) {

       timer.schedule(new TimerTask() {
           @Override
           public void run() {
               try {
                   EnemyAttack(Dawid, monster);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       },1000);


    } else {
        Fonts.enemyAttackText = "Przeciwnik jest zamrożony na " + monster.getFreeze() + " tury!";
    }

    FightLogic.StatusConclude(player,monster);
}

}
