package Project_take1.chCreation;

import Project_take1.MyCharacter;
import Project_take1.containers.MyCharacterSheet;
import Project_take1.race.Race;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class ChCreat extends JFrame{
    private JLabel lbName;
    private JTextField tfName;
    private JComboBox<String> cbRace;
    private JPanel mainPanel;
    private JLabel JLabel;
    private JTextField tfDex;
    private JButton dexM;
    private JButton dexP;
    private JTextField tfStr;
    private JTextField tfCon;
    private JTextField tfInt;
    private JTextField tfWis;
    private JTextField tfCha;
    private JButton strM;
    private JButton strP;
    private JButton conM;
    private JButton intM;
    private JButton wisM;
    private JButton chaM;
    private JButton conP;
    private JButton intP;
    private JButton wisP;
    private JButton chaP;
    private JTextField tfRandM;
    private JTextField tfRandP;
    private JButton btRand;
    private JPanel classPanel;
    private JComboBox cbClasses;
    private JButton btCreate;
    private JPanel classBonusPanel;
    private JLabel lbSt;
    private JLabel lbDex;
    private JLabel lbCon;
    private JLabel lbInt;
    private JLabel lbWis;
    private JLabel lbCha;
    private MyClassPanel pan;
    int selItem;
    Race race = new Race("Human");

    public ChCreat(){
        KeyListener num = new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
                Object obj = e.getComponent();
                if(obj instanceof JTextComponent && c >= '0' && c<= '9') {
                    JTextComponent tx = (JTextComponent) obj;
                    StringBuilder value = new StringBuilder(tx.getText());
                    value.append(c);
                    if(Integer.parseInt(value.toString()) > 20){
                        tx.setText("20");
                        e.consume();
                    }
                }
            }
        };

        /*
          Set all stat action/key listener
         */

        ArrayList<JButton> mButton = new ArrayList<>();
        mButton.add(strM);
        mButton.add(dexM);
        mButton.add(conM);
        mButton.add(intM);
        mButton.add(wisM);
        mButton.add(chaM);
        ArrayList<JButton> pButton = new ArrayList<>();
        pButton.add(strP);
        pButton.add(dexP);
        pButton.add(conP);
        pButton.add(intP);
        pButton.add(wisP);
        pButton.add(chaP);
        ArrayList<JTextField> txStat = new ArrayList<>();
        txStat.add(tfStr);
        txStat.add(tfDex);
        txStat.add(tfCon);
        txStat.add(tfInt);
        txStat.add(tfWis);
        txStat.add(tfCha);
        ArrayList<JLabel> lbStat = new ArrayList<>();
        lbStat.add(lbSt);
        lbStat.add(lbDex);
        lbStat.add(lbCon);
        lbStat.add(lbInt);
        lbStat.add(lbWis);
        lbStat.add(lbCha);

        for(int i = 0; i < 6; i++){
            int finalI = i;
            mButton.get(finalI).addActionListener(e -> {
                int value = Integer.parseInt(txStat.get(finalI).getText());
                if(value == 0){
                    return;
                }
                value--;
                txStat.get(finalI).setText(String.valueOf(value));
            });
            pButton.get(finalI).addActionListener(e -> {
                int value = Integer.parseInt(txStat.get(finalI).getText());
                if(value == 20){
                    return;
                }
                value++;
                txStat.get(finalI).setText(String.valueOf(value));
            });
            mButton.get(finalI).setFocusable(false);
            pButton.get(finalI).setFocusable(false);
            txStat.get(i).setText("11");
            lbStat.get(i).setText(String.valueOf(race.getAbility().get(i)));
            txStat.get(i).addKeyListener(num);
        }

        /*
         * Set Random action listener
         */

        tfRandM.addKeyListener(num);
        tfRandP.addKeyListener(num);
        btRand.addActionListener(e -> {
            if(tfRandM.getText().isEmpty() || tfRandP.getText().isEmpty()) {
                throw new RuntimeException("Ha da essere riempito");
            }
            Random rnd = new Random();
            for(JTextField tf:txStat){
                tf.setText(String.valueOf(rnd.nextInt(Integer.parseInt(tfRandM.getText()),
                        Integer.parseInt(tfRandP.getText()) + 1)));
            }
        });

        /*
        ComboBox Listener
         */

        System.out.println(cbClasses.getSelectedIndex());
        selItem = cbClasses.getSelectedIndex();
        cbClasses.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getSource() instanceof JComboBox<?>){
                    JComboBox<String> box = (JComboBox<String>) e.getSource();
                    int i = box.getSelectedIndex();
                    box.setEnabled(false);
                    if(i != selItem){
                        selItem = i;
                        MyClassPanel pn;
                        String lol = (String) box.getSelectedItem();
                        if(lol.equalsIgnoreCase("Fighter")){
                            pn = new FightPanel();
                        } else {
                            pn = new BarbPanel(lol);
                        }
                        classBonusPanel.remove(pan.getMainPanel());
                        classBonusPanel.add(pn.getMainPanel());
                        pan = pn;
                    }
                    box.setEnabled(true);
                    pan.getMainPanel().setVisible(false);
                    pan.getMainPanel().setVisible(true);
                }
            }
        });

        cbRace.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getSource() instanceof JComboBox<?>){
                    JComboBox<String> box = (JComboBox<String>) e.getSource();
                    int i = box.getSelectedIndex();
                    box.setEnabled(false);
                    race = new Race((String)box.getSelectedItem());
                    for(int j = 0; j<6; j++){
                        lbStat.get(j).setText(String.valueOf(race.getAbility().get(j)));
                        int val = 10 + race.getAbility().get(j);
                        txStat.get(j).setText(String.valueOf(val));
                    }
                    box.setEnabled(true);
                }
            }
        });

        /*
         * create action listener
         */

        btCreate.addActionListener(e -> {
            String name = tfName.getText();
            if(name.equalsIgnoreCase("")){
                return;
            }
            ArrayList<Integer> abPoint = new ArrayList<>();
            for(JTextField tf:txStat){
                abPoint.add(Integer.valueOf(tf.getText()));
            }
            MyCharacter myCharacter = new MyCharacter(name, race.getName(), (String) cbClasses.getSelectedItem(), abPoint,
                    pan.getSaveProf(), pan.getAbilityProf());
            SwingUtilities.invokeLater(() -> new MyCharacterSheet(myCharacter));
        });

        /*
         * Frame initialization
         */

        pan = new BarbPanel("Barbarian");
        classBonusPanel.add(pan.getMainPanel(), BorderLayout.CENTER);
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChCreat::new);
    }
}
