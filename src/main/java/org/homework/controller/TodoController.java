package org.homework.controller;

import org.homework.dto.Todo;
import org.homework.repository.TodoRepository;

public class TodoController {
    TodoRepository todoRepository;
    public Todo setTodo(Todo todo) {
        return todoRepository.setTodo(todo);
    }
    public Todo getTodo(int todoNum) {
        return todoRepository.getTodo(todoNum);
    }
    public boolean deleteTodo(int todoNUm) {
        return todoRepository.deleteTodo(todoNUm);
    }
}
