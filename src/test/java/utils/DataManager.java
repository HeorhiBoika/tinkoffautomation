package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

@SuppressWarnings("unchecked")
public class DataManager {
    private EnumMap<DataType, Data> dataManager = new EnumMap<>(DataType.class);

    public DataManager() {
        dataManager.put(DataType.SIMPLE, new SimpleData("Simple.json"));
    }

    public Data getData(DataType dataType) {
        return dataManager.get(dataType);
    }

    public <T> T get(DataType dataType, String firstNode) {
        Data data = getData(dataType);
        ObjectMapper objectMapper = new ObjectMapper();
        Data result;
        try {
            JsonNode jsonNode = objectMapper.readTree(new File(data.getPath()));
            result = objectMapper.treeToValue(jsonNode.get(firstNode), data.getClass());
        } catch (IOException e) {
            throw new RuntimeException("Deserialization impossible");
        }
        return (T) result;
    }

    public <T> T get(DataType dataType, String... node) {
        //TODO: will be implemented letter
        Data data = getData(dataType);
        ObjectMapper objectMapper = new ObjectMapper();
        Data result = null;
        try {
            JsonNode jsonNode = objectMapper.readTree(new File(data.getPath()));
//            JsonNode jsonNode1 = Stream.of(node).forEach(node -> jsonNode.);
//            result = objectMapper.treeToValue(jsonNode.get(firstNode), data.getClass());
        } catch (IOException e) {
            throw new RuntimeException("Deserialization impossible");
        }
        return (T) result;
    }
}
