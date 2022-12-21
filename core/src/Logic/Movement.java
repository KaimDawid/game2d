package Logic;

import Mobs.Player;
import Objects.ObjectCreator;
import Objects.Shop.Shop;
import com.mygdx.game.Backend.Backend;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.GameApp;

import java.util.TimerTask;

import static com.mygdx.game.GameApp.*;

public class Movement {
    public static boolean moveUP;
    public static boolean moveDOWN;
    public static boolean moveLEFT;
    public static boolean moveRIGHT;

    static int moveValue;
    public static int movedTiles;
    public static double source;
    public static double dest;

     public static void UPBD() {
         if (Dawid.getY() < 50) {
             Dawid.setY(Dawid.getY() + 1);
             System.out.println("Ruszyłeś się");
             Dawid.setEscapeInvulnerability(0);
             Equipment.Y = Equipment.Y + 108;
             Backend.checkSuccesful = 1;
         } else if (Dawid.getY() >= 50) {
             System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
         }
     }
    public static void DOWNBD() {
        if (Dawid.getY() > 0) {
            Dawid.setY(Dawid.getY() + 1);
            System.out.println("Ruszyłeś się");
            Dawid.setEscapeInvulnerability(0);
            Equipment.Y = Equipment.Y - 108;
            Backend.checkSuccesful = 1;
        } else if (Dawid.getY() <= 0) {
            System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
        }
    }
    public static void RIGHTBD() {
        if (Dawid.getX() < 50) {
            Dawid.setX(Dawid.getX() + 1);
            System.out.println("Ruszyłeś się");
            Dawid.setEscapeInvulnerability(0);
            Equipment.X = Equipment.X + 192;
            Backend.checkSuccesful = 1;
        } else if (Dawid.getX() >= 50) {
            System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
        }
    }
    public static void LEFTBD() {
        if (Dawid.getX() < 0) {
            Dawid.setX(Dawid.getX() - 1);
            System.out.println("Ruszyłeś się");
            Dawid.setEscapeInvulnerability(0);
            Equipment.X = Equipment.X - 192;
            Backend.checkSuccesful = 1;
        } else if (Dawid.getX() <= 0) {
            System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
        }
    }

static TimerTask timerTask = new TimerTask() {
    @Override
    public void run() {
        playerSprite.setY(playerSprite.getY() + 1);
        movedTiles++;
    }
};
    public static void goUP(Player Dawid){

        if (Dawid.getY() > -20) {

            if (moveUP && !moveDOWN && !moveLEFT && !moveRIGHT) {






                do {
                    GameApp.moveValue = 0;

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            GameApp.moveValue = GameApp.moveValue + 1;
                            if (movedTiles < 54) {
                                playerSprite.setY(playerSprite.getY() + 2);
                                camera.update();
                                camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
                                movedTiles++;
                            }  else if (movedTiles == 54) {
                                camera.update();
                                ObjectCreator.UpdateShopPosition(Shop.shopList);
                                camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
                                moveUP = false;
                                movedTiles = 0;
                                GameApp.Dawid.setY(GameApp.Dawid.getY() + 1);
                                System.out.println("Ruszyłeś się");
                                GameApp.Dawid.setEscapeInvulnerability(0);
                                Equipment.Y = Equipment.Y + 108;
                                Backend.checkSuccesful = 1;

                            }
                            if (movedTiles < 9){
                                playerSprite.setRegion(0,105,40,95);
                            }
                            if (movedTiles > 8 && movedTiles < 19){
                                playerSprite.setRegion(86,105,40,95);
                            }
                            if (movedTiles > 18 && movedTiles < 28){
                                playerSprite.setRegion(134,105,40,95);
                            }
                            if (movedTiles > 27 && movedTiles < 37){
                                playerSprite.setRegion(174,105,40,95);
                            }
                            if (movedTiles > 36 && movedTiles < 46){
                                playerSprite.setRegion(221,105,40,95);
                            }
                            if (movedTiles > 45){
                                playerSprite.setRegion(267,105,40,95);
                            }
                            camera.update();
                            GameApp.moveValue = 1;
                            camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);

                        }
                    },  (long) 0.000001f);
                }
                while (GameApp.moveValue == 1 && moveUP);
            }

        }
    }

    public static void goDOWN(Player Dawid){

        if (Dawid.getY() < 230) {

            if (moveDOWN && !moveUP && !moveLEFT && !moveRIGHT) {


                do {
                    GameApp.moveValue = 0;

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            GameApp.moveValue = GameApp.moveValue - 1;
                            if (movedTiles < 54) {
                                playerSprite.setY(playerSprite.getY() - 2);
                                camera.update();
                                camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
                                movedTiles++;
                            } else if (movedTiles == 54) {
                                camera.update();
                                camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
                                moveDOWN = false;
                                movedTiles = 0;
                                GameApp.Dawid.setY(GameApp.Dawid.getY() - 1);
                                System.out.println("Ruszyłeś się");
                                GameApp.Dawid.setEscapeInvulnerability(0);
                                Equipment.Y = Equipment.Y - 108;
                                Backend.checkSuccesful = 1;

                            }
                            if (movedTiles < 9){
                                playerSprite.setRegion(0,5,40,100);
                            }
                            if (movedTiles > 8 && movedTiles < 19){
                                playerSprite.setRegion(86,5,40,100);
                            }
                            if (movedTiles > 18 && movedTiles < 28){
                                playerSprite.setRegion(134,5,40,100);
                            }
                            if (movedTiles > 27 && movedTiles < 37){
                                playerSprite.setRegion(174,5,40,100);
                            }
                            if (movedTiles > 36 && movedTiles < 46){
                                playerSprite.setRegion(221,5,40,100);
                            }
                            if (movedTiles > 45){
                                playerSprite.setRegion(267,5,40,100);
                            }
                            camera.update();
                            GameApp.moveValue = 1;
                            camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);

                        }
                    },  (long) 0.000001f);
                }
                while (GameApp.moveValue == 1 && moveUP);
            }
        }
    }

    public static void goRIGHT(final Player Dawid){

            if (Dawid.getX() < 230) {
                if (moveRIGHT && !moveUP && !moveLEFT && !moveDOWN) {



                  /*  timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            playerSprite.setRegion(80,200,40,100);


                        }
                    },300);*/
                    do {
                        GameApp.moveValue = 0;

                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                GameApp.moveValue = GameApp.moveValue + 1;
                                if (movedTiles < 48) {
                                    playerSprite.setX(playerSprite.getX() + 4);
                                    camera.update();
                                    camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
                                    movedTiles++;
                                }  else if (movedTiles == 48){
                                    moveRIGHT = false;
                                    movedTiles = 0;
                                    GameApp.Dawid.setX(GameApp.Dawid.getX() + 1);

                                    System.out.println("Ruszyłeś się");
                                    GameApp.Dawid.setEscapeInvulnerability(0);
                                    Equipment.X = Equipment.X + 192;
                                    Backend.checkSuccesful = 1;

                                }
                                if (movedTiles < 9){
                                    playerSprite.setRegion(0,199,40,100);
                                }
                                if (movedTiles > 8 && movedTiles < 17){
                                    playerSprite.setRegion(86,199,40,100);
                                }
                                if (movedTiles > 16 && movedTiles < 25){
                                    playerSprite.setRegion(130,199,40,100);
                                }
                                if (movedTiles > 24 && movedTiles < 33){
                                    playerSprite.setRegion(174,199,40,100);
                                }
                                if (movedTiles > 32 && movedTiles < 41){
                                    playerSprite.setRegion(221,199,40,100);
                                }
                                if (movedTiles > 42){
                                    playerSprite.setRegion(267,199,40,100);
                                }
                                camera.update();
                                GameApp.moveValue = 1;
                                camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);

                            }
                        },  (long) 0.000001f);
                    }
                    while (GameApp.moveValue == 1 && moveUP);
                }
            }
    }

    public static void goLEFT(final Player Dawid){

        if (Dawid.getX() < 230) {
            if (moveLEFT && !moveUP && !moveDOWN && !moveRIGHT) {





                do {
                    GameApp.moveValue = 0;

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            GameApp.moveValue = GameApp.moveValue - 1;
                            if (movedTiles < 48) {
                                playerSprite.setX(playerSprite.getX() - 4);
                                camera.update();
                                camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);
                                movedTiles++;
                            }  else if (movedTiles ==48) {
                                moveLEFT = false;
                                movedTiles = 0;
                                GameApp.Dawid.setX(GameApp.Dawid.getX() - 1);

                                System.out.println("Ruszyłeś się");
                                GameApp.Dawid.setEscapeInvulnerability(0);
                                Equipment.X = Equipment.X - 192;
                                Backend.checkSuccesful = 1;

                            }
                            if (movedTiles < 9){
                                playerSprite.setRegion(0,294,40,100);
                            }
                            if (movedTiles > 8 && movedTiles < 17){
                                playerSprite.setRegion(86,294,40,100);
                            }
                            if (movedTiles > 16 && movedTiles < 25){
                                playerSprite.setRegion(130,294,40,100);
                            }
                            if (movedTiles > 24 && movedTiles < 33){
                                playerSprite.setRegion(174,294,40,100);
                            }
                            if (movedTiles > 32 && movedTiles < 41){
                                playerSprite.setRegion(221,294,40,100);
                            }
                            if (movedTiles > 42){
                                playerSprite.setRegion(267,294,40,100);
                            }
                            camera.update();
                            GameApp.moveValue = 1;
                            camera.position.set(playerSprite.getX(), playerSprite.getY(), 10);

                        }
                    }, (long) 0.000001f);
                }
                while (GameApp.moveValue == 1 && moveUP);
            }
        }
    }

    public static void updatePostion(){
        for (int i = 1; i < 32; i++) {
            if (Dawid.getX() == i) {
                playerSprite.setX((xValue - 768) + (i * 192));
            }
            if (Dawid.getY() == i) {
                playerSprite.setY((yValue - 432) + (i * 108));
            }

        }
    }
    public static void createMovement(){



    }

}
