package Logic.FightLogic.Skills;

import Logic.FightLogic.Fight;
import Logic.Movement;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.SpriteTouchable;
import lombok.Getter;
import lombok.Setter;

import java.util.TimerTask;

import static com.badlogic.gdx.graphics.Color.RED;
import static com.mygdx.game.Frontend.Fonts.impactFont;
import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.batch;

@Getter@Setter
public class Autoattack  extends Spells {
    public static Texture texture, attackTXT, attack2TXT, critTXT, missTXT;
    public static Sprite sprite, attackSPR, mobAttackSPR, critSPR, critMobSPR, missSPR, missMobSPR;
    public static boolean learned = true;
    public static int cooldown;
public static BitmapFont cooldownBMP;
    public static boolean animAttack;
    public static int attackValue, movedFrames, finalframes = 50;
    public static boolean animMobAttack;
    public static int movedFrames2, mobAttackX;
    public static boolean criticalAttack, criticalMobAttack, miss, mobMiss;

    public static void create(){

        texture = new Texture("attackbutton.png");
        sprite = new Sprite(texture);
        attack2TXT = new Texture("attackanim2.png");
        attackTXT = new Texture("attackanim.png");
        critTXT = new Texture("crit.png");
        critMobSPR = new Sprite(critTXT);
        missTXT = new Texture("miss.png");
        missSPR = new Sprite(missTXT);
        missMobSPR = new Sprite(missTXT);
        critSPR = new Sprite(critTXT);
        missSPR.setSize(360,360);
        missMobSPR.setSize(360,360);
        critSPR.setSize(500,500);
        critMobSPR.setSize(500,500);
        attackSPR = new Sprite(attack2TXT);
        mobAttackSPR = new Sprite(attackTXT);
        mobAttackSPR.setSize(420,420);
        attackSPR.setSize(420,420);
        sprite.setSize(200,60);
        cooldownBMP = Fonts.Impact.generateFont(impactFont);
        cooldownBMP.setColor(RED);
        cooldownBMP.getData().setScale(0.8F);

    }

    public static void render(){

        sprite.setPosition(playerSprite.getX()-450, playerSprite.getY()-250);
        if (fightstart == 1 && learned && fightscreenSP.getHeight()>800){

            sprite.draw(batch);

        }

    }

