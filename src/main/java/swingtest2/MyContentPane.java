package swingtest2;

import javax.swing.*;
import java.awt.*;

/**
 * This is the contentPane of our MyJFrame
 * @author omarc
 */
public class MyContentPane extends JPanel {
    public MyContentPane(){
        super(new BorderLayout());
        JPanel grid1=new JPanel(new GridLayout(6,1));
        grid1.add(new AbilityPanel(1));
        grid1.add(new AbilityPanel(2));
        grid1.add(new AbilityPanel(3));
        grid1.add(new AbilityPanel(4));
        grid1.add(new AbilityPanel(5));
        grid1.add(new AbilityPanel(6));
        add(grid1,BorderLayout.WEST);

        JPanel panel2=new JPanel();
        panel2.setBackground(Color.green);
        add(panel2,BorderLayout.CENTER);
    }
}
