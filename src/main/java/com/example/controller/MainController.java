package main.java.com.example.controller;

import main.java.com.example.MainCommand;
import main.java.com.example.view.MainInputView;
import main.java.com.example.view.MainOutputView;

import java.util.Map;

// 조회와 매칭을 분기하는 컨트롤러
public class MainController extends AbstractController {
    @Override
    public void doProcess(Map<String, Object> model) {
        MainCommand command;
        do {
            MainOutputView.printCommands();
            command = MainInputView.getCommand();

            doMatchingProcess(model, command);
            doFindingProcess(model, command);
            if (command == MainCommand.RESET) {
                ControllerHolder.get(ControllerName.RESET).process(model);
            }
        } while (command != MainCommand.QUIT);
    }

    private void doMatchingProcess(Map<String, Object> model, MainCommand command) {
        if (command == MainCommand.MATCHING) {
            ControllerHolder.get(ControllerName.MATCHING).process(model);
        }
    }

    private void doFindingProcess(Map<String, Object> model, MainCommand command) {
        if (command == MainCommand.FIND) {
            ControllerHolder.get(ControllerName.FIND).process(model);
        }
    }
}
