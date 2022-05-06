package swingtest2;

import javax.swing.*;

/**
 * Square cell that contains an ability <br>
 * Only the value can be edited using the GUI
 * @author Omar Carpentiero
 */
public class AbilityPanel extends JLayeredPane {
    JTextField modifier;
    JTextPane value;
    JLabel name;

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
     *
     * @return String
     */
    public String getName(){
        return this.name.getText();
    }

    public void setName(String name){
        this.name.setText(name);
    }
}
