package Project_take1.bottomlevel_containers;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class MyRoundedBorder extends AbstractBorder {
    int lineSize;
    int cornerSize;
    Paint paint;
    Stroke stroke;

    public MyRoundedBorder(Paint paint, int lineSize, int cornerSize) {
        this.paint = paint;
        this.lineSize = lineSize;
        this.cornerSize = cornerSize;
        this.stroke = new BasicStroke(lineSize);
    }

    /**
     * An Insets object is a representation of the borders of a container. It specifies the space that a container
     * / must leave at each of its edges. The space can be a border, a blank space, or a title.
     */
    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        int size = Math.max(lineSize, cornerSize);
        if (insets == null) {
            insets = new Insets(size, size, size, size);
        } else {
            insets.left = size;
            insets.right = size;
            insets.top = size;
            insets.bottom = size;
        }
        return insets;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Paint oldPaint = g2D.getPaint();
        Stroke oldStroke = g2D.getStroke();
        try {
            if (paint != null) {
                g2D.setPaint(paint);
            } else {
                g2D.setPaint(c.getForeground());
            }
            int offset = lineSize / 2;
            g2D.drawRoundRect(x + offset, y + offset, width - lineSize, height - lineSize, cornerSize, cornerSize);
        } finally {
            g2D.setPaint(oldPaint);
            g2D.setStroke(oldStroke);
        }
    }
}