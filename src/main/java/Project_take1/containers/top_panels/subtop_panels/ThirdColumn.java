package Project_take1.containers.top_panels.subtop_panels;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.third_column.ClassAbilityPanel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;

public class ThirdColumn extends JPanel implements UpdatablePanel {
    MyCharacter myCharacter;
    JLabel title=new JLabel(" Abilities");
    public ThirdColumn(MyCharacter myCharacter) {
        super(new BorderLayout());
        this.myCharacter=myCharacter;
        title.setFont(new Font("Comic Sans",Font.BOLD,25));
        title.setPreferredSize(new Dimension(title.getPreferredSize().width,35));
        JPanel contentPanel=new JPanel(new GridBagLayout());

        GridBagConstraints c=new GridBagConstraints();
        Insets insets=new Insets(3,0,3,0);
        c.insets=insets;
        c.gridy=0;
        c.gridx=0;
        c.weighty=2;
        c.weightx=10;
        c.fill=GridBagConstraints.BOTH;
        contentPanel.add(new ClassAbilityPanel(myCharacter),c);
        c.gridy=1;
        contentPanel.add(new ClassAbilityPanel(myCharacter),c);
        c.gridy=2;
        contentPanel.add(new ClassAbilityPanel(myCharacter),c);
        c.gridy=3;
        contentPanel.add(new ClassAbilityPanel(myCharacter),c);
        c.gridy=4;
        contentPanel.add(new ClassAbilityPanel(myCharacter),c);

        contentPanel.setOpaque(false);

        JPanel placeHolderPanel=new JPanel();
        placeHolderPanel.setOpaque(false);
        c.weighty=50;
        c.gridy=4000000;
        contentPanel.add(placeHolderPanel,c);

        add(title,BorderLayout.NORTH);
        add(contentPanel,BorderLayout.CENTER);



        setOpaque(true);
        setBackground(getPalette().background());
    }

    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }
}
