package Project_take1.bottomlevel_containers;

import Project_take1.resources.graphics.RoundedJPanel;

import javax.swing.*;
import java.awt.*;

public class SimpleRoundedPanel extends RoundedJPanel {
    String name;
    String number;
    public SimpleRoundedPanel(String name, String number){
        this.name = name;
        this.number= number;

        JLabel numberLabel=new JLabel(number);
        JLabel valueLabel=new JLabel(name);
        JPanel contentPanel=new JPanel(new GridBagLayout());

        GridBagConstraints c=new GridBagConstraints();

        c.weighty=1;
        c.fill=GridBagConstraints.HORIZONTAL;


    }

    @Override
    public void paintComponent(Graphics g){
        setArcs(30,30);

    }

    @Override
    public void updateColors() {
    }
}
