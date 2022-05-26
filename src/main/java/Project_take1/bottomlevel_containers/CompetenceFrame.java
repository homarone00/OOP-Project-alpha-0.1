package Project_take1.bottomlevel_containers;

import Project_take1.MyCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A frame for changing the character competence
 */
public class CompetenceFrame extends JFrame implements ActionListener {

    JPanel f;
    MyCharacter c;
    JCheckBox cbStr;
    JCheckBox cbDex;
    JCheckBox cbCon;
    JCheckBox cbIng;
    JCheckBox cbWis;
    JCheckBox cbCha;
    JButton btUpdate;

    CompetenceFrame(MyCharacter c){

        super("Modify Competence");

        f = new JPanel();

         // Checkboxes that indicates the various character bottomlevel_containers
        cbStr = new JCheckBox("Strength");
        cbDex = new JCheckBox("Dexterity");
        cbCon = new JCheckBox("Constitution");
        cbIng = new JCheckBox("Intelligence");
        cbWis = new JCheckBox("Wisdom");
        cbCha = new JCheckBox("Charisma");
        btUpdate = new JButton("Update");

        this.c = c;

        cbStr.setBounds(10,20,100,20);
        cbDex.setBounds(10,50,100,20);
        cbCon.setBounds(10,80,100,20);
        cbIng.setBounds(10,110,100,20);
        cbWis.setBounds(10,140,100,20);
        cbCha.setBounds(10,170,100,20);
        btUpdate.setBounds(150,170,100,25);

         //The selected checkboxes indicate the competence in that stat

        cbStr.setSelected(c.getStrComp());
        cbDex.setSelected(c.getDexComp());
        cbCon.setSelected(c.getConComp());
        cbIng.setSelected(c.getIngComp());
        cbWis.setSelected(c.getWisComp());
        cbCha.setSelected(c.getChaComp());

        cbStr.setFocusable(false);
        cbDex.setFocusable(false);
        cbCon.setFocusable(false);
        cbIng.setFocusable(false);
        cbWis.setFocusable(false);
        cbCha.setFocusable(false);
        btUpdate.setFocusable(false);

        btUpdate.addActionListener(this);

        f.add(cbStr);
        f.add(cbDex);
        f.add(cbCon);
        f.add(cbIng);
        f.add(cbWis);
        f.add(cbCha);
        f.add(btUpdate);

        this.setContentPane(f);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setSize(300,250);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btUpdate)
        {
            c.setStrComp(cbStr.isSelected());
            c.setDexComp(cbDex.isSelected());
            c.setConComp(cbCon.isSelected());
            c.setIngComp(cbIng.isSelected());
            c.setWisComp(cbWis.isSelected());
            c.setChaComp(cbCha.isSelected());

            this.dispose();
        }
    }
}