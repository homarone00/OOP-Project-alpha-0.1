package swingtest.gui;

import javax.swing.*;
import java.awt.*;

public class SingleCell extends JPanel {
    JTextPane number;
    JTextPane bool;
    JTextField name;

    public SingleCell(){
        super(new GridBagLayout());

        //preparo i constraints per il primo elemento
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.ipadx=70;
        c.gridy=0;
        c.ipady=70;
        c.anchor=GridBagConstraints.LINE_START;

        number=new JTextPane(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(Color.lightGray);
                g.fillOval(5,getPreferredSize().height/2,number.getWidth()-20,number.getWidth()-20);

            }
        };
        number.setOpaque(false);

        //debug
        number.setText("1");
        //fine debug
        add(number,c);

        c.gridx=1;
        c.gridy=0;
        bool=new JTextPane(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(new Color(222, 222, 222));
                g.fillOval(10,getPreferredSize().height/2,getPreferredSize().height,number.getPreferredSize().height);
            }
        };
        bool.setOpaque(false);

        //debug
        bool.setText("1");
        //fine debug
        add(bool,c);

        c.gridx=2;
        c.gridy=0;
        c.gridwidth=4;
        c.weightx=3;
        name=new JTextField(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(Color.black);
                double arcSize=(double)name.getPreferredSize().height*(4/5);
                g.fillRoundRect(0,0,name.getPreferredSize().width,name.getPreferredSize().height,(int)arcSize,
                        (int)arcSize);
            }
        };
        name.setOpaque(false);
        name.setEditable(true);
        //debug
        name.setText("1");
        //fine debug
        add(name,c);


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //creazione dello strato di base
        g.setColor(Color.white);
        g.fillRoundRect(0,number.getPreferredSize().height/2,200,getPreferredSize().height,30,30);
        setOpaque(false);
    }


}
