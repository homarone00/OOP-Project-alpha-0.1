package Project_take1.bottomlevel_containers;

import Project_take1.MyCharacter;
import Project_take1.resources.graphics.PalettablePanel;
import Project_take1.resources.graphics.Palette;
import Project_take1.resources.graphics.RoundedJPanel;

import javax.swing.*;
import java.awt.*;

public class SingleAbilityPanel extends RoundedJPanel implements PalettablePanel {
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
        lbName.setFont(new Font("Comic Sans", Font.BOLD, 15));
        this.lbValue = new JLabel(String.valueOf(myCharacter.getCompAbility(baseStat).getModifier()));
        lbValue.setFont(new Font("Comic Sans", Font.BOLD, 15));
        this.clComp = new CompPointLabel(competence);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(clComp)
                        .addComponent(lbValue)
                        .addComponent(lbName)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(clComp)
                                .addComponent(lbValue)
                                .addComponent(lbName))
        );
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
        this.lbName.setForeground(getPalette().text());
        this.lbValue.setForeground(getPalette().text());
    }

    @Override
    public void paintComponents(Graphics g) {
        setArcs(30,30);
        super.paintComponent(g);
    }
}
