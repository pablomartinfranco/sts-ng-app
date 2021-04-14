package challenge;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@Component
@SessionScope
public class SessionService {

    public String currentUser() {
        
        String user = "";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof UserDetails) {
            user = ((UserDetails)principal).getUsername();
        } else {
            user = principal. toString();
        }
        
        return user;
    }
}
