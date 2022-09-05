package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column.CircularLabel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;

public class DamageModifiersPanel extends JPanel implements UpdatablePanel {
    MyCharacter myCharacter;
    JLabel title;
    JLabel settingsButton;
    double length=4;
    CircularLabel plusLabel=new CircularLabel("+",-5,9,15);
    public DamageModifiersPanel(MyCharacter myCharacter){
        super();
        this.myCharacter=myCharacter;
        JPanel topGrid=new JPanel(new BorderLayout());
        topGrid.setOpaque(false);
        length =4;
        title =new JLabel("Weapons");
        title.setFont(new Font("Comic Sans",Font.BOLD,15));
        title.setOpaque(false);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setPreferredSize(new Dimension(20,30));
        JPanel mainGrid=new JPanel(new GridLayout(4,1,5,5));
        mainGrid.setOpaque(false);

        plusLabel.setPreferredSize(new Dimension(20,20));

        setLayout(new BorderLayout());
        mainGrid.add(new SingleWeaponPanel(myCharacter,false));
        mainGrid.add(new SingleWeaponPanel(myCharacter,false));
        mainGrid.add(new SingleWeaponPanel(myCharacter,false));
        mainGrid.add(new SingleWeaponPanel(myCharacter,false));

        setPreferredSize(new Dimension(180,180));
        settingsButton=new JLabel(getPalette().getUnpressedSettingsButton());
        topGrid.add(settingsButton,BorderLayout.EAST);
        topGrid.add(title,BorderLayout.CENTER);
        topGrid.add(plusLabel,BorderLayout.WEST);

        add(mainGrid,BorderLayout.CENTER);
        add(topGrid,BorderLayout.NORTH);
        setOpaque(false);
    }
    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }

    public double getLength() {
        return length;
    }

    public void setLength(int size) {
        this.length = size;
    }
}
