package com.mygdx.game.Backend;

import Data.Quests.Quests;
import Data.Quests.RysiuQuest;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import static com.mygdx.game.GameApp.fightstart;

public class Soundtrack {

    public static Sound swing;
    public static Sound door;
    public static Sound ui, steps, success, coin, potion, battle, equip, mob, thump, bite, banditswing;

public static Music slon, questcomplete, fire, smallbite, heal, ice;

public static Music music;

    public static void create(){
        ice = Gdx.audio.newMusic(Gdx.files.internal("ice.mp3"));
        heal = Gdx.audio.newMusic(Gdx.files.internal("heal.mp3"));
        fire = Gdx.audio.newMusic(Gdx.files.internal("fire.mp3"));
smallbite = Gdx.audio.newMusic(Gdx.files.internal("smallbite.mp3"));
        slon = Gdx.audio.newMusic(Gdx.files.internal("slon.mp3"));
        steps = Gdx.audio.newSound(Gdx.files.internal("steps.mp3"));
        success = Gdx.audio.newSound(Gdx.files.internal("success.mp3"));
        coin = Gdx.audio.newSound(Gdx.files.internal("coin.mp3"));
        questcomplete = Gdx.audio.newMusic(Gdx.files.internal("questcomplete.mp3"));
        potion = Gdx.audio.newSound(Gdx.files.internal("potion.mp3"));
        banditswing = Gdx.audio.newSound(Gdx.files.internal("banditswing.mp3"));
        battle = Gdx.audio.newSound(Gdx.files.internal("battle.mp3"));
        equip = Gdx.audio.newSound(Gdx.files.internal("equip.mp3"));
        mob = Gdx.audio.newSound(Gdx.files.internal("monster.mp3"));
        thump = Gdx.audio.newSound(Gdx.files.internal("thump.mp3"));
        bite = Gdx.audio.newSound(Gdx.files.internal("bite.mp3"));
questcomplete.setVolume(0.3F);
        steps = Gdx.audio.newSound(Gdx.files.internal("steps.mp3"));
        swing = Gdx.audio.newSound(Gdx.files.internal("hit1.wav"));
        door = Gdx.audio.newSound(Gdx.files.internal("door.mp3"));
    ui = Gdx.audio.newSound(Gdx.files.internal("ui.mp3"));



        music = Gdx.audio.newMusic(Gdx.files.internal("soundtrack.mp3"));

        music.setLooping(true);
       slon.setVolume(0.2F);
       slon.setLooping(true);
        music.setVolume(0.2f);
    }

    public static void render(){
if (fightstart == 1){
    music.setVolume(0.05f);
}
else {
    music.setVolume(0.2f);
}
        if (Quests.quest2Stage!=5){
            slon.pause();

            music.play();
        } else if (Quests.quest2Stage == 5) {
            music.stop();
            slon.play();
        }
    }
}
