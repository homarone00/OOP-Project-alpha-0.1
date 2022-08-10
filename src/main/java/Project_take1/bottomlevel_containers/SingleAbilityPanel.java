package Project_take1.bottomlevel_containers;

import Project_take1.MyCharacter;
import Project_take1.resources.graphics.UpdatablePanel;
import Project_take1.resources.graphics.RoundedJPanel;

import javax.swing.*;
import java.awt.*;

public class SingleAbilityPanel extends RoundedJPanel implements UpdatablePanel {
    int baseStat;
    boolean competence;
    String name;
    JLabel lbName;
    JLabel lbValue;
    CompPointLabel clComp;
    MyCharacter myCharacter;

    public SingleAbilityPanel(MyCharacter myCharacter, int baseStat) {
        super();
        this.myCharacter=myCharacter;
        this.arcHeight = 20;
        this.arcWidth = 20;
        this.baseStat = baseStat;
        this.setName();
        this.setPreferredSize(new Dimension(165,47));
        this.setMinimumSize(new Dimension(160, 40));
        this.competence = myCharacter.getCompAbility(baseStat).hasProficiency();
        this.lbName = new JLabel(name);
        lbName.setFont(new Font("Comic Sans", Font.BOLD, 13));
        this.lbValue = new JLabel();
        setValue();
        lbValue.setFont(new Font("Comic Sans", Font.BOLD, 13));
        lbValue.setOpaque(false);
        this.clComp = new CompPointLabel(competence);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.linkSize(clComp, lbValue);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(clComp)
                        .addComponent(lbValue)
                        .addComponent(lbName)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(clComp)
                                .addComponent(lbValue)
                                .addComponent(lbName))
        );
        this.setOpaque(false);
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
            default -> throw new IllegalArgumentException("Index out of range");
        }

    }

    @Override
    public void updateColors() {
        this.lbName.setForeground(getPalette().text());
        this.lbValue.setForeground(getPalette().text());
    }

    @Override
    public void updatePanel() {
        setValue();
    }

    @Override
    public void paintComponents(Graphics g) {
        setArcs(30,30);
        super.paintComponent(g);
    }
    public void setValue(){
        int modifier=myCharacter.getCompAbility(baseStat).getModifier();
        lbValue.setText(Integer.toString(modifier));
    }
}
