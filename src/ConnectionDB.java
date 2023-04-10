import java.sql.*;

public class ConnectionDB {
    public static Connection con;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException{
        con = null;
        Class.forName("org.sqlite.JDBC"); // Загрузка драйвера
        con = DriverManager.getConnection("jdbc:sqlite:TEST.s3db"); // Подключение/Создание базы
        System.out.println("База Подключена!");
    }


    // --------Создание таблицы--------
    public static void CreateDB() throws ClassNotFoundException, SQLException{
        statmt = con.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");

         /* statmt.execute("CREATE TABLE Customers\n" +
                "(\n" +
                "    Id INT,\n" +
                "    Age INT,\n" +
                "    FirstName NVARCHAR(20),\n" +
                "    LastName NVARCHAR(20),\n" +
                "    Email VARCHAR(30),\n" +
                "    Phone VARCHAR(20)\n" +
                ");");*/

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public static void WriteDB() throws SQLException
    {                  // вставка    в какую таблицу    в какие поля              что вставлять
        statmt.execute("INSERT INTO 'users'          ('name', 'phone') VALUES ('Petya', 125453); ");
        statmt.execute("INSERT INTO 'users'          ('name', 'phone') VALUES ('Vasya', 321789); ");
        statmt.execute("INSERT INTO 'users'          ('name', 'phone') VALUES ('Masha', 456123); ");
        System.out.println("Таблица заполнена");
    }
    // -------- Вывод таблицы--------
    public static void ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  name = resSet.getString("name");
            String  phone = resSet.getString("phone");
            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            System.out.println( "phone = " + phone );
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }
    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        con.close();
        statmt.close();
        resSet.close();

        System.out.println("Соединения закрыты");
    }
}
