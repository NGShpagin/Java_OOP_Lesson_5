package Homework_Ex_2_DBSchool.Core.Models;

import java.util.Objects;

public class Person {
    public String firstName;
    public String middleName;
    public String lastName;
    public String age;

    public Person(String lastName, String firstName, String middleName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        Person t = (Person) obj;
        return Objects.equals(this.firstName, t.firstName)
                && Objects.equals(this.lastName, t.lastName)
                && Objects.equals(this.middleName, t.middleName);
    }
}
