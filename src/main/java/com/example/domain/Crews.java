package main.java.com.example.domain;

import java.util.ArrayList;
import java.util.List;

import static main.java.com.example.util.ConditionSearcher.*;

public class Crews {

    private List<Crew> crews;
    private static Crews instance;

    private Crews() {
        this.crews = new ArrayList<>();
    }

    public void addCrews(List<String> crewList, String course) {
        Course courseType = getCourse(course);

        crewList.stream()
                .map(c -> new Crew(courseType, c))
                .forEach(crews::add);
    }

    public static Crews getInstance() {
        if (instance == null) {
            instance = new Crews();
        }

        return instance;
    }

    public List<Crew> getCrewsByCourse(String course) {
        Course courseType = getCourse(course);
        return crews.stream()
                .filter(c -> c.getCourse().equals(courseType))
                .toList();
    }


    public Crew getCrew(String name) {
        return crews.stream()
                .filter(c -> c.getName().equals(name))
                .findAny()
                .orElseThrow();
    }

    @Override
    public String toString() {
        return crews.stream()
                .map(Crew::toString)
                .reduce((crew1, crew2) -> crew1 + " : " + crew2)
                .orElse("");
    }
}
