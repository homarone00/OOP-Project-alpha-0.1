package Project_take1.containers;

import Project_take1.MyCharacter;
import Project_take1.graphics.Palette;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * JFrame principale, al cui interno verranno aggiunti tutti i JComponets
 *
 * @author Omar Carpentiero
 */
public class MyCharacterSheet extends JFrame implements ActionListener, ChangeListener {
    MyTabbedPane contentPane;
    MyJMenuBar jMenuBar;
    Palette palette;
    MyCharacter myCharacter;

    public MyCharacterSheet(MyCharacter myCharacter) {
        myCharacter.assignSheet(this);
        System.out.println(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode());
        System.out.println(myCharacter.getRace());
        System.out.println(myCharacter.getClassCh());

        palette = Palette.getInstance();
        contentPane = new MyTabbedPane(myCharacter);
        jMenuBar = new MyJMenuBar();
        jMenuBar.menu_2_1.addActionListener(this);
        jMenuBar.menu_2_2.addActionListener(this);
        jMenuBar.menu_2_3.addActionListener(this);
        setContentPane(contentPane);
        setSize(1400, 800);
        setJMenuBar(jMenuBar);
        jMenuBar.setVisible(true);
        //these methods must always be the last
        setMinimumSize(new Dimension(1100, 800));
        setResizable(true);
        setVisible(true);
        ImageIcon imageIcon=new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/icons/icon.png")));
        setIconImage(imageIcon.getImage());
        this.setTitle("RollJ Idea");
        updateColors();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void updateColors() {
        this.repaint();
        contentPane.updateColors();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jMenuBar.getMenu_2_1()) {
            palette.setDefaultMode();
            updateColors();
        }
        if (e.getSource() == this.jMenuBar.getMenu_2_2()) {
            palette.setDarkMode();
            updateColors();
        }
        if (e.getSource() == this.jMenuBar.getMenu_2_3()) {
            palette.setPinkMode();
            updateColors();
        }
    }
    public void updatePanel(){
        contentPane.updatePanel();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource().equals(myCharacter)){
            updatePanel();
        }
    }
}