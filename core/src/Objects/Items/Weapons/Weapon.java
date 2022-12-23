package Objects.Items.Weapons;

import Mobs.Player;
import Objects.Items.Gear;
import Objects.Items.Item;
import com.mygdx.game.Assets;
import com.mygdx.game.Frontend.Eq.Equipment;
import com.mygdx.game.GameApp;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Weapon extends Gear {
    public static Item equippedWeapon1;
    public static Item equippedWeapon2;
    public static void giveStartingWeapon(){
        Item.gearPiece[Item.currentSlot] = new Weapon("Sztylet [WEAPON]", 0, 20, 7, 0, 1, 1, 1);
        GameApp.eqList.add(Assets.daggerSPR);
        Equipment.eqSlot++;
        Item.currentSlot++;
    }

    int hands;
    int HP;
    int DMG;
    int crit;
    int magic;
    int isWeapon = 1;

    int weaponslot = 0;



    int stock = 0;
    String shortName;

    String longName = getShortName() + " (" +getHP() +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)";
    int helmEquip;
    int chestEquip;
    int handsEquip;
    int weaponEquip = 1;
    int neckEquip;
    int isON = 0;
    int eqValue;
    int isToxic;
    int isSharp;

    public Weapon(String shortName, int HP, int DMG, int crit, int magic, int hands, int isSharp, int stock) {
        this.hands = hands;
        this.HP = HP;
        this.DMG = DMG;
        this.crit = crit;
        this.magic = magic;
        this.stock = stock;
        this.shortName = shortName;
        this.isSharp = isSharp;
    }



    @Override
    public void eqON(Player player) {
        if (weaponEquip < 2) {
            player.setMaxHP(player.getMaxHP() + HP);
            player.setHP(player.getHP() + HP);
            player.setDMG(player.getDMG() + DMG);
            player.setCritChance(player.getCritChance() + crit);
            player.setMagic(player.getMagic() + magic);
            weaponEquip = 2;
            System.out.println("Założyłeś: " +getShortName() + " (" +getHP() +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");
            isON = 1;
            eqValue = 1;

        }
        else if (weaponEquip > 1){
            player.setMaxHP(player.getMaxHP() - HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - DMG);
            player.setCritChance(player.getCritChance() - crit);
            player.setMagic(player.getMagic() - magic);

            weaponEquip = 1;
            System.out.println("Zdjąłeś: "+getShortName() + " (" +getHP() +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");
            longName();
            eqValue = 0;
        }
        else if (eqValue>0){
            System.out.println("Najpierw zdejmij swoją poprzednią zbroję");
        }

    }




    @Override
    public void eqOFF(Player player){
        if (weaponEquip > 1) {
            player.setMaxHP(player.getMaxHP() - HP);
            if (player.getHP() - HP < 1){
                player.setHP(1);
            }
            else {
                player.setHP(player.getHP() - HP);
            }
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - DMG);
            player.setCritChance(player.getCritChance() - crit);
            player.setMagic(player.getMagic() - magic);
            weaponEquip = 1;
            eqValue = 0;
            isON = 0;
        }
    }

    @Override
    public void Use(Player player) {

    }


    @Override
    public boolean isEquip() {
        return false;
    }

    @Override
    public void setEquip(boolean equip) {

    }



}
