package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column;

import Project_take1.graphics.RoundedJPanel;

import javax.swing.*;
import java.awt.*;

public class SingleWeaponPanel extends RoundedJPanel {
    JTextField name;
    private JTextField attackModifier;
    private int modifier;
    JTextField damage;
    public SingleWeaponPanel() {
        name=new JTextField();
        name.setText("GIGASPADOZZO");
        attackModifier=new JTextField("+5");
        JTextField damage=new JTextField("1d8 + 4d8 + 5");

        setPreferredSize(new Dimension(this.getPreferredSize().width,20));
        setLayout(new BorderLayout());


        add(name,BorderLayout.WEST);
    }

    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }
    public void SetWeaponName(String name){
        this.name.setText(name);
    }
    public void setAttackModifier(String modifier){
        this.attackModifier.setText(modifier);
        this.modifier=Integer.parseInt(modifier);
    }
    public void setAttackModifier(int modifier){
        this.modifier=modifier;
        if(modifier>=0){
            this.attackModifier.setText("+" + modifier);
        }
        else{
            this.attackModifier.setText(Integer.toString(modifier));
        }
    }
    public String GetWeaponName(){
        return name.getText();
    }

    public int getAttackModifier(){
        return modifier;
    }
    public String getAttackModifierString(){
        return attackModifier.getText();
    }
}
