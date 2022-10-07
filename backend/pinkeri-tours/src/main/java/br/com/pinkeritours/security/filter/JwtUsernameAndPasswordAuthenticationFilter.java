package br.com.pinkeritours.security.filter;

import br.com.pinkeritours.dto.LoginRequestDTO;
import br.com.pinkeritours.dto.LoginResponseDTO;
import br.com.pinkeritours.entity.UsuarioEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtUsernameAndPasswordAuthenticationFilter extends
    UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;
  private final Algorithm algorithm;

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException {
    try {
      var authRequest = new ObjectMapper()
          .readValue(request.getInputStream(), LoginRequestDTO.class);
      var authenticationToken = new UsernamePasswordAuthenticationToken(
          authRequest.getUsername(), authRequest.getPassword());

      return authenticationManager.authenticate(authenticationToken);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain, Authentication authResult) throws IOException, ServletException {

    UsuarioEntity usuario = (UsuarioEntity) authResult.getPrincipal();
    List<String> authorities = usuario.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .toList();

    String token = JWT.create()
        .withSubject(usuario.getUsername())
//        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) // 10 min
        .withExpiresAt(Date.valueOf(LocalDate.now().plusDays(1)))
        .withClaim("roles", authorities)
        .sign(algorithm);

    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    var responseDTO = new LoginResponseDTO(token);
    new ObjectMapper().writeValue(response.getOutputStream(), responseDTO);
  }
}
