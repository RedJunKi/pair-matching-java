package main.java.com.example.domain;


import main.java.com.example.util.ConditionSearcher;

public class MatchCondition {

    private final Course course;
    private final Level level;
    private Mission mission;

    public MatchCondition(String course, String level, String mission) {
        this.course = ConditionSearcher.getCourse(course);
        this.level = ConditionSearcher.getLevel(level);
        this.mission = ConditionSearcher.getMission(mission);
    }

    public MatchCondition(String course, String level) {
        this.course = ConditionSearcher.getCourse(course);
        this.level = ConditionSearcher.getLevel(level);
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
