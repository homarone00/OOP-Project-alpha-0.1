package Project_take1.containers.top_panels.subtop_panels;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.DamagePanel;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.SimpleRoundedPanel;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.HPpanels.MainHealthPanel;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.HPpanels.TemporaryHealthPanel;
import Project_take1.graphics.UpdatablePanel;
import Project_take1.graphics.Palette;

import javax.swing.*;
import java.awt.*;

public class SecondColumn extends JPanel implements UpdatablePanel {
    MyCharacter myCharacter;
    SimpleRoundedPanel className;
    SimpleRoundedPanel level;
    JPanel healthGrid;
    MainHealthPanel mainHealthPanel;
    TemporaryHealthPanel temporaryHealthPanel;
    SimpleRoundedPanel acPanel;
    SimpleRoundedPanel initPanel;
    SimpleRoundedPanel speedPanel;
    DamagePanel damagePanel;

    public SecondColumn(MyCharacter myCharacter){
        GridBagConstraints c=new GridBagConstraints();
        c.insets=new Insets(5,2,7,2);
        setLayout(new BorderLayout(5,5));
        setOpaque(true);
        setBackground(getPalette().background());
        setPreferredSize(new Dimension(230,800));
        JPanel placeHolder=new JPanel();
        placeHolder.setPreferredSize(new Dimension(placeHolder.getPreferredSize().width,800));
        add(placeHolder,BorderLayout.CENTER);

        JPanel grid_1=new JPanel(new GridBagLayout());
        grid_1.setOpaque(false);
        className=new SimpleRoundedPanel("Oath of the homosexual","Kappa", 30,30);
        level=new SimpleRoundedPanel("LVL",Integer.toString(myCharacter.getLvl()),30,30);
        c.fill=GridBagConstraints.BOTH;
        c.weightx=10;
        grid_1.add(className,c);
        c.weightx=2;
        grid_1.add(level,c);

        acPanel=new SimpleRoundedPanel("AC",Integer.toString(myCharacter.getAc()),30,30);
        initPanel=new SimpleRoundedPanel("INIT",myCharacter.getStringInitiative(),30,30);
        speedPanel=new SimpleRoundedPanel("SPEED",myCharacter.getSpeed()+"m",30,30);

        JPanel grid_2 =new JPanel(new GridLayout(1,3,4,4));
        grid_2.add(acPanel);
        grid_2.add(initPanel);
        grid_2.add(speedPanel);
        grid_2.setOpaque(false);
        grid_2.setPreferredSize(new Dimension(grid_2.getPreferredSize().width,30));

        JPanel northGrid=new JPanel(new GridLayout(2,1));
        northGrid.setOpaque(false);
        northGrid.add(grid_1);
        northGrid.add(grid_2);
        add(northGrid,BorderLayout.NORTH);
        mainHealthPanel =new MainHealthPanel(myCharacter);
        temporaryHealthPanel=new TemporaryHealthPanel(myCharacter,mainHealthPanel);
        healthGrid=new JPanel(new GridLayout(2,1,4,4));
        JPanel healthWeaponsGrid=new JPanel(new BorderLayout(5,5));

        healthGrid.add(mainHealthPanel);

        healthGrid.add(temporaryHealthPanel);
        healthWeaponsGrid.add(healthGrid,BorderLayout.NORTH);

        damagePanel=new DamagePanel(myCharacter);
        healthWeaponsGrid.add(damagePanel,BorderLayout.CENTER);

        add(healthWeaponsGrid,BorderLayout.CENTER);

    }

    @Override
    public void updateColors() {
        className.updateColors();
        level.updateColors();
        healthGrid.setBackground(getPalette().background());
        mainHealthPanel.updateColors();
        temporaryHealthPanel.updateColors();
        acPanel.updateColors();
        speedPanel.updateColors();
        initPanel.updateColors();
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
