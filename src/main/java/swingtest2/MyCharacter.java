package swingtest2;

public class MyCharacter {
    public static final int STR = 1;
    public static final int DEX = 2;
    public static final int CON = 3;
    public static final int INT = 4;
    public static final int WIS = 5;
    public static final int CHA = 6;

    int lv = 5;

    int str = 10;
    int dex = 10;
    int con = 10;
    int ing = 10;
    int wis = 10;
    int cha = 10;

    Boolean strComp = true;
    Boolean dexComp = false;
    Boolean conComp = false;
    Boolean ingComp = true;
    Boolean wisComp = true;
    Boolean chaComp = false;


    public void setStrComp(Boolean strComp) {
        this.strComp = strComp;
    }

    public void setDexComp(Boolean dexComp) {
        this.dexComp = dexComp;
    }

    public void setConComp(Boolean conComp) {
        this.conComp = conComp;
    }

    public void setIngComp(Boolean ingComp) {
        this.ingComp = ingComp;
    }

    public void setWisComp(Boolean wisComp) {
        this.wisComp = wisComp;
    }

    public void setChaComp(Boolean chaComp) {
        this.chaComp = chaComp;
    }

    public Boolean getStrComp() {
        return strComp;
    }

    public Boolean getDexComp() {
        return dexComp;
    }

    public Boolean getConComp() {
        return conComp;
    }

    public Boolean getIngComp() {
        return ingComp;
    }

    public Boolean getWisComp() {
        return wisComp;
    }

    public Boolean getChaComp() {
        return chaComp;
    }

    /**
     * All setters
     */
    public void setStr(int str) {
        this.str = str;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public void setInt(int ing) {
        this.ing = ing;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    /**
     * All getter
     */
    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getCon() {
        return con;
    }

    public int getInt() {
        return ing;
    }

    public int getWis() {
        return wis;
    }

    public int getCha() {
        return cha;
    }
    /**
     * Special getters for attributes modifiers
     */
    public int getModStr() {
        return (str - 10)/2;
    }

    public int getModDex() {
        return (dex - 10)/2;
    }

    public int getModCon() {
        return (con - 10)/2;
    }

    public int getModInt() {
        return (ing - 10)/2;
    }

    public int getModWis() {
        return (wis - 10)/2;
    }

    public int getModCha() {
        return (cha - 10)/2;
    }

}
