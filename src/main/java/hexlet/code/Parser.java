package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;
import java.util.TreeMap;

import static hexlet.code.FileUtils.JSON;
import static hexlet.code.FileUtils.YAML;
import static hexlet.code.FileUtils.YML;

public class Parser {

    public static Map<String, Object> getData(String content, String dataFormat) throws Exception {

        ObjectMapper objectMapper;

        switch (dataFormat) {

            case YAML, YML -> {
                objectMapper = new ObjectMapper(new YAMLFactory());
                objectMapper.readValue(content, new TypeReference<TreeMap<String, Object>>() {
                });
            }
            case JSON -> {
                objectMapper = new ObjectMapper();
                objectMapper.readValue(content, new TypeReference<TreeMap<String, Object>>() {
                });
            }
            default -> throw new Exception("Extension error");

        }

        return objectMapper.readValue(content, new TypeReference<TreeMap<String, Object>>() { });
    }

}
