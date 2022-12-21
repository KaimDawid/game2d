package Logic.FightLogic.Skills;

import Logic.FightLogic.Fight;
import Logic.Movement;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Frontend.Fonts;
import lombok.Getter;
import lombok.Setter;

import java.util.TimerTask;

import static com.badlogic.gdx.graphics.Color.RED;
import static com.mygdx.game.Frontend.Fonts.impactFont;
import static com.mygdx.game.GameApp.*;
import static com.mygdx.game.GameApp.batch;

@Getter@Setter
public class Autoattack  extends Spells {
    public static Texture texture, attackTXT;
    public static Sprite sprite, attackSPR;
    public static boolean learned = true;
    public static int cooldown;
public static BitmapFont cooldownBMP;
    public static boolean animAttack;
    public static int attackValue, movedFrames, finalframes = 50;

    public static void create(){

        texture = new Texture("attackbutton.png");
        sprite = new Sprite(texture);
        attackTXT = new Texture("attackanim.png");
        attackSPR = new Sprite(attackTXT);
        attackSPR.setSize(420,420);
        sprite.setSize(200,60);
        cooldownBMP = Fonts.Impact.generateFont(impactFont);
        cooldownBMP.setColor(RED);
        cooldownBMP.getData().setScale(0.8F);
    }

    public static void render(){

        sprite.setPosition(playerSprite.getX()-450, playerSprite.getY()-250);
        if (fightstart == 1 && learned && fightscreenSP.getHeight()>1070){
            batch.begin();
            sprite.draw(batch);
            batch.end();
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
}
