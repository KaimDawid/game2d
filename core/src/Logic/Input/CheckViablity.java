package Logic.Input;

import Data.Quests.RusakovQuest;
import com.mygdx.game.GameApp;

import java.util.Date;

public class CheckViablity {
    public static boolean viable = false;
    public static void Check(int X, int Y){
        if (X == 17 && Y != 4){
            viable = false;
        }
        else if (X == 199 || Y == 199 || X ==209 || Y == 209){
            viable = false;

        }
        else if (X == 18 && RusakovQuest.questStage < 3){
            viable = false;
        }else if ((X > 17 && X < 25 )&& (Y == 3 || Y == 5)){
            viable = false;
        }
        else if (X == 24 && Y!= 4){
            viable = false;
        }
        else if ( X == 205 && (Y == 200 || Y == 202 || Y == 203 || Y == 204)){
            viable = false;
        }
        else if (Y == 205 && X != 207){
            viable = false;
        }
        else if (X == 108 ){
            viable = false;
        }
        else if (X == 112 && Y < 120){
            viable = false;
        }
        else if (Y == 109 ){
            viable = false;
        }
        else if (X == 110 && (Y == 114 || Y == 115)){
            viable = false;
        }
        else if (Y == 126){
            viable = false;
        }
        else if ((X == 112 || X == 108 )&& Y == 119){
            viable = false;
        }
        else if (X == 115){
            viable = false;
        }
        else if (X == -3){
            viable = false;
        }
        else if (Y > 8 && X < 1){
            viable = false;
        }
        else if (Y < 1 ){
            viable = false;
        }
        else {
            viable = true;
        }
    }



}
