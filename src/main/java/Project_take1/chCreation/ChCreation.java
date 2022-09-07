package Project_take1.chCreation;

import Project_take1.MyCharacter;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ChCreation extends JFrame {
    private JPanel mainPanel;
    private JButton btCreate;
    private JButton btDelete;
    private JList<MyCharacter> chList;
    private JTextArea textArea1;

    public ChCreation() throws HeadlessException{
        super("D&D Manager");
        textArea1.setBackground(this.getBackground());
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.setSize(new Dimension(400,500));
        Vector<MyCharacter> list = new Vector<>();
        MyCharacter ch = new MyCharacter();
        ch.setName("Antonio");
        list.add(ch);
        ch = new MyCharacter();
        ch.setName("Luca");
        list.add(ch);
        ch = new MyCharacter();
        ch.setName("Marcello");
        list.add(ch);
        chList.setListData(list);
        chList.setCellRenderer(new MyCellRender());
        ListSelectionModel listSelectionModel = chList.getSelectionModel();
        listSelectionModel.addListSelectionListener(e -> {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            int firstIndex = e.getFirstIndex();
            Object myObj = chList.getSelectedValue();
            if(myObj instanceof MyCharacter){
                MyCharacter myChar = (MyCharacter)myObj;
                textArea1.setText(myChar.toStringS());
            }
        });
        btCreate.addActionListener(e -> {
            this.dispose();
            SwingUtilities.invokeLater(ChCreat::new);
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChCreation::new);
    }

}
