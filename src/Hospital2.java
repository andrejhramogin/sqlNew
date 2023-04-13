import java.sql.*;

public class Hospital2 {
    public static Connection con;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void conn() throws ClassNotFoundException, SQLException {
        con = null;
        Class.forName("org.sqlite.JDBC");  // Загрузка драйвера
        con = DriverManager.getConnection("jdbc:sqlite:Hospital2.s3db"); // Подключение/Создание базы

        System.out.println("База Подключена!");
    }

    public static void createDB() throws ClassNotFoundException, SQLException {
        statmt = con.createStatement();

        statmt.execute("CREATE TABLE if not exists 'Departments' (" +
                "'Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "'Name' NVARCHAR(100) NOT NULL UNIQUE CHECK (trim(Name) != '') );");

        statmt.execute("CREATE TABLE if not exists 'Doctors'('Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "'Name' nvarchar MAX NOT NULL CHECK (trim (Name) != '')," +
                "'Premium' MONEY NOT NULL DEFAULT 0 CHECK (Premium >= 0)," +
                "'Salary' MONEY NOT NULL CHECK (Salary > 0)," +
                "'Surname' NVARCHAR MAX NOT NULL CHECK (trim(Surname) != 0));");

        statmt.execute("CREATE TABLE if not exists 'DoctorsSpecializations' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "'DoctorId' INTEGER NOT NULL, " +
                "'SpecializationId' INTEGER NOT NULL," +
                "FOREIGN KEY (DoctorId) REFERENCES Doctors(Id), FOREIGN KEY (SpecializationId) REFERENCES Specializations(Id));");

        statmt.execute("CREATE TABLE if not exists 'Specializations'(" +
                "'Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "'Name' NVARCHAR(100) NOT NULL UNIQUE CHECK (trim(Name) != 0));");
    }
}

