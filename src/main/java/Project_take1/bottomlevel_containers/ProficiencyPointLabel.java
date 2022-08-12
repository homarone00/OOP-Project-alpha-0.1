package Project_take1.bottomlevel_containers;

import Project_take1.graphics.UpdatablePanel;
import Project_take1.graphics.Palette;

import javax.swing.*;
import java.awt.*;

public class ProficiencyPointLabel extends JLabel implements UpdatablePanel {
    boolean proficiency;
    boolean editing;
    boolean expertise;

    public ProficiencyPointLabel(boolean proficiency)
    {
        this.proficiency = proficiency;
        this.expertise=false;
        this.editing=false;
    }
    public ProficiencyPointLabel(boolean proficiency,boolean expertise)
    {
        this.proficiency = proficiency;
        this.expertise=expertise;
        this.editing=false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        int r = 4;


        Color oldColor = g.getColor();
        g.setColor(getPalette().text());
        if(editing){
            g.setColor(getPalette().button_default());
            g2D.fillOval(5, getSize().height / 2 - r, r * 2, r * 2);
        }
        else if(expertise){
            g2D.fillOval(5, getSize().height / 2 - r, r+2 , r+2);
            g2D.setStroke(new BasicStroke(2));
            int radius=(int)(r * 2.5);
            g2D.drawOval(3, getSize().height / 2 - r-2, radius, radius);
        }
        else if(proficiency)
        {
            g2D.fillOval(5, getSize().height / 2 - r, r * 2, r * 2);
            g2D.setStroke(new BasicStroke(2));
            g2D.drawOval(5, getSize().height / 2 - r, r * 2, r * 2);
        }
        else{
            g2D.setStroke(new BasicStroke(2));
            g2D.drawOval(5, getSize().height / 2 - r, r * 2, r * 2);
        }



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

    public boolean hasComp() {
        return proficiency;
    }

    public void setProficiency(boolean proficiency) {
        this.proficiency = proficiency;
        if(!proficiency){
            expertise=false;
        }
    }

    public boolean isProficiency() {
        return proficiency;
    }

    public boolean isExpertise() {
        return expertise;
    }

    public void setExpertise(boolean expertise) {
        this.expertise = expertise;
        if(expertise){
            this.proficiency=true;
        }
    }

    public void setState(boolean proficiency, boolean expertise){
        if(proficiency&&expertise){
            setExpertise(true);
            setProficiency(true);
        }
        if(proficiency&&!expertise){
            setExpertise(false);
            setProficiency(true);
        }
        if(!proficiency&&!expertise){
            setExpertise(false);
            setProficiency(false);
        }
        if(!proficiency&&expertise){
            throw new IllegalStateException("Can't have expertise but not have proficiency");
        }
    }
    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
        if(isEditing()){
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else{
            this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }

    @Override
    public Palette getPalette() {
        return UpdatablePanel.super.getPalette();
    }
}
