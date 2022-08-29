package Project_take1.inventory;

import java.util.ArrayList;
import java.util.Map;

public class Weapon extends Item{
    final static int ONE_HANDED = 0;
    final static int TWO_HANDED = 1;
    String weapon_category;
    String weapon_range;
    String category_range;
    ArrayList<String> properties;
    Map<String, Damage> damage;

    public Weapon(String name, int quantity, double weight, ArrayList<String> description, String category, Money price, String weapon_category, String weapon_range, String category_range, ArrayList<String> properties, Map<String, Damage> damage) {
        super(name, quantity, weight, description, category, price);
        this.weapon_category = weapon_category;
        this.weapon_range = weapon_range;
        this.category_range = category_range;
        this.properties = properties;
        this.damage = damage;
    }

    public String getWeapon_category() {
        return weapon_category;
    }

    public void setWeapon_category(String weapon_category) {
        this.weapon_category = weapon_category;
    }

    public String getWeapon_range() {
        return weapon_range;
    }

    public void setWeapon_range(String weapon_range) {
        this.weapon_range = weapon_range;
    }

    public String getCategory_range() {
        return category_range;
    }

    public void setCategory_range(String category_range) {
        this.category_range = category_range;
    }

    public ArrayList<String> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<String> properties) {
        this.properties = properties;
    }

    public Map<String, Damage> getDamageMap() {
        return damage;
    }

    public void setDamageMap(Map<String, Damage> damage) {
        this.damage = damage;
    }

    public Damage getDamage(){
        return damage.get("damage");
    }

    public Damage getDamage(int HAND){
        if(HAND == ONE_HANDED || !properties.contains("Versatile")){
            return damage.get("damage");
        }
        if(HAND == TWO_HANDED){
            return damage.get("two_handed_damage");
        }
        else {
            throw new IllegalArgumentException("Il valore inserito non ha significato");
        }
    }

    @Override
    public String toString() {
        return "Weapon{" + "weapon_category='" + weapon_category + '\'' + ", weapon_range='" + weapon_range + '\'' + ", category_range='" + category_range + '\'' + ", properties=" + properties + ", damage=" + damage + ", name='" + name + '\'' + ", quantity=" + quantity + ", weight=" + weight + ", description=" + description + ", category='" + category + '\'' + ", price=" + price + '}';
    }
}
