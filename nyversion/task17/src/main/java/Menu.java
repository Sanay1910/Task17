import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public void menu(Select select){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Choose option: ");
        System.out.println("1: SELECT <columns> FROM Person");

        int option = sc.nextInt();

        switch (option) {
            case 1:
                ArrayList<String> personSelect = new ArrayList();
                //id, firstname, lastname, birth, address, relatives, personalmail, workmail
                personSelect.add("person.ID");
                personSelect.add("FirstName");
                personSelect.add("LastName");
                personSelect.add("Birth");
                personSelect.add("Address");
                personSelect.add("Relatives");
                personSelect.add("PersonalMail");
                personSelect.add("WorkMail");
                personSelect.add("ContactNumber.Work");
                personSelect.add("ContactNumber.Home");
                personSelect.add("ContactNumber.Mobile");

                System.out.println("What do you want to select: <opt1> <opt2> .. <optn>");
                sc = new Scanner(System.in);

                int cnt = 0;
                for(String sel: personSelect){
                    ++cnt;
                    System.out.println(cnt + ": " + sel);
                }
                String input = sc.nextLine();
                String[] choices = input.split(" ");

                select.personColumns(choices, personSelect);
                break;

            case 2:
                break;
        }
    }
}
