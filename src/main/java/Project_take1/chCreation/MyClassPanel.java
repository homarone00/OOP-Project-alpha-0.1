package Project_take1.chCreation;

import Project_take1.MyCharacterCons;

import javax.swing.*;
import java.util.ArrayList;

public interface MyClassPanel extends MyCharacterCons {
    ArrayList<Boolean> getAbilityProf();
    ArrayList<Integer> getPrimaryStat();
    ArrayList<Boolean> getSaveProf();
    JPanel getMainPanel();
}
