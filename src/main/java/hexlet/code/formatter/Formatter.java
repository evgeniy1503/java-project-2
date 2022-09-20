package hexlet.code.formatter;

import hexlet.code.Item;

import java.util.Map;

public class Formatter {
    public static String getFormat(Map<String, Item> differ, String format) throws Exception {

        return switch (format) {

            case "plain" -> Plain.makePlain(differ);
            case "json" -> Json.makeJson(differ);
            case  "stylish" -> Stylish.makeStylish(differ);
            default -> throw new Exception("Formatting error");

        };
    }
}
