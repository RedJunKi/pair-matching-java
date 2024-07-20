package main.java.com.example;

import main.java.com.example.controller.MatchController;
import main.java.com.example.domain.Crew;
import main.java.com.example.domain.Crews;
import main.java.com.example.domain.MatchCondition;
import main.java.com.example.domain.Pair;
import main.java.com.example.repository.MatchRepository;
import main.java.com.example.util.FileLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 패키지 경로와 파일명 지정

        // 클래스 로더를 사용하여 리소스 파일을 읽어오기
        String backendCrewPath = "/backend-crew.md";
        String frontendCrewPath = "/frontend-crew.md";

        List<String> backendList = FileLoader.fileLoadToStringList(backendCrewPath);
        List<String> frontendList = FileLoader.fileLoadToStringList(frontendCrewPath);
        Crews crews = Crews.getInstance();
        crews.addCrews(backendList, "백엔드");
        crews.addCrews(frontendList, "프론트엔드");

        MatchCondition level1_carRacing = new MatchCondition("프론트엔드", "레벨1", "자동차경주");
        MatchCondition level1_lotto = new MatchCondition("프론트엔드", "레벨1", "로또");
        MatchCondition level1_numberBaseball = new MatchCondition("프론트엔드", "레벨1", "로또");
        MatchRepository matchRepository = new MatchRepository();
        MatchController matchController = new MatchController(matchRepository);
        matchController.match(level1_carRacing, frontendList);


        matchController.match(level1_lotto, frontendList);
        System.out.println("로또");
        System.out.println();
        System.out.println();
        System.out.println();



        matchController.match(level1_numberBaseball, frontendList);
        System.out.println("숫자야구");
        System.out.println();
        System.out.println();
        System.out.println();

        matchController.match(level1_carRacing, frontendList);
        System.out.println("자동차경주");
        System.out.println();
        System.out.println();
        System.out.println();
    }
}