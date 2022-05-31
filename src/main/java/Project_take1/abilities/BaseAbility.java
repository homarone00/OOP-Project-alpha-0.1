package Project_take1.abilities;

import Project_take1.MyCharacter;

public class BaseAbility extends AbstractAbility{
    int value;
    public BaseAbility(MyCharacter myCharacter,int value, int STAT){
        if(STAT<MyCharacter.STRENGTH||STAT>MyCharacter.CHARISMA){
            throw new IllegalArgumentException("STAT field in BaseAbilityConstructor can only be MyCharacter.STRENGTH" +
                    " < STAT < MyCharacter.CHARISMA");
        }
        this.value=value;
        this.baseModifier=value/2-5;
        this.STAT=STAT;
    }

    @Override
    public int getModifier() {
       return getBaseModifier();
    }


    public void setBaseModifier(){
        this.baseModifier=value/2-5;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
