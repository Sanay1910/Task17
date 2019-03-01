package no.experis.task17;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicInteger.*;
import java.util.ArrayList;
import java.util.List;

import static no.experis.task17.SQLtoREST.*;


@RestController
public class Controller {
    AtomicInteger addrID = new AtomicInteger(SQLtoREST.address.size()+1);
    //AtomicInteger perID = new AtomicInteger(SQLtoREST.person.size()+1);

    static boolean first = true;
    //value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    @RequestMapping(value = "/person", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Person> personAll() {
        openConn();
        readPeople();
        openConn();
        readRelations();
        System.out.println("Trying to find all persons: ");
        List<Person> persons = new ArrayList<>();
        for(Person per : SQLtoREST.person){
            persons.add(per);
        }
        if (persons == null) {
            System.out.println(" --- NO PERSON FOUND --- ");
        }
        return persons;

    }

    @GetMapping("/address/{ID}")
    public Address addressGet(@PathVariable int ID) {
        openConn();
        readAddress();
        openConn();
        readPeople();
        System.out.println("Trying to find address: " + ID);
        Address returnAddress = null;
        Person returnPerson = null;
        Address addre = null;
        ArrayList<Person> persons = new ArrayList<>();
        for (Address addr : SQLtoREST.address) {
            if (addr.ID==(ID)) {
                System.out.println(" --- ADDRESS FOUND --- ");
                //returnAddress = addr;

            for (Person per : SQLtoREST.person) {
                if (addr.address.contains(per.address)) {
                    persons.add(per);
                }
            }
                returnAddress = new Address(addr.ID,persons, addr.address);
            }
        }

        if (returnAddress == null) {
            System.out.println(" --- ADDRESS WAS NOT FOUND --- ");
        }
        return returnAddress;

    }



    @RequestMapping(value = "/address", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Address> addressAll() {
        openConn();
        readAddress();
        System.out.println("Trying to find all addresses: ");
        List<Address> addresses = new ArrayList<>();
        for(Address addr : SQLtoREST.address){
            addresses.add(addr);
        }
        if (addresses == null) {
            System.out.println(" --- NO ADDRESS FOUND --- ");
        }
        return addresses;

    }

    /*@RequestMapping("/person")
    public Person personFind(@RequestParam(value = "ID", defaultValue = "Meh") int ID) {
        System.out.println("Trying to find person: " + ID);
        Person returnPerson = null;
        for (Person per : SQLtoREST.person) {
            if (per.ID==(ID)) {
                System.out.println(" --- PERSON --- ");
                returnPerson = per;
            }
        }
        if (returnPerson == null) {
            System.out.println(" --- PERSON NOT FOUND --- ");
        }
        return returnPerson;
    }
    */


    @PostMapping("/address")
    public Address newAddress(@RequestBody Address newAddress) {

        //newAddress.setID(nextId.incrementAndGet());
        Address a = new Address(addrID.incrementAndGet(), newAddress.persons,newAddress.address);
        System.out.println(" --- ADDRESS ADDED --- ");
        System.out.println(newAddress);
        return a;
    }

    @PostMapping("/person")
    public Person newPerson(@RequestBody Person per) {
        Insert insert = new Insert();
        int perID = SQLtoREST.person.size()+1;
        Person pers = new Person(perID, per.firstName,per.lastName,per.birth,per.address, per.relatives, per.personalMail,per.workMail, per.contact);

        int addressID = 0;

        boolean found = false;
        for(Address val: address){
            if(val.address.equals(pers.address)) {
                addressID = val.ID;
                found = true;
                break;
            }
        }
        if (!found){
            addressID = (SQLtoREST.address.size()+1);
            insert.homeAddress(addressID, pers.address);
        }

        for(Relation rel: pers.relatives){
            System.out.println(rel.toPersonID);
            System.out.println(translator(rel.relation));
            if(rel.toPersonID == pers.ID){
                System.out.println("testooo");
                System.out.println(pers.ID + " " + rel.toPersonID + " " +  translator(rel.relation));
                insert.relation(pers.ID,rel.toPersonID,translator(rel.relation));
                insert.relation(rel.toPersonID,pers.ID,translator(rel.relation));
            }
        }


        insert.contactNumber(pers.ID, per.contact.work, per.contact.home,per.contact.mobile);
        insert.person(pers.ID, pers.firstName,pers.lastName,pers.birth, addressID, pers.address,pers.personalMail,pers.workMail, pers.ID);

        System.out.println(" --- ADDRESS ADDED --- ");
        return pers;
    }

    public int translator(String relation){ String role = "";
        if("father".equals(relation.toLowerCase())){
            return 1;
        }else if("mother".equals(relation.toLowerCase())){
           return 2;
       }else if("son".equals(relation.toLowerCase())){
            return 3;
        }else if("daughter".equals(relation.toLowerCase())){
            return 4;
        }else if("sister".equals(relation.toLowerCase())){
            return 5;
        }else if("brother".equals(relation.toLowerCase())){
            return 6;
        }

       return 0;
    }

    @GetMapping("/person/{ID:[0-9]+}")
    public Person personGet(@PathVariable int ID) {
        System.out.println("Trying to find person: " + ID);
        Person returnPerson = null;
        for (Person per : SQLtoREST.person) {
            if (per.ID==(ID)) {
                System.out.println(" --- PERSON FOUND --- ");
                returnPerson = per;
            }
        }
        if (returnPerson == null) {
            System.out.println(" --- PERSON WAS NOT FOUND --- ");
        }
        return returnPerson;

    }

    @GetMapping("/person/{name:[a-zA-Z]+}")
    public Person personGetByName(@PathVariable String name) {
        System.out.println("Trying to find person: " + name);
        Person returnPerson = null;
        for (Person per : SQLtoREST.person) {
            if (per.firstName.equalsIgnoreCase(name) || per.lastName.equalsIgnoreCase(name)) {
                System.out.println(" --- PERSON FOUND --- ");
                returnPerson = per;
            }
        }
        if (returnPerson == null) {
            System.out.println(" --- PERSON WAS NOT FOUND --- ");
        }
        return returnPerson;

    }
}
