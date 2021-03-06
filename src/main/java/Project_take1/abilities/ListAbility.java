package Project_take1.abilities;

import Project_take1.MyCharacter;

import java.awt.font.TextHitInfo;

public class ListAbility extends AbstractCompAbility{
    boolean expertise;
    boolean competence;
    int bonus=0;
    public ListAbility(MyCharacter myCharacter, String abilityName, boolean competence, boolean expertise, int STAT){
        this.abilityName=abilityName;
        this.STAT=STAT;
        this.competence=competence;
        this.expertise=expertise;
        this.myCharacter=myCharacter;
        setBaseModifier();
    }

    public boolean hasExpertise(){
        return expertise;
    }

    public void setExpertise(boolean expertise){
        this.expertise=expertise;
    }

    @Override
    public int getModifier() {
        int profBonus=myCharacter.getProfBonus();
        int modifier=getBaseModifier()+bonus;
        if(competence){
            modifier+=profBonus;
        }
        if(expertise){
            modifier+=profBonus;
        }
        return modifier;
    }
}
