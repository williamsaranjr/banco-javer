package com.williamsaran.bancojaver.feign;

import com.williamsaran.bancojaver.model.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cliente", url = "http://localhost:8000/clientes/")
public interface ClienteFeign {
    @GetMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ClienteDTO encontrarClientePorId(@PathVariable Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ClienteDTO criarConta(@RequestBody ClienteDTO dto);

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ClienteDTO atualizarConta(@RequestBody ClienteDTO dto);

    @DeleteMapping(value = "{id}")
    void deletarPorId(@PathVariable Long id);

    @PatchMapping(value = "desativar/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ClienteDTO desativarConta(@PathVariable Long id);
}
