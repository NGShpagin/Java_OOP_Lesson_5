package Homework_Ex_2_DBSchool.UI;

import Homework_Ex_2_DBSchool.Core.MVP.View;

import java.util.Scanner;

public class ConsoleView implements View {

    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public String getClassNumber() {
        System.out.println("ClassNumber: ");
        return in.nextLine();
    }

    @Override
    public void setClassNumber(String value) {
        System.out.printf("ClassNumber: %s\n", value);
    }

    @Override
    public String getClassLetter() {
        System.out.println("ClassLetter: ");
        return in.nextLine();
    }

    @Override
    public void setClassLetter(String value) {
        System.out.printf("ClassLetter: %s\n", value);
    }

    @Override
    public String getFirstName() {
        System.out.println("FirstName: ");
        return in.nextLine();
    }

    @Override
    public void setFirstName(String value) {
        System.out.printf("FirstName: %s\n", value);
    }

    @Override
    public String getMiddleName() {
        System.out.println("MiddleName: ");
        return in.nextLine();
    }

    @Override
    public void setMiddleName(String value) {
        System.out.printf("MiddleName: %s\n", value);
    }

    @Override
    public String getLastName() {
        System.out.println("LastName: ");
        return in.nextLine();
    }

    @Override
    public void setLastName(String value) {
        System.out.printf("LastName: %s\n", value);
    }

    @Override
    public String getAge() {
        System.out.println("Age: ");
        return in.nextLine();
    }

    @Override
    public void setAge(String value) {
        System.out.printf("Age: %s\n", value);
    }
}
