package com.Weatherman.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.sql.Date;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Weather {
    double temperature;
    double precipitation;
    Date date;

    public Weather(double temperature, double precipitation, Date date) {
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.date = date;
    }

    public Weather(double temperature, double precipitation) {
        this.temperature = temperature;
        this.precipitation = precipitation;
    }

    @Override
    public String toString() {
        return temperature + " " +  precipitation;
    }
}
