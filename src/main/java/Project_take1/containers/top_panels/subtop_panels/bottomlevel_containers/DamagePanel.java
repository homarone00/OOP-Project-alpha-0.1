package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.DamageModifiersPanel;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.WeaponsPanel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DamagePanel extends JPanel implements UpdatablePanel, PropertyChangeListener {
    MyCharacter myCharacter;
    WeaponsPanel weaponsPanel;
    DamageModifiersPanel damageModifiersPanel;
    public DamagePanel(MyCharacter myCharacter) {
        super(new BorderLayout());
        this.myCharacter=myCharacter;
        setOpaque(false);
        weaponsPanel=new WeaponsPanel(myCharacter);
        damageModifiersPanel=new DamageModifiersPanel(myCharacter);

        add(weaponsPanel,BorderLayout.CENTER);
        add(damageModifiersPanel,BorderLayout.SOUTH);

        weaponsPanel.addPropertyChangeListener(this);
        damageModifiersPanel.addPropertyChangeListener(this);
    }

    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if(e.getSource().equals(weaponsPanel)||e.getSource().equals(damageModifiersPanel)){
            updateSizes();
            System.out.println("helo");
        }
    }

    public void updateSizes() {
        double factor=weaponsPanel.getLength()/damageModifiersPanel.getLength();
        double totalHeight=300;
        weaponsPanel.setPreferredSize(new Dimension(getPreferredSize().width, (int) ((factor/(factor+1))*totalHeight)));
        damageModifiersPanel.setPreferredSize(new Dimension(getPreferredSize().width,(int)((1/(factor+1))*totalHeight)));
    }
}
