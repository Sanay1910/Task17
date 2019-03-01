package no.experis.task17;

import java.util.ArrayList;

public class Address {
    int ID, addressID, personID;
    String address, person;
    ArrayList<Person> persons = new ArrayList<>();

    Address(){

    }

    Address(int ID,  String address){
        this.ID = ID;
        this.address = address;
    }

    Address(String address, ArrayList<Person> persons){
        this.address = address;
        this.persons.addAll(persons);

    }

    Address(int ID, ArrayList<Person> persons, String address){
        this.ID = ID;
        this.address = address;
        this.persons.addAll(persons);

    }

    Address(int addressID, int personID, String address){
        this.addressID = addressID;
        this.personID = personID;
        this.address = address;
    }


    public ArrayList<Person> getPersons() {
        return persons;
    }

    /*public int getAddressID() {
        return addressID;
    }*/

        public void setID(int ID){
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }


}
