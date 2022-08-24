package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.HPpanels;

import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column.CircularLabel;
import Project_take1.graphics.RoundedJPanel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public abstract class AbstractHealthPanel extends RoundedJPanel implements UpdatablePanel, MouseListener, KeyListener, FocusListener {
    JTextField currentHealthField =new JTextField(2);
    JPanel currentHealthPanel=new JPanel(new BorderLayout()){
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Paint oldPaint = g2D.getPaint();
            Stroke oldStroke = g2D.getStroke();
            try {
                int offset = 2;
                g2D.setPaint(getPalette().border());
                g2D.drawRoundRect(1, 4, getSize().width-2, getSize().height-8, 20, 20);
            } finally {
                g2D.setPaint(oldPaint);
                g2D.setStroke(oldStroke);
            }
        }
    };
    CircularLabel plusLabel;
    CircularLabel minusLabel;

    JLabel addSubLabel;
    JLabel nameLabel;
    JPanel addingPanel=new JPanel(new BorderLayout()){
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Paint oldPaint = g2D.getPaint();
            Stroke oldStroke = g2D.getStroke();
            try {
                int offset = 2;
                g2D.setPaint(getPalette().border());
                g2D.drawRoundRect(1, 4, getSize().width-2, getSize().height-8, 20, 20);
            } finally {
                g2D.setPaint(oldPaint);
                g2D.setStroke(oldStroke);
            }
        }
    };
    JTextField addingField =new JTextField(2);

}
