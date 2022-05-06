package swingtest2;

import javax.swing.*;

/**
 * JFrame principale, al cui interno verranno aggiunti tutti i JComponets
 * @author Omar Carpentiero
 */
public class MyJFrame extends JFrame {
    public MyJFrame(){
        this.add(new MyContentPane());
    }
}
