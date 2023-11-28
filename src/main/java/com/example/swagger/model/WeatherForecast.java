package com.example.swagger.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherForecast {
    public WeatherForecast(String date, int temperatureC) {
        setDate(date);
        this.temperatureC = temperatureC;
    }

    public static WeatherForecast of(String date, int temperatureC) {

        return new WeatherForecast(date, temperatureC);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date tempDate = dateFormat.parse(date);
            String checkDate = dateFormat.format(tempDate);
            if (date.equals(checkDate)) {
                this.date = tempDate;
            }
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }

    public int getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(int temperatureC) {
        this.temperatureC = temperatureC;
    }


    private Date date;
    private int temperatureC;

    public int TemperatureF() {
        return 32 + (int) (temperatureC / 0.5556);
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "date=" + getDate() +
                ", temperatureC=" + getTemperatureC() +
                '}';
    }
}
