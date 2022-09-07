package Project_take1.abilities;

import Project_take1.MyCharacter;

public class ListAbility extends AbstractCompAbility{
    int bonus=0;
    public ListAbility(MyCharacter myCharacter, String abilityName, Boolean proficiency, Boolean expertise, int STAT){
        this.abilityName=abilityName;
        this.STAT=STAT;
        this.proficiency = proficiency;
        this.expertise=expertise;
        this.myCharacter=myCharacter;
        setModifier();
    }

    public boolean hasExpertise(){
        return expertise;
    }

    public void setExpertise(boolean expertise){
        this.expertise=expertise;
        myCharacter.updateExpProf(expertise, proficiency, STAT);
    }

    @Override
    public int getModifier() {
        return modifier;
    }
    @Override
    public void setModifier() {
        int modifier=0;
        int profBonus=0;
        if(isProficiency()){
            profBonus= myCharacter.getProfBonus();
        }
        if(hasExpertise()){
            profBonus= myCharacter.getProfBonus()*2;
        }
        int baseStat=MyCharacter.getCorrespondingStat(STAT);
        if(baseStat<MyCharacter.STRENGTH||baseStat>MyCharacter.CHARISMA){
            throw new IllegalStateException("ListAbility tried to set it's modifier, but couldn't get the right basemodifier (STAT) isn't one of strength, dex...\n" +
                    "baseStat = " + baseStat );
        }
        modifier=profBonus+myCharacter.getBaseAbility(baseStat).getModifier();
        this.modifier=modifier;
    }
}
