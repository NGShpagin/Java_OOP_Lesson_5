package Seminar_Ex_1_Messsenger;

import java.util.ArrayList;
import java.util.List;

abstract class User implements CreateId {
    protected String id;
    private final String nickname;
    protected static List<Chat> userChats;
    protected List<Message> notReadMessage;

    protected User(String id, String nickname) {
        this.id = id;
        this.nickname = nickname;
        userChats = new ArrayList<>();
        notReadMessage = new ArrayList<>();
    }

    public Chat createChat(String chatName) {
        String id = createId(Chat.chatIds, "ch_1");
        Chat.chatIds.add(id);
        Chat chat = new Chat(id, chatName, this);
        userChats.add(chat);
        Application.chats.add(chat);
        chat.usersAdmin.add(this);
        chat.creator = this;
        System.out.printf("%s is created by %s\n", chat, this);
        return chat;
    }

    public void readChat(Chat chat) {
        if (!notReadMessage.isEmpty()) {
            notReadMessage.clear();
            System.out.printf("Messages in %s are read by %s\n", chat, this);
        }
    }

    public void addUser(User user, Chat chat, UserRole role) {
        if (role == UserRole.READER) chat.usersReader.add(user);
        else if (role == UserRole.WRITER) chat.usersWriter.add(user);
        else chat.usersAdmin.add(user);
        System.out.printf("%s with role '%s' is added in %s by %s\n", user, role, chat, this);
    }

    //TODO
    public void deleteUser(User user, Chat chat) {
        if (userChats.contains(chat)
                && (chat.creator == this || chat.usersAdmin.contains(user))
                && this != user) {
            if (chat.usersReader.contains(user)) {
                for (int i = 0; i < chat.usersReader.size(); i++) {
                    if (chat.usersReader.get(i) == user) chat.usersReader.remove(i);
                }
            }
            else if (chat.usersWriter.contains(user)) {
                for (int i = 0; i < chat.usersWriter.size(); i++) {
                    if (chat.usersWriter.get(i) == user) chat.usersWriter.remove(i);
                }
            }
            else {
                for (int i = 0; i < chat.usersAdmin.size(); i++) {
                    if (chat.usersAdmin.get(i) == user) chat.usersAdmin.remove(i);
                }
            }
            System.out.printf("%s is deleted from %s\n", user, chat);
        } else if (!userChats.contains(chat)) System.out.println("You don't have this chat");
        else System.out.println("You are not the creator of this Chat");
    }

    public void sendMsg(Chat chat, String text) {
        if (chat.usersAdmin.contains(this) || chat.usersWriter.contains(this)) {
            this.readChat(chat);
            Message msg = new Message(text, this);
            chat.msgHistory.add(msg);
            for (User user: chat.usersAdmin) if (user != this) user.notReadMessage.add(msg);
            for (User user: chat.usersWriter) if (user != this) user.notReadMessage.add(msg);
            for (User user: chat.usersReader) if (user != this) user.notReadMessage.add(msg);
            System.out.printf("(%s) %s: %s\n", chat, this, text);
        } else if (chat.usersReader.contains(this))
            System.out.printf("%s with role 'Reader' can't send msg in %s\n", this, chat);
        else System.out.printf("%s doesn't have access to %s\n", this, chat);

    }

    @Override
    public String toString() {
        return String.format("%s (UserId %s)", nickname, id);
    }
}
