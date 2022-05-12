package swingtest2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static java.lang.String.valueOf;

/**
 * Square cell that contains an ability <br>
 * Only the value can be edited using the GUI
 *
 * @author Omar Carpentiero
 */
public class AbilityPanel extends JLayeredPane {
    /**
     * static attributes are used to define which type of cell is needed
     */
    JLabel modifier;
    JTextPane value;
    int intValue;
    JLabel label;
    /**
     * The values used for intLabel are defined by the static attributes of the Character class
     */
    int intLabel;

    /**
     * The constructor can only be called with a String parameter, representing the label, and an int, representing
     * the intLabel
     */
    AbilityPanel(int intLabel) {
        super();
        this.modifier = new JLabel();
        this.value = new JTextPane();
        this.label = new JLabel();


        setValue(10);
        setLabel(intLabel);

        setPreferredSize(new Dimension(80,30));
        modifier.setBounds(7,7,getPreferredSize().width-7,getPreferredSize().height-7);
        modifier.setFont(new Font("Comic Sans",Font.BOLD,20));
        modifier.setBackground(new Color(255,255,255));
        modifier.setVerticalTextPosition(JLabel.CENTER);
        modifier.setHorizontalTextPosition(JLabel.CENTER);
        add(modifier,0);

        label.setBounds(7,7,getPreferredSize().width-7,15);
        label.setFont(new Font("Comic Sans", Font.BOLD,5));
        label.setBackground(new Color(192, 0, 0));
        modifier.setVerticalTextPosition(JLabel.TOP);
        modifier.setHorizontalTextPosition(JLabel.CENTER);
        add(label,1);

        value.setBounds(7,getPreferredSize().height-14,getPreferredSize().width-7,14);
        value.setFont(new Font("Comic Sans", Font.BOLD,5));
        value.setBackground(new Color(157, 157, 157));
        add(value,1);

    }

    /**
     * @return an integer representation of the modifier of the cell
     */
    public int getModifier() {
        return Integer.parseInt(this.modifier.getText());
    }

    /**
     * This method is private so that only the setValue method can access it
     *
     * @param modifier is the new modifier
     */
    private void setModifier(int modifier) {
        if (modifier >= 0) {
            this.modifier.setText("+" + valueOf(modifier));
        } else {
            this.modifier.setText(valueOf(modifier));
        }
    }

    /**
     * @return a String representation of the label displayed on the cell
     */
    public String getLabel() {
        switch (this.intLabel) {
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

    /**
     * made private so that only the setIntLabel method can call it
     *
     * @param characteristic only the values defined by the Character class attributes are valid
     */
    private void setLabel(int characteristic) {
        switch (characteristic) {
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
            default:
                throw new IllegalArgumentException("Unexpected value for characteristic : " + characteristic);
        }
    }

    /**
     * @return an int representation of the label displayed on the cell
     */
    public int getIntLabel() {
        return this.intLabel;
    }

    /**
     * the method automatically calls the setLabel method to automatically update the label
     */
    private void setIntLabel(int characteristic) {
        if (characteristic >= MyCharacter.STR && characteristic <= MyCharacter.CHA) {
            this.intLabel = characteristic;
            setLabel(characteristic);
        } else
            throw new IllegalArgumentException("Unexpected value for characteristic: " + characteristic);
    }

    public int getValue(){
        return intValue;
    }

    /**
     * this method automatically updates the modifier, using the setModifier method
     * @param value
     */
    public void setValue(int value){
        if(value>=0){
            this.value.setText(valueOf(value));
            this.intValue=value;
            setModifier(value/2 -5);
        }
        else throw new IllegalArgumentException("value = "+ value+"must be -ge than 0");
    }
}
