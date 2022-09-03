package Project_take1.chCreation;

import Project_take1.MyCharacter;

import javax.swing.*;
import java.awt.*;

public class MyCellRender extends JLabel implements ListCellRenderer<MyCharacter>{
    @Override
    public Component getListCellRendererComponent(JList<? extends MyCharacter> list, MyCharacter value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.getName());
        if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
    }
}
