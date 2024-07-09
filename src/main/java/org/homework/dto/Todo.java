package org.homework.dto;



public class Todo {
    private int todoNum;
    private String TodoString;
    public Todo() {
    }
    public Todo(String todoString) {
        TodoString = todoString;
    }

    public Todo(int todoNum, String todoString) {
        this.todoNum = todoNum;
        TodoString = todoString;
    }

    public int getTodoNum() {
        return todoNum;
    }

    public void setTodoNum(int todoNum) {
        this.todoNum = todoNum;
    }

    public String getTodoString() {
        return TodoString;
    }

    public void setTodoString(String todoString) {
        TodoString = todoString;
    }

}