    public static void animateAttack(){

        if (animAttack) {
            Fight.inputBlocked = true;
            attackSPR.draw(batch);


            do {
                attackValue = 0;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        attackValue = attackValue - 1;
                        if (movedFrames < finalframes) {
                            System.out.println("dodaję wartość");
                            movedFrames++;
                        }  else if (movedFrames ==finalframes) {
                            animAttack = false;
                            movedFrames = 0;
                            Fight.inputBlocked = false;
                            System.out.println("koniec animaji");

                        }
                        if (movedFrames < finalframes*0.1){
                            attackSPR.setRegion(70,0,70,70);
                            attackSPR.setPosition(battleStance.getX()+1050,battleStance.getY()+50);
                        }
                        if (movedFrames > finalframes*0.1 && movedFrames < finalframes*0.2){
                            attackSPR.setRegion(140,0,70,70);
                            attackSPR.setPosition(battleStance.getX()+1050,battleStance.getY()+50);
                        }
                        if (movedFrames > finalframes*0.2 && movedFrames < finalframes*0.3){
                            attackSPR.setRegion(210,0,70,70);
                            attackSPR.setPosition(battleStance.getX()+1050,battleStance.getY()+50);
                        }
                        if (movedFrames > finalframes*0.3 && movedFrames < finalframes*0.4){
                            attackSPR.setRegion(280,0,70,70);
                            attackSPR.setPosition(battleStance.getX()+1050,battleStance.getY()+50);
                        }
                        if (movedFrames > finalframes*0.4 && movedFrames < finalframes * 0.5){
                            attackSPR.setRegion(0,70,70,70);
                            attackSPR.setPosition(battleStance.getX()+1050,battleStance.getY()+50);
                        }
                        if (movedFrames > finalframes*0.5 && movedFrames < finalframes*0.6){
                            attackSPR.setRegion(70,70,70,70);
                            attackSPR.setPosition(battleStance.getX()+1050,battleStance.getY()+50);
                        }
                        if (movedFrames > finalframes*0.6 && movedFrames < finalframes*0.7){
                            attackSPR.setRegion(140,70,70,70);
                            attackSPR.setPosition(battleStance.getX()+1050,battleStance.getY()+50);
                        }
                        if (movedFrames > finalframes*0.7 && movedFrames < finalframes*0.8){
                            attackSPR.setRegion(210,70,70,70);
                            attackSPR.setPosition(battleStance.getX()+1050,battleStance.getY()+50);
                        }
                        if (movedFrames > finalframes*0.8 && movedFrames < finalframes*0.9){
                            attackSPR.setRegion(280,70,70,70);
                            attackSPR.setPosition(battleStance.getX()+1050,battleStance.getY()+50);
                        }
                        if (movedFrames > finalframes*0.9){
                            attackSPR.setRegion(280,70,70,70);
                            attackSPR.setPosition(battleStance.getX()+1050,battleStance.getY()+50);
                        }
                        camera.update();
                        attackValue = 1;


                    }
                }, (long) 0.000001f);
            }
            while (attackValue == 1 && animAttack);
        }

    }


    public static void animateMobAttack(){
        mobAttackX = (int) (battleStance.getX()+300);

        if (animMobAttack) {
            Fight.inputBlocked = true;
            mobAttackSPR.draw(batch);





            do {
                attackValue = 0;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        attackValue = attackValue - 1;
                        if (movedFrames2 < finalframes) {
                            System.out.println("dodaję wartość");
                            movedFrames2++;
                        }  else if (movedFrames2 ==finalframes) {
                            animMobAttack = false;
                            movedFrames2 = 0;
                            Fight.inputBlocked = false;
                            System.out.println("koniec animaji");

                        }
                        if (movedFrames2 < finalframes*0.1){
                            mobAttackSPR.setRegion(70,0,70,70);
                            mobAttackSPR.setPosition(mobAttackX,battleStance.getY()-130);
                        }
                        if (movedFrames2 > finalframes*0.1 && movedFrames2 < finalframes*0.2){
                            mobAttackSPR.setRegion(140,0,70,70);
                            mobAttackSPR.setPosition(mobAttackX,battleStance.getY()-130);
                        }
                        if (movedFrames2 > finalframes*0.2 && movedFrames2 < finalframes*0.3){
                            mobAttackSPR.setRegion(210,0,70,70);
                            mobAttackSPR.setPosition(mobAttackX,battleStance.getY()-130);
                        }
                        if (movedFrames2 > finalframes*0.3 && movedFrames2 < finalframes*0.4){
                            mobAttackSPR.setRegion(280,0,70,70);
                            mobAttackSPR.setPosition(mobAttackX,battleStance.getY()-130);
                        }
                        if (movedFrames2 > finalframes*0.4 && movedFrames2 < finalframes * 0.5){
                            mobAttackSPR.setRegion(0,70,70,70);
                            mobAttackSPR.setPosition(mobAttackX,battleStance.getY()-130);
                        }
                        if (movedFrames2 > finalframes*0.5 && movedFrames2 < finalframes*0.6){
                            mobAttackSPR.setRegion(70,70,70,70);
                            mobAttackSPR.setPosition(mobAttackX,battleStance.getY()-130);
                        }
                        if (movedFrames2 > finalframes*0.6 && movedFrames2 < finalframes*0.7){
                            mobAttackSPR.setRegion(140,70,70,70);
                            mobAttackSPR.setPosition(mobAttackX,battleStance.getY()-130);
                        }
                        if (movedFrames2 > finalframes*0.7 && movedFrames2 < finalframes*0.8){
                            mobAttackSPR.setRegion(210,70,70,70);
                            mobAttackSPR.setPosition(mobAttackX,battleStance.getY()-130);
                        }
                        if (movedFrames2 > finalframes*0.8 && movedFrames2 < finalframes*0.9){
                            mobAttackSPR.setRegion(280,70,70,70);
                            mobAttackSPR.setPosition(mobAttackX,battleStance.getY()-130);
                        }
                        if (movedFrames2 > finalframes*0.9){
                            mobAttackSPR.setRegion(280,70,70,70);
                            mobAttackSPR.setPosition(mobAttackX,battleStance.getY()-130);
                        }
                        camera.update();
                        attackValue = 1;


                    }
                }, (long) 0.000001f);
            }
            while (attackValue == 1 && animMobAttack);
        }

    }


    public static void animateCrit(){

        if (criticalAttack){
            critSPR.setPosition(battleStance.getX()+1100,battleStance.getY() + 150);
            critSPR.draw(batch);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    criticalAttack = false;
                }
            },1000);
        }


    }
    public static void animateMobCrit(){
        if (criticalMobAttack){
            critMobSPR.setPosition(battleStance.getX(),battleStance.getY()+50);
            critMobSPR.draw(batch);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    criticalMobAttack = false;
                }
            },1000);
        }


    }


    public static void animateMiss(){
        if (miss){
            missSPR.setPosition(battleStance.getX()+1100,battleStance.getY()+50);
            missSPR.draw(batch);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    miss = false;
                }
            },1000);

        }

    }

    public static void animateMobMiss(){
        if (mobMiss){
            missMobSPR.setPosition(battleStance.getX()+ 100,battleStance.getY()-50);
            missMobSPR.draw(batch);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mobMiss = false;
                }
            },1000);

        }


    }

}
