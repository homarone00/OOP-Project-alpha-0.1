package Project_take1.containers.top_panels.subtop_panels;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.SimpleRoundedPanel;
import Project_take1.graphics.UpdatablePanel;
import Project_take1.graphics.Palette;

import javax.swing.*;
import java.awt.*;

public class SecondColumn extends JPanel implements UpdatablePanel {
    MyCharacter myCharacter;
    SimpleRoundedPanel className;
    SimpleRoundedPanel level;
    public SecondColumn(MyCharacter myCharacter){
        GridBagConstraints c=new GridBagConstraints();
        c.insets=new Insets(5,2,7,2);
        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(getPalette().background());
        setPreferredSize(new Dimension(230,800));
        JPanel placeHolder=new JPanel();
        placeHolder.setPreferredSize(new Dimension(placeHolder.getPreferredSize().width,800));
        add(placeHolder,BorderLayout.CENTER);

        JPanel grid_1=new JPanel(new GridBagLayout());
        grid_1.setOpaque(false);
        className=new SimpleRoundedPanel("oath of the gay","Paladin", 30,30);
        level=new SimpleRoundedPanel("LVL",Integer.toString(myCharacter.getLvl()),30,30);
        c.fill=GridBagConstraints.BOTH;
        c.weightx=10;
        grid_1.add(className,c);
        c.weightx=2;
        grid_1.add(level,c);

        JPanel grid_2 =new JPanel(new GridLayout(1,3,4,4));
        grid_2.add(new SimpleRoundedPanel("AC",Integer.toString(myCharacter.getAc()),30,30));
        if(myCharacter.getInitiative()>=0){
            grid_2.add(new SimpleRoundedPanel("INIT","+"+Integer.toString(myCharacter.getInitiative()),30,30));
        }
        else{
            grid_2.add(new SimpleRoundedPanel("INIT",Integer.toString(myCharacter.getInitiative()),30,30));
        }
        grid_2.add(new SimpleRoundedPanel("SPEED",Integer.toString(myCharacter.getSpeed())+"m",30,30));
        grid_2.setOpaque(false);
        grid_2.setPreferredSize(new Dimension(grid_2.getPreferredSize().width,70));

        add(grid_1,BorderLayout.NORTH);
        add(grid_2,BorderLayout.CENTER);
    }

    @Override
    public void updateColors() {
        className.updateColors();
        level.updateColors();
        setBackground(getPalette().background());
    }

    @Override
    public void updatePanel() {

    }

    @Override
    public Palette getPalette() {
        return UpdatablePanel.super.getPalette();
    }
}
