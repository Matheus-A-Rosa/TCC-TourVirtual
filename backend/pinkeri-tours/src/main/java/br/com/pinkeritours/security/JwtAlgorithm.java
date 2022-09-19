package br.com.pinkeritours.security;

import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JwtAlgorithm {

  private final JwtConfig jwtConfig;

  @Bean
  public Algorithm algorithm() {
    return Algorithm.HMAC256(jwtConfig.getSecretKey().getBytes());
  }

}
