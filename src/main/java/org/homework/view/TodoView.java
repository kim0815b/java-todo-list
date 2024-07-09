package org.homework.view;

import org.homework.controller.TodoController;
import org.homework.dto.Todo;
import org.homework.repository.TodoRepository;

import java.util.Scanner;

public class TodoView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TodoController todoController;
        while (true) {
            System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
            int num = Integer.parseInt(sc.nextLine());
            switch (num) {
                case 1:
                    setTodo();
                    break;
                case 2:
                    deleteTodo();
                    break;
                case 3:
                    getTodo();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    return;
            }
        }
    }

    private static void setTodo() {
        Scanner sc = new Scanner(System.in);
        TodoController todoController = new TodoController();
        String todoString = sc.nextLine();
        Todo todo = new Todo(todoString);
        Todo todo1 = todoController.setTodo(todo);
        System.out.println("할 일이 추가되었습니다. ID: [" + todo1.getTodoNum() + "]");
        sc.close();
    }

    private static void getTodo() {
        Scanner sc = new Scanner(System.in);
        TodoController todoController = new TodoController();
        int num = Integer.parseInt(sc.nextLine());
        Todo todo = todoController.getTodo(num);
        if (todo != null) {
            System.out.println("할 일 ID: [" + todo.getTodoNum() + "] 내용: [" + todo.getTodoString() + "]" );
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
        sc.close();
    }

    private static void deleteTodo() {
        Scanner sc = new Scanner(System.in);
        TodoController todoController = new TodoController();
        int num = Integer.parseInt(sc.nextLine());
        if (todoController.deleteTodo(num)) {
            System.out.println("할 일이 삭제되었습니다. ID: [" + num + "]");
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }
}
