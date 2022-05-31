package Project_take1.abilities;

import Project_take1.MyCharacter;

public class SaveAbility extends AbstractAbility{
    boolean competence;
    int bonus=0;
    public SaveAbility(MyCharacter myCharacter,String abilityName, boolean competence, int STAT){
        this.abilityName=abilityName;
        this.STAT=STAT;
        this.competence=competence;
        this.myCharacter=myCharacter;
        setBaseModifier();

    }
    public void setCompetence(boolean competence){
        this.competence=competence;
    }
    public boolean hasCompetence(){
        return competence;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override

    public int getModifier() {
        int profBonus=myCharacter.getProfBonus();
        if(competence==true){
            return getBaseModifier()+profBonus+bonus;
        }
        else{
            return getBaseModifier()+bonus;
        }
    }
}
