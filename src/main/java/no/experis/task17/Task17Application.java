package no.experis.task17;

import org.springframework.boot.SpringApplication;

import static no.experis.task17.SQLtoREST.openConn;
import static no.experis.task17.SQLtoREST.readPeople;

public class Task17Application {

	public static void main(String[] args) {
		//SpringApplication.run(Task17Application.class, args);

		//SpringApplication.run(task17.class, args);

		//createNewDatabase("people.sqlite");
		//createNewTable();
		//Menu run = new Menu();

		//run.menu(select);
		//Task17Application t = new Task17Application();
		//t.test();


		//select.person();
		//select.personAll();

		openConn();
		readPeople();
		Select select = new Select();

		//select.person();
		//select.relatives();

		select.relatives2();

		SpringApplication.run(SQLtoREST.class, args);
	}

	public void test(){
		Create create = new Create();
		Insert insert = new Insert();
		Select select = new Select();
		Delete delete = new Delete();
		Update update = new Update();

		create.newDatabase("people.sqlite");
		create.relation();
		create.relationType();
		create.person();
		create.homeAddress();
		create.contactNumber();

		//select.relatives();

		//SpringApplication.run(task17.class, args);


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


		insert.person(1, "Bartek", "Gembala", "1993", 2, "Adrian", "test1","test2",1);
		insert.person(2, "Sanay", "Oo", "1995", 1, "Sanoy2", "noe@mail","work@mail", 2);
		insert.person(3, "Philipee", "Boii", "1994", 1, "Minilipee", "boii@mail","workboii@mail", 3);


		insert.contactNumber(1, "32534534","4323423","87765748");
		insert.contactNumber(2, "11112321","11123123","989898989");
		insert.contactNumber(3, "5555555","5555666","7777778");

		insert.homeAddress(2, "Oslo");
		insert.homeAddress(1, "Bergen");
		insert.homeAddress(3, "Talulu");

	}

}
