package main.java.com.example;

import main.java.com.example.domain.Course;
import main.java.com.example.domain.Level;
import main.java.com.example.domain.Mission;

import java.util.Objects;

public class PairMatchingInfo {
    private final Course course;
    private final Mission mission;

    public PairMatchingInfo(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public static PairMatchingInfo of(Course course, Mission mission) {
        return new PairMatchingInfo(course, mission);
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return mission.getLevel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        PairMatchingInfo pairMatchingInfo = (PairMatchingInfo) o;
        return pairMatchingInfo.course == course && pairMatchingInfo.mission.equals(mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, mission);
    }

    public boolean isLevel(Level level) {
        return this.getLevel().equals(level);
    }

    public boolean isCourse(Course course) {
        return this.course.equals(course);
    }
}
