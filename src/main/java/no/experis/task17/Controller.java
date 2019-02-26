package no.experis.task17;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

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
