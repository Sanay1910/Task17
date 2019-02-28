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

@RestController
public class Controller {
    AtomicInteger addrID = new AtomicInteger(SQLtoREST.address.size());
    AtomicInteger perID = new AtomicInteger(SQLtoREST.person.size());

    static boolean first = true;
    //value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    @RequestMapping(value = "/person", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Person> personAll() {
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

  /*  @GetMapping("/address/{ID}")
    public Address addressGet(@PathVariable int ID) {
        System.out.println("Trying to find address: " + ID);
        Address returnAddress = null;
        for (Address addr : SQLtoREST.address) {
            if (addr.ID==(ID)) {
                System.out.println(" --- ADDRESS FOUND --- ");
                returnAddress = addr;
            }
        }
        if (returnAddress == null) {
            System.out.println(" --- ADDRESS WAS NOT FOUND --- ");
        }
        return returnAddress;

    } */

    @GetMapping("/address/{ID}")
    public Address addressGet(@PathVariable int ID) {
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

        //newAddress.setID(nextId.incrementAndGet());
        //int ID, String firstName, String lastName,String birth, String address,
        // ContactNumber contact,String personalMail, String workMail, ArrayList<Relation> relation
        Person pers = new Person(perID.incrementAndGet(), per.firstName,per.lastName,per.birth,per.address,per.personalMail,per.workMail, per.contact,per.relation);
        System.out.println(" --- ADDRESS ADDED --- ");
        System.out.println(pers);
        return pers;
    }

    @GetMapping("/person/{ID}")
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
}
