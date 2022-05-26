package Project_take1.bottomlevel_containers;

import Project_take1.resources.Palettes;

import javax.swing.*;
import java.awt.*;

public class CircularLabel extends JLabel {
    boolean pressed;
    boolean entered;
    String value;
    int xOffset;
    int yOffset;

    public CircularLabel(String value, int xOffset, int yOffset) {
        this.value = value;
        this.pressed = false;
        this.entered = false;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        Palettes palettes = Palettes.getInstance();
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = (getSize().width - getSize().height) / 2;
        Color oldColor = g.getColor();
        g.setColor(palettes.button_default());
        if (this.entered) {
            g.setColor(palettes.button_entered());
        }
        if (this.pressed) {
            g.setColor(palettes.button_pressed());
        }
        g.fillOval(x, 1, getSize().height - 3, getSize().height - 3);

        g.setColor(palettes.button_default());
        if (this.entered) {
            g.setColor(palettes.button_entered_border());
        }
        if (this.pressed) {
            g.setColor(palettes.button_pressed());
        }
        g2D.setStroke(new BasicStroke(1));
        g2D.drawOval(x, 1, getSize().height - 3, getSize().height - 3);

        g.setColor(Color.black);
        g.setFont(new Font("Comic Sans", Font.BOLD, 20));
        g.drawString(value, x + getSize().height / 2 + xOffset, getSize().height / 2 + yOffset);
        g.setColor(oldColor);
    }
}
