package org.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> todoMap = new HashMap<>();
        int todo_seq = 0;
        System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
        Scanner scanner = new Scanner(System.in);

        int todoNum;
        while (true) {
            int num = Integer.parseInt(scanner.nextLine());
            switch (num) {
                case 1:
                    String todo = scanner.nextLine();
                    todoMap.put(++todo_seq, todo);
                    System.out.println("할 일이 추가되었습니다. ID: ["+todo_seq+"]");
                    break;
                case 2:
                    todoNum = Integer.parseInt(scanner.nextLine());
                    if (todoMap.get(todoNum) != null) {
                        todoMap.remove(todoNum);
                        System.out.println("할 일이 삭제되었습니다. ID: ["+todoNum+"]");
                    } else {
                        System.out.println("해당 ID의 할 일이 없습니다.");
                    }
                    break;
                case 3:
                    todoNum = Integer.parseInt(scanner.nextLine());
                    if (todoMap.get(todoNum) != null) {
                        System.out.println("할 일 ID: [" + todoNum + "] 내용: [" + todoMap.get(todoNum) + "]" );
                    } else {
                        System.out.println("해당 ID의 할 일이 없습니다.");
                    }
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    return;
            }
        }
    }
}