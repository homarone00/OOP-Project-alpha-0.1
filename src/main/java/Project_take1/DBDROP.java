package Project_take1;

import Project_take1.utils.SavingUtils;

import java.sql.SQLException;

public class DBDROP {
    public static void main(String[] args){
        try {
            SavingUtils.setDB();
            SavingUtils.dropAll();
            SavingUtils.createTables();
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
