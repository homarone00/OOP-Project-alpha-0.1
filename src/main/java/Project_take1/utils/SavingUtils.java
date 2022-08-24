package Project_take1.utils;

import Project_take1.MyCharacter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class SavingUtils {
    public static void setDB() throws SQLException {
        DBManager.setConnection(
                DBManager.JDBC_Driver_SQLite,
                DBManager.JDBC_URL_SQLite);
    }

    //Create the table
    public static void createTable(Connection connection) throws SQLException{
        try(PreparedStatement createTable = connection.prepareStatement(
                "CREATE TABLE if not EXISTS character(" +
                        "id TEXT," +
                        "name VARCHAR(50)," +
                        "lv INTEGER, " +
                        "maxHp integer," +
                        "currentHp integer, " +
                        "tempHp integer, " +
                        "initiative integer, " +
                        "profBonus integer, " +
                        "ac integer, " +
                        "speed integer, " +
                        "strength integer, strengthProf boolean, " +
                        "dexterity integer, dexterityProf boolean, " +
                        "constitution integer, constitutionProf boolean, " +
                        "intelligence integer, intelligenceProf boolean, " +
                        "wisdom integer, wisdomProf boolean, " +
                        "charisma integer, charismaProf boolean, " +
                        "acrobaticsProf BOOLEAN, acrobaticExp boolean, " +
                        "animal_handlingProf Boolean, animal_handlingExp boolean, " +
                        "arcanaProf boolean, arcanaExp boolean, " +
                        "athleticsProf boolean, athleticsExp boolean, " +
                        "deceptionProf boolean, deceptionExp boolean, " +
                        "historyProf boolean, historyExp Boolean, " +
                        "insightProf boolean, insightExp boolean, " +
                        "intimidationProf boolean, intimidation boolean, " +
                        "investigationProf boolean, investigationExp boolean, " +
                        "medicineProf Boolean, medicineExp boolean, " +
                        "natureProf boolean, natureExp Boolean, " +
                        "perceptionProf Boolean, perceptionExp Boolean, " +
                        "performanceProf Boolean, performanceExp Boolean, " +
                        "persuasionProf Boolean, persuasionExp Boolean, " +
                        "religionProf Boolean, religionExp Boolean, " +
                        "sleight_of_handProf Boolean, sleight_of_handExp Boolean, " +
                        "stealthProf Boolean, stealthExp Boolean, " +
                        "survivalProf Boolean, survivalExp Boolean, " +
                        "PRIMARY Key(id))"
        )) {
            createTable.executeUpdate();
        }
    }
    public static void insertChar(MyCharacter myCharacter) throws SQLException{
        try(PreparedStatement insertCharacter = DBManager.getConnection().prepareStatement(
                "INSERT INTO character(" +
                        "name, lv, maxHp, currentHp, tempHp, initiative, profBonus, ac, speed," +
                        "strength, dexterity, constitution,  " +
                        "intelligence, wisdom, charisma," +
                        "strengthProf, dexterityProf, constitutionProf, intelligenceProf, " +
                        "wisdomProf,charismaProf," +
                        "acrobaticsProf,  acrobaticExp," +
                        "animal_handlingProf,  animal_handlingExp," +
                        "arcanaProf,  arcanaExp," +
                        "athleticsProf, athleticsExp," +
                        "deceptionProf,  deceptionExp," +
                        "historyProf,  historyExp," +
                        "insightProf, insightExp," +
                        "intimidationProf,  intimidation," +
                        "investigationProf,  investigationExp, " +
                        "medicineProf, medicineExp," +
                        "natureProf,  natureExp," +
                        "perceptionProf, perceptionExp," +
                        "performanceProf, performanceExp," +
                        "persuasionProf,  persuasionExp," +
                        "religionProf,  religionExp," +
                        "sleight_of_handProf,  sleight_of_handExp," +
                        "stealthProf, stealthExp," +
                        "survivalProf, survivalExp, id)" +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                        "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
        )) {
            insertCharacter.setString(1, myCharacter.getName());
            insertCharacter.setInt(2,myCharacter.getLvl());
            insertCharacter.setInt(3, myCharacter.getMaxHp());
            insertCharacter.setInt(4, myCharacter.getCurrentHp());
            insertCharacter.setInt(5, myCharacter.getTemporary_hp());
            insertCharacter.setInt(6, myCharacter.getInitiative());
            insertCharacter.setInt(7, myCharacter.getProfBonus());
            insertCharacter.setInt(8, myCharacter.getAc());
            insertCharacter.setInt(9, myCharacter.getSpeed());
            insertCharacter.setInt(10, myCharacter.getIntStat(MyCharacter.STRENGTH));
            insertCharacter.setBoolean(11, myCharacter.getProfStat(MyCharacter.STRENGTH));
            insertCharacter.setInt(12, myCharacter.getIntStat(MyCharacter.DEXTERITY));
            insertCharacter.setBoolean(13, myCharacter.getProfStat(MyCharacter.DEXTERITY));
            insertCharacter.setInt(14, myCharacter.getIntStat(MyCharacter.CONSTITUTION));
            insertCharacter.setBoolean(15, myCharacter.getProfStat(MyCharacter.CONSTITUTION));
            insertCharacter.setInt(16, myCharacter.getIntStat(MyCharacter.INTELLIGENCE));
            insertCharacter.setBoolean(17, myCharacter.getProfStat(MyCharacter.INTELLIGENCE));
            insertCharacter.setInt(18, myCharacter.getIntStat(MyCharacter.WISDOM));
            insertCharacter.setBoolean(19, myCharacter.getProfStat(MyCharacter.WISDOM));
            insertCharacter.setInt(20, myCharacter.getIntStat(MyCharacter.CHARISMA));
            insertCharacter.setBoolean(21, myCharacter.getProfStat(MyCharacter.CHARISMA));
            for(int i = MyCharacter.ACROBATICS; i <= MyCharacter.SURVIVAL; i++)
            {
                insertCharacter.setBoolean(22 + (2*(i - MyCharacter.ACROBATICS)), myCharacter.getProficiency(i));
                insertCharacter.setBoolean(23 + (2*(i - MyCharacter.ACROBATICS)), myCharacter.getExpertise(i));
            }
            insertCharacter.setString(58, myCharacter.getUuid().toString());

            insertCharacter.executeUpdate();
        }
    }
    public static void deleteChar(UUID uuid) throws SQLException {
        try(PreparedStatement deleteChar = DBManager.getConnection().prepareStatement("DELETE FROM character WHERE id" +
                " = ?")) {
            deleteChar.setString(1, uuid.toString());
            deleteChar.executeUpdate();
        }
    }

    public static void resetCharTable() throws SQLException {
        try(PreparedStatement deleteChar = DBManager.getConnection().prepareStatement("DELETE FROM character")) {
            deleteChar.executeUpdate();
        }
    }
    public static void dropCharTable() throws SQLException {
        try(PreparedStatement deleteChar = DBManager.getConnection().prepareStatement("DROP TABLE character")) {
            deleteChar.executeUpdate();
        }
    }
    public static ArrayList<MyCharacter> getAllChar() throws SQLException{
        ResultSet rs = DBManager.getConnection().createStatement().executeQuery("SELECT * FROM character");
        while(rs.next());
        return new ArrayList<>();
    }
}
