package no.experis.task17;

public class Relation {
    String relativeName, relation;
    int ID, fromPersonID, toPersonID;

    Relation(){

    }

    Relation(int ID, String relation, String relativeName){
        this.ID = ID;
        this.relation = relation;
        this.relativeName = relativeName;
    }

    Relation(int toPersonID, String relation){
        this.toPersonID = toPersonID;
        this.relation = relation;
    }

    /*public String getID(){
        return ID;
    }*/

    public void setToPersonID(int toPersonID) {
        this.toPersonID = toPersonID;
    }

    /*public int getToPersonID() {
        return toPersonID;
    }*/

    /*public void setRelation(String relation) {
        this.relation = relation;
    }*/

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRelation(){
        return relation;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getRelativeName(){
        return relativeName;
    }
}
