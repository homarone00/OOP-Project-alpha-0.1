package Project_take1.toplevel_containers;

import Project_take1.bottomlevel_containers.SimpleRoundedPanel;
import Project_take1.resources.graphics.RoundedJPanel;

import javax.swing.*;
import java.awt.*;

public class SecondColumn extends JPanel {
    public SecondColumn(){
        GridBagConstraints c=new GridBagConstraints();
        setLayout(new BorderLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(230,800));
        JPanel placeHolder=new JPanel();
        placeHolder.setPreferredSize(new Dimension(placeHolder.getPreferredSize().width,800));
        add(placeHolder,BorderLayout.CENTER);

        JPanel grid_1=new JPanel(new GridBagLayout());
        SimpleRoundedPanel className=new SimpleRoundedPanel("Paladin",30,30);
        SimpleRoundedPanel level=new SimpleRoundedPanel("LVL","13",30,30);
        c.fill=GridBagConstraints.BOTH;
        c.weightx=10;
        grid_1.add(className,c);
        c.weightx=2;
        grid_1.add(level,c);

        JPanel grid_2 =new JPanel(new GridLayout(1,3,4,4));
        grid_2.add(new SimpleRoundedPanel("AC","12",30,30));
        grid_2.add(new SimpleRoundedPanel("INIT","+5",30,30));
        grid_2.add(new SimpleRoundedPanel("SPEED","9m",30,30));
        grid_2.setOpaque(false);
        grid_2.setPreferredSize(new Dimension(grid_2.getPreferredSize().width,70));

        add(grid_1,BorderLayout.NORTH);
        add(grid_2,BorderLayout.CENTER);
    }
}
