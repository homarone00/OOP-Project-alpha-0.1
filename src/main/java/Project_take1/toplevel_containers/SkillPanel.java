package Project_take1.toplevel_containers;

import Project_take1.MyCharacter;
import Project_take1.bottomlevel_containers.SingleAbilityPanel;
import Project_take1.graphics.UpdatablePanel;
import Project_take1.graphics.Palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SkillPanel extends JPanel implements UpdatablePanel, MouseListener {
    JLabel settingsButton;
    JPanel mainPanel;
    MyCharacter myCharacter;
    boolean settingsButtonEntered;
    boolean settingsButtonActive;
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
        setSettingsButtonActive(false);
        setSettingsButtonEntered(false);
        title = new JLabel("     Skills");
        title.setForeground(getPalette().text());
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setOpaque(false);
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.gridx = 1;
        c.gridy = 0;
        c.weightx=20;
        c.fill = GridBagConstraints.BOTH;
        this.add(title, c);
        settingsButton=new JLabel();
        settingsButton.setIcon(getPalette().getUnpressedSettingsButton());
        settingsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        settingsButton.addMouseListener(this);
        c.gridx = 2;
        c.gridy = 0;
        c.weightx=0.9;
        c.fill = GridBagConstraints.BOTH;
        add(settingsButton,c);
        mainPanel = new JPanel(new GridLayout(9,2,2,2));
        c.gridwidth=2;
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

        acrobatics.addMouseListener(this);
        animalHand.addMouseListener(this);
        arcana.addMouseListener(this);
        athletics.addMouseListener(this);
        deception.addMouseListener(this);
        history.addMouseListener(this);
        insight.addMouseListener(this);
        intimidation.addMouseListener(this);
        investigation.addMouseListener(this);
        medicine.addMouseListener(this);
        nature.addMouseListener(this);
        perception.addMouseListener(this);
        performance.addMouseListener(this);
        persuasion.addMouseListener(this);
        religion.addMouseListener(this);
        sleightHand.addMouseListener(this);
        stealth.addMouseListener(this);
        survival.addMouseListener(this);

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
    public void updatePanel() {
        acrobatics.updatePanel();
        animalHand.updatePanel();
        arcana.updatePanel();
        athletics.updatePanel();
        deception.updatePanel();
        history.updatePanel();
        insight.updatePanel();
        intimidation.updatePanel();
        investigation.updatePanel();
        medicine.updatePanel();
        nature.updatePanel();
        perception.updatePanel();
        performance.updatePanel();
        persuasion.updatePanel();
        religion.updatePanel();
        sleightHand.updatePanel();
        stealth.updatePanel();
        survival.updatePanel();
    }

    @Override
    public Palette getPalette() {
        return Palette.getInstance();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(settingsButton)) {
            if (isSettingsButtonActive()) {
                setSettingsButtonActive(false);
                acrobatics.stopEditingSequence();
                animalHand.stopEditingSequence();
                arcana.stopEditingSequence();
                athletics.stopEditingSequence();
                deception.stopEditingSequence();
                history.stopEditingSequence();
                insight.stopEditingSequence();
                intimidation.stopEditingSequence();
                investigation.stopEditingSequence();
                medicine.stopEditingSequence();
                nature.stopEditingSequence();
                perception.stopEditingSequence();
                performance.stopEditingSequence();
                persuasion.stopEditingSequence();
                religion.stopEditingSequence();
                sleightHand.stopEditingSequence();
                stealth.stopEditingSequence();
                survival.stopEditingSequence();
            } else {
                setSettingsButtonActive(true);
                acrobatics.startEditingSequence();
                animalHand.startEditingSequence();
                arcana.startEditingSequence();
                athletics.startEditingSequence();
                deception.startEditingSequence();
                history.startEditingSequence();
                insight.startEditingSequence();
                intimidation.startEditingSequence();
                investigation.startEditingSequence();
                medicine.startEditingSequence();
                nature.startEditingSequence();
                perception.startEditingSequence();
                performance.startEditingSequence();
                persuasion.startEditingSequence();
                religion.startEditingSequence();
                sleightHand.startEditingSequence();
                stealth.startEditingSequence();
                survival.startEditingSequence();
            }

        }
        if(e.getSource().equals(athletics)){
            if(athletics.isEditing()){
                athletics.switchTriState();
            }
        }
        if(e.getSource().equals(acrobatics)){
            if(acrobatics.isEditing()){
                acrobatics.switchTriState();
            }
        }
        if(e.getSource().equals(arcana)){
            if(arcana.isEditing()){
                arcana.switchTriState();
            }
        }
        if(e.getSource().equals(animalHand)){
            if(animalHand.isEditing()){
                animalHand.switchTriState();
            }
        }
        if(e.getSource().equals(deception)){
            if(deception.isEditing()){
                deception.switchTriState();
            }
        }
        if(e.getSource().equals(history)){
            if(history.isEditing()){
                history.switchTriState();
            }
        }
        if(e.getSource().equals(insight)){
            if(insight.isEditing()){
                insight.switchTriState();
            }
        }
        if(e.getSource().equals(intimidation)){
            if(intimidation.isEditing()){
                intimidation.switchTriState();
            }
        }
        if(e.getSource().equals(investigation)){
            if(investigation.isEditing()){
                investigation.switchTriState();
            }
        }
        if(e.getSource().equals(medicine)){
            if(medicine.isEditing()){
                medicine.switchTriState();
            }
        }
        if(e.getSource().equals(nature)){
            if(nature.isEditing()){
                nature.switchTriState();
            }
        }
        if(e.getSource().equals(perception)){
            if(perception.isEditing()){
                perception.switchTriState();
            }
        }
        if(e.getSource().equals(performance)){
            if(performance.isEditing()){
                performance.switchTriState();
            }
        }
        if(e.getSource().equals(persuasion)){
            if(persuasion.isEditing()){
                persuasion.switchTriState();
            }
        }
        if(e.getSource().equals(religion)){
            if(religion.isEditing()){
                religion.switchTriState();
            }
        }
        if(e.getSource().equals(stealth)){
            if(stealth.isEditing()){
                stealth.switchTriState();
            }
        }
        if(e.getSource().equals(sleightHand)){
            if(sleightHand.isEditing()){
                sleightHand.switchTriState();
            }
        }
        if(e.getSource().equals(survival)){
            if(survival.isEditing()){
                survival.switchTriState();
                revalidate();
            }
        }
    }
    public Boolean isSettingsButtonEntered() {
        return settingsButtonEntered;
    }

    public void setSettingsButtonEntered(Boolean settingsButtonEntered) {
        this.settingsButtonEntered = settingsButtonEntered;
    }

    public boolean isSettingsButtonActive() {
        return settingsButtonActive;
    }

    public void setSettingsButtonActive(boolean settingsButtonActive) {
        this.settingsButtonActive = settingsButtonActive;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource().equals(settingsButton)){
            settingsButton.setIcon(getPalette().getPressedSettingsButton());
        }
        if(e.getSource().equals(acrobatics)&&acrobatics.isEditing()){
            acrobatics.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(animalHand)&&animalHand.isEditing()){
            animalHand.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(arcana)&&arcana.isEditing()){
            arcana.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(athletics)&&athletics.isEditing()){
            athletics.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(deception)&&deception.isEditing()){
            deception.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(history)&&history.isEditing()){
            history.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(insight)&&insight.isEditing()){
            insight.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(intimidation)&&intimidation.isEditing()){
            intimidation.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(investigation)&&investigation.isEditing()){
            investigation.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(medicine)&&medicine.isEditing()){
            medicine.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(nature)&&nature.isEditing()){
            nature.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(perception)&&perception.isEditing()){
            perception.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(performance)&&performance.isEditing()){
            performance.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(persuasion)&&persuasion.isEditing()){
            persuasion.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(religion)&&religion.isEditing()){
            religion.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(stealth)&&stealth.isEditing()){
            stealth.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(sleightHand)&&sleightHand.isEditing()){
            sleightHand.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(survival)&&survival.isEditing()){
            survival.setAsCustomPainted(getPalette().button_pressed());
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource().equals(settingsButton)){
            if(!isSettingsButtonEntered()){
                settingsButton.setIcon(getPalette().getUnpressedSettingsButton());
            }
            else{
                settingsButton.setIcon(getPalette().getHoveredSettingsButton());
            }
        }
        if(e.getSource().equals(athletics)&&athletics.isEditing()){
            if(athletics.isEntered()){
                athletics.setAsCustomPainted(getPalette().button_default());
            }
            else{
                athletics.setPaneled(true);
            }
        }
        if(e.getSource().equals(arcana)&&arcana.isEditing()){
            if(arcana.isEntered()){
                arcana.setAsCustomPainted(getPalette().button_default());
            }
            else{
                arcana.setPaneled(true);
            }
        }
        if(e.getSource().equals(acrobatics)&&acrobatics.isEditing()){
            if(acrobatics.isEntered()){
                acrobatics.setAsCustomPainted(getPalette().button_default());
            }
            else{
                acrobatics.setPaneled(true);
            }
        }
        if(e.getSource().equals(animalHand)&&animalHand.isEditing()){
            if(animalHand.isEntered()){
                animalHand.setAsCustomPainted(getPalette().button_default());
            }
            else{
                animalHand.setPaneled(true);
            }
        }
        if(e.getSource().equals(deception)&&deception.isEditing()){
            if(deception.isEntered()){
                deception.setAsCustomPainted(getPalette().button_default());
            }
            else{
                deception.setPaneled(true);
            }
        }
        if(e.getSource().equals(history)&&history.isEditing()){
            if(history.isEntered()){
                history.setAsCustomPainted(getPalette().button_default());
            }
            else{
                history.setPaneled(true);
            }
        }
        if(e.getSource().equals(insight)&&insight.isEditing()){
            if(insight.isEntered()){
                insight.setAsCustomPainted(getPalette().button_default());
            }
            else{
                insight.setPaneled(true);
            }
        }
        if(e.getSource().equals(investigation)&&investigation.isEditing()){
            if(investigation.isEntered()){
                investigation.setAsCustomPainted(getPalette().button_default());
            }
            else{
                investigation.setPaneled(true);
            }
        }
        if(e.getSource().equals(intimidation)&&intimidation.isEditing()){
            if(intimidation.isEntered()){
                intimidation.setAsCustomPainted(getPalette().button_default());
            }
            else{
                intimidation.setPaneled(true);
            }
        }
        if(e.getSource().equals(medicine)&&medicine.isEditing()){
            if(medicine.isEntered()){
                medicine.setAsCustomPainted(getPalette().button_default());
            }
            else{
                medicine.setPaneled(true);
            }
        }
        if(e.getSource().equals(nature)&&nature.isEditing()){
            if(nature.isEntered()){
                nature.setAsCustomPainted(getPalette().button_default());
            }
            else{
                nature.setPaneled(true);
            }
        }
        if(e.getSource().equals(perception)&&perception.isEditing()){
            if(perception.isEntered()){
                perception.setAsCustomPainted(getPalette().button_default());
            }
            else{
                perception.setPaneled(true);
            }
        }
        if(e.getSource().equals(performance)&&performance.isEditing()){
            if(performance.isEntered()){
                performance.setAsCustomPainted(getPalette().button_default());
            }
            else{
                performance.setPaneled(true);
            }
        }
        if(e.getSource().equals(persuasion)&&persuasion.isEditing()){
            if(persuasion.isEntered()){
                persuasion.setAsCustomPainted(getPalette().button_default());
            }
            else{
                persuasion.setPaneled(true);
            }
        }
        if(e.getSource().equals(religion)&&religion.isEditing()){
            if(religion.isEntered()){
                religion.setAsCustomPainted(getPalette().button_default());
            }
            else{
                religion.setPaneled(true);
            }
        }
        if(e.getSource().equals(sleightHand)&&sleightHand.isEditing()){
            if(sleightHand.isEntered()){
                sleightHand.setAsCustomPainted(getPalette().button_default());
            }
            else{
                sleightHand.setPaneled(true);
            }
        }
        if(e.getSource().equals(stealth)&&stealth.isEditing()){
            if(stealth.isEntered()){
                stealth.setAsCustomPainted(getPalette().button_default());
            }
            else{
                stealth.setPaneled(true);
            }
        }
        if(e.getSource().equals(survival)&&survival.isEditing()){
            if(survival.isEntered()){
                survival.setAsCustomPainted(getPalette().button_default());
            }
            else{
                survival.setPaneled(true);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
