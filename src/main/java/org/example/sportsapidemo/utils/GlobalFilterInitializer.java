package org.example.sportsapidemo.utils;

import lombok.extern.slf4j.Slf4j;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;

@Slf4j
public class GlobalFilterInitializer {

    public static void applyResponseContentType() {
        Filter contentTypeFilter = (Request request, Response response) -> {
            response.type("application/json");
        };
        Spark.after(contentTypeFilter);
    }

    public static void applyLogger() {
        Filter loggerFilter = (Request request, Response response) -> {
            logRequest(request);
        };
        Spark.after(loggerFilter);
    }

    private static void logRequest(Request req) {
        if (req.body().isEmpty()) {
            log.info(String.format("\nRequest method: %s\nRequest URI: %s%s", req.requestMethod(), req.host(), req.uri()));
        } else {
            log.info(String.format("\nRequest method: %s\nRequest URI: %s%s\nBody: \n%s", req.requestMethod(), req.host(), req.uri(), req.body()));
        }
    }
}
