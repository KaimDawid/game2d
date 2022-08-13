package com.mygdx.game;

import Logic.GameLogic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameApp;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) throws InterruptedException {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("RPGKaim");
		new Lwjgl3Application(new GameApp(), config);
		String gameVersion = "alpha v 0.5 ";
		Batch batch = new SpriteBatch();
		Texture mutant = new Texture("mutant.png");

		Sprite mutant2 = new Sprite(mutant);
		Pixmap pixmap = new Pixmap( 64, 64, Pixmap.Format.RGBA8888 );
		pixmap.setColor( 0, 1, 0, 0.75f );
		pixmap.fillCircle( 32, 32, 32 );
		Texture pixmaptext = new Texture( pixmap );
		pixmap.dispose();
		batch.draw(mutant2, 30, 30, 120, 180);
			Gdx.gl.glClearColor(1, 1, 1, 1);


			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
					mutant2.translateX(-1f);
				else
					mutant2.translateX(-10.0f);
			}
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
					mutant2.translateX(1f);
				else
					mutant2.translateX(10.0f);
			}
			batch.begin();
			mutant2.draw(batch);
			batch.end();



		System.out.println(gameVersion);
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
				mutant.draw(pixmap, 30, 30);
				mutant2.translateX(-1f);
			}
			else
				mutant2.translateX(-10.0f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
				mutant2.translateX(1f);
			else
				mutant2.translateX(10.0f);
		}
		GameLogic gameLogic = new GameLogic();
		gameLogic.Game();

	}
}
