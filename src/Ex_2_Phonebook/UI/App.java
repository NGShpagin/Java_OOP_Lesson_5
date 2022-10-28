package Ex_2_Phonebook.UI;

import Ex_2_Phonebook.Config;
import Ex_2_Phonebook.Core.MVP.Presenter;
import Ex_2_Phonebook.Core.MVP.View;

import java.util.Scanner;

public class App {
    public static void ButtonClick() {
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new NewConsoleView();
        Presenter presenter = new Presenter(view, Config.pathDb);
        presenter.LoadFromFile();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.println("1 - prev\n2 - next\n3 - update\n4 - add\n5 - remove\n0 - exit");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.prev();
                        break;
                    case "2":
                        presenter.next();
                        break;
                    case "3":
                        presenter.update();
                        break;
                    case "4":
                        presenter.add();
                        break;
                    case "5":
                        presenter.remove();
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
