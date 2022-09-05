package Project_take1.graphics;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Palette extends AbstractPalette{
    private static Palette instance=null;

    private Palette() {
        setDefaultMode();
    }

    public void setDefaultMode() {
        panel = new Color(255, 255, 255);
        background = new Color(222, 222, 222);
        darker_background=new Color(180,180,180);
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
        darker_background = new Color(141, 55, 138);
        text = new Color(0, 0, 0);
        button_default = new Color(158, 87, 162);
        button_entered = new Color(255, 198, 250);
        button_pressed = new Color(145, 48, 142);
        button_entered_border = new Color(157, 103, 156);
        border=new Color(180, 117, 179);
    }

    public void setDarkMode(){
        panel = new Color(54, 54, 54);
        background = new Color(79, 79, 79);
        darker_background = new Color(31, 31, 31);
        text = new Color(206, 206, 206);
        button_default = new Color(87, 87, 87);
        button_entered = new Color(164, 164, 164);
        button_pressed = new Color(77, 77, 77);
        button_entered_border = new Color(182, 182, 182);
        border=new Color(130,130,130);

    }

    public static Palette getInstance() {
        if (instance == null) {
            instance = new Palette();
        }
        return instance;
    }

    public static void setInstance(Palette palette){
        instance= palette;
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

    public Color darker_background(){
        return darker_background;
    }
    public Color button_default() {
        return button_default;
    }

    public Color border() {
        return border;
    }

    public Color background() {
        return background;
    }

    public Color getPressedVersion(Color original){
        int newRed=original.getRed()-30;
        if(newRed<0){
            newRed=0;
        }
        int newGreen=original.getGreen()-30;
        if(newGreen<0){
            newGreen=0;
        }
        int newBlue=original.getBlue()-30;
        if(newBlue<0){
            newBlue=0;
        }
        return new Color(newRed,newGreen,newBlue);
    }
    public Color getUnPressedVersion(Color original){
        int newRed=original.getRed()+30;
        if(newRed>255){
            newRed=255;
        }
        int newGreen=original.getGreen()+30;
        if(newGreen>255){
            newGreen=255;
        }
        int newBlue=original.getBlue()+30;
        if(newBlue>255){
            newBlue=255;
        }
        return new Color(newRed,newGreen,newBlue);
    }
    public void pressBackground(){
        background=getPressedVersion(background());
    }
    public void unPressBackground(){
        background=getUnPressedVersion(background());
    }
    public int getWhiteness(Color color){
        int whiteness=color.getBlue()+color.getGreen()+color.getRed();
        whiteness/=3;
        return whiteness;
    }
    public ImageIcon scale(ImageIcon imageIcon,int width,int height){
        Image oldImage=imageIcon.getImage();
        Image scaledImage=oldImage.getScaledInstance(width,height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
    public ImageIcon getUnpressedSettingsButton(){
        ImageIcon imageIcon;
        if(getWhiteness(text())<40){
            imageIcon=new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/settingsbuttons/settings_button_black_unpressed.png")));
            imageIcon=scale(imageIcon,17,17);
        }
        else{
            imageIcon=new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/settingsbuttons/settings_button_white_unpressed.png")));
            imageIcon=scale(imageIcon,17,17);
        }
        return imageIcon;
    }
    public ImageIcon getPressedSettingsButton(){
        ImageIcon imageIcon;
        if(getWhiteness(text())<40){
            imageIcon=new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/settingsbuttons/settings_button_black_pressed.png")));
            imageIcon=scale(imageIcon,17,17);
        }
        else{
            imageIcon=new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/settingsbuttons/settings_button_white_pressed.png")));
            imageIcon=scale(imageIcon,17,17);
        }
        return imageIcon;
    }

    public Icon getHoveredSettingsButton() {
        ImageIcon imageIcon;
        if(getWhiteness(text())<40){
            imageIcon=new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/settingsbuttons/settings_button_black_hovered.png")));
            imageIcon=scale(imageIcon,17,17);
        }
        else{
            imageIcon=new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/settingsbuttons/settings_button_white_hovered.png")));
            imageIcon=scale(imageIcon,17,17);
        }
        return imageIcon;
    }
    public Icon getSwordIcon(){
        ImageIcon imageIcon=new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/swords/sword_black.png")));
        imageIcon=scale(imageIcon,17,17);
        return imageIcon;
    }
    public Icon getDamageIcon(){
        ImageIcon imageIcon=new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/damage/damage.png")));
        imageIcon=scale(imageIcon,17,17);
        return imageIcon;
    }
}