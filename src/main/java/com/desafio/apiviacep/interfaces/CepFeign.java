package com.desafio.apiviacep.interfaces;

import com.desafio.apiviacep.model.EnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface CepFeign {

    @GetMapping("{cep}/json")
    EnderecoResponse buscarEnderecoCep(@PathVariable("cep") String cep);

}
