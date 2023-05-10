package men.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String generateToken(){
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("voll med")
                    .withSubject("charly.test")
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw  new RuntimeException();
        }
    }

}
