package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;
import java.util.TreeMap;

import static hexlet.code.ReadFile.YML;
import static hexlet.code.ReadFile.YAML;

public class Parser {



    public static Map<String, Object> getData(String contains, String extension) throws Exception {

        ObjectMapper objectMapper;

        switch (extension) {
            case YAML, YML -> {
                objectMapper = new ObjectMapper(new YAMLFactory());
                objectMapper.readValue(contains, new TypeReference<TreeMap<String, Object>>() {
                });
            }
            default -> {
                objectMapper = new ObjectMapper();
                objectMapper.readValue(contains, new TypeReference<TreeMap<String, Object>>() {
                });
            }
        }
        return objectMapper.readValue(contains, new TypeReference<TreeMap<String, Object>>() { });
    }

}
