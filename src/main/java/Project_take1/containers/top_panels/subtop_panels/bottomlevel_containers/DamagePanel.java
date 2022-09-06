package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.DamageModifiersPanel;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.SingleWeaponPanel;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.WeaponsPanel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.EventListener;

public class DamagePanel extends JPanel implements UpdatablePanel, MouseListener {
    MyCharacter myCharacter;
    WeaponsPanel weaponsPanel;
    DamageModifiersPanel damageModifiersPanel;
    public DamagePanel(MyCharacter myCharacter) {
        super(new GridBagLayout());
        this.myCharacter=myCharacter;
        setOpaque(false);
        weaponsPanel=new WeaponsPanel(myCharacter);
        damageModifiersPanel=new DamageModifiersPanel(myCharacter);

        GridBagConstraints c=new GridBagConstraints();

        c.weightx=5;
        c.weighty=5;
        c.gridx=0;
        c.gridy=0;
        c.fill=GridBagConstraints.BOTH;
        add(weaponsPanel,c);
        c.gridy=1;
        add(damageModifiersPanel,c);

        weaponsPanel.getPlusLabel().addMouseListener(this);
        damageModifiersPanel.getPlusLabel().addMouseListener(this);

        updateListener();
    }

    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }

    public void updateSizes() {
        double factor=((double)weaponsPanel.getLength())/((double)damageModifiersPanel.getLength());
        double totalHeight=300;
        weaponsPanel.setPreferredSize(new Dimension(getPreferredSize().width, (int) ((factor/(factor+1))*totalHeight)));
        damageModifiersPanel.setPreferredSize(new Dimension(getPreferredSize().width,(int)((1/(factor+1))*totalHeight)));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(weaponsPanel.getPlusLabel())&&weaponsPanel.getLength()<6){
            weaponsPanel.addPanel();
            updateSizes();
            updateListener();
            revalidate();
        }
        if(e.getSource().equals(damageModifiersPanel.getPlusLabel()) && (damageModifiersPanel.getLength() < 6)){
            damageModifiersPanel.addPanel();
            updateSizes();
            updateListener();
            revalidate();
        }
        int j=0;
        for(SingleWeaponPanel i: weaponsPanel.getSingleWeaponPanelArrayList()){
            if(e.getSource().equals(i.getIconLabel())&&weaponsPanel.isEditing()){
                weaponsPanel.removePanel(j);
                updateListener();
                revalidate();
                updateSizes();
                break;
            }
            j++;
        }
        int k=0;
        for(SingleWeaponPanel i: damageModifiersPanel.getSingleWeaponPanelArrayList()){
            if(e.getSource().equals(i.getIconLabel())&&damageModifiersPanel.isEditing()){
                damageModifiersPanel.removePanel(k);
                updateListener();
                revalidate();
                updateSizes();
                break;
            }
            k++;
        }

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

    public void updateListener(){
        for(SingleWeaponPanel i: weaponsPanel.getSingleWeaponPanelArrayList()){
            if(i.getIconLabel().getListeners(MouseListener.class).length == 0){
                i.getIconLabel().addMouseListener(this);
            }
        }
        for(SingleWeaponPanel i: damageModifiersPanel.getSingleWeaponPanelArrayList()){
            if(i.getIconLabel().getListeners(MouseListener.class).length == 0){
                i.getIconLabel().addMouseListener(this);
            }
        }
    }
}
