package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;
import java.util.TreeMap;

public class Parser {

    public static final String JSON = "json";
    public static final String YML = "yml";
    public static final String YAML = "yaml";

    public static Map<String, Object> getData(String contains, String extension) throws Exception {
        return parse(contains, extension);
    }

    public static Map<String, Object> parse(String date, String extension) throws Exception {

        ObjectMapper objectMapper;

        if (extension.equals(JSON)) {
            objectMapper = new ObjectMapper();
        } else {
            objectMapper = new ObjectMapper(new YAMLFactory());
        }

        return objectMapper.readValue(date, new TypeReference<TreeMap<String, Object>>() { });

    }
}
