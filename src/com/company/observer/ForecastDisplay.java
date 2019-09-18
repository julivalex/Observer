package com.company.observer;

import com.company.display.DisplayElement;
import com.company.subject.Subject;
import com.company.subject.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(Subject weatherData) {
        if(weatherData instanceof WeatherData) {
            lastPressure = currentPressure;
            currentPressure = ((WeatherData) weatherData).getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Last pressure: " + lastPressure
                + " current pressure " + currentPressure);
    }
}
