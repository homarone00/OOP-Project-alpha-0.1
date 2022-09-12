package Project_take1.utils;

import Project_take1.MyCharacter;
import Project_take1.inventory.*;
import Project_take1.spells.Spell;

import java.sql.*;
import java.util.*;

public class SavingUtils {
    public static void setDB() throws SQLException {
        DBManager.setConnection(DBManager.JDBC_Driver_SQLite, DBManager.JDBC_URL_SQLite);
    }

    //Create the table
    public static void createTables() throws SQLException {
        Connection connection = DBManager.getConnection();
        try (PreparedStatement createTable = connection.prepareStatement("CREATE TABLE if not EXISTS character(" +
                "id TEXT," + "name VARCHAR(50), race TEXT, class TEXT," + "lv INTEGER, " + "maxHp integer," +
                "currentHp " +
                "integer, " + "tempHp integer, " + "initiative integer, " + "profBonus integer, " + "ac integer, " + "speed integer, " + "strength integer, strengthProf boolean, " + "dexterity integer, dexterityProf boolean, " + "constitution integer, constitutionProf boolean, " + "intelligence integer, intelligenceProf boolean, " + "wisdom integer, wisdomProf boolean, " + "charisma integer, charismaProf boolean, " + "acrobaticsProf BOOLEAN, acrobaticsExp boolean, " + "animal_handlingProf Boolean, animal_handlingExp boolean, " + "arcanaProf boolean, arcanaExp boolean, " + "athleticsProf boolean, athleticsExp boolean, " + "deceptionProf boolean, deceptionExp boolean, " + "historyProf boolean, historyExp Boolean, " + "insightProf boolean, insightExp boolean, " + "intimidationProf boolean, intimidationExp boolean, " + "investigationProf boolean, investigationExp boolean, " + "medicineProf Boolean, medicineExp boolean, " + "natureProf boolean, natureExp Boolean, " + "perceptionProf Boolean, perceptionExp Boolean, " + "performanceProf Boolean, performanceExp Boolean, " + "persuasionProf Boolean, persuasionExp Boolean, " + "religionProf Boolean, religionExp Boolean, " + "sleight_of_handProf Boolean, sleight_of_handExp Boolean, " + "stealthProf Boolean, stealthExp Boolean, " + "survivalProf Boolean, survivalExp Boolean, " + "PRIMARY Key(id))")) {
            createTable.executeUpdate();
        }
        try (PreparedStatement createTable =
                     connection.prepareStatement("CREATE TABLE if not EXISTS spells(id TEXT, idc TEXT," +
                             "name VARCHAR(50), descr TEXT, highLv TEXT, range TEXT, components TEXT, material TEXT, " + "ritual BOOLEAN, " + "duration TEXT, " + "concentration BOOLEAN, " +
                             "dc integer, level integer, " + "attType TEXT, school TEXT, " + "PRIMARY Key(id, idc))")) {
            createTable.executeUpdate();
        }
        try (PreparedStatement createTable =
                     connection.prepareStatement("CREATE TABLE if not EXISTS items(id TEXT, idc TEXT," +
                             "name TEXT, quantity INTEGER, weight REAL, descr TEXT, category TEXT, cp INTEGER, sp " +
                             "INTEGER, ep INTEGER, gp INTEGER, pp INTEGER, wp_cat TEXT, wp_range TEXT, cat_range " +
                             "TEXT, prop TEXT, dmg_key TEXT, dmg TEXT, ca INTEGER, dex_b BOOLEAN, min_str INTEGER, " +
                             "max_bonus Integer, stealth_dis BOOLEAN, PRIMARY Key(id, idc))")) {
            createTable.executeUpdate();
        }

    }

