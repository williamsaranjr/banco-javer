package com.williamsaran.bancojaver.feign;

import com.williamsaran.bancojaver.model.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente", url = "http://localhost:8000/clientes/")
public interface ClienteFeign {
    @GetMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ClienteDTO encontrarClientePorId(@PathVariable Long id);
}
