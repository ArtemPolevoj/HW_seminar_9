package com.example.swagger.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class WeatherForecastHolder {
    private static WeatherForecastHolder instance;

    public static WeatherForecastHolder instance() {
        if (instance == null)
            instance = new WeatherForecastHolder();
        return instance;
    }

    // Коллекция для хранения показателей по температуре
    private final Collection<WeatherForecast> values;


    public WeatherForecastHolder() {
        values = new ArrayList<>();
    }

    /// <summary>
    /// Добавить новый показатель по температуре
    /// </summary>
    /// <param name="date"></param>
    /// <param name="temperatureC"></param>
    public boolean add(String date, int temperatureC) {
        values.add(new WeatherForecast(date, temperatureC));
        return true;
    }

    /// <summary>
    /// Обновить показатель по температуре
    /// </summary>
    /// <param name="date"></param>
    /// <param name="temperatureC"></param>
    /// <returns></returns>
    public boolean updateTemperature(String date, int temperatureC) {
        Date date1 = getDate(date);
        for (WeatherForecast w : values) {
            if (w.getDate().equals(date1)) {
                w.setTemperatureC(temperatureC);
                return true;
            }
        }
        return false;
    }

    //public bool Delete()
    public boolean delete(String date) {
        Date temp = getDate(date);
        for (WeatherForecast w : values) {
            if (w.getDate().equals(temp)) {
                values.remove(w);
                return true;
            }
        }
        return false;
    }

    /// <summary>
    /// Получить показатели по температуре за период
    /// </summary>
    /// <param name="from"></param>
    /// <param name="to"></param>
    /// <returns></returns>
    public Collection<WeatherForecast> getTemperatureForPeriod(String from, String to) {
        Collection<WeatherForecast> resultList = new ArrayList<>();
        Date fromDate = getDate(from);
        Date toDate = getDate(to);
        for (WeatherForecast w : values) {
            if ((w.getDate().after(fromDate)) && (w.getDate().before(toDate))) {
                resultList.add(w);
            }
        }
        return resultList;
    }

    public Collection<WeatherForecast> getValues() {
        return values;
    }

    private Date getDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }
}
