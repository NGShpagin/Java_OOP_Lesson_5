package Seminar_Ex_1_Messsenger;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    protected String id;
    protected String name;
    protected User creator;
    protected UserRole role;
    protected List<User> usersWriter;
    protected List<User> usersAdmin;
    protected List<User> usersReader;
    protected List<Message> msgHistory;
    protected static List<String> chatIds = new ArrayList<>();

    public Chat(String id, String name, User creator) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        usersWriter = new ArrayList<>();
        usersAdmin = new ArrayList<>();
        usersReader = new ArrayList<>();
        msgHistory = new ArrayList<>();
    }

    public StringBuilder getUsers() {
        int i = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Users in %s:\n", this));
        if (usersAdmin.size() > 0) {
            for (User user : usersAdmin) sb.append(String.format("%d. %s %s (Admin)\n", i++, user, id));
        }
        if (usersWriter.size() > 0) {
            for (User user : usersWriter) sb.append(String.format("%d. %s %s (Writer)\n", i++, user, id));
        }
        if (usersReader.size() > 0) {
            for (User user : usersReader) sb.append(String.format("%d. %s %s (Reader)\n", i++, user, id));
        }
        return sb;
    }

    public StringBuilder getMsgHistory() {
        StringBuilder sb = new StringBuilder();
        for (Message msg : msgHistory) {
            sb.append(String.format("\ndate: %s\nauthor: %s\ntext: %s\n", msg.date, msg.author, msg.text));
        }
        return sb;
    }


    @Override
    public String toString() {
        return String.format("%s (chatId %s)", name, id);
    }
}
