package org.homework.repository;

import org.homework.dto.Todo;

import java.util.HashMap;
import java.util.Map;

public class TodoRepository {
    private final Map<Integer,Todo> todoMap = new HashMap<>();
    private int todo_seq = 0;

    public Todo getTodo(int todoNum) {
        return todoMap.get(todoNum);
    }
    public int setTodo(Todo todo) {
        todo.setTodoNum(++todo_seq);
        todoMap.put(todo_seq, todo);
        return todo_seq;
    }
    public boolean deleteTodo(int todoNum) {
        Todo todo = todoMap.get(todoNum);
        if (todo != null) {
            todoMap.remove(todoNum);
            return true;
        } else {
            return false;
        }
    }
}
