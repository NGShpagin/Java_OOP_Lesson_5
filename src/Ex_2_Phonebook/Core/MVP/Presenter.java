package Ex_2_Phonebook.Core.MVP;

import Ex_2_Phonebook.Core.Models.Contact;
import Ex_2_Phonebook.UI.App;

import java.io.IOException;
import java.util.Scanner;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(View view, String pathOb) {
        this.view = view;
        model = new Model(pathOb);
    }

    public void LoadFromFile() {
        model.load();

        if (model.currentBook().count() > 0) {
            model.setCurrentIndex(0);
            var contact = model.currentContact();

            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setDescription(contact.description);
        }
    }

    public void add() {
        model.currentBook().add(
                new Contact(view.getFirstName(), view.getLastName(), view.getDescription()));
    }

    public void update() {
        System.out.print("\033[H\033[J");
        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.println("1 - FirstName\n2 - LastName\n3 - Description\n4 - Previous menu");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        model.currentBook().updateContact(model.getCurrentIndex(), "FirstName");
//                        view.setFirstName(view.getFirstName());
                        break;
                    case "2":
                        model.currentBook().updateContact(model.getCurrentIndex(), "LastName");
                        break;
                    case "3":
                        model.currentBook().updateContact(model.getCurrentIndex(), "Description");
                        break;
                    case "4":
                        App.ButtonClick();
                        break;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }
    }

    public void remove() {
        Contact contact = new Contact(view.getFirstName(), view.getLastName(), view.getDescription());
        model.currentBook().remove(contact);

        if (model.currentBook().count() < 1) {
            model.setCurrentIndex(-1);
            view.setFirstName("");
            view.setLastName("");
            view.setDescription("");
        } else {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            if (model.getCurrentIndex() < 0)
                model.setCurrentIndex(0);

            Contact temp = model.currentContact();
            view.setFirstName(temp.firstName);
            view.setLastName(temp.lastName);
            view.setDescription(temp.description);
        }
    }

    public void saveToFile() throws IOException {
        model.save();
    }

    public void next() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() + 1 < model.currentBook().count()) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                Contact contact = model.currentContact();
                view.setFirstName(contact.firstName);
                view.setLastName(contact.lastName);
                view.setDescription(contact.description);
            } else {
                model.setCurrentIndex(0);
                Contact contact = model.currentContact();
                view.setFirstName(contact.firstName);
                view.setLastName(contact.lastName);
                view.setDescription(contact.description);
            }
        }
    }

    public void prev() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                Contact contact = model.currentContact();
                view.setFirstName(contact.firstName);
                view.setLastName(contact.lastName);
                view.setDescription(contact.description);
            } else {
                model.setCurrentIndex(model.currentBook.count()-1);
                Contact contact = model.currentContact();
                view.setFirstName(contact.firstName);
                view.setLastName(contact.lastName);
                view.setDescription(contact.description);
            }
        }
    }
}
