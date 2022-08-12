package Project_take1.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * this class allows you to automatically implement the getPalette() default method forces the user to write the
 * updateColors() method (via the UpdatablePanel interface).
 * the default color is the panel color found in the Palette class;
 * You can change that by calling the setAsCustomPainted(Color c) method in the subclass constructor :) .
 */
public abstract class RoundedJPanel extends JPanel implements UpdatablePanel {
    protected int arcWidth;
    protected int arcHeight;
    protected boolean customPainted=false;
    protected boolean paneled=false;
    protected Color customColor;
    public RoundedJPanel(){
        super(new FlowLayout());
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color oldColor = g.getColor();
        if(!customPainted||paneled){
            g.setColor(getPalette().panel());
        }
        if(customPainted&&!paneled){
            g.setColor(customColor);
        }
        super.paintComponent(g);
        g.fillRoundRect(0, 0, getSize().width, getSize().height, this.arcWidth, this.arcHeight);
        g.setColor(oldColor);


    }
    public void setAsCustomPainted(Color customColor){
        this.customColor=customColor;
        setPaneled(false);
        customPainted=true;
        repaint();
    }
    protected void setAsDefaultPainted(){
        this.customPainted=false;
    }

    protected void setArcs(int arcWidth, int arcHeight){
        this.arcWidth=arcWidth;
        this.arcHeight=arcHeight;
    }

    public boolean isPaneled() {
        return paneled;
    }

    public void setPaneled(boolean paneled) {
        this.paneled = paneled;
        repaint();
    }
}
