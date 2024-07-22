package org.homework;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class OutputView {
    public void outPutAddTodo(int id) {
        System.out.println("할 일이 추가되었습니다. ID: ["+id+"]");
    }

    public void outPutDeleteTodo(boolean isDelete, int id) {
        if (isDelete) {
            System.out.println("할 일이 삭제되었습니다. ID: [" + id + "]");
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }
    public void outPutSelectTodo(Todo todo) {
        System.out.println("할 일 ID: ["+todo.getId()+"] 내용: ["+todo.getContent()+"]");
    }
    public void outPutFinishProgram() {
        System.out.println("프로그램을 종료합니다.");
    }
    public void outPutError() {
        System.out.println("다시 입력해주세요.");
    }

    //
//    public static void outPutTodoAll(Map<Integer, Todo> todoMap) {
//        System.out.println("ID \t\t내용 \t\t\t상태\t\t마감일");
//        System.out.println("----------------------------------------------");
//        todoMap.values()
//                .stream()
//                .sorted(Comparator.comparing(Todo::getEndDate).reversed())
//                .forEach(System.out ::println);
//    }
    public void outPutTodoAll(Collection<Todo> todoCollection) {
        System.out.println("ID \t\t내용 \t\t\t상태\t\t마감일");
        System.out.println("----------------------------------------------");
        todoCollection.stream()
                .sorted(Comparator.comparing(Todo::getEndDate).reversed())
                .forEach(System.out::println);
    }
}
