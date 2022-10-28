package Seminar_Ex_1_Messsenger;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Message {
    String text;
    User author;
    Date date;

    public Message(String text, User author) {
        this.text = text;
        this.author = author;
        date = (new GregorianCalendar()).getTime();
    }

}
