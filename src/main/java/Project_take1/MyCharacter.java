package Project_take1;

import Project_take1.abilities.*;
import Project_take1.containers.MyCharacterSheet;

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
    String name = "Leario";
    int lvl = 10;
    int maxHp = 15;
    int currentHp = 15;
    int temporary_hp = 0;
    int initiative=4;
    int profBonus = 1;
    int ac = 14;

    public String getName() {
        return name;
    }

    int speed=9;

    private int intStrength = 10;
    private int intDexterity = 10;
    private int intConstitution = 10;
    private int intIntelligence = 10;
    private int intWisdom = 10;
    private int intCharisma = 10;

    BaseAbility strength;
    BaseAbility dexterity;
    BaseAbility constitution;
    BaseAbility intelligence;
    BaseAbility wisdom;
    BaseAbility charisma;

    SaveAbility strength_save;
    private Boolean strengthProf = false;
    SaveAbility dexterity_save;
    private Boolean dexterityProf = true;
    SaveAbility constitution_save;
    private Boolean constitutionProf = true;
    SaveAbility intelligence_save;
    private Boolean intelligenceProf = false;
    SaveAbility wisdom_save;
    private Boolean wisdomProf = false;
    SaveAbility charisma_save;
    private Boolean charismaProf = true;

    ListAbility acrobatics;
    private Boolean acrobaticsProf = false;
    private Boolean acrobaticsExp = false;
    ListAbility animal_handling;
    private Boolean animal_handlingProf = false;
    private Boolean animal_handlingExp = false;
    ListAbility arcana;
    private Boolean arcanaProf = false;
    private Boolean arcanaExp = false;
    ListAbility athletics;
    private Boolean athleticsProf = false;
    private Boolean athleticsExp = false;
    ListAbility deception;
    private Boolean deceptionProf = false;
    private Boolean deceptionExp = false;
    ListAbility history;
    private Boolean historyProf = false;
    private Boolean historyExp = false;
    ListAbility insight;
    private Boolean insightProf = false;
    private Boolean insightExp = false;
    ListAbility intimidation;
    private Boolean intimidationProf = false;
    private Boolean intimidationExp = false;
    ListAbility investigation;
    private Boolean investigationProf = false;
    private Boolean investigationExp = false;
    ListAbility medicine;
    private Boolean medicineProf = false;
    private Boolean medicineExp = false;
    ListAbility nature;
    private Boolean natureProf = false;
    private Boolean natureExp = false;
    ListAbility perception;
    private Boolean perceptionProf = false;
    private Boolean perceptionExp = false;
    ListAbility performance;
    private Boolean performanceProf = false;
    private Boolean performanceExp = false;
    ListAbility persuasion;
    private Boolean persuasionProf = false;
    private Boolean persuasionExp = false;
    ListAbility religion;
    private Boolean religionProf = false;
    private Boolean religionExp = false;
    ListAbility sleight_of_hand;
    private Boolean sleight_of_handProf = false;
    private Boolean sleight_of_handExp = false;
    ListAbility stealth;
    private Boolean stealthProf = false;
    private Boolean stealthExp = false;
    ListAbility survival;
    private Boolean survivalProf = false;
    private Boolean survivalExp = false;
    MyCharacterSheet myCharacterSheet;

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
                "static attributes of MyCharacter\n It found STAT = " + STAT);}
    }
    public int getIntStat(int STAT) {
        if(STAT == STRENGTH){
            return this.intStrength;
        }
        if(STAT == DEXTERITY) {
            return this.intDexterity;
        }
        if(STAT == CONSTITUTION){
            return this.intConstitution;
        }
        if(STAT == INTELLIGENCE){
            return this.intIntelligence;
        }
        if(STAT == WISDOM){
            return this.intWisdom;
        }
        if(STAT == CHARISMA){
            return this.intCharisma;
        }
        else{
            throw new IllegalArgumentException("The value of the parameter must be lower than 7");
        }
    }

    /**
     * This method update the int value of a stat and his BaseStat representation
     * @param STAT  The index of the stat
     * @param value The new value of the stat
     */
    public void updateIntStat(int STAT, int value){
        if(value < 0)
        {
            throw new IllegalArgumentException("The value of the stat must be <= 0");
        }
        if(STAT < STRENGTH || STAT > CHARISMA){
            throw new IllegalArgumentException("The value doesn't represent any BaseAbility");
        }
        if(STAT == STRENGTH){
            this.intStrength = value;
            this.getBaseAbility(STRENGTH).setValue(value);
        }
        if(STAT == DEXTERITY) {
            this.intDexterity = value;
            this.getBaseAbility(DEXTERITY).setValue(value);
        }
        if(STAT == CONSTITUTION){
            this.intConstitution = value;
            this.getBaseAbility(CONSTITUTION).setValue(value);
        }
        if(STAT == INTELLIGENCE){
            this.intIntelligence = value;
            this.getBaseAbility(INTELLIGENCE).setValue(value);
        }
        if(STAT == WISDOM){
            this.intWisdom = value;
            this.getBaseAbility(WISDOM).setValue(value);
        }
        if(STAT == CHARISMA){
            this.intCharisma = value;
            this.getBaseAbility(CHARISMA).setValue(value);
        }
    }
    public void abilityInit(){
        //remember to pull from database!!!
         this.strength=new BaseAbility(this,getIntStat(STRENGTH),STRENGTH);
         this.dexterity=new BaseAbility(this,getIntStat(DEXTERITY),DEXTERITY);
         this.constitution=new BaseAbility(this,getIntStat(CONSTITUTION),CONSTITUTION);
         this.intelligence=new BaseAbility(this,getIntStat(INTELLIGENCE),INTELLIGENCE);
         this.wisdom=new BaseAbility(this,getIntStat(WISDOM),WISDOM);
         this.charisma=new BaseAbility(this,getIntStat(CHARISMA),CHARISMA);

         this.strength_save =new SaveAbility(this,"Strength",strengthProf,STRENGTH_SAVE);
         this.dexterity_save=new SaveAbility(this,"Dexterity",dexterityProf,DEXTERITY_SAVE);
         this.constitution_save=new SaveAbility(this,"Constitution",constitutionProf,CONSTITUTION_SAVE);
         this.intelligence_save=new SaveAbility(this,"Intelligence",intelligenceProf,INTELLIGENCE_SAVE);
         this.wisdom_save=new SaveAbility(this,"Wisdom",wisdomProf,WISDOM_SAVE);
         this.charisma_save=new SaveAbility(this,"Charisma",charismaProf,CHARISMA_SAVE);

         this.acrobatics=new ListAbility(this,"Acrobatics",acrobaticsProf,acrobaticsExp,ACROBATICS);
         this.animal_handling=new ListAbility(this,"Animal Handling",animal_handlingProf,animal_handlingExp,ANIMAL_HANDLING);
         this.arcana=new ListAbility(this,"Arcana",arcanaProf,arcanaExp,ARCANA);
         this.athletics=new ListAbility(this,"Athletics",athleticsProf,athleticsExp,ATHLETICS);
         this.deception=new ListAbility(this,"Deception",deceptionProf,deceptionExp,DECEPTION);
         this.history=new ListAbility(this,"History",historyProf,historyExp,HISTORY);
         this.insight=new ListAbility(this,"Insight",insightProf,insightExp,INSIGHT);
         this.intimidation=new ListAbility(this,"Intimidation",intimidationProf,intimidationExp,INTIMIDATION);
         this.investigation=new ListAbility(this,"Investigation",investigationProf,investigationExp,INVESTIGATION);
         this.medicine=new ListAbility(this,"Medicine",medicineProf,medicineExp,MEDICINE);
         this.nature=new ListAbility(this,"Nature",natureProf,natureExp,NATURE);
         this.perception=new ListAbility(this,"Perception",perceptionProf,perceptionExp,PERCEPTION);
         this.performance=new ListAbility(this,"Performance",performanceProf,performanceExp,PERFORMANCE);
         this.persuasion=new ListAbility(this,"Persuasion",persuasionProf,persuasionExp,PERSUASION);
         this.religion=new ListAbility(this,"Religion",religionProf,religionExp,RELIGION);
         this.sleight_of_hand=new ListAbility(this,"Sleight of hand",sleight_of_handProf,sleight_of_handExp,SLEIGHT_OF_HAND);
         this.stealth=new ListAbility(this,"Stealth",stealthProf,stealthExp,STEALTH);
         this.survival=new ListAbility(this,"Survival",survivalProf,survivalExp,SURVIVAL);

    }
    public void charInit(){

    }
    public void abilityUpdate(){
        strength_save.setModifier();
        dexterity_save.setModifier();
        constitution_save.setModifier();
        intelligence_save.setModifier();
        wisdom_save.setModifier();
        charisma_save.setModifier();
        acrobatics.setModifier();
        animal_handling.setModifier();
        arcana.setModifier();
        athletics.setModifier();
        deception.setModifier();
        history.setModifier();
        insight.setModifier();
        intimidation.setModifier();
        investigation.setModifier();
        medicine.setModifier();
        nature.setModifier();
        perception.setModifier();
        performance.setModifier();
        persuasion.setModifier();
        religion.setModifier();
        sleight_of_hand.setModifier();
        stealth.setModifier();
        survival.setModifier();

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
                    " MyCharacter.STRENGTH <= STAT <= MyCharacter.CHARISMA\n"+"The function found "+ STAT);
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

    public ListAbility getListAbility(int STAT) {
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
    public String getStringProfBonus(){
        if(profBonus>=0){
            return "+" + Integer.toString(profBonus);
        }
        else{
            return Integer.toString(profBonus);
        }
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
    public void assignSheet(MyCharacterSheet myCharacterSheet){
        this.myCharacterSheet=myCharacterSheet;
    }
    public void requestUpdate(){
        abilityUpdate();
        myCharacterSheet.updatePanel();
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getTemporary_hp() {
        return temporary_hp;
    }

    public void setTemporary_hp(int temporary_hp) {
        this.temporary_hp = temporary_hp;
    }
}
