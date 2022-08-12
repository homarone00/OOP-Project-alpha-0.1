package Project_take1.bottomlevel_containers;

import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;

public class JTabPanel extends JPanel implements UpdatablePanel {
    boolean pressed;
    boolean entered;
    boolean active;
    String value;
    int xOffSet;
    int yOffset;

    public JTabPanel(String value,int xOffSet,int yOffset){
        setValue(value);
        setPressed(false);
        setEntered(false);
        setActive(false);
        setxOffSet(xOffSet);
        setyOffset(yOffset);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color oldColor = g.getColor();
        g.setColor(getPalette().panel());
        if(isActive()){
            g.setColor(getPalette().background());
        }
        g.fillRoundRect(5, 5, getSize().width-10, getSize().height-10, 10, 10);
        g.setColor(getPalette().text());
        g.setFont(new Font("Comic Sans", Font.BOLD, 20));
        g.drawString(value,getSize().width/xOffSet,getSize().height/2+yOffset);
        g.setColor(getPalette().background());
        g.fillRect(0, 0, getSize().width, 10);
        g.setColor(oldColor);

    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isEntered() {
        return entered;
    }

    public void setEntered(boolean entered) {
        this.entered = entered;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setxOffSet(int xOffSet) {
        this.xOffSet = xOffSet;
    }

    public void setyOffset(int yOffset) {
        this.yOffset = yOffset;
    }

    @Override
    public void updateColors() {
    }

    @Override
    public void updatePanel() {

    }

}
