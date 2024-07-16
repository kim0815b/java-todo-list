package org.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class TodoController {
    private final TodoService todoService;

    public TodoController() {
        this.todoService = new TodoService();
    }

    public void run(){
        while (true) {
            switch (choiceMenu()) {
                case ADD:
                    save();
                    break;
                case DELETE:
                    delete();
                    break;
                case SELECT:
                    select();
                    break;
                case SELECTALL:
                    selectAll();
                case SEARCH:
                    search();
                    break;
                case EXIT:
                    exit();
                    return;
                case NONE:
                    error();
                    break;
            }
        }
    }
    private Menu choiceMenu() {
        OutputView.outPutChoiceMenu();
        return InputView.inputMenu();
    }
    private void save(){
        String content = InputView.inputString();
        Date date = inputDate();
        Todo todo = new Todo(content,date);
        OutputView.outPutAddTodo(todoService.save(todo));
    }
    private void delete() {
        int num = InputView.inputNum();
        if (todoService.existsById(num)) {
            todoService.delete(num);
            OutputView.outPutDeleteTodo(num);
        } else {
            OutputView.outPutTodoIfNull();
        }
    }

    private void select() {
        OutputView.outPutSelectNum();
        try {
            OutputView.outPutSelectTodo(
                    todoService.findById(InputView.inputNum())
            );
        } catch (RuntimeException e) {
            OutputView.outPutTodoIfNull();
        }
//        if (findByIdTodo.isPresent()) {
//            OutputView.outPutSelectTodo(findByIdTodo.get());
//        } else {
//            OutputView.outPutTodoIfNull();
//        }
    }
    private void selectAll() {
        OutputView.outPutTodoAll(todoService.selectAll().values());
    }
    private void exit() {
        OutputView.outPutFinishProgram();
    }
    private void error() {
        OutputView.outPutError();
    }

    private void search() {
        OutputView.outPutSearchContent();
        OutputView.outPutTodoAll(todoService.search(InputView.inputString()));
    }
    private Date inputDate() {
        OutputView.outPutAddEndDate();
        String endDateStr = InputView.inputString();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            return format.parse(endDateStr);
        } catch (ParseException e) {
            return null;
        }
    }

}
