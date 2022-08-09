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
    JLabel title;
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
        title = new JLabel("Saving Throws");
        title.setOpaque(false);
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
    }

    @Override
    public Palette getPalette() {
        return Palette.getInstance();
    }
}
