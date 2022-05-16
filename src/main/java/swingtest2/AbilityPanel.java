package swingtest2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    JButton jb_plus;
    JButton jb_minus;

    /**
     * The constructor can only be called with a String parameter, representing the label, and an int, representing
     * the intLabel
     */
    AbilityPanel(int intLabel) {
        super();
        this.jb_minus=new JButton("-");
        this.jb_plus=new JButton("+");

        this.modifier = new JLabel();
        this.value = new JTextField(){

        };
        this.label = new JLabel();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(new Color(0x676767)));

        setValue(10);
        setLabel(intLabel);

        setPreferredSize(new Dimension(120,30));
        modifier.setFont(new Font("Comic Sans",Font.BOLD,35));
        modifier.setBackground(new Color(255, 255, 255));
        modifier.setHorizontalAlignment(JLabel.CENTER);
        modifier.setOpaque(true);
        add(modifier,BorderLayout.CENTER);

        JPanel grid1=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        label.setFont(new Font("Comic Sans", Font.BOLD,12));
        label.setBackground(new Color(231, 231, 231));
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);

        c.weightx=10;
        c.gridx=1;
        c.fill=GridBagConstraints.VERTICAL;
        grid1.add(label,c);

        c.weightx=2;
        c.gridx=0;
        c.fill=GridBagConstraints.VERTICAL;
        grid1.add(new JPanel(),c);

        c.weightx=2;
        c.gridx=2;
        c.fill=GridBagConstraints.VERTICAL;
        grid1.add(new JPanel(),c);
        add(grid1,BorderLayout.NORTH);

        jb_plus.setBackground(new Color(194, 194, 194));
        jb_plus.setOpaque(true);
        jb_plus.setFocusable(false);
        jb_plus.setFont(new Font("Comic Sans",Font.BOLD,9));

        jb_minus.setBackground(new Color(194, 194, 194));
        jb_minus.setOpaque(true);
        jb_minus.setFocusable(false);
        jb_minus.setFont(new Font("Comic Sans",Font.BOLD,9));

        jb_minus.addActionListener(minus->{
            int value=getValue();
            if (value !=0) {
                value--;
                setValue(value);
            }
        });

        jb_plus.addActionListener(plus->{
            int value=getValue();
            value++;
            setValue(value);
        });

        JPanel grid3 =new JPanel(new GridLayout(1,3));
        value.setFont(new Font("Comic Sans", Font.BOLD,15));
        value.setBackground(new Color(231, 231, 231));
        grid3.add(jb_minus);
        grid3.add(value);
        grid3.add(jb_plus);
        grid3.setBackground(new Color(255,255,255));
        grid3.setOpaque(true);
        add(grid3,BorderLayout.SOUTH);

        value.addActionListener(actionValue->{
            try{
                setValue(getValue());
            }
            catch (IllegalArgumentException e){
                JOptionPane.showMessageDialog(null,"You can't have negative/string stats in D&D!");
            }
        });

        value.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent event){
                char c= event.getKeyChar();
                if(!(Character.isDigit(c)||c==KeyEvent.VK_DELETE)){
                    event.consume();
                }
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
    protected void setModifier(int modifier) {
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

    public int getValue() {
        int value = Integer.parseInt(this.value.getText());
        intValue = value;
        return value;
    }

    /**
     * this method automatically updates the modifier, using the setModifier method
     * @param value
     */
    public void setValue(int value){
        if(value>=0){
            this.value.setText(valueOf(value));
            this.intValue=value;
            if(value<10&&value%2==1){
                value--;
            }
            setModifier(value/2-5);
        }
        else throw new IllegalArgumentException("value = "+ value +"must be -ge than 0");
    }
}
