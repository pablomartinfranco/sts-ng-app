package challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@RestController
public class WeatherController {
	
	private HttpClient httpClient;

    public WeatherController(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
	
	@GetMapping("/resource")
  	public Map<String, Object> resource() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
	
	@GetMapping("/weather")
  	public JSONObject weather() throws IOException, InterruptedException, ParseException {
		
		String apiCall = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=f045a059df662d7d23a1dcaac47a3bcf";
		
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(apiCall)).build();
		
		JSONParser jsonParser = new JSONParser(JSONParser.MODE_JSON_SIMPLE);

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		
		return (JSONObject) jsonParser.parse(response.body());
	}
	
}
