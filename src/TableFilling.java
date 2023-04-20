//заполнение таблицы через консоль

import java.util.Scanner;

public class TableFilling {

    public static Scanner scanner = new Scanner(System.in);

    public static String getString(){
        return scanner.nextLine();
    }

//    public static String fillTable(){
//
//        System.out.println("Enter the table tytle: ");
//
//        String message = String.format("CREATE TABLE if not exists '%s'('Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL);"), getString());
//
//        return message;
//
//    }
}
/*
statmt.execute("CREATE TABLE if not exists 'Departments' (" +
                "'Id' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "'Name' NVARCHAR(100) NOT NULL UNIQUE CHECK (trim(Name) != '') );");
 */