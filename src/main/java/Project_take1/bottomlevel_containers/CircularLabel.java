package Project_take1.bottomlevel_containers;

import Project_take1.resources.graphics.UpdatablePanel;
import Project_take1.resources.graphics.Palette;

import javax.swing.*;
import java.awt.*;


public class CircularLabel extends JLabel implements UpdatablePanel {
    boolean pressed;
    boolean entered;
    String value;
    int xOffset;
    int yOffset;
    int fontSize;

    public CircularLabel(String value, int xOffset, int yOffset, int fontSize) {
        setValue(value);
        this.fontSize = fontSize;
        setPressed(false);
        setEntered(false);
        setxOffset(xOffset);
        setyOffset(yOffset);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = (getSize().width - getSize().height) / 2;
        Color oldColor = g.getColor();
        g.setColor(getPalette().button_default());
        if (isEntered()) {
            g.setColor(getPalette().button_entered());
        }
        if (isPressed()) {
            g.setColor(getPalette().button_pressed());
        }
        g.fillOval(x, 1, getSize().height - 3, getSize().height - 3);

        g.setColor(getPalette().button_default());
        if (isEntered()) {
            g.setColor(getPalette().button_entered_border());
        }
        if (isPressed()) {
            g.setColor(getPalette().button_pressed());
        }

        g2D.setStroke(new BasicStroke(1));
        g2D.drawOval(x, 1, getSize().height - 3, getSize().height - 3);

        g.setColor(getPalette().text());
        g.setFont(new Font("Comic Sans", Font.BOLD, fontSize));
        g.drawString(value, x + getSize().height / 2 + xOffset, getSize().height / 2 + yOffset);
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
}
