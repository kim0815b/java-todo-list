package org.homework;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.LocalDate.*;

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

    public List<Todo> selectDeadlinesSevenDays() {
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysLater = today.plusDays(7);
        return todoMap.values().stream()
                .filter(todo -> !todo.getEndDate().isBefore(today) && !todo.getEndDate().isAfter(sevenDaysLater))
                .collect(Collectors.toList());
    }
}
