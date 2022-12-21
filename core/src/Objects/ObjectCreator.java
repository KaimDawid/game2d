package Objects;

import Objects.Items.Usables.Usables;
import Objects.Shop.Shop;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.List;

import static com.mygdx.game.GameApp.playerSprite;

public class ObjectCreator {


public static int rowsX = 4;
public static int rowsY = 5;


    public static void UpdateShopPosition(List<Sprite> spriteList){
        for (int i = 0; i < spriteList.size(); i++) {



            float myX = playerSprite.getX() + ((i + 4) * 100);
            if (i > 0){
                myX+= i*3;
            }
            float myY = playerSprite.getY() + 110;
            if (i >= rowsX && i < rowsX*2 ) {
                myX = myX - 400;
                myY = myY - 101;
            }
            else if (i >= rowsX*2 && i < rowsX*3){
                myX = myX - 800;
                myY = myY - 202;
            }

            else if (i >= rowsX*3 && i < rowsX*4){
                myX = myX - 1200;
                myY = myY - 303;
            }
            else if (i >= rowsX*4 && i < rowsX*5){
                myX = myX - 1600;
                myY = myY - 404;
            }
            else if (i >= rowsX*5 && i < rowsX*6){
                myX = myX - 2000;
                myY = myY - 505;
            }

            spriteList.get(i).setPosition(myX, myY);
        }
    }

    public static void CreateUsable(Usables name, Sprite sprite){
        Shop.shopList.add(sprite);


name.setImage(Shop.shopList.get(0));



    }


}
