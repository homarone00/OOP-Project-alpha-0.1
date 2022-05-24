package swingtest2;

import javax.swing.*;

/**
 * JFrame principale, al cui interno verranno aggiunti tutti i JComponets
 *
 * @author Omar Carpentiero
 */
public class MyJFrame extends JFrame {
    public MyJFrame() {
        setSize(1400, 800);
        setContentPane(new MyContentPane());
        MyJMenuBar jMenuBar = new MyJMenuBar();
        setJMenuBar(jMenuBar);
        jMenuBar.setVisible(true);
        //these methods must always be the last
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyJFrame();
    }
}
