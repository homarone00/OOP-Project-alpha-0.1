package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column;

import Project_take1.graphics.UpdatablePanel;
import Project_take1.graphics.Palette;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.min;


public class CircularLabel extends JLabel implements UpdatablePanel {
    boolean pressed;
    boolean entered;
    String value;
    int xOffset;
    int yOffset;
    int fontSize;
    int size;

    public CircularLabel(String value, int xOffset, int yOffset, int fontSize) {
        setValue(value);
        this.fontSize = fontSize;
        setPressed(false);
        setEntered(false);
        setxOffset(xOffset);
        setyOffset(yOffset);
        size=min(getSize().height,getSize().width);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        size=min(getSize().height,getSize().width);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x;
        int y;
        if(getSize().width>getSize().height){
            x = (getSize().width - getSize().height) / 2;
            y=1;
        }
        else{
            x=1;
            y = -(getSize().width - getSize().height) / 2;
        }
        Color oldColor = g.getColor();
        g.setColor(getPalette().button_default());
        if (isEntered()) {
            g.setColor(getPalette().button_entered());
        }
        if (isPressed()) {
            g.setColor(getPalette().button_pressed());
        }
        g.fillOval(x, y, size - 3, size - 3);

        g.setColor(getPalette().button_default());
        if (isEntered()) {
            g.setColor(getPalette().button_entered_border());
        }
        if (isPressed()) {
            g.setColor(getPalette().button_pressed());
        }

        g2D.setStroke(new BasicStroke(1));
        g2D.drawOval(x, y, size - 3, size - 3);

        g.setColor(getPalette().text());
        g.setFont(new Font("Comic Sans", Font.BOLD, fontSize));
        g.drawString(value, x + size / 2 + xOffset, size / 2 + yOffset);
        g.setColor(oldColor);
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
        repaint();
    }

    public boolean isEntered() {
        return entered;
    }

    public void setEntered(boolean entered) {
        this.entered = entered;
        repaint();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setxOffset(int xOffset) {
        this.xOffset = xOffset;
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

    public Palette getPalette() {
        return Palette.getInstance();
    }

    public int getCircleSize() {
        return size;
    }

    public void setCircleSize(int size) {
        this.size = size;
    }
}
