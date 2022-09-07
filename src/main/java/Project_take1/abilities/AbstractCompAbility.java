package Project_take1.abilities;

public abstract class AbstractCompAbility extends AbstractAbility {
    protected Boolean proficiency;
    Boolean expertise;

    public void setProficiency(boolean proficiency) {
        this.proficiency = proficiency;
        myCharacter.updateExpProf(expertise, this.proficiency, STAT);
    }

    public Boolean isProficiency() {
        return proficiency;
    }

    public Boolean isExpertise() {
        return expertise;
    }

    public void setExpertise(boolean expertise) {
        this.expertise = expertise;
        myCharacter.updateExpProf(expertise, proficiency, STAT);
    }
}
