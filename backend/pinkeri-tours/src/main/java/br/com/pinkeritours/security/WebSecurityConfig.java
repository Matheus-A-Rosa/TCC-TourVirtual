package br.com.pinkeritours.security;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
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
