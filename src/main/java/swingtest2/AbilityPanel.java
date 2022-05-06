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

    JTextField modifier;
    JTextPane value;
    int intValue;
    JLabel label;
    int intLabel;

    /**
     * The constructor can only be called with a String parameter, representing the label, and an int, representing
     * the intLabel
     */
    AbilityPanel(String label){
        super();
        this.modifier=new JTextField();
        this.value=new JTextPane();
        this.label =new JLabel(label);
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
     * @return a String representation of the label displayed on the cell
     */

    public String getLabel(){
        switch(this.intLabel) {
            case MyCharacter.STR:
                return "STRENGTH";
            case MyCharacter.DEX:
                return "DEXTERITY";
            case MyCharacter.CON:
                return "CONSTITUTION";
            case MyCharacter.INT:
                return "INTELLIGENCE";
            case MyCharacter.WIS:
                return "WISDOM";
            case MyCharacter.CHA:
                return "CHARISMA";
            default:
                throw new IllegalStateException("Unexpected value: " + this.intLabel);
        }
    }

    private void setIntLabel(int characteristic){
        if (characteristic>= MyCharacter.STR && characteristic<=MyCharacter.CHA){
            this.intLabel=characteristic;

        }
        else throw new IllegalArgumentException("Unexpected value: " + characteristic);
    }

    /**
     * @return an int representation of the label displayed on the cell
     */
    public int getIntLabel(){
        return this.intLabel;
    }

    /**
     * the method automatically calls the setLabel method to automatically update the label
     * @return
     */
    public int setLabel(int characteristic){
        switch(characteristic) {
            case MyCharacter.STR:
                this.label.setText("STRENGTH");
            case MyCharacter.DEX:
                this.label.setText("DEXTERITY");
            case MyCharacter.CON:
                this.label.setText("CONSTITUTION");
            case MyCharacter.INT:
                this.label.setText("INTELLIGENCE");
            case MyCharacter.WIS:
                this.label.setText("WISDOM");
            case MyCharacter.CHA:
                this.label.setText("CHARISMA");
            default: throw new IllegalArgumentException("Unexpected value: " + characteristic);
        }
    }

}
