package main.java.com.example.view;

import main.java.com.example.MatchingCommand;
import main.java.com.example.RematchingCommand;
import main.java.com.example.domain.Course;
import main.java.com.example.domain.Level;

public class MatchingInputView extends AbstractInputView {
    public static MatchingCommand getCommand() {
        String input = readInput();
        String[] validatedInputArray = Validator.validate(input);

        Course course = Course.findByName(validatedInputArray[0]);
        Level level = Level.findByName(validatedInputArray[1]);
        String missionName = validatedInputArray[2];

        return MatchingCommand.of(course, level, missionName);
    }

    public static RematchingCommand getRematchingCommand() {
        return RematchingCommand.findByCommand(readInput());
    }

    private static class Validator {

        private static final String NOT_MATCH_FORM = "입력 형식에 맞지 않습니다.";
        private static final int INPUT_VALUE_AMOUNT = 3;
        private static final String COMMA = ",";
        private static final String SPACE = " ";
        private static final String BLANK = "";

        public static String[] validate(String target) {
            target = target.replaceAll(SPACE, BLANK);
            String[] result = target.split(COMMA);
            hasValidSize(result);

            return result;
        }

        private static void hasValidSize(String[] target) {
            if (target.length != INPUT_VALUE_AMOUNT) {
                throw new IllegalArgumentException(NOT_MATCH_FORM);
            }
        }
    }
}
