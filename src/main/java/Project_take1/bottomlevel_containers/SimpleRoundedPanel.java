package Project_take1.bottomlevel_containers;

import Project_take1.resources.graphics.RoundedJPanel;
import org.intellij.lang.annotations.JdkConstants;

import javax.swing.*;
import java.awt.*;
//this RoundedJPanel only has one big label, for the nomber of the stat, and one small label, to define the name of it
public class SimpleRoundedPanel extends RoundedJPanel {
    JLabel numberLabel;
    JLabel nameLabel;
    public SimpleRoundedPanel(String name, String number,int arcWidth,int arcHeight){
        this.arcWidth=arcWidth;
        this.arcHeight=arcHeight;

        JLabel numberLabel=new JLabel();
        JLabel nameLabel =new JLabel();
        numberLabel.setText(number);
        nameLabel.setText(name);

        JPanel contentPanel=new JPanel(new GridBagLayout());
        contentPanel.setPreferredSize(new Dimension(50,60));
        contentPanel.setOpaque(false);
        GridBagConstraints c=new GridBagConstraints();

        numberLabel.setFont(new Font("Comic Sans",Font.BOLD,30));
        numberLabel.setHorizontalAlignment(JLabel.CENTER);
        c.weighty=10;
        c.weightx=5;
        c.gridy=0;
        c.fill=GridBagConstraints.BOTH;
        numberLabel.setPreferredSize(new Dimension(50,30));
        contentPanel.add(numberLabel,c);

        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,10));
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        c.weighty=1;
        c.gridy=1;
        c.weightx=5;
        contentPanel.add(nameLabel,c);

        add(contentPanel);
    }

    //Constructor for panel with only one label
    public SimpleRoundedPanel(String name,int arcWidth,int arcHeight){
        this.arcWidth=arcWidth;
        this.arcHeight=arcHeight;

        JLabel nameLabel =new JLabel();
        nameLabel.setText(name);

        JPanel contentPanel=new JPanel();
        contentPanel.setPreferredSize(new Dimension(50,60));
        contentPanel.setOpaque(false);

        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,30));
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        nameLabel.setPreferredSize(new Dimension(50,30));
        contentPanel.add(nameLabel);

        add(contentPanel);
    }

    public void setName(String name){
        if(nameLabel!=null){
            this.nameLabel.setText(name);
        }
        else{
            throw new IllegalStateException("The SimpleRoundedPanel with associated number"+numberLabel.getText()+
                    "does not have a name");
        }
    }

    public void setNumber(String number){
        if(nameLabel!=null){
            this.numberLabel.setText(number);
        }
        else{
            throw new IllegalStateException("The SimpleRoundedPanel with associated name"+nameLabel.getText()+
                    "does not have a number");
        }
    }

    public void setNumber(int number){
        if(nameLabel!=null){
            this.numberLabel.setText(Integer.toString(number));
        }
        else{
            throw new IllegalStateException("The SimpleRoundedPanel with associated name"+nameLabel.getText()+
                    "does not have a number");
        }
    }
    @Override
    public void paintComponent(Graphics g){
        setArcs(arcWidth,arcHeight);
        super.paintComponent(g);

    }

    @Override
    public void updateColors() {
    }

    public void setNameAlignement(int horizontalAlignment,int verticalAlignment){
        nameLabel.setHorizontalAlignment(horizontalAlignment);
        nameLabel.setVerticalAlignment(verticalAlignment);
    }
}
