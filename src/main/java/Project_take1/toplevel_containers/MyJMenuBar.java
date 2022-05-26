package Project_take1.toplevel_containers;

import javax.swing.*;
import java.awt.*;

public class MyJMenuBar extends JMenuBar {
    JMenu menu_1=new JMenu("Opzione1");
    JMenu menu_2=new JMenu("Color Mode");
    JMenu menu_3=new JMenu("Opzione3");
    JMenu menu_4=new JMenu("Opzione4");

    //prima colonna
    JMenuItem menu_1_1 =new JMenuItem("1111");
    JMenuItem menu_1_2 =new JMenuItem("2222");

    //seconda colonna
    JMenuItem menu_2_1=new JMenuItem("Light Mode");
    JMenuItem menu_2_2=new JMenuItem("Dark Mode");
    JMenuItem menu_2_3=new JMenuItem("Pink Mode");
    public MyJMenuBar(){


        //aggiungo la prima colonna
        menu_1.add(menu_1_1);
        menu_1.add(menu_1_2);

        //aggiungo la seconda colonna
        menu_2.add(menu_2_1);
        menu_2.add(menu_2_2);
        menu_2.add(menu_2_3);

        menu_1_1.setPreferredSize(new Dimension(menu_1.getPreferredSize().width,menu_1_1.getPreferredSize().height));
        menu_1_2.setPreferredSize(new Dimension(menu_1.getPreferredSize().width,menu_1_2.getPreferredSize().height));
        add(menu_1);
        add(menu_2);
    }

    public JMenu getMenu_1() {
        return menu_1;
    }

    public JMenu getMenu_2() {
        return menu_2;
    }

    public JMenu getMenu_3() {
        return menu_3;
    }

    public JMenu getMenu_4() {
        return menu_4;
    }

    public JMenuItem getMenu_1_1() {
        return menu_1_1;
    }

    public JMenuItem getMenu_1_2() {
        return menu_1_2;
    }

    public JMenuItem getMenu_2_1() {
        return menu_2_1;
    }

    public JMenuItem getMenu_2_2() {
        return menu_2_2;
    }

    public Object getMenu_2_3() {
        return menu_2_3;
    }
}