package hexlet.code;

import java.util.Map;


public class Differ {

    public static String generate(String firstFilePath, String secondFilePath, String format) throws Exception {

        String containsFileOne = ReadFile.readFile(firstFilePath);
        String containsFileTwo = ReadFile.readFile(secondFilePath);

        String extensionFile1 = ReadFile.getExtensionFile(firstFilePath);
        String extensionFile2 = ReadFile.getExtensionFile(secondFilePath);

        Map<String, Object> dataFileOne = Parser.getData(containsFileOne, extensionFile1);
        Map<String, Object> dataFileTwo = Parser.getData(containsFileTwo, extensionFile2);

        return Formatter.getStylish(dataFileOne, dataFileTwo);

    }

}
