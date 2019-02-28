package no.experis.task17;

import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
public class Controller {

    private ArrayList<Person> persons = new ArrayList<>();
    private AtomicInteger nextId = new AtomicInteger(SQLtoREST.person.size());
    Insert insert = new Insert();
    private AtomicInteger nextAddressId = new AtomicInteger(SQLtoREST.address.size())

    @RequestMapping("/person")
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

   /* @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        Person addPerson = null;
        insert.person2(person.ID, person.firstName, person.lastName, person.birth, person.address );
        return person;
    } */

    @PostMapping("/person")
    public Person newPerson(@RequestBody Person newPerson) {
        //person.setID(nextId.incrementAndGet());
        //persons.add(person);
        //return person;
        newPerson.setID(nextId.incrementAndGet());



            //newPerson.ID);
            //per.setFirstName(newPerson.firstName);
            //per.setLastName(newPerson.lastName);
            //per.setBirth(newPerson.birth);
            //per.firstName = newPerson.firstName;
            //per.lastName = newPerson.lastName;
            //per.birth = newPerson.birth;
            //per.address = newPerson.address;
            //per.setID(nextId.incrementAndGet());
            insert.person2(newPerson.ID, newPerson.firstName, newPerson.lastName, newPerson.birth);

        System.out.println(" --- PERSON ADDED --- ");
        return newPerson;
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
