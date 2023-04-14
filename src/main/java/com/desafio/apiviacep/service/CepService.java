package com.desafio.apiviacep.service;

import com.desafio.apiviacep.interfaces.CepFeign;
import com.desafio.apiviacep.model.EnderecoRequest;
import com.desafio.apiviacep.model.EnderecoResponse;
import com.desafio.apiviacep.model.Frete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.zip.DataFormatException;

@Service
public class CepService {

    @Autowired
    private CepFeign cepFeign;

    public EnderecoResponse executa(EnderecoRequest request) {
        if (request.getCep() != null){
            String cep = request.getCep().trim().replace("-","");
            if (cep.length() == 8 && cep.chars().allMatch(x -> Character.isDigit(x))){
                return cepFeign.buscarEnderecoCep(cep);
            }
        }
        return null;
    }

}
