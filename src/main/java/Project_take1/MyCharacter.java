package Project_take1;

import Project_take1.abilities.*;

import java.util.ArrayList;

public class MyCharacter {
    //static STATS (STATESTEKS!)
    public static final int STRENGTH = 1;
    public static final int DEXTERITY = 2;
    public static final int CONSTITUTION = 3;
    public static final int INTELLIGENCE = 4;
    public static final int WISDOM = 5;
    public static final int CHARISMA = 6;

    public static final int STRENGTH_SAVE=31;
    public static final int DEXTERITY_SAVE=32;
    public static final int CONSTITUTION_SAVE=33;
    public static final int INTELLIGENCE_SAVE=34;
    public static final int WISDOM_SAVE=35;
    public static final int CHARISMA_SAVE=36;

    public static final int ACROBATICS=11;
    public static final int ANIMAL_HANDLING=12;
    public static final int ARCANA=13;
    public static final int ATHLETICS=14;
    public static final int DECEPTION=15;
    public static final int HISTORY=16;
    public static final int INSIGHT=17;
    public static final int INTIMIDATION=18;
    public static final int INVESTIGATION=19;
    public static final int MEDICINE=20;
    public static final int NATURE=21;
    public static final int PERCEPTION=22;
    public static final int PERFORMANCE=23;
    public static final int PERSUASION=24;
    public static final int RELIGION=25;
    public static final int SLEIGHT_OF_HAND=26;
    public static final int STEALTH=27;
    public static final int SURVIVAL=28;

    //da aggiungere UUID
    int lvl = 10;
    int maxHp = 15;
    int currentHp = 15;
    int temporary_hp = 0;
    int initiative=4;
    int profBonus = 1;
    int ac = 14;
    int speed=9;

    int intStrength = 10;
    int intDexterity = 10;
    int intConstitution = 10;
    int intIntelligence = 10;
    int intWisdom = 10;
    int intCharisma = 10;

    BaseAbility strength;
    BaseAbility dexterity;
    BaseAbility constitution;
    BaseAbility intelligence;
    BaseAbility wisdom;
    BaseAbility charisma;

    SaveAbility strength_save;
    SaveAbility dexterity_save;
    SaveAbility constitution_save;
    SaveAbility intelligence_save;
    SaveAbility wisdom_save;
    SaveAbility charisma_save;

    ListAbility acrobatics;
    ListAbility animal_handling;
    ListAbility arcana;
    ListAbility athletics;
    ListAbility deception;
    ListAbility history;
    ListAbility insight;
    ListAbility intimidation;
    ListAbility investigation;
    ListAbility medicine;
    ListAbility nature;
    ListAbility perception;
    ListAbility performance;
    ListAbility persuasion;
    ListAbility religion;
    ListAbility sleight_of_hand;
    ListAbility stealth;
    ListAbility survival;

    public MyCharacter() {
         abilityInit();
         charInit();
    }


