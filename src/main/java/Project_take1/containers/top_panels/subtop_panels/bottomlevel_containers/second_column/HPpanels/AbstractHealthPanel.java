package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.HPpanels;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column.CircularLabel;
import Project_take1.graphics.RoundedJPanel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class AbstractHealthPanel extends RoundedJPanel implements UpdatablePanel, MouseListener, KeyListener, FocusListener, HealthPanel {
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
    CircularLabel jl_plus;
    CircularLabel jl_minus;

    int currentHealth;
    JLabel addSubLabel;
    JLabel nameLabel;
    JPanel hpPanel =new JPanel(new BorderLayout());
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
    MyCharacter myCharacter;

    public AbstractHealthPanel(MyCharacter myCharacter) {
        this.setLayout(new BorderLayout());
        this.myCharacter=myCharacter;
        setPreferredSize(new Dimension(190,100));
        currentHealthField.setOpaque(false);
        currentHealthField.addKeyListener(this);
        currentHealthField.addFocusListener(this);
        addingField.addKeyListener(this);
        addingField.addFocusListener(this);
        JPanel contentPanel=new JPanel(new BorderLayout(4,4));

        setOpaque(false);

        nameLabel=new JLabel();
        nameLabel.setPreferredSize(new Dimension(55,this.getPreferredSize().height));
        nameLabel.setOpaque(false);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        currentHealthField.addActionListener(actionValue -> {
            setCurrentHealth(Integer.parseInt(currentHealthField.getText()));
            nameLabel.requestFocus();
        });

        jl_plus =new CircularLabel("+",-7,15,20);
        jl_minus =new CircularLabel("-",-5,13,20);
        jl_plus.setCircleSize(15);
        jl_minus.setCircleSize(15);


        currentHealthPanel.setPreferredSize(new Dimension(50,50));
        currentHealthField.setOpaque(false);
        currentHealthPanel.setOpaque(false);
        currentHealthField.setMinimumSize(new Dimension(50,50));

        JPanel mainAddingPanel=new JPanel(new BorderLayout());

        addingField.setBorder(null);
        addingField.setOpaque(false);
        addingPanel.setPreferredSize(new Dimension(mainAddingPanel.getPreferredSize().width,25));
        addingField.setPreferredSize(new Dimension(mainAddingPanel.getPreferredSize().width,25));

        addingField.setHorizontalAlignment(JLabel.CENTER);
        addingField.setFont(new Font("Comic Sans", Font.BOLD, 20));

        addingPanel.add(addingField,BorderLayout.CENTER);
        addingPanel.setOpaque(false);
        addSubLabel=new JLabel("+ / -");
        addSubLabel.setHorizontalAlignment(JLabel.CENTER);
        addSubLabel.setPreferredSize(new Dimension(mainAddingPanel.getPreferredSize().width,30));

        JPanel addingPlaceHolderPanel_1 =new JPanel();
        addingPlaceHolderPanel_1.setPreferredSize(new Dimension(mainAddingPanel.getPreferredSize().width,25));
        addingPlaceHolderPanel_1.setOpaque(false);

        JPanel addingPlaceHolderPanel_2 =new JPanel();
        addingPlaceHolderPanel_2.setPreferredSize(new Dimension(5,mainAddingPanel.getPreferredSize().height));
        addingPlaceHolderPanel_2.setOpaque(false);

        addSubLabel.setFont(new Font("Comic Sans", Font.BOLD, 18));

        mainAddingPanel.setOpaque(false);
        mainAddingPanel.add(addingPanel,BorderLayout.CENTER);
        mainAddingPanel.add(addSubLabel,BorderLayout.SOUTH);
        mainAddingPanel.add(addingPlaceHolderPanel_1,BorderLayout.NORTH);
        mainAddingPanel.add(addingPlaceHolderPanel_2,BorderLayout.EAST);
        mainAddingPanel.setPreferredSize(new Dimension(60,this.getPreferredSize().height));


        JPanel buttonGrid=new JPanel(new GridLayout(2,1));
        buttonGrid.setPreferredSize(new Dimension(32,this.getPreferredSize().height));
        buttonGrid.setOpaque(false);

        currentHealthPanel.add(currentHealthField,BorderLayout.CENTER);
        currentHealthField.setBorder(null);
        currentHealthField.setHorizontalAlignment(SwingConstants.CENTER);

        buttonGrid.add(jl_plus);
        buttonGrid.add(jl_minus);

        jl_plus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jl_minus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        jl_plus.addMouseListener(this);
        jl_minus.addMouseListener(this);

        contentPanel.add(buttonGrid,BorderLayout.EAST);
        contentPanel.setOpaque(false);
        currentHealthPanel.setOpaque(false);
        buttonGrid.setOpaque(false);
        hpPanel.setOpaque(false);
        hpPanel.setPreferredSize(new Dimension(50,getPreferredSize().height));
        add(contentPanel,BorderLayout.CENTER);
        add(nameLabel,BorderLayout.WEST);
        add(mainAddingPanel,BorderLayout.EAST);

        contentPanel.add(hpPanel,BorderLayout.CENTER);
    }

    @Override
    public void setCurrentHealth(int a) {

    }

    @Override
    public int getCurrentHealth() {
        return 0;
    }

    @Override
    public void updateColors() {
        currentHealthField.setForeground(getPalette().text());
        addingField.setForeground(getPalette().text());
        nameLabel.setForeground(getPalette().text());
        addSubLabel.setForeground(getPalette().text());
        addingField.setCaretColor(getPalette().text());
        currentHealthField.setCaretColor(getPalette().text());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(jl_plus)){
            addValue(1);
        }
        if(e.getSource().equals(jl_minus)){
            addValue(-1);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(jl_minus)) {
            jl_minus.setPressed(true);
            jl_minus.repaint();
        }
        if (e.getSource() == jl_plus) {
            jl_plus.setPressed(true);
            jl_plus.repaint();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource().equals(jl_minus)) {
            jl_minus.setPressed(false);
            jl_minus.repaint();
        }
        if (e.getSource() == jl_plus) {
            jl_plus.setPressed(false);
            jl_plus.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(jl_minus)) {
            jl_minus.setEntered(true);
            jl_minus.repaint();
        }
        if (e.getSource() == jl_plus) {
            jl_plus.setEntered(true);
            jl_plus.repaint();
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(jl_minus)) {
            jl_minus.setEntered(false);
            jl_minus.repaint();
        }
        if (e.getSource() == jl_plus) {
            jl_plus.setEntered(false);
            jl_plus.repaint();
        }

    }

}
