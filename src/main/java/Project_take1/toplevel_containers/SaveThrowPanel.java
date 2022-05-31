package Project_take1.toplevel_containers;

import Project_take1.MyCharacter;
import Project_take1.bottomlevel_containers.UpdatablePanel;
import Project_take1.resources.graphics.PalettablePanel;
import Project_take1.resources.graphics.Palette;

import javax.swing.*;
import java.awt.*;

public class SaveThrowPanel extends JPanel implements PalettablePanel, UpdatablePanel {
    MyCharacter myCharacter;
    public SaveThrowPanel(MyCharacter myCharacter) {
        super();
        this.myCharacter=myCharacter;
        setPreferredSize(new Dimension(200,getPreferredSize().height));


    }

    @Override
    public void updateColors() {
    }

    @Override
    public Palette getPalette() {
        return Palette.getInstance();
    }
}
