package org.homework;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.IllformedLocaleException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Optional<Todo> findById(int id){
        return todoRepository.findById(id);
    }
    public int save(Todo todo) {
        return todoRepository.save(todo);
    }

    public boolean existsById(int id) {
        return todoRepository.existsById(id);
    }
    public boolean delete(int id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return true;
        }
        throw new IllegalArgumentException();
    }
    public void update(Todo todo) {
        todoRepository.update(todo);
    }

    public List<Todo> search(String content) {
        return todoRepository.search(content);
    }
}
