package Project_take1.classes;

import Project_take1.MyCharacter;

import java.util.ArrayList;

public class Class implements MyClass{
    protected String name;
    ArrayList<Integer> primaryStat = new ArrayList<>();
    ArrayList<Integer> chPrimaryStat = new ArrayList<>();
    ArrayList<Integer> saveProf = new ArrayList<>();
    ArrayList<Integer> chAbilityPro = new ArrayList<>();
    ArrayList<Integer> chAbilityExp = new ArrayList<>();
    ArrayList<Integer> AbilityProf = new ArrayList<>();
    ArrayList<Integer> AbilityExp = new ArrayList<>();
    int profPoint = 0;
    int abPoint = 0;

    public Class(String name) {
        this.name = name;
        if(this.name.equalsIgnoreCase("Barbarian")){
            profPoint = 2;
            chAbilityPro.add(MyCharacter.ANIMAL_HANDLING);
            chAbilityPro.add(MyCharacter.ATHLETICS);
            chAbilityPro.add(MyCharacter.INTIMIDATION);
            chAbilityPro.add(MyCharacter.NATURE);
            chAbilityPro.add(MyCharacter.PERCEPTION);
            chAbilityPro.add(MyCharacter.SURVIVAL);
            primaryStat.add(MyCharacter.STRENGTH);
            saveProf.add(MyCharacter.STRENGTH_SAVE);
            saveProf.add(MyCharacter.CONSTITUTION_SAVE);
        } else if (this.name.equalsIgnoreCase("Bard")) {
            profPoint = 3;
            for(int i = MyCharacter.ACROBATICS; i <= MyCharacter.SURVIVAL; i++){
                chAbilityPro.add(i);
            }
            primaryStat.add(MyCharacter.CHARISMA);
            saveProf.add(MyCharacter.DEXTERITY_SAVE);
            saveProf.add(MyCharacter.CHARISMA_SAVE);
        } else if(this.name.equalsIgnoreCase("Cleric")){
            primaryStat.add(MyCharacter.WISDOM);
            saveProf.add(MyCharacter.WISDOM_SAVE);
            saveProf.add(MyCharacter.CHARISMA_SAVE);
            chAbilityPro.add(MyCharacter.HISTORY);
            chAbilityPro.add(MyCharacter.INSIGHT);
            chAbilityPro.add(MyCharacter.MEDICINE);
            chAbilityPro.add(MyCharacter.PERSUASION);
            chAbilityPro.add(MyCharacter.RELIGION);
            profPoint = 2;
        } else if (this.name.equalsIgnoreCase("Druid")) {
            primaryStat.add(MyCharacter.WISDOM);
            saveProf.add(MyCharacter.WISDOM_SAVE);
            saveProf.add(MyCharacter.INTELLIGENCE_SAVE);
            profPoint = 2;
            chAbilityPro.add(MyCharacter.ARCANA);
            chAbilityPro.add(MyCharacter.ANIMAL_HANDLING);
            chAbilityPro.add(MyCharacter.INSIGHT);
            chAbilityPro.add(MyCharacter.MEDICINE);
            chAbilityPro.add(MyCharacter.NATURE);
            chAbilityPro.add(MyCharacter.PERCEPTION);
            chAbilityPro.add(MyCharacter.RELIGION);
            chAbilityPro.add(MyCharacter.SURVIVAL);
        } else if (this.name.equalsIgnoreCase("Fighter")) {
            abPoint = 1;
            chPrimaryStat.add(MyCharacter.STRENGTH);
            chPrimaryStat.add(MyCharacter.DEXTERITY);
            saveProf.add(MyCharacter.STRENGTH_SAVE);
            saveProf.add(MyCharacter.CONSTITUTION_SAVE);
            profPoint = 2;
            chAbilityPro.add(ACROBATICS);
            chAbilityPro.add(ANIMAL_HANDLING);
            chAbilityPro.add(ATHLETICS);
            chAbilityPro.add(HISTORY);
            chAbilityPro.add(INSIGHT);
            chAbilityPro.add(INTIMIDATION);
            chAbilityPro.add(PERCEPTION);
            chAbilityPro.add(SURVIVAL);
        } else if(this.name.equalsIgnoreCase("Monk")) {
            abPoint = 2;
            primaryStat.add(MyCharacter.DEXTERITY);
            primaryStat.add(MyCharacter.WISDOM);
            saveProf.add(MyCharacter.STRENGTH_SAVE);
            saveProf.add(MyCharacter.DEXTERITY_SAVE);
            chAbilityPro.add(ACROBATICS);
            chAbilityPro.add(ATHLETICS);
            chAbilityPro.add(HISTORY);
            chAbilityPro.add(INSIGHT);
            chAbilityPro.add(RELIGION);
            chAbilityPro.add(STEALTH);
        } else if (this.name.equalsIgnoreCase("Paladin")) {
            primaryStat.add(STRENGTH);
            primaryStat.add(CHARISMA);
            saveProf.add(WISDOM_SAVE);
            saveProf.add(CHARISMA_SAVE);
            abPoint = 2;
            chAbilityPro.add(ATHLETICS);
            chAbilityPro.add(INSIGHT);
            chAbilityPro.add(INTIMIDATION);
            chAbilityPro.add(MEDICINE);
            chAbilityPro.add(PERSUASION);
            chAbilityPro.add(RELIGION);
        } else if (this.name.equalsIgnoreCase("Rogue")) {
            primaryStat.add(DEXTERITY);
            saveProf.add(DEXTERITY_SAVE);
            saveProf.add(INTELLIGENCE_SAVE);
            abPoint = 4;
            chAbilityPro.add(ACROBATICS);
            chAbilityPro.add(ATHLETICS);
            chAbilityPro.add(DECEPTION);
            chAbilityPro.add(INSIGHT);
            chAbilityPro.add(INTIMIDATION);
            chAbilityPro.add(INVESTIGATION);
            chAbilityPro.add(PERCEPTION);
            chAbilityPro.add(PERFORMANCE);
            chAbilityPro.add(PERSUASION);
            chAbilityPro.add(SLEIGHT_OF_HAND);
            chAbilityPro.add(STEALTH);

        } else if (this.name.equalsIgnoreCase("Sorcerer")) {
            primaryStat.add(CHARISMA);
            saveProf.add(CONSTITUTION_SAVE);
            saveProf.add(CHARISMA_SAVE);
            abPoint = 2;
            chAbilityPro.add(ARCANA);
            chAbilityPro.add(DECEPTION);
            chAbilityPro.add(INSIGHT);
            chAbilityPro.add(INTIMIDATION);
            chAbilityPro.add(PERSUASION);
            chAbilityPro.add(RELIGION);
        } else if (this.name.equalsIgnoreCase("Warlock")) {
            primaryStat.add(CHARISMA);
            saveProf.add(WISDOM_SAVE);
            saveProf.add(CHARISMA_SAVE);
            abPoint = 2;
            chAbilityPro.add(ARCANA);
            chAbilityPro.add(DECEPTION);
            chAbilityPro.add(HISTORY);
            chAbilityPro.add(INTIMIDATION);
            chAbilityPro.add(INVESTIGATION);
            chAbilityPro.add(NATURE);
            chAbilityPro.add(RELIGION);
        } else if (this.name.equalsIgnoreCase("Wizard")) {
            primaryStat.add(INTELLIGENCE);
            saveProf.add(INTELLIGENCE_SAVE);
            saveProf.add(WISDOM_SAVE);
            abPoint = 2;
            chAbilityPro.add(ARCANA);
            chAbilityPro.add(HISTORY);
            chAbilityPro.add(INSIGHT);
            chAbilityPro.add(INVESTIGATION);
            chAbilityPro.add(MEDICINE);
            chAbilityPro.add(RELIGION);
        } else {
            throw new RuntimeException("ERROR WRONG NAME: The class name is not implemented");
        }
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
