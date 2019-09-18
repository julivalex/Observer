package com.company.observer;

import com.company.display.DisplayElement;
import com.company.subject.Subject;
import com.company.subject.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(Subject weatherData) {
        if(weatherData instanceof WeatherData) {
            this.temperature = ((WeatherData) weatherData).getTemperature();
            this.humidity = ((WeatherData) weatherData).getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }
}
