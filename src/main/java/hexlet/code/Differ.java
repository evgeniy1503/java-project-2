package hexlet.code;

import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;

import java.util.Map;


public class Differ {

    public static String generate(String firstFilePath, String secondFilePath, String format) throws Exception {

        String containsFileOne = ReadFile.readFile(firstFilePath);
        String containsFileTwo = ReadFile.readFile(secondFilePath);

        String extensionFileOne = ReadFile.getExtensionFile(firstFilePath);
        String extensionFileTwo = ReadFile.getExtensionFile(secondFilePath);

        Map<String, Object> dataFileOne = Parser.getData(containsFileOne, extensionFileOne);
        Map<String, Object> dataFileTwo = Parser.getData(containsFileTwo, extensionFileTwo);

        Map<String, Item> differ = Differences.getDiff(dataFileOne, dataFileTwo);

        return switch (format) {
            case "plain" -> Plain.makePlain(differ);
            case "json" -> Json.makeJson(differ);
            default -> Stylish.makeStylish(differ);
        };

    }
    public static String generate(String firstFilePath, String secondFilePath) throws Exception {
        return generate(firstFilePath, secondFilePath, "stylish");
    }
}
