package Project_take1.abilities;

import Project_take1.MyCharacter;

public abstract class AbstractAbility implements Ability{
    protected int baseModifier;
    protected int STAT;
    protected MyCharacter myCharacter;
    protected String abilityName;

    public int getBaseModifier() {
        return baseModifier;
    }

    public void setBaseModifier() {
        this.baseModifier=myCharacter.getBaseAbility(MyCharacter.getCorrespondingStat(STAT)).getBaseModifier();
    }

    public int getSTAT() {
        return STAT;
    }

    public void setSTAT(int STAT) {
        this.STAT = STAT;
    }
}
