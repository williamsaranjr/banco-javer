package com.williamsaran.bancojaver.controller;

import com.google.gson.Gson;
import com.williamsaran.bancojaver.feign.ClienteFeign;
import com.williamsaran.bancojaver.model.ClienteDTO;
import com.williamsaran.bancojaver.utils.ClienteUtils;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class ClienteControllerTest {
    @Autowired
    private MockMvc mock;
    @MockBean
    private ClienteFeign feign;
    @InjectMocks
    private ClienteController controller;
    private final Gson gson = new Gson();

    @Test
    public void testEncontrarClientePorId() throws Exception {
        Mockito.when(feign.encontrarClientePorId(ArgumentMatchers.anyLong()))
                .thenReturn(ClienteUtils.criarDTOMock());

        mock.perform(get("/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ClienteUtils.ID))
                .andExpect(jsonPath("$.nome").value(ClienteUtils.NOME));
    }

    @Test
    public void testCriarConta() throws Exception {
        ClienteDTO cliente = ClienteUtils.criarDTOMock();
        Mockito.when(feign.criarConta(ArgumentMatchers.any()))
                .thenReturn(cliente);

        mock.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(gson.toJson(cliente)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(ClienteUtils.ID))
                .andExpect(jsonPath("$.nome").value(ClienteUtils.NOME));
    }

    @Test
    public void testAtualizarConta() throws Exception {
        Mockito.when(feign.atualizarConta(ArgumentMatchers.any()))
                .thenReturn(ClienteUtils.criarDTOMock());

        mock.perform(patch("/clientes")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(gson.toJson(ClienteUtils.criarDTOMock())))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletarConta() throws Exception {
        Mockito.doNothing().when(feign)
                .deletarPorId(ArgumentMatchers.anyLong());

        mock.perform(delete("/clientes/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDesativarConta() throws Exception {
        ClienteDTO cliente = ClienteUtils.criarDTOMock();
        cliente.setCorrentista(false);

        Mockito.when(feign.desativarConta(ArgumentMatchers.anyLong()))
                .thenReturn(cliente);

        mock.perform(patch("/clientes/desativar/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.correntista").value(false));
    }
}
