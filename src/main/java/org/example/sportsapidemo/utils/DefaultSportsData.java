package org.example.sportsapidemo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.sportsapidemo.model.Sports;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DefaultSportsData {

    public static void injectDefaultData(List<Sports> sports) {
        try {
            String fileContent = Files.readString(Path.of(PropertiesManager.getDefaultSportsFilePath()));
            Sports[] defaultSports = new ObjectMapper().readValue(fileContent, Sports[].class);
            for (Sports sport : defaultSports) {
                sports.add(new Sports(sport.getId(), sport.getName(), sport.isActive()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}