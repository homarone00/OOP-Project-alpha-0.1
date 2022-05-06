package swingtest.gui;

import javax.swing.*;
import java.awt.*;

/*
La JMenuBar e il JPanel principale sono dichiarati come classi a parte; chiamare il loro costruttore e basta è
sufficiente per creare l'interfaccia completa
 */
public class MainJFrame extends JFrame {
    public MainJFrame(){
        //aggiunta del menu
        MainJMenuBar menuBar=new MainJMenuBar();
        setJMenuBar(menuBar);

        //creazione del pannello principale
        MainJPanel mainPanel=new MainJPanel();
        setContentPane(mainPanel);
        mainPanel.setVisible(true);

        //chiamata ai metodi di JFrame
        setTitle("Test GUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(MainJFrame::new);
    }

}
