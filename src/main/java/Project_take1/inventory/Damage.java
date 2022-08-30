package Project_take1.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Damage {
    String damage_dice;
    String damage_type;

    @Override
    public String toString() {
        return "Damage{" + "damage_dice='" + damage_dice + '\'' + ", damage_type='" + damage_type + '\'' + '}';
    }

    public Damage(String damage_dice, String damage_type) {
        this.damage_dice = damage_dice;
        this.damage_type = damage_type;
    }
    public Damage(String dbdmg){
        ArrayList<String> dmg = new ArrayList<>(Arrays.asList(dbdmg.split("/")));
        this.damage_dice = dmg.get(0);
        this.damage_type = dmg.get(1);
    }

    public String getDamage_dice() {
        return damage_dice;
    }

    public void setDamage_dice(String damage_dice) {
        this.damage_dice = damage_dice;
    }

    public String getDamage_type() {
        return damage_type;
    }

    public void setDamage_type(String damage_type) {
        this.damage_type = damage_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Damage damage = (Damage) o;
        return damage_dice.equals(damage.damage_dice) && damage_type.equals(damage.damage_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(damage_dice, damage_type);
    }
}
