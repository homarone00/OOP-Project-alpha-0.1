package wildmagic_old.swing.cells;

import wildmagic_old.exeptions.CellBooleanHasMultipleChactersException;

public interface Cell {
    int getNumber();
    void setNumber(int number);
    boolean getBool() throws CellBooleanHasMultipleChactersException;
    void setBool(boolean bool);
    String getName();
    void setName(String name);
    public void pullFromDatabase(int number,boolean bool);
}
