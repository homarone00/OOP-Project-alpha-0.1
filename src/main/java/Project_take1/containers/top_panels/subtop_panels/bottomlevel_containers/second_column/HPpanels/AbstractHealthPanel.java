package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column.HPpanels;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column.CircularLabel;
import Project_take1.graphics.RoundedJPanel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
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
    CircularLabel plusLabel;
    CircularLabel minusLabel;

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
        JPanel contentPanel=new JPanel(new BorderLayout(4,4));

        nameLabel=new JLabel();
        nameLabel.setPreferredSize(new Dimension(45,this.getPreferredSize().height));
        nameLabel.setOpaque(false);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        currentHealthField.addActionListener(actionValue -> {
            setCurrentHealth(Integer.parseInt(currentHealthField.getText()));
            nameLabel.requestFocus();
        });

        plusLabel=new CircularLabel("+",-7,15,20);
        minusLabel=new CircularLabel("-",-5,13,20);
        plusLabel.setCircleSize(15);
        minusLabel.setCircleSize(15);


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

        JPanel addingPlaceHolderPanel=new JPanel();
        addingPlaceHolderPanel.setPreferredSize(new Dimension(mainAddingPanel.getPreferredSize().width,25));
        addingPlaceHolderPanel.setOpaque(false);

        addSubLabel.setFont(new Font("Comic Sans", Font.BOLD, 18));

        mainAddingPanel.setOpaque(false);
        mainAddingPanel.add(addingPanel,BorderLayout.CENTER);
        mainAddingPanel.add(addSubLabel,BorderLayout.SOUTH);
        mainAddingPanel.add(addingPlaceHolderPanel,BorderLayout.NORTH);
        mainAddingPanel.setPreferredSize(new Dimension(60,this.getPreferredSize().height));


        JPanel buttonGrid=new JPanel(new GridLayout(2,1));
        buttonGrid.setPreferredSize(new Dimension(32,this.getPreferredSize().height));
        buttonGrid.setOpaque(false);

        currentHealthPanel.add(currentHealthField,BorderLayout.CENTER);
        currentHealthField.setBorder(null);
        currentHealthField.setHorizontalAlignment(SwingConstants.CENTER);

        buttonGrid.add(plusLabel);
        buttonGrid.add(minusLabel);

        contentPanel.add(buttonGrid,BorderLayout.EAST);
        contentPanel.setOpaque(false);
        currentHealthPanel.setOpaque(false);
        buttonGrid.setOpaque(false);
        hpPanel.setOpaque(false);
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
}
