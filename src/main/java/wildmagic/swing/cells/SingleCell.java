package wildmagic.swing.cells;

import wildmagic.exeptions.CellBooleanHasMultipleChactersException;

import javax.swing.*;
import java.awt.*;

/*
Questa classe rappresenta ciascuna delle righe che contengono le estrazioni della wild magic, nella mainFrame.
E' una griglia con 3 camp
i:
1) un numero    2) un valore vero o falso   3) un nome
 */
public class SingleCell extends AbstractCell {
    public SingleCell() {
        super(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();

        this.number = new JTextField();
        c.weightx=0.1;
        c.fill=GridBagConstraints.HORIZONTAL;
        add(this.number,c);

        this.bool = new JTextField();
        c.weightx=0.1;
        c.fill=GridBagConstraints.HORIZONTAL;
        add(this.bool,c);

        this.name = new JTextField();
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        add(this.name,c);
    }

    public SingleCell(int number, boolean bool, String name) {
        super(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();

        this.number = new JTextField();
        c.weightx=0.1;
        c.fill=GridBagConstraints.HORIZONTAL;
        add(this.number,c);

        this.bool = new JTextField();
        c.weightx=0.1;
        c.fill=GridBagConstraints.HORIZONTAL;
        add(this.bool,c);

        this.name = new JTextField();
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        add(this.name,c);

        setNumber(number);
        setBool(bool);
        setName(name);
    }

    /*
    Il metodo copy copia gli attributi della Cell passata come parametro dentro agli attributi della Cell chiamante
     */
    public void copy(Cell c) throws CellBooleanHasMultipleChactersException {
        setBool(c.getBool());
        setName(c.getName());
        setNumber(c.getNumber());
    }
}
