package Project_take1.chCreation;

import Project_take1.abilities.Ability;
import Project_take1.classes.MyClassCr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class FightPanel extends JPanel implements MyClassPanel{
    private JRadioButton strengthRadioButton;
    private JRadioButton dexterityRadioButton;
    private JPanel mainPanel;
    private JLabel ptProf;
    private JLabel sv1;
    private JLabel sv2;
    private JPanel abPanel;
    MyClassCr classCr = new MyClassCr("Fighter");
    ArrayList<JRadioButton> btRadio = new ArrayList<>();

    public FightPanel() {
        abPanel.setLayout(new GridLayout(3,3));
        ptProf.setText(String.valueOf(classCr.getProfPoint()));
        sv1.setText(Ability.getAbilityName(classCr.getSaveProf().get(0)));
        sv1.setText(Ability.getAbilityName(classCr.getSaveProf().get(1)));
        ButtonGroup group = new ButtonGroup();
        group.add(strengthRadioButton);
        group.add(dexterityRadioButton);
        ptProf.setText(String.valueOf(classCr.getProfPoint()));
        for(Integer i:classCr.getChAbilityPro()){
            btRadio.add(new JRadioButton(Ability.getAbilityName(i)));
        }
        ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
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
                ptProf.setText(String.valueOf(classCr.getProfPoint()));
                System.out.println(classCr.getProfPoint());
            }
        };
        for(JRadioButton i:btRadio){
            abPanel.add(i);
            i.addItemListener(listener);
        }
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
        return null;
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

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lol");
        FightPanel barb = new FightPanel();
        barb.setVisible(true);
        barb.setOpaque(true);
        barb.setSize(new Dimension(200,200));
        frame.setContentPane(barb.mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
