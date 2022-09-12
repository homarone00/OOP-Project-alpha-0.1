package Project_take1.containers.top_panels.subtop_panels;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.spell_pane.SingleSpellPanel;
import Project_take1.graphics.UpdatablePanel;
import Project_take1.spells.Spell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpellPanel extends JPanel implements UpdatablePanel {
    int level;
    MyCharacter myCharacter;
    int length;
    JLabel title;
    JPanel contentPane;
    ArrayList<SingleSpellPanel> singleSpellPanels;
    JPanel placeHolderPanel;
    public SpellPanel(int level, MyCharacter myCharacter){
        super(new BorderLayout());
        title=new JLabel();
        contentPane=new JPanel(new GridBagLayout());
        length=0;
        title.setHorizontalAlignment(JLabel.CENTER);
        if(level==0){
            title.setText("CANTRIPS");
        }
        else if(level==1){
            title.setText("1st LEVEL");
        }
        else if(level==2){
            title.setText("2nd LEVEL");
        }
        else if(level==3){
            title.setText("3rd LEVEL");
        }
        else{
            title.setText(level + "th LEVEL");
        }
        title.setOpaque(false);
        title.setFont(new Font("Comic Sans",Font.BOLD,23));
        GridBagConstraints c=new GridBagConstraints();
        Insets i=new Insets(10,10,10,10);

        add(title,BorderLayout.NORTH);


        placeHolderPanel=new JPanel();
        placeHolderPanel.setOpaque(false);
        c.gridx=0;
        c.gridy=50;
        c.fill=GridBagConstraints.BOTH;
        c.weighty=150;
        c.weightx=10;
        contentPane.add(placeHolderPanel,c);
        contentPane.setOpaque(false);

        this.myCharacter=myCharacter;
        this.level=level;
        for(Spell spell :myCharacter.getKnownSpells().getArraySpells()){
            addSpell(spell);
        }
        myCharacter.getKnownSpells().getArraySpells();
        setOpaque(false);
        add(contentPane,BorderLayout.CENTER);
    }
    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }

    public void addSpell(Spell spell){
        if(spell.getLevel()==level){

            GridBagConstraints c=new GridBagConstraints();
            Insets i=new Insets(3,3,3,3);
            c.insets=i;
            c.gridx=0;
            c.gridy=length;
            c.fill=GridBagConstraints.BOTH;
            c.weighty=10;
            c.weightx=100;

            contentPane.add(new SingleSpellPanel(spell),c);
            length++;

            contentPane.remove(placeHolderPanel);
            c.gridx=0;
            c.gridy=50;
            c.fill=GridBagConstraints.BOTH;
            c.weighty=150-length*12;
            c.weightx=10;
            contentPane.add(placeHolderPanel,c);
            revalidate();
        }

    }
}
