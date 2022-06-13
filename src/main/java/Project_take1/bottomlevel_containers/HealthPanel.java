package Project_take1.bottomlevel_containers;

import Project_take1.resources.graphics.MyRoundedBorder;
import Project_take1.resources.graphics.PalettablePanel;
import Project_take1.resources.graphics.RoundedJPanel;

import javax.swing.*;
import java.awt.*;

public class HealthPanel extends RoundedJPanel implements PalettablePanel {
    int maxHealth;
    int currentHealth;
    JLabel maxHealthPanel=new JLabel();
    JTextField currentHealthPanel=new JTextField();
    CircularLabel plusLabel=new CircularLabel("+",2,2,5);
    CircularLabel minusLabel=new CircularLabel("-",2,2,5);
    boolean temporary;

    public HealthPanel(boolean temporary){
        super();

        this.temporary=temporary;
        setMaxHealth(100);
        setCurrentHealth(10);
        this.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(70,100));
        currentHealthPanel.setOpaque(false);


        JPanel healthPanel=new JPanel(new BorderLayout());
        currentHealthPanel.setPreferredSize(new Dimension(50,50));
        maxHealthPanel.setPreferredSize(new Dimension(50,50));

        currentHealthPanel.setBorder(new MyRoundedBorder(getPalette().border(),3,20));
        healthPanel.add(currentHealthPanel,BorderLayout.CENTER);
        healthPanel.add(maxHealthPanel,BorderLayout.SOUTH);

        add(healthPanel,BorderLayout.CENTER);
        setSize(new Dimension(getPreferredSize()));
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        maxHealthPanel.setText("/" + String.valueOf(maxHealth));
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        currentHealthPanel.setText(String.valueOf(currentHealth));
    }

    @Override

    public void paintComponent(Graphics g){
        this.arcHeight=30;
        this.arcWidth=30;
        super.paintComponent(g);
    }

    @Override
    public void updateColors() {
    }

}
