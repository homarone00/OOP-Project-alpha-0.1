package swingtest.gui;

import javax.swing.*;
import java.awt.*;

public class MainJPanel extends JPanel {
    public MainJPanel(){
       super(new GridLayout(2,1));
       add(new SingleCell());
       add(new SingleCell());
       setBackground(new Color(236, 236, 236));
    }
}
