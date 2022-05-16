package swingtest2;

import javax.swing.*;
import java.awt.*;

public class MyJMenuBar extends JMenuBar {
    public MyJMenuBar(){
        JMenu menu_1=new JMenu("Opzione1");
        JMenu menu_2=new JMenu("Opzione2");
        JMenu menu_3=new JMenu("Opzione3");
        JMenu menu_4=new JMenu("Opzione4");

        JMenuItem menu_1_1 =new JMenuItem("1111");
        JMenuItem menu_1_2 =new JMenuItem("2222");
        menu_1.add(menu_1_1);
        menu_1.add(menu_1_2);
        menu_1_1.setPreferredSize(new Dimension(menu_1.getPreferredSize().width,menu_1_1.getPreferredSize().height));
        menu_1_2.setPreferredSize(new Dimension(menu_1.getPreferredSize().width,menu_1_2.getPreferredSize().height));
        add(menu_1);
        add(menu_2);
    }
}
