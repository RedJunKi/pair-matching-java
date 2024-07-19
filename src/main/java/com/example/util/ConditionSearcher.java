package main.java.com.example.util;

import main.java.com.example.domain.Course;
import main.java.com.example.domain.Level;
import main.java.com.example.domain.Mission;

import java.util.Arrays;

public class ConditionSearcher {

    public static Course getCourse(String course) {
        return Arrays.stream(Course.values())
                .filter(ct -> ct.getName().equals(course))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는게 없습니다."));
    }

    public static Level getLevel(String level) {
        return Arrays.stream(Level.values())
                .filter(lt -> lt.getName().equals(level))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는게 없습니다."));
    }

    public static Mission getMission(String mission) {
        return Arrays.stream(Mission.values())
                .filter(mt -> mt.getName().equals(mission))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는게 없습니다."));
    }
}