    /**
     * Character Code
     */
    public static void insertChar(MyCharacter myCharacter) throws SQLException {
        try (PreparedStatement insertCharacter =
                     DBManager.getConnection().prepareStatement("INSERT INTO character(" + "name, lv, maxHp, " +
                             "currentHp, tempHp, initiative, profBonus, ac, speed," + "strength, dexterity, " +
                             "constitution,  " + "intelligence, wisdom, charisma," + "strengthProf, dexterityProf, " +
                             "constitutionProf, intelligenceProf, " + "wisdomProf,charismaProf," + "acrobaticsProf,  " +
                             "acrobaticsExp," + "animal_handlingProf,  animal_handlingExp," + "arcanaProf,  " +
                             "arcanaExp," + "athleticsProf, athleticsExp," + "deceptionProf,  deceptionExp," +
                             "historyProf,  historyExp," + "insightProf, insightExp," + "intimidationProf,  " +
                             "intimidationExp," + "investigationProf,  investigationExp, " + "medicineProf, " +
                             "medicineExp," + "natureProf,  natureExp," + "perceptionProf, perceptionExp," +
                             "performanceProf, performanceExp," + "persuasionProf,  persuasionExp," + "religionProf, " +
                             " religionExp," + "sleight_of_handProf,  sleight_of_handExp," + "stealthProf, " +
                             "stealthExp," + "survivalProf, survivalExp, id, race, class)" + "values (?, ?, ?, ?, ?, " +
                             "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " + "?, ?, ?, ?, " +
                             "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            insertCharacter.setString(1, myCharacter.getName());
            insertCharacter.setInt(2, myCharacter.getLvl());
            insertCharacter.setInt(3, myCharacter.getMaxHp());
            insertCharacter.setInt(4, myCharacter.getCurrentHp());
            insertCharacter.setInt(5, myCharacter.getTemporary_hp());
            insertCharacter.setInt(6, myCharacter.getInitiative());
            insertCharacter.setInt(7, myCharacter.getProfBonus());
            insertCharacter.setInt(8, myCharacter.getAc());
            insertCharacter.setInt(9, myCharacter.getSpeed());
            for (int i = MyCharacter.STRENGTH; i <= MyCharacter.CHARISMA; i++) {
                insertCharacter.setInt(10 + i - MyCharacter.STRENGTH, myCharacter.getIntStat(i));
            }
            for (int i = MyCharacter.STRENGTH; i <= MyCharacter.CHARISMA; i++) {
                insertCharacter.setBoolean(16 + i - MyCharacter.STRENGTH, myCharacter.getProfStat(i));
            }
            for (int i = MyCharacter.ACROBATICS; i <= MyCharacter.SURVIVAL; i++) {
                insertCharacter.setBoolean(22 + (2 * (i - MyCharacter.ACROBATICS)), myCharacter.getProficiency(i));
                insertCharacter.setBoolean(23 + (2 * (i - MyCharacter.ACROBATICS)), myCharacter.getExpertise(i));
            }
            insertCharacter.setString(58, myCharacter.getUuid().toString());
            insertCharacter.setString(59, myCharacter.getRace());
            insertCharacter.setString(60, myCharacter.getClassCh());
            insertCharacter.executeUpdate();
        }
    }

    public static void deleteChar(UUID uuid) {
        try (PreparedStatement deleteChar = DBManager.getConnection().prepareStatement("DELETE FROM items WHERE id" +
                " = ?")) {
            deleteChar.setString(1, uuid.toString());
            deleteChar.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (PreparedStatement deleteChar = DBManager.getConnection().prepareStatement("DELETE FROM spells WHERE id" +
                " = ?")) {
            deleteChar.setString(1, uuid.toString());
            deleteChar.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (PreparedStatement deleteChar = DBManager.getConnection().prepareStatement("DELETE FROM character WHERE id" + " = ?")) {
            deleteChar.setString(1, uuid.toString());
            deleteChar.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void resetCharTable() throws SQLException {
        try (PreparedStatement deleteChar = DBManager.getConnection().prepareStatement("DELETE FROM character")) {
            deleteChar.executeUpdate();
        }
    }

    public static void dropCharTable() throws SQLException {
        try (PreparedStatement deleteChar =
                     DBManager.getConnection().prepareStatement("DROP TABLE IF EXISTS character")) {
            deleteChar.executeUpdate();
        }
    }

    public static ArrayList<MyCharacter> getAllChar() throws SQLException {
        try (PreparedStatement slChar = DBManager.getConnection().prepareStatement("SELECT * FROM character")) {
            try (ResultSet rs = slChar.executeQuery()) {
                ArrayList<MyCharacter> allChar = new ArrayList<>();
                while (rs.next()) {
                    ArrayList<Integer> intStat = new ArrayList<>();
                    for (int i = MyCharacter.STRENGTH; i <= MyCharacter.CHARISMA; i++) {
                        intStat.add(rs.getInt(Utils.getIndexName(i)));
                    }
                    ArrayList<Boolean> boolSave = new ArrayList<>();
                    for (int i = MyCharacter.STRENGTH; i <= MyCharacter.CHARISMA; i++) {
                        boolSave.add(rs.getBoolean(Utils.getSaveIndex(i)));
                    }
                    ArrayList<Boolean> boolProfExp = new ArrayList<>();
                    for (int i = MyCharacter.ACROBATICS; i <= MyCharacter.SURVIVAL; i++) {
                        boolProfExp.add(rs.getBoolean(Utils.getProfIndex(i)));
                        boolProfExp.add(rs.getBoolean(Utils.getExpIndex(i)));
                    }
                    allChar.add(new MyCharacter(UUID.fromString(rs.getString("id")), rs.getString("name"),
                            rs.getString("race"), rs.getString("class"), rs.getInt("lv"), rs.getInt("maxHp"), rs.getInt(
                                    "currentHp"),
                            rs.getInt("tempHp"), rs.getInt("initiative"), rs.getInt("profBonus"), rs.getInt("ac"), rs.getInt("speed"), intStat, boolSave, boolProfExp));
                }
                return allChar;
            }
        }
    }
    public static void updateCharacter(MyCharacter myCharacter) throws SQLException {
        try(PreparedStatement update = DBManager.getConnection().prepareStatement(
                "UPDATE character " +
                        "SET name = ?, lv = ?, maxHp = ?, currentHp = ?, tempHp = ?, initiative = ?, profBonus = ?, " +
                        "ac = ?, speed = ?," +
                        "strength = ?, dexterity = ?, constitution = ?, intelligence = ?, wisdom = ?, charisma = ?," +
                        "strengthProf = ?, dexterityProf = ?, constitutionProf = ?, intelligenceProf = ?, wisdomProf = ?, charismaProf = ?," +
                        "acrobaticsProf = ?, acrobaticsExp = ?," +
                        "animal_handlingProf = ?, animal_handlingExp = ?," +
                        "arcanaProf = ?, arcanaExp = ?, " +
                        "athleticsProf = ?, athleticsExp = ?," +
                        "deceptionProf = ?, deceptionExp = ?," +
                        "historyProf = ?, historyExp = ?," +
                        "insightProf = ?,insightExp = ?," +
                        "intimidationProf = ?, intimidationExp = ?, " +
                        "investigationProf = ?, investigationExp = ?," +
                        "medicineProf = ?, medicineExp = ?," +
                        "natureProf = ?, natureExp = ?," +
                        "perceptionProf = ?, perceptionExp = ?," +
                        "performanceProf = ?,  performanceExp = ?," +
                        "persuasionProf = ?, persuasionExp = ?," +
                        "religionProf = ?, religionExp = ?," +
                        "sleight_of_handProf = ?, sleight_of_handExp = ?," +
                        "stealthProf = ?, stealthExp = ?," +
                        "survivalProf = ?,  survivalExp = ?, class = ?, race = ? " +
                        "WHERE id = ?"))
        {
            update.setString(1, myCharacter.getName());
            update.setInt(2, myCharacter.getLvl());
            update.setInt(3, myCharacter.getMaxHp());
            update.setInt(4, myCharacter.getCurrentHp());
            update.setInt(5, myCharacter.getTemporary_hp());
            update.setInt(6, myCharacter.getInitiative());
            update.setInt(7, myCharacter.getProfBonus());
            update.setInt(8, myCharacter.getAc());
            update.setInt(9, myCharacter.getSpeed());
            for (int i = MyCharacter.STRENGTH; i <= MyCharacter.CHARISMA; i++) {
                update.setInt(10 + i - MyCharacter.STRENGTH, myCharacter.getIntStat(i));
            }
            for (int i = MyCharacter.STRENGTH; i <= MyCharacter.CHARISMA; i++) {
                update.setBoolean(16 + i - MyCharacter.STRENGTH, myCharacter.getProfStat(i));
            }
            for (int i = MyCharacter.ACROBATICS; i <= MyCharacter.SURVIVAL; i++) {
                update.setBoolean(22 + (2 * (i - MyCharacter.ACROBATICS)), myCharacter.getProficiency(i));
                update.setBoolean(23 + (2 * (i - MyCharacter.ACROBATICS)), myCharacter.getExpertise(i));
            }
            update.setString(58, myCharacter.getClassCh());
            update.setString(59, myCharacter.getRace());
            update.setString(60, myCharacter.getUuid().toString());
            update.executeUpdate();
        }
    }

    /**
     * Item Code
     */
    public static void insertItem(UUID id, Item item) throws SQLException{
        Connection connection = DBManager.getConnection();
        if(item.getCategory().equalsIgnoreCase("weapon")){
            try (PreparedStatement insertWeapon = connection.prepareStatement("INSERT INTO items (id,name,quantity," +
                    "weight, descr, category, cp, sp, ep, gp, pp, wp_cat, wp_range, cat_range, prop, dmg_key, dmg, " +
                    "idc) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")){
                Weapon weapon = (Weapon) item;
                insertWeapon.setString(1,weapon.getIdi().toString());
                insertWeapon.setString(2, weapon.getName());
                insertWeapon.setInt(3, weapon.getQuantity());
                insertWeapon.setDouble(4, weapon.getWeight());
                insertWeapon.setString(5, SavingUtils.arrayListToString(weapon.getDescription()));
                insertWeapon.setString(6, weapon.getCategory());
                insertWeapon.setInt(7, weapon.getPrice().getCp());
                insertWeapon.setInt(8, weapon.getPrice().getSp());
                insertWeapon.setInt(9, weapon.getPrice().getEp());
                insertWeapon.setInt(10, weapon.getPrice().getGp());
                insertWeapon.setInt(11, weapon.getPrice().getPp());
                insertWeapon.setString(12, weapon.getWeapon_category());
                insertWeapon.setString(13, weapon.getWeapon_range());
                insertWeapon.setString(14, weapon.getCategory_range());
                insertWeapon.setString(15, SavingUtils.arrayListToString(weapon.getArrayListProperties()));
                StringBuilder key = new StringBuilder();
                StringBuilder dmgS = new StringBuilder();
                for(String s:weapon.getDamageMap().keySet()){
                    key.append(s).append("},{");
                    Damage dmg = weapon.getDamageMap().get(s);
                    dmgS.append(dmg.getDamage_dice()).append("/").append(dmg.getDamage_type()).append("},{");
                }
                insertWeapon.setString(16, key.toString());
                insertWeapon.setString(17, dmgS.toString());
                insertWeapon.setString(18, id.toString());
                insertWeapon.executeUpdate();
            }
        }
        else if (item.getCategory().equalsIgnoreCase("armor")) {
            try (PreparedStatement insertArmor= connection.prepareStatement("INSERT INTO items (id,name,quantity," +
                    "weight, descr, category, cp, sp, ep, gp, pp, ca, dex_b, min_str, " +
                    "max_bonus, stealth_dis, idc) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?)")){
                Armor armor = (Armor) item;
                insertArmor.setString(1,armor.getIdi().toString());
                insertArmor.setString(2, armor.getName());
                insertArmor.setInt(3, armor.getQuantity());
                insertArmor.setDouble(4, armor.getWeight());
                insertArmor.setString(5, SavingUtils.arrayListToString(armor.getDescription()));
                insertArmor.setString(6, armor.getCategory());
                insertArmor.setInt(7, armor.getPrice().getCp());
                insertArmor.setInt(8, armor.getPrice().getSp());
                insertArmor.setInt(9, armor.getPrice().getEp());
                insertArmor.setInt(10, armor.getPrice().getGp());
                insertArmor.setInt(11, armor.getPrice().getPp());
                insertArmor.setInt(11, armor.getCa());
                insertArmor.setBoolean(13, armor.getDex_bonus());
                insertArmor.setInt(14, armor.getMin_str());
                insertArmor.setInt(15, armor.getMax_bonus());
                insertArmor.setBoolean(16,armor.getStealth_dis());
                insertArmor.setString(17, id.toString());
                insertArmor.executeUpdate();
            }
        }
        else{
            try (PreparedStatement insertItem = connection.prepareStatement("INSERT INTO items (id,name,quantity," +
                    "weight, descr, category, cp, sp, ep, gp, pp, idc) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)")){
                insertItem.setString(1,item.getIdi().toString());
                insertItem.setString(2, item.getName());
                insertItem.setInt(3, item.getQuantity());
                insertItem.setDouble(4, item.getWeight());
                insertItem.setString(5, SavingUtils.arrayListToString(item.getDescription()));
                insertItem.setString(6, item.getCategory());
                insertItem.setInt(7, item.getPrice().getCp());
                insertItem.setInt(8, item.getPrice().getSp());
                insertItem.setInt(9, item.getPrice().getEp());
                insertItem.setInt(10, item.getPrice().getGp());
                insertItem.setInt(11, item.getPrice().getPp());
                insertItem.setString(12, id.toString());
                insertItem.executeUpdate();
            }
        }
    }
    public static void resetItemTable() throws SQLException {
        try (PreparedStatement deleteChar = DBManager.getConnection().prepareStatement("DELETE FROM items")) {
            deleteChar.executeUpdate();
        }
    }
    public static void deleteItem(UUID uuid, Item item) throws SQLException {
        try (PreparedStatement deleteItem = DBManager.getConnection().prepareStatement("DELETE FROM items WHERE " +
                "idc = ? AND id = ?")) {
            deleteItem.setString(1, uuid.toString());
            deleteItem.setString(2, item.getIdi().toString());
            deleteItem.executeUpdate();
        }
    }
    public static void dropItemsTable() throws SQLException {
        try (PreparedStatement deleteItem = DBManager.getConnection().prepareStatement("DROP TABLE IF EXISTS items")) {
            deleteItem.executeUpdate();
        }
    }
    public static ArrayList<Item> getAllItems(UUID id) throws SQLException {
        try (PreparedStatement slItem =
                     DBManager.getConnection().prepareStatement("SELECT * FROM items WHERE idc = '" + id.toString() + "'")) {
            try (ResultSet rs = slItem.executeQuery()) {
                ArrayList<Item> allItems = new ArrayList<>();
                while (rs.next()) {
                    String category = rs.getString("category");
                    Money cost = new Money(rs.getInt("cp"), rs.getInt("sp"), rs.getInt("ep"), rs.getInt("gp"),
                            rs.getInt("pp"));
                    if(category.equalsIgnoreCase("weapon")){
                        String keyS = rs.getString("dmg_key");
                        ArrayList<String> dmgS = new ArrayList<>(Arrays.asList(rs.getString("dmg").split("},\\{")));
                        int i = 0;
                        Map<String, Damage> damage = new HashMap<>();
                        for(String s:keyS.split("},\\{")){
                            damage.put(s, new Damage(dmgS.get(i++)));
                        }
                        Weapon w = new Weapon(rs.getString("name"), rs.getInt("quantity"), rs.getDouble("weight"),
                                SavingUtils.stringToArrayList(rs.getString("descr")), category, cost,
                                rs.getString("wp_cat"), rs.getString("wp_range"),
                                rs.getString("cat_range"),
                                new WeaponProperties(SavingUtils.stringToArrayList(rs.getString("prop"))), damage);
                        w.setIdi(UUID.fromString(rs.getString("id")));
                        allItems.add(w);
                    }
                    else if (category.equalsIgnoreCase("armor")) {
                        Armor a = new Armor(rs.getString("name"), rs.getInt("quantity"), rs.getDouble("weight"),
                                SavingUtils.stringToArrayList(rs.getString("descr")), category, cost, rs.getInt("ca"),
                                rs.getBoolean("dex_b"), rs.getInt("min_str"), rs.getInt("max_bonus"), rs.getBoolean(
                                        "stealth_dis"));
                        a.setIdi(UUID.fromString(rs.getString("id")));
                        allItems.add(a);
                    }
                    else{
                        Item i = new Item(rs.getString("name"), rs.getInt("quantity"), rs.getDouble("weight"),
                                SavingUtils.stringToArrayList(rs.getString("descr")), category, cost);
                        i.setIdi(UUID.fromString(rs.getString("id")));
                        allItems.add(i);
                    }
                }
                for(Item i:allItems){
                    i.setId(id);
                }
                return allItems;
            }
        }
    }
    public static void updateItem(UUID id, Item item) throws SQLException {
        if(item.getCategory().equalsIgnoreCase("weapon")){
            Weapon weapon = (Weapon) item;
            try(PreparedStatement update = DBManager.getConnection().prepareStatement(
                    "UPDATE items " +
                            "SET quantity = ?, weight = ?, descr = ?, category = ?, cp = ?, sp = ?, ep = ?, gp = ?, " +
                            "pp = ?, wp_cat = ?, wp_range = ?, cat_range = ?, prop = ?, dmg_key = ?, dmg = ?, name = " +
                            "?" +
                            "WHERE idc = ? AND id = ?"))
            {
                update.setInt(1,weapon.getQuantity());
                update.setDouble(2,weapon.getWeight());
                update.setString(3,SavingUtils.arrayListToString(weapon.getDescription()));
                update.setString(4, weapon.getCategory());
                update.setInt(5, weapon.getPrice().getCp());
                update.setInt(6, weapon.getPrice().getSp());
                update.setInt(7, weapon.getPrice().getEp());
                update.setInt(8, weapon.getPrice().getGp());
                update.setInt(9, weapon.getPrice().getPp());
                update.setString(10, weapon.getWeapon_category());
                update.setString(11, weapon.getWeapon_range());
                update.setString(12, weapon.getCategory_range());
                update.setString(13, SavingUtils.arrayListToString(weapon.getArrayListProperties()));
                StringBuilder key = new StringBuilder();
                StringBuilder dmgS = new StringBuilder();
                for(String s:weapon.getDamageMap().keySet()){
                    key.append(s).append("},{");
                    Damage dmg = weapon.getDamageMap().get(s);
                    dmgS.append(dmg.getDamage_dice()).append("/").append(dmg.getDamage_type()).append("},{");
                }
                update.setString(14, key.toString());
                update.setString(15, dmgS.toString());
                update.setString(16, weapon.getName());
                update.setString(17, id.toString());
                update.setString(18, weapon.getIdi().toString());
                update.executeUpdate();
            }
        }
        else if (item.getCategory().equalsIgnoreCase("armor")) {
            Armor armor = (Armor) item;
            try(PreparedStatement update = DBManager.getConnection().prepareStatement(
                    "UPDATE items " +
                            "SET quantity = ?, weight = ?, descr = ?, category = ?, cp = ?, sp = ?, ep = ?, gp = ?, " +
                            "pp = ?, ca = ?, dex_b = ?, min_str = ?, max_bonus = ?, stealth_dis = ?, name = ?" +
                            "WHERE idc = ? AND id = ?"))
            {
                update.setInt(1,armor.getQuantity());
                update.setDouble(2,armor.getWeight());
                update.setString(3,SavingUtils.arrayListToString(armor.getDescription()));
                update.setString(4, armor.getCategory());
                update.setInt(5, armor.getPrice().getCp());
                update.setInt(6, armor.getPrice().getSp());
                update.setInt(7, armor.getPrice().getEp());
                update.setInt(8, armor.getPrice().getGp());
                update.setInt(9, armor.getPrice().getPp());
                update.setInt(10, armor.getCa());
                update.setBoolean(11, armor.getDex_bonus());
                update.setInt(12, armor.getMin_str());
                update.setInt(13, armor.getMax_bonus());
                update.setBoolean(14,armor.getStealth_dis());
                update.setString(16, id.toString());
                update.setString(15, armor.getName());
                update.setString(17, armor.getIdi().toString());
                update.executeUpdate();
            }
        }
        else{
            try(PreparedStatement update = DBManager.getConnection().prepareStatement(
                    "UPDATE items " +
                            "SET quantity = ?, weight = ?, descr = ?, category = ?, cp = ?, sp = ?, ep = ?, gp = ?, " +
                            "pp = ?, name = ?" +
                            "WHERE idc = ? AND id = ?"))
            {
                update.setInt(1,item.getQuantity());
                update.setDouble(2,item.getWeight());
                update.setString(3,SavingUtils.arrayListToString(item.getDescription()));
                update.setString(4, item.getCategory());
                update.setInt(5, item.getPrice().getCp());
                update.setInt(6, item.getPrice().getSp());
                update.setInt(7, item.getPrice().getEp());
                update.setInt(8, item.getPrice().getGp());
                update.setInt(9, item.getPrice().getPp());
                update.setString(11, id.toString());
                update.setString(10, item.getName());
                update.setString(12, item.getIdi().toString());
                update.executeUpdate();
            }
        }
    }
    public static void updateItem(Item item) throws SQLException {
        if(item.getCategory().equalsIgnoreCase("weapon")){
            Weapon weapon = (Weapon) item;
            try(PreparedStatement update = DBManager.getConnection().prepareStatement(
                    "UPDATE items " +
                            "SET quantity = ?, weight = ?, descr = ?, category = ?, cp = ?, sp = ?, ep = ?, gp = ?, " +
                            "pp = ?, wp_cat = ?, wp_range = ?, cat_range = ?, prop = ?, dmg_key = ?, dmg = ?, name = " +
                            "?" +
                            "WHERE idc = ? AND id = ?"))
            {
                update.setInt(1,weapon.getQuantity());
                update.setDouble(2,weapon.getWeight());
                update.setString(3,SavingUtils.arrayListToString(weapon.getDescription()));
                update.setString(4, weapon.getCategory());
                update.setInt(5, weapon.getPrice().getCp());
                update.setInt(6, weapon.getPrice().getSp());
                update.setInt(7, weapon.getPrice().getEp());
                update.setInt(8, weapon.getPrice().getGp());
                update.setInt(9, weapon.getPrice().getPp());
                update.setString(10, weapon.getWeapon_category());
                update.setString(11, weapon.getWeapon_range());
                update.setString(12, weapon.getCategory_range());
                update.setString(13, SavingUtils.arrayListToString(weapon.getArrayListProperties()));
                StringBuilder key = new StringBuilder();
                StringBuilder dmgS = new StringBuilder();
                for(String s:weapon.getDamageMap().keySet()){
                    key.append(s).append("},{");
                    Damage dmg = weapon.getDamageMap().get(s);
                    dmgS.append(dmg.getDamage_dice()).append("/").append(dmg.getDamage_type()).append("},{");
                }
                update.setString(14, key.toString());
                update.setString(15, dmgS.toString());
                update.setString(16, weapon.getName());
                update.setString(17, weapon.getId().toString());
                update.setString(18, weapon.getIdi().toString());
                update.executeUpdate();
            }
        }
        else if (item.getCategory().equalsIgnoreCase("armor")) {
            Armor armor = (Armor) item;
            try(PreparedStatement update = DBManager.getConnection().prepareStatement(
                    "UPDATE items " +
                            "SET quantity = ?, weight = ?, descr = ?, category = ?, cp = ?, sp = ?, ep = ?, gp = ?, " +
                            "pp = ?, ca = ?, dex_b = ?, min_str = ?, max_bonus = ?, stealth_dis = ?, name = ?" +
                            "WHERE idc = ? AND id = ?"))
            {
                update.setInt(1,armor.getQuantity());
                update.setDouble(2,armor.getWeight());
                update.setString(3,SavingUtils.arrayListToString(armor.getDescription()));
                update.setString(4, armor.getCategory());
                update.setInt(5, armor.getPrice().getCp());
                update.setInt(6, armor.getPrice().getSp());
                update.setInt(7, armor.getPrice().getEp());
                update.setInt(8, armor.getPrice().getGp());
                update.setInt(9, armor.getPrice().getPp());
                update.setInt(10, armor.getCa());
                update.setBoolean(11, armor.getDex_bonus());
                update.setInt(12, armor.getMin_str());
                update.setInt(13, armor.getMax_bonus());
                update.setBoolean(14,armor.getStealth_dis());
                update.setString(16, armor.getId().toString());
                update.setString(15, armor.getName());
                update.setString(17, armor.getIdi().toString());
                update.executeUpdate();
            }
        }
        else{
            try(PreparedStatement update = DBManager.getConnection().prepareStatement(
                    "UPDATE items " +
                            "SET quantity = ?, weight = ?, descr = ?, category = ?, cp = ?, sp = ?, ep = ?, gp = ?, " +
                            "pp = ?, name = ?" +
                            "WHERE idc = ? AND id = ?"))
            {
                update.setInt(1,item.getQuantity());
                update.setDouble(2,item.getWeight());
                update.setString(3,SavingUtils.arrayListToString(item.getDescription()));
                update.setString(4, item.getCategory());
                update.setInt(5, item.getPrice().getCp());
                update.setInt(6, item.getPrice().getSp());
                update.setInt(7, item.getPrice().getEp());
                update.setInt(8, item.getPrice().getGp());
                update.setInt(9, item.getPrice().getPp());
                update.setString(11, item.getId().toString());
                update.setString(10, item.getName());
                update.setString(12, item.getIdi().toString());
                update.executeUpdate();
            }
        }
    }

    /**
     * Spells code
     */
    public static void insertSpell(UUID id, Spell spell) throws SQLException {
        Connection connection = DBManager.getConnection();
        try (PreparedStatement insertSpell = connection.prepareStatement("INSERT INTO spells (idc, name, descr, " +
                "highLv, range, components, material, ritual, duration, concentration, dc, level, attType, school, " +
                "id) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")){
            insertSpell.setString(1,id.toString());
            insertSpell.setString(2, spell.getName());
            insertSpell.setString(3, arrayListToString(spell.getDesc()));
            insertSpell.setString(4, arrayListToString(spell.getHighLv()));
            insertSpell.setString(5, spell.getRange());
            insertSpell.setString(6, arrayListToString(spell.getComponents()));
            insertSpell.setString(7, spell.getMaterial());
            insertSpell.setBoolean(8,spell.getRitual());
            insertSpell.setString(9, spell.getDuration());
            insertSpell.setBoolean(10, spell.getConcentration());
            insertSpell.setInt(11, spell.getDcInt());
            insertSpell.setInt(12, spell.getLevel());
            insertSpell.setString(13, spell.getAttType());
            insertSpell.setString(14, spell.getSchool());
            insertSpell.setString(15, spell.getIdi().toString());
            insertSpell.executeUpdate();
        }
    }
    public static void deleteSpell(UUID uuid, Spell spell) throws SQLException {
        try (PreparedStatement deleteSpell = DBManager.getConnection().prepareStatement("DELETE FROM spells WHERE " +
                "idc = ? AND id = ?")) {
            deleteSpell.setString(1, uuid.toString());
            deleteSpell.setString(2, spell.getIdi().toString());
            deleteSpell.executeUpdate();
        }
    }
    public static void resetSpellTable() throws SQLException {
        try (PreparedStatement deleteSpell = DBManager.getConnection().prepareStatement("DELETE FROM spells")) {
            deleteSpell.executeUpdate();
        }
    }
    public static void dropSpellsTable() throws SQLException {
        try (PreparedStatement deleteSpell =
                     DBManager.getConnection().prepareStatement("DROP TABLE IF EXISTS spells")) {
            deleteSpell.executeUpdate();
        }
    }
    public static Set<Spell> getAllSpell(UUID id) throws SQLException {
        try (PreparedStatement slItem =
                     DBManager.getConnection().prepareStatement("SELECT * FROM spells WHERE idc = '" + id.toString() +
                             "'")) {
            try (ResultSet rs = slItem.executeQuery()) {
                HashSet<Spell> allSpells = new HashSet<>();
                while (rs.next()) {
                    Spell s = new Spell(rs.getString("name"), stringToArrayList(rs.getString("descr")),
                            stringToArrayList(rs.getString("highLv")), rs.getString("range"),
                            stringToArrayList(rs.getString("components")), rs.getString("material"),
                            rs.getBoolean("ritual"), rs.getString("duration"), rs.getBoolean("concentration"),
                            rs.getInt("dc"), rs.getInt("level"), rs.getString("attType"),
                            rs.getString("school"));
                    s.setIdi(UUID.fromString(rs.getString("id")));
                    allSpells.add(s);
                }
                return allSpells;
            }
        }
    }
    public static void updateSpell(UUID id, Spell spell) throws SQLException {
        try(PreparedStatement update = DBManager.getConnection().prepareStatement(
                "UPDATE spells " +
                        "SET descr = ?, highLv = ?, range = ?, components = ?, material = ?, ritual = ?, " +
                        "duration = ?, concentration = ?, dc = ?, level = ?, attType = ?, school = ?, name = ?" +
                        "WHERE idc = ? AND id = ?"))
        {
            update.setString(1, arrayListToString(spell.getDesc()));
            update.setString(2, arrayListToString(spell.getHighLv()));
            update.setString(3, spell.getRange());
            update.setString(4, arrayListToString(spell.getComponents()));
            update.setString(5, spell.getMaterial());
            update.setBoolean(6, spell.getRitual());
            update.setString(7, spell.getDuration());
            update.setBoolean(8, spell.getConcentration());
            update.setInt(9, spell.getDcInt());
            update.setInt(10, spell.getLevel());
            update.setString(11, spell.getAttType());
            update.setString(12, spell.getSchool());
            update.setString(14, id.toString());
            update.setString(13, spell.getName());
            update.setString(15, spell.getIdi().toString());
            update.executeUpdate();
        }
    }

    /**
     * Utils
     */
    private static String arrayListToString(ArrayList<String> a){
        StringBuilder b = new StringBuilder();
        for(String s:a){
            b.append(s);
            b.append("},{");
        }
        return b.toString();
    }
    private static ArrayList<String> stringToArrayList(String s){
        return new ArrayList<>(Arrays.asList(s.toString().split("},\\{")));
    }
    public static void dropAll() throws SQLException{
        dropSpellsTable();
        dropItemsTable();
        dropCharTable();
    }
}
