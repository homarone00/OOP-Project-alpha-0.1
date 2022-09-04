package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.WeaponsPanel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;

public class DamagePanel extends JPanel implements UpdatablePanel {
    MyCharacter myCharacter;
    public DamagePanel(MyCharacter myCharacter) {
        super(new BorderLayout());
        setPreferredSize(new Dimension(230,150));
        this.myCharacter=myCharacter;
        setOpaque(true);
        setBackground(Color.red);
        add(new WeaponsPanel(myCharacter),BorderLayout.CENTER);
    }

    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }
}
