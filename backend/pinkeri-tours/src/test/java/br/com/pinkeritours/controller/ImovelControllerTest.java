package br.com.pinkeritours.controller;

import static br.com.pinkeritours.uttils.ImovelUtils.getImovelRequestDTO;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.pinkeritours.service.ImovelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@WebMvcTest(ImovelController.class)
class ImovelControllerTest {

  private static final String URL = "/imoveis";

  private final ObjectMapper jsonMapper = new ObjectMapper();

  @MockBean
  private ImovelService service;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void quandoSalvar_retornaSucesso() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = post(URL)
        .contentType(APPLICATION_JSON)
        .content(jsonMapper.writeValueAsString(getImovelRequestDTO()));

    mockMvc.perform(requestBuilder)
        .andExpect(status().isCreated());
  }

  @Test
  void quandoListar_retornaSucesso() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = get(URL)
        .contentType(APPLICATION_JSON)
        .param("page", "0")
        .param("size", "1");

    mockMvc.perform(requestBuilder)
        .andExpect(status().isOk());
  }

  @Test
  void quandoBuscarPorId_retornaSucesso() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = get(URL.concat("/{id}"), anyLong())
        .contentType(APPLICATION_JSON);

    mockMvc.perform(requestBuilder)
        .andExpect(status().isOk());
  }
}