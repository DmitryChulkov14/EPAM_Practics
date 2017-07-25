package ua.nure.chulkov.Practice4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {
    static String readFile(String path, String encoding) {
        String res = null;
        try{
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
