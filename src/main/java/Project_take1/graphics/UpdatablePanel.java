package Project_take1.graphics;

import javax.swing.*;

public interface UpdatablePanel {
    void updateColors();
    void updatePanel();
    default Palette getPalette(){
        return Palette.getInstance();
    }
}
