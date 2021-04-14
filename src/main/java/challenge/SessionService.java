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

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof UserDetails) {
            this.user = ((UserDetails)principal).getUsername();
        } else {
            this.user = principal. toString();
        }
        
        return user;
    }
}
