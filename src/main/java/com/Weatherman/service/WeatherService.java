package com.Weatherman.service;

import com.Weatherman.domain.Weather;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WeatherService {

    public static List<Weather> getCurrentWeather(double latitude, double longitude) {
        List<Weather> weatherList = new ArrayList<>();
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + latitude + "," + longitude + "/today?&unitGroup=metric&include=days&key=85S3DU298JNY5V7QR9BRRUQRM";
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);
        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map< String, Object > map = springParser.parseMap(resp);
        List days;
        days = (List) map.get("days");

        for (int i=0; i<1; i++) {
            LinkedHashMap current = (LinkedHashMap) days.toArray()[i];
            weatherList.add(new Weather(Double.parseDouble(String.valueOf(current.get("temp"))), Double.parseDouble(String.valueOf(current.get("precip"))), Date.valueOf(String.valueOf(java.time.LocalDate.now()))));
        }
        return weatherList;
    }

    public static List<Weather> getForecastFromFirstApi(double latitude, double longitude, int amountOfDays) {
        List<Weather> weatherList = new ArrayList<>();
        String url = "https://api.weatherbit.io/v2.0/forecast/daily?&lat=" + latitude + "&lon=" + longitude + "&key=8ddaa1dfca0b4fd09d5cd506a9345d1c";
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);
        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map < String, Object > map = springParser.parseMap(resp);
        List days;
        days = (List) map.get("data");
        for (int i=0; i<amountOfDays + 1; i++) {
            LinkedHashMap current = (LinkedHashMap) days.toArray()[i];
            weatherList.add(new Weather(Double.parseDouble(String.valueOf(current.get("temp"))), Double.parseDouble(String.valueOf(current.get("precip"))), Date.valueOf(String.valueOf(current.get("valid_date")))));
        }
        weatherList.remove(0);
        return weatherList;
    }

    public static List<Weather> getForecastFromSecondApi(double latitude, double longitude, int amountOfDays) {
        List<Weather> weatherList = new ArrayList<>();
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + latitude + "," + longitude + "?&unitGroup=metric&include=days&key=85S3DU298JNY5V7QR9BRRUQRM";
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);
        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map < String, Object > map = springParser.parseMap(resp);
        List days;
        days = (List) map.get("days");
        for (int i=0; i<amountOfDays + 1; i++) {
            LinkedHashMap current = (LinkedHashMap) days.toArray()[i];
            weatherList.add(new Weather(Double.parseDouble(String.valueOf(current.get("temp"))), Double.parseDouble(String.valueOf(current.get("precip"))), Date.valueOf(String.valueOf(current.get("datetime")))));
        }
        weatherList.remove(0);
        return weatherList;
    }
}
