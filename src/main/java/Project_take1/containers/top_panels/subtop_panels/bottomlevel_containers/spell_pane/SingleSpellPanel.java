package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.spell_pane;

import Project_take1.graphics.RoundedJPanel;
import Project_take1.spells.Spell;

import javax.swing.*;
import java.awt.*;

public class SingleSpellPanel extends RoundedJPanel {
    JLabel spellName;
    Spell spell;
    JLabel components;
    JLabel iconLabel;

    public SingleSpellPanel(Spell spell) {
        super();
        setArcs(30,30);

        spellName=new JLabel();
        spellName.setOpaque(false);
        components=new JLabel();
        components.setOpaque(false);

        this.spell = spell;
        spellName.setText(spell.getName());
        components.setText(spell.getStringComponents());

        setOpaque(false);
        setLayout(new GridBagLayout());

        GridBagConstraints c=new GridBagConstraints();
        setPreferredSize(new Dimension(200,50));
        spellName.setFont(new Font("Comic Sans",Font.BOLD,20));
        components.setFont(new Font("Comic Sans",Font.BOLD,7));


        c.fill=GridBagConstraints.BOTH;
        c.gridy=0;
        c.gridx=2;
        c.gridheight=2;
        c.weighty=20;
        c.weightx=10;
        add(spellName,c);

        c.gridy=1;
        c.gridx=3;
        c.gridheight=1;
        c.weighty=2;
        c.weightx=1;
        add(components,c);

        JPanel placeHolderPanel=new JPanel();
        placeHolderPanel.setOpaque(false);
        c.gridy=0;
        c.gridx=3;
        c.gridheight=1;
        c.weighty=2;
        c.weightx=9;
        add(placeHolderPanel,c);

        iconLabel =new JLabel();
        iconLabel.setOpaque(false);
        c.gridy=0;
        c.gridx=1;
        c.gridheight=2;
        c.weighty=2;
        c.weightx=3;

        updateIcon();

        add(iconLabel,c);

        JPanel placeHolderPanel2=new JPanel();
        placeHolderPanel2.setOpaque(false);
        c.gridy=0;
        c.gridx=0;
        c.gridheight=2;
        c.weighty=2;
        c.weightx=1;
        add(placeHolderPanel2,c);
    }

    private void updateIcon() {
        if(spell.getName().contains("heal")||spell.getName().contains("Heal")
        ||spell.getName().contains("Cure")||spell.getName().contains("cure")){
            iconLabel.setIcon(getPalette().getHealIcon());
            return;
        }
        for(String i:spell.getDesc()){
            try{String j=spell.getHighLv().get(0);
                if((i.contains("damage")||i.contains("Damage"))&&(j.contains("increases")&&j.contains("damage"))){
                    iconLabel.setIcon(getPalette().getFireballIcon());
                    return;
                }
            }
            catch (IndexOutOfBoundsException ignored){}

        }
        if(!spell.getAttType().equals("None")){
            iconLabel.setIcon(getPalette().getFireballIcon());
            return;
        }
        iconLabel.setIcon(getPalette().getSupportIcon());
    }

    @Override
    public void updateColors() {
        updateIcon();
        spellName.setForeground(getPalette().text());
        components.setForeground(getPalette().text());

    }

    @Override
    public void updatePanel() {

    }
}
