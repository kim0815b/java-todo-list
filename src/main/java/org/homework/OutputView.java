package org.homework;

public class OutputView {
    public static void outPutChoiceMenu() {
        System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
    }
    public static void outPutAddTodo(int id) {
        System.out.println("할 일이 추가되었습니다. ID: ["+id+"]");
    }
    public static void outPutDeleteTodo(int id) {
        System.out.println("할 일이 삭제되었습니다. ID: ["+id+"]");
    }
    public static void outPutSelectTodo(Todo todo) {
        System.out.println("할 일 ID: ["+todo.getId()+"] 내용: ["+todo.getContent()+"]");
    }
    public static void outPutTodoNull() {
        System.out.println("해당 ID의 할 일이 없습니다.");
    }
    public static void outPutFinishProgram() {
        System.out.println("프로그램을 종료합니다.");
    }
}
