package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.HPpanels;

import Project_take1.MyCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class TemporaryHealthPanel extends AbstractHealthPanel{
    MainHealthPanel mainHealthPanel;
    public TemporaryHealthPanel(MyCharacter myCharacter, MainHealthPanel mainHealthPanel) {
        super(myCharacter);
        setCurrentHealth();
        this.mainHealthPanel=mainHealthPanel;
        nameLabel.setText("<html>temp<br>HP</html>");
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,18));

        currentHealthField.setFont(new Font("Comic Sans",Font.BOLD,20));

        addingField.addActionListener(actionValue -> {
            String content=addingField.getText();
            if(!content.isEmpty()){
                if(content.startsWith("+")||content.startsWith("-")){
                    int integer;
                    try{
                        integer=Integer.parseInt(content);
                        int current =getCurrentHealth();
                        current +=integer;
                        if(current>=0){
                            setCurrentHealth(current);
                            addingField.setText("");
                        }
                        else{
                            setCurrentHealth(0);
                            mainHealthPanel.addValue(current);
                            addingField.setText("");
                        }
                    } catch (NumberFormatException ignored) {

                    }
                }
            }

        });
        JPanel placeHolderPanel_1=new JPanel();
        JPanel placeHolderPanel_2=new JPanel();
        placeHolderPanel_1.setPreferredSize(new Dimension(placeHolderPanel_1.getPreferredSize().width,18));
        placeHolderPanel_2.setPreferredSize(new Dimension(placeHolderPanel_1.getPreferredSize().width,18));
        hpPanel.add(placeHolderPanel_1,BorderLayout.NORTH);
        hpPanel.add(placeHolderPanel_2,BorderLayout.SOUTH);
        placeHolderPanel_1.setOpaque(false);
        placeHolderPanel_2.setOpaque(false);
        hpPanel.add(currentHealthPanel,BorderLayout.CENTER);
    }
    public void setCurrentHealth(int currentHealth) {
        if(currentHealth<0){
            throw new IllegalArgumentException("TemporaryHealthPanel tried to set a negative value for tmpHP, using the " +
                    "setCurrentHealth method");
        }
        else{
            this.currentHealth = currentHealth;
            currentHealthField.setText(String.valueOf(currentHealth));
            myCharacter.setTemporary_hp(currentHealth);
        }
    }
    @Override
    public void setCurrentHealth() {
        currentHealth=myCharacter.getTemporary_hp();
        if(currentHealth<0){
            throw new IllegalStateException("TemporaryHealthPanel found a negative value for tmp hp");
        }
        currentHealthField.setText(String.valueOf(currentHealth));

    }

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public void updateColors() {
        super.updateColors();
    }

    @Override
    public void updatePanel() {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource().equals(currentHealthField)) {
            if (currentHealthField.getText().isEmpty()) {
                setCurrentHealth();
            } else {
                setCurrentHealth(Integer.parseInt(currentHealthField.getText()));
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource().equals(currentHealthField)){
            char c=e.getKeyChar();
            if(!Character.isDigit(c)||c==KeyEvent.VK_DELETE){
                e.consume();
            }
            if (currentHealthField.getText().length() >= (3) && c != KeyEvent.VK_DELETE &&
                    (currentHealthField.getSelectedText()==null)) {
                e.consume();
            }
        }
        if(e.getSource().equals(addingField)){
            char c=e.getKeyChar();
            if((!Character.isDigit(c))&&!(c=='+'||c=='-')){
                e.consume();
            }
            if (addingField.getText().length() >= 4 && c != KeyEvent.VK_DELETE &&
                    (addingField.getSelectedText()==null)) {
                e.consume();
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
    public void paintComponent(Graphics g){
        this.arcHeight=30;
        this.arcWidth=30;
        super.paintComponent(g);
    }
    @Override
    public void addValue(int a){
        int current=getCurrentHealth();
        current+=a;
        if(current>=0){
            setCurrentHealth(current);
        }
        else{
            setCurrentHealth(0);
            mainHealthPanel.addValue(current);
        }
    }
}
