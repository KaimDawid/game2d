package Logic.FightLogic.Skills;

import Logic.FightLogic.Fight;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.TimerTask;

import static com.mygdx.game.GameApp.*;

public class MobSkills {

    public static Texture thunderTXT, poisonTXT;
    public static Sprite thunderSPR, poisonSPR;
    public static boolean animThunder, animPoison;
    public static int movedFrames, finalframes = 40, thunderValue, poisonValue;

    public static void create(){
thunderTXT = new Texture("thunder.png");
thunderSPR = new Sprite(thunderTXT);
thunderSPR.setSize(600,600);
poisonTXT = new Texture("poison.png");
poisonSPR = new Sprite(poisonTXT);
poisonSPR.setSize(450,450);


    }

    public static void animateThunder(){

        if (animThunder) {
            Fight.inputBlocked = true;

            thunderSPR.draw(batch);


            do {
                thunderValue = 0;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        thunderValue = thunderValue - 1;
                        if (movedFrames < finalframes) {

                            movedFrames++;
                        }  else if (movedFrames ==finalframes) {
                            animThunder = false;
                            movedFrames = 0;
                            Fight.inputBlocked = false;


                        }
                        if (movedFrames < finalframes*0.1){
                            thunderSPR.setRegion(0,0,180,200);
                          thunderSPR.setPosition(battleStance.getX()+150,battleStance.getY()-50);
                        }
                        if (movedFrames > finalframes*0.1 && movedFrames < finalframes*0.2){
                            thunderSPR.setRegion(180,0,180,200);
                          thunderSPR.setPosition(battleStance.getX()+150,battleStance.getY()-50);
                        }
                        if (movedFrames > finalframes*0.2 && movedFrames < finalframes*0.3){
                            thunderSPR.setRegion(360,0,180,200);
                          thunderSPR.setPosition(battleStance.getX()+150,battleStance.getY()-50);
                        }
                        if (movedFrames > finalframes*0.3 && movedFrames < finalframes*0.4){
                            thunderSPR.setRegion(540,0,180,200);
                          thunderSPR.setPosition(battleStance.getX()+150,battleStance.getY()-50);
                        }
                        if (movedFrames > finalframes*0.4 && movedFrames < finalframes * 0.5){
                            thunderSPR.setRegion(720,0,180,200);
                          thunderSPR.setPosition(battleStance.getX()+150,battleStance.getY()-50);
                        }
                        if (movedFrames > finalframes*0.5 && movedFrames < finalframes*0.6){
                            thunderSPR.setRegion(0,200,180,200);
                          thunderSPR.setPosition(battleStance.getX()+150,battleStance.getY()-50);
                        }
                        if (movedFrames > finalframes*0.6 && movedFrames < finalframes*0.7){
                            thunderSPR.setRegion(180,200,180,200);
                          thunderSPR.setPosition(battleStance.getX()+150,battleStance.getY()-50);
                        }
                        if (movedFrames > finalframes*0.7 && movedFrames < finalframes*0.8){
                            thunderSPR.setRegion(360,200,180,200);
                          thunderSPR.setPosition(battleStance.getX()+150,battleStance.getY()-50);
                        }
                        if (movedFrames > finalframes*0.8 && movedFrames < finalframes*0.9){
                            thunderSPR.setRegion(540,200,180,200);
                          thunderSPR.setPosition(battleStance.getX()+150,battleStance.getY()-50);
                        }
                        if (movedFrames > finalframes*0.9){
                            thunderSPR.setRegion(720,200,180,200);
                          thunderSPR.setPosition(battleStance.getX()+150,battleStance.getY()-50);
                        }
                        camera.update();
                        thunderValue = 1;


                    }
                }, (long) 0.000001f);
            }
            while (thunderValue == 1 && animThunder);
        }



    }


    public static void animatePoison(){

        if (animPoison) {
            Fight.inputBlocked = true;

            poisonSPR.draw(batch);

            do {
                poisonValue = 0;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        poisonValue = poisonValue - 1;
                        if (movedFrames < finalframes) {
                         poisonSPR.setX(poisonSPR.getX() - 22);
                            movedFrames++;
                        }  else if (movedFrames ==finalframes) {
                            animPoison = false;
                            movedFrames = 0;
                            Fight.inputBlocked = false;
                            poisonSPR.setPosition(battleStance.getX()+900, battleStance.getY()-100);

                        }
                        if (movedFrames < 2){
                            poisonSPR.setPosition(battleStance.getX()+900, battleStance.getY()-100);
                        }
                        if (movedFrames < finalframes*0.1){
                            poisonSPR.setRegion(0,0,120,95);

                        }
                        if (movedFrames > finalframes*0.1 && movedFrames < finalframes*0.2){
                            poisonSPR.setRegion(120,0,120,95);

                        }
                        if (movedFrames > finalframes*0.2 && movedFrames < finalframes*0.3){
                            poisonSPR.setRegion(240,0,120,95);

                        }
                        if (movedFrames > finalframes*0.3 && movedFrames < finalframes*0.4){
                            poisonSPR.setRegion(360,0,120,95);

                        }
                        if (movedFrames > finalframes*0.4 && movedFrames < finalframes * 0.5){
                            poisonSPR.setRegion(480,0,120,95);

                        }
                        if (movedFrames > finalframes*0.5 && movedFrames < finalframes*0.6){
                            poisonSPR.setRegion(600,0,100,95);

                        }
                        if (movedFrames > finalframes*0.6 && movedFrames < finalframes*0.7){
                            poisonSPR.setRegion(0,90,120,103);

                        }
                        if (movedFrames > finalframes*0.7 && movedFrames < finalframes*0.8){
                            poisonSPR.setRegion(120,90,120,103);

                        }
                        if (movedFrames > finalframes*0.8 && movedFrames < finalframes*0.9){
                            poisonSPR.setRegion(240,90,120,103);

                        }
                        if (movedFrames > finalframes*0.9){
                            poisonSPR.setRegion(360,95,120,98);

                        }
                        camera.update();
                        poisonValue = 1;


                    }
                }, (long) 0.000001f);
            }
            while (poisonValue == 1 && animPoison);
        }
        
        
    }


}
