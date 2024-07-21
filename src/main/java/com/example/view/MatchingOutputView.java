package main.java.com.example.view;

import main.java.com.example.RematchingCommand;
import main.java.com.example.domain.Course;
import main.java.com.example.domain.Level;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MatchingOutputView {
    private static final String LINE_SEPARATOR = "#############################################";
    private static final String MISSION_MESSAGE_FORMAT = "  - %s: ";
    private static final String VALUE_SEPARATOR_LINE = " | ";
    private static final String COURSE_PREFIX = "과정: ";
    private static final String MISSION_PREFIX = "미션:";
    private static final String ASKING_REMATCHING_COMMAND = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    private static final String PAIR_MATCHING_RESULT_MESSAGE = "페어 매칭 결과입니다.";
    private static final String VALUE_SEPARATOR_COLON = " : ";
    private static final String SELECT_BASIC_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
    private static final String SELECTION_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String RESET_MESSAGE = " 초기화 되었습니다.";

    public static void printInformation(Map<Level, List<String>> allCrewNamesByLevel) {
        System.out.println();
        System.out.println(LINE_SEPARATOR);

        printCourse();
        printMissions(allCrewNamesByLevel);
        System.out.println(LINE_SEPARATOR);

        printAskingInfoMessage();
    }

    public static void printAskingRematchingCommand() {
        System.out.println();
        System.out.println(ASKING_REMATCHING_COMMAND);
        printRematchingCommands();
        System.out.println();
    }

    private static void printRematchingCommands() {
        Iterator<RematchingCommand> iterator = Arrays.stream(RematchingCommand.values()).iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().getCommand());
            addSeparator(iterator, VALUE_SEPARATOR_LINE);
        }
    }

    private static void printAskingInfoMessage() {
        System.out.println(SELECT_BASIC_MESSAGE);
        System.out.println(SELECTION_EXAMPLE);
    }

    private static void printMissions(Map<Level, List<String>> allCrewNamesByLevel) {
        System.out.println(MISSION_PREFIX);
        for (Level level : Level.values()) {
            System.out.printf(MISSION_MESSAGE_FORMAT, level.getName());
            Iterator<String> iterator = allCrewNamesByLevel.get(level).iterator();
            printMissionNames(iterator);
            System.out.println();
        }
    }

    private static void printCourse() {
        System.out.println(COURSE_PREFIX);
        Iterator<Course> iterator = Arrays.stream(Course.values()).iterator();
        printCourseNames(iterator);
        System.out.println();
    }

    private static void printCourseNames(Iterator<Course> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next().getName());
            addSeparator(iterator, VALUE_SEPARATOR_LINE);
        }
    }

    private static void printMissionNames(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            addSeparator(iterator, VALUE_SEPARATOR_LINE);
        }
    }

    private static void addSeparator(Iterator<?> iterator, String s) {
        if (iterator.hasNext()) {
            System.out.print(s);
        }
    }

    public static void printPairInformation(List<List<String>> pairs) {
        System.out.println(PAIR_MATCHING_RESULT_MESSAGE);
        for (List<String> pair : pairs) {
            printPair(pair);
        }
    }

    private static void printPair(List<String> pair) {
        Iterator<String> iterator = pair.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            addSeparator(iterator, VALUE_SEPARATOR_COLON);
        }
        System.out.println();
    }

    public static void printResetResult() {
        System.out.println();
        System.out.println(RESET_MESSAGE);
    }
}
