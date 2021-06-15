package sotrap.com.project.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {

    @GetMapping("/api/test/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return ">>> User Contents!";
    }

    @GetMapping("/api/test/assitant")
    @PreAuthorize("hasRole('ASSISTANT') or hasRole('ASSISTANT')")
    public String assistantAccess() {
        return ">>> assistant Board";
    }


    @GetMapping("/api/test/agent")
    @PreAuthorize("hasRole('AGENT') or hasRole('AGENT')")
    public String agentAccess() {
        return ">>> Agent Board";
    }

    @GetMapping("/api/test/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Contents";
    }
}