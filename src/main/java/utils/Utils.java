package utils;

import java.io.File;

public class Utils {
    public static String wildMagicDir() {
        String path = String.format("%s%s%s", System.getenv("LOCALAPPDATA"), System.getProperty("file.separator")
                , "wildMagic");
        new File(path).mkdirs();
        return path;
    }
}
