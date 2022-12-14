package Logic;

import Mobs.Monster;
import Mobs.Player;
import Objects.Items.Chests.ChestArmor;
import Objects.Items.Hands.Gloves;
import Objects.Items.Helmets.HeadPiece;
import Objects.Items.Necklaces.Necklace;
import Objects.Items.Weapons.Weapon;
import com.mygdx.game.Frontend.Eq.Equipment;
import jdk.javadoc.internal.doclets.formats.html.markup.Head;

import java.util.Scanner;

import static Objects.Items.Item.gearPiece;
import static com.mygdx.game.GameApp.Dawid;

public class Inventory {

    public static Weapon EQ[] = new Weapon[50];

    public static boolean helmetON = false;
    public static boolean chestON = false;
    public static boolean weapon1ON = false;
    public static boolean weapon2ON = false;
    public static boolean glovesON = false;
    public static boolean neckON = false;
    public static Gloves emptyHands = new Gloves("empty", 0,0,0,0,1);
    public static ChestArmor emptyChest = new ChestArmor("empty", 0,0,0,0,1);
    public static HeadPiece emptyHead = new HeadPiece("empty", 0,0,0,0,1);
    public static Necklace emptyNeck = new Necklace("empty",0,0,0,0,1);
    public static Weapon emptyWeapon = new Weapon("empty",0,0,0,0,1,0,1);
    public static Weapon equippedweapon = new Weapon("test",1,1,1,1,1,1,1);
static Scanner scanner = new Scanner(System.in);

    public static void INVENTORY(Player Dawid) throws InterruptedException {
        String input2 = scanner.nextLine().toUpperCase();
        switch (input2) {

            case "0":
                Slot(0,Dawid);
                break;

            case "1":

                Slot(1,Dawid);
                break;
            case "2":
                Slot(2,Dawid);
                break;
            case "3":
                Slot(3,Dawid);
                break;
            case "4":
                Slot(4,Dawid);
                break;
            case "5":
                Slot(5,Dawid);
                break;
            case "6":
                Slot(6,Dawid);
                break;
            case "7":
                Slot(7,Dawid);
                break;
            case "8":
                Slot(8,Dawid);
                break;
            case "9":
                Slot(9,Dawid);
                break;
            case "10":
                Slot(10,Dawid);
                break;
            case "11":
                Slot(11,Dawid);
                break;
            case "12":
                Slot(12,Dawid);
                break;
            case "13":
                Slot(13,Dawid);
                break;
            case "14":
                Slot(14,Dawid);
                break;

            case "15":
                Slot(15,Dawid);
                break;

            case "16":
                Slot(16,Dawid);
                break;
            case "17":
                Slot(17,Dawid);
                break;
            case "18":
                Slot(18,Dawid);
                break;
            case "19":
                Slot(19,Dawid);
                break;
            case "21":
                Slot(21,Dawid);
                break;
            case "22":
                Slot(22,Dawid);
                break;
            case "23":
                Slot(23,Dawid);
                break;
            case "24":
                Slot(24,Dawid);
                break;
            case "25":
                Slot(25,Dawid);
                break;
            case "26":
                Slot(26,Dawid);
                break;
            case "27":
                Slot(27,Dawid);
                break;
            case "28":
                Slot(28,Dawid);
                break;
            case "29":
                Slot(29,Dawid);
                break;
            case "30":
                Slot(30,Dawid);
                break;
            case "31":
                Slot(31,Dawid);
                break;
            case "32":
                Slot(32,Dawid);
                break;
            case "33":
                Slot(33,Dawid);
                break;
            case "34":
                Slot(34,Dawid);
                break;
            case "35":
                Slot(35,Dawid);
                break;
            case "36":
                Slot(36,Dawid);
                break;
            case "37":
                Slot(37,Dawid);
                break;
            case "38":
                Slot(38,Dawid);
                break;
            case "39":
                Slot(39,Dawid);
                break;
            case "40":
                Slot(40,Dawid);
                break;


            case "OFF":
                for (int i = 0; i < 50; i++) {
                    try {
                        gearPiece[i].eqOFF(Dawid);
                    } catch (NullPointerException a) {

                    }
                }
                Monster.helmEQ = 0;
                Monster.weaponEQ--;
                Monster.neckEQ = 0;
                Monster.chestEQ = 0;
                Monster.handsEQ = 0;
                System.out.println("Zdj????e?? wszystkie przedmioty");
                Thread.sleep(500);
            default:
                break;
        }
    }



