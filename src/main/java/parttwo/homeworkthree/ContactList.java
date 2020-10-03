package parttwo.homeworkthree;

import java.util.ArrayList;
import java.util.List;

public class ContactList {

    List<Contact> phoneBook = new ArrayList<>();


    public void add(long number,String name){
        phoneBook.add(new Contact(number,name));
    }

    public ArrayList<Long> get(String name){
        ArrayList<Contact> contactsFound = new ArrayList<>();
        for (Contact c: phoneBook
             ) {
            if(c.getName() == name){
                contactsFound.add(c);
            }
        }
        ArrayList<Long> numbers = new ArrayList<>();
        for (Contact c: contactsFound
             ) {
            numbers.add(c.getNumber());
        }
        return numbers;
    }


}
