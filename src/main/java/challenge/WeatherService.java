package challenge;

import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;

@Service
public class WeatherService {
	
	private final HttpClientService httpClientService;

    public WeatherService(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }
    
  	public JSONObject weather() {
		
		String apiCall = "http://api.openweathermap.org/data/2.5/weather?q=Buenos%20Aires,ar&appid=f045a059df662d7d23a1dcaac47a3bcf";
		
		return httpClientService.get(apiCall);
	}
	
  	public JSONObject forecast() {
		
		String apiCall = "http://api.openweathermap.org/data/2.5/forecast?q=Buenos%20Aires,ar&cnt=3&appid=f045a059df662d7d23a1dcaac47a3bcf";
		
		return httpClientService.get(apiCall);
	}

}
