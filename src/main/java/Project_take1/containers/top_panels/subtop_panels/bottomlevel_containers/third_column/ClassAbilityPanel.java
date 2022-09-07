package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.third_column;

import Project_take1.MyCharacter;
import Project_take1.graphics.RoundedJPanel;

import javax.swing.*;
import java.awt.*;

public class ClassAbilityPanel extends RoundedJPanel {
    boolean infinite;
    MyCharacter myCharacter;

    //zero if infinite
    int maxUses;
    int currentUses;
    JLabel title;
    JLabel source;
    JLabel iconLabel;
    boolean editing=false;
    public ClassAbilityPanel(MyCharacter myCharacter) {
        super();
        this.myCharacter=myCharacter;
        setLayout(new GridBagLayout());
        arcHeight=30;
        arcWidth=30;
        //if true, the ability has infinite uses
        abilityInitFinite();

        this.title=new JLabel("Titolo");
        this.source=new JLabel("Classe: kappa gay");
        this.title.setOpaque(false);
        this.source.setOpaque(false);

        this.title.setHorizontalAlignment(JLabel.LEFT);
        this.source.setHorizontalAlignment(JLabel.LEFT);

        this.title.setFont(new Font("Comic Sans",Font.BOLD,20));
        this.source.setFont(new Font("Comic Sans",Font.BOLD,10));

        iconLabel=new JLabel();
        iconLabel.setBackground(Color.red);

        GridBagConstraints c=new GridBagConstraints();
        Insets i=new Insets(3,10,3,3);
        c.weighty=2;
        c.weightx=10;
        c.gridx=1;
        c.gridy=0;
        c.fill=GridBagConstraints.BOTH;
        add(title,c);

        c.insets=i;
        c.weightx=2;
        c.weighty=3;
        c.gridx=2;
        c.gridheight=2;
        add(iconLabel,c);

        c.insets=new Insets(0,0,0,0);
        c.gridx=1;
        c.gridy=1;
        c.weightx=10;
        c.weighty=2;
        c.gridheight=1;
        add(source,c);

        JPanel fillerPanel=new JPanel();
        fillerPanel.setOpaque(false);
        c.gridx=0;
        c.gridy=0;
        c.gridheight=2;
        c.weighty=2;
        c.weightx=1;
        add(fillerPanel,c);
        setOpaque(false);

    }
    public void abilityInitInfinite(){
        setInfinite(true);
    }
    public void abilityInitFinite(){

        setInfinite(false);
        setMaxUses(5);
        setCurrentUses(4);

    }

    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }

    public boolean isInfinite() {
        return infinite;
    }

    public void setInfinite(boolean infinite) {
        if(infinite){
            setMaxUses(0);
            setCurrentUses(0);
            this.infinite = true;
        }
        else{
            if(getMaxUses()==0){
                setMaxUses(1);
            }
            if(getCurrentUses()==0){
                setCurrentUses(1);
            }
            this.infinite=false;
        }
    }

    public int getMaxUses() {
        return maxUses;
    }

    public void setMaxUses(int maxUses) {
        this.maxUses = maxUses;
    }

    public int getCurrentUses() {
        return currentUses;
    }

    public void setCurrentUses(int currentUses) {
        this.currentUses = currentUses;
    }
}
