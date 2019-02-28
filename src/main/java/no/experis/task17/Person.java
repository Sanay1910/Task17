package no.experis.task17;

import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;

public class Person {

    String firstName, lastName,birth, address, personalEmail, workEmail;
    int ID;
    ArrayList<Relation> relation = new ArrayList<>();
    ArrayList<ContactNumbers> contact = new ArrayList<>();

    public Person(){
        this.ID = ID;
        this.firstName= firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.address = address;
        this.relation.addAll(relation);
    }

    public Person(String firstName, String lastName, String birth/*, String address*/){
        this.ID = ID;
        this.firstName= firstName;
        this.lastName = lastName;
        this.birth = birth;
        //this.address = address;
        this.relation.addAll(relation);
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

    public ArrayList<ContactNumbers> getContact() {
        return contact;
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

    /*public String getWork(){
        return contact.get(0);
    }*/

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

    public void setRelation(ArrayList<Relation> relation) {
        this.relation = relation;
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

    public void setBirth(String birth) {
        this.birth = birth;
    }
    public  String getBirth() {
        return birth;
    }




}
