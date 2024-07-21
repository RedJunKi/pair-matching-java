package main.java.com.example.controller;

import main.java.com.example.MatchingCommand;
import main.java.com.example.RematchingCommand;
import main.java.com.example.exception.PairMatchingAlreadyExistException;
import main.java.com.example.exception.SamePairMatchedAtSameLevelException;
import main.java.com.example.service.MatchingService;
import main.java.com.example.view.ExceptionHandlingOutputView;
import main.java.com.example.view.MatchingInputView;
import main.java.com.example.view.MatchingOutputView;

import java.util.List;
import java.util.Map;

public class MatchController extends AbstractController{
    private static final int MAX_RETRY_COUNT = 3;
    private static final String MATCHING_FAILED_MESSAGE = "페어 매칭에 실패했습니다.";

    @Override
    public void doProcess(Map<String, Object> model) {
        MatchingCommand matchingCommand = getMatchingCommand();

        try {
            MatchingService.checkPairMatchingAlreadyExists(matchingCommand);
            matchPairs(matchingCommand);
        } catch (PairMatchingAlreadyExistException e) {
            handlePairMatchingAlreadyExistingCondition(matchingCommand);
        }
    }

    private static void matchPairs(MatchingCommand matchingCommand) {
        doMatch(matchingCommand, 0);

        List<List<String>> pairs = MatchingService.findAllPairs(matchingCommand);
        MatchingOutputView.printPairInformation(pairs);
    }

    private static void doMatch(MatchingCommand matchingCommand, int count) {
        try {
            MatchingService.doMatch(matchingCommand);
        } catch (SamePairMatchedAtSameLevelException e) {
            if (count == MAX_RETRY_COUNT) {
                ExceptionHandlingOutputView.printExceptionMessage(MATCHING_FAILED_MESSAGE);
                throw e;
            }
            doMatch(matchingCommand, ++count);
        }
    }

    private static void handlePairMatchingAlreadyExistingCondition(MatchingCommand matchingCommand) {
        MatchingOutputView.printAskingRematchingCommand();
        RematchingCommand rematchingCommand = MatchingInputView.getRematchingCommand();
        if (rematchingCommand == RematchingCommand.YES) {
            matchPairs(matchingCommand);
        }
    }
}