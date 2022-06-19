package Project_take1.bottomlevel_containers;

import Project_take1.MyCharacter;
import Project_take1.resources.graphics.PalettablePanel;
import Project_take1.resources.graphics.Palette;

import javax.swing.*;
import java.awt.*;

public class SingleAbilityPanel extends JPanel implements PalettablePanel {
    int baseStat;
    boolean competence;
    String name;
    JLabel lbName;
    JLabel lbValue;
    CompPointLabel clComp;

    public SingleAbilityPanel(MyCharacter myCharacter, int baseStat) {
        super();
        this.baseStat = baseStat;
        this.setName();
        this.competence = myCharacter.getCompAbility(baseStat).hasCompetence();
        this.lbName = new JLabel(name);
        this.lbValue = new JLabel(String.valueOf(myCharacter.getCompAbility(baseStat).getModifier()));
        this.clComp = new CompPointLabel(competence);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 50;
        this.add(clComp, c);
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(lbName, c);
        c.gridx = 2;
        c.fill = GridBagConstraints.NONE;
        c.ipadx = 0;
        c.anchor = GridBagConstraints.EAST;
        lbValue.setHorizontalAlignment(JLabel.RIGHT);
        this.add(lbValue, c);
        this.setMaximumSize(new Dimension(1500,1500));
        this.setSize(1500,1500);
    }

    void setName(){
        switch (baseStat)
        {
            //saving
            case MyCharacter.STRENGTH_SAVE -> name ="Strength";
            case MyCharacter.DEXTERITY_SAVE -> name ="Dexterity";
            case MyCharacter.CONSTITUTION_SAVE -> name ="Constitution";
            case MyCharacter.INTELLIGENCE_SAVE -> name ="Intelligence";
            case MyCharacter.WISDOM_SAVE -> name ="Wisdom";
            case MyCharacter.CHARISMA_SAVE -> name ="Charisma";
            //ability
            case MyCharacter.ACROBATICS -> name = "Acrobatics";
            case MyCharacter.ANIMAL_HANDLING -> name = "Animal Handling";
            case MyCharacter.ARCANA -> name = "Arcana";
            case MyCharacter.ATHLETICS -> name = "Athletics";
            case MyCharacter.DECEPTION -> name = "Deception";
            case MyCharacter.HISTORY -> name = "History";
            case MyCharacter.INSIGHT -> name = "Insight";
            case MyCharacter.INTIMIDATION -> name = "Intimidation";
            case MyCharacter.INVESTIGATION -> name = "Investigation";
            case MyCharacter.MEDICINE -> name = "Medicine";
            case MyCharacter.NATURE -> name = "Nature";
            case MyCharacter.PERCEPTION -> name = "Perception";
            case MyCharacter.PERFORMANCE -> name = "Performance";
            case MyCharacter.PERSUASION -> name = "Persuasion";
            case MyCharacter.RELIGION -> name = "Religion";
            case MyCharacter.SLEIGHT_OF_HAND -> name = "Sleight of Hand";
            case MyCharacter.STEALTH -> name = "Stealth";
            case MyCharacter.SURVIVAL -> name = "Survival";
            //a sysout print in case of error
            default -> System.out.println("Error, index out of range");
        }

    }

    @Override
    public void updateColors() {
    }

    @Override
    public Palette getPalette() {
        return Palette.getInstance();
    }
}
