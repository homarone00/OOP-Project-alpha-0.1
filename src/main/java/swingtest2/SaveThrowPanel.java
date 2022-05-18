package swingtest2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SaveThrowPanel extends JPanel implements MouseListener, WindowListener {
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

    CompetenceFrame fComp;
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

        lbUpdate();

    }

    public void lbUpdate(){
        lbstr.setText(String.valueOf(ch.getModStr()));
        lbdex.setText(String.valueOf(ch.getModDex()));
        lbcon.setText(String.valueOf(ch.getModCon()));
        lbwis.setText(String.valueOf(ch.getModWis()));
        lbing.setText(String.valueOf(ch.getModInt()));
        lbcha.setText(String.valueOf(ch.getModCha()));
        rbstr.setSelected(ch.getStrComp());
        rbdex.setSelected(ch.getDexComp());
        rbcon.setSelected(ch.getConComp());
        rbwis.setSelected(ch.getWisComp());
        rbing.setSelected(ch.getIngComp());
        rbcha.setSelected(ch.getChaComp());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == sett)
        {
            fComp = new CompetenceFrame(ch);
            fComp.addWindowListener(this);
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

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        if(e.getSource() == fComp)
        {
            lbUpdate();
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        if(e.getSource() == fComp)
        {
            lbUpdate();
        }
    }
}