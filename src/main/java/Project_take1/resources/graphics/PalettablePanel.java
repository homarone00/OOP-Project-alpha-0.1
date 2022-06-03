package Project_take1.resources.graphics;

public interface PalettablePanel {
    void updateColors();
    default Palette getPalette(){
        return Palette.getInstance();
    }
}
