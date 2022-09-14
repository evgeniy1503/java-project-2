package hexlet.code;

import hexlet.code.formatter.Formatter;

import java.util.Map;


public class Differ {

    public static String generate(String firstFilePath, String secondFilePath, String format) throws Exception {

        String containsFileOne = ReadFile.readFile(firstFilePath);
        String containsFileTwo = ReadFile.readFile(secondFilePath);

        String extensionFileOne = ReadFile.getExtensionFile(firstFilePath);
        String extensionFileTwo = ReadFile.getExtensionFile(secondFilePath);

        Map<String, Object> dataFileOne = Parser.getData(containsFileOne, extensionFileOne);
        Map<String, Object> dataFileTwo = Parser.getData(containsFileTwo, extensionFileTwo);

        Map<String, Item> differ = GetDifferences.getDiff(dataFileOne, dataFileTwo);

        String result = Formatter.stylish(differ);

        return result;
    }

}
