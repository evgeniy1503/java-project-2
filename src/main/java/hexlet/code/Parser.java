package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static Map<String, Object> getData(String contains) throws Exception {
        return parse(contains);
    }

    public static Map<String, Object> parse(String date) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> dataMap = objectMapper.readValue(date, new TypeReference<TreeMap<String, Object>>() { });
        return dataMap;

    }
}
