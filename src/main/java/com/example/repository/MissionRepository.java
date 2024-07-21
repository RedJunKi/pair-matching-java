package main.java.com.example.repository;

import main.java.com.example.domain.Level;
import main.java.com.example.domain.Mission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissionRepository {
    private static final List<Mission> missions = new ArrayList<>();

    public static void save(Level level, String missionName) {
        missions.add(Mission.of(level, missionName));
    }

    public static Map<Level, List<String>> findAllNamesByAllLevel() {
        Map<Level, List<String>> result = new HashMap<>();
        for (Level level : Level.values()) {
            List<String> missionNames = findAllNamesByLevel(level);
            result.put(level, missionNames);
        }
        return result;
    }

    private static List<String> findAllNamesByLevel(Level level) {
        return missions.stream()
                .filter(m -> m.isSameLevel(level))
                .map(Mission::getName)
                .toList();
    }

    public static boolean isExistingWith(Level level, String missionName) {
        return missions.stream()
                .filter(m -> m.isSameLevel(level))
                .anyMatch(m -> m.isSameMission(missionName));
    }
}
