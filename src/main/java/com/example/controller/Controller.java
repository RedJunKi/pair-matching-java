package main.java.com.example.controller;

import java.util.Map;
import java.util.Objects;

public interface Controller {
    void process(Map<String, Object> model);
}
