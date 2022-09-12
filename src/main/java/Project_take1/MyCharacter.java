package Project_take1;

import Project_take1.abilities.*;
import Project_take1.containers.MyCharacterSheet;
import Project_take1.inventory.Inventory;
import Project_take1.spells.KnownSpell;
import Project_take1.spells.Spell;
import Project_take1.utils.SavingUtils;

import java.sql.SQLException;
import java.util.*;

public class MyCharacter implements MyCharacterCons{
    //static STATS (STATESTEKS!)
    UUID uuid = UUID.randomUUID();
    String name;
    String race;
    String classCh;
    int lvl = 10;
    int maxHp = 15;
    int currentHp = 15;
    int temporary_hp = 0;
    int initiative = 4;
    int profBonus = 1;
    int ac = 14;
    int speed=9;
    public ArrayList<Integer> intStat = new ArrayList<>();
    public ArrayList<Boolean> saveProf = new ArrayList<>();
    public ArrayList<Boolean> abilityProfExp = new ArrayList<>();
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
    Inventory inventory = new Inventory(uuid);
    KnownSpell spells = new KnownSpell(uuid);

    MyCharacterSheet myCharacterSheet;
    public String getName() {
        return name;
    }
    public MyCharacter(String name, String race, String classCh, ArrayList<Integer> intStat, ArrayList<Boolean> saveProf, ArrayList<Boolean> abilityProfExp) {
        this.name = name;
        this.race = race;
        this.classCh = classCh;
        this.intStat = intStat;
        this.saveProf = saveProf;
        this.abilityProfExp = abilityProfExp;
        this.inventory = new Inventory(this.getUuid());
        abilityInit();
        charInit();
        try {
            SavingUtils.insertChar(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public MyCharacter() {
        name = "Leario";
        classCh = "Paladin";
        race = "Human";
        for(int i = 0; i<6; i++)
        {
            intStat.add(10);
            saveProf.add(true);
        }
        for(int j = ACROBATICS; j <= SURVIVAL; j++)
        {
            abilityProfExp.add(Boolean.TRUE);
            abilityProfExp.add(Boolean.FALSE);
        }
        abilityInit();
        charInit();
    }
    public MyCharacter(UUID uuid, String name, String race, String classCh, int lvl, int maxHp, int currentHp,
                       int temporary_hp, int initiative, int profBonus, int ac, int speed, ArrayList<Integer> intStat,
                       ArrayList<Boolean> saveProf, ArrayList<Boolean> abilityProfExp) {
        this.uuid = uuid;
        this.race = race;
        this.classCh = classCh;
        this.name = name;
        this.lvl = lvl;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.temporary_hp = temporary_hp;
        this.initiative = initiative;
        this.profBonus = profBonus;
        this.ac = ac;
        this.speed = speed;
        this.intStat = intStat;
        this.saveProf = saveProf;
        this.abilityProfExp = abilityProfExp;
        abilityInit();
        try {
            spells = new KnownSpell(uuid);
            spells.setSpells(SavingUtils.getAllSpell(this.uuid));
            inventory.setId(uuid);
            inventory.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public MyCharacter(String name){
        for(int i = 0; i<6; i++)
        {
            intStat.add(10);
            saveProf.add(true);
        }
        for(int j = ACROBATICS; j <= SURVIVAL; j++)
        {
            abilityProfExp.add(Boolean.TRUE);
            abilityProfExp.add(Boolean.FALSE);
        }
        abilityInit();
        charInit();
        this.name = name;
        try {
            SavingUtils.insertChar(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        if(STAT >= STRENGTH && STAT <= CHARISMA)
        {
            return intStat.get(STAT - 1);
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
        this.intStat.set(STAT - 1, value);
        getBaseAbility(STAT).setValue(value);
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Boolean getProfStat(int STAT) {
        if(STAT >= STRENGTH && STAT <= CHARISMA){
            return saveProf.get(STAT - 1);
        }
        else{
            throw new IllegalArgumentException("The value of the parameter must be lower than 7");
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

         this.strength_save =new SaveAbility(this,"Strength",getProfStat(STRENGTH),STRENGTH_SAVE);
         this.dexterity_save=new SaveAbility(this,"Dexterity",getProfStat(DEXTERITY),DEXTERITY_SAVE);
         this.constitution_save=new SaveAbility(this,"Constitution",getProfStat(CONSTITUTION),CONSTITUTION_SAVE);
         this.intelligence_save=new SaveAbility(this,"Intelligence",getProfStat(INTELLIGENCE),INTELLIGENCE_SAVE);
         this.wisdom_save=new SaveAbility(this,"Wisdom",getProfStat(WISDOM),WISDOM_SAVE);
         this.charisma_save=new SaveAbility(this,"Charisma",getProfStat(CHARISMA),CHARISMA_SAVE);

         this.acrobatics=new ListAbility(this,"Acrobatics",getProficiency(ACROBATICS),getExpertise(ACROBATICS),ACROBATICS);
         this.animal_handling=new ListAbility(this,"Animal Handling",getProficiency(ANIMAL_HANDLING),getExpertise(ANIMAL_HANDLING),ANIMAL_HANDLING);
         this.arcana=new ListAbility(this,"Arcana",getProficiency(ARCANA),getExpertise(ARCANA),ARCANA);
         this.athletics=new ListAbility(this,"Athletics",getProficiency(ATHLETICS),getExpertise(ATHLETICS),ATHLETICS);
         this.deception=new ListAbility(this,"Deception",getProficiency(DECEPTION),getExpertise(DECEPTION),DECEPTION);
         this.history=new ListAbility(this,"History",getProficiency(HISTORY),getExpertise(HISTORY),HISTORY);
         this.insight=new ListAbility(this,"Insight",getProficiency(INSIGHT),getExpertise(INSIGHT),INSIGHT);
         this.intimidation=new ListAbility(this,"Intimidation",getProficiency(INTIMIDATION),getExpertise(INTIMIDATION),INTIMIDATION);
         this.investigation=new ListAbility(this,"Investigation",getProficiency(INVESTIGATION),getExpertise(INVESTIGATION),INVESTIGATION);
         this.medicine=new ListAbility(this,"Medicine",getProficiency(MEDICINE),getExpertise(MEDICINE),MEDICINE);
         this.nature=new ListAbility(this,"Nature",getProficiency(NATURE),getExpertise(NATURE),NATURE);
         this.perception=new ListAbility(this,"Perception",getProficiency(PERCEPTION),getExpertise(PERCEPTION),PERCEPTION);
         this.performance=new ListAbility(this,"Performance",getProficiency(PERFORMANCE),getExpertise(PERFORMANCE),PERFORMANCE);
         this.persuasion=new ListAbility(this,"Persuasion",getProficiency(PERSUASION),getExpertise(PERSUASION),PERSUASION);
         this.religion=new ListAbility(this,"Religion",getProficiency(RELIGION),getExpertise(RELIGION),RELIGION);
         this.sleight_of_hand=new ListAbility(this,"Sleight of hand",getProficiency(SLEIGHT_OF_HAND),getExpertise(SLEIGHT_OF_HAND),SLEIGHT_OF_HAND);
         this.stealth=new ListAbility(this,"Stealth",getProficiency(STEALTH),getExpertise(STEALTH),STEALTH);
         this.survival=new ListAbility(this,"Survival",getProficiency(SURVIVAL),getExpertise(SURVIVAL),SURVIVAL);

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
    public AbstractCompAbility getCompAbility(int STAT) {
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
    public Boolean getProficiency(int STAT){
        if(STAT >= ACROBATICS && STAT <= SURVIVAL) {
            return abilityProfExp.get(2*(STAT - ACROBATICS));
        }
        else {
            throw new IllegalArgumentException("STAT field in MyCharacter.ListAbility(int STAT); can only be" +
                    " MyCharacter.ACROBATICS< STAT < MyCharacter.SURVIVAL");
        }
    }
    public Boolean getExpertise(int STAT){
        if(STAT >= ACROBATICS && STAT <= SURVIVAL) {
            return abilityProfExp.get(2*(STAT - ACROBATICS) + 1);
        }
        else
        {
            throw new IllegalArgumentException("STAT field in MyCharacter.ListAbility(int STAT); can only be" +
                    " MyCharacter.ACROBATICS< STAT < MyCharacter.SURVIVAL");
        }
    }
    public AbstractAbility getAbility(int STAT) {
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
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getInitiative(){
        return initiative;
    }
    public void setInitiative(int initiative){
        this.initiative=initiative;
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void assignSheet(MyCharacterSheet myCharacterSheet){
        this.myCharacterSheet=myCharacterSheet;
    }
    public void requestUpdate(){
        abilityUpdate();
        myCharacterSheet.updatePanel();
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTemporary_hp() {
        return temporary_hp;
    }

    public void setTemporary_hp(int temporary_hp) {
        this.temporary_hp = temporary_hp;
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UUID getUuid() {
        return uuid;
    }
    public void setName(String name) {
        this.name = name;
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertWeapon(){

    }

    public String getRace() {
        return race;
    }

    public String getStringInitiative() {
        if(getInitiative()<0){
            return String.valueOf(getInitiative());
        }
        else{
            return "+" + getInitiative();
        }
    }

    public String toStringS(){
        StringBuilder s =
                new StringBuilder(uuid.toString()).append("\n").append(name).append("\t").append(race).append("\t").append(classCh).append("\n");
        s.append("Strength:").append(getIntStat(STRENGTH)).append("\t");
        s.append("Dexterity:").append(getIntStat(DEXTERITY)).append("\n");
        s.append("Constitution:").append(getIntStat(CONSTITUTION)).append("\t");
        s.append("Intelligence:").append(getIntStat(INTELLIGENCE)).append("\n");
        s.append("Wisdom:").append(getIntStat(WISDOM)).append("\t");
        s.append("Charisma:").append(getIntStat(CHARISMA)).append("\n");
        return s.toString();
    }

    public String getClassCh() {
        return classCh;
    }

    public void setClassCh(String classCh) {
        this.classCh = classCh;
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public KnownSpell getKnownSpells() {
        return spells;
    }

    public void setSpells(KnownSpell spells) {
        this.spells = spells;
    }

    public void insertSpell(Spell spell){
        spells.insert(spell);
    }


    public void updateExpProf(Boolean exp, Boolean prof, int STAT){
        if(STAT >= MyCharacter.ACROBATICS && STAT <= MyCharacter.SURVIVAL){
            abilityProfExp.set((STAT - ACROBATICS) * 2, prof);
            abilityProfExp.set((STAT - ACROBATICS) * 2 + 1, exp);
        } else {
            saveProf.set(STAT - STRENGTH_SAVE, prof);
        }
        try {
            SavingUtils.updateCharacter(this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
    public void setUuid(UUID id){
        uuid = id;
    }
}
