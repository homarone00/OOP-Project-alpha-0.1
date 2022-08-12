package Project_take1.bottomlevel_containers;

import Project_take1.MyCharacter;
import Project_take1.graphics.UpdatablePanel;
import Project_take1.graphics.RoundedJPanel;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("ALL")
public class SingleAbilityPanel extends RoundedJPanel implements UpdatablePanel {
    int baseStat;
    boolean proficiency;
    boolean expertise;
    String name;
    JLabel lbName;
    JLabel lbValue;
    ProficiencyPointLabel clComp;
    MyCharacter myCharacter;
    boolean editing;
    Thread thread;
    boolean entered;

    public SingleAbilityPanel(MyCharacter myCharacter, int baseStat) {
        super();
        editing=false;
        this.myCharacter=myCharacter;
        this.arcHeight = 20;
        this.arcWidth = 20;
        this.baseStat = baseStat;
        this.setName();
        this.setPreferredSize(new Dimension(165,47));
        this.setMinimumSize(new Dimension(160, 40));
        this.proficiency = myCharacter.getCompAbility(baseStat).isProficiency();
        this.expertise=myCharacter.getCompAbility(baseStat).isExpertise();
        this.lbName = new JLabel(name);
        lbName.setFont(new Font("Comic Sans", Font.BOLD, 13));
        this.lbValue = new JLabel();
        setModifier();
        lbValue.setFont(new Font("Comic Sans", Font.BOLD, 13));
        lbValue.setOpaque(false);
        this.clComp = new ProficiencyPointLabel(proficiency,expertise);
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
        this.setPaneled(true);
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
            //a sys out print in case of error
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
        setModifier();
    }

    @Override
    public void paintComponents(Graphics g) {
        setArcs(30,30);
        super.paintComponent(g);
    }
    public void setModifier(){
        int modifier=myCharacter.getCompAbility(baseStat).getModifier();
        lbValue.setText(Integer.toString(modifier));
    }
    public void startEditingSequence(){
        setEditing(true);
        editAnimation();
    }
    public void editAnimation(){
        thread= new Thread(() -> {
            while (isEditing()) {
                clComp.setEditing(true);
                clComp.repaint();
                try{
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!isEditing()){
                    clComp.setEditing(false);
                    clComp.repaint();
                    break;
                }
                try{
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!isEditing()){
                    clComp.setEditing(false);
                    clComp.repaint();
                    break;
                }
                try{
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!isEditing()){
                    clComp.setEditing(false);
                    clComp.repaint();
                    break;
                }
                try{
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!isEditing()){
                    clComp.setEditing(false);
                    clComp.repaint();
                    break;
                }
                clComp.setEditing(false);
                clComp.repaint();
                try{
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!isEditing()){
                    clComp.setEditing(false);
                    clComp.repaint();
                    break;
                }
                try{
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!isEditing()){
                    clComp.setEditing(false);
                    clComp.repaint();
                    break;
                }
                try{
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!isEditing()){
                    clComp.setEditing(false);
                    clComp.repaint();
                    break;
                }
                try{
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!isEditing()){
                    clComp.setEditing(false);
                    clComp.repaint();
                    break;
                }

            }
        });
        thread.start();
    }
    public void stopEditingSequence(){
        setEditing(false);
    }

    public void switchBiState() {
        if(proficiency){
            setProficiency(false);
            myCharacter.getCompAbility(baseStat).setProficiency(false);
        }
        else{
            setProficiency(true);
            myCharacter.getCompAbility(baseStat).setProficiency(true);
        }
        setModifier();
    }
    public void switchTriState(){
        if(!proficiency&&!expertise){
            setProficiency(true);
            myCharacter.getCompAbility(baseStat).setProficiency(true);
        }
        else if(proficiency&&!expertise){
            setExpertise(true);
            myCharacter.getCompAbility(baseStat).setExpertise(true);
        }
        else if(proficiency&&expertise)
        {
            setProficiency(false);
            setExpertise(false);
            myCharacter.getCompAbility(baseStat).setProficiency(false);
            myCharacter.getCompAbility(baseStat).setExpertise(false);
        }
        else if(!proficiency&&expertise){
            throw new IllegalStateException("Can't have expertise but not have proficiency");
        }
        setModifier();
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
        if(isEditing()){
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if(!isEditing()){
            this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    public boolean isProficiency() {
        return proficiency;
    }

    public void setProficiency(boolean proficiency) {
        this.proficiency = proficiency;
        myCharacter.getCompAbility(baseStat).setProficiency(false);
        clComp.setProficiency(proficiency);
        setModifier();
    }

    public boolean isExpertise() {
        return expertise;
    }

    public void setExpertise(boolean expertise) {
        this.expertise = expertise;
        myCharacter.getCompAbility(baseStat).setExpertise(expertise);
        clComp.setExpertise(expertise);
    }

    public boolean isEntered() {
        return entered;
    }

    public void setEntered(boolean entered) {
        this.entered = entered;
        if(isEntered()){
            this.setAsCustomPainted(getPalette().button_default());
            repaint();
        }
        else{
            this.setPaneled(true);
            repaint();
        }
    }
}
