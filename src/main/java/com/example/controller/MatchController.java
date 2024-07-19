package main.java.com.example.controller;

import main.java.com.example.domain.Crew;
import main.java.com.example.domain.Crews;
import main.java.com.example.domain.MatchCondition;
import main.java.com.example.repository.MatchRepository;
import main.java.com.example.domain.Pair;
import main.java.com.example.util.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MatchController {

    private final MatchRepository matchRepository;
    private static final int MAX_RETRY_COUNT = 3;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void match(MatchCondition matchCondition, List<String> crews) {
        int retryCount = 0;
        List<Pair> matchPair;
        List<Pair> findPair;

        do {
            retryCount++;
            if (retryCount == MAX_RETRY_COUNT) {
                throw new IllegalArgumentException();
            }

            matchPair = createMatchPair(crews);
            findPair = matchRepository.findPairByMatchCondition(matchCondition);
        } while (isDuplicatePair(matchPair, findPair));

        matchRepository.save(matchCondition, matchPair);
    }


    private boolean isDuplicatePair(List<Pair> matchPair, List<Pair> findPairs) {
        for (Pair pair : matchPair) {
            if (findPairs.contains(pair)) {
                return true;
            }
        }
        return false;
    }

    private List<Pair> createMatchPair(List<String> crews) {
        List<Pair> result = new ArrayList<>();
        Crews crewInstance = Crews.getInstance();
        Stack<String> shuffeldCrewStack = crewListToStack(crews);

        while (shuffeldCrewStack.size() >= 2) {
            result.add(createPair(shuffeldCrewStack, crewInstance));
        }
        return result;
    }

    private Pair createPair(Stack<String> crewStack, Crews crewInstance) {
        Crew firstCrew = crewInstance.getCrew(crewStack.pop());
        Crew secondCrew = crewInstance.getCrew(crewStack.pop());

        if (crewStack.size() == 1) {
            Crew thirdCrew = crewInstance.getCrew(crewStack.pop());
            return new Pair(firstCrew, secondCrew, thirdCrew);
        }

        return new Pair(firstCrew, secondCrew);
    }

    private static Stack<String> crewListToStack(List<String> crews) {
        Stack<String> crewStack = new Stack<>();
        crewStack.addAll(Randoms.shuffle(crews));
        return crewStack;
    }
}