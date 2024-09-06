package com.williamsaran.bancojaver.controller;

import com.williamsaran.bancojaver.feign.ClienteFeign;
import com.williamsaran.bancojaver.model.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes/")
public class ClienteController {
    @Autowired
    private ClienteFeign clienteFeign;

    @GetMapping(value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO encontrarClientePorId(@PathVariable Long id) {
        var cliente = clienteFeign.encontrarClientePorId(id);

        return cliente;
    }
}
