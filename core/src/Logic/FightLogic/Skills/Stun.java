package Logic.FightLogic.Skills;

import Logic.FightLogic.Fight;
import Logic.Movement;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.TimerTask;

import static com.mygdx.game.GameApp.*;

public class Stun {
    
    public static Texture stunTXT;
    public static Sprite stunSPR, mobStunSPR;
    
    public static boolean animStun, mobAnimStun;
    
    public static int movedFrames, movedFrames2, finalframes = 80, stunValue, mobStunValue;
    
    public static float stunX, stunY, mobStunX, mobStunY;
    
    
    public static void create(){
        
        
        stunTXT = new Texture("stunanim.png");
        stunSPR = new Sprite(stunTXT);
        mobStunSPR = new Sprite(stunTXT);
        mobStunSPR.setSize(360,360);
        stunSPR.setSize(360,360);
        
        
    }
    
    
    
    
    public static void animateStun(){
        stunX = battleStance.getX()+150;
        stunY = battleStance.getY() + 200;
        if (animStun) {

            stunSPR.draw(batch);





            do {
                stunValue = 0;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        stunValue = stunValue - 1;
                        if (movedFrames < finalframes) {

                            movedFrames++;
                        }  else if (movedFrames ==finalframes) {
                            if (Dawid.getStun() < 1) {
                                animStun = false;
                            }
                            else {
                                animStun = true;
                            }
                            movedFrames = 0;



                        }
                        if (movedFrames < finalframes*0.1){
                            stunSPR.setPosition(stunX, stunY);
                            stunSPR.setRegion(0,0,250,250);
                        }
                        if (movedFrames > finalframes*0.1 && movedFrames < finalframes*0.2){
                            stunSPR.setRegion(250,0,250,250);
                            stunSPR.setPosition(stunX, stunY);
                        }
                        if (movedFrames > finalframes*0.2 && Movement.movedTiles < finalframes*0.3){
                            stunSPR.setRegion(500,0,250,250);
                            stunSPR.setPosition(stunX, stunY);
                        }
                        if (movedFrames > finalframes*0.3 && Movement.movedTiles < finalframes*0.4){
                            stunSPR.setRegion(750,0,250,250);
                            stunSPR.setPosition(stunX, stunY);
                        }
                        if (movedFrames > finalframes*0.4 && movedFrames < finalframes *0.5){
                            stunSPR.setRegion(1000,0,250,250);
                            stunSPR.setPosition(stunX, stunY);
                        }
                        if (movedFrames > finalframes*0.5 && movedFrames < finalframes*0.6){
                            stunSPR.setRegion(1250,0,250,250);
                            stunSPR.setPosition(stunX, stunY);
                        }
                        if (movedFrames > finalframes*0.6 && movedFrames < finalframes*0.7){
                            stunSPR.setRegion(1500,0,250,250);
                            stunSPR.setPosition(stunX, stunY);
                        }
                        if (movedFrames > finalframes*0.7 && Movement.movedTiles < finalframes*0.8){
                            stunSPR.setRegion(1750,0,250,250);
                            stunSPR.setPosition(stunX, stunY);
                        }
                        if (movedFrames > finalframes*0.8 && Movement.movedTiles < finalframes*0.9){
                            stunSPR.setRegion(2000,0,250,250);
                            stunSPR.setPosition(stunX, stunY);
                        }
                        if (movedFrames > finalframes*0.9){
                            stunSPR.setRegion(2250,0,250,250);
                            stunSPR.setPosition(stunX, stunY);
                        }

                        stunValue = 1;


                    }
                }, (long) 0.000001f);
            }
            while (stunValue == 1 && animStun);
        }
    }

    public static void animateMobStun(){
        mobStunX = battleStance.getX()+1100;
        mobStunY = battleStance.getY() + 200;
        if (mobAnimStun) {

            mobStunSPR.draw(batch);





            do {
                mobStunValue = 0;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                       mobStunValue = mobStunValue -1;
                        if (movedFrames2 < finalframes) {

                            movedFrames2++;
                        }  else if (movedFrames2 ==finalframes) {
                            if (currentTarget.getFreeze() == 0) {
                                mobAnimStun = false;
                            }
                            else {
                                mobAnimStun = true;
                            }
                            movedFrames2 = 0;



                        }
                        if (movedFrames2 < finalframes*0.1){
                            mobStunSPR.setPosition(mobStunX, mobStunY);
                            mobStunSPR.setRegion(0,0,250,250);
                        }
                        if (movedFrames2 > finalframes*0.1 && movedFrames2 < finalframes*0.2){
                            mobStunSPR.setRegion(250,0,250,250);
                            mobStunSPR.setPosition(mobStunX, mobStunY);
                        }
                        if (movedFrames2 > finalframes*0.2 && Movement.movedTiles < finalframes*0.3){
                            mobStunSPR.setRegion(500,0,250,250);
                            mobStunSPR.setPosition(mobStunX, mobStunY);
                        }
                        if (movedFrames2 > finalframes*0.3 && Movement.movedTiles < finalframes*0.4){
                            mobStunSPR.setRegion(750,0,250,250);
                            mobStunSPR.setPosition(mobStunX, mobStunY);
                        }
                        if (movedFrames2 > finalframes*0.4 && movedFrames2 < finalframes *0.5){
                            mobStunSPR.setRegion(1000,0,250,250);
                            mobStunSPR.setPosition(mobStunX, mobStunY);
                        }
                        if (movedFrames2 > finalframes*0.5 && movedFrames2 < finalframes*0.6){
                            mobStunSPR.setRegion(1250,0,250,250);
                            mobStunSPR.setPosition(mobStunX, mobStunY);
                        }
                        if (movedFrames2 > finalframes*0.6 && movedFrames2 < finalframes*0.7){
                            mobStunSPR.setRegion(1500,0,250,250);
                            mobStunSPR.setPosition(mobStunX, mobStunY);
                        }
                        if (movedFrames2 > finalframes*0.7 && Movement.movedTiles < finalframes*0.8){
                            mobStunSPR.setRegion(1750,0,250,250);
                            mobStunSPR.setPosition(mobStunX, mobStunY);
                        }
                        if (movedFrames2 > finalframes*0.8 && Movement.movedTiles < finalframes*0.9){
                            mobStunSPR.setRegion(2000,0,250,250);
                            mobStunSPR.setPosition(mobStunX, mobStunY);
                        }
                        if (movedFrames2 > finalframes*0.9){
                            mobStunSPR.setRegion(2250,0,250,250);
                            mobStunSPR.setPosition(mobStunX, mobStunY);
                        }

                        mobStunValue = 1;


                    }
                }, (long) 0.000001f);
            }
            while (mobStunValue == 1 && animStun);
        }
    }

}
