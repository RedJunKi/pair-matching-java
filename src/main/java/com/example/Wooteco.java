package main.java.com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wooteco {
    private final Crews crewList;

    public Wooteco(Crews crewList) {
        this.crewList = crewList;
    }


    public void generatePair(List<String> crews, String level, String mission) {
        Level nowLevel = Level.valueOf(level);
        Mission nowMission = Mission.valueOf(mission);
        Map<Level, Mission> levelAndMission = Map.of(nowLevel, nowMission);


        if (crews.size() % 2 == 1) {
            String crew1 = crews.remove(crews.size() - 1);
            String crew2 = crews.remove(crews.size() - 1);
            String crew3 = crews.remove(crews.size() - 1);

            pairMatching(crew1, crew2, crew3, levelAndMission);
        }

        while (!crews.isEmpty()) {
            String crew1 = crews.remove(crews.size() - 1);
            String crew2 = crews.remove(crews.size() - 1);

            pairMatching(crew1, crew2, levelAndMission);
        }
    }

    private void pairMatching(String crew1, String crew2, Map<Level, Mission> levelMissionMap) {
        Crew pairCrew1 = crewList.getCrew(crew1);
        Crew pairCrew2 = crewList.getCrew(crew2);

        pairCrew1.getPairList().put(levelMissionMap, pairCrew2);
        pairCrew2.getPairList().put(levelMissionMap, pairCrew1);
    }

    private void pairMatching(String crew1, String crew2, String crew3, Map<Level, Mission> levelMissionMap) {

    }
}
