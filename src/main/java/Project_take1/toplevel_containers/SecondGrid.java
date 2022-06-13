package Project_take1.toplevel_containers;

import Project_take1.bottomlevel_containers.HealthPanel;

import javax.swing.*;
import java.awt.*;

public class SecondGrid extends JPanel {
    public SecondGrid(){
        setLayout(new BorderLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(200,800));
        JPanel placeHolder=new JPanel();
        placeHolder.setPreferredSize(new Dimension(placeHolder.getPreferredSize().width,800));
        add(placeHolder,BorderLayout.CENTER);
        JPanel grid=new JPanel(new GridLayout(1,2,4,4));
        grid.add(new HealthPanel(true));
        grid.add(new HealthPanel(false));
        grid.setOpaque(false);
        add(grid,BorderLayout.NORTH);
    }
}
