package Objects.Shop;

import Mobs.Player;
import Objects.Items.Item;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Assets;
import com.mygdx.game.Backend.Soundtrack;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.Frontend.Fonts;
import com.mygdx.game.GameApp;

import java.util.*;

public class Shop {

    public static Texture shopTxt;
    public static Sprite shopSprite, sellHP, sellMANA, sellGW, sellAP, sellBOMB;
    public static List<Sprite> shopList;
    int X;
    int Y;

    int floor;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Shop(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }


    public static void create(){
        sellAP = new Sprite(Assets.armorPotionTXT);
        sellBOMB = new Sprite(Assets.bombTXT);
        sellHP = new Sprite(Assets.healthPotionTXT);
        sellGW = new Sprite(Assets.grindingWheelTXT);
        sellMANA = new Sprite(Assets.manaPotionTXT);
    }
    public static void Display(){






    }


    public static void purchase(Player player) {

        Scanner scanner = new Scanner(System.in);

        int bombPrice = 25;
        int potionPrice = 40;
int armorPrice = 50;
int redRingPrice = 30;
int greenRingPrice = 30;
String input = "100";
int bombStock = 3;
int potionStock = 2;
int armorStock = 1;
int redRingStock = 1;
int greenRingStock = 1;
        System.out.println("______________________________________________________________________________________________________" +
                "________________________________________");
        System.out.println("Witaj w sklepie, wybierz towar który chcesz kupić            |        Twoje złoto: " + player.getGold());
        System.out.println("1. Bomba: " + bombPrice + " sztuk złota (80 obrażeń w walce)                |        " +
                "2. Eliksir zdrowia:" + potionPrice + " sztuk złota (+ 100 punktów życia w walce)");
        System.out.println("3. Podkowa: " + armorPrice + " sztuk złota (negacja 15 punktów obrażeń       |        " +
                "4. Czerwony pierścień: " + redRingPrice + " sztuk złota (+15 obrażeń)");
        System.out.println("5. Zielony pierścień (+20 życia): " + greenRingPrice + " sztuk złota");
do {
    System.out.println("Dostępne towary: wpisz 9");
    System.out.println("Wyjdź: wpisz 0");
    input = scanner.nextLine().toUpperCase();

    switch (input) {
        case "1":
            if (bombStock > 0) {
                if (player.getGold() >= bombPrice) {
                    player.setGold(player.getGold() - bombPrice);
                    player.setBombNumber(player.getBombNumber() + 1);
                    bombStock = (bombStock - 1);
                    System.out.println("Zakupiłeś bombę, masz ich teraz: " + player.getBombNumber());
                } else {
                    System.out.println("Nie masz wystarczająco pieniędzy.");
                }
            }
            else {
                System.out.println("Towar się skończył, wybierz sobie coś innego");}
            break;
        case "2":
            if (potionStock > 0) {
                if (player.getGold() >= potionPrice) {
                    player.setGold(player.getGold() - potionPrice);
                    player.setPotionNumber(player.getPotionNumber() + 1);
                    potionStock = (potionStock - 1);
                    System.out.println("Zakupiłeś eliksir zdrowia, masz ich teraz: " + player.getPotionNumber());
                } else {
                    System.out.println("Nie masz wystarczająco pieniędzy");
                }
            }    else {
                System.out.println("Towar się skończył, wybierz sobie coś innego");}
            break;
        case "3":
            if (armorStock > 0) {
                if (player.getGold() >= armorPrice) {
                    player.setGold(player.getGold() - armorPrice);
                    player.setArmor(player.getArmor() + 15);
                    armorStock = (armorStock - 1);
                    System.out.println("Zakupiłeś podkowę, negujesz od teraz: " + player.getArmor() + " obrażeń");
                } else {
                    System.out.println("Nie masz wystarczająco pieniędzy");
                }
            }    else {
                System.out.println("Towar się skończył, wybierz sobie coś innego");}
            break;
        case "4":
            if (redRingStock > 0) {
                if (player.getGold() >= redRingPrice) {
                    player.setGold(player.getGold() - redRingPrice);
                    player.setDMG(player.getDMG() + 15);
                    redRingStock = (redRingStock - 1);
                    System.out.println("Zakupiłeś czerwony pierścień, dostajesz + 15 do obrażeń ");
                } else {
                    System.out.println("Nie masz wystarczająco pieniędzy");
                }
            }    else {
                System.out.println("Towar się skończył, wybierz sobie coś innego");}
            break;
        case "5":
            if (greenRingStock > 0) {
                if (player.getGold() >= greenRingPrice) {
                    player.setGold(player.getGold() - greenRingPrice);
                    player.setHP(player.getHP() + 20);
                    player.setMaxHP(player.getHP() + 20);
                    greenRingStock = (greenRingStock - 1);
                    System.out.println("Zakupiłeś zielony pierścień, dostajesz + 20 do zdrowia ");
                } else {
                    System.out.println("Nie masz wystarczająco pieniędzy");
                }
            }    else {
                System.out.println("Towar się skończył, wybierz sobie coś innego");}
            break;
        case "9":
            System.out.println("________________________________________Twoje złoto: " + player.getGold() + "_________________________________________" +
                    "________________________________________");
            System.out.println("1. Bomba: " + bombPrice + " sztuk złota (80 obrażeń w walce)                |        " +
                    "2. Eliksir zdrowia:" + potionPrice + " sztuk złota (+ 100 punktów życia w walce)");
            System.out.println("3. Podkowa: " + armorPrice + " sztuk złota (negacja 15 punktów obrażeń       |        " +
                    "4. Czerwony pierścień: " + redRingPrice + " sztuk złota (+15 obrażeń)");
            System.out.println("5. Zielony pierścień (+20 życia): " + greenRingPrice + " sztuk złota");
            break;
        default:
            input = "0";
    }
} while (!input.equals("0"));
    }



