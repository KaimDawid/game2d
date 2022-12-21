package Logic.Drop;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

import static Logic.Drop.Miscelanous.gatheredWood;
import static Logic.Drop.Miscelanous.woodLogs;
import static com.badlogic.gdx.math.MathUtils.random;
import static com.mygdx.game.GameApp.Dawid;

@Getter @Setter
public class Miscelanous {

   public static ArrayList<Wood> woodLogs = new ArrayList<Wood>();

    public static int poisonSacks = 0;

    public static int psRequirement = 6;

    public static int banditsKilled = 0;

    public static int bkRequirement = 10;

public static int gatheredWood = 0;

public static int crayfishKilled;
public static int crayFishRequirement = 6;
    
public static boolean magicFlute = false;

}
