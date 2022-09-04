package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column;

import Project_take1.MyCharacter;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;

public class WeaponsPanel extends JPanel implements UpdatablePanel {
    MyCharacter myCharacter;
    public WeaponsPanel(MyCharacter myCharacter){
        super();
        this.myCharacter=myCharacter;
        setLayout(new GridLayout(4,1,5,5));
        setPreferredSize(new Dimension(230,200));
        add(new SingleWeaponPanel(myCharacter,true));
        add(new SingleWeaponPanel(myCharacter,true));
        add(new SingleWeaponPanel(myCharacter,true));
        add(new SingleWeaponPanel(myCharacter,true));

    }
    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }
}
