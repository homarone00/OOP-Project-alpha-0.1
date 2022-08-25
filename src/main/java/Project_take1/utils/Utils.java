package Project_take1.utils;

import java.io.File;
import java.util.ArrayList;
import Project_take1.MyCharacter;

/**
 * General utils Class
 */
public class Utils {
    /**
     * This method (used principally by DBManager) return the path to the DB Directory and, in case it does not
     * exist, the method create it.
     * @return  A String containing the path to the DBDirectory
     */
    public static String projectDir(){
        String pathName = String.format("%s%s%s", System.getenv("LOCALAPPDATA"), System.getProperty("file.separator"),
                "prjDnD");
        new File(pathName).mkdir();
        return pathName;
    }

    public static String getIndexName(int STAT){
        ArrayList<String> indexAb = new ArrayList<>();
        indexAb.add("strength");
        indexAb.add("dexterity");
        indexAb.add("constitution");
        indexAb.add("intelligence");
        indexAb.add("wisdom");
        indexAb.add("charisma");
        if(STAT < MyCharacter.STRENGTH || STAT > MyCharacter.CHARISMA){
            throw new IllegalArgumentException("STAT must be >= STRENGTH && <= CHARISMA");
        }
        return indexAb.get(STAT - MyCharacter.STRENGTH);
    }

    public static String getSaveIndex(int STAT){
        ArrayList<String> indexAb = new ArrayList<>();
        indexAb.add("strengthProf");
        indexAb.add("dexterityProf");
        indexAb.add("constitutionProf");
        indexAb.add("intelligenceProf");
        indexAb.add("wisdomProf");
        indexAb.add("charismaProf");
        if(STAT < MyCharacter.STRENGTH || STAT > MyCharacter.CHARISMA){
            throw new IllegalArgumentException("STAT must be >= STRENGTH && <= CHARISMA");
        }
        return indexAb.get(STAT - MyCharacter.STRENGTH);
    }

    public static String getProfIndex(int STAT) {
        ArrayList<String> indexAb = new ArrayList<>();
        indexAb.add("acrobaticsProf");
        indexAb.add("animal_handlingProf");
        indexAb.add("arcanaProf");
        indexAb.add("athleticsProf");
        indexAb.add("deceptionProf");
        indexAb.add("historyProf");
        indexAb.add("insightProf");
        indexAb.add("intimidationProf");
        indexAb.add("investigationProf");
        indexAb.add("medicineProf");
        indexAb.add("natureProf");
        indexAb.add("perceptionProf");
        indexAb.add("performanceProf");
        indexAb.add("persuasionProf");
        indexAb.add("religionProf");
        indexAb.add("sleight_of_handProf");
        indexAb.add("stealthProf");
        indexAb.add("survivalProf");
        if (STAT < MyCharacter.ACROBATICS || STAT > MyCharacter.SURVIVAL) {
            throw new IllegalArgumentException("STAT must be >= ACROBATICS && <= SURVIVAL");
        } return indexAb.get(STAT - MyCharacter.ACROBATICS);
    }
    public static String getExpIndex(int STAT) {
        ArrayList<String> indexAb = new ArrayList<>();
        indexAb.add("acrobaticsExp");
        indexAb.add("animal_handlingExp");
        indexAb.add("arcanaExp");
        indexAb.add("athleticsExp");
        indexAb.add("deceptionExp");
        indexAb.add("historyExp");
        indexAb.add("insightExp");
        indexAb.add("intimidationExp");
        indexAb.add("investigationExp");
        indexAb.add("medicineExp");
        indexAb.add("natureExp");
        indexAb.add("perceptionExp");
        indexAb.add("performanceExp");
        indexAb.add("persuasionExp");
        indexAb.add("religionExp");
        indexAb.add("sleight_of_handExp");
        indexAb.add("stealthExp");
        indexAb.add("survivalExp");
        if (STAT < MyCharacter.ACROBATICS || STAT > MyCharacter.SURVIVAL) {
            throw new IllegalArgumentException("STAT must be >= ACROBATICS && <= SURVIVAL");
        }
        return indexAb.get(STAT - MyCharacter.ACROBATICS);
    }
}
