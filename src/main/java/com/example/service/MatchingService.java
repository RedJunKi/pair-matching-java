package main.java.com.example.service;

import main.java.com.example.MatchingCommand;
import main.java.com.example.PairMatchingInfo;
import main.java.com.example.domain.Course;
import main.java.com.example.domain.Mission;
import main.java.com.example.exception.PairMatchingAlreadyExistException;
import main.java.com.example.repository.CrewRepository;
import main.java.com.example.repository.PairMatchingRepository;
import main.java.com.example.util.Randoms;

import java.util.List;

public class MatchingService {
    private static final String PAIR_MATCHING_NOT_EXISTING = "매칭 이력이 없습니다.";
    private static final String NOT_ENOUGH_CREWS = "페어 매칭이 가능한 경우의 수가 없습니다.";

    public static void doMatch(MatchingCommand matchingCommand) {
        List<String> crewNames = CrewRepository.findAllByCourse(matchingCommand.getCourse());

        if (crewNames.size() < 2) {
            throw new IllegalStateException(NOT_ENOUGH_CREWS);
        }
        List<String> shuffledCrewNames = Randoms.shuffle(crewNames);
        PairMatchingInfo pairMatchingInfo = PairMatchingInfo.of(matchingCommand.getCourse(), matchingCommand.getMission());
        PairMatchingRepository.save(pairMatchingInfo, shuffledCrewNames);
    }

    public static void checkPairMatchingAlreadyExists(MatchingCommand matchingCommand) {
        if (PairMatchingRepository.existingWith(matchingCommand)) {
            throw new PairMatchingAlreadyExistException();
        }
    }

    public static List<List<String>> findAllPairs(MatchingCommand matchingCommand) {
        PairMatchingInfo pairMatchingInfo = PairMatchingInfo.of(matchingCommand.getCourse(), matchingCommand.getMission());
        List<List<String>> pairs = PairMatchingRepository.findAllPairsBy(pairMatchingInfo);

        if (pairs == null) {
            throw new IllegalArgumentException(PAIR_MATCHING_NOT_EXISTING);
        }
        return pairs;
    }

    public static void resetPairMatching(MatchingCommand matchingCommand) {
        PairMatchingInfo pairMatchingInfo = PairMatchingInfo.of(matchingCommand.getCourse(), matchingCommand.getMission());
        PairMatchingRepository.reset(pairMatchingInfo);

    }
}
