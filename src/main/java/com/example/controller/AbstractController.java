package main.java.com.example.controller;

import main.java.com.example.MatchingCommand;
import main.java.com.example.domain.Level;
import main.java.com.example.repository.MissionRepository;
import main.java.com.example.view.ExceptionHandlingOutputView;
import main.java.com.example.view.MatchingInputView;
import main.java.com.example.view.MatchingOutputView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractController implements Controller {
    @Override
    public void process(Map<String, Object> model) {
        try {
            doProcess(model);
        } catch (IllegalArgumentException e) {
            ExceptionHandlingOutputView.printExceptionMessage(e.getMessage());
            process(model);
        }
    }

    protected static MatchingCommand getMatchingCommand() {
        Map<Level, List<String>> allCrewNamesByLevel = MissionRepository.findAllNamesByAllLevel();
        MatchingOutputView.printInformation(allCrewNamesByLevel);
        return MatchingInputView.getCommand();
    }

    public abstract void doProcess(Map<String, Object> model);
}
