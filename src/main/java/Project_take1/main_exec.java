package Project_take1;

import Project_take1.containers.MyCharacterSheet;

import javax.swing.*;
import java.awt.*;

public class main_exec {
    public static void main(String[] args) {
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
        MyCharacter myCharacter = new MyCharacter();
        MyCharacterSheet myCharacterSheet=new MyCharacterSheet(myCharacter);

    }
}
