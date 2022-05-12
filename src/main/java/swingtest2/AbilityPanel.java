package swingtest2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JTextField value;
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
        this.value = new JTextField();
        this.label = new JLabel();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(new Color(0x676767)));

        setValue(10);
        setLabel(intLabel);

        setPreferredSize(new Dimension(120,30));
        modifier.setFont(new Font("Comic Sans",Font.BOLD,35));
        modifier.setBackground(new Color(25,255,255));
        modifier.setHorizontalAlignment(JLabel.CENTER);
        modifier.setOpaque(true);
        add(modifier,BorderLayout.CENTER);

        label.setFont(new Font("Comic Sans", Font.BOLD,12));
        label.setBackground(new Color(192, 0, 0));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label,BorderLayout.NORTH);

        JPanel grid3 =new JPanel(new GridLayout(1,3));
        value.setFont(new Font("Comic Sans", Font.BOLD,15));
        value.setBackground(new Color(157, 157, 157));
        grid3.add(new JPanel());
        grid3.add(value);
        grid3.add(new JPanel());
        add(grid3,BorderLayout.SOUTH);

        value.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setValue(getValue());
            }
        });

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
        if(characteristic==MyCharacter.STR){
            this.label.setText("STRENGTH");
        }
        else if(characteristic==MyCharacter.DEX){
            this.label.setText("DEXTERITY");
        }
        else if(characteristic==MyCharacter.CON){
            this.label.setText("CONSTITUTION");
        }
        else if(characteristic==MyCharacter.INT){
            this.label.setText("INTELLIGENCE");
        }
        else if(characteristic==MyCharacter.WIS){
            this.label.setText("WISDOM");
        }
        else if(characteristic==MyCharacter.CHA){
            this.label.setText("CHARISMA");
        }
        else throw new IllegalArgumentException("Unexpected value for characteristic : " + characteristic);
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
