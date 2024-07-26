package org.homework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TodoRepository {
    private final Map<Integer, Todo> todoMap = new HashMap<>();
    private int todoSeq = 0;
    public Optional<Todo> findById(int id) {
        return Optional.ofNullable(todoMap.get(id));
    }
    public int save(Todo todo) {
        todo.setId(++todoSeq);
        todoMap.put(todoSeq, todo);
        return todoSeq;
    }
    public boolean existsById(int id) {
        return Optional.ofNullable(todoMap.get(id)).isPresent();
    }
    public void deleteById(int id) {
        todoMap.remove(id);
    }
    public void update(Todo todo) {
        todoMap.put(todo.getId(),todo);
    }
    public List<Todo> search(String content) {
        return todoMap.values().stream()
                .filter(todo -> todo.getContent().contains(content))
                .collect(Collectors.toList());
    }
}
