package com.williamsaran.bancojaver.controller;

import com.google.gson.Gson;
import com.williamsaran.bancojaver.feign.ClienteFeign;
import com.williamsaran.bancojaver.model.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes/")
public class ClienteController {
    @Autowired
    private ClienteFeign clienteFeign;

    @GetMapping(value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO encontrarClientePorId(@PathVariable Long id) {
        return clienteFeign.encontrarClientePorId(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO criarConta(@RequestBody ClienteDTO dto) {
        return clienteFeign.criarConta(dto);
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO atualizarConta(@RequestBody ClienteDTO dto) {
        return clienteFeign.atualizarConta(dto);
    }

    @DeleteMapping(value = "{id}")
    public void deletarPorId(@PathVariable Long id) {
        clienteFeign.deletarPorId(id);
    }

    @PutMapping(value = "desativar/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO desativarConta(@PathVariable Long id) {
        return clienteFeign.desativarConta(id);
    }
}
