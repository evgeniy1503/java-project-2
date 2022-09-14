package hexlet.code.formatter;

import hexlet.code.Item;

import java.util.Map;

import static hexlet.code.Status.ADDED;
import static hexlet.code.Status.DELETED;
import static hexlet.code.Status.UNCHANGED;

public class Plain {

    public static String makePlain(Map<String, Item> differ) {

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Item> item : differ.entrySet()) {

            Object newValue = checkValue(item.getValue().getNewValue());
            Object oldValue = checkValue(item.getValue().getOldValue());

            if (!item.getValue().getStatus().equals(UNCHANGED)) {
                switch (item.getValue().getStatus()) {
                    case ADDED -> result.append("Property '").append(item.getKey())
                            .append("' was added with value: ").append(oldValue).append("\n");
                    case DELETED -> result.append("Property '").append(item.getKey())
                            .append("' was removed").append("\n");
                    default -> result.append("Property '").append(item.getKey())
                            .append("' was updated. From ").append(oldValue)
                            .append(" to ").append(newValue).append("\n");
                }
            }
        }
        return result.toString().trim();
    }

    public static Object checkValue(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Integer) {
            return value;
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof Boolean) {
            return value;
        } else {
            return "[complex value]";
        }
    }
}
