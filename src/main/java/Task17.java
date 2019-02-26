
public class task17 {
    public static void main(String[] args) {
        //createNewDatabase("people.sqlite");
        //createNewTable();
        Create create = new Create();
        Insert insert = new Insert();
        Select select = new Select();
        Delete delete = new Delete();
        Update update = new Update();
        Menu run = new Menu();
        //run.menu(select);

        //create.relation();

        select.relatives();

        //create.relationType();
        //create.newDatabase("people.sqlite");

        /*
        insert.relationType("Father");
        insert.relationType("Mother");
        insert.relationType("Son");
        insert.relationType("Daughter");
        insert.relationType("Sister");
        insert.relationType("Brother");

        insert.relation(1, 2, 1);
        insert.relation(1, 3, 2);
        insert.relation(2, 1, 3);
        insert.relation(3, 1, 3);
        */

        /*
        create.person();
        create.homeAddress();
        create.contactNumber();
        */

        /*
        insert.person(1, "Bartek", "Gembala", "1993", 2, "Adrian", "test1","test2",1);
        insert.person(2, "Sanay", "Oo", "1995", 1, "Sanoy2", "noe@mail","work@mail", 2);
        insert.person(3, "Philipee", "Boii", "1994", 1, "Minilipee", "boii@mail","workboii@mail", 3);
        */


        /*
        insert.contactNumber(1, "32534534","4323423","87765748");
        insert.contactNumber(2, "11112321","11123123","989898989");
        insert.contactNumber(3, "5555555","5555666","7777778");
        */

        /*
        insert.homeAddress(2, "Oslo");
        insert.homeAddress(1, "Bergen");
        insert.homeAddress(3, "Talulu");
        */
        //select.person();
        //select.personAll();

    }
}

