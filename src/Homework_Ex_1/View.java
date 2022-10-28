package Homework_Ex_1;

import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);

    String getOperand() {
        return in.next();
    }

    ComplexNum getValue() {
        ComplexNum c = new ComplexNum();
        System.out.print("Введите целую часть ");
        c.setReal(in.nextDouble());
        System.out.print("Введите мнимую часть ");
        c.setImage(in.nextDouble());
        return c;
    }

    String print(String title, ComplexNum result) {
        StringBuilder sb = new StringBuilder();
        if (result.getImage() >= 0)
            sb.append(String.format("%s%.2f+%.2fi", title, result.getReal(), result.getImage()));
        else
            sb.append(String.format("%s%.2f %.2fi", title, result.getReal(), result.getImage()));
        return sb.toString();
    }

    String viewMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("+ - / *");
        return sb.toString();
    }
}
