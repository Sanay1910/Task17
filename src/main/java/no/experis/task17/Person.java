package no.experis.task17;

import java.util.ArrayList;
import java.util.*;

import static no.experis.task17.SQLtoREST.person;

public class Person {

    int ID;
    String firstName, lastName,birth, address, personalMail, workMail;

    ArrayList<Relation> relation = new ArrayList<>();
    ArrayList<Relation> relatives = new ArrayList<>();
    ContactNumber contact = new ContactNumber();



    Person(){

    }

    Person(int ID,String firstName, String lastName,String birth, String address, String personalMail, String workMail, ContactNumber contact, ArrayList<Relation> relation){
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

    Person(String firstName, String lastName,String birth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
    }

    Person(int ID, String firstName, String lastName,String birth){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
    }

    public Person(int ID, String firstName, String lastName, String birth, String address, ContactNumber contact, String personalMail, String workMail, ArrayList<Relation> relation) {
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

    Person(int ID, String firstName, String lastName, String birth, String address, ArrayList<Relation> relatives, String personalMail, String workMail, ContactNumber contact){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.address = address;
        this.relatives.addAll(relatives);
        this.personalMail = personalMail;
        this.workMail = workMail;
        this.contact = contact;
    }

    Person(String firstName, String lastName, String birth, String address, ArrayList<Relation> relatives, String personalMail, String workMail, ContactNumber contact){
        //this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.address = address;
        this.relatives.addAll(relatives);
        this.personalMail = personalMail;
        this.workMail = workMail;
        this.contact = contact;
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

    public String getBirth() {
        return birth;
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


    public void setRelatives(ArrayList<Relation> relatives) {
        this.relatives = relatives;
    }

    public ArrayList<Relation> getRelatives() {
        ArrayList<Relation> newRel = new ArrayList<>();
        for(Relation rel: SQLtoREST.relation){
            if (rel.ID==ID){
                newRel.add(rel);
            }
        }
        return newRel;
    }

    /*public ArrayList<Relation> getRelationships() {
        ArrayList<Relation> newRel = new ArrayList<>();
        for(Relation rel: SQLtoREST.relation){
            if (rel.ID==ID){
                newRel.add(rel);
            }
        }
        return newRel;
    }*/

    public void setPersonalMail(String personalMail) {
        this.personalMail = personalMail;
    }

    public String getPersonalMail(){
        return personalMail;
    }

    public void setWorkMail(String workMail) {
        this.workMail = workMail;
    }

    public String getWorkMail(){
        return workMail;
    }
}
