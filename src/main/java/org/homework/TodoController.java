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

    public void run() {
        while (true) {
            try {
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
            } catch (ParseException e) {
                System.out.println("날짜를 잘못 입력했습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("할 일이 없습니다.");
            }
        }
    }

    private Menu choiceMenu() {
        return InputView.inputMenu();
    }

    private void save() throws ParseException {
        String content = InputView.inputContent();
        Date date = InputView.inputDate();
        Todo todo = new Todo(content, date);
        OutputView.outPutAddTodo(todoService.save(todo));
    }

    private void delete() {
        int num = InputView.inputDeleteById();
        OutputView.outPutDeleteTodo(
                todoService.delete(num),
                num
        );
    }

    private void select() throws IllegalArgumentException {
        Todo todo = todoService.findById(InputView.inputFindById())
                .orElseThrow(IllegalArgumentException::new);
        OutputView.outPutSelectTodo(todo);
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
        OutputView.outPutTodoAll(
                todoService.search(
                        InputView.inputSearchContent()
                )
        );
    }
}
