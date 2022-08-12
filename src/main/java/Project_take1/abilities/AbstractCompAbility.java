package Project_take1.abilities;

public abstract class AbstractCompAbility extends AbstractAbility {
    protected boolean proficiency;
    boolean expertise;

    public void setProficiency(boolean proficiency) {
        this.proficiency = proficiency;
    }

    public boolean isProficiency() {
        return proficiency;
    }

    public boolean isExpertise() {
        return expertise;
    }

    public void setExpertise(boolean expertise) {
        this.expertise = expertise;
    }
}
