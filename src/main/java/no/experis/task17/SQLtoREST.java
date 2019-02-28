package no.experis.task17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;
import java.util.ArrayList;

import static no.experis.task17.Select.relatives2;


@SpringBootApplication
public class SQLtoREST {

    private static String URL = "jdbc:sqlite:src/main/resources/people.sqlite";
    private static Connection conn = null;
    public static ArrayList<Person> person = new ArrayList<Person>();
    public static ArrayList<Relation> relation = new ArrayList<Relation>();
    public static ArrayList<ContactNumbers> numbers = new ArrayList<ContactNumbers>();


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

        //Select relations = new Select();
        try{
            PreparedStatement preparedStatement =
                    //conn.prepareStatement("SELECT * FROM customer");
                    conn.prepareStatement(" SELECT person.ID, firstName, lastName, birth, address, personalMail, workMail, home, work, mobile" +
                            " FROM Person" +
                            " INNER JOIN homeAddress ON homeAddress.ID = person.AddressID" +
                            " INNER JOIN contactNumber ON contactNumber.ID = person.contactID"
                    );
            ResultSet resultSet = preparedStatement.executeQuery();

            for(Relation rel: relation){
                System.out.println(rel);
            }
            while (resultSet.next()) {
                Person p = new Person();
                p.setID(resultSet.getInt("ID"));
                p.setFirstName(resultSet.getString("firstName"));
                p.setLastName(resultSet.getString("lastName"));
                p.setAddress(resultSet.getString("address"));
                p.setPersonalEmail(resultSet.getString("personalMail"));
                p.setWorkEmail(resultSet.getString("workMail"));
                p.setRelation(relatives2());

                ContactNumbers n = new ContactNumbers();
                n.setHomeNum(resultSet.getString("home"));
                n.setWorkNum(resultSet.getString("work"));
                n.setMobileNum(resultSet.getString("mobile"));
                person.add(p);
                p.getContact().add(n);
                person.add(p);

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