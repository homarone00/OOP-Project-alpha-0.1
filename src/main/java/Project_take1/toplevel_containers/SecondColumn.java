package Project_take1.toplevel_containers;

import Project_take1.bottomlevel_containers.HealthPanel;
import Project_take1.bottomlevel_containers.SimpleRoundedPanel;

import javax.swing.*;
import java.awt.*;

public class SecondColumn extends JPanel {
    public SecondColumn(){
        setLayout(new BorderLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(200,800));
        JPanel placeHolder=new JPanel();
        placeHolder.setPreferredSize(new Dimension(placeHolder.getPreferredSize().width,800));
        add(placeHolder,BorderLayout.CENTER);
        JPanel grid_1 =new JPanel(new GridLayout(1,3,4,4));
        grid_1.add(new SimpleRoundedPanel("AC","12"));
        grid_1.add(new SimpleRoundedPanel("INIT","+5"));
        grid_1.add(new SimpleRoundedPanel("SPEED","9m"));
        grid_1.setOpaque(false);
        add(grid_1,BorderLayout.NORTH);
    }
}
