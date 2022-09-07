package Project_take1.chCreation;

import Project_take1.MyCharacterCons;
import Project_take1.abilities.Ability;
import Project_take1.classes.MyClassCr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class BarbPanel extends JPanel implements MyClassPanel, MyCharacterCons {
    private JPanel mainPanel;
    private JLabel ptPoint;
    private JPanel AbPanel;
    private JLabel primStat;
    private JLabel sv1;
    private JLabel sv2;
    private JLabel stat_2;
    MyClassCr classCr;
    ArrayList<JRadioButton> btRadio = new ArrayList<>();

    public BarbPanel(String className) {
        classCr = new MyClassCr(className);
        if(className.equalsIgnoreCase("Barbarian")){
            AbPanel.setLayout(new GridLayout(2,3));
        } else if (className.equalsIgnoreCase("Bard")) {
            AbPanel.setLayout(new GridLayout(6,3));
        } else if (className.equalsIgnoreCase("Cleric")) {
            AbPanel.setLayout(new GridLayout(2,3));
        } else if (className.equalsIgnoreCase("Ranger")) {
            AbPanel.setLayout(new GridLayout(4,3));
        } else if (className.equalsIgnoreCase("Druid")) {
            AbPanel.setLayout(new GridLayout(3,3));
        } else if (className.equalsIgnoreCase("Monk")) {
            AbPanel.setLayout(new GridLayout(2,3));
        } else if (className.equalsIgnoreCase("Paladin")) {
            AbPanel.setLayout(new GridLayout(2,3));
        }  else if (className.equalsIgnoreCase("Rogue")) {
            AbPanel.setLayout(new GridLayout(4,3));
        } else if (className.equalsIgnoreCase("Sorcerer")) {
            AbPanel.setLayout(new GridLayout(2,3));
        } else if (className.equalsIgnoreCase("Warlock")) {
            AbPanel.setLayout(new GridLayout(3,3));
        } else if (className.equalsIgnoreCase("Wizard")) {
            AbPanel.setLayout(new GridLayout(2,3));
        } else {
            throw new RuntimeException("Nome errato");
        }


        ptPoint.setText(String.valueOf(classCr.getProfPoint()));
        for(Integer i:classCr.getChAbilityPro()){
            btRadio.add(new JRadioButton(Ability.getAbilityName(i)));
        }
        primStat.setText(Ability.getAbilityName(classCr.getPrimaryStat().get(0)));
        if(classCr.getPrimaryStat().size() > 1) {
            stat_2.setText(Ability.getAbilityName(classCr.getPrimaryStat().get(1)));
        } else {
            stat_2.setText("");
        }
        sv1.setText(Ability.getAbilityName(classCr.getSaveProf().get(0)));
        sv2.setText(Ability.getAbilityName(classCr.getSaveProf().get(1)));
        ItemListener listener = e -> {
            if(e.getSource() instanceof JRadioButton rb){
                if(e.getStateChange() == ItemEvent.DESELECTED){
                    classCr.setProfPoint(classCr.getProfPoint() + 1);
                } else if(e.getStateChange() == ItemEvent.SELECTED && classCr.getProfPoint() > 0){
                    classCr.setProfPoint(classCr.getProfPoint() - 1);
                } else if(e.getStateChange() == ItemEvent.SELECTED && classCr.getProfPoint() == 0){
                    rb.setSelected(false);
                    classCr.setProfPoint(classCr.getProfPoint() - 1);
                }
            }
            ptPoint.setText(String.valueOf(classCr.getProfPoint()));
            System.out.println(classCr.getProfPoint());
        };
        for(JRadioButton i:btRadio){
            AbPanel.add(i);
            i.addItemListener(listener);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lol");
        BarbPanel barb = new BarbPanel("Barbarian");
        barb.setVisible(true);
        barb.setOpaque(true);
        barb.setSize(new Dimension(200,200));
        frame.setContentPane(barb.mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public ArrayList<Boolean> getAbilityProf() {
        if(classCr.getProfPoint() != 0){
            throw new RuntimeException("Deve essere a 0");
        }
        ArrayList<Boolean> ret = new ArrayList<>();
        for(int j = ACROBATICS; j <= SURVIVAL; j++){
            boolean t = false;
            for(JRadioButton rb:btRadio){
                if(rb.getText().equalsIgnoreCase(Ability.getAbilityName(j)) && rb.isSelected()){
                    ret.add(true);
                    t = true;
                }
            }
            if(!t){
                ret.add(false);
            }
            ret.add(false);
        }
        return ret;
    }

    @Override
    public ArrayList<Integer> getPrimaryStat() {
        return classCr.getPrimaryStat();
    }

    @Override
    public ArrayList<Boolean> getSaveProf() {
        ArrayList<Boolean> ret = new ArrayList<>();
        for(int i = STRENGTH_SAVE; i <= CHARISMA_SAVE; i++){
            if(classCr.getSaveProf().contains(i)){
                ret.add(true);
            } else {
                ret.add(false);
            }
        }
        return ret;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
