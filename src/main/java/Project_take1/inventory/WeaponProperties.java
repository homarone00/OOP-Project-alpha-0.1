package Project_take1.inventory;

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
}
