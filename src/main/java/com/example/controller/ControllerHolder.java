package main.java.com.example.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerHolder {

    private final static Map<ControllerName, Controller> controllers = new HashMap<>();

    static {
        initSetupControllers();
        controllers.put(ControllerName.MAIN, new MainController());
        controllers.put(ControllerName.MATCHING, new MatchController());
        controllers.put(ControllerName.FIND, new FindingController());
        controllers.put(ControllerName.RESET, new ResetController());
    }

    private static void initSetupControllers() {
        controllers.put(ControllerName.SETUP_MISSION, new SetupController());
        controllers.put(ControllerName.SETUP_CREW, new SetupCrewController());
    }

    public static Controller get(ControllerName controllerName) {
        return controllers.get(controllerName);
    }
}
