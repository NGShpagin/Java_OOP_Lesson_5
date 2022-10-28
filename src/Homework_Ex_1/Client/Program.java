package Homework_Ex_1.Client;

import Homework_Ex_1.Presenter;
import Homework_Ex_1.View;

public class Program {
    public static void main(String[] args) throws Exception {
        Presenter p = new Presenter(new View());
        p.getOperand();
        p.clickButton();
        p.getOperand();
        p.clickButton();
        p.getOperand();
        p.clickButton();
        p.getOperand();
        p.clickButton();
        p.getOperand();
        p.clickButton();
    }
}
