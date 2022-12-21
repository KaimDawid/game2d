package com.mygdx.game.Frontend;

import Logic.FightLogic.Skills.Autoattack;
import Logic.FightLogic.Skills.Fireball;
import Logic.FightLogic.Skills.Icebolt;
import com.mygdx.game.GameApp;

public class AllAssets {

    public static void Create(){
        GameApp.fireball.createFire();
        Icebolt.createIce();
    }
    public static void Draw(){
        GameApp.fireball.animateFire();
        Autoattack.animateAttack();
        Icebolt.animateIce();
    }


}
