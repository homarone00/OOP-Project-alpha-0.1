package Project_take1.containers.top_panels.subtop_panels;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.SingleAbilityPanel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class SaveThrowPanel extends JPanel implements UpdatablePanel, MouseListener {
    MyCharacter myCharacter;
    SingleAbilityPanel strSave;
    SingleAbilityPanel dexSave;
    SingleAbilityPanel conSave;
    SingleAbilityPanel intSave;
    SingleAbilityPanel wisSave;
    SingleAbilityPanel chaSave;
    JPanel mainPanel;
    JLabel title;
    JLabel settingsButton;
    boolean settingsButtonEntered;
    boolean settingsButtonActive;
    public SaveThrowPanel(MyCharacter myCharacter) {
        super();
        this.myCharacter=myCharacter;
        this.setLayout(new GridBagLayout());
        setSettingsButtonEntered(false);
        setSettingsButtonActive(false);
        GridBagConstraints c = new GridBagConstraints();
        strSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.STRENGTH_SAVE);
        dexSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.DEXTERITY_SAVE);
        conSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.CONSTITUTION_SAVE);
        intSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.INTELLIGENCE_SAVE);
        wisSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.WISDOM_SAVE);
        chaSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.CHARISMA_SAVE);

        strSave.addMouseListener(this);
        dexSave.addMouseListener(this);
        conSave.addMouseListener(this);
        intSave.addMouseListener(this);
        wisSave.addMouseListener(this);
        chaSave.addMouseListener(this);

        //creating label and icon
        title = new JLabel("Saving Throws");
        title.setOpaque(false);
        title.setVerticalAlignment(JLabel.NORTH);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));


        settingsButton=new JLabel();
        settingsButton.setIcon(getPalette().getUnpressedSettingsButton());
        settingsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        settingsButton.addMouseListener(this);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx=20;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        this.add(title, c);

        c.gridx = 2;
        c.gridy = 0;
        c.weightx=2;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        this.add(settingsButton, c);

        mainPanel = new JPanel(new GridLayout(3,2,2,2));
        c.gridy = 1;
        c.gridx = 1;
        c.gridwidth=2;
        c.fill = GridBagConstraints.BOTH;
        mainPanel.setOpaque(false);
        mainPanel.add(strSave);
        mainPanel.add(dexSave);
        mainPanel.add(conSave);
        mainPanel.add(intSave);
        mainPanel.add(wisSave);
        mainPanel.add(chaSave);
        this.add(mainPanel, c);
        this.setOpaque(true);
        this.setBackground(Color.yellow);

        /*
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.linkSize(strSave, dexSave, conSave, intSave, wisSave, chaSave);
        layout.setAutoCreateGaps(true);

        GroupLayout.SequentialGroup h1Group = layout.createSequentialGroup();
        h1Group.addGroup(
                layout.createParallelGroup()
                        .addComponent(strSave)
                        .addComponent(conSave)
                        .addComponent(wisSave)
        );
        h1Group.addGroup(
                layout.createParallelGroup()
                        .addComponent(dexSave)
                        .addComponent(intSave)
                        .addComponent(chaSave)
        );
        GroupLayout.SequentialGroup h2Group = layout.createSequentialGroup();

        h2Group.addGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(title)
                        .addGroup(h1Group)
        );
        layout.setHorizontalGroup(h2Group);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(
                layout.createParallelGroup()
                        .addComponent(title)
        );
        vGroup.addGroup(
                layout.createParallelGroup()
                        .addComponent(strSave)
                        .addComponent(dexSave)
        );
        vGroup.addGroup(
                layout.createParallelGroup()
                        .addComponent(conSave)
                        .addComponent(intSave)
        );
        vGroup.addGroup(
                layout.createParallelGroup()
                        .addComponent(wisSave)
                        .addComponent(chaSave)
        );
        layout.setVerticalGroup(vGroup);
         */
    }

    @Override
    public void updateColors() {
        strSave.updateColors();
        dexSave.updateColors();
        conSave.updateColors();
        intSave.updateColors();
        wisSave.updateColors();
        chaSave.updateColors();
        title.setForeground(getPalette().text());
        setBackground(getPalette().background());
        settingsButton.setIcon(getPalette().getUnpressedSettingsButton());
        updatePanel();
    }

    @Override
    public void updatePanel() {
        strSave.updatePanel();
        dexSave.updatePanel();
        conSave.updatePanel();
        intSave.updatePanel();
        wisSave.updatePanel();
        chaSave.updatePanel();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(settingsButton)){
            if(isSettingsButtonActive()){
                setSettingsButtonActive(false);
                strSave.stopEditingSequence();
                dexSave.stopEditingSequence();
                conSave.stopEditingSequence();
                intSave.stopEditingSequence();
                wisSave.stopEditingSequence();
                chaSave.stopEditingSequence();
            }
            else{
                setSettingsButtonActive(true);
                strSave.startEditingSequence();
                dexSave.startEditingSequence();
                conSave.startEditingSequence();
                intSave.startEditingSequence();
                wisSave.startEditingSequence();
                chaSave.startEditingSequence();

            }

        }
        if(e.getSource().equals(strSave)){
            if(strSave.isEditing()){
                strSave.switchBiState();
            }
        }
        if(e.getSource().equals(dexSave)){
            if(dexSave.isEditing()){
                dexSave.switchBiState();
            }
        }
        if(e.getSource().equals(conSave)){
            if(conSave.isEditing()){
                conSave.switchBiState();
            }
        }
        if(e.getSource().equals(intSave)){
            if(intSave.isEditing()){
                intSave.switchBiState();
            }
        }
        if(e.getSource().equals(wisSave)){
            if(wisSave.isEditing()){
                wisSave.switchBiState();
            }
        }
        if(e.getSource().equals(chaSave)){
            if(chaSave.isEditing()){
                chaSave.switchBiState();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource().equals(settingsButton)){
            settingsButton.setIcon(getPalette().getPressedSettingsButton());
        }
        if(e.getSource().equals(strSave)&&strSave.isEditing()){
            strSave.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(dexSave)&&dexSave.isEditing()){
            dexSave.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(conSave)&&conSave.isEditing()){
            conSave.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(intSave)&&intSave.isEditing()){
            intSave.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(wisSave)&&wisSave.isEditing()){
            wisSave.setAsCustomPainted(getPalette().button_pressed());
        }
        if(e.getSource().equals(chaSave)&&chaSave.isEditing()){
            chaSave.setAsCustomPainted(getPalette().button_pressed());
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
        if(e.getSource().equals(strSave)&&strSave.isEditing()){
            if(strSave.isEntered()){
                strSave.setAsCustomPainted(getPalette().button_default());
            }
            else{
                strSave.setPaneled(true);
            }
        }
        if(e.getSource().equals(dexSave)&&dexSave.isEditing()){
            if(dexSave.isEntered()){
                dexSave.setAsCustomPainted(getPalette().button_default());
            }
            else{
                dexSave.setPaneled(true);
            }
        }
        if(e.getSource().equals(conSave)&&conSave.isEditing()){
            if(conSave.isEntered()){
                conSave.setAsCustomPainted(getPalette().button_default());
            }
            else{
                conSave.setPaneled(true);
            }
        }
        if(e.getSource().equals(intSave)&&intSave.isEditing()){
            if(intSave.isEntered()){
                intSave.setAsCustomPainted(getPalette().button_default());
            }
            else{
                intSave.setPaneled(true);
            }
        }
        if(e.getSource().equals(wisSave)&&wisSave.isEditing()){
            if(wisSave.isEntered()){
                wisSave.setAsCustomPainted(getPalette().button_default());
            }
            else{
                wisSave.setPaneled(true);
            }
        }
        if(e.getSource().equals(chaSave)&&chaSave.isEditing()){
            if(chaSave.isEntered()){
                chaSave.setAsCustomPainted(getPalette().button_default());
            }
            else{
                chaSave.setPaneled(true);
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().equals(settingsButton)){
            settingsButton.setIcon(getPalette().getHoveredSettingsButton());
            setSettingsButtonEntered(true);
        }
        if(e.getSource().equals(strSave)){
            if(strSave.isEditing()){
                strSave.setEntered(true);
            }
        }
        if(e.getSource().equals(dexSave)){
            if(dexSave.isEditing()){
                dexSave.setEntered(true);
            }
        }
        if(e.getSource().equals(conSave)){
            if(conSave.isEditing()){
                conSave.setEntered(true);
            }
        }
        if(e.getSource().equals(intSave)){
            if(intSave.isEditing()){
                intSave.setEntered(true);
            }
        }
        if(e.getSource().equals(wisSave)){
            if(wisSave.isEditing()){
                wisSave.setEntered(true);
            }
        }
        if(e.getSource().equals(chaSave)){
            if(chaSave.isEditing()){
                chaSave.setEntered(true);
            }
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource().equals(settingsButton)){
            settingsButton.setIcon(getPalette().getUnpressedSettingsButton());
            setSettingsButtonEntered(false);
        }
        if(e.getSource().equals(strSave)){
            strSave.setPaneled(true);
        }
        if(e.getSource().equals(dexSave)){
            dexSave.setPaneled(true);
        }
        if(e.getSource().equals(conSave)){
            conSave.setPaneled(true);
        }
        if(e.getSource().equals(intSave)){
            intSave.setPaneled(true);
        }
        if(e.getSource().equals(wisSave)){
            wisSave.setPaneled(true);
        }
        if(e.getSource().equals(chaSave)){
            chaSave.setPaneled(true);
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
}
