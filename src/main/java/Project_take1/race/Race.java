package Project_take1.race;

import Project_take1.MyCharacter;

import java.util.ArrayList;

public class Race {
    String name;
    ArrayList<Integer> ability= new ArrayList<>(6);
    int speed = 9;
    ArrayList<String>racial_trait = new ArrayList<>();
    String size = "Medium";
    int variablePoint = 0;

    public Race(String name) {
        this.name = name;
        ability.set(MyCharacter.STRENGTH - MyCharacter.STRENGTH, 0);
        ability.set(MyCharacter.DEXTERITY - MyCharacter.STRENGTH, 0);
        ability.set(MyCharacter.CONSTITUTION - MyCharacter.STRENGTH, 0);
        ability.set(MyCharacter.INTELLIGENCE - MyCharacter.STRENGTH, 0);
        ability.set(MyCharacter.WISDOM - MyCharacter.STRENGTH, 0);
        ability.set(MyCharacter.CHARISMA - MyCharacter.STRENGTH, 0);
        if(name.equalsIgnoreCase("Human")){
            ability.set(MyCharacter.STRENGTH - MyCharacter.STRENGTH, 1);
            ability.set(MyCharacter.DEXTERITY - MyCharacter.STRENGTH, 1);
            ability.set(MyCharacter.CONSTITUTION - MyCharacter.STRENGTH, 1);
            ability.set(MyCharacter.INTELLIGENCE - MyCharacter.STRENGTH, 1);
            ability.set(MyCharacter.WISDOM - MyCharacter.STRENGTH, 1);
            ability.set(MyCharacter.CHARISMA - MyCharacter.STRENGTH, 1);
        } else if (name.equalsIgnoreCase("Dwarf")) {
            ability.set(MyCharacter.CONSTITUTION - MyCharacter.STRENGTH, 2);
            ability.set(MyCharacter.STRENGTH - MyCharacter.STRENGTH, 2);
        } else if (name.equalsIgnoreCase("Elf")) {
            ability.set(MyCharacter.DEXTERITY - MyCharacter.STRENGTH, 2);
            ability.set(MyCharacter.INTELLIGENCE - MyCharacter.STRENGTH, 1);
        }  else if (name.equalsIgnoreCase("Gnome")) {
            this.size = "Small";
            ability.set(MyCharacter.CONSTITUTION - MyCharacter.STRENGTH, 1);
            ability.set(MyCharacter.INTELLIGENCE - MyCharacter.STRENGTH, 2);
        } else if (name.equalsIgnoreCase("Half-Elf")) {
            ability.set(MyCharacter.CHARISMA - MyCharacter.STRENGTH, 2);
            variablePoint = 1;
        } else if(name.equalsIgnoreCase("Halfling")){
            ability.set(MyCharacter.CHARISMA - MyCharacter.STRENGTH, 1);
            ability.set(MyCharacter.DEXTERITY - MyCharacter.STRENGTH, 2);
            size = "Small";
        } else if(name.equalsIgnoreCase("Half-Orc")){
            ability.set(MyCharacter.CONSTITUTION - MyCharacter.STRENGTH, 1);
            ability.set(MyCharacter.STRENGTH - MyCharacter.STRENGTH, 2);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getAbility() {
        return ability;
    }

    public void setAbility(ArrayList<Integer> ability) {
        this.ability = ability;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<String> getRacial_trait() {
        return racial_trait;
    }

    public void setRacial_trait(ArrayList<String> racial_trait) {
        this.racial_trait = racial_trait;
    }
}
