package utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Trucks;

import java.io.IOException;
import java.nio.file.Paths;

public class Parser {

    public Trucks parse(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonParser jsonParser;
        Trucks trucks = null;
        try {
            jsonParser = objectMapper.createParser(Paths.get(path).toFile());
            trucks = jsonParser.readValueAs(Trucks.class);
        } catch (IOException e) {
            System.out.println("Parse error: " + e.getMessage());
        }
        return trucks;
    }
}
