package Project_take1.inventory;

import java.util.ArrayList;

public class Armor extends Item{
    int ca;
    Boolean dex_bonus;
    int min_str;
    int max_bonus;
    Boolean stealth_dis;

    public Armor(String name, int quantity, double weight, ArrayList<String> description, String category, Money price,
                 int ca, Boolean dex_bonus, int min_str, int max_bonus, Boolean stealth_dis) {
        super(name, quantity, weight, description, category, price);
        this.ca = ca;
        this.dex_bonus = dex_bonus;
        this.min_str = min_str;
        this.max_bonus = max_bonus;
        this.stealth_dis = stealth_dis;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public Boolean getDex_bonus() {
        return dex_bonus;
    }

    public void setDex_bonus(Boolean dex_bonus) {
        this.dex_bonus = dex_bonus;
    }

    public int getMin_str() {
        return min_str;
    }

    public void setMin_str(int min_str) {
        this.min_str = min_str;
    }

    public int getMax_bonus() {
        return max_bonus;
    }

    public void setMax_bonus(int max_bonus) {
        this.max_bonus = max_bonus;
    }

    public Boolean getStealth_dis() {
        return stealth_dis;
    }

    public void setStealth_dis(Boolean stealth_dis) {
        this.stealth_dis = stealth_dis;
    }

    @Override
    public String toString() {
        return "Armor{" + "ca=" + ca + ", dex_bonus=" + dex_bonus + ", min_str=" + min_str + ", max_bonus=" + max_bonus + ", stealth_dis=" + stealth_dis + ", name='" + name + '\'' + ", quantity=" + quantity + ", weight=" + weight + ", description='" + description + '\'' + ", category='" + category + '\'' + ", price=" + price + '}';
    }
}
