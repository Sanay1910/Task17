package no.experis.task17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static no.experis.task17.Select.contact;
import static no.experis.task17.Select.relatives2;


@SpringBootApplication
public class SQLtoREST {


    private static String URL = "jdbc:sqlite:src/main/resources/people.sqlite";
    private static Connection conn = null;
    public static ArrayList<Person> person = new ArrayList<Person>();
    public static ArrayList<Relation> relation = new ArrayList<Relation>();
    public static ArrayList<Address> address = new ArrayList<>();


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

    public static void readRelations(){
        try {
            PreparedStatement preparedStatement2 =
                    //conn.prepareStatement("SELECT * FROM customer");
                    conn.prepareStatement("SELECT p1.ID, p2.firstName as relativeName, relationship" +
                            " FROM relation INNER JOIN person p1 ON relation.fromPersonID = p1.ID" +
                            " INNER JOIN person p2 ON relation.toPersonID = p2.ID" +
                            " INNER JOIN relationType ON relation.relation = relationType.id "
                    );
            ResultSet rs2 = preparedStatement2.executeQuery();

            while (rs2.next()) {
                relation.add(
                        new Relation(
                                rs2.getString("p1.ID"),
                                rs2.getString("p2.relativeName"),
                                rs2.getString("relationship")
                        ));
            }
            for(Relation rel: relation){
                System.out.println(rel);
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

    public static void readPeople(){
    System.out.println("readPeople");
        //Select relations = new Select();
        try{
            PreparedStatement preparedStatement =
                    //conn.prepareStatement("SELECT * FROM customer");
                    conn.prepareStatement(" SELECT person.ID, firstName, lastName, birth, address, personalMail, workMail, work, home, mobile" +
                            " FROM Person" +
                            " INNER JOIN homeAddress ON homeAddress.ID = person.AddressID" +
                            " INNER JOIN contactNumber ON contactNumber.ID = person.contactID"
                    );
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<ContactNumber> contact = new ArrayList<>();
            while (resultSet.next()) {

                person.add(
                        new Person(
                                resultSet.getInt("ID"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName"),
                                resultSet.getString("birth"),
                                resultSet.getString("Address"),
                                new ContactNumber(resultSet.getString("work"),resultSet.getString("home"),resultSet.getString("mobile")),
                                resultSet.getString("personalMail"),
                                resultSet.getString("workMail"),
                                relatives2()
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

    public static void readAddress(){
        System.out.println("readAddress");
        //Select relations = new Select();
        try{
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT ID, address" +
                            " FROM HomeAddress"
                    );



           /* ("SELECT homeAddress.ID, address, addressID" +
                    " FROM HomeAddress" +
                    " LEFT JOIN person ON person.addressID = homeAddress.ID" */
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                address.add(
                        new Address(
                                resultSet.getInt("ID"),
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
    /*
    public static ArrayList<Person> listAll() {
        ArrayList<Person> persons = new ArrayList<>();
        person.forEach(persons::add);
        return persons;
    }
    */
}