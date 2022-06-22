package Project_take1.toplevel_containers;

import Project_take1.MyCharacter;
import Project_take1.resources.graphics.PalettablePanel;
import Project_take1.resources.graphics.Palette;
import Project_take1.bottomlevel_containers.StatPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This is the first contentPane of our MyJFrame
 *
 * @author omarc
 */
public class MyAbilityPane extends JPanel implements KeyListener, PalettablePanel {
    MyCharacter myCharacter;
    StatPanel strPanel;
    StatPanel dexPanel;
    StatPanel conPanel;
    StatPanel intPanel;
    StatPanel wisPanel;
    StatPanel chaPanel;
    JTextField nameText;
    JPanel namePanel;

    public MyAbilityPane(MyCharacter myCharacter) {
        super();
        this.myCharacter=myCharacter;
        this.setLayout(new BorderLayout(10,10));
        JPanel nameStatAbilityPanel = new JPanel(new BorderLayout(5, 5));
        namePanel = new JPanel(new BorderLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2D = (Graphics2D) g;
                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color oldColor = g.getColor();
                g.setColor(getPalette().panel());
                g.fillRoundRect(0, 0, getSize().width, getSize().height, 30, 30);
                g.setColor(oldColor);
            }
        };
        this.setOpaque(true);
        //Left stat grid initialization
        JPanel statGrid = new JPanel(new GridLayout(6, 1, 5, 5));
        strPanel = new StatPanel(1);
        dexPanel = new StatPanel(2);
        conPanel = new StatPanel(3);
        intPanel = new StatPanel(4);
        wisPanel = new StatPanel(5);
        chaPanel = new StatPanel(6);
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
        nameText = new JTextField("Default Name");
        nameText.setBorder(null);
        nameText.setOpaque(false);
        nameText.setFont(new Font("Comic Sans", Font.BOLD, 20));
        nameText.setHorizontalAlignment(JTextField.CENTER);
        nameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (nameText.getText().length() >= 27) {
                    e.consume();
                }
            }
        });
        nameText.setOpaque(false);
        namePanel.setPreferredSize(new Dimension(getPreferredSize().width, 50));
        namePanel.add(nameText, BorderLayout.CENTER);

        //adding all components to the ContentPane
        add(nameStatAbilityPanel, BorderLayout.WEST);
        nameStatAbilityPanel.add(statGrid, BorderLayout.WEST);
        JPanel placeHolder = new JPanel(new BorderLayout(10,10));
        JPanel newPlaceHolder=new JPanel();
        placeHolder.add(newPlaceHolder,BorderLayout.CENTER);
        placeHolder.add(new SecondColumn(),BorderLayout.WEST);
        add(placeHolder, BorderLayout.CENTER);
        nameStatAbilityPanel.add(namePanel, BorderLayout.NORTH);
        SaveThrowPanel saveThrowPanel=new SaveThrowPanel(myCharacter);
        saveThrowPanel.setBackground(getPalette().panel());
        saveThrowPanel.setForeground(getPalette().text());
        nameStatAbilityPanel.add(saveThrowPanel, BorderLayout.CENTER);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_UP) {
            strPanel.value.requestFocusInWindow();
        }
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
        namePanel.repaint();
        nameText.setForeground(getPalette().text());
        this.setBackground(getPalette().background());

    }
    public Palette getPalette() {
        return Palette.getInstance();
    }
}