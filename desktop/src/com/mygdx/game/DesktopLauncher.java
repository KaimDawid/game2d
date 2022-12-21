package com.mygdx.game;

import Logic.GameLogic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
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
		config.setForegroundFPS(65);

		config.setInitialVisible(true);
		config.setInitialBackgroundColor(Color.DARK_GRAY);

		config.setWindowedMode(1460,840);
		config.setWindowIcon("maptile.png");
		config.setTitle("Ravens Guard This Kingdom");
		new Lwjgl3Application(new GameApp(), config);

		String gameVersion = "demo 0.85 ";
		Batch batch = new SpriteBatch();
		Texture mutant = new Texture("mutant.png");

		Sprite mutant2 = new Sprite(mutant);
		Pixmap pixmap = new Pixmap( 64, 64, Pixmap.Format.RGBA8888 );
		pixmap.setColor( 0, 1, 0, 0.75f );
		pixmap.fillCircle( 32, 32, 32 );
		Texture pixmaptext = new Texture( pixmap );
		pixmap.dispose();

			Gdx.gl.glClearColor(1, 1, 1, 1);


		GameLogic gameLogic = new GameLogic();
		gameLogic.Game();

	}
}
