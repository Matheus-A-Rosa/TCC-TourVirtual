package br.com.pinkeritours.security.filter;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import br.com.pinkeritours.exception.StandardError;
import br.com.pinkeritours.security.JwtConfig;
import br.com.pinkeritours.security.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenVerifierFilter extends OncePerRequestFilter {

  private final JwtConfig jwtConfig;
  private final JwtUtils jwtUtils;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    if (jwtConfig.getLoginPath().equals(request.getServletPath())) {
      filterChain.doFilter(request, response);
    }

    String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (Strings.isNullOrEmpty(authorizationHeader) ||
        !authorizationHeader.startsWith(jwtConfig.getTokenPrefix())) {
      filterChain.doFilter(request, response);
    }

    try {
      String token = authorizationHeader.replace(jwtConfig.getTokenPrefix(), "");
      var authenticationToken = jwtUtils.getAuthenticationToken(token);
      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      filterChain.doFilter(request, response);

    } catch (Exception e) {
      log.error("Error loggin in: {}", e.getMessage());
      StandardError error = new StandardError(BAD_REQUEST.value(), e.getMessage());
      response.setContentType(APPLICATION_JSON_VALUE);
      new ObjectMapper().writeValue(response.getOutputStream(), error);

    }

  }

}