    public static void Slot(int slotNumber, Player Dawid) {

        try {
            if (gearPiece[slotNumber].getHelmEquip() > 0 && Monster.helmEQ < 1 && gearPiece[slotNumber].getIsON() < 1) {
                HeadPiece.equippedHead = gearPiece[slotNumber];
                gearPiece[slotNumber].eqON(Dawid);
                Monster.helmEQ = 1;
                gearPiece[slotNumber].setIsON(1);
            } else if (gearPiece[slotNumber].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && gearPiece[slotNumber].getIsON() < 1
             && Monster.weaponEQ == 0) {
                Weapon.equippedWeapon1 = gearPiece[slotNumber];
                equippedweapon = (Weapon) gearPiece[slotNumber];
                Equipment.currentWeapon = gearPiece[slotNumber];
                gearPiece[slotNumber].eqON(Dawid);
                Monster.weaponEQ++;
                gearPiece[slotNumber].setIsON(1);
                gearPiece[slotNumber].setWeaponslot(1);
            }
                else if (gearPiece[slotNumber].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && gearPiece[slotNumber].getIsON() < 1
                && Monster.weaponEQ == 1) {
                    Weapon.equippedWeapon2 = gearPiece[slotNumber];
                    equippedweapon = (Weapon) gearPiece[slotNumber];
                    gearPiece[slotNumber].eqON(Dawid);
                    Monster.weaponEQ++;
                    gearPiece[slotNumber].setIsON(1);
                    gearPiece[slotNumber].setWeaponslot(2);
            } else if (gearPiece[slotNumber].getNeckEquip() > 0 && Monster.neckEQ < 1 && gearPiece[slotNumber].getIsON() < 1) {
                    Necklace.equippedNeck = gearPiece[slotNumber];
                gearPiece[slotNumber].eqON(Dawid);
                Monster.neckEQ = 1;
                gearPiece[slotNumber].setIsON(1);
            } else if (gearPiece[slotNumber].getChestEquip() == 1 && Monster.chestEQ < 1 && gearPiece[slotNumber].getIsON() < 1) {
                    ChestArmor.equippedChest = gearPiece[slotNumber];
                gearPiece[slotNumber].eqON(Dawid);
                Monster.chestEQ = 1;
                gearPiece[slotNumber].setIsON(1);

            } else if (gearPiece[slotNumber].getHandsEquip() > 0 && Monster.handsEQ < 1 && gearPiece[slotNumber].getIsON() < 1) {
                    Gloves.equippedGloves = gearPiece[slotNumber];
                gearPiece[slotNumber].eqON(Dawid);
                Monster.handsEQ = 1;
                gearPiece[slotNumber].setIsON(1);
            } else if (gearPiece[slotNumber].getHelmEquip() > 0 && Monster.helmEQ > 0 && gearPiece[slotNumber].getIsON() > 0) {
                HeadPiece.equippedHead = emptyHead;
                gearPiece[slotNumber].eqOFF(Dawid);
                Monster.helmEQ = 0;
                gearPiece[slotNumber].setIsON(0);
                System.out.println("Zdj????e?? przedmiot");
            } else if (gearPiece[slotNumber].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && gearPiece[slotNumber].getIsON() > 0) {
                    if (gearPiece[slotNumber] == Weapon.equippedWeapon1) {
                        Weapon.equippedWeapon1 = emptyWeapon;
                    }
                    else if (gearPiece[slotNumber] == Weapon.equippedWeapon2){
                        Weapon.equippedWeapon2 = emptyWeapon;
                    }
                gearPiece[slotNumber].eqOFF(Dawid);
                equippedweapon = null;
                Monster.weaponEQ--;
                gearPiece[slotNumber].setIsON(0);
                System.out.println("Zdj????e?? przedmiot");
            } else if (gearPiece[slotNumber].getNeckEquip() > 0 && Monster.neckEQ > 0 && gearPiece[slotNumber].getIsON() > 0) {
                    Necklace.equippedNeck = emptyNeck;
                gearPiece[slotNumber].eqOFF(Dawid);
                Monster.neckEQ = 0;
                gearPiece[slotNumber].setIsON(0);
                System.out.println("Zdj????e?? przedmiot");
            } else if (gearPiece[slotNumber].getChestEquip() > 0 && Monster.chestEQ > 0 && gearPiece[slotNumber].getIsON() > 0) {
                    ChestArmor.equippedChest = emptyChest;
                gearPiece[slotNumber].eqOFF(Dawid);
                Monster.chestEQ = 0;
                gearPiece[slotNumber].setIsON(0);
                System.out.println("Zdj????e?? przedmiot");
            } else if (gearPiece[slotNumber].getHandsEquip() > 0 && Monster.handsEQ > 0 && gearPiece[slotNumber].getIsON() > 0) {
                    Gloves.equippedGloves = emptyHands;
                gearPiece[slotNumber].eqOFF(Dawid);
                Monster.handsEQ = 0;
                gearPiece[slotNumber].setIsON(0);
                System.out.println("Zdj????e?? przedmiot");
            } else {
                System.out.println("Najpierw zdejmij ekwipunek!");
            }
        } catch (NullPointerException a) {
            System.out.println("Nie masz tego przedmiotu");
        }
    }


    public static void addEmptyGear(){
        ChestArmor.equippedChest = emptyChest;
        HeadPiece.equippedHead = emptyHead;
        Weapon.equippedWeapon2 = emptyWeapon;
        Weapon.equippedWeapon1 = emptyWeapon;
        Necklace.equippedNeck = emptyNeck;
        Gloves.equippedGloves = emptyHands;
    }

    public static void addEquippedGear(){
        Dawid.setHP(Dawid.getHP() + Weapon.equippedWeapon1.getHP() + Weapon.equippedWeapon2.getHP() + ChestArmor.equippedChest.getHP() + Gloves.equippedGloves.getHP() + Necklace.equippedNeck.getHP()  + HeadPiece.equippedHead.getHP());
    }

    /*public static void InvPrint(int invSlots, Player player){
        for (int i = 1; i < invSlots ; i++) {

            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case i:
                    Slot(i, player);
                    break;
            }
        }
    }*/

}
