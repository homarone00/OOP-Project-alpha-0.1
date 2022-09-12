package Project_take1;

import Project_take1.chCreation.ChCreation;
import Project_take1.containers.MyCharacterSheet;

import javax.swing.*;
import java.awt.*;

public class main_exec {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChCreation::new);
    }
}
