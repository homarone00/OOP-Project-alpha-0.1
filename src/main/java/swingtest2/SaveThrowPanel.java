package swingtest2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SaveThrowPanel extends JPanel implements MouseListener{
    JPanel saving = new JPanel();
    JRadioButton rbstr = new JRadioButton("Strenght");
    JRadioButton rbdex = new JRadioButton("Dexterity");
    JRadioButton rbwis = new JRadioButton("Wisdom");
    JRadioButton rbing = new JRadioButton("intelligence");
    JRadioButton rbcha = new JRadioButton("Charisma");
    JRadioButton rbcon = new JRadioButton("Constitution");
    JLabel lbstr = new JLabel("15");
    JLabel lbdex = new JLabel("15");
    JLabel lbwis = new JLabel("15");
    JLabel lbing = new JLabel("15");
    JLabel lbcha = new JLabel("15");
    JLabel lbcon = new JLabel("15");
    JLabel sett = new JLabel("ciao");

    MyCharacter ch = new MyCharacter();

    public SaveThrowPanel() {
        super();

        this.setLayout(new BorderLayout());
        this.add(saving, BorderLayout.WEST);
        JPanel right = new JPanel();
        right.setBackground(Color.red);
        right.setLayout(new BorderLayout());

        saving.setLayout(new GridLayout(6, 2));
        sett.setBackground(Color.BLUE);
        sett.setOpaque(true);

        right.add(sett, BorderLayout.NORTH);
        this.add(right, BorderLayout.CENTER);

        sett.addMouseListener(this);


        rbstr.setOpaque(false);
        rbdex.setOpaque(false);
        rbwis.setOpaque(false);
        rbing.setOpaque(false);
        rbcha.setOpaque(false);
        rbcon.setOpaque(false);
        rbstr.setSelected(true);
        rbdex.setSelected(false);
        rbwis.setSelected(true);
        rbing.setSelected(false);
        rbcha.setSelected(true);
        rbcon.setSelected(false);
        rbstr.setFocusable(false);
        rbdex.setFocusable(false);
        rbwis.setFocusable(false);
        rbing.setFocusable(false);
        rbcha.setFocusable(false);
        rbcon.setFocusable(false);

        /*
          rimuovo i mouse listener per renderli immodificabili
         */

        for (MouseListener al : rbstr.getMouseListeners()) {
            rbstr.removeMouseListener(al);
        }
        for (MouseListener al : rbdex.getMouseListeners()) {
            rbdex.removeMouseListener(al);
        }
        for (MouseListener al : rbwis.getMouseListeners()) {
            rbwis.removeMouseListener(al);
        }
        for (MouseListener al : rbing.getMouseListeners()) {
            rbing.removeMouseListener(al);
        }
        for (MouseListener al : rbcha.getMouseListeners()) {
            rbcha.removeMouseListener(al);
        }
        for (MouseListener al : rbcon.getMouseListeners()) {
            rbcon.removeMouseListener(al);
        }


        saving.add(rbstr);
        saving.add(lbstr);
        saving.add(rbdex);
        saving.add(lbdex);
        saving.add(rbcon);
        saving.add(lbwis);
        saving.add(rbwis);
        saving.add(lbing);
        saving.add(rbing);
        saving.add(lbcha);
        saving.add(rbcha);
        saving.add(lbcon);

        lbUpdate(ch);

    }

    public void lbUpdate(MyCharacter i){
        lbstr.setText(String.valueOf(i.getModStr()));
        lbdex.setText(String.valueOf(i.getModDex()));
        lbcon.setText(String.valueOf(i.getModCon()));
        lbwis.setText(String.valueOf(i.getModWis()));
        lbing.setText(String.valueOf(i.getModInt()));
        lbcha.setText(String.valueOf(i.getModCha()));
        rbstr.setSelected(i.getComp()[0]);
        rbdex.setSelected(i.getComp()[1]);
        rbcon.setSelected(i.getComp()[2]);
        rbwis.setSelected(i.getComp()[3]);
        rbing.setSelected(i.getComp()[4]);
        rbcha.setSelected(i.getComp()[5]);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == sett)
        {
            JFrame checkpage = new JFrame();
            checkpage.setSize(200,200);
            checkpage.setVisible(true);



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
        /*
          contratio di maouse entered
         */
    }
}