package main.java.com.example.domain;

import main.java.com.example.domain.Course;
import main.java.com.example.domain.Level;
import main.java.com.example.domain.Mission;

import static main.java.com.example.util.ConditionSearcher.*;

public class MatchCondition {

    private final Course course;
    private final Level level;
    private Mission mission;

    public MatchCondition(String course, String level, String mission) {
        this.course = getCourse(course);
        this.level = getLevel(level);
        this.mission = getMission(mission);
    }

    public MatchCondition(String course, String level) {
        this.course = getCourse(course);
        this.level = getLevel(level);
    }
}
