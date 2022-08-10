package Project_take1.abilities;

import Project_take1.MyCharacter;

public abstract class AbstractCompAbility extends AbstractAbility {
    protected boolean proficiency;

    public void setProficiency(boolean proficiency) {
        this.proficiency = proficiency;
    }

    public boolean hasProficiency() {
        return proficiency;
    }

}
