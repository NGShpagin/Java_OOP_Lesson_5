package Ex_2_Phonebook.Core.Models;

import java.time.LocalDate;

public class Contact implements Comparable<Contact> {
    public LocalDate date;
    public String firstName;
    public String lastName;
    public String company;
    public String phone;

    //ToDo
    // public Email email;
    // public String email;
    public String description;

    public Contact(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    // ToDo
    // Добавить возможность создания объектов с большим количеством параметров

    @Override
    public int compareTo(Contact o) {
        // ???
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        Contact t = (Contact) obj;
        return this.firstName == t.firstName
                && this.lastName == t.lastName;
    }
}