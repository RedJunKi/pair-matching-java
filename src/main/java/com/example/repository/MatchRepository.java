package main.java.com.example.repository;

import main.java.com.example.domain.MatchCondition;
import main.java.com.example.domain.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchRepository {

    private Map<MatchCondition, List<Pair>> matchPair = new HashMap<>();

    public void save(MatchCondition matchCondition, List<Pair> pairs) {
        matchPair.put(matchCondition, pairs);
    }

    public List<Pair> findPairByMatchCondition(MatchCondition matchCondition) {
        return matchPair.get(matchCondition);
    }
}
