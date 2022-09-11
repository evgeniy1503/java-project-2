package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {
    public static String readFile(String pathToFile) throws Exception {
        String containsFile;
        Path pathFile;
        if (pathToFile.contains("./src/main/resources/")) {
            pathFile = Path.of(pathToFile);
        } else {
            String fullPath = "./src/main/resources/" + pathToFile;
            pathFile = Path.of(fullPath);
        }
        containsFile = Files.readString(pathFile);

        return containsFile;
    }
}
