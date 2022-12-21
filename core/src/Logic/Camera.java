package Logic;

import Logic.FightLogic.Fight;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Assets;
import com.mygdx.game.GameApp;

import java.util.TimerTask;

import static com.mygdx.game.GameApp.*;

public class Camera {

    public static float X;

    public static void fadeOut() {

        if (GameApp.transitionOut) {
            batch.begin();
            battleStance.setSize(0,0);
          /*  mapSprite.setColor(originalColor.r, originalColor.g, originalColor.b, 0.05f);

            fightscreenSP.setColor(color2.r, color2.g, color2.b, 0.05f);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    mapSprite.setColor(originalColor.r, originalColor.g, originalColor.b, 5);
                    fightscreenSP.setColor(color2.r, color2.g, color2.b, 5);
                }
            },2000);*/

            batch.end();
            do {

                GameApp.screenValue = 0;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        GameApp.screenValue = GameApp.screenValue + 1;
                        if (GameApp.loopRepeated < 480) {
                            GameApp.fightscreenSP.setSize(GameApp.fightscreenSP.getWidth() - 32, GameApp.fightscreenSP.getHeight());
                            GameApp.fightscreenSP.setX(GameApp.fightscreenSP.getX() + 16);
                            GameApp.loopRepeated++;



                        } else if (GameApp.loopRepeated > 479) {
                            GameApp.narrowScreen = false;
                            GameApp.loopRepeated = 0;
                        }
                        if (GameApp.loopRepeated2 < 540) {
                            GameApp.fightscreenSP.setSize(GameApp.fightscreenSP.getWidth(), GameApp.fightscreenSP.getHeight() - 16);
                            GameApp.fightscreenSP.setY(GameApp.fightscreenSP.getY() + 8);
                            GameApp.loopRepeated++;

                        } else if (GameApp.loopRepeated2 > 539) {
                            GameApp.narrowScreen = false;
                            GameApp.loopRepeated2 = 0;

                        }
                        if (GameApp.fightscreenSP.getHeight() < 8){
                            GameApp.fightscreenSP.setSize(1,1);
                            GameApp.transitionOut = false;
                        }
                        GameApp.camera.update();

                        GameApp.camera.position.set(GameApp.playerSprite.getX(), GameApp.playerSprite.getY(), 10);

                    }
                }, 100);
            }
            while (GameApp.narrowScreen);
        }
    }


    public static void fadeIn() {
        if (GameApp.transitionIn) {
            batch.begin();

          /*  GameApp.mapSprite.setColor(color.b, color.r, color.g ,0);

            GameApp.fightscreenSP.setColor(originalColor2.b, originalColor2.r, originalColor2.g, 0.1f);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    GameApp.mapSprite.setColor(color.b,color.r,color.g, 0);

                    GameApp.fightscreenSP.setColor(originalColor2.b, originalColor2.r, originalColor2.g, 5);
                }
            },2000);*/


            batch.end();
            do {

                GameApp.screenValue = 0;

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        GameApp.screenValue = GameApp.screenValue + 1;

                        if (Assets.attackSpr.getWidth() < 200 && Assets.attackSpr.getHeight() < 80){
                            Assets.attackSpr.setSize((float) (Assets.attackSpr.getWidth() + 2), (float) (Assets.attackSpr.getHeight() + 0.8));
                            Assets.runSpr.setSize((float) (Assets.runSpr.getWidth() + 2), (float) (Assets.runSpr.getHeight() + 0.8));
                           /* if (Fight.healLearned){
                               healSPR2.setSize((float) (healSPR2.getWidth() + 1), (float) (healSPR2.getHeight() + 0.4));
                            }
                            if (Fight.fireballLearned){
                                fireBallSPR2.setSize((float) (GameApp.fireBallSPR2.getWidth() + 1), (float) (GameApp.fireBallSPR2.getHeight() + 0.4));
                            }
                            if (Fight.adrenalineLearned){
                                getAdrenalineSPR2.setSize((float) (GameApp.getAdrenalineSPR2.getWidth() + 1), (float) (GameApp.getAdrenalineSPR2.getHeight() + 0.4));
                            }
                            if (Fight.ironskinLearned){
                               ironskinSPR2.setSize((float) (ironskinSPR2.getWidth() + 1), (float) (ironskinSPR2.getHeight() + 0.4));
                            }
                            if (Fight.iceLearned){
                                getIceBoltSPR2.setSize((float) (getIceBoltSPR2.getWidth() + 1), (float) (getIceBoltSPR2.getHeight() + 0.4));
                            }
                            if (Fight.cleaveLearned){
                                cleaveSPR2.setSize((float) (cleaveSPR2.getWidth() + 1), (float) (cleaveSPR2.getHeight() + 0.4));
                            }*/
                        }
                        if (Assets.attackSpr.getX() != playerSprite.getX() - 600){
Assets.attackSpr.setX(Assets.attackSpr.getX() - 4);
                        }
                        if (Assets.attackSpr.getY() != playerSprite.getY() - 250){
Assets.attackSpr.setY(Assets.attackSpr.getY() - 2);
                        }
                        if (Assets.runSpr.getX() != playerSprite.getX() - 300){
                        Assets.runSpr.setX(Assets.runSpr.getX() - 2);
                        }
                        if (Assets.runSpr.getY() != playerSprite.getY() - 250){
                            Assets.runSpr.setY(Assets.runSpr.getY() - 2);
                        }

if (X > 0){
    fightscreenSP.setAlpha(X--);
}


                        if (GameApp.loopRepeated < 480) {
                            GameApp.fightscreenSP.setSize(GameApp.fightscreenSP.getWidth() + 32, GameApp.fightscreenSP.getHeight());
                            GameApp.loopRepeated++;
                            GameApp.fightscreenSP.setX(GameApp.fightscreenSP.getX() - 16);
                        } else if (GameApp.loopRepeated > 479) {
                            GameApp.narrowScreen = false;
                            GameApp.loopRepeated = 0;
                        }
                        if (GameApp.loopRepeated2 < 540) {
                            GameApp.fightscreenSP.setSize(GameApp.fightscreenSP.getWidth(), GameApp.fightscreenSP.getHeight() + 16);

                            GameApp.fightscreenSP.setY(GameApp.fightscreenSP.getY() - 8);
                            GameApp.loopRepeated++;

                        } else if (GameApp.loopRepeated2 > 539) {
                            GameApp.narrowScreen = false;
                            GameApp.loopRepeated2 = 0;
                        }
                        if (GameApp.fightscreenSP.getHeight() > 1079){
                            GameApp.transitionIn = false;
                        }
                        GameApp.camera.update();

                        GameApp.camera.position.set(GameApp.playerSprite.getX(), GameApp.playerSprite.getY(), 10);

                    }
                }, 100);
            }
            while (GameApp.narrowScreen);
        }
    }

    public static void reduce(double source, double destination, double increase){
        if (source > destination){
            source = source - increase;
        }
    }
    public static void increase(double source, double destination, double increase){
        if (source < destination){
            source = source + increase;
        }
    }


}
