package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column.CircularLabel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WeaponsPanel extends JPanel implements UpdatablePanel, MouseListener {
    MyCharacter myCharacter;
    JLabel title;
    JLabel settingsButton;
    double length=4;
    JPanel mainGrid;
    CircularLabel plusLabel=new CircularLabel("+",-5,9,15);
    public WeaponsPanel(MyCharacter myCharacter){
        super();
        this.myCharacter=myCharacter;
        JPanel topGrid=new JPanel(new BorderLayout());
        topGrid.setOpaque(false);
        length =4;
        title =new JLabel("Weapons");
        title.setFont(new Font("Comic Sans",Font.BOLD,15));
        title.setOpaque(false);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setPreferredSize(new Dimension(20,30));

        mainGrid=new JPanel(new GridBagLayout());
        mainGrid.setOpaque(false);

        plusLabel.setPreferredSize(new Dimension(20,20));
        plusLabel.addMouseListener(this);

        setLayout(new BorderLayout());
        GridBagConstraints c=new GridBagConstraints();
        Insets insets=new Insets(2,0,2,0);

        c.gridy=0;
        c.fill=GridBagConstraints.BOTH;
        c.weightx=10;
        c.weighty=10;
        c.insets=insets;
        mainGrid.add(new SingleWeaponPanel(myCharacter,true),c);
        c.gridy=1;
        mainGrid.add(new SingleWeaponPanel(myCharacter,true),c);
        c.gridy=2;
        mainGrid.add(new SingleWeaponPanel(myCharacter,true),c);
        c.gridy=3;
        mainGrid.add(new SingleWeaponPanel(myCharacter,true),c);

        settingsButton=new JLabel(getPalette().getUnpressedSettingsButton());
        topGrid.add(settingsButton,BorderLayout.EAST);
        topGrid.add(title,BorderLayout.CENTER);
        topGrid.add(plusLabel,BorderLayout.WEST);

        add(mainGrid,BorderLayout.CENTER);
        add(topGrid,BorderLayout.NORTH);
        setOpaque(false);
    }
    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(plusLabel)&&length<6){
            GridBagConstraints c=new GridBagConstraints();
            c.insets= new Insets(2,0,2,0);
            c.gridy=(int)length;
            c.gridx=0;
            length++;
            c.weighty=10;
            c.weightx=10;
            c.fill=GridBagConstraints.BOTH;
            mainGrid.add(new SingleWeaponPanel(myCharacter,true),c);
            revalidate();
        }
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
}
