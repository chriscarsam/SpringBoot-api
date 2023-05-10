package men.voll.api.controller;

import jakarta.validation.Valid;
import men.voll.api.domain.user.UserAuthenticationData;
import men.voll.api.infra.security.TokenService;
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
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticationUser(@RequestBody @Valid UserAuthenticationData userAuthenticationData){
        Authentication authToken = new UsernamePasswordAuthenticationToken(userAuthenticationData.login(), userAuthenticationData.password());
        authenticationManager.authenticate(authToken);
        String JWTtoken = tokenService.generateToken();
        return ResponseEntity.ok(JWTtoken);
    }
}
