package main.java.com.example;

import main.java.com.example.controller.ControllerHolder;
import main.java.com.example.controller.ControllerName;

import java.util.HashMap;
import java.util.Map;

public class PairMatchingApplication {
    public void run() {
        Map<String, Object> model = new HashMap<>();
        setupData(model);
        ControllerHolder.get(ControllerName.MAIN).process(model);

    }

    private void setupData(Map<String, Object> model) {
        ControllerHolder.get(ControllerName.SETUP_MISSION).process(model);
        ControllerHolder.get(ControllerName.SETUP_CREW).process(model);

    }
}
