package Project_take1.containers.top_panels.subtop_panels;

import Project_take1.MyCharacter;
import Project_take1.abilities.Ability;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.third_column.ClassAbilityPanel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ThirdColumn extends JPanel implements UpdatablePanel {
    MyCharacter myCharacter;
    JLabel title=new JLabel(" Abilities");
    ArrayList<ClassAbilityPanel> abilityPanels;
    public ThirdColumn(MyCharacter myCharacter) {
        super(new BorderLayout());
        this.myCharacter=myCharacter;
        title.setFont(new Font("Comic Sans",Font.BOLD,25));
        title.setPreferredSize(new Dimension(title.getPreferredSize().width,35));
        JPanel contentPanel=new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false);
        setOpaque(false);

        abilityPanels=new ArrayList<>();

        GridBagConstraints c=new GridBagConstraints();
        Insets insets=new Insets(3,0,3,0);
        c.insets=insets;
        c.gridy=0;
        c.gridx=0;
        c.weighty=2;
        c.weightx=10;
        c.fill=GridBagConstraints.BOTH;
        ClassAbilityPanel classAbilityPanel1=new ClassAbilityPanel(myCharacter,"Ability 1","source: class");
        ClassAbilityPanel classAbilityPanel2=new ClassAbilityPanel(myCharacter,"Ability 2","source: class");
        ClassAbilityPanel classAbilityPanel3=new ClassAbilityPanel(myCharacter,"Ability 3","source: feat");
        ClassAbilityPanel classAbilityPanel4=new ClassAbilityPanel(myCharacter,"Ability 4","source: class");
        ClassAbilityPanel classAbilityPanel5=new ClassAbilityPanel(myCharacter,"Ability 5","source: inventory");

        abilityPanels.add(classAbilityPanel1);
        abilityPanels.add(classAbilityPanel2);
        abilityPanels.add(classAbilityPanel3);
        abilityPanels.add(classAbilityPanel4);
        abilityPanels.add(classAbilityPanel5);

        contentPanel.add(classAbilityPanel1,c);
        c.gridy=1;
        contentPanel.add(classAbilityPanel2,c);
        c.gridy=2;
        contentPanel.add(classAbilityPanel3,c);
        c.gridy=3;
        contentPanel.add(classAbilityPanel4,c);
        c.gridy=4;
        contentPanel.add(classAbilityPanel5,c);

        contentPanel.setOpaque(false);

        JPanel placeHolderPanel=new JPanel();
        placeHolderPanel.setOpaque(false);
        c.weighty=50;
        c.gridy=4000000;
        contentPanel.add(placeHolderPanel,c);

        add(title,BorderLayout.NORTH);
        add(contentPanel,BorderLayout.CENTER);



        setOpaque(false);
    }

    @Override
    public void updateColors() {
        this.title.setForeground(getPalette().text());
        for(ClassAbilityPanel c:abilityPanels){
            c.updateColors();
        }

    }

    @Override
    public void updatePanel() {

    }
}
