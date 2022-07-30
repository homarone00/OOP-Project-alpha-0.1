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
        strSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.STRENGTH_SAVE);
        dexSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.DEXTERITY_SAVE);
        conSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.CONSTITUTION_SAVE);
        intSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.INTELLIGENCE_SAVE);
        wisSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.WISDOM_SAVE);
        chaSave = new SingleAbilityPanel(this.myCharacter, MyCharacter.CHARISMA_SAVE);
        JLabel title = new JLabel("Saving Throws");
        title.setOpaque(true);
        title.setVerticalAlignment(JLabel.NORTH);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Comic Sans", Font.BOLD, 20));
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        this.add(title, c);
        mainPanel = new JPanel(new GridLayout(3,2,2,2));
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
        strSave.updateColors();
        //eccetera :)
    }

    @Override
    public Palette getPalette() {
        return Palette.getInstance();
    }
}