    public static void checkRequirement(int gold, Player player, Item item){

        if (item.isGear()) {
            if (gold > player.getGold()) {
                Fonts.topText = "Not enough gold";
            } else {
                item = Item.gearPiece[Item.currentSlot];
                Equipment.eqSlot++;
                Item.currentSlot++;
            }
        }
        else if (item.isUsable() && item.getMaxStock() > 0){
            if (gold > player.getGold()) {
                Fonts.topText = "Not enough gold";
            } else {
                Soundtrack.coin.play();
                item.setStock(item.getStock() + 1);
                item.setMaxStock(item.getMaxStock() - 1);
                player.setGold(player.getGold() - item.getBuyPrice());
                GameApp.usableList.add(item.getImage());
                Item.edible.add(item);
                Fonts.topText = "You've bought " + item.getName() + " for " + gold;

            }
        }
        else if (item.getMaxStock() == 0){
            Fonts.topText = "Out of stock";
        }

    }

    public static void makeAShopList(){
        shopList = new List<Sprite>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Sprite> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Sprite sprite) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Sprite> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Sprite> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Sprite get(int index) {
                return null;
            }

            @Override
            public Sprite set(int index, Sprite element) {
                return null;
            }

            @Override
            public void add(int index, Sprite element) {

            }

            @Override
            public Sprite remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Sprite> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Sprite> listIterator(int index) {
                return null;
            }

            @Override
            public List<Sprite> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        GameApp.usableList = new List<Sprite>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Sprite> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Sprite sprite) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Sprite> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Sprite> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Sprite get(int index) {
                return null;
            }

            @Override
            public Sprite set(int index, Sprite element) {
                return null;
            }

            @Override
            public void add(int index, Sprite element) {

            }

            @Override
            public Sprite remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Sprite> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Sprite> listIterator(int index) {
                return null;
            }

            @Override
            public List<Sprite> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }


}
