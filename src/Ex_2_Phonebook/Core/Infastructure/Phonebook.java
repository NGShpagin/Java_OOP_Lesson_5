package Ex_2_Phonebook.Core.Infastructure;

import Ex_2_Phonebook.Core.Models.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phonebook {
    private List<Contact> contacts;

    public Phonebook() {
        contacts = new ArrayList<Contact>();
    }

    // create
    public boolean add(Contact contact) {
        boolean flag = false;
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            flag = true;
        }
        return flag;
    }

    // read
    public Contact getContact(int index) {
        return contains(index) ? contacts.get(index) : null;
    }

    public Contact updateContact(int index, String param) {
        Contact myContact = contacts.get(index);
        if (param == "FirstName") myContact.firstName = (new Scanner(System.in)).nextLine();
        else if (param == "LastName") myContact.lastName = (new Scanner(System.in)).nextLine();
        else myContact.description = (new Scanner(System.in)).nextLine();
        return contains(index) ? contacts.get(index) : null;
    }

    //ToDo
    // update
    // ????

    // delete
    public boolean remove(Contact contact) {
        boolean flag = false;
        if (contacts.indexOf(contact) != -1) {
            contacts.remove(contact);
            flag = true;
        }
        return flag;
    }

    private boolean contains(int index) {
        return contacts != null && contacts.size() > index;
    }

    public List<Contact> getContacts() {
        // if ???
        return contacts;
    }

    public int count() {
        return contacts.size();
    }
}
