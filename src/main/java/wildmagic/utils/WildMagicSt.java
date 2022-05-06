package wildmagic.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;

public class WildMagicSt {
    //Settaggio del database con relativa creazione della TABLE
    public static void setDB() throws SQLException, IOException{
            DBManager.setConnection(
                    DBManager.JDBC_Driver_SQLite,
                    DBManager.JDBC_URL_SQLite);
            WildMagicSt.createTable(DBManager.getConnection());
    }

    //Creazione della TABLE wildmagic
    public static void createTable(Connection connection) throws SQLException, IOException{
        try (PreparedStatement dropTable = connection.prepareStatement("DROP TABLE IF EXISTS wildmagic")) {
            dropTable.executeUpdate();
        }

        try (PreparedStatement createTable = connection.prepareStatement("CREATE TABLE wildmagic (id INTEGER, tr VARCHAR" +
                "(1), desc VARCHAR(1000), PRIMARY KEY (id, tr))")) {
            createTable.executeUpdate();
        }

        try (PreparedStatement insertWM = connection.prepareStatement("INSERT INTO wildmagic (id, tr, desc) VALUES" +
                " (?, ?, ?)")){

            String pathName=
                    System.getProperty("user.dir") + "/src/main/java/" +WildMagicSt.class.getPackageName().replace(
                    ".","/") +
                    "/wildMagic.csv";
            Path path= Paths.get(pathName);
            try(Scanner scanner=new Scanner(path)){
                while(scanner.hasNextLine()){
                    String[] field=scanner.nextLine().split(";");
                    insertWM.setInt(1, Integer.parseInt(field[0]));
                    insertWM.setString(2, field[1]);
                    insertWM.setString(3, field[2]);
                    insertWM.executeUpdate();
                }
            }
        }
    }

    //Funzione del recupero della descrizione
    public static String description(Connection connection, int n, Boolean v) throws SQLException{
        String c;
        if(v){
            c="V";
        }else{
            c="F";
        }
        String s = String.format("SELECT desc FROM wildmagic WHERE wildmagic.id = %d and wildmagic.tr = '%s'", n, c);
        try(PreparedStatement getWildMagic = connection.prepareStatement(s)) {
            try (ResultSet rs = getWildMagic.executeQuery()) {
                return rs.getString("desc");
            }
        }
    }
}
