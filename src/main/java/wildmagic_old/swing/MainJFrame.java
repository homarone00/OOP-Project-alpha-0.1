package wildmagic_old.swing;

import wildmagic_old.swing.cells.RandomBracket;
import wildmagic_old.utils.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class MainJFrame extends JFrame {
    public MainJFrame() {
        // Preparo la barra dei menu

        JMenuBar menuBar=new JMenuBar();
        JMenu menuOpzioni=new JMenu("Opzioni");
        JMenuItem menu_Update=new JMenuItem("Update");
        JMenuItem menu_Info=new JMenuItem("Info");

        menuOpzioni.setPreferredSize(new Dimension(60,menuOpzioni.getPreferredSize().height));
        menu_Update.setPreferredSize(new Dimension(60,menu_Update.getPreferredSize().height));
        menu_Info.setPreferredSize(new Dimension(60,menu_Info.getPreferredSize().height));

        JPanel mainPanel=new JPanel(new BorderLayout());
        menuOpzioni.add(menu_Info);
        menuOpzioni.add(menu_Update);
        menuBar.add(menuOpzioni);
        setJMenuBar(menuBar);

        JButton rollButton=new JButton("ROLL");
        JButton clearButton=new JButton("CLEAR");
        JButton fullListButton=new JButton("FULL LIST");

        JPanel leftPanel=new JPanel(new BorderLayout());
        JPanel rightPanel=new JPanel(new GridLayout(3,1));
        JPanel topLeftPanel=new JPanel(new GridLayout(9,1));
        JPanel bottomLeftPanel=new JPanel(new GridLayout(1,3));


        bottomLeftPanel.setPreferredSize(new Dimension(getPreferredSize().width,50));

        GridFrame g1=new GridFrame();
        leftPanel.add(g1,BorderLayout.CENTER);
        bottomLeftPanel.add(rollButton);
        bottomLeftPanel.add(clearButton);
        bottomLeftPanel.add(fullListButton);
        leftPanel.add(bottomLeftPanel,BorderLayout.PAGE_END);
        mainPanel.add(leftPanel,BorderLayout.CENTER);
        mainPanel.add(rightPanel,BorderLayout.LINE_END);

        //parte di debug
        RandomBracket rand100=new RandomBracket(1,5);
        RandomBracket rand2=new RandomBracket(1,2);
        RandomBracket rand20=new RandomBracket(1,20);
        rightPanel.add(rand100);
        rightPanel.add(rand2);
        rightPanel.add(rand20);
        rand20.initRand(rand100,rand20);

        rollButton.addActionListener(e -> {
            rand20.initRand(rand100,rand2);
            System.out.println("Button pressed");
            try{
                System.out.println(WildMagicSt.description(DBManager.getConnection(), (rand20.getValue() - 1)/2, true));
            }catch (SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        //fine parte di debug

        /*Chiamo i metodi di JFrame*/
        setContentPane(mainPanel);
        setTitle("WildMagic");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);

        //Settaggio del DB
        try{
            WildMagicSt.setDB();
            System.out.println("DB fatto/trovato");
        }catch (IOException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainJFrame::new);
    }
}
