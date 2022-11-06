package Homework_Ex_2_DBSchool.Core.Models;

public class Teacher extends Person {

    public Teacher(String lastName, String firstName, String middleName, String age) {
        super(lastName, firstName, middleName, age);
    }

    @Override
    public String toString() {
        return String.format("Teacher: %s %s %s, age: %s\n", lastName, firstName, middleName, age);
    }
}
