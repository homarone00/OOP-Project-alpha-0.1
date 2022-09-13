package Project_take1.containers.top_panels;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.SpellPanel;
import Project_take1.graphics.UpdatablePanel;
import Project_take1.spells.Spell;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class MySpellPane extends JPanel implements UpdatablePanel {
    MyCharacter myCharacter;
    SpellPanel lvl0;
    SpellPanel lvl1;
    SpellPanel lvl2;
    SpellPanel lvl3;
    SpellPanel lvl4;
    SpellPanel lvl5;
    SpellPanel lvl6;
    SpellPanel lvl7;
    SpellPanel lvl8;
    SpellPanel lvl9;
    JPanel bottomPanel=new JPanel();
    JTextField searchField=new JTextField(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Color oldColor=g.getColor();
            g.setColor((getPalette().border()));
            g.drawRoundRect(0,9,searchField.getSize().width-1,searchField.getSize().height-20,20,20);
            g.setColor(oldColor);
        }
    };
    JLabel searchLabel=new JLabel("  SEARCH:");

    public MySpellPane(MyCharacter myCharacter) {
        super(new BorderLayout());
        this.myCharacter=myCharacter;
        setBackground(getPalette().background());
        setOpaque(true);

        lvl0=new SpellPanel(0,myCharacter);
        lvl1=new SpellPanel(1,myCharacter);
        lvl2=new SpellPanel(2,myCharacter);
        lvl3=new SpellPanel(3,myCharacter);
        lvl4=new SpellPanel(4,myCharacter);
        lvl5=new SpellPanel(5,myCharacter);
        lvl6=new SpellPanel(6,myCharacter);
        lvl7=new SpellPanel(7,myCharacter);
        lvl8=new SpellPanel(8,myCharacter);
        lvl9=new SpellPanel(9,myCharacter);

        JPanel contentPane=new JPanel(new GridLayout(2,5,5,5));
        searchField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        searchLabel.setFont(new Font("Comic Sans",Font.BOLD,26));
        searchLabel.setPreferredSize(new Dimension(140,60));
        contentPane.add(lvl0);
        contentPane.add(lvl1);
        contentPane.add(lvl2);
        contentPane.add(lvl3);
        contentPane.add(lvl4);
        contentPane.add(lvl5);
        contentPane.add(lvl6);
        contentPane.add(lvl7);
        contentPane.add(lvl8);
        contentPane.add(lvl9);
        contentPane.setOpaque(false);
        add(contentPane,BorderLayout.CENTER);

        bottomPanel=new JPanel(new BorderLayout(25,0)){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Color oldColor =g.getColor();
                g.setColor(getPalette().panel());
                Graphics2D g2d=(Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.fillRoundRect(3,2,bottomPanel.getSize().width-6,bottomPanel.getSize().height-5,30,30);
                g.setColor(oldColor);
            }
        };

        bottomPanel.setOpaque(false);
        bottomPanel.add(searchLabel,BorderLayout.WEST);
        bottomPanel.add(searchField,BorderLayout.CENTER);

        searchField.setOpaque(false);
        searchField.setFont(new Font("Comic Sans",Font.BOLD,26));
        JPanel placeHolderPanel= new JPanel();
        placeHolderPanel.setOpaque(false);
        placeHolderPanel.setPreferredSize(new Dimension(500,40));
        bottomPanel.setPreferredSize(new Dimension(1000,60));
        bottomPanel.add(placeHolderPanel,BorderLayout.EAST);

        add(bottomPanel,BorderLayout.SOUTH);
        searchField.addActionListener(actionValue -> {
            Spell spell=new Spell(searchField.getText());
            myCharacter.getKnownSpells().insert(spell);
            lvl0.addSpell(spell);
            lvl1.addSpell(spell);
            lvl2.addSpell(spell);
            lvl3.addSpell(spell);
            lvl4.addSpell(spell);
            lvl5.addSpell(spell);
            lvl6.addSpell(spell);
            lvl7.addSpell(spell);
            lvl8.addSpell(spell);
            lvl9.addSpell(spell);
        });
    }

    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }
}
