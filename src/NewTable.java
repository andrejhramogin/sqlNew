//таблица для отработки метода заполнения через консоль

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewTable {
    public static Connection con;
    public static Statement statmt;

    public static void conn() throws  ClassNotFoundException, SQLException{
        con = null;
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:NewTable.s3db");
        System.out.println("Base connected!");
    }

//    public static void createDB() throws ClassNotFoundException, SQLException{
//        statmt.execute(TableFilling.fillTable());
//        System.out.println("New table has created.");
//    }
}
