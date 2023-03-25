package phonebook;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Phonebook myPhonebook = new Phonebook(new ArrayList<>());

        myPhonebook.addNewNote("Alex", "+380673321234");
        myPhonebook.addNewNote("Tom", "+380952243256");
        myPhonebook.addNewNote("Ed", "+380671232233");
        myPhonebook.addNewNote("Alex", "+380675507090");

        System.out.println(myPhonebook);
        System.out.println(myPhonebook.findAll("Alex"));

    }
}
