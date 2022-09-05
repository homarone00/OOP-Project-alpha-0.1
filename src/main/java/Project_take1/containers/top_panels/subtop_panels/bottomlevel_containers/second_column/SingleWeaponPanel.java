package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column;

import Project_take1.MyCharacter;
import Project_take1.graphics.RoundedJPanel;
import Project_take1.inventory.Weapon;

import javax.swing.*;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.util.Objects;

public class SingleWeaponPanel extends RoundedJPanel {
    MyCharacter myCharacter;
    Weapon weapon;
    boolean editable;
    JTextField nameField;
    JTextField bonusField;
    JTextField damageField;
    boolean isWeapon;
    public SingleWeaponPanel(MyCharacter myCharacter, boolean isWeapon) {
        super();
        this.myCharacter=myCharacter;
        this.isWeapon=isWeapon;
        nameField=new JTextField("Spadozza"){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Color oldColor=g.getColor();
                if(editable){
                    g.setColor((getPalette().border()));
                }
                else{
                    g.setColor(getPalette().panel());
                }
                g.drawRoundRect(3,2,nameField.getSize().width-7,nameField.getSize().height-5,20,20);
                g.setColor(oldColor);
            }
        };
        bonusField=new JTextField("+7"){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Color oldColor=g.getColor();
                if(editable){
                    g.setColor((getPalette().border()));
                }
                else{
                    g.setColor(getPalette().panel());
                }
                g.drawRoundRect(1,1,bonusField.getSize().width-2,bonusField.getSize().height-4,20,20);
                g.setColor(oldColor);
            }
        };
        damageField =new JTextField("1d8 + 6"){

            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Color oldColor=g.getColor();
                if(editable){
                    g.setColor((getPalette().border()));
                }
                else{
                    g.setColor(getPalette().panel());
                }
                g.drawRoundRect(1,1,damageField.getSize().width-8,damageField.getSize().height-4,20,20);
                g.setColor(oldColor);
            }
        };
        setLayout(new BorderLayout(5,0));
        setPreferredSize(new Dimension(180,20));
        setOpaque(false);

        setEditable(false);

        nameField.setBorder(null);
        bonusField.setBorder(null);
        damageField.setBorder(null);

        nameField.setOpaque(false);
        bonusField.setOpaque(false);
        damageField.setOpaque(false);

        nameField.setPreferredSize(new Dimension(90,20));
        bonusField.setPreferredSize(new Dimension(20,20));
        damageField.setPreferredSize(new Dimension(80,20));

        nameField.setHorizontalAlignment(JTextField.CENTER);
        bonusField.setHorizontalAlignment(JTextField.CENTER);
        damageField.setHorizontalAlignment(JTextField.CENTER);

        nameField.setFont(new Font("Comic Sans",Font.BOLD,12));
        bonusField.setFont(new Font("Comic Sans",Font.BOLD,12));
        damageField.setFont(new Font("Comic Sans",Font.BOLD,12));

        JPanel contentPanel=new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);

        contentPanel.add(nameField,BorderLayout.WEST);
        contentPanel.add(bonusField,BorderLayout.CENTER);
        contentPanel.add(damageField,BorderLayout.LINE_END);

        JLabel iconLabel=new JLabel();
        iconLabel.setPreferredSize(new Dimension(30,20));
        iconLabel.setHorizontalAlignment(JLabel.CENTER);
        if(isWeapon()){
            iconLabel.setIcon(getPalette().getSwordIcon());
        }
        else{
            iconLabel.setIcon(getPalette().getDamageIcon());
        }
        add(contentPanel,BorderLayout.CENTER);
        add(iconLabel,BorderLayout.WEST);
    }

    @Override
    public void paintComponent(Graphics g) {
        this.setArcs(20,20);
        super.paintComponent(g);
    }

    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }
    public void setEditable(boolean editable){
        this.editable=editable;

        nameField.setEditable(editable);
        bonusField.setEditable(editable);
        damageField.setEditable(editable);
        if(editable){
            nameField.setHighlighter(new DefaultHighlighter());
            bonusField.setHighlighter(new DefaultHighlighter());
            damageField.setHighlighter(new DefaultHighlighter());
        }
        else{
            nameField.setHighlighter(null);
            bonusField.setHighlighter(null);
            damageField.setHighlighter(null);
        }
        repaint();
    }
    public void setAsWeapon(){
        isWeapon =true;
    }

    public void setAsDamageModifier(){
        isWeapon=false;
    }
    public boolean isWeapon(){
        if(isWeapon){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isDamageModifier(){
        return !isWeapon;

    }
}
