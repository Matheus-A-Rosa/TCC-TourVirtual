package br.com.pinkeritours.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Data
public class JwtUtils {

  private final Algorithm algorithm;

  public UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
    JWTVerifier verifier = JWT.require(algorithm).build();
    DecodedJWT decodedJWT = verifier.verify(token);
    String username = decodedJWT.getSubject();
    List<String> roles = decodedJWT.getClaim("roles").asList(String.class);
    List<SimpleGrantedAuthority> authorities = roles.stream()
        .map(SimpleGrantedAuthority::new)
        .toList();

    return new UsernamePasswordAuthenticationToken(username, null, authorities);
  }

}
