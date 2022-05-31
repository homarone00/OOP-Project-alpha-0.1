package Project_take1.resources.graphics;

public interface PalettablePanel {
    default Palette getPalette(){
        return Palette.getInstance();
    }
}
