package Project_take1.abilities;

import Project_take1.MyCharacter;

public class SaveAbility extends AbstractCompAbility{
    int bonus;
    public SaveAbility(MyCharacter myCharacter, String abilityName, Boolean proficiency, int STAT){
        this.abilityName=abilityName;
        this.STAT=STAT;
        this.expertise = false;
        this.proficiency = proficiency;
        this.myCharacter=myCharacter;
        setModifier();
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int getModifier() {
        setModifier();
        return modifier;
    }
    @Override
    public void setModifier(){
        int profBonus=0;
        int stat=MyCharacter.getCorrespondingStat(STAT);
        if(isProficiency()){
            profBonus = myCharacter.getProfBonus();
        }
        modifier=profBonus+myCharacter.getBaseAbility(stat).getModifier();
    }
}
