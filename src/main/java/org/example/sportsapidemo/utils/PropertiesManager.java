package org.example.sportsapidemo.utils;

import com.netflix.config.DynamicProperty;

import static java.util.Objects.nonNull;

public class PropertiesManager {

    public static Integer getSparkPort() {
        return Integer.parseInt(getProperty("spark.port"));
    }

    public static String getDefaultSportsFilePath() {
        return getProperty("default.sports.file.path");
    }

    private static String getProperty(String propertyName) {
        return nonNull(System.getProperty(propertyName)) ?
                System.getProperty(propertyName) :
                DynamicProperty.getInstance(propertyName).getString();
    }

}
