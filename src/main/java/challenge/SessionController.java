package challenge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
	
	private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }
    
	@GetMapping("/session")
  	public String user() {
		return this.sessionService.currentUser();
	}
}
