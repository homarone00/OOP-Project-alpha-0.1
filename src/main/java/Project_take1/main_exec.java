package Project_take1;

import Project_take1.toplevel_containers.MyCharacterSheet;

import javax.swing.*;

public class main_exec {
    public static void main(String[] args) {
        try {
            // Roba che in un qualche modo funziona (non presa da stack overflow)
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception (maybe)
        } catch (ClassNotFoundException e) {
            // handle exception (come on)
        } catch (InstantiationException e) {
            // handle exception (really?)
        } catch (IllegalAccessException e) {
            // handle exception ( :C )
        }
        MyCharacter myCharacter = new MyCharacter();
        MyCharacterSheet myCharacterSheet=new MyCharacterSheet(myCharacter);
    }
}
