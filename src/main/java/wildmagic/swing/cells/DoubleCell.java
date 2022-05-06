package wildmagic.swing.cells;

import javax.swing.*;
import java.awt.*;

public class DoubleCell extends AbstractCell {
    JTextField description;

    public DoubleCell() {
        super(new GridLayout(1, 3));
        JPanel t1 = new JPanel(new GridLayout(2, 1));
        this.name=new JTextField();
        this.number=new JTextField();
        this.bool=new JTextField();
        this.description=new JTextField();
        t1.add(this.name);
        t1.add(this.description);
        add(this.number);
        add(this.bool);
        add(t1);
        this.number.setPreferredSize(new Dimension(10, getPreferredSize().height));
        this.bool.setPreferredSize(new Dimension(10, getPreferredSize().height));
        this.name.setPreferredSize(new Dimension(this.name.getPreferredSize().width, 15));
        setPreferredSize(new Dimension(getPreferredSize().width, 40));
    }

    public DoubleCell(int number, boolean bool, String name, String description) {
        super(new GridLayout(1, 3));
        JPanel t1 = new JPanel(new GridLayout(2, 1));
        this.name=new JTextField();
        this.number=new JTextField();
        this.bool=new JTextField();
        this.description=new JTextField();
        t1.add(this.name);
        t1.add(this.description);
        add(this.number);
        add(this.bool);
        add(t1);
        this.number.setPreferredSize(new Dimension(10, getPreferredSize().height));
        this.bool.setPreferredSize(new Dimension(10, getPreferredSize().height));
        this.name.setPreferredSize(new Dimension(this.name.getPreferredSize().width, 15));
        setPreferredSize(new Dimension(getPreferredSize().width, 40));
        setNumber(number);
        setBool(bool);
        setName(name);
        setDescription(description);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    @Override
    public void pullFromDatabase(int number,boolean bool){
        super.pullFromDatabase(number,bool);
        /*
        bisogna pullare anche la descrizione!
         */
    }
}