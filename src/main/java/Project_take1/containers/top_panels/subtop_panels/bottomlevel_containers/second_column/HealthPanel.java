package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column.CircularLabel;
import Project_take1.graphics.UpdatablePanel;
import Project_take1.graphics.RoundedJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HealthPanel extends RoundedJPanel implements UpdatablePanel, MouseListener, KeyListener, FocusListener {
    int maxHealth;
    int currentHealth;
    JLabel maxHealthPanel=new JLabel();
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
    boolean temporary;
    MyCharacter myCharacter;

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


    public HealthPanel(boolean temporary,MyCharacter myCharacter){
        super();
        this.setLayout(new BorderLayout());
        this.temporary=temporary;
        this.myCharacter=myCharacter;
        if(!temporary){
            setMaxHealth();
            setCurrentHealth();
        }
        else{
            setMaxHealth(myCharacter.getTemporary_hp());
        }
        setPreferredSize(new Dimension(190,100));
        currentHealthField.setOpaque(false);
        currentHealthField.addKeyListener(this);
        currentHealthField.addFocusListener(this);
        JPanel contentPanel=new JPanel(new BorderLayout(4,4));

        nameLabel=new JLabel();
        if(temporary){
            nameLabel.setText("<html>temp<br>HP</html>");
            nameLabel.setFont(new Font("Comic Sans",Font.BOLD,18));
        }
        else{
            nameLabel.setText(" HP ");
            nameLabel.setFont(new Font("Comic Sans",Font.BOLD,22));
        }
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

        JPanel hpPanel =new JPanel(new BorderLayout());
        currentHealthPanel.setPreferredSize(new Dimension(50,50));
        currentHealthField.setOpaque(false);
        currentHealthPanel.setOpaque(false);
        currentHealthField.setMinimumSize(new Dimension(50,50));

        currentHealthField.setFont(new Font("Comic Sans",Font.BOLD,20));
        maxHealthPanel.setFont(new Font("Comic Sans",Font.BOLD,20));
        maxHealthPanel.setPreferredSize(new Dimension(50,50));
        maxHealthPanel.setHorizontalAlignment(JLabel.CENTER);

        JPanel mainAddingPanel=new JPanel(new BorderLayout());

        addingField.setBorder(null);
        addingField.setOpaque(false);
        addingPanel.setPreferredSize(new Dimension(mainAddingPanel.getPreferredSize().width,25));
        addingField.setPreferredSize(new Dimension(mainAddingPanel.getPreferredSize().width,25));

        addingField.setHorizontalAlignment(JLabel.CENTER);
        addingField.setFont(new Font("Comic Sans", Font.BOLD, 20));

        addingField.addActionListener(actionValue -> {
            String content=addingField.getText();
            if(!content.isEmpty()){
                if(content.startsWith("+")||content.startsWith("-")){
                    int integer;
                    try{
                        integer=Integer.parseInt(content);
                        int a=getCurrentHealth();
                        a+=integer;
                        setCurrentHealth(a);
                        addingField.setText("");
                    } catch (NumberFormatException ignored) {

                    }
                }
            }

        });

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

        //adding phase
        currentHealthPanel.add(currentHealthField,BorderLayout.CENTER);
        currentHealthField.setBorder(null);
        currentHealthField.setHorizontalAlignment(SwingConstants.CENTER);
        hpPanel.add(currentHealthPanel,BorderLayout.CENTER);
        hpPanel.add(maxHealthPanel,BorderLayout.SOUTH);

        buttonGrid.add(plusLabel);
        buttonGrid.add(minusLabel);
        contentPanel.add(hpPanel,BorderLayout.CENTER);
        contentPanel.add(buttonGrid,BorderLayout.EAST);
        contentPanel.setOpaque(false);
        currentHealthPanel.setOpaque(false);
        buttonGrid.setOpaque(false);
        hpPanel.setOpaque(false);
        add(contentPanel,BorderLayout.CENTER);
        add(nameLabel,BorderLayout.WEST);
        add(mainAddingPanel,BorderLayout.EAST);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        maxHealthPanel.setText("/" + String.valueOf(maxHealth));
    }
    public void setMaxHealth() {
        this.maxHealth = myCharacter.getMaxHp();
        maxHealthPanel.setText("/" + String.valueOf(maxHealth));
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        currentHealthField.setText(String.valueOf(currentHealth));
        myCharacter.setCurrentHp(currentHealth);
    }
    public void setCurrentHealth() {
        this.currentHealth = myCharacter.getCurrentHp();
        currentHealthField.setText(String.valueOf(currentHealth));
    }

    @Override

    public void paintComponent(Graphics g){
        this.arcHeight=30;
        this.arcWidth=30;
        super.paintComponent(g);
    }

    @Override
    public void updateColors() {
    }

    @Override
    public void updatePanel() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource().equals(currentHealthField)){
            char c=e.getKeyChar();
            {
                if(!Character.isDigit(c)||c==KeyEvent.VK_DELETE){
                    e.consume();
                }
                if (currentHealthField.getText().length() >= (maxHealthPanel.getText().length()-1) && c != KeyEvent.VK_DELETE &&
                        (currentHealthField.getSelectedText()==null)) {
                    e.consume();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource().equals(currentHealthField)){
            setCurrentHealth(Integer.parseInt(currentHealthField.getText()));
        }

    }
}
