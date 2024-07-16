package main.java.com.example.util;

import main.java.com.example.Main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<String> fileLoadToStringList(String filePath) {

        List<String> result = new ArrayList<>();

        try (
                InputStream inputStream = Main.class.getResourceAsStream(filePath);
                InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
