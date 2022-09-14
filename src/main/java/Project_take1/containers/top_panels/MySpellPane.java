package Project_take1.containers.top_panels;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.SpellPanel;
import Project_take1.graphics.TransparentPanel;
import Project_take1.graphics.UpdatablePanel;
import Project_take1.spells.Spell;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MySpellPane extends JPanel implements UpdatablePanel, KeyListener {
    MyCharacter myCharacter;
    SpellPanel lvl0;
    SpellPanel lvl1;
    SpellPanel lvl2;
    SpellPanel lvl3;
    SpellPanel lvl4;
    SpellPanel lvl5;
    SpellPanel lvl6;
    SpellPanel lvl7;
    SpellPanel lvl8;
    SpellPanel lvl9;
    JPanel bottomPanel=new JPanel();
    JPanel searchFieldBox;
    JTextField searchField=new JTextField();

    JLabel searchLabel=new JLabel("  SEARCH:");

    public MySpellPane(MyCharacter myCharacter) {
        super(new BorderLayout());
        this.myCharacter=myCharacter;
        setBackground(getPalette().background());
        setOpaque(true);

        lvl0=new SpellPanel(0,myCharacter);
        lvl1=new SpellPanel(1,myCharacter);
        lvl2=new SpellPanel(2,myCharacter);
        lvl3=new SpellPanel(3,myCharacter);
        lvl4=new SpellPanel(4,myCharacter);
        lvl5=new SpellPanel(5,myCharacter);
        lvl6=new SpellPanel(6,myCharacter);
        lvl7=new SpellPanel(7,myCharacter);
        lvl8=new SpellPanel(8,myCharacter);
        lvl9=new SpellPanel(9,myCharacter);

        JPanel contentPane=new JPanel(new GridLayout(2,5,5,5));
        searchField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        searchLabel.setFont(new Font("Comic Sans",Font.BOLD,26));
        searchLabel.setPreferredSize(new Dimension(140,60));
        contentPane.add(lvl0);
        contentPane.add(lvl1);
        contentPane.add(lvl2);
        contentPane.add(lvl3);
        contentPane.add(lvl4);
        contentPane.add(lvl5);
        contentPane.add(lvl6);
        contentPane.add(lvl7);
        contentPane.add(lvl8);
        contentPane.add(lvl9);
        contentPane.setOpaque(false);
        add(contentPane,BorderLayout.CENTER);

        searchFieldBox = new JPanel(new BorderLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Color oldColor = g.getColor();
                g.setColor((getPalette().border()));
                g.drawRoundRect(0, 9, searchFieldBox.getSize().width - 1, searchFieldBox.getSize().height - 20, 20, 20);
                g.setColor(oldColor);
            }
        };

        bottomPanel=new JPanel(new BorderLayout(25,0)){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Color oldColor =g.getColor();
                g.setColor(getPalette().panel());
                Graphics2D g2d=(Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.fillRoundRect(3,2,bottomPanel.getSize().width-6,bottomPanel.getSize().height-5,30,30);
                g.setColor(oldColor);
            }
        };

        searchFieldBox.add(searchField,BorderLayout.CENTER);
        searchFieldBox.add(new TransparentPanel(new Dimension(5,5)),BorderLayout.WEST);
        searchFieldBox.add(new TransparentPanel(new Dimension(5,5)),BorderLayout.EAST);

        bottomPanel.setOpaque(false);
        bottomPanel.add(searchLabel,BorderLayout.WEST);
        searchFieldBox.setOpaque(false);
        bottomPanel.add(searchFieldBox,BorderLayout.CENTER);

        searchField.setOpaque(false);
        searchField.setFont(new Font("Comic Sans",Font.BOLD,26));
        JPanel placeHolderPanel= new JPanel();
        placeHolderPanel.setOpaque(false);
        placeHolderPanel.setPreferredSize(new Dimension(500,40));
        bottomPanel.setPreferredSize(new Dimension(1000,60));
        bottomPanel.add(placeHolderPanel,BorderLayout.EAST);

        searchField.addKeyListener(this);

        add(bottomPanel,BorderLayout.SOUTH);
        searchField.addActionListener(actionValue -> {
            if(searchField.getText().equals("nico bico")){
                JFrame NICOBICOFRAME=new JFrame();
                JLabel NICOBICOLABEL=new JLabel("NICOBICO");
                JTextArea NICOBICOTEXTAREA1 =new JTextArea();
                JTextArea NICOBICOTEXTAREA2 =new JTextArea();
                NICOBICOTEXTAREA2.setRows(15);
                NICOBICOTEXTAREA1.setRows(15);
                Thread t=new Thread(()->{
                    NICOBICOFRAME.setSize(new Dimension(1000,800));
                    NICOBICOLABEL.setFont(new Font("Comic Sans",Font.BOLD,150));
                    NICOBICOTEXTAREA1.setBorder(new EmptyBorder(new Insets(0,0,0,0)));
                    NICOBICOTEXTAREA2.setBorder(new EmptyBorder(new Insets(0,0,0,0)));
                    NICOBICOTEXTAREA1.setFont(new Font("Comic Sans",Font.BOLD,15));
                    NICOBICOTEXTAREA2.setFont(new Font("Comic Sans",Font.BOLD,15));
                    NICOBICOFRAME.setLayout(new BorderLayout());
                    NICOBICOFRAME.add(NICOBICOTEXTAREA1,BorderLayout.NORTH);
                    NICOBICOFRAME.add(NICOBICOLABEL,BorderLayout.CENTER);
                    NICOBICOFRAME.add(NICOBICOTEXTAREA2,BorderLayout.SOUTH);
                    NICOBICOFRAME.setTitle("NICOBICONICOBICONICOBICONICOBICO");
                    NICOBICOFRAME.setVisible(true);
                    NICOBICOFRAME.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                });
                t.start();
                Thread t3=new Thread(()->{
                    Random rand=new Random();
                    for(int i=0;;i++){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        int R=rand.nextInt(0,255);
                        int G=rand.nextInt(0,255);
                        int B=rand.nextInt(0,255);
                        NICOBICOLABEL.setForeground(new Color(R,G,B));
                        NICOBICOTEXTAREA1.setForeground(new Color(R,G,B));
                        NICOBICOTEXTAREA2.setForeground(new Color(R,G,B));
                        NICOBICOFRAME.revalidate();
                        if(i==1000){
                            NICOBICOTEXTAREA1.setText("NICO BICO");
                            NICOBICOTEXTAREA2.setText("NICO BICO");
                            i=0;
                        }
                        else if(i%50==0){
                            NICOBICOTEXTAREA1.append("\n");
                            NICOBICOTEXTAREA2.append("\n");
                        }
                        else{
                            NICOBICOTEXTAREA1.append(" NICO BICO");
                            NICOBICOTEXTAREA2.setText(NICOBICOTEXTAREA1.getText()+" NICO BICO");
                        }
                        R=rand.nextInt(0,255);
                        G=rand.nextInt(0,255);
                        B=rand.nextInt(0,255);
                        NICOBICOTEXTAREA1.setBackground(new Color(R,G,B));
                        NICOBICOTEXTAREA2.setBackground(new Color(R,B,G));
                        NICOBICOLABEL.setBackground(new Color(G,B,R));
                    }

                });
                t3.start();
            }
            Thread t2=new Thread(()->{
                Spell spell=new Spell(searchField.getText());
                myCharacter.getKnownSpells().insert(spell);
                lvl0.addSpell(spell);
                lvl1.addSpell(spell);
                lvl2.addSpell(spell);
                lvl3.addSpell(spell);
                lvl4.addSpell(spell);
                lvl5.addSpell(spell);
                lvl6.addSpell(spell);
                lvl7.addSpell(spell);
                lvl8.addSpell(spell);
                lvl9.addSpell(spell);
            });
            t2.start();

        });
    }

    @Override
    public void updateColors() {
        setBackground(getPalette().background());
        searchField.setForeground(getPalette().text());
        searchLabel.setForeground(getPalette().text());
        searchField.setCaretColor(getPalette().text());
        lvl0.updateColors();
        lvl1.updateColors();
        lvl2.updateColors();
        lvl3.updateColors();
        lvl4.updateColors();
        lvl5.updateColors();
        lvl6.updateColors();
        lvl7.updateColors();
        lvl8.updateColors();
        lvl9.updateColors();

    }

    @Override
    public void updatePanel() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource().equals(searchField)){
            if(Character.isAlphabetic(e.getKeyChar())||Character.isDigit(e.getKeyChar())){
                searchField.setForeground(getPalette().text());
            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource().equals(searchField)){
            if(e.getKeyCode()==KeyEvent.VK_DELETE||e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                searchField.setForeground(getPalette().text());
            }

        }
    }
}
