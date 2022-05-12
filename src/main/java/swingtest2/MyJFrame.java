package swingtest2;

import javax.swing.*;

/**
 * JFrame principale, al cui interno verranno aggiunti tutti i JComponets
 * @author Omar Carpentiero
 */
public class MyJFrame extends JFrame {
    public MyJFrame(){
        setContentPane(new MyContentPane());
        setSize(1400,800);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new MyJFrame();
    }
}
