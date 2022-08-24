package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column;

import Project_take1.MyCharacter;
import Project_take1.graphics.MyRoundedBorder;
import Project_take1.graphics.RoundedJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.String.valueOf;

/**
 * Square cell that contains an ability <br>
 * Only the name can be edited using the GUI
 *
 * @author Omar Carpentiero
 */
public class StatPanel extends RoundedJPanel implements FocusListener,MouseListener {
    /**
     * static attributes are used to define which type of cell is needed
     */
    JLabel modifier = new JLabel();

    public JTextField value;
    int intValue;

    JLabel label;
    /**
     * The values used for intLabel are defined by the static attributes of the Character class
     */
    int intLabel;

    CircularLabel jl_plus;
    CircularLabel jl_minus;
    MyCharacter myCharacter;

    /**
     * The constructor can only be called with a String parameter, representing the label, and an int, representing
     * the intLabel
     */
    public StatPanel(int intLabel, MyCharacter myCharacter) {
        super();
        this.intLabel=intLabel;
        this.myCharacter=myCharacter;
        setLayout(new GridBagLayout());
        this.setOpaque(false);

        this.jl_minus = new CircularLabel("-",-5,+5,20);
        jl_minus.addMouseListener(this);
        jl_minus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.jl_plus = new CircularLabel("+",-7,+7,20);

        jl_plus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jl_plus.addMouseListener(this);
        this.value = new JTextField();
        this.label = new JLabel();


        setValue(myCharacter.getBaseAbility(intLabel).getValue());
        setLabel(intLabel);

        GridBagConstraints c = new GridBagConstraints();
        setPreferredSize(new Dimension(120, 70));
        modifier.setFont(new Font("Comic Sans", Font.BOLD, 35));
        modifier.setHorizontalAlignment(JLabel.CENTER);
        modifier.setOpaque(false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 1;
        c.gridx = 0;
        c.weighty = 10;
        add(modifier, c);
        JPanel topGrid = new JPanel(new GridBagLayout());
        topGrid.setOpaque(false);
        label.setFont(new Font("Comic Sans", Font.BOLD, 12));
        label.setOpaque(false);
        label.setHorizontalAlignment(JLabel.CENTER);
        c.weightx = 10;
        c.gridx = 1;
        c.fill = GridBagConstraints.VERTICAL;
        topGrid.add(label, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.weighty = 2;
        c.gridx = 0;
        add(topGrid, c);

        jl_plus.setFont(new Font("Comic Sans", Font.BOLD, 9));
        jl_minus.setFont(new Font("Comic Sans", Font.BOLD, 9));
        JPanel bottomGrid = new JPanel(new GridLayout(1, 3));
        value.setFont(new Font("Comic Sans", Font.BOLD, 15));
        bottomGrid.add(jl_minus);
        bottomGrid.add(value);
        bottomGrid.add(jl_plus);
        bottomGrid.setOpaque(false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 2;
        c.weighty = 2;
        c.gridx = 0;
        add(bottomGrid, c);
        value.setBorder(new MyRoundedBorder(getPalette().border(), 2, 5));
        value.setOpaque(false);
        value.setHorizontalAlignment(JTextField.CENTER);
        value.addActionListener(actionValue -> {
            try {
                setValue(getValue());
                myCharacter.getBaseAbility(intLabel).setValue(getValue());
                myCharacter.requestUpdate();
                modifier.requestFocus();
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "You can't have negative/string values in D&D!");
            }
        });
        value.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                value.selectAll();
            }
        });
        value.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent event) {
                char c = event.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_DELETE)) {
                    event.consume();
                }
                if (value.getText().length() >= 2 && c != KeyEvent.VK_DELETE && (value.getSelectedText()==null)) {
                    event.consume();
                }
            }
        });
        value.addFocusListener(this);
    }

    /**
     * @return an integer representation of the modifier of the cell
     */
    public int getModifier() {
        return Integer.parseInt(this.modifier.getText());
    }

    /**
     * This method is private so that only the setModifier method can access it
     *
     * @param modifier is the new modifier
     */
    protected void setModifier(int modifier) {
        if (modifier >= 0) {
            this.modifier.setText("+" + modifier);
        } else {
            this.modifier.setText(valueOf(modifier));
        }
    }

    /**
     * @return a String representation of the label displayed on the cell
     */
    public String getLabel() {
        return switch (this.intLabel) {
            case MyCharacter.STRENGTH -> "STRENGTH";
            case MyCharacter.DEXTERITY -> "DEXTERITY";
            case MyCharacter.CONSTITUTION -> "CONSTITUTION";
            case MyCharacter.INTELLIGENCE -> "INTELLIGENCE";
            case MyCharacter.WISDOM -> "WISDOM";
            case MyCharacter.CHARISMA -> "CHARISMA";
            default -> throw new IllegalStateException("Unexpected name: " + this.intLabel);
        };
    }

    /**
     * made private so that only the setIntLabel method can call it
     *
     * @param characteristic only the values defined by the Character class attributes are valid
     */
    private void setLabel(int characteristic) {
        if (characteristic == MyCharacter.STRENGTH) {
            this.label.setText("STRENGTH");
        } else if (characteristic == MyCharacter.DEXTERITY) {
            this.label.setText("DEXTERITY");
        } else if (characteristic == MyCharacter.CONSTITUTION) {
            this.label.setText("CONSTITUTION");
        } else if (characteristic == MyCharacter.INTELLIGENCE) {
            this.label.setText("INTELLIGENCE");
        } else if (characteristic == MyCharacter.WISDOM) {
            this.label.setText("WISDOM");
        } else if (characteristic == MyCharacter.CHARISMA) {
            this.label.setText("CHARISMA");
        } else
            throw new IllegalArgumentException("Unexpected name for characteristic : " + characteristic);
    }

    /**
     * @return an int representation of the label displayed on the cell
     */
    public int getIntLabel() {
        return this.intLabel;
    }

    /**
     * the method automatically calls the setLabel method to automatically updatePanel the label
     */
    private void setIntLabel(int characteristic) {
        if (characteristic >= MyCharacter.STRENGTH && characteristic <= MyCharacter.CHARISMA) {
            this.intLabel = characteristic;
            setLabel(characteristic);
        } else
            throw new IllegalArgumentException("Unexpected name for characteristic: " + characteristic);
    }

    public int getValue() {
        int value;
        try{
            value = Integer.parseInt(this.value.getText());
        } catch (NumberFormatException e) {
            value=intValue;
            return value;
        }
        intValue = value;
        return value;
    }

    /**
     * this method automatically updates the modifier, using the setModifier method
     */
    public void setValue(int value) {
        if (value >= 0) {
            this.value.setText(valueOf(value));
            this.intValue = value;
            if (value < 10 && value % 2 == 1) {
                value--;
            }
            setModifier(value / 2 - 5);
        } else
            throw new IllegalArgumentException("name = " + value + "must be -ge than 0");
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(jl_minus)) {
            int value = getValue();
            if (value != 0) {
                value--;
                setValue(value);
                myCharacter.updateIntStat(intLabel, this.getValue());
                myCharacter.requestUpdate();
            }
        }
        if (e.getSource() == jl_plus) {
            int value = getValue();
            value++;
            setValue(value);
            myCharacter.updateIntStat(intLabel, this.getValue());
            myCharacter.requestUpdate();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(jl_minus)) {
            jl_minus.setPressed(true);
            jl_minus.repaint();
        }
        if (e.getSource() == jl_plus) {
            jl_plus.setPressed(true);
            jl_plus.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource().equals(jl_minus)) {
            jl_minus.setPressed(false);
            jl_minus.repaint();
        }
        if (e.getSource() == jl_plus) {
            jl_plus.setPressed(false);
            jl_plus.repaint();
        }
    }
    @Override
    public void mouseEntered(MouseEvent e){
        if (e.getSource().equals(jl_minus)) {
            jl_minus.setEntered(true);
            jl_minus.repaint();
        }
        if (e.getSource() == jl_plus) {
            jl_plus.setEntered(true);
            jl_plus.repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if (e.getSource().equals(jl_minus)) {
            jl_minus.setEntered(false);
            jl_minus.repaint();
        }
        if (e.getSource() == jl_plus) {
            jl_plus.setEntered(false);
            jl_plus.repaint();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        setValue(getValue());
    }

    /**
     * this method updates the colors that cannot be updated with the repaint() method
     */
    public void updateColors(){
        modifier.setForeground(getPalette().text());
        label.setForeground(getPalette().text());
        value.setBorder(new MyRoundedBorder(getPalette().border(), 2, 5));
        value.setForeground(getPalette().text());
        value.setCaretColor(getPalette().text());
    }

    @Override
    public void updatePanel() {
    }

    @Override
    public void paintComponent(Graphics g) {
        this.arcHeight=30;
        this.arcWidth=30;
        super.paintComponent(g);
    }
}