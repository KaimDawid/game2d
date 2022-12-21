package com.mygdx.game.Frontend.Animacja;

import Logic.Movement;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.GameApp;

public class Animacja {
    public static int doneTicks;


    public static void MyAnimation ( int ticks, Sprite localSprite, int moveX,
                                     int widthDividedBy5, int height, int start, int doneTicks){
        GameApp.moveValue = GameApp.moveValue - 1;
        if (doneTicks < ticks) {
            doneTicks++;
        } else if (doneTicks == ticks) {
            start = 0;
            Movement.movedTiles = 0;


        }
        if (doneTicks > 0 && doneTicks < ticks * 30) {
            localSprite.setRegion(moveX, 0, widthDividedBy5, height);

        }
        if (doneTicks > 30 && doneTicks < ticks * 60) {
            localSprite.setRegion(moveX*2, 0, widthDividedBy5, height);

        }
        if (doneTicks > 60 && doneTicks < 90) {
            localSprite.setRegion((moveX*3), 0, widthDividedBy5, height);

        }
        if (doneTicks > 90 && doneTicks < 120) {
            localSprite.setRegion((moveX*4), 0, widthDividedBy5, height);

        }
        if (doneTicks > 120) {

            localSprite.setRegion((moveX*5), 0, widthDividedBy5, height);

        }

        GameApp.moveValue = 1;


    }



}
