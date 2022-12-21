package Mobs.Cemetery;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class CemeterySprites {


    public static Texture skeletonTXT;
    public static Texture lumpOfFleshTXT;
    public static Texture headlessHorsemanTXT;
    public static Texture ghostTXT;
    public static Texture ghoulTXT;
    public static Sprite skeletonSPR;
    public static Sprite lumpOfFleshSPR;
    public static Sprite headlessHorsemanSPR;
    public static Sprite ghostSPR;
    public static Sprite ghoulSPR;

    public static void create(){

        skeletonTXT = new Texture("skeleton.png");
        lumpOfFleshTXT = new Texture("lumpofflesh.png");
        headlessHorsemanTXT = new Texture("headlesshorseman.png");
        ghostTXT = new Texture("ghost.png");
        ghoulTXT = new Texture("ghoul.png");

        skeletonSPR = new Sprite(skeletonTXT);
        lumpOfFleshSPR = new Sprite(lumpOfFleshTXT);
        headlessHorsemanSPR = new Sprite(headlessHorsemanTXT);
        ghostSPR = new Sprite(ghostTXT);
        ghoulSPR = new Sprite(ghoulTXT);


    }


}
