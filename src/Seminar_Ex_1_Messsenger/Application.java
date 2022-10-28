package Seminar_Ex_1_Messsenger;

import java.util.ArrayList;
import java.util.List;

public class Application implements CreateId {
    protected String name;
    public static List<Chat> chats;
    public static List<User> users;
    private static List<String> standartIds;
    private static List<String> premiumIds;

    public Application(String name) {
        this.name = name;
        chats = new ArrayList<>();
        users = new ArrayList<>();
        standartIds = new ArrayList<>();
        premiumIds = new ArrayList<>();
    }

    public User createStandartUser(String nickname) {
        String id = createId(standartIds, "stUs_1");
        standartIds.add(id);
        User user = new StandartUser(id, nickname);
        users.add(user);
        return user;
    }

    public User createPremiumUser(String nickname) {
        String id = createId(premiumIds, "prUs_1");
        premiumIds.add(id);
        User user = new PremiumUser(id, nickname);
        users.add(user);
        return user;
    }

    public StringBuilder getAppChats() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Chat chat: chats) {
            sb.append(String.format("\n%d. Chat %s, creator %s", i, chat, chat.creator));
        }
        return sb;
    }

}
