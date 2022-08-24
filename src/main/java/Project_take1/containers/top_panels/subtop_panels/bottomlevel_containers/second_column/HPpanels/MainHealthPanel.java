package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.HPpanels;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column.CircularLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainHealthPanel extends AbstractHealthPanel {
    int maxHealth;

    JLabel maxHealthPanel=new JLabel();


    public MainHealthPanel(MyCharacter myCharacter){
        super(myCharacter);
        setMaxHealth();
        setCurrentHealth();

        nameLabel.setText(" HP ");
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,22));



        currentHealthField.setFont(new Font("Comic Sans",Font.BOLD,20));
        maxHealthPanel.setFont(new Font("Comic Sans",Font.BOLD,20));
        maxHealthPanel.setPreferredSize(new Dimension(50,50));
        maxHealthPanel.setHorizontalAlignment(JLabel.CENTER);

        addingField.addActionListener(actionValue -> {
            String content=addingField.getText();
            if(!content.isEmpty()){
                if(content.startsWith("+")||content.startsWith("-")){
                    int integer;
                    try{
                        integer=Integer.parseInt(content);
                        int a=getCurrentHealth();
                        a+=integer;
                        setCurrentHealth(a);
                        addingField.setText("");
                    } catch (NumberFormatException ignored) {

                    }
                }
            }

        });

        //adding phase
        hpPanel.add(currentHealthPanel,BorderLayout.CENTER);
        hpPanel.add(maxHealthPanel,BorderLayout.SOUTH);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        maxHealthPanel.setText("/" + String.valueOf(maxHealth));
    }
    public void setMaxHealth() {
        this.maxHealth = myCharacter.getMaxHp();
        maxHealthPanel.setText("/" + String.valueOf(maxHealth));
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        currentHealthField.setText(String.valueOf(currentHealth));
        myCharacter.setCurrentHp(currentHealth);
    }
    public void setCurrentHealth() {
        this.currentHealth = myCharacter.getCurrentHp();
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

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource().equals(currentHealthField)){
            char c=e.getKeyChar();
            {
                if(!Character.isDigit(c)||c==KeyEvent.VK_DELETE){
                    e.consume();
                }
                if (currentHealthField.getText().length() >= (maxHealthPanel.getText().length()-1) && c != KeyEvent.VK_DELETE &&
                        (currentHealthField.getSelectedText()==null)) {
                    e.consume();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource().equals(currentHealthField)){
            if(currentHealthField.getText().isEmpty()){
                setCurrentHealth();
            }
            else{
                setCurrentHealth(Integer.parseInt(currentHealthField.getText()));
            }

        }

    }
}
