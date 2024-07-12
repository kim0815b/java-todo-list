package org.homework;

public class TodoController {
    private TodoService todoService;
    public void run() {
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
                case EXIT:
                    exit();
                    return;
                case NONE:
            }
        }
    }
    private Menu choiceMenu() {
        OutputView.outPutChoiceMenu();
        return InputView.inputMenu();
    }
    private void save() {
        todoService.save(InputView.inputContent());
    }
    private void delete() {
        int num = InputView.inputNum();
        todoService.delete(num);
        OutputView.outPutDeleteTodo(num);
    }
    private void select() {
        OutputView.outPutSelectTodo(todoService.findById(InputView.inputNum()));
    }

    private void exit() {
        OutputView.outPutFinishProgram();
    }
}
