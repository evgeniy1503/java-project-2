package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Formatter {


    public static String getStylish(Map<String, Object> dataFileOne, Map<String, Object> dataFileTwo) {

        Set<String> allKey = new TreeSet<>(dataFileOne.keySet());
        allKey.addAll(dataFileTwo.keySet());

        StringBuilder result = new StringBuilder();

        result.append("{");
        for (String key : allKey) {
            if (!dataFileOne.containsKey(key)) {
                result.append("\n  + ").append(key).append(": ").append(dataFileTwo.get(key));
            } else {
                if (!dataFileTwo.containsKey(key)) {
                    result.append("\n  - ").append(key).append(": ").append(dataFileOne.get(key));
                } else {
                    if (Objects.equals(dataFileOne.get(key), dataFileTwo.get(key))) {
                        result.append("\n    ").append(key).append(": ").append(dataFileTwo.get(key));
                    } else {
                        result.append("\n  - ").append(key).append(": ").append(dataFileOne.get(key));
                        result.append("\n  + ").append(key).append(": ").append(dataFileTwo.get(key));
                    }
                }
            }
        }
        result.append("\n}");
        return result.toString();
    }
}
