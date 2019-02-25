public class Task17 {
    public static void main(String [] args) {
        Create create = new Create();
        Insert insert = new Insert();
        Select select = new Select();
        Update update = new Update();

        //create.newDatabase("people.sqlite");


        //create.personTable();
        //create.homeAddress();
        //create.contactNumber();

        //insert.person(1, "Bartek", "Gembala", "1993", 2, "Adrian", "test1","test2",1);
        //insert.person(2, "Sanay", "Oo", "1995", 1, "Sanoy2", "noe@mail","work@mail", 2);
        //insert.person(3, "Philipee", "Boii", "1994", 1, "Minilipee", "boii@mail","workboii@mail", 3);


        //insert.insertPerson(1,"Sanay", "Oo", "191096", "Grorud", "Pappa", "person@person", "experis@experis", 1);
        //insert.insertContact(1, "123", "456", "789");

        select.person();
        select.contactNumber();

        //update.updatePerson(1,"Sanay", "Moe", "101095", "Vika", "Mamma", "pe@pe", "ex@ex", 1);


    }


}
