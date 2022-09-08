package Project_take1.chCreation;

import Project_take1.MyCharacter;
import Project_take1.containers.MyCharacterSheet;
import Project_take1.utils.SavingUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Vector;

public class ChCreation extends JFrame {
    private JPanel mainPanel;
    private JButton btCreate;
    private JButton btDelete;
    private JList<MyCharacter> chList;
    private JTextArea textArea1;
    private JButton selectButton;

    public ChCreation() throws HeadlessException{
        super("D&D Manager");
        try {
            SavingUtils.setDB();
            SavingUtils.createTables();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        textArea1.setBackground(this.getBackground());
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        this.setSize(new Dimension(400,500));
        Vector<MyCharacter> list = new Vector<>();
        try{
            for(MyCharacter c: SavingUtils.getAllChar()){
                list.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        selectButton.addActionListener(e -> {
            MyCharacter c = chList.getSelectedValue();
            SwingUtilities.invokeLater(() ->new MyCharacterSheet(c));
            this.dispose();
        });
        btDelete.addActionListener(e -> {
            MyCharacter c = chList.getSelectedValue();
            try{
                SavingUtils.deleteChar(c.getUuid());
                int i = chList.getSelectedIndex();
                list.remove(i);
                chList.clearSelection();
                chList.setListData(list);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChCreation::new);
    }

}
