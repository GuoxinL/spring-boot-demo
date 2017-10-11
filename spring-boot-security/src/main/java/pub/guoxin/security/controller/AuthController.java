package pub.guoxin.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import pub.guoxin.security.JwtAuthenticationRequest;
import pub.guoxin.security.JwtAuthenticationResponse;
import pub.guoxin.security.model.User;
import pub.guoxin.security.service.AuthService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guoxin on 17-8-26.
 */
@RestController
@RequestMapping("/auth/")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createAuthenticationToken(JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @GetMapping(value = "refresh", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) throws AuthenticationException {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if (refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }

    @PostMapping(value = "register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User register(User addedUser) throws AuthenticationException {
        return authService.register(addedUser);
    }

}
