package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {
    public static String readFile(String pathToFile) throws Exception {

        String containsFile;
        Path pathFile;
        File file = new File(pathToFile);
        String absolutePath = file.getAbsolutePath();
        pathFile = Path.of(absolutePath);

        containsFile = Files.readString(pathFile);
        return containsFile;

    }

    public static String getExtensionFile(String pathToFile) throws Exception {
        String extension;
        if (pathToFile.contains(Parser.JSON)) {
            extension = Parser.JSON;
        } else if (pathToFile.contains(Parser.YML) || pathToFile.contains(Parser.YAML)) {
            extension = Parser.YML;
        } else {
            throw new Exception("Not correct format");
        }
        return extension;
    }
}
