package main.java.com.example.controller;

import main.java.com.example.MatchingCommand;
import main.java.com.example.service.MatchingService;
import main.java.com.example.view.MatchingOutputView;

import java.util.List;
import java.util.Map;

public class FindingController extends AbstractController{

    @Override
    public void doProcess(Map<String, Object> model) {
        MatchingCommand matchingCommand = getMatchingCommand();

        List<List<String>> pairs = MatchingService.findAllPairs(matchingCommand);
        MatchingOutputView.printPairInformation(pairs);
    }
}
