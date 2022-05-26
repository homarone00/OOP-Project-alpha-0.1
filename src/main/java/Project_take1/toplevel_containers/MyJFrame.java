package Project_take1.toplevel_containers;

import Project_take1.resources.Palettes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JFrame principale, al cui interno verranno aggiunti tutti i JComponets
 *
 * @author Omar Carpentiero
 */
public class MyJFrame extends JFrame implements ActionListener {
    MyTabbedPane contentPane;
    MyJMenuBar jMenuBar;
    Palettes palettes;
    public MyJFrame() {
        palettes=Palettes.getInstance();
        contentPane=new MyTabbedPane();
        jMenuBar=new MyJMenuBar();
        jMenuBar.menu_2_1.addActionListener(this);
        jMenuBar.menu_2_2.addActionListener(this);
        jMenuBar.menu_2_3.addActionListener(this);
        setContentPane(contentPane);
        setSize(1400, 800);
        setJMenuBar(jMenuBar);
        jMenuBar.setVisible(true);
        //these methods must always be the last
        setResizable(true);
        setVisible(true);

        updateColors();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyJFrame();
    }
    public void updateColors(){
        this.repaint();
        contentPane.updateColors();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.jMenuBar.getMenu_2_1()){
            palettes.setDefaultMode();
            updateColors();
        }
        if(e.getSource()==this.jMenuBar.getMenu_2_2()){
            palettes.setDarkMode();
            updateColors();
        }
        if(e.getSource()==this.jMenuBar.getMenu_2_3()){
            palettes.setPinkMode();
            updateColors();
        }
    }
}
