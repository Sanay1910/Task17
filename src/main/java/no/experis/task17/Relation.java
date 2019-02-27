package no.experis.task17;

public class Relation {
    String ID, relativeName, relation;

    Relation(String ID, String relation, String relativeName){
        this.ID = ID;
        this.relation = relation;
        this.relativeName = relativeName;
    }

    //public String getID(){
    //    return ID;
    //}

    public String getRelation(){
        return relation;
    }

    public String getRelativeName(){
        return relativeName;
    }
}
