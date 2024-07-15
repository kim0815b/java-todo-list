package org.homework;

import java.util.IllformedLocaleException;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService() {
        this.todoRepository = new TodoRepository();
    }

    public Optional<Todo> findById(int id) {
        return todoRepository.findById(id);
    }
    public int save(Todo todo) {
        return todoRepository.save(todo);
    }

    public boolean existsById(int id) {
        return todoRepository.existsById(id);
    }
    public void delete(int id) {
        todoRepository.deleteById(id);
    }
    public void update(Todo todo) {
        todoRepository.update(todo);
    }

    public Map<Integer, Todo> selectAll() {
        return todoRepository.selectAll();
    }
}
