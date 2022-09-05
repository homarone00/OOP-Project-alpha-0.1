package Project_take1.chCreation;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.JTextComponent;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class ChCreat extends JFrame{
    private JLabel lbName;
    private JTextField tfName;
    private JComboBox comboBox1;
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
    private JPanel ClassPanel;
    private JComboBox cbClasses;
    private JButton btCreate;
    private JPanel ClassBonusPanel;

    public ChCreat(){
        KeyListener num = new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
                Object obj = e.getComponent();
                if(obj instanceof JTextComponent && c >= '0' && c<= '9'){
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
            txStat.get(i).setText("10");
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
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChCreat::new);
    }
}
