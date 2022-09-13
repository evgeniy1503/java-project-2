package hexlet.code;

import java.util.Map;


public class Differ {
    public static String generate(String firstFilePath, String secondFilePath) throws Exception {

        String containsFileOne = ReadFile.readFile(firstFilePath);
        String containsFileTwo = ReadFile.readFile(secondFilePath);

        String extensionFile1 = ReadFile.getExtensionFile(firstFilePath);
        String extensionFile2 = ReadFile.getExtensionFile(secondFilePath);

        Map<String, Object> dataFileOne = Parser.getData(containsFileOne, extensionFile1);
        Map<String, Object> dataFileTwo = Parser.getData(containsFileTwo, extensionFile2);

        return getDiff(dataFileOne, dataFileTwo);

    }

    public static String getDiff(Map<String, Object> dataFileOne, Map<String, Object> dataFileTwo) {

        StringBuilder result = new StringBuilder();
        result.append("{");

        for (Map.Entry<String, Object> fileOne : dataFileOne.entrySet()) {
            if (!dataFileTwo.containsKey(fileOne.getKey())) {
                result.append("\n- ").append(fileOne.getKey()).append(": ").append(fileOne.getValue());
            } else if (dataFileTwo.containsKey(fileOne.getKey())
                    && dataFileTwo.get(fileOne.getKey()).equals(fileOne.getValue())) {
                result.append("\n  ").append(fileOne.getKey()).append(": ").append(fileOne.getValue());
            } else {
                result.append("\n- ").append(fileOne.getKey()).append(": ").append(fileOne.getValue());
                result.append("\n+ ").append(fileOne.getKey()).append(": ").append(dataFileTwo.get(fileOne.getKey()));
            }
        }

        for (Map.Entry<String, Object> fileTwo : dataFileTwo.entrySet()) {
            if (!dataFileOne.containsKey(fileTwo.getKey())) {
                result.append("\n+ ").append(fileTwo.getKey()).append(": ").append(fileTwo.getValue());
            }
        }

        result.append("\n}");
        return result.toString();

    }
}
