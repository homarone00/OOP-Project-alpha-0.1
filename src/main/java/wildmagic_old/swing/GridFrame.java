package wildmagic_old.swing;

import wildmagic_old.swing.cells.DoubleCell;
import wildmagic_old.swing.cells.SingleCell;

import javax.swing.*;
import java.awt.*;

public class GridFrame extends JPanel {
    DoubleCell d1;
    SingleCell s1;
    SingleCell s2;
    SingleCell s3;
    SingleCell s4;
    SingleCell s5;
    SingleCell s6;
    SingleCell s7;
    SingleCell s8;

    public GridFrame(){
        super(new BorderLayout());
        d1=new DoubleCell();
        s1=new SingleCell();
        s2=new SingleCell();
        s3=new SingleCell();
        s4=new SingleCell();
        s5=new SingleCell();
        s6=new SingleCell();
        s7=new SingleCell();
        s8=new SingleCell();
        JPanel grid=new JPanel(new GridLayout(8,1));
        grid.add(s1);
        grid.add(s2);
        grid.add(s3);
        grid.add(s4);
        grid.add(s5);
        grid.add(s6);
        grid.add(s7);
        grid.add(s8);
        add(d1,BorderLayout.PAGE_START);
        add(grid,BorderLayout.CENTER);
    }
/*
implementare il metodo slide e il metodo refresh
 */

}
