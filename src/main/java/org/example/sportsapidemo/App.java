package org.example.sportsapidemo;
import org.example.sportsapidemo.controller.SportsController;
import org.example.sportsapidemo.service.SportsService;
import spark.Spark;


public class App {

    public static void main(String[] args) {
        SportsService sportsService = new SportsService();
        new SportsController(sportsService);
        Spark.awaitInitialization();
    }

}