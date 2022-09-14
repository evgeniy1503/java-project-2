package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {

    public static final String JSON = "json";
    public static final String YML = "yml";
    public static final String YAML = "yaml";
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
        if (pathToFile.endsWith(JSON)) {
            extension = JSON;
        } else if (pathToFile.endsWith(YML) || pathToFile.endsWith(YAML)) {
            extension = YML;
        } else {
            throw new Exception("Not correct format");
        }
        return extension;
    }
}
