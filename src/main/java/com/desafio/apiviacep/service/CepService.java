package com.desafio.apiviacep.service;

import com.desafio.apiviacep.interfaces.CepFeign;
import com.desafio.apiviacep.model.CepRequest;
import com.desafio.apiviacep.model.EnderecoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    private CepFeign cepFeign;

    public EnderecoResponse executa(CepRequest request) {
        if (request.getCep() != null){
            String cep = request.getCep().trim().replace("-","");
            if (cep.length() == 8 && cep.chars().allMatch(Character::isDigit)){
                return cepFeign.buscarEnderecoCep(cep);
            }
        }
        return null;
    }

}
