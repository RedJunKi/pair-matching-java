package main.java.com.example.util;

import java.util.Collections;
import java.util.List;

public class Randoms {

    public static List<String> shuffle(List<String> crews) {
        Collections.shuffle(crews);
        return crews;
    }
}
