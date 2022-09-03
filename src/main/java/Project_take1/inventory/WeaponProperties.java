package Project_take1.inventory;

import java.util.ArrayList;

public class WeaponProperties {
    boolean ammunition;
    boolean finesse;
    boolean heavy;
    boolean light;
    boolean loading;
    boolean monk;
    boolean reach;
    boolean special;
    boolean thrown;
    boolean two_handed;
    boolean versatile;

    public WeaponProperties(boolean ammunition, boolean finesse, boolean heavy, boolean light, boolean loading,
                            boolean monk, boolean reach, boolean special, boolean thrown, boolean two_handed,
                            boolean versatile) {
        this.ammunition = ammunition;
        this.finesse = finesse;
        this.heavy = heavy;
        this.light = light;
        this.loading = loading;
        this.monk = monk;
        this.reach = reach;
        this.special = special;
        this.thrown = thrown;
        this.two_handed = two_handed;
        this.versatile = versatile;
    }
    public WeaponProperties(ArrayList<String> arrayList){
        ammunition=false;
        finesse=false;
        heavy=false;
        light=false;
        loading=false;
        monk=false;
        reach=false;
        special=false;
        thrown=false;
        two_handed=false;
        versatile=false;
        if(arrayList.contains("Ammunition")){
            ammunition=true;
        }
        if(arrayList.contains("Finesse")){
            finesse=true;
        }
        if(arrayList.contains("Heavy")){
            heavy=true;
        }
        if(arrayList.contains("Light")){
            light=true;
        }
        if(arrayList.contains("Loading")){
            loading=true;
        }
        if(arrayList.contains("Monk")){
            monk=true;
        }
        if(arrayList.contains("Reach")){
            reach=true;
        }
        if(arrayList.contains("Special")){
            special=true;
        }
        if(arrayList.contains("Trown")){
            thrown=true;
        }
        if(arrayList.contains("Two_handed")){
            two_handed=true;
        }
        if(arrayList.contains("Versatile")){
            versatile=true;
        }

    }

    public boolean isAmmunition() {
        return ammunition;
    }

    public void setAmmunition(boolean ammunition) {
        this.ammunition = ammunition;
    }

    public boolean isFinesse() {
        return finesse;
    }

    public void setFinesse(boolean finesse) {
        this.finesse = finesse;
    }

    public boolean isHeavy() {
        return heavy;
    }

    public void setHeavy(boolean heavy) {
        this.heavy = heavy;
    }

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public boolean isMonk() {
        return monk;
    }

    public void setMonk(boolean monk) {
        this.monk = monk;
    }

    public boolean isReach() {
        return reach;
    }

    public void setReach(boolean reach) {
        this.reach = reach;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public boolean isThrown() {
        return thrown;
    }

    public void setThrown(boolean thrown) {
        this.thrown = thrown;
    }

    public boolean isTwo_handed() {
        return two_handed;
    }

    public void setTwo_handed(boolean two_handed) {
        this.two_handed = two_handed;
    }

    public boolean isVersatile() {
        return versatile;
    }

    public void setVersatile(boolean versatile) {
        this.versatile = versatile;
    }

    public ArrayList<String> getArrayList() {
        ArrayList<String> arrayList= new ArrayList<>();
        if(isAmmunition()){
            arrayList.add("Ammunition");
        }
        if(isFinesse()){
            arrayList.add("Finesse");
        }
        if(isHeavy()){
            arrayList.add("Heavy");
        }
        if(isLight()){
            arrayList.add("Light");
        }
        if(isLoading()){
            arrayList.add("Loading");
        }
        if(isMonk()){
            arrayList.add("Monk");
        }
        if(isReach()){
            arrayList.add("Reach");
        }
        if(isSpecial()){
            arrayList.add("Special");
        }
        if(isThrown()){
            arrayList.add("Thrown");
        }
        if(isTwo_handed()){
            arrayList.add("Two_handed");
        }
        if(isVersatile()){
            arrayList.add("Versatile");
        }
        return arrayList;
    }

    public void updateProperties(ArrayList<String> arrayList){
        ammunition=false;
        finesse=false;
        heavy=false;
        light=false;
        loading=false;
        monk=false;
        reach=false;
        special=false;
        thrown=false;
        two_handed=false;
        versatile=false;
        if(arrayList.contains("Ammunition")){
            ammunition=true;
        }
        if(arrayList.contains("Finesse")){
            finesse=true;
        }
        if(arrayList.contains("Heavy")){
            heavy=true;
        }
        if(arrayList.contains("Light")){
            light=true;
        }
        if(arrayList.contains("Loading")){
            loading=true;
        }
        if(arrayList.contains("Monk")){
            monk=true;
        }
        if(arrayList.contains("Reach")){
            reach=true;
        }
        if(arrayList.contains("Special")){
            special=true;
        }
        if(arrayList.contains("Trown")){
            thrown=true;
        }
        if(arrayList.contains("Two_handed")){
            two_handed=true;
        }
        if(arrayList.contains("Versatile")){
            versatile=true;
        }

    }
}