    public static int getCorrespondingStat(int STAT){
        ArrayList<Integer> strArray=new ArrayList<Integer>();
        strArray.add(STRENGTH);
        strArray.add(STRENGTH_SAVE);
        strArray.add(ATHLETICS);

        ArrayList<Integer> dexArray=new ArrayList<Integer>();
        dexArray.add(DEXTERITY);
        dexArray.add(DEXTERITY_SAVE);
        dexArray.add(ACROBATICS);
        dexArray.add(SLEIGHT_OF_HAND);
        dexArray.add(STEALTH);

        ArrayList<Integer>conArray=new ArrayList<Integer>();
        conArray.add(CONSTITUTION);
        conArray.add(CONSTITUTION_SAVE);

        ArrayList<Integer> intArray=new ArrayList<Integer>();
        intArray.add(INTELLIGENCE);
        intArray.add(INTELLIGENCE_SAVE);
        intArray.add(ARCANA);
        intArray.add(HISTORY);
        intArray.add(INVESTIGATION);
        intArray.add(NATURE);
        intArray.add(RELIGION);

        ArrayList<Integer> wisArray =new ArrayList<Integer>();
        wisArray.add(WISDOM);
        wisArray.add(WISDOM_SAVE);
        wisArray.add(ANIMAL_HANDLING);
        wisArray.add(INSIGHT);
        wisArray.add(MEDICINE);
        wisArray.add(PERCEPTION);
        wisArray.add(SURVIVAL);

        ArrayList<Integer> chaArray =new ArrayList<Integer>();
        chaArray.add(CHARISMA);
        chaArray.add(CHARISMA_SAVE);
        chaArray.add(DECEPTION);
        chaArray.add(INTIMIDATION);
        chaArray.add(PERFORMANCE);
        chaArray.add(PERSUASION);

        if (strArray.contains(STAT)) {
            return STRENGTH;
        }
        else if(dexArray.contains(STAT)){
            return DEXTERITY;
        }
        else if (conArray.contains(STAT)) {
            return CONSTITUTION;
        }
        else if(intArray.contains(STAT)){
            return INTELLIGENCE;
        }
        else if (wisArray.contains(STAT)) {
            return WISDOM;
        }
        else if(chaArray.contains(STAT)){
            return CHARISMA;
        }
        else{throw new IllegalArgumentException("getCorrespondingStat() can only accept parameters picked from the " +
                "static attributes of MyCharacter");}
    }
    public void abilityInit(){
        //remember to pull from database!!!
         this.strength=new BaseAbility(this,10,STRENGTH);
         this.dexterity=new BaseAbility(this,10,DEXTERITY);
         this.constitution=new BaseAbility(this,10,CONSTITUTION);
         this.intelligence=new BaseAbility(this,10,INTELLIGENCE);
         this.wisdom=new BaseAbility(this,10,WISDOM);
         this.charisma=new BaseAbility(this,10,CHARISMA);

         this.strength_save =new SaveAbility(this,"Strength",true,STRENGTH_SAVE);
         this.dexterity_save=new SaveAbility(this,"Dexterity",true,DEXTERITY_SAVE);
         this.constitution_save=new SaveAbility(this,"Constitution",true,CONSTITUTION_SAVE);
         this.intelligence_save=new SaveAbility(this,"Intelligence",true,INTELLIGENCE_SAVE);
         this.wisdom_save=new SaveAbility(this,"Wisdom",true,WISDOM_SAVE);
         this.charisma_save=new SaveAbility(this,"Charisma",true,CHARISMA_SAVE);

         this.acrobatics=new ListAbility(this,"Acrobatics",true,true,ACROBATICS);
         this.animal_handling=new ListAbility(this,"Animal Handling",true,true,ANIMAL_HANDLING);
         this.arcana=new ListAbility(this,"Arcana",true,true,ARCANA);
         this.athletics=new ListAbility(this,"Athletics",true,true,ATHLETICS);
         this.deception=new ListAbility(this,"Deception",true,true,DECEPTION);
         this.history=new ListAbility(this,"History",true,true,HISTORY);
         this.insight=new ListAbility(this,"Insight",true,true,INSIGHT);
         this.intimidation=new ListAbility(this,"Intimidation",true,true,INTIMIDATION);
         this.investigation=new ListAbility(this,"Investigation",true,true,INVESTIGATION);
         this.medicine=new ListAbility(this,"Medicine",true,true,MEDICINE);
         this.nature=new ListAbility(this,"Nature",true,true,NATURE);
         this.perception=new ListAbility(this,"Perception",true,true,PERCEPTION);
         this.performance=new ListAbility(this,"Performance",true,true,PERFORMANCE);
         this.persuasion=new ListAbility(this,"Persuasion",true,true,PERSUASION);
         this.religion=new ListAbility(this,"Religion",true,true,RELIGION);
         this.sleight_of_hand=new ListAbility(this,"Sleight of hand",true,true,SLEIGHT_OF_HAND);
         this.stealth=new ListAbility(this,"Stealth",true,true,STEALTH);
         this.survival=new ListAbility(this,"Survival",true,true,SURVIVAL);

    }
    public void charInit(){

    }
    public BaseAbility getBaseAbility(int STAT) {
        if (STAT == STRENGTH) {
            return strength;
        }
        if (STAT == DEXTERITY) {
            return dexterity;
        }
        if (STAT == CONSTITUTION) {
            return constitution;
        }
        if (STAT == INTELLIGENCE) {
            return intelligence;
        }
        if (STAT == WISDOM) {
            return wisdom;
        }
        if (STAT == CHARISMA) {
            return charisma;
        }
        else{
            throw new IllegalArgumentException("STAT field in MyCharacter.BaseAbility(int STAT); can only be" +
                    " MyCharacter.STRENGTH < STAT < MyCharacter.CHARISMA");
        }
    }
    public SaveAbility getSaveAbility(int STAT){
        if (STAT == STRENGTH_SAVE) {
            return strength_save;
        }
        if (STAT == DEXTERITY_SAVE) {
            return dexterity_save;
        }
        if (STAT == CONSTITUTION_SAVE) {
            return constitution_save;
        }
        if (STAT == INTELLIGENCE_SAVE) {
            return intelligence_save;
        }
        if (STAT == WISDOM_SAVE) {
            return wisdom_save;
        }
        if (STAT == CHARISMA_SAVE) {
            return charisma_save;
        }
        else{
            throw new IllegalArgumentException("STAT field in MyCharacter.BaseAbility(int STAT); can only be" +
                    " MyCharacter.STRENGTH_SAVE < STAT < MyCharacter.CHARISMA_SAVE");
        }
    }

