package org.homework;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static Menu inputMenu() {
        return Menu.get(Integer.parseInt(sc.nextLine()));
    }

    public static int inputNum() {
        return Integer.parseInt(sc.nextLine());
    }

    public static String inputContent() {
        return sc.nextLine();
    }

}
