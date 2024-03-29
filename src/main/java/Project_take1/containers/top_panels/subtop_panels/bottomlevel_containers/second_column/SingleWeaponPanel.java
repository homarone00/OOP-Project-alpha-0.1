package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column;

import Project_take1.MyCharacter;
import Project_take1.graphics.RoundedJPanel;
import Project_take1.inventory.Damage;
import Project_take1.inventory.Weapon;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SingleWeaponPanel extends RoundedJPanel implements MouseListener{
    MyCharacter myCharacter;
    Weapon weapon;
    boolean editable;
    JTextField nameField;
    JTextField bonusField;
    JTextField damageField;
    boolean isWeapon;
    JLabel iconLabel=new JLabel();
    boolean crossHovered=false;
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

        iconLabel.setPreferredSize(new Dimension(30,20));
        iconLabel.setHorizontalAlignment(JLabel.CENTER);
        iconLabel.addMouseListener(this);
        if(isWeapon()){
            iconLabel.setIcon(getPalette().getSwordIcon());
        }
        else{
            iconLabel.setIcon(getPalette().getDamageIcon());
        }
        add(contentPanel,BorderLayout.CENTER);
        add(iconLabel,BorderLayout.WEST);
        setEditable(false);
    }
    public SingleWeaponPanel(MyCharacter myCharacter, boolean isWeapon, Weapon weapon) {
        super();
        if (!weapon.isWeapon()){
            throw new IllegalArgumentException("the Item provided is not a weapon (SingleWeaponPanel constructor)");
        }
        this.myCharacter=myCharacter;
        this.isWeapon=isWeapon;
        setWeapon(weapon);
        nameField=new JTextField(weapon.getName()){
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
        damageField =new JTextField(weapon.getDamage().getDamage_dice()){

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

        iconLabel.setPreferredSize(new Dimension(30,20));
        iconLabel.setHorizontalAlignment(JLabel.CENTER);
        iconLabel.addMouseListener(this);
        if(isWeapon()){
            iconLabel.setIcon(getPalette().getSwordIcon());
        }
        else{
            iconLabel.setIcon(getPalette().getDamageIcon());
        }
        add(contentPanel,BorderLayout.CENTER);
        add(iconLabel,BorderLayout.WEST);
        setEditable(false);

    }


    @Override
    public void paintComponent(Graphics g) {
        this.setArcs(20,20);
        super.paintComponent(g);
    }

    @Override
    public void updateColors() {
        nameField.setForeground(getPalette().text());
        damageField.setForeground(getPalette().text());
        bonusField.setForeground(getPalette().text());
        if(isWeapon){
            iconLabel.setIcon(getPalette().getSwordIcon());
        }
        else{
            iconLabel.setIcon(getPalette().getDamageIcon());
        }
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
            iconLabel.setIcon(getPalette().getUnpressedRedCross());
            iconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else{
            iconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            nameField.select(0,0);
            damageField.select(0,0);
            bonusField.select(0,0);
            if(nameField.getHighlighter()!=null){
                nameField.setHighlighter(null);
            }
            if(damageField.getHighlighter()!=null){
                damageField.setHighlighter(null);
            }
            if(bonusField.getHighlighter()!=null){
                bonusField.setHighlighter(null);
            }
            if(isWeapon()){
                iconLabel.setIcon(getPalette().getSwordIcon());
            }
            if(!isWeapon()){
                iconLabel.setIcon(getPalette().getDamageIcon());
            }
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

    public JLabel getIconLabel() {
        return iconLabel;
    }

    public void setIconLabel(JLabel iconLabel) {
        this.iconLabel = iconLabel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource().equals(iconLabel)&&isEditable()){
            if(isEditable()){
                iconLabel.setIcon(getPalette().getPressedRedCross());
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource().equals(iconLabel)&&isEditable()){
            if(isEditable()){
                if(crossHovered){
                    iconLabel.setIcon(getPalette().getHoveredRedCross());
                }
                else{
                    iconLabel.setIcon(getPalette().getUnpressedRedCross());
                }
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().equals(iconLabel)&&isEditable()){
            crossHovered=true;
            iconLabel.setIcon(getPalette().getHoveredRedCross());
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource().equals(iconLabel)&&isEditable()){
            crossHovered=false;
            iconLabel.setIcon(getPalette().getUnpressedRedCross());
        }

    }

    public boolean isEditable() {
        return editable;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void updateDB(){
        weapon.setName(nameField.getText());
        Damage damage=new Damage(damageField.getText(),"damage type");
        weapon.getDamageMap().replace("damage",damage);
        System.out.println(weapon.getDamageMap().get("damage"));

    }
}
