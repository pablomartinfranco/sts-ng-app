package challenge;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.ParseException;

@RestController
public class WeatherController {
	
	private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
	
	@GetMapping("/information")
  	public Map<String, Object> information() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("title", "Servicio del Clima");
		return model;
	}
	
	@GetMapping("/weather")
  	public JSONObject weather() {
		return weatherService.weather();
	}
	
	@GetMapping("/forecast")
  	public JSONObject forecast() {
		return weatherService.forecast();
	}
	
}
