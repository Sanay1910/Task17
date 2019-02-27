package no.experis.task17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;
import java.util.ArrayList;

@SpringBootApplication
public class SQLtoREST {

    private static String URL = "jdbc:sqlite:src/main/resources/people.sqlite";
    private static Connection conn = null;
    public static ArrayList<Person> person = new ArrayList<Person>();


    public static void openConn(){
        try{
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
        }
        catch (Exception e){
            System.out.println("Something went wrong.");
            System.out.println(e.toString());
        }
        finally {
        }
    }

    public static void readPeople(){
        try{
            PreparedStatement preparedStatement =
                    //conn.prepareStatement("SELECT * FROM customer");
                    conn.prepareStatement(" SELECT person.ID, firstName, lastName, birth, address" +
                                              " FROM Person" +
                                              " INNER JOIN homeAddress ON homeAddress.ID = person.AddressID"
                                         );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                person.add(
                        new Person(
                                resultSet.getInt("ID"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getString("birth"),
                                resultSet.getString("Address")
                        ));
            }

        }
        catch (Exception e){
            System.out.println("Something went wrong.");
            System.out.println(e.toString());
        }
        finally {
            try {
                conn.close();
            }
            catch (Exception e){
                System.out.println("Something went wrong.");
                System.out.println(e.toString());
            }
        }
    }
}