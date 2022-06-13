package Project_take1.abilities;

public abstract class AbstractCompAbility extends AbstractAbility {
    boolean competence;

    public void setCompetence(boolean competence){
        this.competence=competence;
    }
    public boolean hasCompetence(){
        return competence;
    }
}
