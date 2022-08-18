package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import static com.mygdx.game.GameApp.*;

public class GameInterface {
    public static void showSteering() {
        GameApp.bottomText = "Sterowanie: \n \n" +
                "Chodzenie:  W, S, D, A \n \n Mapa: Tab \n \n Ekwipunek: F2 \n \n Atrybuty: F3";

    }
}
