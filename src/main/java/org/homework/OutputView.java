package org.homework;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

public class OutputView {
    public static void outPutChoiceMenu() {
        System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 번호 조회, 4. 조회, 5.검색, 5.종료");
    }
    public static void outPutAddEndDate(){
        System.out.println("마감일을 입력해주세요 ex) YYYYMMDD");
    }
    public static void outPutAddTodo(int id) {
        System.out.println("할 일이 추가되었습니다. ID: ["+id+"]");
    }
    public static void outPutDeleteTodo(int id) {
        System.out.println("할 일이 삭제되었습니다. ID: ["+id+"]");
    }
    public static void outPutSelectNum() {
        System.out.println("검색할 번호를 입력해주세요");
    }
    public static void outPutSelectTodo(Todo todo) {
        System.out.println("할 일 ID: ["+todo.getId()+"] 내용: ["+todo.getContent()+"]");
    }
    public static void outPutTodoIfNull() {
        System.out.println("해당 ID의 할 일이 없습니다.");
    }
    public static void outPutFinishProgram() {
        System.out.println("프로그램을 종료합니다.");
    }
    public static void outPutSearchContent() {
        System.out.println("검색어를 입력해주세요");
    }
    public static void outPutError() {
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
    public static void outPutTodoAll(Collection<Todo> todoCollection) {
        System.out.println("ID \t\t내용 \t\t\t상태\t\t마감일");
        System.out.println("----------------------------------------------");
        todoCollection.stream()
                .sorted(Comparator.comparing(Todo::getEndDate).reversed())
                .forEach(System.out ::println);
    }
}
