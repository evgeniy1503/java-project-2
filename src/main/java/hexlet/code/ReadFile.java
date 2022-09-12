package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {
    public static String readFile(String pathToFile) throws Exception {

        String containsFile;
        Path pathFile;

        if (pathToFile.contains("src/main/resources/")) {
            File file = new File(pathToFile);
            String absolutePath = file.getAbsolutePath();
            pathFile = Path.of(absolutePath);
        } else {
            String path = "src/main/resources/" + pathToFile;
            File file = new File(path);
            String absolutePath = file.getAbsolutePath();
            pathFile = Path.of(absolutePath);
        }

        containsFile = Files.readString(pathFile);
        return containsFile;

    }
}
