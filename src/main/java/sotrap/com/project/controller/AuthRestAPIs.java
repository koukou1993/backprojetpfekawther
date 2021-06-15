package sotrap.com.project.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import sotrap.com.project.message.request.LoginForm;
import sotrap.com.project.message.request.SignUpForm;
import sotrap.com.project.message.response.JwtResponse;
import sotrap.com.project.message.response.ResponseMessage;
import sotrap.com.project.model.Role;
import sotrap.com.project.model.RoleName;
import sotrap.com.project.model.User;
import sotrap.com.project.repository.RoleRepository;
import sotrap.com.project.repository.UserRepository;
import sotrap.com.project.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    Logger log = Logger.getLogger(AuthRestAPIs.class.getName());

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        try {
            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
                        HttpStatus.BAD_REQUEST);
            }

            if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
                        HttpStatus.BAD_REQUEST);
            }
            log.info("Here");
            // Creating user's account
            User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
                    encoder.encode(signUpRequest.getPassword()));

            Set<String> strRoles = signUpRequest.getRoles();
            Set<Role> roles = new HashSet<>();
            log.info("i should be here");
            if(strRoles == null){
                new RuntimeException("Fail! -> Cause: User Role not find.");
            }
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: admin Role not find."));
                        roles.add(adminRole);

                        break;
                    case "assistant":
                        Role assistantRole = roleRepository.findByName(RoleName.ROLE_ASSISTANT)
                                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: assistant Role not find."));
                        roles.add(assistantRole);

                        break;
                    case "agent":
                        Role agentRole = roleRepository.findByName(RoleName.ROLE_AGENT)
                                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: agent Role not find."));
                        roles.add(agentRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                        roles.add(userRole);
                }
            });
            log.info("nearly done");
            user.setRoles(roles);
            userRepository.save(user);

        }catch (Exception e){
            log.info("Error while creating user: ");
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
    }
}