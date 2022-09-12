package Project_take1.containers;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.MySpellPane;
import Project_take1.containers.top_panels.subtop_panels.SpellPanel;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.JTabPanel;
import Project_take1.graphics.UpdatablePanel;
import Project_take1.graphics.Palette;
import Project_take1.containers.top_panels.MyAbilityPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyTabbedPane extends JPanel implements MouseListener, UpdatablePanel {
    MyAbilityPane abilityTab;
    MySpellPane spellTab;
    boolean hasSpells;
    JPanel bioTab;
    JPanel bookTab;
    JPanel tabsPanel;
    JTabPanel tabButton_1;
    JTabPanel tabButton_2;
    JPanel placeHolderPanel;

    public MyTabbedPane(MyCharacter myCharacter){
        setLayout(new BorderLayout());
        abilityTab=new MyAbilityPane(myCharacter);
        add(abilityTab,BorderLayout.CENTER);



        spellTab=new MySpellPane(myCharacter);


        //graphics
        this.setBorder(null);
        setOpaque(true);
        this.setBackground(getPalette().background());

        //tabsPanel
        tabsPanel=new JPanel(new GridBagLayout()){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Color oldColor=g.getColor();
                g.setColor(getPalette().background());
                g.fillRect(0, 0, getSize().width, 10);
                g.setColor(oldColor);
            }

        };
        tabsPanel.setPreferredSize(new Dimension(getPreferredSize().width,45));
        add(tabsPanel,BorderLayout.SOUTH);
        tabsPanel.setBackground(getPalette().darker_background());

        GridBagConstraints c=new GridBagConstraints();

        //tabButton
        tabButton_1=new JTabPanel("Abilities",5,7);
        tabButton_1.setActive(true);
        tabButton_1.setPreferredSize(new Dimension(50,50));
        tabButton_1.setBackground(getPalette().background());
        tabButton_1.setOpaque(false);
        tabButton_1.addMouseListener(this);
        c.weightx=1;
        c.gridx=0;
        c.weighty=1;
        c.fill=GridBagConstraints.BOTH;
        tabButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tabsPanel.add(tabButton_1,c);

        tabButton_2=new JTabPanel("Spells",4,7);
        tabButton_2.setPreferredSize(new Dimension(50,50));
        tabButton_2.setBackground(getPalette().background());
        tabButton_2.setOpaque(false);
        tabButton_2.addMouseListener(this);
        c.weightx=1;
        c.gridx=1;
        c.weighty=1;
        c.fill=GridBagConstraints.BOTH;
        tabButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tabsPanel.add(tabButton_2,c);

        //placeholder
        placeHolderPanel=new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2D = (Graphics2D) g;
                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color oldColor = g.getColor();
                g.setColor(getPalette().background());
                g.fillRect(0, 0, getSize().width, 10);
                g.setColor(oldColor);
            }
        };
        placeHolderPanel.setBackground(getPalette().darker_background());
        c.weightx=10;
        c.gridx=2;
        tabsPanel.add(placeHolderPanel,c);
        //spelltab
        spellTab=new MySpellPane(myCharacter);
        spellTab.setBackground(getPalette().background());

    }

    public void updateColors(){
        abilityTab.updateColors();
        spellTab.setBackground(getPalette().background());
        tabsPanel.setBackground(getPalette().darker_background());
        placeHolderPanel.setBackground(getPalette().darker_background());
        this.setBackground(getPalette().background());
        this.repaint();
    }

    @Override
    public void updatePanel() {
        abilityTab.updatePanel();
    }

    public Palette getPalette() {
        return Palette.getInstance();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==tabButton_1){
            BorderLayout layout=(BorderLayout)this.getLayout();
            tabButton_1.setActive(true);
            tabButton_2.setActive(false);
            Thread exec = new Thread(() -> {
                remove(layout.getLayoutComponent(BorderLayout.CENTER));
                add(abilityTab, BorderLayout.CENTER);
                revalidate();
                updateColors();
            });
            exec.start();


        }
        if(e.getSource()==tabButton_2){
            BorderLayout layout=(BorderLayout)this.getLayout();
            tabButton_1.setActive(false);
            tabButton_2.setActive(true);

            Thread exec = new Thread(() -> {
                remove(layout.getLayoutComponent(BorderLayout.CENTER));
                add(spellTab,BorderLayout.CENTER);
                revalidate();
                updateColors();
            });
            exec.start();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==tabButton_1&&tabButton_1.isActive()){
            getPalette().pressBackground();
            updateColors();
        }
        if(e.getSource()==tabButton_2&&tabButton_2.isActive()){
            getPalette().pressBackground();
            updateColors();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource()==tabButton_1&&tabButton_1.isActive()){
            getPalette().unPressBackground();
            updateColors();
        }
        if(e.getSource()==tabButton_2&&tabButton_2.isActive()){
            getPalette().unPressBackground();
            updateColors();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}