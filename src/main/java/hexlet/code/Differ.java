package hexlet.code;

import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;

import java.util.Map;


public class Differ {

    public static String generate(String firstFilePath, String secondFilePath, String format) throws Exception {

        String content1 = FileUtils.readFile(firstFilePath);
        String contain2 = FileUtils.readFile(secondFilePath);

        String extension1 = FileUtils.getDataFormat(firstFilePath);
        String extension2 = FileUtils.getDataFormat(secondFilePath);

        Map<String, Object> data1 = Parser.getData(content1, extension1);
        Map<String, Object> data2 = Parser.getData(contain2, extension2);

        Map<String, Item> differ = Differences.getDiff(data1, data2);

        return switch (format) {

            case "plain" -> Plain.makePlain(differ);
            case "json" -> Json.makeJson(differ);
            case  "stylish" -> Stylish.makeStylish(differ);
            default -> throw new Exception("Formatting error");
        };

    }
    public static String generate(String firstFilePath, String secondFilePath) throws Exception {

        return generate(firstFilePath, secondFilePath, "stylish");

    }
}
