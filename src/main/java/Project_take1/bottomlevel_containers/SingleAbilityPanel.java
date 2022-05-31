package Project_take1.bottomlevel_containers;

import Project_take1.MyCharacter;
import Project_take1.resources.graphics.PalettablePanel;
import Project_take1.resources.graphics.Palette;

import javax.swing.*;

public class SingleAbilityPanel extends JPanel implements PalettablePanel, UpdatablePanel {
    int baseStat;
    boolean competence;
    String name;
    public SingleAbilityPanel(MyCharacter myCharacter, String name) {

    }

    @Override
    public void updateColors() {
    }

    @Override
    public Palette getPalette() {
        return Palette.getInstance();
    }
}
