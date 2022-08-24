package generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;



public class Main {

    private static Connection connection;
    private static Statement statement;
    public static void main(String[] args) {
        // начало первого задания
        String[] hw = {"hello", "world"};

        changeOrder(hw);
        System.out.println(Arrays.toString(hw));
        // конец первого задания

        //создаю фрукты и кладу в коробки
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Box<Apple> appleBox = new Box<>();

        appleBox.addFruits(apple1);
        appleBox.addFruits(apple2);
        appleBox.addFruits(apple3);
        appleBox.addFruits(apple4);
        System.out.println(appleBox.getWeight());

        Orange or1 = new Orange();
        Orange or2 = new Orange();
        Orange or3 = new Orange();
        Orange or4 = new Orange();
        Box<Orange> orangeBox = new Box<>();

        orangeBox.addFruits(or1);
        orangeBox.addFruits(or2);
        orangeBox.addFruits(or3);
        orangeBox.addFruits(or4);
        System.out.println(orangeBox.getWeight());

        //сравниваю коробки
        System.out.println(appleBox.compare(orangeBox));

        //создаю ещё одну для задания с пересыпанием
        Box<Orange> bigOrangeBox = new Box<>();
        Orange or5 = new Orange();

        bigOrangeBox.addFruits(or5);
        orangeBox.relocateFruits(bigOrangeBox);

        //проверяю
        System.out.println(orangeBox.getWeight());
        System.out.println(bigOrangeBox.getWeight());

        //bigOrangeBox.relocateFruits(appleBox); проверяю что апельсины к яблокам не насыпать

        try {
            connect();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            statement.execute("CREATE TABLE IF NOT EXISTS fruits (" + "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "name TEXT)");
            statement.execute("INSERT INTO fruits (name) VALUES ('apple')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        try {
            disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void changeOrder(Object[] array){
        if (array.length < 2){
            return;
        }

        Object temp = array[0];
        array[0] = array[1];
        array[1] = temp;
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:fruits.db");
        statement = connection.createStatement();
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }
}
