package wildmagic.swing.cells;

import wildmagic.exeptions.CellBooleanHasMultipleChactersException;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractCell extends JPanel implements Cell {
    JTextField number;
    JTextField bool;
    JTextField name;

    public AbstractCell(LayoutManager layout) {
        super(layout);
    }

    public int getNumber() {
        return Integer.parseInt(number.getText());
    }

    public boolean getBool() throws CellBooleanHasMultipleChactersException {
        if (bool.getText().equals("V")) {
            return true;
        }
        if (bool.getText().equals("N")) {
            return false;
        }
        if (bool.getText().isBlank()) {
            return true;
        }
        throw new CellBooleanHasMultipleChactersException("Il campo text della cella" + name.getText() + "numero" + number.getText() + "contiene più di un carattere!");
    }

    @Override
    public String getName() {
        return name.getText();
    }

    @Override
    public void setNumber(int number) {
        this.number.setText(String.valueOf(number));
    }

    @Override
    public void setBool(boolean bool) {
        if (bool == true) {
            this.bool.setText("T");
        }
        if (bool == false) {
            this.bool.setText("N");
        }
    }

    @Override
    public void setName(String name) {
        this.name.setText(name);
    }

    @Override
    public void pullFromDatabase(int number,boolean bool){
        setNumber(number);
        setBool(bool);
        /*
        questo metodo, da implementare, utilizza l'indice i e il boolean bool per prendere dal database i dati
        corrispondenti (name)
        */
    }
}
