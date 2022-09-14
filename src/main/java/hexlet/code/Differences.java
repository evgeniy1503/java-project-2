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

public class Differences {

    public static Map<String, Item> getDiff(Map<String, Object> dataFileOne, Map<String, Object> dataFileTwo) {

        Map<String, Item> differ = new TreeMap<>();

        Set<String> allKey = new TreeSet<>();
        allKey.addAll(dataFileOne.keySet());
        allKey.addAll(dataFileTwo.keySet());

        for (String key : allKey) {
            Object oldValue = dataFileOne.get(key);
            Object newValue = dataFileTwo.get(key);

            if (Objects.equals(dataFileOne.get(key), dataFileTwo.get(key))) {
                differ.put(key, new Item(oldValue, newValue, UNCHANGED));
            } else {
                if (!dataFileOne.containsKey(key)) {
                    differ.put(key, new Item(newValue, ADDED));
                } else  if (!dataFileTwo.containsKey(key)) {
                    differ.put(key, new Item(oldValue, DELETED));
                } else {
                    differ.put(key, new Item(oldValue, newValue, CHANGED));
                }
            }
        }

        return differ;

    }
}
