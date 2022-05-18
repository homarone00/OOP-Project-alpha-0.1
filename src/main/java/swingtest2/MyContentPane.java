package swingtest2;

import javax.swing.*;
import java.awt.*;

/**
 * This is the contentPane of our MyJFrame
 * @author omarc
 */
public class MyContentPane extends JLayeredPane {
    public MyContentPane(){
        super();
        this.setLayout(new BorderLayout());
        JPanel foreground=new JPanel(new BorderLayout());
        //da modificare il setBounds
        this.setPreferredSize(new Dimension(1400,700));
        foreground.setBounds(0,0,1400,700);
        JPanel background=new JPanel(new BorderLayout());
        background.setBounds(0,0,1400,700);

        JPanel grid1=new JPanel(new GridLayout(6,1,15,15));
        AbilityPanel strPanel=new AbilityPanel(1);
        AbilityPanel dexPanel=new AbilityPanel(2);
        AbilityPanel conPanel=new AbilityPanel(3);
        AbilityPanel intPanel=new AbilityPanel(4);
        AbilityPanel wisPanel=new AbilityPanel(5);
        AbilityPanel chaPanel=new AbilityPanel(6);
        grid1.add(strPanel);
        strPanel.revalidate();
        strPanel.repaint();
        grid1.add(dexPanel);
        grid1.add(conPanel);
        grid1.add(intPanel);
        grid1.add(wisPanel);
        grid1.add(chaPanel);

        foreground.add(grid1,BorderLayout.WEST);
        JPanel panel2=new JPanel();
        panel2.setBackground(Color.green);
        foreground.add(panel2,BorderLayout.CENTER);

        JPanel centerPanel=new JPanel(new BorderLayout());
        JPanel throwPanel=new JPanel(new GridBagLayout());
        JPanel saveThrowPanel=new SaveThrowPanel();
        throwPanel.add(saveThrowPanel);
        centerPanel.add(throwPanel,BorderLayout.WEST);
        foreground.add(centerPanel);

        JPanel roundedRect1=new JPanel();
        roundedRect1.setBorder(new MyRoundedBorder(Color.white,1,30));
        JPanel roundedRect2=new JPanel();
        roundedRect2.setBorder(new MyRoundedBorder(Color.white,1,30));
        JPanel roundedRect3=new JPanel();
        roundedRect3.setBorder(new MyRoundedBorder(Color.white,1,30));
        JPanel roundedRect4=new JPanel();
        roundedRect4.setBorder(new MyRoundedBorder(Color.white,1,30));
        JPanel roundedRect5=new JPanel();
        roundedRect5.setBorder(new MyRoundedBorder(Color.white,1,30));
        JPanel roundedRect6=new JPanel();
        roundedRect6.setBorder(new MyRoundedBorder(Color.white,1,30));
        JPanel backgroundGrid=new JPanel(new GridLayout(6,1,15,15));
        backgroundGrid.add(roundedRect1);
        backgroundGrid.add(roundedRect2);
        backgroundGrid.add(roundedRect3);
        backgroundGrid.add(roundedRect4);
        backgroundGrid.add(roundedRect5);
        backgroundGrid.add(roundedRect6);
        background.add(backgroundGrid,BorderLayout.WEST);

        //add(background,1);
        add(foreground,2);
        this.moveToFront(foreground);
    }
}
