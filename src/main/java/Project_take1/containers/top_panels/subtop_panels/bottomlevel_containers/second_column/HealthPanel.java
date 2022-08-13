package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column.CircularLabel;
import Project_take1.graphics.MyRoundedBorder;
import Project_take1.graphics.UpdatablePanel;
import Project_take1.graphics.RoundedJPanel;

import javax.swing.*;
import java.awt.*;

public class HealthPanel extends RoundedJPanel implements UpdatablePanel {
    int maxHealth;
    int currentHealth;
    JLabel maxHealthPanel=new JLabel();
    JTextField currentHealthField =new JTextField(2);
    JPanel currentHealthPanel=new JPanel(new BorderLayout());
    CircularLabel plusLabel;
    CircularLabel minusLabel;
    boolean temporary;
    MyCharacter myCharacter;

    public HealthPanel(boolean temporary,MyCharacter myCharacter){
        super();
        this.temporary=temporary;
        this.myCharacter=myCharacter;
        setMaxHealth(100);
        setCurrentHealth(10);
        setPreferredSize(new Dimension(100,100));
        currentHealthField.setOpaque(false);
        JPanel contentPanel=new JPanel(new BorderLayout());

        plusLabel=new CircularLabel("+",2,2,10);
        minusLabel=new CircularLabel("-",2,2,10);

        JPanel healthPanel=new JPanel(new BorderLayout());
        currentHealthPanel.setPreferredSize(new Dimension(50,50));
        currentHealthField.setMinimumSize(new Dimension(50,50));
        currentHealthField.setFont(new Font("Comic Sans",Font.BOLD,20));
        maxHealthPanel.setFont(new Font("Comic Sans",Font.BOLD,20));
        maxHealthPanel.setPreferredSize(new Dimension(50,50));


        JPanel buttonGrid=new JPanel(new GridLayout(2,1));
        buttonGrid.setPreferredSize(new Dimension(40,30));

        //adding phase
        currentHealthPanel.add(currentHealthField,BorderLayout.CENTER);
        currentHealthField.setBorder(null);
        currentHealthField.setHorizontalAlignment(SwingConstants.CENTER);
        healthPanel.add(currentHealthPanel,BorderLayout.CENTER);
        healthPanel.add(maxHealthPanel,BorderLayout.SOUTH);

        buttonGrid.add(plusLabel);
        buttonGrid.add(minusLabel);
        contentPanel.add(healthPanel,BorderLayout.CENTER);
        contentPanel.add(buttonGrid,BorderLayout.EAST);
        contentPanel.setOpaque(false);
        currentHealthPanel.setOpaque(false);
        buttonGrid.setOpaque(false);
        healthPanel.setOpaque(false);
        add(contentPanel);
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
        currentHealthField.setText(String.valueOf(currentHealth));
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

    @Override
    public void updatePanel() {

    }

}
