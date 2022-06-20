package Project_take1.toplevel_containers;

import Project_take1.MyCharacter;
import Project_take1.bottomlevel_containers.SingleAbilityPanel;
import Project_take1.resources.graphics.PalettablePanel;
import Project_take1.resources.graphics.Palette;

import javax.swing.*;
import java.awt.*;

public class SaveThrowPanel extends JPanel implements PalettablePanel {
    MyCharacter myCharacter;
    SingleAbilityPanel strSave;
    SingleAbilityPanel dexSave;
    SingleAbilityPanel conSave;
    SingleAbilityPanel intSave;
    SingleAbilityPanel wisSave;
    SingleAbilityPanel chaSave;
    JPanel mainPanel;
    public SaveThrowPanel(MyCharacter myCharacter) {
        super();
        this.myCharacter=myCharacter;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        strSave = new SingleAbilityPanel(myCharacter, MyCharacter.STRENGTH_SAVE);
        dexSave = new SingleAbilityPanel(myCharacter, MyCharacter.DEXTERITY_SAVE);
        conSave = new SingleAbilityPanel(myCharacter, MyCharacter.CONSTITUTION_SAVE);
        intSave = new SingleAbilityPanel(myCharacter, MyCharacter.INTELLIGENCE_SAVE);
        wisSave = new SingleAbilityPanel(myCharacter, MyCharacter.WISDOM_SAVE);
        chaSave = new SingleAbilityPanel(myCharacter, MyCharacter.CHARISMA_SAVE);
        JLabel title = new JLabel("Saving Throws");
        title.setOpaque(false);
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.gridx = 1;
        c.gridy = 0;
        this.add(title, c);
        mainPanel = new JPanel(new GridLayout(6,1,1,1));
        c.gridy = 1;
        c.gridx = 1;
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
    }

    @Override
    public void updateColors() {
    }

    @Override
    public Palette getPalette() {
        return Palette.getInstance();
    }
}
