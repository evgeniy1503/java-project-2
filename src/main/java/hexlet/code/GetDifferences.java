package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Objects;


import static hexlet.code.Status.ADDED;
import static hexlet.code.Status.DELETED;
import static hexlet.code.Status.UNCHANGED;
import static hexlet.code.Status.CHANGED;

public class GetDifferences {

    public static Map<String, Item> getDiff(Map<String, Object> dataFileOne, Map<String, Object> dataFileTwo) {

        Set<String> allKey = new TreeSet<>(dataFileOne.keySet());
        allKey.addAll(dataFileTwo.keySet());

        Map<String, Item> differ = new TreeMap<String, Item>();

        for (String key : allKey) {
            if (!dataFileOne.containsKey(key)) {
                differ.put(key, new Item(dataFileTwo.get(key), ADDED));
            } else if (!dataFileTwo.containsKey(key)) {
                differ.put(key, new Item(dataFileOne.get(key), DELETED));
            } else if (Objects.equals(dataFileOne.get(key), dataFileTwo.get(key))) {
                differ.put(key, new Item(dataFileOne.get(key), (dataFileTwo.get(key)), UNCHANGED));
            } else {
                differ.put(key, new Item(dataFileOne.get(key), (dataFileTwo.get(key)), CHANGED));
            }
        }
        return differ;
    }
}
