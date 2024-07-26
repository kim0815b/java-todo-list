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
    private final InputView inputView;
    private final OutputView outputView;
    public TodoController(TodoService todoService,
                          InputView inputView,
                          OutputView outputView) {
        this.todoService = todoService;
        this.inputView = inputView;
        this.outputView = outputView;
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
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("할 일이 없습니다.");
            }
        }
    }

    private Menu choiceMenu() {
        return inputView.inputMenu();
    }

    private void save() throws ParseException {
        String content = inputView.inputContent();
        Date date = inputView.inputDate();
        Todo todo = new Todo(content, date);
        outputView.outPutAddTodo(todoService.save(todo));
    }

    private void delete() throws IllegalArgumentException{
        int num = inputView.inputDeleteById();
        outputView.outPutDeleteTodo(
                todoService.delete(num),
                num
        );
    }

    private void select() throws IllegalArgumentException {
        Todo todo = todoService.findById(inputView.inputFindById())
                .orElseThrow(IllegalArgumentException::new);
        outputView.outPutSelectTodo(todo);
    }

    private void exit() {
        outputView.outPutFinishProgram();
    }

    private void error() {
        outputView.outPutError();
    }

    private void search() {
        outputView.outPutTodoAll(
                todoService.search(
                        inputView.inputSearchContent()
                )
        );
    }
}
