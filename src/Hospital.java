import java.sql.*;

public class Hospital {
    public static Connection con;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void conn() throws ClassNotFoundException, SQLException {
        con = null;
        Class.forName("org.sqlite.JDBC");  // Загрузка драйвера
        con = DriverManager.getConnection("jdbc:sqlite:Hospital.s3db"); // Подключение/Создание базы

        System.out.println("База Подключена!");
    }

    // --------Создание таблицы--------
    public static void createDB() throws ClassNotFoundException, SQLException {
        statmt = con.createStatement();

        statmt.execute("CREATE TABLE if not exists 'Examinations' (" +
                "'Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "'DayOfWeek' INT NOT NULL," +
                "'EndTime' TIME NOT NULL ," +
                "'Name' NVARCHAR(100) NOT NULL UNIQUE," +
                "'StartTime' TIME NOT NULL, CHECK (DayOfWeek>=1 AND DayOfWeek <=7), CHECK (StartTime >= 8  AND StartTime <= 18 ), CHECK (EndTime > StartTime));");

        statmt.execute("CREATE TABLE if not exists 'Doctors'('Id' INTEGER PRIMARY KEY AUTOINCREMENT not null," +
                " 'Name' nvarchar MAX NOT NULL CHECK (Name != ' ')," +
                " 'Phone' CHAR(10)," +
                "'Salary' money NOT NULL CHECK (Salary>0)," +
                "'Surname' NVARCHAR MAX NOT NULL CHECK (Surname != ' ') );");

        statmt.execute("CREATE TABLE if not exists 'Diseases'(" +
                "'Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "'Name' NVARCHAR(100) NOT NULL UNIQUE CHECK (Name != ' ')," +
                "'Severity' INT NOT NULL DEFAULT 1 CHECK (Severity >= 1));");

        statmt.execute("CREATE TABLE if not exists 'Departments' (" +
                "'Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "'Building' INT NOT NULL CHECK (Building>=1 AND Building <=5)," +
                "'Financing' MONEY NOT NULL DEFAULT 0 CHECK (Financing >=0)," +
                "'Name' NVARCHAR(100) NOT NULL UNIQUE CHECK (Name != ' ') );");
    }
}
