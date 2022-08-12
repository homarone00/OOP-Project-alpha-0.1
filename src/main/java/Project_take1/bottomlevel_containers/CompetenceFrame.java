package Project_take1.bottomlevel_containers;

import Project_take1.MyCharacter;

import javax.swing.*;
import java.awt.*;

/**
 * A frame for changing the character proficiency
 */
public class CompetenceFrame extends JFrame /*implements ActionListener*/ {

    JPanel f;
    MyCharacter myCharacter;
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

        this.myCharacter = c;

        cbStr.setBounds(10,20,100,20);
        cbDex.setBounds(10,50,100,20);
        cbCon.setBounds(10,80,100,20);
        cbIng.setBounds(10,110,100,20);
        cbWis.setBounds(10,140,100,20);
        cbCha.setBounds(10,170,100,20);
        btUpdate.setBounds(150,170,100,25);

         //The selected checkboxes indicate the proficiency in that stat
        /*
        cbStr.setSelected(myCharacter.getStrProf());
        cbDex.setSelected(myCharacter.getDexProf());
        cbCon.setSelected(myCharacter.getConProf());
        cbIng.setSelected(myCharacter.getIngComp());
        cbWis.setSelected(myCharacter.getWisProf());
        cbCha.setSelected(myCharacter.getChaComp());
        */
        cbStr.setFocusable(false);
        cbDex.setFocusable(false);
        cbCon.setFocusable(false);
        cbIng.setFocusable(false);
        cbWis.setFocusable(false);
        cbCha.setFocusable(false);
        btUpdate.setFocusable(false);

        //btUpdate.addActionListener(this);

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
    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btUpdate)
        {
            myCharacter.setStrProf(cbStr.isSelected());
            myCharacter.setDexProf(cbDex.isSelected());
            myCharacter.setConProf(cbCon.isSelected());
            myCharacter.setIngComp(cbIng.isSelected());
            myCharacter.setWisProf(cbWis.isSelected());
            myCharacter.setChaComp(cbCha.isSelected());

            this.dispose();
        }
    }

     */
}