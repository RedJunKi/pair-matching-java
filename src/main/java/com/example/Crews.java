package main.java.com.example;

import java.util.ArrayList;
import java.util.List;

public class Crews {

    private final List<Crew> crews = new ArrayList<>();

    public Crews(List<String> backendCrew, List<String> frontendCrew) {
        init(backendCrew, frontendCrew);
    }

    private void init(List<String> backendCrew, List<String> frontendCrew) {
        backendCrew.stream()
                .map(c -> new Crew(Course.BACKEND, c))
                .forEach(crews::add);

        frontendCrew.stream()
                .map(c -> new Crew(Course.FRONTEND, c))
                .forEach(crews::add);
    }

    public List<Crew> getBackendCrews() {
        return crews.stream()
                .filter(c -> c.getCourse().equals(Course.BACKEND))
                .toList();
    }

    public List<Crew> getFrontendCrews() {
        return crews.stream()
                .filter(c -> c.getCourse().equals(Course.FRONTEND))
                .toList();
    }

    public Crew getCrew(String name) {
        return crews.stream()
                .filter(c -> c.getName().equals(name))
                .findAny().orElseThrow();
    }
}
