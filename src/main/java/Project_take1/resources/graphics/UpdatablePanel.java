package Project_take1.resources.graphics;

public interface UpdatablePanel {
    void updateColors();
    void updatePanel();
    default Palette getPalette(){
        return Palette.getInstance();
    }
}
