package com.desafio.apiviacep.controller;

import com.desafio.apiviacep.model.EnderecoRequest;
import com.desafio.apiviacep.model.EnderecoResponse;
import com.desafio.apiviacep.service.CepService;
import com.desafio.apiviacep.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepController {

    @Autowired
    private CepService cepService;

    @Autowired
    private FreteService freteService;

    @PostMapping("/consulta")
    public ResponseEntity getCep(@RequestBody EnderecoRequest enderecoRequest)
            throws NullPointerException {

        try {
            EnderecoResponse endereco = cepService.executa(enderecoRequest);
            endereco.setFrete(freteService.getFrete(endereco.getUf()));
            if (endereco != null){
            return ResponseEntity.ok().body(endereco);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cep inválido. Digite novamente.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Cep inválido. Digite novamente.");        }


    }

}
