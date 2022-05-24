package swingtest2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This is the contentPane of our MyJFrame
 *
 * @author omarc
 */
public class MyContentPane extends JPanel implements KeyListener {
    StatPanel strPanel;
    StatPanel dexPanel;
    StatPanel conPanel;
    StatPanel intPanel;
    StatPanel wisPanel;
    StatPanel chaPanel;
    JTextField nameText;

    public MyContentPane() {
        super();
        this.setLayout(new BorderLayout());
        JPanel nameStatAbilityPanel = new JPanel(new BorderLayout(5, 5));
        JPanel namePanel = new JPanel(new BorderLayout()) {
            public void paintComponent(Graphics g) {
                Graphics2D g2D = (Graphics2D) g;
                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color oldColor = g.getColor();
                g.setColor(Color.white);
                super.paintComponent(g);
                g.fillRoundRect(0, 0, getSize().width, getSize().height, 30, 30);
                g.setColor(oldColor);
            }
        };
        JPanel abilityPanel;
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
        namePanel.setBackground(new Color(0xDADADA));
        statGrid.setBackground(namePanel.getBackground());
        nameStatAbilityPanel.setBackground(namePanel.getBackground());
        //icons
        //name field initialization
        nameText = new JTextField("Davide sfaticatino");
        nameText.setBorder(new MyRoundedBorder(namePanel.getBackground(), 0, 2));
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
        JPanel placeHolder = new JPanel();
        placeHolder.setBackground(Color.green);
        add(placeHolder, BorderLayout.CENTER);
        nameStatAbilityPanel.add(namePanel, BorderLayout.NORTH);
        nameStatAbilityPanel.add(new SaveThrowPanel(), BorderLayout.CENTER);
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
}
