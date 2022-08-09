package Project_take1.toplevel_containers;

import Project_take1.MyCharacter;
import Project_take1.bottomlevel_containers.SingleAbilityPanel;
import Project_take1.resources.graphics.PalettablePanel;
import Project_take1.resources.graphics.Palette;

import javax.swing.*;
import java.awt.*;

public class SkillPanel extends JPanel implements PalettablePanel{
    JPanel mainPanel;
    MyCharacter myCharacter;
    SingleAbilityPanel acrobatics;
    SingleAbilityPanel animalHand;
    SingleAbilityPanel arcana;
    SingleAbilityPanel athletics;
    SingleAbilityPanel deception;
    SingleAbilityPanel history;
    SingleAbilityPanel insight;
    SingleAbilityPanel intimidation;
    SingleAbilityPanel investigation;
    SingleAbilityPanel medicine;
    SingleAbilityPanel nature;
    SingleAbilityPanel perception;
    SingleAbilityPanel performance;
    SingleAbilityPanel persuasion;
    SingleAbilityPanel religion;
    SingleAbilityPanel sleightHand;
    SingleAbilityPanel stealth;
    SingleAbilityPanel survival;
    JLabel title;

    public SkillPanel(MyCharacter myCharacter){
        super();
        this.myCharacter = myCharacter;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        acrobatics = new SingleAbilityPanel(this.myCharacter, MyCharacter.ACROBATICS);
        animalHand = new SingleAbilityPanel(this.myCharacter, MyCharacter.ANIMAL_HANDLING);
        arcana = new SingleAbilityPanel(this.myCharacter, MyCharacter.ARCANA);
        athletics = new SingleAbilityPanel(this.myCharacter, MyCharacter.ATHLETICS);
        deception = new SingleAbilityPanel(this.myCharacter, MyCharacter.DECEPTION);
        history = new SingleAbilityPanel(this.myCharacter, MyCharacter.HISTORY);
        insight = new SingleAbilityPanel(this.myCharacter, MyCharacter.INSIGHT);
        intimidation = new SingleAbilityPanel(this.myCharacter, MyCharacter.INTIMIDATION);
        investigation = new SingleAbilityPanel(this.myCharacter, MyCharacter.INVESTIGATION);
        medicine = new SingleAbilityPanel(this.myCharacter, MyCharacter.MEDICINE);
        nature = new SingleAbilityPanel(this.myCharacter, MyCharacter.NATURE);
        perception = new SingleAbilityPanel(this.myCharacter, MyCharacter.PERCEPTION);
        performance = new SingleAbilityPanel(this.myCharacter, MyCharacter.PERFORMANCE);
        persuasion = new SingleAbilityPanel(this.myCharacter, MyCharacter.PERSUASION);
        religion = new SingleAbilityPanel(this.myCharacter, MyCharacter.RELIGION);
        sleightHand = new SingleAbilityPanel(this.myCharacter, MyCharacter.SLEIGHT_OF_HAND);
        stealth = new SingleAbilityPanel(this.myCharacter, MyCharacter.STEALTH);
        survival = new SingleAbilityPanel(this.myCharacter, MyCharacter.SURVIVAL);
        title = new JLabel("Skills");
        title.setForeground(getPalette().text());
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setOpaque(false);
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        this.add(title, c);
        mainPanel = new JPanel(new GridLayout(9,2,2,2));
        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        mainPanel.setOpaque(false);
        mainPanel.add(acrobatics);
        mainPanel.add(animalHand);
        mainPanel.add(arcana);
        mainPanel.add(athletics);
        mainPanel.add(deception);
        mainPanel.add(history);
        mainPanel.add(insight);
        mainPanel.add(intimidation);
        mainPanel.add(investigation);
        mainPanel.add(medicine);
        mainPanel.add(nature);
        mainPanel.add(perception);
        mainPanel.add(performance);
        mainPanel.add(persuasion);
        mainPanel.add(religion);
        mainPanel.add(sleightHand);
        mainPanel.add(stealth);
        mainPanel.add(survival);
        this.add(mainPanel, c);
        this.setBackground(Color.GREEN);
    }

    @Override
    public void updateColors(){
        acrobatics.updateColors();
        animalHand.updateColors();
        arcana.updateColors();
        athletics.updateColors();
        deception.updateColors();
        history.updateColors();
        insight.updateColors();
        intimidation.updateColors();
        investigation.updateColors();
        medicine.updateColors();
        nature.updateColors();
        perception.updateColors();
        performance.updateColors();
        persuasion.updateColors();
        religion.updateColors();
        sleightHand.updateColors();
        stealth.updateColors();
        survival.updateColors();
        title.setForeground(getPalette().text());
    }

    @Override
    public Palette getPalette() {
        return Palette.getInstance();
    }
}
