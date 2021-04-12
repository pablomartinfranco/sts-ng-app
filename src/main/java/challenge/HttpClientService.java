package challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@Service
public class HttpClientService {
	
	private final HttpClient httpClient;

    public HttpClientService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

  	public JSONObject get(String apiCall) {
		
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(apiCall)).build();
		
		JSONParser jsonParser = new JSONParser(JSONParser.MODE_JSON_SIMPLE);

		HttpResponse<String> response;

		JSONObject jsonResponse;
		
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

			jsonResponse = (JSONObject) jsonParser.parse(response.body());
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return jsonResponse;
	}
	
}
