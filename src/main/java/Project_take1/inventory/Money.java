package Project_take1.inventory;

import org.jetbrains.annotations.NotNull;

public class Money extends Currency implements Comparable<Money>{
    int cp;
    int sp;
    int ep;
    int gp;
    int pp;

    public Money(int cp, int sp, int ep, int gp, int pp){
        if(cp < 0 || sp < 0 || ep < 0 || gp < 0 || pp < 0)
        {
            throw new IllegalArgumentException("The money must be positive or 0");
        }
        this.cp = cp;
        this.sp = sp;
        this.ep = ep;
        this.gp = gp;
        this.pp = pp;
        fixMoney();
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public void addMoney(Money sum){
        cp += sum.cp;
        sp += sum.sp;
        ep += sum.ep;
        gp += sum.gp;
        pp += sum.pp;
        fixMoney();
    }
    public void subMoney(Money min){
        if(min.compareTo(this) > 0){
            throw new RuntimeException("Transaction failed");
        }
        this.toCopper();
        min.toCopper();
        this.cp -= min.getCp();
        this.fixMoney();
    }
    public void fixMoney(){
        toCopper();
        if(getCurrency(PLATINUM)){
            pp = convert(COPPER, PLATINUM, cp);
            cp -= convert(COPPER, PLATINUM, cp)*getConversion(PLATINUM);
        }
        if(getCurrency(GOLD)){
            gp = convert(COPPER, GOLD, cp);
            cp -= convert(COPPER, GOLD, cp)*getConversion(GOLD);
        }
        if(getCurrency(ELECTRUM)){
            ep = convert(COPPER, ELECTRUM, cp);
            cp -= convert(COPPER, ELECTRUM, cp)*getConversion(ELECTRUM);
        }
        if(getCurrency(SILVER)){
            sp = convert(COPPER, SILVER, cp);
            cp -= convert(COPPER, SILVER, cp)*getConversion(SILVER);
        }
        if(!getCurrency(COPPER)) {
            cp = 0;
        }
    }
    private void toCopper() {
        cp += convert(SILVER, COPPER, sp) + convert(ELECTRUM, COPPER, ep) + convert(GOLD, COPPER, gp) + convert(PLATINUM, COPPER, pp);
        sp = 0;
        gp = 0;
        ep = 0;
        pp = 0;
    }

    @Override
    public String toString() {
        return "Money{" + "cp=" + cp + ", sp=" + sp + ", ep=" + ep + ", gp=" + gp + ", pp=" + pp + '}';
    }

    @Override
    public int compareTo(@NotNull Money o) {
        o.toCopper();
        this.toCopper();
        int ret = Integer.compare(this.getCp(), o.getCp());
        o.fixMoney();
        this.fixMoney();
        return ret;
    }
}