package com.Weatherman.resource;

import com.Weatherman.domain.Weather;
import com.Weatherman.service.WeatherService;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@EnableScheduling
public class WeatherResource {

    private static final long FIXED_DELAY = 3_600_000;

    @GetMapping("/weathercomparison") //Reads in the weather forecast for the next 16 days from the first api and the second api. Also reads in the current weather.
    public List<List<Weather>> getWeather(@RequestParam("latitude") String latitude,
                                          @RequestParam("longitude") String longitude,
                                          @RequestParam("amountOfDays") String amountOfDays) {
        List<List<Weather>> weatherList = new ArrayList<>();
        weatherList.add(WeatherService.getForecastFromFirstApi(Integer.parseInt(latitude), Integer.parseInt(longitude), Integer.parseInt(amountOfDays)));
        weatherList.add(WeatherService.getForecastFromSecondApi(Integer.parseInt(latitude), Integer.parseInt(longitude), Integer.parseInt(amountOfDays)));
        weatherList.add(WeatherService.getCurrentWeather(Integer.parseInt(latitude), Integer.parseInt(longitude)));
        System.out.println(weatherList);
        return weatherList;
    }

    @Scheduled(fixedDelay = FIXED_DELAY)
    public void scheduledGetWeather() {
        getWeather("59", "23", "7");
    }
}