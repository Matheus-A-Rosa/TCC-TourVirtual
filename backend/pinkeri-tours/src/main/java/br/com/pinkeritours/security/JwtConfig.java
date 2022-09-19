package br.com.pinkeritours.security;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class JwtConfig {

  @Value("${application.jwt.secretKey}")
  private String secretKey;

  @Value("${application.jwt.tokenPrefix}")
  private String tokenPrefix;

  @Value("${application.jwt.tokenExpirationAfterDays}")
  private Integer tokenExpirationAfterDays;

  @Value("${application.jwt.login.path}")
  private String loginPath;

}
