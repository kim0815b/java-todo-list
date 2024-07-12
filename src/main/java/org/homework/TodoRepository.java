package org.homework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoRepository {
    private final Map<Integer, Todo> todoMap = new HashMap<>();
    private int todoSeq = 0;

    public Todo findById(int id) {
        return todoMap.get(id);
    }

    public void save(Todo todo) {
        todo.setId(++todoSeq);
        todoMap.put(todoSeq, todo);
    }

    public void deleteById(int id) {
        todoMap.remove(id);
    }

    public void update(Todo todo) {
        todoMap.put(todo.getId(),todo);
    }
}
