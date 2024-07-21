package main.java.com.example.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String NOT_EXISTING_COURSE_NAME = "존재하지 않는 과정입니다.";

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findByName(String courseName) {
        return Arrays.stream(Course.values())
                .filter(c -> c.name.equals(courseName))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(NOT_EXISTING_COURSE_NAME));
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                "}";
    }
    public String getName() {
        return name;
    }
}
