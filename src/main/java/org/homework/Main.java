package org.homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        start().run();
    }

    public static TodoController start() {
        return new TodoController(
                new TodoService(
                        new TodoRepository()),
                new InputView(),
                new OutputView()
        );
    }
}