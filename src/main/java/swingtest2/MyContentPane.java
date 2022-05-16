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
        AbilityPanel strPanel=new AbilityPanel(1);
        AbilityPanel dexPanel=new AbilityPanel(2);
        AbilityPanel conPanel=new AbilityPanel(3);
        AbilityPanel intPanel=new AbilityPanel(4);
        AbilityPanel wisPanel=new AbilityPanel(5);
        AbilityPanel chaPanel=new AbilityPanel(6);
        grid1.add(strPanel);
        grid1.add(dexPanel);
        grid1.add(conPanel);
        grid1.add(intPanel);
        grid1.add(wisPanel);
        grid1.add(chaPanel);

        add(grid1,BorderLayout.WEST);
        JPanel panel2=new JPanel();
        panel2.setBackground(Color.green);
        add(panel2,BorderLayout.CENTER);

    }
}
