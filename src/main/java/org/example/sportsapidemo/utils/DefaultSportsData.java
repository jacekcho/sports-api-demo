package org.example.sportsapidemo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.sportsapidemo.model.Sport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DefaultSportsData {

    public static void injectDefaultData(List<Sport> sports) {
        try {
            String fileContent = Files.readString(Path.of(PropertiesManager.getDefaultSportsFilePath()));
            Sport[] defaultSports = new ObjectMapper().readValue(fileContent, Sport[].class);
            for (Sport sport : defaultSports) {
                sports.add(new Sport(sport.getId(), sport.getName(), sport.isActive()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}