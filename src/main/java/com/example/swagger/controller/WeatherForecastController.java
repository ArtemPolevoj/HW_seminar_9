package com.example.swagger.controller;

import com.example.swagger.model.WeatherForecast;
import com.example.swagger.model.WeatherForecastHolder;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@Tag(name = "Показания. (формат даты - \"yyyy-MM-dd\")")
public class WeatherForecastController {
    private final WeatherForecastHolder repository;

    public WeatherForecastController() {
        this.repository = new WeatherForecastHolder();
    }

    @RequestMapping(value = "добавить показания", method = RequestMethod.POST)
    public boolean add(String date, int temperatureC) {

        return repository.add(date, temperatureC);
    }

    @RequestMapping(value = "/обновить показания", method = RequestMethod.PUT)
    public boolean update(String date, int temperatureC) {
        return repository.updateTemperature(date, temperatureC);
    }

    @RequestMapping(value = "/удалить показания", method = RequestMethod.DELETE)
    public boolean delete(String date) {
        return repository.delete(date);
    }

    @RequestMapping(value = "/получить показания", method = RequestMethod.GET)
    public Collection<WeatherForecast> get(String from, String to) {
        return repository.getTemperatureForPeriod(from, to);
    }
}

