package Project_take1;

import Project_take1.containers.MyCharacterSheet;

import javax.swing.*;

public class main_exec {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException |
                 IllegalAccessException ignored) {
        }
        MyCharacter myCharacter = new MyCharacter();
        MyCharacterSheet myCharacterSheet=new MyCharacterSheet(myCharacter);
    }
}
