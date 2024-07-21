package main.java.com.example.repository;

import main.java.com.example.MatchingCommand;
import main.java.com.example.PairMatchingInfo;

import main.java.com.example.exception.SamePairMatchedAtSameLevelException;

import java.util.*;
import java.util.stream.Collectors;

public class PairMatchingRepository {
    private static final int PAIR_DEFAULT_SIZE = 2;

    private static Map<PairMatchingInfo, List<List<String>>> pairMatchings = new HashMap<>();

    public static boolean existingWith(MatchingCommand matchingCommand) {
        return pairMatchings.containsKey(PairMatchingInfo.of(matchingCommand.getCourse(), matchingCommand.getMission()));
    }

    public static void save(PairMatchingInfo pairMatchingInfo, List<String> crewNames) {
        List<String> crewNamesArray = new ArrayList<>(crewNames);
        List<List<String>> pairedCrews = makePair(crewNamesArray);
        Validator.checkIfPairAlreadyMatched(pairMatchingInfo, pairedCrews);

        pairMatchings.put(pairMatchingInfo, pairedCrews);
    }

    private static List<List<String>> makePair(List<String> crewNamesArray) {
        List<List<String>> pairedCrews = new ArrayList<>();
        while (PAIR_DEFAULT_SIZE <= crewNamesArray.size()) {
            List<String> crewPair = new ArrayList<>(List.of(getCrewName(crewNamesArray), getCrewName(crewNamesArray)));
            handleOddCrew(crewNamesArray, crewPair);
            pairedCrews.add(crewPair);
        }
        return pairedCrews;
    }

    private static void handleOddCrew(List<String> crewNameArray, List<String> crewPair) {
        if (crewNameArray.size() == 1) {
            crewPair.add(getCrewName(crewNameArray));
        }
    }

    private static String getCrewName(List<String> crewNamesArray) {
        return crewNamesArray.remove(0);
    }

    public static List<List<String>> findAllPairsBy(PairMatchingInfo pairMatchingInfo) {
        return pairMatchings.get(pairMatchingInfo);
    }

    public static void reset(PairMatchingInfo pairMatchingInfo) {
        pairMatchings.remove(pairMatchingInfo);
    }

    private static class Validator {
        private static void checkIfPairAlreadyMatched(PairMatchingInfo pairMatchingInfo, List<List<String>> pairedCrews) {
            List<List<String>> pairsAtSameLevelAndCourse = findAllPairsByLevelAndCourse(pairMatchingInfo);

            for (List<String> pair : pairedCrews) {
                if (pairsAtSameLevelAndCourse.contains(pair)) {
                    throw new SamePairMatchedAtSameLevelException();
                }
            }
        }

        private static List<List<String>> findAllPairsByLevelAndCourse(PairMatchingInfo pairMatchingInfo) {
            List<List<String>> pairsAtSameLevel = new ArrayList<>();

            for (PairMatchingInfo matchingInfo : getPairMatchingInfoAtSameLevelAndCourse(pairMatchingInfo)) {
                pairsAtSameLevel.addAll(pairMatchings.get(matchingInfo));
            }
            pairsAtSameLevel.forEach(Collections::sort);
            return pairsAtSameLevel;
        }

        private static List<PairMatchingInfo> getPairMatchingInfoAtSameLevelAndCourse(PairMatchingInfo pairMatchingInfo) {
            List<PairMatchingInfo> infoAtSameLevel = pairMatchings.keySet().stream()
                    .filter(p -> p.isLevel(pairMatchingInfo.getLevel()))
                    .filter(p -> p.isCourse(pairMatchingInfo.getCourse()))
                    .collect(Collectors.toList());
            return infoAtSameLevel;
        }
    }
}
