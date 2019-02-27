package no.experis.task17;

import org.springframework.web.bind.annotation.*;

@RestController
public class RelationController {

    @RequestMapping("/relation")
    public Relation relationFind(@RequestParam(value = "ID", defaultValue = "Meh") int ID) {
        System.out.println("Trying to find person: " + ID);
        Relation returnRelation = null;
        for (Relation rel : SQLtoREST.relation) {
            if (rel.ID.equals(ID)) {
                System.out.println(" --- RELATION --- ");
                returnRelation = rel;
            }
        }
        if (returnRelation == null) {
            System.out.println(" --- RELATION NOT FOUND --- ");
        }
        return returnRelation;
    }

    @GetMapping("/relation/{ID}")
    public Relation relationGet(@PathVariable int ID) {
        System.out.println("Trying to find relation: " + ID);
        Relation returnRelation = null;
        for (Relation rel : SQLtoREST.relation) {
            if (rel.ID.equals(ID)) {
                System.out.println(" --- RELATION FOUND --- ");
                returnRelation = rel;
            }
        }
        if (returnRelation == null) {
            System.out.println(" --- RELATION WAS NOT FOUND --- ");
        }
        return returnRelation;

    }
}
