package Project_take1.resources;

import java.awt.*;

public class Palettes {
    private static Palettes instance=null;
    Color panel;
    Color background;
    Color text;
    Color button_default;
    Color button_pressed;
    Color button_entered;
    Color button_entered_border;
    Color border;

    public Palettes() {
        setDefaultMode();
    }

    public void setDefaultMode() {
        panel = new Color(255, 255, 255);
        background = new Color(222, 222, 222);
        text = new Color(0, 0, 0);
        button_default = new Color(232, 232, 232);
        button_entered = new Color(245, 245, 245);
        button_pressed = new Color(150, 150, 150);
        button_entered_border = new Color(220, 220, 220);
        border=new Color(232,232,232);
    }
    public void setPinkMode(){
        panel = new Color(219, 135, 222);
        background = new Color(171, 85, 168);
        text = new Color(0, 0, 0);
        button_default = new Color(158, 87, 162);
        button_entered = new Color(255, 198, 250);
        button_pressed = new Color(145, 48, 142);
        button_entered_border = new Color(157, 103, 156);
        border=new Color(180, 117, 179);
    }

    public void setDarkMode(){
        panel = new Color(54, 54, 54);
        background = new Color(91, 91, 91);
        text = new Color(206, 206, 206);
        button_default = new Color(87, 87, 87);
        button_entered = new Color(245, 245, 245);
        button_pressed = new Color(150, 150, 150);
        button_entered_border = new Color(220, 220, 220);
        border=new Color(130,130,130);

    }

    public static Palettes getInstance() {
        if (instance == null) {
            instance = new Palettes();
        }
        return instance;
    }
    public Color panel(){
        return this.panel;
    }
    public Color text(){
        return this.text;
    }
    public Color button_entered(){
        return this.button_entered;
    }

    public Color button_pressed() {
        return button_pressed;
    }

    public Color button_entered_border() {
        return button_entered_border;
    }

    public Color button_default() {
        return button_default;
    }

    public Paint border() {
        return border;
    }

    public Color background() {
        return background;
    }
}
