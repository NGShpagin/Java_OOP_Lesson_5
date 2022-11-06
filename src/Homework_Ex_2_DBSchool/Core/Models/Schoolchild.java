package Homework_Ex_2_DBSchool.Core.Models;

public class Schoolchild extends Person{

    public Schoolchild(String lastName, String firstName, String middleName, String age) {
        super(lastName, firstName, middleName, age);
    }

    @Override
    public String toString() {
        return String.format("SchoolChild: %s %s %s, age: %s", lastName, firstName, middleName, age);
    }
}
