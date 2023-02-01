package com.mygdx.game.Frontend;

import Logic.FightLogic.Skills.*;
import com.mygdx.game.GameApp;

public class AllAssets {

    public static void Create(){
        GameApp.fireball.createFire();
        Icebolt.createIce();
    }
    public static void Draw(){
        Fireball.animMobFire();
        GameApp.fireball.animateFire();
        Autoattack.animateAttack();
        Autoattack.animateMobAttack();
        Autoattack.animateCrit();
        MobSkills.animatePoison();
        MobSkills.animateThunder();
        Autoattack.animateMobCrit();
        Autoattack.animateMiss();
        Autoattack.animateMobMiss();
        Stun.animateStun();
        Stun.animateMobStun();
        Icebolt.animateIce();
    }


}