    public ListAbility getListAbility(int STAT)
    {
        if(STAT == ACROBATICS)
        {
            return acrobatics;
        }
        if(STAT == ANIMAL_HANDLING)
        {
            return animal_handling;
        }
        if(STAT == ARCANA)
        {
            return arcana;
        }
        if(STAT == ATHLETICS)
        {
            return athletics;
        }
        if(STAT == DECEPTION)
        {
            return deception;
        }
        if(STAT == HISTORY)
        {
            return history;
        }
        if(STAT == INSIGHT)
        {
            return insight;
        }
        if(STAT == INTIMIDATION)
        {
            return intimidation;
        }
        if(STAT == INVESTIGATION)
        {
            return investigation;
        }
        if(STAT == MEDICINE)
        {
            return medicine;
        }
        if(STAT == NATURE)
        {
            return nature;
        }
        if(STAT == PERCEPTION)
        {
            return  perception;
        }
        if(STAT == PERFORMANCE)
        {
            return performance;
        }
        if(STAT == PERSUASION)
        {
            return persuasion;
        }
        if(STAT == RELIGION)
        {
            return religion;
        }
        if(STAT == SLEIGHT_OF_HAND)
        {
            return sleight_of_hand;
        }
        if(STAT == STEALTH)
        {
            return stealth;
        }
        if(STAT == SURVIVAL)
        {
            return survival;
        }
        else
        {
            throw new IllegalArgumentException("STAT field in MyCharacter.ListAbility(int STAT); can only be" +
                    " MyCharacter.ACROBATICS< STAT < MyCharacter.SURVIVAL");
        }
    }

    public AbstractCompAbility getCompAbility(int STAT)
    {
        try {
            return getListAbility(STAT);
        }catch (IllegalArgumentException e) {
            try {
                return getSaveAbility(STAT);
            }
            catch (IllegalArgumentException x)
            {
                throw new IllegalArgumentException("STAT field in MyCharacter.getCompAbility; out of range");
            }
        }
    }

    public AbstractAbility getAbility(int STAT)
    {
        try{
            return getBaseAbility(STAT);
        }
        catch (IllegalArgumentException e)
        {
            try {
                return getCompAbility(STAT);
            }
            catch (IllegalArgumentException ex)
            {
                throw new IllegalArgumentException("STAT field in MyCharacter.getAbility; out of range");
            }
        }
    }
    public int getAbilityModifier(int STAT){
        try {
            return getAbility(STAT).getModifier();
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("STAT field in MyCharacter.getAbilityModifier; out of range");
        }
    }
    public int getProfBonus(){
        return profBonus;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }
    public int getInitiative(){
        return initiative;
    }
    public void setInitiative(int initiative){
        this.initiative=initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
