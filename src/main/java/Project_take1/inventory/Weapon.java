package Project_take1.inventory;

import Project_take1.utils.SavingUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Weapon extends Item{
    //Two static value for the hand
    final public static int ONE_HANDED = 0;
    final public static int TWO_HANDED = 1;
    String weapon_category;
    String weapon_range;
    String category_range;
    WeaponProperties properties;
    Map<String, Damage> damage;

    public Weapon(String name, int quantity, double weight, ArrayList<String> description, String category, Money price,
                  String weapon_category, String weapon_range, String category_range, WeaponProperties properties,
                  Map<String, Damage> damage) {
        super(name, quantity, weight, description, category, price);
        this.weapon_category = weapon_category;
        this.weapon_range = weapon_range;
        this.category_range = category_range;
        this.properties = properties;
        this.damage = damage;
    }
    public Weapon(String name) {
        super(name, 1, 1, new ArrayList<String>(), "weapon", new Money());
        this.weapon_category = "Default category";
        this.weapon_range = "60 m";
        this.category_range = "Range category";
        this.properties = new WeaponProperties(false,false,false,false,false,false,false,false,false,false,false);
        this.damage = new HashMap<>();
        Damage weaponDamage=new Damage("1d8","Cringing");
        damage.put("damage",weaponDamage);
    }

    public String getWeapon_category() {
        return weapon_category;
    }

    public void setWeapon_category(String weapon_category) {
        this.weapon_category = weapon_category;
        this.update();
    }

    public String getWeapon_range() {
        return weapon_range;
    }

    public void setWeapon_range(String weapon_range) {
        this.weapon_range = weapon_range;
        this.update();
    }

    public String getCategory_range() {
        return category_range;
    }

    public void setCategory_range(String category_range) {
        this.category_range = category_range;
        this.update();
    }

    public WeaponProperties getProperties() {
        return properties;
    }
    public ArrayList<String> getArrayListProperties(){
        return properties.getArrayList();
    }

    public void setProperties(WeaponProperties properties) {
        this.properties = properties;
        if(id != null){
            this.update();
        }    }

    public Map<String, Damage> getDamageMap() {
        return damage;
    }

    public void setDamageMap(Map<String, Damage> damage) {
        this.damage = damage;
        if(id != null){
            this.update();
        }    }

    /**
     * A method for the base damage
     * @return The base weapon's damage, Key damage
     */
    public Damage getDamage(){
        return damage.get("damage");
    }

    /**
     * A method for a specific damage
     * @param HAND One of the static integer of Weapon, it represents the principal characteristic of the damage
     * (Grip elemental etc)
     * @ONE_HANDED Base Damage
     * @TWO_HANDED Two-Handed Damage
     * @return The selected damage
     */
    public Damage getDamage(int HAND){
        if(HAND == ONE_HANDED || !properties.isVersatile()){
            return damage.get("damage");
        }
        if(HAND == TWO_HANDED){
            return damage.get("two hand");
        }
        else {
            throw new IllegalArgumentException("Il valore inserito non ha significato");
        }
    }

    @Override
    public String toString() {
        return "Weapon{" + "weapon_category='" + weapon_category + '\'' +
                ", weapon_range='" + weapon_range + '\'' + ", category_range='" + category_range + '\'' +
                ", properties=" + properties + ", damage=" + damage + ", name='" + name + '\'' + ", quantity=" +
                quantity + ", weight=" + weight + ", description=" + description + ", category='" + category + '\'' +
                ", price=" + price + '}';
    }
}
