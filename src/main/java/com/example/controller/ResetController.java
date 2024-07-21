package main.java.com.example.controller;

import main.java.com.example.MatchingCommand;
import main.java.com.example.service.MatchingService;
import main.java.com.example.view.MatchingOutputView;

import java.util.Map;

public class ResetController extends AbstractController{
    @Override
    public void doProcess(Map<String, Object> model) {
        MatchingCommand matchingCommand = getMatchingCommand();
        MatchingService.resetPairMatching(matchingCommand);

        MatchingOutputView.printResetResult();
    }
}
