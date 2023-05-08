package men.voll.api.controller;

import jakarta.validation.Valid;
import men.voll.api.domain.user.UserAuthenticationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping
    public ResponseEntity authenticationUser(@RequestBody @Valid UserAuthenticationData userAuthenticationData){
        Authentication token = new UsernamePasswordAuthenticationToken(userAuthenticationData.login(), userAuthenticationData.password());
        authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
