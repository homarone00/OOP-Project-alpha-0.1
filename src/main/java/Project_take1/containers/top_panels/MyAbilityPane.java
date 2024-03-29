package Project_take1.containers.top_panels;

import Project_take1.MyCharacter;
import Project_take1.containers.MyTabbedPane;
import Project_take1.containers.top_panels.subtop_panels.SaveThrowPanel;
import Project_take1.containers.top_panels.subtop_panels.SecondColumn;
import Project_take1.containers.top_panels.subtop_panels.SkillPanel;
import Project_take1.containers.top_panels.subtop_panels.ThirdColumn;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.SimpleRoundedPanel;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column.StatPanel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is the first contentPane of our MyJFrame
 *
 * @author omarc
 */
public class MyAbilityPane extends JPanel implements KeyListener, UpdatablePanel {
    MyCharacter myCharacter;
    StatPanel strPanel;
    StatPanel dexPanel;
    StatPanel conPanel;
    StatPanel intPanel;
    StatPanel wisPanel;
    StatPanel chaPanel;
    JTextField nameText;
    JPanel namePanel;
    SecondColumn secondColumn;
    ThirdColumn thirdColumn;
    SkillPanel skillPanel;
    SaveThrowPanel savePanel;
    SimpleRoundedPanel profPanel;

    public MyAbilityPane(MyCharacter myCharacter){
        super();
        this.myCharacter=myCharacter;
        this.setLayout(new BorderLayout(10,10));
        JPanel nameStatAbilityPanel = new JPanel(new BorderLayout(5, 5));
        namePanel = new JPanel(new BorderLayout(10,10)) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2D = (Graphics2D) g;
                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color oldColor = g.getColor();
                g.setColor(getPalette().panel());
                g.fillRoundRect(0, 0, getSize().width -75, getSize().height, 30, 30);
                g.setColor(oldColor);
            }
        };
        this.setOpaque(true);
        this.setBackground(getPalette().background());
        //Left stat grid initialization
        JPanel statGrid = new JPanel(new GridLayout(6, 1, 5, 5));
        strPanel = new StatPanel(MyCharacter.STRENGTH, myCharacter);
        dexPanel = new StatPanel(MyCharacter.DEXTERITY, myCharacter);
        conPanel = new StatPanel(MyCharacter.CONSTITUTION, myCharacter);
        intPanel = new StatPanel(MyCharacter.INTELLIGENCE, myCharacter);
        wisPanel = new StatPanel(MyCharacter.WISDOM, myCharacter);
        chaPanel = new StatPanel(MyCharacter.CHARISMA, myCharacter);
        statGrid.add(strPanel);
        statGrid.add(dexPanel);
        statGrid.add(conPanel);
        statGrid.add(intPanel);
        statGrid.add(wisPanel);
        statGrid.add(chaPanel);
        strPanel.value.addKeyListener(this);
        //background initialization
        namePanel.setOpaque(false);
        statGrid.setOpaque(false);
        nameStatAbilityPanel.setOpaque(false);
        //icons
        //name field initialization
        nameText = new JTextField();
        nameText.setText(myCharacter.getName());
        nameText.setBorder(null);
        nameText.setOpaque(false);
        nameText.setFont(new Font("Comic Sans", Font.BOLD, 30));
        nameText.setHorizontalAlignment(JTextField.CENTER);
        nameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (nameText.getText().length() >= 23) {
                    e.consume();
                }
            }
        });
        nameText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                myCharacter.setName(nameText.getText());
            }
        });
        nameText.addActionListener(actionValue->{
            myCharacter.setName(nameText.getText());
            namePanel.requestFocus();
        });
        nameText.setOpaque(false);
        namePanel.setPreferredSize(new Dimension(getPreferredSize().width, 60));
        namePanel.add(nameText, BorderLayout.CENTER);

        profPanel=new SimpleRoundedPanel("PROF", myCharacter.getStringProfBonus(),30,30);
        profPanel.setPreferredSize(new Dimension(70,this.getHeight()));
        profPanel.getNumberLabel().setFont(new Font("Comic Sans",Font.BOLD,30));
        profPanel.getNumberLabel().setPreferredSize(new Dimension(profPanel.getNumberLabel().getPreferredSize().width,5));
        namePanel.add(profPanel,BorderLayout.EAST);
        //adding all components to the ContentPane
        nameStatAbilityPanel.add(statGrid, BorderLayout.WEST);
        JPanel centralPanel = new JPanel(new BorderLayout(10,10));
        JLabel newPlaceHolder=new JLabel("hello");
        newPlaceHolder.setOpaque(false);
        centralPanel.add(newPlaceHolder,BorderLayout.CENTER);
        secondColumn= new SecondColumn(myCharacter);
        centralPanel.add(secondColumn,BorderLayout.WEST);
        add(centralPanel, BorderLayout.CENTER);
        nameStatAbilityPanel.add(namePanel, BorderLayout.NORTH);
        //Commento separatorio
        skillPanel = new SkillPanel(myCharacter);
        savePanel = new SaveThrowPanel(myCharacter);
        JPanel saveSkillPanel = new JPanel(new GridBagLayout());
        saveSkillPanel.setBackground(getPalette().background());

        thirdColumn=new ThirdColumn(myCharacter);
        centralPanel.add(thirdColumn,BorderLayout.CENTER);
        centralPanel.setOpaque(false);

        JPanel placeholder=new JPanel();
        placeholder.setOpaque(false);
        placeholder.setPreferredSize(new Dimension(450,800));
        centralPanel.add(placeholder,BorderLayout.EAST);

        GridBagConstraints c=new GridBagConstraints();
        saveSkillPanel.setOpaque(false);

        c.gridx=0;
        c.gridy=0;
        c.weightx=5;
        c.weighty=80;
        c.fill=GridBagConstraints.BOTH;
        saveSkillPanel.add(savePanel,c);
        c.gridx=0;
        c.gridy=1;
        c.weighty=250;
        saveSkillPanel.add(skillPanel,c);

        savePanel.setOpaque(false);
        savePanel.setPreferredSize(new Dimension(getPreferredSize().width,300));
        skillPanel.setOpaque(false);
        saveSkillPanel.setPreferredSize(new Dimension(450,800));
        saveSkillPanel.setOpaque(false);
        nameStatAbilityPanel.add(saveSkillPanel, BorderLayout.CENTER);
        nameStatAbilityPanel.setPreferredSize(new Dimension(450,500));
        add(nameStatAbilityPanel, BorderLayout.WEST);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    public void updateColors(){
        strPanel.updateColors();
        dexPanel.updateColors();
        conPanel.updateColors();
        intPanel.updateColors();
        wisPanel.updateColors();
        chaPanel.updateColors();
        secondColumn.updateColors();
        namePanel.repaint();
        nameText.setForeground(getPalette().text());
        skillPanel.updateColors();
        savePanel.updateColors();
        this.setBackground(getPalette().background());
        nameText.setCaretColor(getPalette().text());
        profPanel.updateColors();
        thirdColumn.updateColors();
    }

    @Override
    public void updatePanel() {
        strPanel.updatePanel();
        dexPanel.updatePanel();
        conPanel.updatePanel();
        intPanel.updatePanel();
        wisPanel.updatePanel();
        chaPanel.updatePanel();
        secondColumn.updatePanel();
        skillPanel.updatePanel();
        savePanel.updatePanel();
    }
}