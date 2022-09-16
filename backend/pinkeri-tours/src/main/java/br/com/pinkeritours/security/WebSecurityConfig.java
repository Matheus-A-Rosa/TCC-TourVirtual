package br.com.pinkeritours.security;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import br.com.pinkeritours.filter.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig)
      throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
//        .sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and()
//        .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
//        .addFilterAfter(null, null)
        .httpBasic()
        .and()
        .authorizeHttpRequests()
        .antMatchers(GET, "/v*/imoveis").permitAll()
        .antMatchers(POST, "/v*/usuarios/*").permitAll()
        .anyRequest()
        .authenticated();
    return http.build();
  }

}
