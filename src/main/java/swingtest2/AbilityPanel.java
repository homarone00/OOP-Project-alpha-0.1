package swingtest2;

import javax.swing.*;

/**
 * Square cell that contains an ability <br>
 * Only the value can be edited using the GUI
 * @author Omar Carpentiero
 */
public class AbilityPanel extends JLayeredPane {
    /**
     * static attributes are used to define which type of cell is needed
     */
    static final int STR = 1;
    static final int DEX = 2;
    static final int CON = 3;
    static final int INT = 4;
    static final int WIS = 5;
    static final int CHA = 6;


    JTextField modifier;
    JTextPane value;
    int intValue;
    JLabel name;
    int intName;

    /**
     * The constructor can only be called with a String parameter, which represents the name
     */
    AbilityPanel(String name){
        super();
        this.modifier=new JTextField();
        this.value=new JTextPane();
        this.name=new JLabel(name);
    }

    /**
     * @return an integer representation of the modifier of the cell
     */
    public int getModifier(){
        return Integer.parseInt(this.modifier.getText());
    }

    /**
     * This method is private so that only the setValue method can access it
     * @param modifier is the new modifier
     */
    private void setModifier(int modifier){
        if(modifier>=0){
            this.modifier.setText("+" + String.valueOf(modifier));
        }
        else{
            this.modifier.setText(String.valueOf(modifier));
        }
    }

    /**
     * @return an int representation of the name displayed on the cell
     */
    @Override
    public String getName(){
        switch(intName) {
            case STR:
                return "STRENGTH";
            case DEX:
                return "DEXTERITY";
            case CON:
                return "CONSTITUTION";
            case INT:
                return "INTELLIGENCE";
            case WIS:
                return "WISDOM";
            case CHA:
                return "CHARISMA";
        }
        return "ciao";
    }

}
