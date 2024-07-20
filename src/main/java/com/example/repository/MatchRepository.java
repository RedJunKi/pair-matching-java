package main.java.com.example.repository;

import main.java.com.example.domain.Level;
import main.java.com.example.domain.MatchCondition;
import main.java.com.example.domain.Pair;
import main.java.com.example.exception.DuplicationPairsException;
import main.java.com.example.exception.EmptyPairMatchConditionException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchRepository {

    private Map<MatchCondition, List<Pair>> matchPair = new HashMap<>();

    public void save(MatchCondition matchCondition, List<Pair> pairs) {
        matchPair.put(matchCondition, pairs);
    }

    public boolean hasDuplicatingAtSameLevel(MatchCondition matchCondition, List<Pair> pairs) {
        List<List<Pair>> matchedPairsAtSameLevel = findAllByLevel(matchCondition.getLevel());

        try {
            checkHavingDuplicatingPairs(pairs, matchedPairsAtSameLevel);
        } catch (DuplicationPairsException e) {
            return true;
        }

        return false;
    }

    private static void checkHavingDuplicatingPairs(List<Pair> pairs, List<List<Pair>> matchedPairsAtSameLevel) throws DuplicationPairsException {
        for (List<Pair> pairsAtSameLevel : matchedPairsAtSameLevel) {
            checkDuplicationByEachPairMatchingInfo(pairs, pairsAtSameLevel);
        }
    }

    private static void checkDuplicationByEachPairMatchingInfo(List<Pair> pairs, List<Pair> pairsAtSameLevel) throws DuplicationPairsException {
        for (Pair pair : pairsAtSameLevel) {
            checkDuplication(pairs, pair);
        }
    }

    private static void checkDuplication(List<Pair> pairs, Pair pair) throws DuplicationPairsException {
        if (pairs.contains(pair)) {
            throw new DuplicationPairsException();
        }
    }

    private List<List<Pair>> findAllByLevel(Level level) {
        List<List<Pair>> matchedPairsAtSameLevel = new ArrayList<>();
        getPairsAtSameLevel(level, matchedPairsAtSameLevel);
        return matchedPairsAtSameLevel;
    }

    private void getPairsAtSameLevel(Level level, List<List<Pair>> matchedPairsAtSameLevel) {
        matchPair.forEach((matchCondition, pairs) -> {
            if (matchCondition.getLevel() == level) {
                matchedPairsAtSameLevel.add(pairs);
            }
        });
    }

    public List<List<String>> findAllNamesByPairMatchCondition(MatchCondition matchCondition) {
        List<Pair> pairs = findByPairMatchCondition(matchCondition);
        if (pairs == null) {
            throw new EmptyPairMatchConditionException();
        }
        return findAllNamesFromPairs(pairs);
    }

    private static List<List<String>> findAllNamesFromPairs(List<Pair> pairs) {
        List<List<String>> pairNamesArray = new ArrayList<>();
        findAllNamesFromPair(pairs, pairNamesArray);
        return pairNamesArray;
    }

    private static void findAllNamesFromPair(List<Pair> pairs, List<List<String>> pairNamesArray) {
        for (Pair pair : pairs) {
            pairNamesArray.add(pair.getCrewNames());
        }
    }

    private List<Pair> findByPairMatchCondition(MatchCondition matchCondition) {
        return matchPair.get(matchCondition);
    }

    public void resetAll() {
        matchPair.clear();
    }
}
