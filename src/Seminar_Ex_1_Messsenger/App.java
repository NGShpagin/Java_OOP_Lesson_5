package Seminar_Ex_1_Messsenger;

/*
ООП-проектирование.

Описать в ООП-подходе "мессенджер" в котором могут переписываться пользователи.
 */

public class App {
    public static void main(String[] args) {
        //#region Create app
        Application app1 = new Application("Messenger");
        //#endregion

        //#region Create users
        User user1 = app1.createPremiumUser("user1");
        System.out.printf("User1: %s\n", user1);

        User user2 = app1.createStandartUser("user2");
        System.out.printf("User2: %s\n", user2);

        User user3 = app1.createStandartUser("user3");
        System.out.printf("User3: %s\n", user3);
        //#endregion

        //#region Create Chat
        Chat chat1 = user1.createChat("Chat1");
        System.out.println(chat1.getUsers());

        Chat chat2 = user2.createChat("Chat2");
        //#endregion

        //#region Add User in Chat
        user1.addUser(user2, chat1, UserRole.WRITER);
        user1.addUser(user3, chat1, UserRole.WRITER);
        System.out.println(chat1.getUsers());

        user2.addUser(user3, chat2, UserRole.WRITER);
        System.out.println(chat2.getUsers());
        //#endregion

        //#region Delete User from Chat (only Chat author)
        user1.deleteUser(user3, chat1);
        System.out.println(chat1.getUsers());
        //#endregion

        //#region Send Msg in Chat & Read
        user1.sendMsg(chat1, "Hello world");
        user2.sendMsg(chat1, "Hello, my dear friend");
        user1.readChat(chat1);
        //#endregion

        //#region ChatHistory
        System.out.println(chat1.getMsgHistory());
        //#endregion

        //#region Application Chatlist
        System.out.println(app1.getAppChats());
        //#endregion




    }
}
