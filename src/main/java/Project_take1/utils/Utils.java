package Project_take1.utils;

import java.io.File;

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
}
