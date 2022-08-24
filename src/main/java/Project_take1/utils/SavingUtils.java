package Project_take1.utils;

import Project_take1.MyCharacter;
import Project_take1.utils.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.*;
import java.nio.file.Path;
import java.nio.file.Paths;


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
                        "id INTEGER," +
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
                        "name, lv, maxHp currentHp, tempHp, initiative, profBonus, ac, speed," +
                        "strength, strengthProf," +
                        "dexterity,  dexterityProf, " +
                        "constitution, constitutionProf,  " +
                        "intelligence, intelligenceProf, " +
                        "wisdom, wisdomProf," +
                        "charisma, charismaProf," +
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
                        "survivalProf, survivalExp)" +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                        "?, ?, ?, ?, ?)"
        )) {
            insertCharacter.setString(1, myCharacter.getName());
            insertCharacter.setInt(2,myCharacter.getLvl());
        }
    }
}
