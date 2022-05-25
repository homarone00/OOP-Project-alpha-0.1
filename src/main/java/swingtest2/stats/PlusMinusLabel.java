package swingtest2.stats;

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
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        int x = (getSize().width - getSize().height) / 2;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color oldColor = g.getColor();
        g.setColor(new Color(232, 232, 232));
        if (this.entered == true) {
            g.setColor(new Color(245, 245, 245));
        }
        if (this.pressed == true) {
            g.setColor(new Color(200, 200, 200));
        }
        g.fillOval(x, 0, getSize().height - 1, getSize().height - 1);
        g.setColor(new Color(232, 232, 232));
        if (this.entered == true) {
            g.setColor(new Color(220, 220, 220));
        }
        if (this.pressed == true) {
            g.setColor(new Color(150, 150, 150));
        }
        g2D.setStroke(new BasicStroke(1));
        g2D.drawOval(x, 0, getSize().height - 1, getSize().height - 1);
        if (plusminus.equals("-")) {
            g.setColor(Color.black);
            g.setFont(new Font("Comic Sans", Font.BOLD, 20));
            g.drawString("-", x + getSize().height / 2 + 2 - 6, getSize().height / 2 + 5);
            g.setColor(oldColor);
        } else {
            g.setColor(Color.black);
            g.setFont(new Font("Comic Sans", Font.BOLD, 20));
            g.drawString("+", x + getSize().height / 2 + 2 - 8, getSize().height / 2 + 7);
            g.setColor(oldColor);
        }
    }
}
