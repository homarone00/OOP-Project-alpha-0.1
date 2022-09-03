package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column;

import Project_take1.MyCharacter;
import Project_take1.graphics.RoundedJPanel;
import Project_take1.inventory.Weapon;

import javax.swing.*;
import java.awt.*;

public class SingleWeaponPanel extends RoundedJPanel {
    MyCharacter myCharacter;
    Weapon weapon;
    boolean editable;
    JTextField nameField;
    JTextField bonusField;
    JTextField damageField;
    public SingleWeaponPanel(MyCharacter myCharacter) {
        super();
        this.myCharacter=myCharacter;
        this.weapon=weapon;

        nameField=new JTextField("Spadozza"){
            @Override
            public void paintComponent(Graphics g){
                Color oldColor=g.getColor();
                if(editable){
                    g.setColor((getPalette().border()));
                }
                else{
                    g.setColor(getPalette().panel());
                }
                g.drawRoundRect(1,1,this.getSize().width-2,this.getSize().height,5,5);
            }
        };
        bonusField=new JTextField("+7"){
            @Override
            public void paintComponent(Graphics g){
                Color oldColor=g.getColor();
                if(editable){
                    g.setColor((getPalette().border()));
                }
                else{
                    g.setColor(getPalette().panel());
                }
                g.drawRoundRect(1,1,this.getSize().width-2,this.getSize().height,5,5);
            }
        };
        damageField =new JTextField("1d8 + 6"){
            @Override
            public void paintComponent(Graphics g){
                Color oldColor=g.getColor();
                if(editable){
                    g.setColor((getPalette().border()));
                }
                else{
                    g.setColor(getPalette().panel());
                }
                g.drawRoundRect(1,1,this.getSize().width-2,this.getSize().height,5,5);
            }
        };

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(getPreferredSize().width,20));
        setOpaque(false);

        setEditable(false);

        nameField.setBorder(null);
        bonusField.setBorder(null);
        damageField.setBorder(null);

        add(nameField,BorderLayout.WEST);
        add(bonusField,BorderLayout.CENTER);
        add(damageField,BorderLayout.WEST);

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
        repaint();
    }
}
