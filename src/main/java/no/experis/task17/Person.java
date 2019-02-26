package no.experis.task17;

import java.util.ArrayList;

public class Person {

    String firstName, lastName,birth, address, personalEmail, workEmail;
    int ID;
    ArrayList<String> relationships = new ArrayList<>();
    ArrayList<String> contact = new ArrayList<>();

    Person(int ID, String firstName, String lastName,String birth, String address){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.address = address;
    }

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

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getID(){
        return ID + "";
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress(){
        System.out.println(address);
        return address;
    }

    public void setWork(String work) {
        contact.set(0,work);
    }

    /*public String getWork(){
        return contact.get(0);
    }*/

    public void setRelationships(String person1, String person2, String role) {
        relationships.add(person1 + "->" + role + ":" + person2);
    }


    public ArrayList<String> getRelationships() {
        return relationships;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getPersonalEmail(){
        return personalEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getWorkEmail(){
        return workEmail;
    }




}
