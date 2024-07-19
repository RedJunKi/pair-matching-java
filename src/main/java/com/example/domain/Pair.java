package main.java.com.example.domain;

import java.util.*;

public class Pair {

    private final Set<Crew> crews = new HashSet<>();

    public Pair(Crew... crew) {
        crews.addAll(Arrays.asList(crew));
    }

    public Set<Crew> getCrews() {
        return crews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Pair pair = (Pair) o;

        return pair.getCrews().equals(crews);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(crews);
    }
}
