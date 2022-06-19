package Project_take1.bottomlevel_containers;

import Project_take1.resources.graphics.PalettablePanel;
import Project_take1.resources.graphics.Palette;

import javax.swing.*;
import java.awt.*;

public class CompPointLabel extends JLabel implements PalettablePanel {
    boolean comp;

    public CompPointLabel(boolean comp)
    {
        this.comp = comp;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        int r = 4;


        Color oldColor = g.getColor();
        g.setColor(getPalette().text());

        if(comp)
        {
            g2D.fillOval(6, getSize().height / 2 - r, r * 2, r * 2);
        }
        g2D.setStroke(new BasicStroke(2));
        g2D.drawOval(6, getSize().height / 2 - r, r * 2, r * 2);

        g.setColor(oldColor);
        this.setOpaque(false);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(15,15);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(15,15);
    }

    @Override
    public void updateColors() {

    }

    @Override
    public Palette getPalette() {
        return PalettablePanel.super.getPalette();
    }
}
