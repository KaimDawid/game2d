import Logic.GameLogic;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameApp {
    public static void main(String[] args) throws InterruptedException {
     /*   Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("RPGKaim");
        new Lwjgl3Application(new com.mygdx.game.GameApp(), config);*/
        String gameVersion = "alpha v 0.5 ";
        Batch batch = new SpriteBatch();
        Texture mutant = new Texture("mutant.png");

        batch.draw(mutant, 30, 30, 120, 180);
        System.out.println(gameVersion);
        GameLogic gameLogic = new GameLogic();
        gameLogic.Game();
    }

    }

