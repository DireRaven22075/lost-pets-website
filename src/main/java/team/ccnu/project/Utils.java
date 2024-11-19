package team.ccnu.project;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class Utils {
    private static Utils instance;

    private Utils() {
        // private constructor to prevent instantiation
    }

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }
    public String encodePW(String str) {
        return Hashing.sha256().hashString(str, StandardCharsets.UTF_8).toString();
    }
}
