package Project_take1.abilities;

import Project_take1.MyCharacterCons;

public interface Ability extends MyCharacterCons {
    int getModifier();
    static String getAbilityName(int STAT) {
        String s;
        switch (STAT){
            case STRENGTH -> s = "Strength";
            case DEXTERITY -> s = "Dexterity";
            case CONSTITUTION -> s = "Constitution";
            case INTELLIGENCE -> s = "Intelligence";
            case WISDOM -> s = "Wisdom";
            case CHARISMA -> s = "Charisma";
            case STRENGTH_SAVE -> s = "Strength Save";
            case DEXTERITY_SAVE -> s = "Dexterity Save";
            case CONSTITUTION_SAVE -> s = "Constitution Save";
            case INTELLIGENCE_SAVE -> s = "Intelligence Save";
            case WISDOM_SAVE -> s = "Wisdom Save";
            case CHARISMA_SAVE -> s = "Charisma Save";
            case ACROBATICS -> s = "Acrobatics Save";
            case ANIMAL_HANDLING -> s = "Animal Handling";
            case ARCANA -> s = "Arcana";
            case ATHLETICS -> s = "Athletics";
            case DECEPTION -> s = "Deception";
            case HISTORY -> s = "History";
            case INSIGHT -> s = "Insight";
            case INTIMIDATION -> s = "Intimidation";
            case INVESTIGATION -> s = "Investigation";
            case MEDICINE -> s = "Medicine";
            case NATURE -> s = "Nature";
            case PERCEPTION -> s = "Perception";
            case PERFORMANCE -> s = "Performance";
            case PERSUASION -> s = "Persuasion";
            case RELIGION -> s = "Religion";
            case SLEIGHT_OF_HAND -> s = "Sleight of Hand";
            case STEALTH -> s = "Stealth";
            case SURVIVAL -> s = "Survival";
            default -> throw new RuntimeException();
        }
        return s;
    }
    static int getAbilityN(String name) {
        if (name.equalsIgnoreCase("Strength")) {
            return STRENGTH;
        } else if (name.equalsIgnoreCase("Dexterity")) {
            return DEXTERITY;
        } else if (name.equalsIgnoreCase("Constitution")) {
            return CONSTITUTION;
        } else if (name.equalsIgnoreCase("Intelligence")) {
            return INTELLIGENCE;
        } else if (name.equalsIgnoreCase("Wisdom")) {
            return WISDOM;
        } else if (name.equalsIgnoreCase("Charisma")) {
            return CHARISMA;
        } else if (name.equalsIgnoreCase("Strength Save")) {
            return STRENGTH_SAVE;
        } else if (name.equalsIgnoreCase("Dexterity Save")) {
            return DEXTERITY_SAVE;
        } else if (name.equalsIgnoreCase("Constitution Save")) {
            return CONSTITUTION_SAVE;
        } else if (name.equalsIgnoreCase("Intelligence Save")) {
            return INTELLIGENCE_SAVE;
        } else if (name.equalsIgnoreCase("Wisdom Save")) {
            return WISDOM_SAVE;
        } else if (name.equalsIgnoreCase("Charisma Save")) {
            return CHARISMA_SAVE;
        } else if (name.equalsIgnoreCase("Acrobatics")) {
            return ACROBATICS;
        } else if (name.equalsIgnoreCase("Animal Handling")) {
            return ANIMAL_HANDLING;
        } else if (name.equalsIgnoreCase("Arcana")) {
            return ARCANA;
        } else if (name.equalsIgnoreCase("ATHLETICS")) {
            return ATHLETICS;
        } else if (name.equalsIgnoreCase("DECEPTION")) {
            return DECEPTION;
        } else if (name.equalsIgnoreCase("History")) {
            return HISTORY;
        } else if (name.equalsIgnoreCase("Insight")) {
            return INSIGHT;
        } else if (name.equalsIgnoreCase("Intimidation")) {
            return INTIMIDATION;
        } else if (name.equalsIgnoreCase("Investigation")) {
            return INVESTIGATION;
        } else if (name.equalsIgnoreCase("Medicine")) {
            return MEDICINE;
        } else if (name.equalsIgnoreCase("Nature")) {
            return NATURE;
        } else if (name.equalsIgnoreCase("Perception")) {
            return PERCEPTION;
        } else if (name.equalsIgnoreCase("Performance")) {
            return PERFORMANCE;
        } else if (name.equalsIgnoreCase("Persuasion")) {
            return PERSUASION;
        } else if (name.equalsIgnoreCase("Religion")) {
            return RELIGION;
        } else if (name.equalsIgnoreCase("SLEIGHT OF HAND")) {
            return SLEIGHT_OF_HAND;
        } else if (name.equalsIgnoreCase("STEALTH")) {
            return STEALTH;
        } else if (name.equalsIgnoreCase("Survival")) {
            return SURVIVAL;
        }
        throw new RuntimeException();
    }
}
