package Project_take1.toplevel_containers;

import Project_take1.MyCharacter;
import Project_take1.resources.graphics.Palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JFrame principale, al cui interno verranno aggiunti tutti i JComponets
 *
 * @author Omar Carpentiero
 */
public class MyCharacterSheet extends JFrame implements ActionListener {
    MyTabbedPane contentPane;
    MyJMenuBar jMenuBar;
    Palette palette;
    MyCharacter myCharacter;

    public MyCharacterSheet(MyCharacter myCharacter) {
        myCharacter.assignSheet(this);
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
}