package main.java.com.example.domain;

import java.util.Objects;

public class Mission {

    private final Level level;
    private final String name;

    private Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public static Mission of(Level level, String missionName) {
        return new Mission(level, missionName);
    }

    public Level getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Mission mission = (Mission) o;
        return level == mission.getLevel() && name.equals(mission.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, name);
    }

    @Override
    public String toString() {
        return "Mission{" +
                "level=" + level +
                ", name='" + name + '\'' +
                "}";
    }

    public boolean isSameLevel(Level level) {
        return this.level.equals(level);
    }

    public boolean isSameMission(String missionName) {
        return this.name.equals(missionName);
    }
}
