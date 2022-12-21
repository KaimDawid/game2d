package Objects.Items;

import Mobs.Player;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public abstract class Gear extends Item {
    boolean isGear = true;
    boolean isUsable = false;
    public static boolean success;

    public abstract boolean isEquip();

    public abstract void setEquip(boolean equip);
}
