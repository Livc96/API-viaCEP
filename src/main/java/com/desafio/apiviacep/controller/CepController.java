package com.desafio.apiviacep.controller;

import com.desafio.apiviacep.model.CepRequest;
import com.desafio.apiviacep.model.EnderecoResponse;
import com.desafio.apiviacep.service.CepService;
import com.desafio.apiviacep.service.FreteService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("Método para retornar o endereço e o frete de acordo com a sua região. ")
    @PostMapping("/v1/consulta-endereco")
    public ResponseEntity returnCep(@RequestBody CepRequest cepRequest) {
        try {
            EnderecoResponse endereco = cepService.executa(cepRequest);
            if (endereco != null){
                endereco.setFrete(freteService.getFrete(endereco.getUf()));
                return ResponseEntity.ok().body(endereco);
            }  else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cep inválido. Digite novamente.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Cep inválido. Digite novamente.");
        }
    }

}
