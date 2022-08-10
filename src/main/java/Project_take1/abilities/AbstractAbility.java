package Project_take1.abilities;

import Project_take1.MyCharacter;

public abstract class AbstractAbility implements Ability{
    protected int modifier;
    protected int STAT;
    protected MyCharacter myCharacter;
    protected String abilityName;
    public int getSTAT() {
        return STAT;
    }

    public void setSTAT(int STAT) {
        this.STAT = STAT;
    }

    public abstract void setModifier();
}
