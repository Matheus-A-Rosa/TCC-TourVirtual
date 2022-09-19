package br.com.pinkeritours.security;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import br.com.pinkeritours.security.filter.JwtTokenVerifierFilter;
import br.com.pinkeritours.security.filter.JwtUsernameAndPasswordAuthenticationFilter;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

  private final Algorithm algorithm;
  private final JwtConfig jwtConfig;
  private final JwtUtils jwtUtils;
  private final AuthenticationManager authenticationManager;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    var filter = new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager, algorithm);
    filter.setFilterProcessesUrl(jwtConfig.getLoginPath());

    http
        .csrf().disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilter(filter)
        .addFilterBefore(new JwtTokenVerifierFilter(jwtConfig, jwtUtils),
            UsernamePasswordAuthenticationFilter.class)
        .authorizeHttpRequests()
        .antMatchers(GET, "/v*/imoveis/**").permitAll()
        .antMatchers(POST, "/v*/usuarios/*").permitAll()
        .antMatchers(POST, jwtConfig.getLoginPath() + "/**").permitAll()
        .anyRequest()
        .authenticated();
    return http.build();
  }

}
