package main.java.com.example;

import main.java.com.example.util.FileLoader;
import main.java.com.example.util.Randoms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 패키지 경로와 파일명 지정

        // 클래스 로더를 사용하여 리소스 파일을 읽어오기
        String backendCrewPath = "/backend-crew.md";
        String frontendCrewPath = "/frontend-crew.md";

        List<String> backendList = FileLoader.fileLoadToStringList(backendCrewPath);
        List<String> frontendList = FileLoader.fileLoadToStringList(frontendCrewPath);

        Crews crews = new Crews(backendList, frontendList);


    }
}