package team.ccnu.project;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;
import java.security.SecureRandom;
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
    public String getSalt() {
        //1. Random, salt 생성
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[20];

        //2. 난수 생성
        sr.nextBytes(salt);

        //3. byte To String (10진수 문자열로 변경)
        StringBuffer sb = new StringBuffer();
        for(byte b : salt) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String encodePW(String str) {
        return Hashing.sha256().hashString(str, StandardCharsets.UTF_8).toString();
    }
}
