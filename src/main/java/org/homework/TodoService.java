package org.homework;

import java.util.Optional;

public class TodoService {
    private TodoRepository todoRepository;
    public Todo findById(int id) {
        return Optional.ofNullable(todoRepository.findById(id))
                .orElseThrow();
    }
    public void save(String content) {
        todoRepository.save(new Todo(content));
    }
    public void delete(int id) {
        todoRepository.deleteById(id);
    }
    public void update(Todo todo) {
        todoRepository.update(todo);
    }
}
