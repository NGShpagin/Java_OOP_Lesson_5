package Ex_3_Math.Client;


import Ex_3_Math.Core.Views.View;

import java.util.Scanner;

public class CosoleView implements View {
    Scanner in = new Scanner(System.in);

    public String get() {
        return in.next();
    };

    @Override
    public void set(String value) {
        System.out.println(value);
    }
}
