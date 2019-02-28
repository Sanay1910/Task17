package no.experis.task17;

import java.util.ArrayList;

public class Person {

    String firstName, lastName,birth, address, personalMail, workMail;
    int ID;
    ArrayList<Relation> relation = new ArrayList<>();
    //ArrayList<ContactNumber> contact = new ArrayList<>();
    ContactNumber contact = new ContactNumber();


    Person(int ID, String firstName, String lastName, String birth,String address, ContactNumber contact){
        this(ID, firstName,lastName, birth, address, contact,null,null,null);
    }

    Person(int ID, String firstName, String lastName,String birth, String address, ContactNumber contact,String personalMail, String workMail, ArrayList<Relation> relation){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.address = address;
        this.contact = contact;
        this.personalMail = personalMail;
        this.workMail = workMail;
        this.relation.addAll(relation);

    }
    /*Person(int ID, String firstName, String lastName, String address, ContactNumber contact, String personalMail, String workMail, ArrayList<Relation> relation    ){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.personalMail = personalMail;
        this.workMail = workMail;
        this.relation.addAll(relation);
        this.contact = contact;
    }*/

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
        return address;
    }

    public void setWork(String work) {
        //contact.set(0,work);
    }

    public ContactNumber getContact(){
        return contact;
    }

    //public void setRelationships(String person1, String person2, String role) {
    //    relation.add(person1 + "->" + role + ":" + person2);
    //}


    public ArrayList<Relation> getRelationships() {
        ArrayList<Relation> newRel = new ArrayList<>();

        for(Relation rel: relation){
            if (Integer.parseInt(rel.ID)==ID){
                newRel.add(rel);
            }
        }
        return newRel;
    }

    public void setPersonalMail(String personalEmail) {
        this.personalMail = personalEmail;
    }

    public String getPersonalEmail(){
        return personalMail;
    }

    public void setWorkEmail(String workEmail) {
        this.workMail = workEmail;
    }

    public String getWorkEmail(){
        return workMail;
    }




}
