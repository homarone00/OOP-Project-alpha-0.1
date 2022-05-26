package Project_take1.toplevel_containers;

import Project_take1.toplevel_containers.MyContentPane;

import javax.swing.*;

public class MyTabbedPane extends JTabbedPane {
    MyContentPane abilityTab;
    JPanel spellTab;
    boolean hasSpells;
    JPanel bioTab;
    JPanel bookTab;
    public MyTabbedPane(){
        abilityTab=new MyContentPane();
        this.addTab("Abilities",abilityTab);
        //placeholders
        spellTab=new JPanel();
        this.addTab("Spells",spellTab);

        //graphics
        this.setBorder(null);

        //setting position
        this.setTabPlacement(BOTTOM);
    }

    public void updateColors(){
        abilityTab.updateColors();
    }
}
