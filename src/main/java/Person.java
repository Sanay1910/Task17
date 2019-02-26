import java.util.ArrayList;

public class Person {

    String firstName, lastName, address, personalEmail, workEmail;
    int ID;
    ArrayList<String> relationships = new ArrayList<>();
    ArrayList<String> contact = new ArrayList<>();

    Person(int ID, String firstName, String lastName, String address, ArrayList<String> contact){
        this(ID, firstName,lastName,address,contact,null,null,null);
    }

    Person(int ID, String firstName, String lastName, String address, ArrayList<String> contact, String personalEmail, String workEmail, ArrayList<String> relationships){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
        this.personalEmail = personalEmail;
        this.workEmail = workEmail;
        this.relationships = relationships;
    }

}
