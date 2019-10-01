package com.codeinvestigator.corsfilter.weatherforecast;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @GetMapping("/weather")
    public String weather(){
        return "Sunny maybe rainy... 21 deg centigrade";
    }
}
