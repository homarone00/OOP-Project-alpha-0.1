package swingtest2.stats;

import swingtest2.resources.Palettes;

import javax.swing.*;
import java.awt.*;

public class PlusMinusLabel extends JLabel {
    boolean pressed;
    boolean entered;
    String plusminus;

    public PlusMinusLabel(String plusminus) {
        this.plusminus = plusminus;
        this.pressed = false;
        this.entered = false;
    }

    public void paintComponent(Graphics g) {
        Palettes palettes=Palettes.getInstance();
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        int x = (getSize().width - getSize().height) / 2;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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
        g2D.drawOval(x, 0, getSize().height - 1, getSize().height - 1);
        g.setColor(Color.black);
        g.setFont(new Font("Comic Sans", Font.BOLD, 20));
        if (plusminus.equals("-")) {
            g.drawString("-", x + getSize().height / 2 + 2 - 6, getSize().height / 2 + 5);
        } else {
            g.drawString("+", x + getSize().height / 2 + 2 - 8, getSize().height / 2 + 7);
        }
        g.setColor(oldColor);
    }
}
