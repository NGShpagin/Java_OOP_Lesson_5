package Homework_Ex_2_DBSchool.UI;

import Homework_Ex_2_DBSchool.Config;
import Homework_Ex_2_DBSchool.Core.MVP.Presenter;
import Homework_Ex_2_DBSchool.Core.MVP.View;

import java.util.Scanner;

public class App {
    public static void ButtonClick() {
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, Config.classPath, Config.teacherPath, Config.studentPath);

        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println("1 - ClassList\n2 - TeacherList\n3 - addTeacher\n4 - addScoolChild\n5 - addClass\n0 - exit");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
//                        System.out.print("\033[H\033[J");
                        presenter.loadFromFileClass();
                        try (Scanner in2 = new Scanner(System.in)) {
                            while (true) {
                                System.out.println("1 - prev\n2 - next\n3 - prevMenu\n0 - exit");
                                String key1 = in.next();
                                System.out.print("\033[H\033[J");
                                switch (key1) {
                                    case "1" -> presenter.prevClass();
                                    case "2" -> presenter.nextClass();
                                    case "3" -> ButtonClick();
                                    case "0" -> {
                                        return;
                                    }
                                    default -> System.out.println("Такой команды нет");
                                }
                            }
                        }
                    case "2":
//                        System.out.print("\033[H\033[J");
                        presenter.loadFromFileTeacher();
                        try (Scanner in2 = new Scanner(System.in)) {
                            while (true) {
                                System.out.println("1 - prev\n2 - next\n3 - prevMenu\n0 - exit");
                                String key2 = in.next();
                                System.out.print("\033[H\033[J");
                                switch (key2) {
                                    case "1" -> presenter.prevTeacher();
                                    case "2" -> presenter.nextTeacher();
                                    case "3" -> ButtonClick();
                                    case "0" -> {
                                        return;
                                    }
                                    default -> System.out.println("Такой команды нет");
                                }
                            }
                        }
                    case "3":
                        presenter.addTeacher();
                        break;
                    case "4":
                        System.out.println("Wil be added later...");
                        break;
                    case "5":
                        presenter.addClass();
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }
    }
}
