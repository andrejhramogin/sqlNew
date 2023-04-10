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
                "'Name' NVARCHAR(100) UNIQUE," +
                "'StartTime' TIME NOT NULL, CHECK (StartTime >= 8  AND StartTime <= 18 ), CHECK (EndTime > StartTime));");

        statmt.execute("CREATE TABLE if not exists 'Doctors'('Id' INTEGER PRIMARY KEY AUTOINCREMENT not null," +
                " 'Name' nvarchar(100) NOT NULL CHECK (Name != ' ')," +
                " 'Phone' CHAR(10) NOT NULL," +
                "'Salary' money NOT NULL CHECK (Salary>0)," +
                "'Surname' NVARCHAR(100) NOT NULL CHECK (Surname != ' ') );");
    }
}
