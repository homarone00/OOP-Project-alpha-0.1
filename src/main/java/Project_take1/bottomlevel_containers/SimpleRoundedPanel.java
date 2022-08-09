package Project_take1.bottomlevel_containers;

import Project_take1.resources.graphics.PalettablePanel;
import Project_take1.resources.graphics.Palette;
import Project_take1.resources.graphics.RoundedJPanel;
import org.intellij.lang.annotations.JdkConstants;

import javax.swing.*;
import java.awt.*;
//this RoundedJPanel only has one big label, for the nomber of the stat, and one small label, to define the name of it
public class SimpleRoundedPanel extends RoundedJPanel implements PalettablePanel {
    JLabel numberLabel;
    JLabel nameLabel;
    public SimpleRoundedPanel(String name, String number,int arcWidth,int arcHeight){
        super();
        this.arcWidth=arcWidth;
        this.arcHeight=arcHeight;

        numberLabel=new JLabel();
        nameLabel =new JLabel();
        numberLabel.setText(number);
        nameLabel.setText(name);

        JPanel contentPanel=new JPanel(new GridBagLayout());
        this.setPreferredSize(new Dimension(150,60));
        contentPanel.setPreferredSize(new Dimension(this.getPreferredSize().width,this.getPreferredSize().height));
        this.setOpaque(false);
        contentPanel.setOpaque(false);
        GridBagConstraints c=new GridBagConstraints();

        numberLabel.setFont(new Font("Comic Sans",Font.BOLD,30));
        numberLabel.setHorizontalAlignment(JLabel.CENTER);
        c.weighty=8;
        c.weightx=5;
        c.gridy=0;
        c.fill=GridBagConstraints.BOTH;
        numberLabel.setPreferredSize(new Dimension(50,30));
        contentPanel.add(numberLabel,c);

        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,10));
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        c.weighty=2;
        c.gridy=1;
        c.weightx=5;
        contentPanel.add(nameLabel,c);

        add(contentPanel);
    }

    //Constructor for panel with only one label
    public SimpleRoundedPanel(String name,int arcWidth,int arcHeight){
        super();
        this.arcWidth=arcWidth;
        this.arcHeight=arcHeight;

        nameLabel =new JLabel();
        numberLabel=new JLabel();
        nameLabel.setText(name);

        JPanel contentPanel=new JPanel();
        contentPanel.setPreferredSize(new Dimension(150,60));
        contentPanel.setOpaque(false);

        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,30));
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        nameLabel.setPreferredSize(new Dimension(150,45));
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



    public void setNameAlignement(int horizontalAlignment,int verticalAlignment){
        nameLabel.setHorizontalAlignment(horizontalAlignment);
        nameLabel.setVerticalAlignment(verticalAlignment);
    }

    @Override
    public void updateColors() {
        numberLabel.setForeground(getPalette().text());
        nameLabel.setForeground(getPalette().text());
    }

}
